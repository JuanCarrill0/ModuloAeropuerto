/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Juan
 */
public class Conexion {
    public static Connection getConexionConConector(){
        //Conectar
        Connection con=null;
        try{ 
        con= DriverManager.getConnection(Propiedades.URL,Propiedades.USERNAME,Propiedades.PASSWORD); 
        if(con!=null){
            System.out.println("*** Connected to database***");
        }
       }
       catch(SQLException ex){
           ex.printStackTrace();
       }
       return con;
    }
    
    public static Connection getConexionSinConector() throws ClassNotFoundException{
        //Conectar
        String controlador = "org.postgresql.Driver";
        Connection con=null;
        try{ 
        Class.forName(controlador);    
        con= DriverManager.getConnection(Propiedades.URL,Propiedades.USERNAME,Propiedades.PASSWORD); 
        if(con!=null){
            System.out.println("*** Connected to database***");
        }
       }
       catch(SQLException ex){
           ex.printStackTrace();
       }
       return con;
    }
    
}