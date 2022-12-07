/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Vuelo;

/**
 *
 * @author Juan
 */
public class Vuelo {
    
    private String idVuelo;
    private int idPrograma;
    private String codLinea;
    private String placaAvion;
    private String Fecha;
    private int plazasVacias;

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
    }

    public void setCodLinea(String codLinea) {
        this.codLinea = codLinea;
    }

    public void setPlacaAvion(String placaAvion) {
        this.placaAvion = placaAvion;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public void setPlazasVacias(int plazasVacias) {
        this.plazasVacias = plazasVacias;
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public int getIdPrograma() {
        return idPrograma;
    }

    public String getCodLinea() {
        return codLinea;
    }

    public String getPlacaAvion() {
        return placaAvion;
    }

    public String getFecha() {
        return Fecha;
    }

    public int getPlazasVacias() {
        return plazasVacias;
    }
    
}
