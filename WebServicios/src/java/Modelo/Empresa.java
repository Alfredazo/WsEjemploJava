/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Alfredazo
 */
public class Empresa {
    
    private int rutEmpresa;
    private String digitoV;
    private String giro;
    private String razonSocial;
    private String comuna;
    private String direccion;

    public Empresa() {
    }

    public Empresa(int rutEmpresa, String digitoV, String giro, String razonSocial, String comuna, String direccion) {
        this.rutEmpresa = rutEmpresa;
        this.digitoV = digitoV;
        this.giro = giro;
        this.razonSocial = razonSocial;
        this.comuna = comuna;
        this.direccion = direccion;
    }

    public int getRutEmpresa() {
        return rutEmpresa;
    }

    public void setRutEmpresa(int rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    public String getDigitoV() {
        return digitoV;
    }

    public void setDigitoV(String digitoV) {
        this.digitoV = digitoV;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Empresa{" + "rutEmpresa=" + rutEmpresa + ", digitoV=" + digitoV + ", giro=" + giro + ", razonSocial=" + razonSocial + ", comuna=" + comuna + ", direccion=" + direccion + '}';
    }
    

    /*Validar rut*/
    public static boolean validarRutTrabajador(String rut) {      
        boolean validacion = false;
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
