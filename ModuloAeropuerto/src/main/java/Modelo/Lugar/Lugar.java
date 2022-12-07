/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Lugar;

/**
 *
 * @author Juan
 */
public class Lugar {
    private String idLugar;
    private String idTipoLugar;
    private String nomLugar;
    private String idDestino;

    public String getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(String idDestino) {
        this.idDestino = idDestino;
    }

    public void setIdLugar(String idLugar) {
        this.idLugar = idLugar;
    }

    public void setIdTipoLugar(String idTipoLugar) {
        this.idTipoLugar = idTipoLugar;
    }

    public void setNomLugar(String nomLugar) {
        this.nomLugar = nomLugar;
    }

    public String getIdLugar() {
        return idLugar;
    }

    public String getIdTipoLugar() {
        return idTipoLugar;
    }

    public String getNomLugar() {
        return nomLugar;
    }
    
    
}
