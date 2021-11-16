package co.edu.ucentral.ingsf.springprime.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ManejadorConexion {
//    sqlite:
    private final String URL = "myhotelreservation.db";

//    postgress:
    private final String BASEDATOS = "myhotelreservationdatabase";
    private final String USUARIO = "postgres";
    private final String CLAVE = "2ccd22b661623";

    public Connection conectarseSQLite (){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:"+URL);
//            log.info("Se conecto a SQLLITE");
            return conexion;
        } catch (ClassNotFoundException | SQLException e) {
//            log.error("Informa error",e);
            System.out.println(""+e);
        }
        return null;
    }

    public Connection conectarsePostgres (){
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/"+BASEDATOS, USUARIO, CLAVE);
//            log.info("Se conecto a postgres");
            return conexion;
        } catch (ClassNotFoundException | SQLException e) {
//            log.error("Informa error",e);
            System.out.println(e);
        }
        return null;
    }


    public void desconexion(Connection conexion){
        if (conexion!= null){
            try {
                conexion.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}
