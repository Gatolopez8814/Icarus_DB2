package principal;

import Interfaz.PaginaPrincipal;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.ConexionMySql;

public class Principal {

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
                Principal principal = new Principal();
                principal.mostrarInterfaz();
            }
        });
    }//-----------------------------------------------------------------END_MAIN

    private void mostrarInterfaz() {         
        
        PaginaPrincipal vent = new PaginaPrincipal();
        vent.mostrarVentana();
       /*
        
       ConexionMySql coneccion= ConexionMySql.obtenerInstancia();
        boolean bandera= coneccion.noReturnStatementMySQL("root","root","","INSERT INTO `test`.`t1`(`num`)VALUES(1);");
        if(bandera){
            System.out.println("La conexion es posible");
        }else{
            System.out.println("ERROR la conexion No pudo realizarse ");
        } 
        */
        
        
        
        
    }//------------------------------------------------------END_mostrarInterfaz

    
}//____________________________________________________________________END_MAIN
