package modelo;

import java.util.ArrayList;

public class Modelo {

    private static Modelo instancia = null;
    private ConexionMySql miConexion;
    private ManejadorArchivos miArchivos;

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
            String statement;            
            for(String data:inserts){
                statement= "insert into "+ database+"."+table+" value(";
                String[] value=data.split(separator+"");
                for(int i=0;i<value.length;i++){
                    statement+="'"+value[i]+"'";
                    if(i!=value.length-1){
                        statement+=",";
                    }
                }
                statement+=");";
                 miConexion.noReturnStatementMySQL(UserName, UserPass, database, statement);
            }
             miConexion.noReturnStatementMySQL(UserName, UserPass, database, "commit;");
           
        } catch (Exception e) {
        }
        return true;
    }

    public boolean cargarDesdeArchivo(String URL_par_File) {
        if ("".equals(URL_par_File)) {
            return false;
        }
        String UserName = "", UserPass = "", dataBase = "", Table = "", URL_File = "";
        String sep;
        char separator = ' ';
        try {
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
                            sep = getValue(par);
                            if (sep.length() > 1) {
                                return false;
                            }
                            separator = sep.charAt(0);
                            break;
                        default:
                            //error
                            return false;
                    }
                }
            }
        } catch (Exception e) {
        }
         System.out.println("va a llegar2");
          System.out.println(dataBase);
          System.out.println(Table);
          System.out.println(separator);
          System.out.println(UserName);
          System.out.println(UserPass);
          System.out.println(URL_File);         
        /*if ("".equals(dataBase) || "".equals(Table) || validaSeparador(separator)
                || "".equals(UserName) || "".equals(UserPass) || "".equals(URL_File)) {
            return false;
        }*/
        System.out.println("va a llegar");
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
            case '\\':
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
