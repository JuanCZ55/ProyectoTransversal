package Persistencia;

import Modelo.Conexion;
import java.sql.*;
import Modelo.Alumno;
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

    public void actualizarAlumno(Alumno alum) {
        String sql = "UPDATE alumno SET dni=?,apellido=?,nombre=?,fecha_Nacimiento=? WHERE id_Alumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alum.getDni());
            ps.setString(2, alum.getApellido());
            ps.setString(3, alum.getNombre());
            ps.setDate(4, Date.valueOf(alum.getFechaNac()));
            ps.setInt(5, alum.getIdAlumno());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno Modificado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
        }
    }

    public void bajaLogica(int id) {
        String sql = "UPDATE alumno SET estado = 0 WHERE id_Alumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno Eliminado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
        }
    }

    public void altaLogica(int id) {
        String sql = "UPDATE alumno SET estado = 1 WHERE id_Alumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno Activo");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
        }
    }

    public Alumno buscarAlumno(int id) {
        String sql = "SELECT dni, apellido, nombre, fecha_Nacimiento FROM alumno WHERE id_Alumno = ? AND estado = 1";
        Alumno alumno = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fecha_Nacimiento").toLocalDate());
                alumno.setActivo(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese Alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
        }
        return alumno;
    }

    public void eliminarAlumno(int id) {
        String sql = "DELETE FROM alumno WHERE id_Alumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el alumno");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
        }
    }
}
