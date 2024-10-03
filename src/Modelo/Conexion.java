package Modelo;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static Conexion connection = null;

    private Conexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar Driver");

        }
    }

    public static Connection getConexion() {
        Connection con = null;

        if (connection == null) {
            connection = new Conexion();
        }

        try {
            con = DriverManager.getConnection("jdbc:mariadb://localhost/universidadulp_trasversal", "root", "");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: error al conectarse a la base de datos");
        }

        return con;
    }

}
