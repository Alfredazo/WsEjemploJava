/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Alfredazo
 */
public class TurnoHora {
    private int rutTrabajador;
    private String digitoVTrabajador;
    private String tipoTurno;
    private String horaEntrada;
    private String horaSalida;
    private Date   fechaRegistro;
    private String motivoInasistencia;
    private String horasTrabajadas;
    private String horasExtras;
    private String horasMenos;

    public TurnoHora() {
    }

    public TurnoHora(int rutTrabajador, String digitoV,String tipoTurno, String horaEntrada, String horaSalida, Date fechaRegistro, String motivoInasistencia, String horasTrabajadas, String horasExtras, String horasMenos) {
        this.rutTrabajador = rutTrabajador;
        this.digitoVTrabajador = digitoV;
        this.tipoTurno = tipoTurno;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.fechaRegistro = fechaRegistro;
        this.motivoInasistencia = motivoInasistencia;
        this.horasTrabajadas = horasTrabajadas;
        this.horasExtras = horasExtras;
        this.horasMenos = horasMenos;
    }

    public int getRutTrabajador() {
        return rutTrabajador;
    }

    public void setRutTrabajador(int rutTrabajador) {
        this.rutTrabajador = rutTrabajador;
    }

    public String getDigitoVTrabajador() {
        return digitoVTrabajador;
    }

    public void setDigitoVTrabajador(String digitoVTrabajador) {
        this.digitoVTrabajador = digitoVTrabajador;
    }

    public String getTipoTurno() {
        return tipoTurno;
    }

    public void setTipoTurno(String tipoTurno) {
        this.tipoTurno = tipoTurno;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getMotivoInasistencia() {
        return motivoInasistencia;
    }

    public void setMotivoInasistencia(String motivoInasistencia) {
        this.motivoInasistencia = motivoInasistencia;
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
        return "TurnoHora{" + "tipoTurno=" + tipoTurno + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida + ", fechaRegistro=" + fechaRegistro + ", motivoInasistencia=" + motivoInasistencia + ", horasTrabajadas=" + horasTrabajadas + ", horasExtras=" + horasExtras + ", horasMenos=" + horasMenos + '}';
    }
    
    
    
}
