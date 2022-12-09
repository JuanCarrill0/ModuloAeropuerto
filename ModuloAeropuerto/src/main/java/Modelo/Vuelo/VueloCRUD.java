/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Vuelo;

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
public class VueloCRUD {
    
    public boolean agregarVuelo(Vuelo vuelo) throws ClassNotFoundException{
         //Metodo para definir una consulta
        PreparedStatement ps= null;
        Connection con=getConexionSinConector();
        
        String idVuelo = vuelo.getIdVuelo();
        String idPrograma = vuelo.getIdPrograma();
        String codLinea = vuelo .getCodLinea();
        String placaAvion = vuelo.getPlacaAvion();
        String Fecha = vuelo.getFecha();
        int plazasVacias = vuelo .getPlazasVacias();

        System.out.println(idVuelo+idPrograma+codLinea+placaAvion+Fecha+plazasVacias);
        String sql= "INSERT INTO vuelo (idVuelo,idPrograma,codLinea,placaAvion,Fecha,plazasVacias)"
                + "VALUES(?,?,?,?,?,?)";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, idVuelo);
            ps.setString(2, idPrograma);
            ps.setString(3, codLinea);
            ps.setString(4, placaAvion);
            ps.setString(5, Fecha);
            ps.setInt(6, plazasVacias);
            ps.execute();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
     }
    
     public List listarVuelos(){
        List<Vuelo> datos= new ArrayList<>();
        String sql= "select * from vuelo";
        try{
            Connection con=getConexionSinConector();
            PreparedStatement ps= con.prepareStatement(sql);
            //Metodo para capturar resultado de una consulta a la BD
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                /* 1. 1-Cedula-Nombre-Apellido-... */
                Vuelo vuelo= new Vuelo();
                vuelo.setIdVuelo(rs.getString(1));
                vuelo.setIdPrograma(rs.getString(2));
                vuelo.setCodLinea(rs.getString(3));
                vuelo.setPlacaAvion(rs.getString(4));
                vuelo.setFecha(rs.getString(5));
                vuelo.setPlazasVacias(rs.getInt(6));
                datos.add(vuelo);
            }
               
        }catch(Exception e){
             e.printStackTrace();
        }
        return datos;
        
    }
    
    
    
}
