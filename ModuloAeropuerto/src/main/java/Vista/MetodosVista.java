/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import static Modelo.Conexion.getConexionSinConector;
import Modelo.Dia.Dia;
import Modelo.Dia.DiaCRUD;
import Modelo.Hora.Hora;
import Modelo.Hora.HoraCRUD;
import Modelo.LineaAerea.LineaAerea;
import Modelo.LineaAerea.LineaAereaCRUD;
import Modelo.Lugar.Lugar;
import Modelo.Lugar.LugarCRUD;
import Modelo.ModeloAvion.ModeloAvion;
import Modelo.ModeloAvion.ModeloAvionCRUD;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author Juan
 */
public class MetodosVista {
    
    List Listar;
    
    public void llenarLugarCB(JComboBox CB, int Lugar){
        try{
            Connection con=getConexionSinConector();
            LugarCRUD lugar = new LugarCRUD();
            Listar = lugar.listarLugarEspecifico(Lugar);
            Iterator iterador = Listar.iterator(); 
            while (iterador.hasNext()) {
                Lugar lugarAeropuerto = (Lugar) iterador.next();
                CB.addItem(lugarAeropuerto.getNomLugar());
            }
 
        }catch(Exception e){
            e.printStackTrace();
        }  
    }
    
     public void llenarLineaCB(JComboBox CB){
        try{
            Connection con=getConexionSinConector();
            LineaAereaCRUD lineaAerea = new LineaAereaCRUD();
            CB.removeAllItems();
            Listar = lineaAerea.listarLinea();
            Iterator iterador = Listar.iterator(); 
            while (iterador.hasNext()) {
                LineaAerea linea = (LineaAerea) iterador.next();
                CB.addItem(linea.getNomLinea());
            }
 
        }catch(Exception e){
            e.printStackTrace();
        }  
    }
     
     public void llenarDiaCB(JComboBox CB){
        try{
            Connection con=getConexionSinConector();
            DiaCRUD dia = new DiaCRUD();
            CB.removeAllItems();
            Listar = dia.listarDia();
            Iterator iterador = Listar.iterator(); 
            while (iterador.hasNext()) {
                Dia dia_ = (Dia) iterador.next();
                CB.addItem(dia_.getNomDia());
            }
 
        }catch(Exception e){
            e.printStackTrace();
        }  
    }
     
    public void llenarHoraCB(JComboBox CB){
        try{
            Connection con=getConexionSinConector();
            HoraCRUD hora = new HoraCRUD();
            CB.removeAllItems();
            Listar = hora.listarHora();
            Iterator iterador = Listar.iterator(); 
            while (iterador.hasNext()) {
                Hora hora_ = (Hora) iterador.next();
                CB.addItem(hora_.getHora());
            }
        }catch(Exception e){
            e.printStackTrace();
        }  
    }
    
     public void llenarAvionCB(JComboBox CB, JComboBox CBLinea){
        try{
            /*Declarar el modelo de linea aerea con su CRUD*/
            LineaAerea linea = new LineaAerea();
            LineaAereaCRUD lineaCRUD = new LineaAereaCRUD();
            /*Saber el nombre de la linea aerea para buscar su id*/
            linea.setNomLinea((String) CBLinea.getSelectedItem());
            if(lineaCRUD.buscarLineaAereaID(linea)){
                /*Si la encuentra llenar el combo box*/
                Connection con=getConexionSinConector();
                ModeloAvionCRUD modelo = new ModeloAvionCRUD();
                CB.removeAllItems();
                /*Llama al metodo listar ModeloLinea Aerea que ejecuta el sql*/
                Listar = modelo.listarModeloAerolinea(linea.getCodLinea());
                Iterator iterador = Listar.iterator(); 
                while (iterador.hasNext()) {
                    ModeloAvion modelo_ = (ModeloAvion) iterador.next();
                    CB.addItem(modelo_.getNombreModelo());
                }
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }  
    }
    
    
    
}
