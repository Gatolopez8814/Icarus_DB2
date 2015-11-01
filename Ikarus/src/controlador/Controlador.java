
package controlador;

import Interfaz.PaginaPrincipal;
import modelo.Modelo;

public class Controlador {
    
    private static Controlador instancia = null;
    private Modelo model;
    private PaginaPrincipal vista;
    
    public Controlador(){
        model = Modelo.obtenerInstancia();
    }
    
    public static Controlador obtenerInstancia() {
        if (instancia == null) {
            instancia = new Controlador();
        }
        return instancia;
    }
    
     public boolean cargarDesdeParametros(String UserName,String UserPass,
            String URL_File,String dataBase,String Table,char separator){
        return model.cargarDesdeParametros(UserName, UserPass, URL_File, 
                dataBase, Table, separator);
    }
    
     public boolean cargarDesdeArchivo(String URL_File){
        return model.cargaSimultanea(URL_File);
    }

   
     
}
