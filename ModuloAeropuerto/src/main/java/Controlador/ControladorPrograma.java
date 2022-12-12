/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.LineaAerea.LineaAerea;
import Modelo.LineaAerea.LineaAereaCRUD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Lugar.Lugar;
import Modelo.Lugar.LugarCRUD;
import Modelo.ProgramaVuelo.ProgramaVuelo;
import Modelo.ProgramaVuelo.ProgramaVueloCRUD;
import Vista.VentanaPrograma;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Juan
 */
public class ControladorPrograma implements ActionListener{
    private final VentanaPrograma ventanaPrograma = new VentanaPrograma();
    /* Declaraciones tablas usadas en la ventana de programa de vuelo*/
    private Lugar lugar = new Lugar();
    private Lugar lugarDestino = new Lugar();
    private LugarCRUD lugarCRUD = new LugarCRUD();
    private LineaAerea linea = new LineaAerea();
    private LineaAereaCRUD lineaCRUD = new LineaAereaCRUD();
    
    
    /* Declaración de la tabla a guardar de Programa de Vuelo*/
    
    private ProgramaVuelo programa = new ProgramaVuelo();
    private ProgramaVueloCRUD programaCRUD = new ProgramaVueloCRUD();
    
    public ControladorPrograma(){
        
        this.ventanaPrograma.btnCrearPrograma.addActionListener(this);     
        
    }
    
    public VentanaPrograma getVentanaPrograma(){
        return ventanaPrograma;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ventanaPrograma.btnCrearPrograma){
            linea.setNomLinea((String)ventanaPrograma.cbLineaAerea.getSelectedItem());
            lugar.setNomLugar((String)ventanaPrograma.cbAeropuerto.getSelectedItem());
            lugarDestino.setNomLugar((String)ventanaPrograma.cbAeropuertoD.getSelectedItem());
            try {
                if(lineaCRUD.buscarLineaAereaID(linea) && lugarCRUD.buscarLugarID(lugar) && lugarCRUD.buscarLugarID(lugarDestino)){
                    programa.setCodLinea(linea.getCodLinea());
                    programa.setIdLugar(lugar.getIdLugar());
                    programa.setIdDestino(lugarDestino.getIdLugar());
                    programa.setIdPrograma(Integer.parseInt(ventanaPrograma.JTextIdPrograma.getText()));
                    programa.setFechaCreacion(ventanaPrograma.cbDia.getSelectedItem()+" "+ventanaPrograma.cbHora.getSelectedItem());
           
            try{
                if(programaCRUD.agregarPrograma(programa)){
                    JOptionPane.showMessageDialog(null, "Se guardó el programa");
                }else{
                    JOptionPane.showMessageDialog(null, "Error al Guardar el programa, revise los datos");
                }
            }       catch (ClassNotFoundException ex) {
                        Logger.getLogger(ControladorPrograma.class.getName()).log(Level.SEVERE, null, ex);
                    }
    
            }} catch (SQLException ex) {
                Logger.getLogger(ControladorPrograma.class.getName()).log(Level.SEVERE, null, ex);
            }
   
        }
    }
    
    
}
