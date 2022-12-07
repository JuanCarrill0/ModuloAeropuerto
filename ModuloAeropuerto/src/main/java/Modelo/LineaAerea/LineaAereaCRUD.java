/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.LineaAerea;

import static Modelo.Conexion.getConexionConConector;
import static Modelo.Conexion.getConexionSinConector;
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
public class LineaAereaCRUD {
    
        public boolean agregarLineaAerea(LineaAerea linea) throws ClassNotFoundException{
         //Metodo para definir una consulta
        PreparedStatement ps= null;
        Connection con=getConexionSinConector();
        
        String codLinea = linea.getCodLinea();
        String nomLinea = linea.getNomLinea();

        System.out.println(codLinea+nomLinea);
        
        String sql= "INSERT INTO lineaaerea (codLinea,nomLinea)"
                + "VALUES(?,?)";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, codLinea);
            ps.setString(2, nomLinea);
            ps.execute();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
     }
        
    
        public List listarLinea(){
        List<LineaAerea> datos= new ArrayList<>();
        String sql= "select * from lineaaerea";
        try{
            Connection con=getConexionSinConector();
            PreparedStatement ps= con.prepareStatement(sql);
            //Metodo para capturar resultado de una consulta a la BD
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                /* 1. 1-Cedula-Nombre-Apellido-... */
                LineaAerea linea= new LineaAerea();
                linea.setCodLinea(rs.getString(1));
                linea.setNomLinea(rs.getString(2));

                datos.add(linea);
            }
               
        }catch(Exception e){
             e.printStackTrace();
        }
        return datos;
        
    }
        
    public boolean buscarLineaAereaID(LineaAerea linea) throws SQLException{
        
        PreparedStatement ps= null;
        ResultSet rs= null;
        Connection con = getConexionConConector();
        
        String sql= "SELECT codlinea FROM lineaaerea WHERE nomlinea=?";
        
        
        try{
             ps= con.prepareStatement(sql);
             ps.setString(1,linea.getNomLinea());
             rs= ps.executeQuery();
             
             if(rs.next()){
                 linea.setCodLinea(rs.getString("codlinea"));
                 return true;
             }
             return false;
            
            }catch(SQLException e){
               e.printStackTrace();
               return false; 
            } 
    }
        
        
}
