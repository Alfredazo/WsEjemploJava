package Modelo;

import java.sql.PreparedStatement;

public class Trabajador {

    /*Atributos*/
    private int rutTrabajador;
    private String digitoV;
    private String primerN;
    private String segundoN;
    private String apellidoP;
    private String apellidoM;
    private int horas_diarias;

    /*Constructores*/
    public Trabajador() {
    }

    public Trabajador(int rutTrabajador, String digitoV, String primerN, String segundoN, String apellidoP, String apellidoM, int horas_diarias) throws Exception {
        this.setRutTrabajador(rutTrabajador);
        this.setDigitoV(digitoV);
        this.setPrimerN(primerN);
        this.setSegundoN(segundoN);
        this.setApellidoP(apellidoP);
        this.setApellidoM(apellidoM);
        this.setHoras_diarias(horas_diarias);
    }

    /*Getter and Setter*/
    public int getRutTrabajador() {
        return rutTrabajador;
    }

    public void setRutTrabajador(int rutTrabajador) throws Exception {

        if (String.valueOf(rutTrabajador).isEmpty()) {
            throw new Exception("El rut no debe venir Vacio");
        }

        this.rutTrabajador = rutTrabajador;
    }

    public String getDigitoV() {
        return digitoV;
    }

    public void setDigitoV(String digitoV) throws Exception {
        if (digitoV.length() != 1) {
            throw new Exception("El digito solo debe contener un Caracter");
        }

        this.digitoV = digitoV;
    }

    public String getPrimerN() {
        return primerN;
    }

    public void setPrimerN(String primerN) throws Exception {
        if (primerN.length() <= 0) {
            throw new Exception("El primer Nombre no debe venir en blanco");
        }
        this.primerN = primerN;
    }

    public String getSegundoN() {
        return segundoN;
    }

    public void setSegundoN(String segundoN) throws Exception {
        if (segundoN.length() <= 0) {
            throw new Exception("El segundo Nombre no debe venir en blanco");
        }
        this.segundoN = segundoN;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) throws Exception {
        if (apellidoP.length() <= 0) {
            throw new Exception("El Apellido Paterno no debe venir en blanco");
        }
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) throws Exception {
        if (apellidoM.length() <= 0) {
            throw new Exception("El Apellido Materno no debe venir en blanco");
        }
        this.apellidoM = apellidoM;
    }

    public int getHoras_diarias() {
        return horas_diarias;
    }

    public void setHoras_diarias(int horas_diarias) throws Exception {
        if (horas_diarias < 0 || horas_diarias > 20) {
            throw new Exception("El rango de Horas diarias es de 0 a 15");
        }
        this.horas_diarias = horas_diarias;
    }

    /*TOString*/
    @Override
    public String toString() {
        return "Trabajador{" + "rutTrabajador=" + rutTrabajador + ", digitoV=" + digitoV + ", primerN=" + primerN + ", segundoN=" + segundoN + ", apellidoP=" + apellidoP + ", apellidoM=" + apellidoM + ", horas_diarias=" + horas_diarias + '}';
    }

    /*Validar rut*/
    public boolean validarRutTrabajador(int rutT, String digitoV) {
        boolean validacion = false;
        String rut = "";
        rut = String.valueOf(rutT) + digitoV;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }

}
