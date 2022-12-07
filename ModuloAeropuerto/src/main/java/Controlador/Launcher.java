/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Controlador;

import Vista.VentanaPrincipal;

import Modelo.Conexion;
import Modelo.Dia.Dia;
import Modelo.Dia.DiaCRUD;
import Modelo.Hora.Hora;
import Modelo.Hora.HoraCRUD;
import Modelo.LineaAerea.LineaAerea;
import Modelo.LineaAerea.LineaAereaCRUD;
import Modelo.Lugar.Lugar;
import Modelo.Lugar.LugarCRUD;
import Modelo.ProgramaVuelo.ProgramaVuelo;
import Modelo.ProgramaVuelo.ProgramaVueloCRUD;
import Vista.VentanaProgramaVuelo;

/**
 *
 * @author Juan
 */
public class Launcher {

    public static void main(String[] args) throws ClassNotFoundException {
        VentanaPrincipal ventana = new VentanaPrincipal();
        VentanaProgramaVuelo ventanaPrograma = new VentanaProgramaVuelo();

        ventana.setVisible(true);
        ventana.setTitle("MODULO AEROPUERTO");
    }
}
