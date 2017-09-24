/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

/**
 *
 * @author Alfredazo
 */
public class TurnoDao {

    Conexion conexion;

    public TurnoDao() {
        conexion = new Conexion();
    }

    public boolean agregarTurnoTrabajador(String tipoTurno, String horaLlegada, String horaSalida, Date fechaRegistroTurno, String motivoInasistencia, int rutTrabajador, String digitoV) {
        boolean agregado = false;
        String sql = "Insert into turno(tipo_turno, hora_llegada, hora_salida, fechaRegistroTurno, motivo_inasistencia,"
                + " Trabajador_rut_trabajador, Trabajador_digitoV_trabajador) "
                + " Values (?,?,?,?,?,?,?); ";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, tipoTurno);
            cs.setString(2, horaLlegada);
            cs.setString(3, horaSalida);
            cs.setDate(4, fechaRegistroTurno);
            cs.setString(5, motivoInasistencia);
            cs.setInt(6, rutTrabajador);
            cs.setString(7, digitoV);

            int numFilas = cs.executeUpdate();
            if (numFilas > 0) {
                agregado = true;
            } else {
                agregado = false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return agregado;
    }

    public boolean eliminarturno(int rutTrabajador, String digitoV, Date fechaRegistro, String tipoTurno) {
        boolean eliminado = false;
        String sql = "Delete from turno "
                + "WHERE Trabajador_rut_trabajador = ? and Trabajador_digitoV_trabajador = ? "
                + " and fechaRegistroTurno = ? and tipo_turno = ? ;";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, rutTrabajador);
            cs.setString(2, digitoV);
            cs.setDate(3, fechaRegistro);
            cs.setString(4, tipoTurno);

            int numFilas = cs.executeUpdate();

            if (numFilas > 0) {
                eliminado = true;
            } else {
                eliminado = false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return eliminado;
    }

    public boolean modificarTurno(String tipoTurno, String horaLlegada, String horaSalida, Date fechaRegistroTurno, String motivoInasistencia, int rutTrabajador, String digitoV, int idTurno) {
        boolean modificado = false;
        
        String sql = "UPDATE turno "
                + " SET tipo_turno = ?, hora_llegada = ?, hora_salida = ? , fechaRegistroTurno = ? , motivo_inasistencia = ? "
                + " WHERE Trabajador_rut_trabajador = ? and Trabajador_digitoV_trabajador = ? and id_turno = ?;";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, tipoTurno);
            cs.setString(2, horaLlegada);
            cs.setString(3, horaSalida);
            cs.setDate(4, fechaRegistroTurno);
            cs.setString(5, motivoInasistencia);
            cs.setInt(6, rutTrabajador);
            cs.setString(7, digitoV);
            cs.setInt(8, idTurno);

            int numFilas = cs.executeUpdate();

            if (numFilas > 0) {
                modificado = true;
            } else {
                modificado = false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modificado;
    }

    public int devolverIdturnoPorParametro(String tipoTurno, Date fechaRegistroTurno, int rutTrabajador, String digitoV) {
        int id = -1;

        String sql = "Select id_turno from turno "
                + " where Trabajador_rut_trabajador = ? and Trabajador_digitoV_trabajador = ?"
                + " and tipo_turno = ? and fechaRegistroTurno = ?";

        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, rutTrabajador);
            ps.setString(2, digitoV);
            ps.setString(3, tipoTurno);
            ps.setDate(4, fechaRegistroTurno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (Exception e) {

        }

        return id;
    }

}
