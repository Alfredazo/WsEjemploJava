/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Conexion;
import Modelo.Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alfredazo
 */
public class EmpresaDao {

    Conexion conexion;

    public EmpresaDao() {
        conexion = new Conexion();
    }

    /*Listar todas las empresas*/
    public ArrayList<Empresa> listarNombreEmpresa() {

        ArrayList listaNombreEmpresas = new ArrayList();

        String sql = "Select * From Empresa";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int rutEmpresa = rs.getInt(1);
                String digitoV = rs.getString(2);
                String giro = rs.getString(3);
                String razonSocial = rs.getString(4);
                String comuna = rs.getString(5);
                String direccion = rs.getString(6);
                Empresa empresita = new Empresa(rutEmpresa, digitoV, giro, razonSocial, comuna, direccion);
                listaNombreEmpresas.add(empresita);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaNombreEmpresas;
    }

    public String buscarNombreEmpresaPorRutTrabajador(int rut, String digitoV) {

        String nombreEmpresa = "";

        String sql = "Select e.giro_empresa "
                + " from trabajador t Join empresa e "
                + " ON e.rut_empresa = t.Empresa_rut_empresa "
                + " and e.digitoV_empresa = t.Empresa_digitoV_empresa "
                + " where rut_trabajador= ? and digitoV_trabajador = ?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, rut);
            ps.setString(2, digitoV);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
               nombreEmpresa = rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return nombreEmpresa;
    }

      public boolean validarExisteEmpresa(int rut, String digitoV) {

        boolean validar = false;

        String sql = "Select * From empresa "
                + " where rut_empresa= ? and digitoV_empresa = ?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setInt(1, rut);
            ps.setString(2, digitoV);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
               validar = true;
            }else{
                validar = false;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return validar;
    }
    
}
