/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.ModeloAvion;

import static Modelo.Conexion.getConexionConConector;
import static Modelo.Conexion.getConexionSinConector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class ModeloAvionCRUD {
    
        
    public List listarModeloAerolinea(String codLinea){
        List<ModeloAvion> datos= new ArrayList<>();
        String sql= "SELECT M.nombremodelo ||' '|| M.idmodelo Avion\n" +
                    "FROM avion A, modelo_avion M\n" +
                    "WHERE A.codlinea = '"+codLinea+"' AND  A.idmodelo = M.idmodelo";
        try{
            Connection con=getConexionSinConector();
            PreparedStatement ps= con.prepareStatement(sql);
            //Metodo para capturar resultado de una consulta a la BD
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                /* 1. 1-Cedula-Nombre-Apellido-... */
                ModeloAvion modelo= new ModeloAvion();
                modelo.setNombreModelo(rs.getString(1));
                datos.add(modelo);
            }
               
        }catch(Exception e){
             e.printStackTrace();
        }
        return datos;
        
    }
    
        public boolean buscarPlazasVacias(ModeloAvion modelo) throws SQLException{
        
        PreparedStatement ps= null;
        ResultSet rs= null;
        Connection con = getConexionConConector();
        
        String sql= "SELECT capacidad\n" +
                    "FROM modelo_avion\n" +
                    "WHERE idmodelo = ?";
        try{
             ps= con.prepareStatement(sql);
             ps.setString(1,modelo.getIdModelo());
             rs= ps.executeQuery();
             
             if(rs.next()){
                 modelo.setCapacidad(rs.getInt("capacidad"));
                 return true;
             }
             return false;
            
            }catch(SQLException e){
               e.printStackTrace();
               return false; 
            } 
    }
        
     
        
     
    
}
