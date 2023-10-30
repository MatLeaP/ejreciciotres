/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejerciciotres;

import java.sql.SQLException;


/**
 *
 * @author Matias
 */
public class Main {
    
    

    public static void main(String[] args) throws SQLException {
        Conexion con = new Conexion();
        //con.insertarTarea();
        //con.consultarTareas();
        //con.actualizarTarea();
        con.eliminarTarea();
    }
}
