package Modelo;

import java.sql.*;

public class Conexion{

    public Conexion() {
    }
    
    public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemacontablescat","root","root");
        }catch(Exception e){
        }
        return con;
    }
    
}