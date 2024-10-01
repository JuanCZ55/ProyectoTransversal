package AccesoADatos;

import java.sql.*;
import Entidades.Alumno;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;

public class AlumnoData {

    private Connection con = null;

    public AlumnoData() {
        con = (Connection) Conexion.getConexion();
    }

    public void guardarAlumno(Alumno alum) {
        String sql = "INSERT INTO alumno( dni, apellido, nombre, fecha_Nacimiento, estado)"
                + " VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alum.getDni());
            ps.setString(2, alum.getApellido());
            ps.setString(3, alum.getNombre());
            ps.setDate(4, Date.valueOf(alum.getFechaNac()));
            ps.setBoolean(5, alum.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alum.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno Guardado Existosamente pa");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
        }

    }
}
