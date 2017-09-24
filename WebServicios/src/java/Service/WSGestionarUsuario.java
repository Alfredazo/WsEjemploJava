/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import Modelo.*;
import DAO.UsuarioDao;

/**
 *
 * @author Alfredazo
 */
@WebService(serviceName = "WSGestionarUsuario")
public class WSGestionarUsuario {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "validarUsuario")
    public boolean validarUsuario(@WebParam(name = "nombreUsuario") String nombreUsuario, @WebParam(name = "claveUsuario") String claveUsuario) {
        boolean validador = false;
        UsuarioDao usuariodao = new UsuarioDao();
        validador = usuariodao.validarClaveUsuario(nombreUsuario, claveUsuario);
        return validador;
    }
}
