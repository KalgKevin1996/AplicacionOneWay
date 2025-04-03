package aplicacion_oneway.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/tuctucdb";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "sasa";

    public static Connection conectar() throws SQLException{
        return DriverManager.getConnection(URL,USUARIO,PASSWORD);
    }
}
