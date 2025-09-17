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

public class Conexion {

    Connection conn; 
    public Conexion(String URL, String USER, String PASSWORD) { 
        conectionByDB(URL, USER, PASSWORD); 
    }
    
    public void conectionByDB(String URL, String USER, String PASSWORD){
        try { 
            conn = DriverManager.getConnection(URL, USER, PASSWORD); 
            System.out.println("CONEXION ESTABLECIDA");
        }catch(Exception e) { 
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() { 
        return conn; 
    }
    
    public void insert() { 
        
    }
    
    public void update() { 
        
    }
    
    public void read() { 
        
    }
 
}