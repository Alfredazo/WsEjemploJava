/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Conexion;
import Modelo.TurnoHora;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alfredazo
 */
public class TurnoHoraDao {

    Conexion conexion;

    public TurnoHoraDao() {
        conexion = new Conexion();
    }

    public ArrayList<TurnoHora> listarTurnoHoraPorRangoFechas(int rutTrabajador, String digitoVTrabajador, Date fechaInicial, Date fechaFinal) {

        ArrayList listaTurnoHora = new ArrayList();
        TurnoHora turnoHora;

        String sql = "Select t.trabajador_rut_trabajador, t.Trabajador_digitoV_trabajador , t.fechaRegistroTurno,t.tipo_turno,t.motivo_inasistencia,t.hora_llegada,"
                + "t.hora_salida,h.horas_trabajadas,h.horas_extras,h.horas_menos,t.id_turno, h.turno_id_turno"
                + " from hora h Left join turno t"
                + " on(t.id_turno = h.turno_id_turno) "
                + " where t.Trabajador_rut_trabajador = ? and t.Trabajador_digitoV_trabajador = ? and t.fechaRegistroTurno between ? and ?";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, rutTrabajador);
            ps.setString(2, digitoVTrabajador);
            ps.setDate(3, fechaInicial);
            ps.setDate(4, fechaFinal);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                turnoHora = new TurnoHora();
                turnoHora.setRutTrabajador(rs.getInt(1));
                turnoHora.setDigitoVTrabajador(rs.getString(2));
                turnoHora.setFechaRegistro(rs.getDate(3));
                turnoHora.setTipoTurno(rs.getString(4));
                turnoHora.setMotivoInasistencia(rs.getString(5));
                turnoHora.setHoraEntrada(rs.getString(6));
                turnoHora.setHoraSalida(rs.getString(7));
                turnoHora.setHorasTrabajadas(rs.getString(8));
                turnoHora.setHorasExtras(rs.getString(9));
                turnoHora.setHorasMenos(rs.getString(10));

                listaTurnoHora.add(turnoHora);
            }

        } catch (Exception e) {

        }
        return listaTurnoHora;
    }

    public ArrayList<TurnoHora> listarTurnoHoraPorFechaEspecifica(int rutTrabajador, String digitoVTrabajador, Date fechaInicial) {

        ArrayList listaTurnoHora = new ArrayList();
        TurnoHora turnoHora;

        String sql = "Select t.trabajador_rut_trabajador, t.Trabajador_digitoV_trabajador, t.fechaRegistroTurno,t.tipo_turno,t.motivo_inasistencia,t.hora_llegada,"
                + "t.hora_salida,h.horas_trabajadas,h.horas_extras,h.horas_menos,t.id_turno, h.turno_id_turno"
                + " from hora h Left join turno t"
                + " on(t.id_turno = h.turno_id_turno) "
                + " where t.Trabajador_rut_trabajador = ? and t.Trabajador_digitoV_trabajador = ? and t.fechaRegistroTurno = ?";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, rutTrabajador);
            ps.setString(2, digitoVTrabajador);
            ps.setDate(3, fechaInicial);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                turnoHora = new TurnoHora();
                turnoHora.setRutTrabajador(rs.getInt(1));
                turnoHora.setDigitoVTrabajador(rs.getString(2));
                turnoHora.setFechaRegistro(rs.getDate(3));
                turnoHora.setTipoTurno(rs.getString(4));
                turnoHora.setMotivoInasistencia(rs.getString(5));
                turnoHora.setHoraEntrada(rs.getString(6));
                turnoHora.setHoraSalida(rs.getString(7));
                turnoHora.setHorasTrabajadas(rs.getString(8));
                turnoHora.setHorasExtras(rs.getString(9));
                turnoHora.setHorasMenos(rs.getString(10));

                listaTurnoHora.add(turnoHora);
            }

        } catch (Exception e) {

        }
        return listaTurnoHora;
    }

  
}
