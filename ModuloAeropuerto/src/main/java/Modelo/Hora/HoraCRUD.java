/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Hora;

import static Modelo.Conexion.getConexionSinConector;
import Modelo.Dia.Dia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class HoraCRUD {
    
        public List listarHora(){
        List<Hora> datos= new ArrayList<>();
        String sql= "select hora from hora";
        try{
            Connection con=getConexionSinConector();
            PreparedStatement ps= con.prepareStatement(sql);
            //Metodo para capturar resultado de una consulta a la BD
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                /* 1. 1-Cedula-Nombre-Apellido-... */
                Hora hora= new Hora();
                hora.setHora(rs.getString(1));
                datos.add(hora);
            }
               
        }catch(Exception e){
             e.printStackTrace();
        }
        return datos; 
    }
    
}
