/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciotres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Matias
 */
public class Conexion {
    Connection conectar = null;
    
    String usuario = "root";
    
    String contrasena = "root";
    
    String db = "task";
    
    String ip = "localhost";
    
    String puerto = "3306";
    
    String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + db;
    
  
    
    public Connection establecerConeccion(){
        
        try{
            
            conectar = DriverManager.getConnection(cadena, usuario, contrasena);
            JOptionPane.showMessageDialog(null, "Se conectó correctamente");
 
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Se producido un error" + e.toString());
        }
        return conectar;
        
        
    }
}
