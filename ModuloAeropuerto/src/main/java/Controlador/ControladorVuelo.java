/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Avion.Avion;
import Modelo.Avion.AvionCRUD;
import Modelo.Dia.Dia;
import Modelo.Dia.DiaCRUD;
import Modelo.LineaAerea.LineaAerea;
import Modelo.LineaAerea.LineaAereaCRUD;
import Modelo.Lugar.Lugar;
import Modelo.Lugar.LugarCRUD;
import Modelo.ModeloAvion.ModeloAvion;
import Modelo.ModeloAvion.ModeloAvionCRUD;
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
import javax.swing.JOptionPane;


/**
 *
 * @author Juan
 */
public class ControladorVuelo implements ActionListener {
    
    private final VentanaVuelo ventanaVuelo = new VentanaVuelo();
    private final AvionCRUD avionCRUD = new AvionCRUD();
    private final ModeloAvion modeloAvion = new ModeloAvion();
    private final ModeloAvionCRUD modeloAvionCRUD = new ModeloAvionCRUD();
    private final Avion avion = new Avion();
    private final Vuelo vuelo = new Vuelo();
    private final VueloCRUD vueloCRUD = new VueloCRUD();
    private final ProgramaVueloCRUD programaCRUD = new ProgramaVueloCRUD();
    private final LugarCRUD lugarCRUD = new LugarCRUD();
    private final LineaAerea linea = new LineaAerea();
    private final LineaAereaCRUD lineaCRUD = new LineaAereaCRUD();
    private final Dia dia = new Dia();
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
    
    public void limpiar(JTable tabla){
            DefaultTableModel tb= (DefaultTableModel)tabla.getModel();
            int a= tabla.getRowCount()-1;
            for(int i=a; i>=0; i--){
                tb.removeRow(tb.getRowCount()-1);
              }
 }
    
    public void listarTabla(JTable tabla){
        limpiar(tabla);
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
                            List<Lugar> listarLugar = lugarCRUD.listarViajesPrograma(listarPrograma.get(i).getIdPrograma());
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
    
    public static String getLastN(String s, int n) {
        if (s == null || n > s.length()) {
            return s;
        }
        return s.substring(s.length() - n);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        /*Si se da al boton de ver programas de vuelo*/
        if(e.getSource() == ventanaVuelo.btnProgramas){
            /*Se declaran los parametros establecidos en el cb*/
            linea.setNomLinea((String)ventanaVuelo.cbAerolinea.getSelectedItem());
            dia.setNomDia((String)ventanaVuelo.cbDia.getSelectedItem());
            /*Ejecuta el metodo para listar la tabla*/
            listarTabla(ventanaVuelo.Tabla);
        }else{
            if(e.getSource() == ventanaVuelo.btnCrearVuelo){
                try {
                    linea.setNomLinea((String)ventanaVuelo.cbAerolinea.getSelectedItem());
                    avion.setIdModelo(getLastN((String)ventanaVuelo.cbAvion.getSelectedItem(),3));
                    modeloAvion.setIdModelo(getLastN((String)ventanaVuelo.cbAvion.getSelectedItem(),3));
                    if(lineaCRUD.buscarLineaAereaID(linea)){
                        avion.setCodLinea(linea.getCodLinea());
                        if(avionCRUD.buscarAvionID(avion)){
                            if(modeloAvionCRUD.buscarPlazasVacias(modeloAvion)){
                                vuelo.setIdVuelo((String)ventanaVuelo.TextNumVuelo.getText());
                                vuelo.setIdPrograma(Integer.parseInt((String)ventanaVuelo.TextIdPrograma.getText()));
                                vuelo.setCodLinea(linea.getCodLinea());
                                vuelo.setPlacaAvion(avion.getPlacaAvion());
                                vuelo.setPlazasVacias(modeloAvion.getCapacidad());
                                if(vueloCRUD.agregarVuelo(vuelo)){
                                    JOptionPane.showMessageDialog(null,"Se guardó el vuelo");
                                }else{
                                    JOptionPane.showMessageDialog(null,"Error en guardar el vuelo, revise los datos");
                                }
                            }
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorVuelo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorVuelo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
