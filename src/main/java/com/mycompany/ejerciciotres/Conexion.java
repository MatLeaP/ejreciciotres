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
    
    //Statement st = null;
    
    //ResultSet rs = null;
    
    public Connection establecerConeccion(){
        
        try{
            
            conectar = DriverManager.getConnection(cadena, usuario, contrasena);
            JOptionPane.showMessageDialog(null, "Se conectó correctamente");
 
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Se producido un error" + e.toString());
        }
        return conectar;
        
        
    }
    
    public void insertarTarea() throws SQLException{
        Connection con = establecerConeccion();
        
        if( con != null ){
            try{
                //Obtén el id y el nombre de la carrera a travez de JOptionPane
            String idStr = JOptionPane.showInputDialog("Ingrese el id a insertar");
            String nameTask = JOptionPane.showInputDialog("Ingrese nueva tarea");
            String descriptionTask = JOptionPane.showInputDialog("Ingrese la descripcion");
            
            int id = Integer.parseInt(idStr);
            
            //Crear un objeto statement para ejecutar la consulta sql
            Statement statement = con.createStatement();
            
            String query = "INSERT INTO tareas (id, nameTask, descriptionTask) VALUES (" + id + ", '" + nameTask + "', '" + descriptionTask + "')";

            
            statement.executeUpdate(query);
            }catch(Exception e){
                e.printStackTrace();
                
            }
           
        }
    }
    
    public void consultarTareas(){
        //Establecemos la conexion
        Connection con = establecerConeccion();
        
        if( con != null ){
            try{
                //Creamos un objeto de Statement para ejecutar consultas SQL
                Statement statement = con.createStatement();
                
                //Ejecutar una consulta Select para obtener datos en la tabla "carreras
                ResultSet resultSet = statement.executeQuery("SELECT * FROM tareas");
                
                //Recorrer los resultados de la consulta
                while(resultSet.next()){
                    //Obtiene valores de las columnas por nombre y por indice
                    int id = resultSet.getInt("id");
                    String nameTask = resultSet.getString("nameTask");
                    String descriptionTask = resultSet.getString("descriptionTask");
                    
                    //Imprimos los valores de cada fila
                    System.out.println("ID: " +id + ", Nombre de la tarea: " + nameTask + "Descripcion de la tarea: " + descriptionTask);
                    
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    
    public void actualizarTarea(){
        //Establecer la conexion a la base de datos
        Connection con = establecerConeccion();
        
        if( con != null ){
            try{
                //creamos el objeto statement para ejecutar consulta sql
                Statement statement = con.createStatement();
                
                //Creamos la consulta
                String query = "UPDATE tareas SET nameTask = 'otra tarea', descriptionTask = 'nueva descripción' WHERE id = " + 1;
                
                //Ejecutamos la consulta de actualizacion
                statement.executeUpdate(query);
                
                //imprimimos
                System.out.println("Dato actualizado correctamente");
                
                //Cerramos el statement
                statement.close();
                
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }   
    
    }
    
    public void eliminarTarea(){
        Connection con = establecerConeccion();
        
        if( con != null ){
            try{
                
                Statement statement = con.createStatement();
                
                String query = "DELETE FROM tareas WHERE id = " + 1;
                
                statement.executeUpdate(query);
                
                System.out.println("Dato eliminado satisfactoriamente");
                
                statement.close();
                
                con.close();
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
