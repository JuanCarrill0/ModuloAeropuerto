/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.ModeloAvion;

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
public class ModeloAvionCRUD {
    
    
        public List listarModeloAvion(){
        List<ModeloAvion> datos= new ArrayList<>();
        String sql= "select * from modelo_avion";
        try{
            Connection con=getConexionSinConector();
            PreparedStatement ps= con.prepareStatement(sql);
            //Metodo para capturar resultado de una consulta a la BD
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                /* 1. 1-Cedula-Nombre-Apellido-... */
                ModeloAvion modelo= new ModeloAvion();
                modelo.setIdModelo(rs.getString(1));
                modelo.setCapacidad(rs.getInt(2));
                modelo.setNombreModelo(rs.getString(3));

                datos.add(modelo);
            }
               
        }catch(Exception e){
             e.printStackTrace();
        }
        return datos;
        
    }
    
}
