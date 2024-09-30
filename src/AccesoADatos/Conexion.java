package AccesoADatos;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost/";
    private static final String DB = "universidadulp_trasversal";
    private static final String USUARIO = "root";
    private static String PASSWORD = "";

    private static Connection connection;

    private Conexion() {
    }

    public static Connection getConexion() {
        if (connection == null) {
            try {
                Class.forName("org.mariadb.jdbc.Drivers");
                connection = DriverManager.getConnection(URL+DB+"?useLegacyDatatimeCode=false&serverTimezone=UTC"
                        +"&user="+USUARIO+"&password="+PASSWORD);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: error al conectars a la base de datos");
            } catch (ClassNotFoundException c) {
                JOptionPane.showMessageDialog(null, "Error: error al cargar los drivers");
            }
        }
        return connection;
    }

}
