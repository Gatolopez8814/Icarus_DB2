package modelo;

import java.sql.*;

public class ConexionMySql {

    private static ConexionMySql instancia = null;

    private ConexionMySql(){
    }
    
    public static ConexionMySql obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConexionMySql();
        }
        return instancia;
    }
    
    public boolean isConexionPossible(String user,String password) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();           
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/?"
                    + "user="+user+"&password="+password);
            con.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return false;
    }

}
