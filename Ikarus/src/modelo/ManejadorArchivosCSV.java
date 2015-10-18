package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ManejadorArchivosCSV {

    private static ManejadorArchivosCSV instancia = null;

    private ManejadorArchivosCSV() {
    }

    public static ManejadorArchivosCSV obtenerInstancia() {
        if (instancia == null) {
            instancia = new ManejadorArchivosCSV();
        }
        return instancia;
    }

    public ArrayList<String> leer(String nombreArchivo) {//"blabla/blabla/nameOfTheFile.csv"
        ArrayList<String> contenido = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error" + e.getMessage());
        }
        return contenido;
    }//-------------------------------------------------------------------------
}
