package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ManejadorArchivos {

    private static ManejadorArchivos instancia = null;
    

    private ManejadorArchivos() {        
    }

    public static ManejadorArchivos obtenerInstancia() {
        if (instancia == null) {
            instancia = new ManejadorArchivos();
        }
        return instancia;
    }

    public ArrayList<String> leer(String nombreArchivo) {//"src/vocabulario.txt"
        ManejadorReportes reportes= ManejadorReportes.obtenerInstancia();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<String> lista = new ArrayList<>();
        try {
            archivo = new File(nombreArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {                
                lista.add(linea);
            }
        } catch (IOException e) {
            reportes.agregarError("Error al leer el archivo "+ nombreArchivo+ e.getMessage());
            System.err.println("Error al leer el archivo "+ nombreArchivo+ e.getMessage());
        }
        return lista;
    }//-------------------------------------------------------------------------

    public void guardar(String nombreArchivo, ArrayList<String> contenido) {//"src/vocabulario.txt"
        ManejadorReportes reportes= ManejadorReportes.obtenerInstancia();
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(nombreArchivo);
            pw = new PrintWriter(fw);
            for (int i = 0; i < contenido.size(); i++) {
                pw.println(contenido.get(i));
            }
        } catch (IOException e) {
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                reportes.agregarError("Error al leer el archivo "+ nombreArchivo+ e.getMessage());
            }
        }
    }//-------------------------------------------------------------------------

    public void guardarSinBorrar(String nombreArchivo, ArrayList<String> contenido) {//"src/vocabulario.txt"
        ManejadorReportes reportes= ManejadorReportes.obtenerInstancia();
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(nombreArchivo, true);
            pw = new PrintWriter(fw);
            for (int i = 0; i < contenido.size(); i++) {
                pw.println(contenido.get(i));
            }
        } catch (IOException e) {
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                reportes.agregarError("Error al leer el archivo "+ nombreArchivo+ e.getMessage());
            }
        }
    }//-------------------------------------------------------------------------

    public void borrarContenidoArchivo(String nombreArchivo) {
        ManejadorReportes reportes= ManejadorReportes.obtenerInstancia();
        File archivo = new File(nombreArchivo);
        if (archivo.exists() && archivo.delete()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                reportes.agregarError("Error en archivo "+ nombreArchivo+ e.getMessage());
            }
        }
    }//-------------------------------------------------------------------------

    public void borrarArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);//"src/archivos/" + nombreArchivo + ".txt"
        if (archivo.exists()) {
            archivo.delete();
        }
    }//-------------------------------------------------------------------------

    public void CrearArchivo(String nombreArchivo) {//"src/archivos/" + nombreArchivo + ".txt"
        ManejadorReportes reportes= ManejadorReportes.obtenerInstancia();
        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                reportes.agregarError("Error al crear el archivo "+ nombreArchivo+ e.getMessage());
            }
        }
    }//-------------------------------------------------------------------------

    public ArrayList<String> leerCSV(String nombreArchivo) {//"blabla/blabla/nameOfTheFile.csv"
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
}//end class
