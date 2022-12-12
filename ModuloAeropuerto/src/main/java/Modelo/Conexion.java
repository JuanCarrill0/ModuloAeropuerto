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
    
    private static Connection conConector;
    private static Connection conNoConector;
    

    public static Connection getConexionConConector(){
        
        if(conConector!= null){
            return Conexion.conConector;
        }else{
            try{ 
            conConector= DriverManager.getConnection(Propiedades.URL,Propiedades.USERNAME,Propiedades.PASSWORD); 
           }
           catch(SQLException ex){
               ex.printStackTrace();
           }
           return conConector;   
        }   
    }
    
    public static Connection getConexionSinConector() throws ClassNotFoundException{
        //Conectar
        String controlador = "org.postgresql.Driver";
        if(conNoConector != null){
            return Conexion.conNoConector;
        }else{
            try{ 
            Class.forName(controlador);    
            Conexion.conNoConector= DriverManager.getConnection(Propiedades.URL,Propiedades.USERNAME,Propiedades.PASSWORD); 
           }
           catch(SQLException ex){
               ex.printStackTrace();
           }
           return Conexion.conNoConector;
            
        }
    }
    
}