/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Controlador;

import Vista.VentanaPrincipal;

/**
 *
 * @author Juan
 */
public class Launcher {

    public static void main(String[] args) throws ClassNotFoundException {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
        ventana.setTitle("MODULO AEROPUERTO");
    }
}
