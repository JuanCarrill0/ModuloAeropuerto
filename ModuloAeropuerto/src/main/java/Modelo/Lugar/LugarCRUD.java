/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Lugar;

import static Modelo.Conexion.getConexionSinConector;
import Modelo.ProgramaVuelo.ProgramaVuelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

   
    
}
