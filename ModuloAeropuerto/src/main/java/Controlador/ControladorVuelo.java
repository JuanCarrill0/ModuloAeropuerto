/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Dia.Dia;
import Modelo.Dia.DiaCRUD;
import Modelo.LineaAerea.LineaAerea;
import Modelo.LineaAerea.LineaAereaCRUD;
import Modelo.Lugar.Lugar;
import Modelo.Lugar.LugarCRUD;
import Modelo.ProgramaVuelo.ProgramaVuelo;
import Modelo.ProgramaVuelo.ProgramaVueloCRUD;
import Modelo.Vuelo.Vuelo;
import Modelo.Vuelo.VueloCRUD;
import Vista.VentanaVuelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;


/**
 *
 * @author Juan
 */
public class ControladorVuelo implements ActionListener {
    
    private final VentanaVuelo ventanaVuelo = new VentanaVuelo();
    private ProgramaVuelo programa = new ProgramaVuelo();
    private Vuelo vuelo = new Vuelo();
    private VueloCRUD vueloCRUD = new VueloCRUD();
    private ProgramaVueloCRUD programaCRUD = new ProgramaVueloCRUD();
    private Lugar lugar = new Lugar();
    private LugarCRUD lugarCRUD = new LugarCRUD();
    private LineaAerea linea = new LineaAerea();
    private LineaAereaCRUD lineaCRUD = new LineaAereaCRUD();
    private Dia dia = new Dia();
    private DiaCRUD diaCRUD = new DiaCRUD();
    DefaultTableModel modelo= new DefaultTableModel(); 
    
    public ControladorVuelo(){
        this.ventanaVuelo.cbDia.addActionListener(this);
        this.ventanaVuelo.cbAerolinea.addActionListener(this);
        this.ventanaVuelo.btnCrearVuelo.addActionListener(this);  
        this.ventanaVuelo.btnProgramas.addActionListener(this);
    }
    
    public VentanaVuelo getVentanaVuelo(){
        return ventanaVuelo;
    }
    
    public void listarTabla(JTable tabla){
        modelo = (DefaultTableModel)tabla.getModel();
        Object[] objeto= new Object[5];
        /*Se busca el id de la linea y se pasa como parametro junto al dia para listas
           los programas de vuelos especificos para ese dia y aerolinea*/
        try {
                if(lineaCRUD.buscarLineaAereaID(linea)){
                     List<ProgramaVuelo> listarPrograma = programaCRUD.listarProgramasAerolineaDia(linea, dia);
                     /*Cuando la tabla está vacia enlista*/
                     if (modelo.getRowCount()== 0) {
                            for(int i=0; i<listarPrograma.size();i++){
                            /*Enlista los lugares relacionados con el id del lugar de la lista de programas*/
                            List<Lugar> listarLugar = lugarCRUD.listarLugarViajesID(listarPrograma.get(i).getIdLugar());
                            /*Se adjuntan los datos en la tabla respectivamente*/
                            objeto[0]= listarPrograma.get(i).getIdPrograma();
                            objeto[1]= listarPrograma.get(i).getFechaCreacion();
                            objeto[2]= listarLugar.get(i).getNomLugar();
                            objeto[3]= listarLugar.get(i).getNomDestino();
                            modelo.addRow(objeto);
                        }
                        ventanaVuelo.Tabla.setModel(modelo);    
                    }
                     
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrograma.class.getName()).log(Level.SEVERE, null, ex);
            }
  }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ventanaVuelo.btnProgramas){
            /*Se declaran los parametros establecidos en el cb*/
            linea.setNomLinea((String)ventanaVuelo.cbAerolinea.getSelectedItem());
            dia.setNomDia((String)ventanaVuelo.cbDia.getSelectedItem());
            listarTabla(ventanaVuelo.Tabla);
        }else{
            if(e.getSource() == ventanaVuelo.btnCrearVuelo){
                try {
                    if(lineaCRUD.buscarLineaAereaID(linea)){
                        vuelo.setCodLinea(linea.getCodLinea());
                        vuelo.setFecha((String)ventanaVuelo.cbDia.getSelectedItem());
                        vuelo.setIdPrograma((String)ventanaVuelo.TextIdPrograma.getText());
                        vuelo.setIdVuelo((String)ventanaVuelo.TextNumVuelo.getText());
                  
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorVuelo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
