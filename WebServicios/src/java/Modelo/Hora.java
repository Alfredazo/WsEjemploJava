/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Alfredazo
 */
public class Hora {
    
    private String horasTrabajadas;
    private String horasExtras;
    private String horasMenos;

    public Hora() {
    }

    
    public Hora(String horasTrabajadas, String horasExtras, String horasMenos) {
        this.horasTrabajadas = horasTrabajadas;
        this.horasExtras = horasExtras;
        this.horasMenos = horasMenos;
    }

    public String getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(String horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public String getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(String horasExtras) {
        this.horasExtras = horasExtras;
    }

    public String getHorasMenos() {
        return horasMenos;
    }

    public void setHorasMenos(String horasMenos) {
        this.horasMenos = horasMenos;
    }

    @Override
    public String toString() {
        return "Hora{" + "horasTrabajadas=" + horasTrabajadas + ", horasExtras=" + horasExtras + ", horasMenos=" + horasMenos + '}';
    }
    
    
        
}
