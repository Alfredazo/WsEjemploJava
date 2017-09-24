
package Modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Alfredazo
 */
public class Turno {
        
    private String tipoTurno;
    private String horaLlegada;
    private String horaSalida;
    private Date fechaRegistroTurno;
    private String motivoInasistencia;

    public Turno() {
    }

    public Turno(String tipoTurno, String horaLlegada, String horaSalida, Date fechaRegistroTurno, String motivoInasistencia) {
        
        this.tipoTurno = tipoTurno;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
        this.fechaRegistroTurno = fechaRegistroTurno;
        this.motivoInasistencia = motivoInasistencia;
    }

  
    public String getTipoTurno() {
        return tipoTurno;
    }

    public void setTipoTurno(String tipoTurno) {
        this.tipoTurno = tipoTurno;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Date getFechaRegistroTurno() {
        return fechaRegistroTurno;
    }

    public void setFechaRegistroTurno(Date fechaRegistroTurno) {
        this.fechaRegistroTurno = fechaRegistroTurno;
    }

    public String getMotivoInasistencia() {
        return motivoInasistencia;
    }

    public void setMotivoInasistencia(String motivoInasistencia) {
        this.motivoInasistencia = motivoInasistencia;
    }

    @Override
    public String toString() {
        return "Turno{tipoTurno=" + tipoTurno + ", horaLlegada=" + horaLlegada + ", horaSalida=" + horaSalida + ", fechaRegistroTurno=" + fechaRegistroTurno + ", motivoInasistencia=" + motivoInasistencia + '}';
    }
    
    
    
             

    
}
