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
import Vista.VentanaProgramaVuelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Juan
 */
public class ControladorProgramaVuelo implements ActionListener {
    private final VentanaProgramaVuelo ventana = new VentanaProgramaVuelo();
    DefaultTableModel modelo= new DefaultTableModel(); 
    private ProgramaVuelo programa = new ProgramaVuelo();
    private AvionCRUD avionCRUD = new AvionCRUD();
    private ModeloAvion modeloAvion = new ModeloAvion();
    private ModeloAvionCRUD modeloAvionCRUD = new ModeloAvionCRUD();
    private Avion avion = new Avion();
    private Vuelo vuelo = new Vuelo();
    private VueloCRUD vueloCRUD = new VueloCRUD();
    private ProgramaVueloCRUD programaCRUD = new ProgramaVueloCRUD();
    private Lugar lugar = new Lugar();
    private LugarCRUD lugarCRUD = new LugarCRUD();
    private LineaAerea linea = new LineaAerea();
    private LineaAereaCRUD lineaCRUD = new LineaAereaCRUD();
    private Dia dia = new Dia();
    private DiaCRUD diaCRUD = new DiaCRUD();
    
    public ControladorProgramaVuelo(){
        this.ventana.cbDia.addActionListener(this);
        this.ventana.cbLineaAerea.addActionListener(this);
        this.ventana.btnBuscar.addActionListener(this);
    }
    
    public void limpiar(JTable tabla){
       DefaultTableModel tb= (DefaultTableModel)tabla.getModel();
       int a= tabla.getRowCount()-1;
       System.out.println(tabla.getRowCount());
       for(int i=a; i>=0; i--){
           tb.removeRow(tb.getRowCount()-1);
        }
    }
    
    
    public VentanaProgramaVuelo getVentanaProgramaVuelo(){
        return this.ventana;
    }
  
       public void listarTablaProgramas(JTable tabla){
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
                        ventana.Tabla.setModel(modelo);    
                    }    
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrograma.class.getName()).log(Level.SEVERE, null, ex);
            }
  }
   
  public void listarTablaVuelos(JTable tabla){
        limpiar(tabla);
        modelo = (DefaultTableModel)tabla.getModel();
        Object[] objeto= new Object[5];
        /*Se busca el id de la linea y se pasa como parametro junto al dia para listas
           los programas de vuelos especificos para ese dia y aerolinea*/
        try {
                if(lineaCRUD.buscarLineaAereaID(linea)){
                     List<Vuelo> listarVuelos = vueloCRUD.listarVuelosLineaDia(linea, dia);
                     /*Cuando la tabla está vacia enlista*/
                     if (modelo.getRowCount()== 0) {
                            for(int i=0; i<listarVuelos.size();i++){
                                System.out.println("entro vuelos");
                            /*Se adjuntan los datos en la tabla respectivamente*/
                            objeto[0]= listarVuelos.get(i).getIdVuelo();
                            objeto[1]= listarVuelos.get(i).getIdPrograma();
                            objeto[2]= listarVuelos.get(i).getPlacaAvion();
                            objeto[3]= listarVuelos.get(i).getPlazasVacias();
                            modelo.addRow(objeto);
                        }
                        ventana.Tabla2.setModel(modelo);    
                    }    
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrograma.class.getName()).log(Level.SEVERE, null, ex);
            }
  }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ventana.btnBuscar){
           linea.setNomLinea((String)ventana.cbLineaAerea.getSelectedItem());
           dia.setNomDia((String)ventana.cbDia.getSelectedItem());
           listarTablaProgramas(ventana.Tabla);
           listarTablaVuelos(ventana.Tabla2);
        }
    }
  
}
