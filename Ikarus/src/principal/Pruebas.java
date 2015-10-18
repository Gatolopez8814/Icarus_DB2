package principal;

import java.util.ArrayList;
import modelo.ConexionMySql;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.ManejadorArchivosCSV;
import modelo.ManejadorArchivosTxt;

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
                //pruebas.prueba2();
                //pruebas.prueba3();
                pruebas.prueba4();
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
    private void prueba3(){
        ManejadorArchivosTxt fileManager = ManejadorArchivosTxt.obtenerInstancia();
        fileManager.CrearArchivo("test.txt");
        ArrayList<String> contenido = new ArrayList<>();
        contenido.add("linea 1");
        contenido.add("linea 2");
        fileManager.guardarSinBorrar("test.txt", contenido );
        contenido = new ArrayList<>();
        contenido.add("linea 3");
        contenido.add("linea 4");
        fileManager.guardarSinBorrar("test.txt", contenido );
        contenido = fileManager.leer("test.txt");
        for(String x:contenido){
            System.out.println(x);
        }
    }
    private void prueba4(){
        ManejadorArchivosCSV CSVManager = ManejadorArchivosCSV.obtenerInstancia();
        ArrayList<String> contenido = CSVManager.leer("clientes.csv");
        for(String x:contenido){
            System.out.println(x);
        }
        for(int i=0;i<25;i++){
            System.out.print("-");            
        }
        System.out.println("");
        String[] Y;
        for(String x:contenido){
            Y =x.split(",");
            for(String a:Y){
                System.out.println(a);
            }
        }
        
    }
}
