package Persistencia;

import Modelo.Conexion;
import Modelo.Materia;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;

public class MateriaData {

    private Connection con = null;

    public MateriaData() {
        con = (Connection) Conexion.getConexion();
    }

    public void guardarMateria(Materia materia) {
        String sql = "INSERT INTO materia (nombre, año_De_cursada, estado) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia guardada exitosamente.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la materia: " + ex.getMessage());
        }
    }

    public void actualizarMateria(Materia mate) {
        String sql = "UPDATE materia SET nombre=?, año_De_cursada=? WHERE id_Materia=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mate.getNombre());
            ps.setInt(2, mate.getAnioMateria());
            ps.setInt(3, mate.getIdMateria());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia Modificada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder al actualizar materia");
        }
    }

    public void bajaLogica(int id) {
        String sql = "UPDATE materia SET estado = 0 WHERE id_Materia=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se dio de baja la Materia " + id);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de baja la materia");
        }
    }

    public void altaLogica(int id) {
        String sql = "UPDATE materia SET estado = 1 WHERE id_Materia=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se activo la Materia " + id);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar el alta a la materia");
        }
    }

    public Materia buscarMateria(int id) {
        String sql = "SELECT nombre, año_De_cursada, estado FROM materia WHERE id_Materia=?";
        Materia mate = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                mate = new Materia();
                mate.setIdMateria(id);
                mate.setNombre(rs.getString("nombre"));
                mate.setAnioMateria(rs.getInt("año_De_cursada"));
                mate.setActivo(rs.getInt("estado") == 1);
            } else {
                JOptionPane.showMessageDialog(null, "No existe esa Materia");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumnos");
        }
        return mate;
    }

    public void eliminarMateria(int id) {
        String sql = "DELETE FROM materia WHERE id_Materia=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro la Materia");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }
    }
    
     public ArrayList<Materia> listarMaterias() {
        String sql = "SELECT * FROM materia ";
        int x = 0;
        Materia mate = null;
        ArrayList<Materia> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                mate = new Materia();
                mate.setIdMateria(rs.getInt("id_Materia"));
                mate.setNombre(rs.getString("nombre"));
                mate.setAnioMateria(rs.getInt("año_De_cursada"));
                mate.setActivo(rs.getInt("estado") == 1);

                lista.add(mate);
                x++;
            }
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "No hay Materias");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }

        return lista;
    }
}
