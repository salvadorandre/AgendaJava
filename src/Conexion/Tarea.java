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

public class Tarea extends Conexion{
    
    public Tarea(String URL, String USER, String PASSWORD) {
        super(URL, USER, PASSWORD);
    }
    
     public void insert(String nombre, String fecha, String entrega, String estado, int idContacto) {
        String query = "INSERT INTO tarea (nombre, fecha, entrega, estado, Contacto_idContacto) values(?,?,?,?,?)"; 
        
        try { 
            PreparedStatement insert = this.getConnection().prepareStatement(query); 
            insert.setString(1, nombre);
            insert.setString(2, fecha);
            insert.setString(3, entrega);
            insert.setString(4, estado);
            insert.setInt(5, idContacto);
            
            insert.executeUpdate(); 
            System.out.println("Registro completado");
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
     public void update(String nombre, String fecha, String entrega, String estado, int idContacto, int idUpdate) { 
        String query = "UPDATE tarea SET nombre =?, fecha =?, entrega=?, estado=?, Contacto_idContacto=? WHERE idTarea = ?"; 
        try {
            PreparedStatement update = this.getConnection().prepareStatement(query); 
            update.setString(1, nombre);
            update.setString(2, fecha);
            update.setString(3, entrega);
            update.setString(4, estado);
            update.setInt(5, idContacto);
            update.setInt(6, idUpdate);
            update.executeUpdate(); 
            
            System.out.println("Campo actualizado");
        }catch(Exception e) { 
            e.printStackTrace();
        }
    }
    
    public void read() { 
        String query = "SELECT * FROM tarea"; 
        
        try { 
            Statement stmt = this.getConnection().createStatement(); 
            ResultSet rs = stmt.executeQuery(query); 
            
            System.out.println("------------------Tareas Asignadas--------------------");
            while(rs.next()) { 
                System.out.println("-----"+rs.getInt("idTarea")+ " | " + rs.getString("nombre")+ " | " + rs.getString("fecha")+ " | " + rs.getString("entrega")+ " | " + rs.getString("estado")+ " | " + rs.getInt("Contacto_idContacto")+"-----");
            }
        }catch(Exception e) { 
            e.printStackTrace();
        }
    }
    
    
    public List<String[]> getAllTasks() {
        
        String query = "SELECT * FROM tarea";
        List<String[]> tareas = new ArrayList<>(); 
        
        try { 
            Statement stm = this.getConnection().createStatement(); 
            ResultSet st = stm.executeQuery(query);
            
            while(st.next()) { 
                String[] fila = {
                    String.valueOf(st.getInt("idTarea")), 
                    st.getString("nombre"), 
                    st.getString("fecha"), 
                    st.getString("entrega"), 
                    st.getString("estado"), 
                    String.valueOf(st.getInt("Contacto_idContacto"))
                };
                tareas.add(fila); 
            }
        }catch(SQLException e) { 
        }
        
        return tareas; 
    }
    
    
    public String[] getTareaById(int idTarea) { 
        String query = "SELECT * FROM tarea WHERE idTarea = " + idTarea; 
        
        String[] tarea = null; 
        
        try { 
            Statement st = this.getConnection().createStatement(); 
            ResultSet rs = st.executeQuery(query); 
                    
            if(rs.next()) { 
                tarea = new String[] {
                   String.valueOf(rs.getInt("idTarea")), 
                   rs.getString("nombre"), 
                   rs.getString("fecha"), 
                   rs.getString("entrega"), 
                   rs.getString("estado"),
                   String.valueOf(rs.getInt("Contacto_idContacto"))
                }; 
            }
        }catch(SQLException e) { 
            e.printStackTrace();
        }
        return tarea; 
    }
}
