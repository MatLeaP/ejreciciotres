/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciotres;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Matias
 */
public class Task {
    
    Conexion con = new Conexion();
    
     public void insertarTarea() throws SQLException{
        Connection conexion = con.establecerConeccion();
        
        if( con != null ){
            try{
                //Obtén el id,el nombre de la tarea y la descripcion a travez de JOptionPane
            String idStr = JOptionPane.showInputDialog("Ingrese el id a insertar");
            String nameTask = JOptionPane.showInputDialog("Ingrese nueva tarea");
            String descriptionTask = JOptionPane.showInputDialog("Ingrese la descripcion");
            
            int id = Integer.parseInt(idStr);
            
            //Crear un objeto statement para ejecutar la consulta sql
            Statement statement = conexion.createStatement();
            
            String query = "INSERT INTO tareas (id, nameTask, descriptionTask) VALUES (" + id + ", '" + nameTask + "', '" + descriptionTask + "')";

            
            statement.executeUpdate(query);
            }catch(Exception e){
                e.printStackTrace();
                
            }
           
        }
    }
    
    public void consultarTareas(){
        //Establecemos la conexion
        Connection conexion = con.establecerConeccion();
        
        if( con != null ){
            try{
                //Creamos un objeto de Statement para ejecutar consultas SQL
                Statement statement = conexion.createStatement();
                
                //Ejecutar una consulta Select para obtener datos en la tabla tareas
                ResultSet resultSet = statement.executeQuery("SELECT * FROM tareas");
                
                StringBuilder resultText = new StringBuilder("Tareas:\n");
                
                List<String> results = new ArrayList<>();
                //Recorrer los resultados de la consulta
                while(resultSet.next()){
                    //Obtiene valores de las columnas por nombre y por indice
                    int id = resultSet.getInt("id");                                       
                    String name = resultSet.getString("nameTask");
                    String description = resultSet.getString("descriptionTask");
                    
                    results.add("ID: " + id + "." + "Nombre de la tarea: " + name + "." + "Descripcion de la tarea: " + description);
                                   
                }
                JOptionPane.showMessageDialog(null, String.join("\n", results), "Resultados de la consulta", JOptionPane.INFORMATION_MESSAGE);
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    
    public void actualizarTarea(){
        //Establecer la conexion a la base de datos
        Connection conexion = con.establecerConeccion();
        
        if( con != null ){
            try{
                //creamos el objeto statement para ejecutar consulta sql
                Statement statement = conexion.createStatement();
                
                //Creamos la consulta
                String query = "UPDATE tareas SET nameTask = 'otra tarea', descriptionTask = 'nueva descripción' WHERE id = " + 1;
                
                //Ejecutamos la consulta de actualizacion
                statement.executeUpdate(query);
                
                //imprimimos
                System.out.println("Dato actualizado correctamente");
                
                //Cerramos el statement
                statement.close();
                
                conexion.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }   
    
    }
    
    public void eliminarTarea(){
        Connection conexion = con.establecerConeccion();
        
        if( con != null ){
            try{
                
                Statement statement = conexion.createStatement();
                
                String query = "DELETE FROM tareas WHERE id = " + 1;
                
                statement.executeUpdate(query);
                
                System.out.println("Dato eliminado satisfactoriamente");
                
                statement.close();
                
                conexion.close();
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
}
