/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Avion;

import static Modelo.Conexion.getConexionConConector;
import static Modelo.Conexion.getConexionSinConector;
import Modelo.LineaAerea.LineaAerea;
import Modelo.TipoLugar.TipoLugar;
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
public class AvionCRUD {
        
    public boolean buscarAvionID(Avion avion) throws SQLException{
        PreparedStatement ps= null;
        ResultSet rs= null;
        Connection con = getConexionConConector();
        
        String sql= "SELECT placaavion, codlinea, idmodelo" +
                    " FROM avion" +
                    " WHERE codlinea= ? AND idmodelo =?";
        
        try{
             ps= con.prepareStatement(sql);
             ps.setString(1,avion.getCodLinea());
             ps.setString(2,avion.getIdModelo());;
             rs= ps.executeQuery();
             
             if(rs.next()){
                 avion.setPlacaAvion(rs.getString("placaavion"));
                 avion.setCodLinea(rs.getString("codlinea"));
                 avion.setIdModelo(rs.getString("idmodelo"));
                 return true;
             }
             return false;
            
            }catch(SQLException e){
               e.printStackTrace();
               return false; 
            } 
    }
        
}
