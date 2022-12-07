/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Avion;

import static Modelo.Conexion.getConexionSinConector;
import Modelo.TipoLugar.TipoLugar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class AvionCRUD {
    
        public List listarAvion(){
        List<Avion> datos= new ArrayList<>();
        String sql= "select * from avion";
        try{
            Connection con=getConexionSinConector();
            PreparedStatement ps= con.prepareStatement(sql);
            //Metodo para capturar resultado de una consulta a la BD
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                /* 1. 1-Cedula-Nombre-Apellido-... */
                Avion avion= new Avion();
                avion.setCodLinea(rs.getString(1));
                avion.setPlacaAvion(rs.getString(2));
                avion.setIdModelo(rs.getString(3));

                datos.add(avion);
            }
               
        }catch(Exception e){
             e.printStackTrace();
        }
        return datos;
        
    }
}
