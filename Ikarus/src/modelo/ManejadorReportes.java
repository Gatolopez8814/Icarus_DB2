package modelo;

import java.util.ArrayList;
import java.util.Date;

public class ManejadorReportes {

    private static ManejadorReportes instancia = null;
    private String nombre;
    private ArrayList<String> errores;
    private ArrayList<String> log;

    private ManejadorReportes() {
        nombre = "";
        errores = new ArrayList<>();
        log = new ArrayList<>();
    }

    public static ManejadorReportes obtenerInstancia() {
        if (instancia == null) {
            instancia = new ManejadorReportes();
        }
        return instancia;
    }

    public void agregarEntradaLog(String entrada) {
        Date fecha = new Date();
        log.add(fecha + " | " + entrada);
    }

    public void agregarError(String entrada) {
        Date fecha = new Date();
        log.add(fecha + " | " + entrada);
        errores.add(fecha + " | " + entrada);
    }

    public void imprimir() {
        ManejadorArchivos archivos = ManejadorArchivos.obtenerInstancia();
         if (!nombre.isEmpty()) {
            archivos.CrearArchivo(nombre + ".log");
            archivos.guardar(nombre + ".log", log);
         }
        if (!errores.isEmpty()) {
            archivos.CrearArchivo(nombre + ".bad");
            archivos.guardar(nombre + ".bad", errores);
        }
        log.clear();
        errores.clear();
    }

    public void setNombre(String nombre) {
        imprimir();
        this.nombre = CreateName(nombre);
    }

    public String CreateName(String Path_and_name) {
        String result = "";
        for (int i = 0; i < Path_and_name.length() - 4; i++) {//remove .ext
            result += Path_and_name.charAt(i);
        }
        return result;
    }

}
