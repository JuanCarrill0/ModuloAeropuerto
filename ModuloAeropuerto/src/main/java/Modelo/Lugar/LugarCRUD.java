/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Lugar;

import static Modelo.Conexion.getConexionConConector;
import static Modelo.Conexion.getConexionSinConector;
import Modelo.LineaAerea.LineaAerea;
import Modelo.ProgramaVuelo.ProgramaVuelo;
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
public class LugarCRUD {
    
     public List listarLugar(){
        List<Lugar> datos= new ArrayList<>();
        String sql= "select * from lugar";
        try{
            Connection con=getConexionSinConector();
            PreparedStatement ps= con.prepareStatement(sql);
            //Metodo para capturar resultado de una consulta a la BD
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                /* 1. 1-Cedula-Nombre-Apellido-... */
                Lugar lugar= new Lugar();
                lugar.setIdLugar(rs.getString(1));
                lugar.setIdTipoLugar(rs.getString(2));
                lugar.setNomLugar(rs.getString(3));

                datos.add(lugar);
            }
               
        }catch(Exception e){
             e.printStackTrace();
        }
        return datos;
        
    }
    
    public List listarViajesPrograma(int idPrograma_){
        List<Lugar> datos= new ArrayList<>();
        int idPrograma = idPrograma_;
        String sql= "SELECT C.nomlugar Despegue, D.nomlugar Destino " +
                    "FROM lugar C, lugar D , programa_vuelo P " +
                    "WHERE C.idlugar = P.idlugar AND D.idlugar = P.iddestino AND P.idprograma = '"+idPrograma+"';";
        try{
            Connection con=getConexionSinConector();
            PreparedStatement ps= con.prepareStatement(sql);
            //Metodo para capturar resultado de una consulta a la BD
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Lugar lugar= new Lugar();
                lugar.setNomLugar(rs.getString(1));
                lugar.setNomDestino(rs.getString(2));
                datos.add(lugar);
            }
               
        }catch(Exception e){
             e.printStackTrace();
        }
        return datos;
        
    }
    
     public List listarLugarEspecifico(int idTipoLugar){
        List<Lugar> datos= new ArrayList<>();
        String sql= "select nomlugar from lugar where idtipolugar = '"+idTipoLugar+"'";
        try{
            Connection con=getConexionSinConector();
            PreparedStatement ps= con.prepareStatement(sql);
            //Metodo para capturar resultado de una consulta a la BD
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                /* 1. 1-Cedula-Nombre-Apellido-... */
                Lugar lugar= new Lugar();
                lugar.setNomLugar(rs.getString(1));
                datos.add(lugar);
            }
               
        }catch(Exception e){
             e.printStackTrace();
        }
        return datos;
        
    }
    
    public boolean buscarLugarID(Lugar lugar) throws SQLException{
        
        PreparedStatement ps= null;
        ResultSet rs= null;
        Connection con = getConexionConConector();
        
        String sql= "SELECT idlugar FROM lugar WHERE nomlugar= ?";
        
        
        try{
             ps= con.prepareStatement(sql);
             ps.setString(1,lugar.getNomLugar());
             rs= ps.executeQuery();
             
             if(rs.next()){
                 lugar.setIdLugar(rs.getString("idlugar"));
                 System.out.println(rs.getString("idlugar"));
                 return true;
             }
             return false;
            
            }catch(SQLException e){
               e.printStackTrace();
               return false; 
            } 
    }   
}
