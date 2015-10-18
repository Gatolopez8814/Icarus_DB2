package principal;

import modelo.ConexionMySql;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Pruebas {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.err.println(e.getMessage());
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Pruebas pruebas = new Pruebas();
                //pruebas.iniciarPrueba();
                pruebas.prueba2();
            }
        });
    }

    private void iniciarPrueba() {
        // testConeccion();
        ConexionMySql coneccion= ConexionMySql.obtenerInstancia();
        boolean bandera= coneccion.isConexionPossible("root", "root");
        if(bandera){
            System.out.println("La conexion es posible");
        }else{
            System.out.println("ERROR la conexion No pudo realizarse ");
        }            
    }
    private void prueba2(){
        ConexionMySql coneccion= ConexionMySql.obtenerInstancia();
        boolean bandera= coneccion.noReturnStatementMySQL("root","root","","INSERT INTO `test`.`t1`(`num`)VALUES(1);");
        if(bandera){
            System.out.println("La conexion es posible");
        }else{
            System.out.println("ERROR la conexion No pudo realizarse ");
        }  
    }
    
}
