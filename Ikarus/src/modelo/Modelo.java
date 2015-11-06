package modelo;

import Interfaz.PaginaPrincipal;
import java.util.ArrayList;

public class Modelo {

    private static Modelo instancia = null;
    private ConexionMySql miConexion;
    private ManejadorArchivos miArchivos;
    private ManejadorReportes reportes;

    public static Modelo obtenerInstancia() {
        if (instancia == null) {
            instancia = new Modelo();
        }
        return instancia;
    }

    public Modelo() {
        miConexion = ConexionMySql.obtenerInstancia();
        miArchivos = ManejadorArchivos.obtenerInstancia();
        reportes = ManejadorReportes.obtenerInstancia();
    }

    public boolean cargarDesdeParametros(String UserName, String UserPass,
            String URL_File, String database, String table, char separator) {
        reportes.setNombre(URL_File);//imprime y limpiareporte del parfile y crea el nuevo
        reportes.agregarEntradaLog("cargando ");
        if (!miConexion.isConexionPossible(UserName, UserPass)) {
            reportes.agregarError("error de coneccion");
            reportes.imprimir();
            return false;
        }
        try {
            ArrayList<String> inserts = miArchivos.leerCSV(URL_File);
            if (inserts.isEmpty()) {
                reportes.agregarError("error en " + URL_File + " archivo vacio");
                reportes.imprimir();
                return false;
            }
            String statement;
            for (String data : inserts) {
                if (!data.isEmpty()) {
                    //System.out.println(data);
                    statement = "insert into " + database + "." + table + " value(";
                    String[] value = data.split(separator + "");
                    for (int i = 0; i < value.length; i++) {
                        statement += "'" + value[i] + "'";
                        if (i != value.length - 1) {
                            statement += ",";
                        }
                    }
                    statement += ");";
                    //--------------------------------------- ACÁ LLEVA LOS CORRECTOS Y LOS ERRORES
                    //System.out.println("@= " + statement);
                    if (miConexion.noReturnStatementMySQL(UserName, UserPass, database, statement)) {
                        reportes.agregarEntradaLog("entrada ingresado correctamente");
                    } else {
                        reportes.agregarEntradaLog("error ingresado entrada");
                    }
                }

            }
            //miConexion.noReturnStatementMySQL(UserName, UserPass, database, "commit;");
        } catch (Exception e) {
            reportes.agregarError(e.getMessage());
        }
        reportes.agregarEntradaLog(" carga terminada");
        reportes.imprimir();
        PaginaPrincipal.obtenerInstancia().update(null);
        return true;
    }

    public boolean cargarDesdeArchivo(String URL_par_File) {
        reportes.setNombre(URL_par_File);
        if ("".equals(URL_par_File)) {
            reportes.agregarError(" error con el archivo de parametros");
            return false;
        }
        String UserName = "", UserPass = "", dataBase = "", Table = "", URL_File = "";
        String sep;
        char separator = ',';
        try {
            ArrayList<String> param = miArchivos.leer(URL_par_File);
            for (String par : param) {
                reportes.agregarEntradaLog(" Leyendo parfile");
                reportes.agregarEntradaLog(" linea | " + par);
                if (par.charAt(0) != '%') {
                    switch (par.split("=")[0]) {
                        case "username":
                        case "nombreusuario":
                            UserName = getValue(par);
                            reportes.agregarEntradaLog(" Nombre de usuario identificado  | " + UserName);
                            break;
                        case "userpass":
                        case "pass":
                        case "contraseña":
                        case "password":
                            UserPass = getValue(par);
                            reportes.agregarEntradaLog(" contraseña identificado  | " + UserPass);
                            break;
                        case "file":
                        case "archivo":
                            URL_File = getValue(par);
                            reportes.agregarEntradaLog(" URL_File identificado  | " + URL_File);
                            break;
                        case "database":
                        case "basedatos":
                            dataBase = getValue(par);
                            reportes.agregarEntradaLog(" dataBase identificado  | " + dataBase);
                            break;
                        case "table":
                        case "tabla":
                            Table = getValue(par);
                            reportes.agregarEntradaLog(" tabla identificado  | " + Table);
                            break;
                        case "separator":
                        case "separador":
                            sep = getValue(par);
                            if (sep.length() > 1) {
                                reportes.agregarError(" separador NO identificado  | " + sep);
                                reportes.imprimir();
                                return false;
                            }
                            separator = sep.charAt(0);
                            reportes.agregarEntradaLog(" separador identificado  | " + sep);
                            break;
                        default:
                            reportes.agregarError(" Parametro desconocido en Parfile");
                            reportes.imprimir();
                            return false;
                    }
                }
            }
        } catch (Exception e) {
            reportes.agregarError(e.getMessage());
        }
        if (UserName.isEmpty() || UserPass.isEmpty() || URL_File.isEmpty()
                || dataBase.isEmpty() || Table.isEmpty()) {
            return false;
        }
        return cargarDesdeParametros(UserName, UserPass, URL_File, dataBase, Table, separator);
    }

    private String getValue(String txt) {
        txt = txt.split("=")[1];
        String value = "";
        char actual;
        for (int i = 0; i < txt.length(); i++) {/*quita los espacios*/

            actual = txt.charAt(i);
            if (' ' != actual) {
                value += actual;
            }
        }
        return value;
    }

    private boolean validaSeparador(char separator) {
        switch (separator) {
            case ';':
            case ',':
            case '-':
            case '/':
            case '.':
            case '=':
            case '+':
            case '*':
            case '?':
            case '¿':
            case '!':
            case '¡':
            case '<':
            case '>':
            case '&':
            case '#':
            case '$':
            case '@':
                return true;
        }
        return true;
    }
}
