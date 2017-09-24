/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Alfredazo
 */
public class UsuarioDao {

    Conexion conexion;

    public UsuarioDao() {
        conexion = new Conexion();
    }

    public boolean validarClaveUsuario(String nombreUsuario, String claveUsuario) {

        boolean validado = false;

        String sql = "Select nombreUsuario, password from usuario Where nombreUsuario= ?";
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                if (rs.getString(1).equals(nombreUsuario) && rs.getString(2).equals(claveUsuario)) {
                    validado = true;
                } else {
                    validado = false;
                }
            }

        } catch (Exception e) {
            System.out.println("algo" + e.getMessage());
        }
        return validado;
    }

}
