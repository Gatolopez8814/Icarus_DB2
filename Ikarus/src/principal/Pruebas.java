package principal;

import controlador.ConexionMySql;
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
                pruebas.iniciarPrueba();
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
    
}
