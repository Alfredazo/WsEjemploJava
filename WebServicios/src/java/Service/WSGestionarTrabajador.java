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
import DAO.TrabajadorDao;
import java.util.ArrayList;

/**
 *
 * @author Alfredazo
 */
@WebService(serviceName = "WSGestionarTrabajador")
public class WSGestionarTrabajador {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertarTrabajador")
    public boolean insertarTrabajador(@WebParam(name = "rutTrabajador") int rutTrabajador, @WebParam(name = "digitoV") String digitoV, @WebParam(name = "primerN") String primerN, @WebParam(name = "segundoN") String segundoN, @WebParam(name = "apellidoP") String apellidoP, @WebParam(name = "apellidoM") String apellidoM, @WebParam(name = "horas_diarias") int horas_diarias, @WebParam(name = "rutEmpresa") int rutEmpresa, @WebParam(name = "digitoVEmpresa") String digitoVEmpresa) {
        boolean validar = false;
        TrabajadorDao trabajadorDao = new TrabajadorDao();
        validar = trabajadorDao.insertarTrabajador(rutTrabajador, digitoV, primerN, segundoN, apellidoP, apellidoM, horas_diarias, rutEmpresa, digitoVEmpresa);
        return validar;
    }

    @WebMethod(operationName = "modificarTrabajador")
    public boolean modificarTrabajador(@WebParam(name = "rutTrabajador") int rutTrabajador, @WebParam(name = "digitoV") String digitoV, @WebParam(name = "primerN") String primerN, @WebParam(name = "segundoN") String segundoN, @WebParam(name = "apellidoP") String apellidoP, @WebParam(name = "apellidoM") String apellidoM, @WebParam(name = "horas_diarias") int horas_diarias, @WebParam(name = "rutEmpresa") int rutEmpresa, @WebParam(name = "digitoVEmpresa") String digitoVEmpresa) {
        boolean validar = false;
        TrabajadorDao trabajadorDao = new TrabajadorDao();
        validar = trabajadorDao.modificarTrabajador(rutTrabajador, digitoV, primerN, segundoN, apellidoP, apellidoM, horas_diarias, rutEmpresa, digitoVEmpresa);
        return validar;
    }

    @WebMethod(operationName = "eliminarTrabajador")
    public boolean eliminarTrabajador(@WebParam(name = "rutTrabajador") int rutTrabajador, @WebParam(name = "digitoV") String digitoV) {
        boolean validar = false;
        TrabajadorDao trabajadorDao = new TrabajadorDao();
        validar = trabajadorDao.eliminarTrabajador(rutTrabajador, digitoV);
        return validar;
    }

    @WebMethod(operationName = "listarTodosLosTrabajadores")
    public ArrayList<Trabajador> listarTodosLosTrabajadores() {
        TrabajadorDao trabajadorDao = new TrabajadorDao();
        ArrayList<Trabajador> listaTrabajadores = new ArrayList();
        listaTrabajadores = trabajadorDao.listarTodosLosTrabajadores();
        return listaTrabajadores;
    }

    @WebMethod(operationName = "listarTrabajadoresPorEmpresa")
    public ArrayList<Trabajador> listarTrabajadoresPorEmpresa(@WebParam(name = "rutEmpresa") int rutEmpresa, @WebParam(name = "digitoVEmpresa") String digitoVEmpresa) {
        TrabajadorDao trabajadorDao = new TrabajadorDao();
        ArrayList<Trabajador> listaTrabajadores = new ArrayList();
        listaTrabajadores = trabajadorDao.listarTrabajadoresPorEmpresa(rutEmpresa, digitoVEmpresa);
        return listaTrabajadores;
    }

    @WebMethod(operationName = "ValidarTrabajadorExiste")
    public boolean ValidarTrabajadorExiste(@WebParam(name = "rutTrabajador") int rutTrabajador, @WebParam(name = "digitoV") String digitoV) {
        boolean validar = false;
        TrabajadorDao trabajadorDao = new TrabajadorDao();
        validar = trabajadorDao.ValidarTrabajadorExiste(rutTrabajador, digitoV);
        return validar;
    }

    @WebMethod(operationName = "buscarTrabajadorPorRut")
    public Trabajador buscarTrabajadorPorRut(@WebParam(name = "rutTrabajador") int rutTrabajador, @WebParam(name = "digitoV") String digitoV) {
        Trabajador trabajadorcito = new Trabajador();
        TrabajadorDao trabajadorDao = new TrabajadorDao();
        trabajadorcito = trabajadorDao.buscarTrabajadorPorRut(rutTrabajador, digitoV);
        return trabajadorcito;
    }


}
