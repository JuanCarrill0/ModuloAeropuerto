/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.TipoLugar;

import static Modelo.Conexion.getConexionSinConector;
import Modelo.Lugar.Lugar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class TipoLugarCRUD {
    
        public List listarTipoLugar(){
        List<TipoLugar> datos= new ArrayList<>();
        String sql= "select * from tipo_lugar";
        try{
            Connection con=getConexionSinConector();
            PreparedStatement ps= con.prepareStatement(sql);
            //Metodo para capturar resultado de una consulta a la BD
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                /* 1. 1-Cedula-Nombre-Apellido-... */
                TipoLugar tipoLugar= new TipoLugar();
                tipoLugar.setIdTipoLugar(rs.getString(1));
                tipoLugar.setDescTipoLugar(rs.getString(2));

                datos.add(tipoLugar);
            }
               
        }catch(Exception e){
             e.printStackTrace();
        }
        return datos;
        
    }
    
}
