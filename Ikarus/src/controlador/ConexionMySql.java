package controlador;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexionMySql {

    private static ConexionMySql instancia = null;
    private Connection conexion;

    public static ConexionMySql obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConexionMySql();
        }
        return instancia;
    }//---------------------------------------------------- FIN_obtenerInstancia

    public Connection conectar() {
        Connection conexion = null;
        Statement comando = null;
        ResultSet registro;
        try {
            //Driver JDBC
            Class.forName("com.mysql.jdbc.Driver");
            //Nombre del servidor. localhost:3306 es la ruta y el puerto de la conexión MySQL
            //panamahitek_text es el nombre que le dimos a la base de datos
            String servidor = "jdbc:mysql://server-sigeti:3306/sigeti";
            //El root es el nombre de usuario por default. No hay contraseña
            String usuario = "monty";
            String pass = "root";
            //Se inicia la conexión
            conexion = (Connection) DriverManager.getConnection(servidor, usuario, pass);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            conexion = null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
            ex.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexión a la base de datos: " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
            ex.printStackTrace();
        } finally {           
            return conexion;
        }      
    }//------------------------------------------------------------ FIN_conectar

    public Connection getConexion() {
        return conexion;
    }//--------------------------------------------------------- FIN_getConexion
}
