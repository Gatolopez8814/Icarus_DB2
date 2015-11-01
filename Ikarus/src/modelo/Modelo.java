package modelo;

import java.util.ArrayList;

public class Modelo {

    private static Modelo instancia = null;
    private ConexionMySql miConexion;
    private ManejadorArchivos miArchivos;
    public ManejadorRegistros registros;

    public static Modelo obtenerInstancia() {
        if (instancia == null) {
            instancia = new Modelo();
        }
        return instancia;
    }

    private Modelo() {
        miConexion = ConexionMySql.obtenerInstancia();
        miArchivos = ManejadorArchivos.obtenerInstancia();
    }

    public boolean cargarDesdeParametros(String UserName, String UserPass,
            String URL_File, String database, String table, char separator) {
        System.out.println("cargarDesdeParametros");
        if (!miConexion.isConexionPossible(UserName, UserPass)) {
            return false;
        }
        try {
            ArrayList<String> inserts = miArchivos.leerCSV(URL_File);
            if (inserts.isEmpty()) {
                return false;
            }
            registros = new ManejadorRegistros();
            System.out.println("contador? - " + registros.getContador());
            // contador en 0
            String statement;
            for (String data : inserts) {

                statement = "insert into " + database + "." + table + " value(";
                String[] value = data.split(separator + "");
                for (int i = 0; i < value.length; i++) {

                    statement += "'" + value[i] + "'";
                    if (i != value.length - 1) {
                        statement += ",";
                    }
                }
                statement += ");";
                //--------------------------------------- ACÁ LLEVA EL CONTADOR Y LOS ERRORES
                if (miConexion.noReturnStatementMySQL(UserName, UserPass, database, statement)) {
                    registros.setContador(registros.getContador() + 1);
                    System.out.println("contador? - " + registros.getContador());
                } else {
                    registros.setErrores(registros.getErrores() + 1);
                    System.out.println("ERROR DE REGISTRO! TOTAL= " + registros.getErrores());
                    registros.setContador(registros.getContador() + 1);
                    System.out.println("contador? - " + registros.getContador());
                }
            }
            miConexion.noReturnStatementMySQL(UserName, UserPass, database, "commit;");

        } catch (Exception e) {
        }
        return true;
    }

    public boolean cargarDesdeArchivo(String URL_par_File) {
        if (URL_par_File.isEmpty()) {
            return false;
        }
        String UserName = "", UserPass = "", dataBase = "", Table = "", URL_File = "";
        String separator;
        char s = ' ';
        ArrayList<String> param = miArchivos.leer(URL_par_File);
        for (String par : param) {
            //System.out.println(par);
            if (par.charAt(0) != '%') {
                System.out.println(par);
                switch (par.split("=")[0]) {
                    case "username":
                    case "nombreusuario":
                        UserName = getValue(par);
                        break;
                    case "userpass":
                    case "pass":
                    case "contraseña":
                    case "password":
                        UserPass = getValue(par);
                        break;
                    case "file":
                    case "archivo":
                        URL_File = getValue(par);
                        break;
                    case "database":
                    case "basedatos":
                        dataBase = getValue(par);
                        break;
                    case "table":
                    case "tabla":
                        Table = getValue(par);
                        break;
                    case "separator":
                    case "separador":
                        separator = getValue(par);
                        if (separator.length() > 1) {
                            return false;
                        }
                        s = separator.charAt(0);
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println(dataBase);
        System.out.println(Table);
        System.out.println(s);
        System.out.println(UserName);
        System.out.println(UserPass);
        System.out.println(URL_File);
        /*if ("".equals(dataBase) || "".equals(Table) || validaSeparador(s)
         || "".equals(UserName) || "".equals(UserPass) || "".equals(URL_File)) {
         return false;
         }*/
        return cargarDesdeParametros(UserName, UserPass, URL_File, dataBase, Table, s);
    }

    public boolean cargaSimultanea(String paths) {
        if (paths.contains(";")) {
            String rutas[] = paths.split(";");
            boolean todas = false;
            for (String ruta : rutas) {
                todas = cargarDesdeArchivo(ruta);
            }
            return todas;
        } else {
            return cargarDesdeArchivo(paths);
        }
    }

    private String getValue(String txt) {
        String value = "";
        char actual;
        try {
            txt = txt.split("=")[1];
            for (int i = 0; i < txt.length(); i++) {/*quita los espacios*/

                actual = txt.charAt(i);
                if (' ' != actual) {
                    value += actual;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error " + e.getMessage());
        }
        return value;
    }

//    private boolean validaSeparador(char s) {
//        String separator = s+"";
//        String t = ";,-/.\\=+*¿?¡!<>@#$&";
//        return t.contains(separator);
//    }
}
