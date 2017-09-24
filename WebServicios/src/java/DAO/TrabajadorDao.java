/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Conexion;
import Modelo.Trabajador;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alfredazo
 */
public class TrabajadorDao {

    Conexion conexion;

    public TrabajadorDao() {
        conexion = new Conexion();
    }

    public boolean insertarTrabajador(int rutTrabajador, String digitoV, String primerN, String segundoN, String apellidoP, String apellidoM, int horas_diarias, int rutEmpresa, String digitoVEmpresa) {
        boolean agregado = false;
        String sql = "Insert into Trabajador(rut_trabajador,digitoV_trabajador,primerN_trabajador,segundoN_trabajador,"
                + "apellidoP_trabajador, apellidoM_trabajador, horas_diariasTrabajador, Empresa_rut_empresa,Empresa_digitoV_empresa)"
                + "Values(?,?,?,?,?,?,?,?,?);";
        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, rutTrabajador);
            cs.setString(2, digitoV);
            cs.setString(3, primerN);
            cs.setString(4, segundoN);
            cs.setString(5, apellidoP);
            cs.setString(6, apellidoM);
            cs.setInt(7, horas_diarias);
            cs.setInt(8, rutEmpresa);
            cs.setString(9, digitoVEmpresa);

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

    public boolean modificarTrabajador(int rutTrabajador, String digitoV, String primerN, String segundoN, String apellidoP, String apellidoM, int horas_diarias, int rutEmpresa, String digitoVEmpresa) {
        boolean modificado = false;
        String sql = "UPDATE trabajador "
                + "SET primerN_trabajador = ?, segundoN_trabajador = ?, apellidoP_trabajador = ? , apellidoM_trabajador = ? , horas_diariasTrabajador = ?,"
                + "Empresa_rut_empresa = ?, Empresa_digitoV_empresa = ? "
                + "WHERE rut_trabajador = ? and digitoV_trabajador = ?;";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setString(1, primerN);
            cs.setString(2, segundoN);
            cs.setString(3, apellidoP);
            cs.setString(4, apellidoM);
            cs.setInt(5, horas_diarias);
            cs.setInt(6, rutEmpresa);
            cs.setString(7, digitoVEmpresa);
            cs.setInt(8, rutTrabajador);
            cs.setString(9, digitoV);

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

    public boolean eliminarTrabajador(int rutTrabajador, String digitoV) {
        boolean eliminado = false;
        String sql = "Delete from Trabajador "
                + "WHERE rut_trabajador = ? and digitoV_trabajador = ?;";

        try {
            Connection accesoDB = conexion.getConexion();
            CallableStatement cs = accesoDB.prepareCall(sql);
            cs.setInt(1, rutTrabajador);
            cs.setString(2, digitoV);

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

    public ArrayList<Trabajador> listarTodosLosTrabajadores() {

        ArrayList listaTrabajadores = new ArrayList();
        Trabajador trabajador;

        String sql = "Select * From Trabajador";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                trabajador = new Trabajador();
                trabajador.setRutTrabajador(rs.getInt(1));
                trabajador.setDigitoV(rs.getString(2));
                trabajador.setPrimerN(rs.getString(3));
                trabajador.setSegundoN(rs.getString(4));
                trabajador.setApellidoP(rs.getString(5));
                trabajador.setApellidoM(rs.getString(6));
                trabajador.setHoras_diarias(rs.getInt(7));

                listaTrabajadores.add(trabajador);
            }

        } catch (Exception e) {

        }
        return listaTrabajadores;
    }

    public ArrayList<Trabajador> listarTrabajadoresPorEmpresa(int rutEmpresa, String digitoVEmpresa) {

        ArrayList listaTrabajadores = new ArrayList();
        Trabajador trabajador;

        String sql = "Select * From Trabajador Where Empresa_rut_empresa = ? and Empresa_digitoV_empresa = ?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, rutEmpresa);
            ps.setString(2, digitoVEmpresa);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                trabajador = new Trabajador();
                trabajador.setRutTrabajador(rs.getInt(1));
                trabajador.setDigitoV(rs.getString(2));
                trabajador.setPrimerN(rs.getString(3));
                trabajador.setSegundoN(rs.getString(4));
                trabajador.setApellidoP(rs.getString(5));
                trabajador.setApellidoM(rs.getString(6));
                trabajador.setHoras_diarias(rs.getInt(7));

                listaTrabajadores.add(trabajador);
            }

        } catch (Exception e) {

        }
        return listaTrabajadores;
    }

    public boolean ValidarTrabajadorExiste(int rut, String digitoV) {
        boolean encontrado = false;
        String sql = "Select * From Trabajador WHERE rut_trabajador = ? and digitoV_trabajador = ?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, rut);
            ps.setString(2, digitoV);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                encontrado = true;
            } else {
                encontrado = false;
            }

        } catch (Exception e) {

        }
        return encontrado;
    }

    public Trabajador buscarTrabajadorPorRut(int rut, String digitoV) {
        Trabajador trabajadorcito = null;
        String sql = "Select primerN_trabajador, segundoN_trabajador, apellidoP_trabajador, apellidoM_trabajador, horas_diariasTrabajador From Trabajador "
                + "WHERE rut_trabajador = ? and digitoV_trabajador = ?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, rut);
            ps.setString(2, digitoV);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String primerN = rs.getString(1);
                String segundoN = rs.getString(2);
                String apellidoP = rs.getString(3);
                String apellidoM = rs.getString(4);
                int horas_diarias = rs.getInt(5);
                
                trabajadorcito = new Trabajador(rut, digitoV, primerN, segundoN, apellidoP, apellidoM, horas_diarias);
            }

        } catch (Exception e) {

        }
        return trabajadorcito;
    }

}
