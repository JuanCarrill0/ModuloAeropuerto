/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.ProgramaVuelo;

import static Modelo.Conexion.getConexionSinConector;
import Modelo.Vuelo.Vuelo;
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
public class ProgramaVueloCRUD {
    
        public boolean agregarVuelo(ProgramaVuelo programa) throws ClassNotFoundException{
         //Metodo para definir una consulta
        PreparedStatement ps= null;
        Connection con=getConexionSinConector();
        
        String codLinea = programa.getCodLinea();
        int idPrograma = programa.getIdPrograma();
        String idLugar = programa.getIdLugar();
        String fechaCreacion = programa.getFechaCreacion();

        System.out.println(codLinea+idPrograma+idLugar+fechaCreacion);
        String sql= "INSERT INTO programa_vuelo (codLinea,idPrograma,idLugar,fechaCreacion)"
                + "VALUES(?,?,?,?)";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, codLinea);
            ps.setInt(2, idPrograma);
            ps.setString(3, idLugar);
            ps.setString(4, fechaCreacion);
            ps.execute();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
     }
        
        public List listarProgramas(){
        List<ProgramaVuelo> datos= new ArrayList<>();
        String sql= "select * from programa_vuelo";
        try{
            Connection con=getConexionSinConector();
            PreparedStatement ps= con.prepareStatement(sql);
            //Metodo para capturar resultado de una consulta a la BD
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                /* 1. 1-Cedula-Nombre-Apellido-... */
                ProgramaVuelo programa= new ProgramaVuelo();
                programa.setCodLinea(rs.getString(1));
                programa.setIdPrograma(rs.getInt(2));
                programa.setIdLugar(rs.getString(3));
                programa.setFechaCreacion(rs.getString(4));

                datos.add(programa);
            }
               
        }catch(Exception e){
             e.printStackTrace();
        }
        return datos;
        
    }
}
