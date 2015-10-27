package principal;

import Interfaz.PaginaPrincipal;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
        /*VentanaPrincipal ventana = VentanaPrincipal.obtenerInstancia();
        ventana.mostrar();*/
        
        PaginaPrincipal vent = new PaginaPrincipal();
        vent.mostrarVentana();
        
        
        
        
    }//------------------------------------------------------END_mostrarInterfaz

    
}//____________________________________________________________________END_MAIN
