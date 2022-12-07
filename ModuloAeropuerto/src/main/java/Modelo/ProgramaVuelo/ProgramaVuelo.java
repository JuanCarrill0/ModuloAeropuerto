/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.ProgramaVuelo;

/**
 *
 * @author Juan
 */
public class ProgramaVuelo {
    private String codLinea;
    private int idPrograma;
    private String idLugar;
    private String fechaCreacion;

    public void setCodLinea(String codLinea) {
        this.codLinea = codLinea;
    }

    public String getCodLinea() {
        return codLinea;
    }

    public int getIdPrograma() {
        return idPrograma;
    }

    public String getIdLugar() {
        return idLugar;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setIdPrograma(int idPrograma) {
        this.idPrograma = idPrograma;
    }

    public void setIdLugar(String idLugar) {
        this.idLugar = idLugar;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
}
