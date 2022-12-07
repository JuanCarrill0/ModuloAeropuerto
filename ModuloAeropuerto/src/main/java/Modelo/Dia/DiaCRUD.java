/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dia;

import Modelo.Avion.Avion;
import static Modelo.Conexion.getConexionSinConector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class DiaCRUD {
    
    public List listarDia(){
        List<Dia> datos= new ArrayList<>();
        String sql= "select nomdia from dia";
        try{
            Connection con=getConexionSinConector();
            PreparedStatement ps= con.prepareStatement(sql);
            //Metodo para capturar resultado de una consulta a la BD
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                /* 1. 1-Cedula-Nombre-Apellido-... */
                Dia dia= new Dia();
                dia.setNomDia(rs.getString(1));
                datos.add(dia);
            }
               
        }catch(Exception e){
             e.printStackTrace();
        }
        return datos; 
    }
    
}
