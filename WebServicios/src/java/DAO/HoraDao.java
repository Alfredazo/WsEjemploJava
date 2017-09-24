/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Eleazar
 */
public class HoraDao {

    Conexion conexion;

    public HoraDao() {
        conexion = new Conexion();
    }

    public boolean agregarHora(String horasTrabajadas, String horasExtras, String horasMenos) {
        boolean agregado = false;
        int idUltimoTurno = retornarUltimoIDTurno();
        String sql = " Insert into hora(horas_trabajadas, horas_extras, horas_menos, turno_id_turno)"
                + " Values (?,?,?,?); ";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, horasTrabajadas);
            cs.setString(2, horasExtras);
            cs.setString(3, horasMenos);
            cs.setInt(4, idUltimoTurno);

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

    public int retornarUltimoIDTurno() {
        int ultimoD = 0;
        String sql = "select  id_turno from turno order by id_turno desc limit 1";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ultimoD = rs.getInt(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ultimoD;
    }

    public boolean modificarHora(String horasTrabajadas, String horasExtras, String horasMenos, int idTurno) {
        boolean modificado = false;

        String sql = "UPDATE hora "
                + " SET horas_trabajadas = ?, horas_extras = ?, horas_menos = ?"
                + " WHERE turno_id_turno = ?;";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, horasTrabajadas);
            cs.setString(2, horasExtras);
            cs.setString(3, horasMenos);
            cs.setInt(4, idTurno);

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

}
