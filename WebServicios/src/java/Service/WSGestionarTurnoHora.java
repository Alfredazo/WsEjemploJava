/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.TurnoHoraDao;
import Modelo.TurnoHora;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Alfredazo
 */
@WebService(serviceName = "WSGestionarTurnoHora")
public class WSGestionarTurnoHora {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "listarTurnoHoraPorRangoFechas")
    public ArrayList<TurnoHora> listarTurnoHoraPorRangoFechas(@WebParam(name = "rutTrabajador") int rutTrabajador, @WebParam(name = "digitoV") String digitoV, @WebParam(name = "fechaInicial") String fechaInicial, @WebParam(name = "fechaFinal") String fechaFinal) throws ParseException {
        TurnoHoraDao turnoHora = new TurnoHoraDao();
        ArrayList<TurnoHora> listado = new ArrayList();

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        String fechaInicial1 = formato.format(Date.valueOf(fechaInicial));
        java.util.Date fechaParseada = formato.parse(fechaInicial1);
        java.sql.Date fechaLista = new java.sql.Date(fechaParseada.getTime());

        String fechaInicial2 = formato.format(Date.valueOf(fechaFinal));
        java.util.Date fechaParseada2 = formato.parse(fechaInicial2);
        java.sql.Date fechaLista2 = new java.sql.Date(fechaParseada2.getTime());

        listado = turnoHora.listarTurnoHoraPorRangoFechas(rutTrabajador, digitoV, fechaLista, fechaLista2);

        return listado;
    }

    @WebMethod(operationName = "listarTurnoHoraPorFechaEspecifica")
    public ArrayList<TurnoHora> listarTurnoHoraPorFechaEspecifica(@WebParam(name = "rutTrabajador") int rutTrabajador, @WebParam(name = "digitoV") String digitoV, @WebParam(name = "fechaInicial") String fechaInicial) throws ParseException {
        TurnoHoraDao turnoHora = new TurnoHoraDao();
        ArrayList<TurnoHora> listado = new ArrayList();

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        String fechaInicial1 = formato.format(Date.valueOf(fechaInicial));
        java.util.Date fechaParseada = formato.parse(fechaInicial1);
        java.sql.Date fechaLista = new java.sql.Date(fechaParseada.getTime());

        listado = turnoHora.listarTurnoHoraPorFechaEspecifica(rutTrabajador, digitoV, fechaLista);

        return listado;
    }

}
