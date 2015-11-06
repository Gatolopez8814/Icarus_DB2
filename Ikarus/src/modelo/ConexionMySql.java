package modelo;

import java.sql.*;

public class ConexionMySql {

    private static ConexionMySql instancia = null;

    private ConexionMySql() {
    }

    public static ConexionMySql obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConexionMySql();
        }
        return instancia;
    }

    public boolean isConexionPossible(String user, String password) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/?"
                    + "user=" + user + "&password=" + password);
            con.close();
            return true;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            System.err.println(e.toString());
            ManejadorReportes.obtenerInstancia().agregarError(e.toString());
        }
        return false;
    }

    public boolean noReturnStatementMySQL(String user, String password,String tablespace,String statement) {
        //ando INSERT, DELETE, UPDATE, SET, 
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/"+tablespace+"?"
                    + "user=" + user + "&password=" + password);
            Statement cmd = con.createStatement();
            if(cmd.executeUpdate(statement) == 1){//"Example DELETE FROM HERRAMIENTA WHERE NOMBRE = 'Serrucho'"
                ManejadorReportes.obtenerInstancia().agregarEntradaLog(statement);
            }else{
                ManejadorReportes.obtenerInstancia().agregarError("ERROR en "+statement);
            }
            con.close();
            return true;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            System.err.println(e.toString());
            ManejadorReportes.obtenerInstancia().agregarError(e.toString());
        }
        return false;
    }

}
