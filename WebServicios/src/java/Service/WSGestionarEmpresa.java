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
import DAO.EmpresaDao;
import java.util.ArrayList;

/**
 *
 * @author Alfredazo
 */
@WebService(serviceName = "WSGestionarEmpresa")
public class WSGestionarEmpresa {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "listarNombreEmpresa")
    public ArrayList<Empresa> listarNombreEmpresa() {
        EmpresaDao empresaDao = new EmpresaDao();
        ArrayList<Empresa> listarEmpresasTrabajadores = new ArrayList();
        listarEmpresasTrabajadores = empresaDao.listarNombreEmpresa();
        return listarEmpresasTrabajadores;
    }

    @WebMethod(operationName = "buscarNombreEmpresaPorRutTrabajador")
    public String buscarNombreEmpresaPorRutTrabajador(@WebParam(name = "rutTrabajador") int rutTrabajador, @WebParam(name = "digitoV") String digitoV) {
        EmpresaDao empresaDao = new EmpresaDao();
        String nombreEmpresa = "";
        nombreEmpresa = empresaDao.buscarNombreEmpresaPorRutTrabajador(rutTrabajador, digitoV);
        return nombreEmpresa;
    }

    @WebMethod(operationName = "validarExisteEmpresa")
    public boolean validarExisteEmpresa(@WebParam(name = "rutEmpresa") int rutEmpresa, @WebParam(name = "digitoV") String digitoV) {
        EmpresaDao empresaDao = new EmpresaDao();
        boolean validar = false;
        
        validar = empresaDao.validarExisteEmpresa(rutEmpresa, digitoV);
        
        return validar;
    }

    
    
}
