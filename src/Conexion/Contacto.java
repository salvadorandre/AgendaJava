/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

/**
 *
 * @author Andre
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Contacto extends Conexion{
    
    public Contacto(String URL, String USER, String PASSWORD) {
        super(URL, USER, PASSWORD);
    }
    
    public void insert(String nombre, String apellido, String telefono) {
        String query = "INSERT INTO contacto (nombre, apellido, telefono) values(?,?,?)"; 
        
        try { 
            PreparedStatement insert = this.getConnection().prepareStatement(query); 
            insert.setString(1, nombre);
            insert.setString(2, apellido);
            insert.setString(3, telefono);
            
            insert.executeUpdate(); 
            System.out.println("Registro completado");
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(String nombre, String apellido, String telefono, int idUpdate) { 
        String query = "UPDATE contacto SET nombre =?, apellido =?, telefono=? WHERE idContacto = ?"; 
        try {
            PreparedStatement update = this.getConnection().prepareStatement(query); 
            update.setString(1, nombre);
            update.setString(2, apellido);
            update.setString(3, telefono);
            update.setInt(4, idUpdate);
            update.executeUpdate(); 
            
            System.out.println("Campo actualizado");
        }catch(Exception e) { 
            e.printStackTrace();
        }
    }

    
    public List<String[]> getAllContacts() {
        List<String[]> contactos = new ArrayList<>(); 
        String query = "SELECT * FROM contacto";

        try { 
            Statement stmt = this.getConnection().createStatement(); 
            ResultSet rs = stmt.executeQuery(query); 

            while(rs.next()) { 
                String[] fila = {
                    String.valueOf(rs.getInt("idContacto")),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("telefono")
                };
                contactos.add(fila);
            }
        } catch(Exception e) { 
            e.printStackTrace();
        }
        return contactos; 
    }
    
    public String[] getContact(int id) {
        String[] contacto = null; 
        String query = "SELECT * FROM contacto WHERE idContacto = " + id; 
        ResultSet rs = null; 
        try { 
            Statement stmt = this.getConnection().createStatement();
            rs = stmt.executeQuery(query);
            
            if(rs.next()) { 
                contacto = new String[] {
                  String.valueOf(rs.getInt("idContacto")), 
                  rs.getString("nombre"), 
                  rs.getString("apellido"), 
                  rs.getString("telefono")
                };
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return contacto; 
    }
    
    
}
