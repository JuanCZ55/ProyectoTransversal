package Persistencia;

import Modelo.Conexion;
import Modelo.Alumno;
import Modelo.Inscripcion;
import Modelo.Materia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;

public class InscripcionData {

    private Connection con = null;
    private MateriaData md = new MateriaData();
    private AlumnoData ad = new AlumnoData();

    public InscripcionData() {
        con = (Connection) Conexion.getConexion();
    }

    public void inscripcionAluMat(Inscripcion inscripcion) {
        String sql = "INSERT INTO inscripcion (nota, id_Alumno, id_Materia) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, inscripcion.getNota());
            ps.setInt(2, inscripcion.getAlumno().getIdAlumno());
            ps.setInt(3, inscripcion.getMateria().getIdMateria());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                inscripcion.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion guardada exitosamente.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la Inscripcion: " + ex.getMessage());
        }
    }

    public int actualizarNota(int idAlum, int idMater, double nota) {
        String sql = "UPDATE inscripcion SET nota = ? WHERE id_Alumno = ? AND  id_Materia = ? ";
        int filas = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlum);
            ps.setInt(3, idMater);
            filas = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la nota");
        }
        
        return filas;
    }

    public void borrarInscripcion(int idAlum, int idMate) {
        String sql = "DELETE FROM inscripcion WHERE id_Alumno = ? AND  id_Materia = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlum);
            ps.setInt(2, idMate);
            int exito = ps.executeUpdate();
            if (exito > 0) {
                JOptionPane.showMessageDialog(null, "Inscripcion Eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro la Inscripcion");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al borrar la nota");
        }

    }

    public ArrayList<Inscripcion> listaInscripciones() {
        ArrayList<Inscripcion> lista = new ArrayList<>();
        String sql = "SELECT id_Inscripcion,COALESCE(nota,0) AS nota,id_Alumno,id_Materia FROM inscripcion";
        /*La consulta usa COALESCE para reemplazar valores null en 'nota' por 0*/
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion ins = new Inscripcion();
                ins.setIdInscripcion(rs.getInt("id_Inscripcion"));
                ins.setNota(rs.getDouble("nota"));
                ins.setAlumno(ad.buscarAlumId(rs.getInt("id_Alumno")));
                ins.setMateria(md.buscarMateria(rs.getInt("id_Materia")));
                lista.add(ins);
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las inscripciones");
        }

        return lista;
    }

    public ArrayList<Inscripcion> listaInscriPorAlum(int idAlumno) {
        ArrayList<Inscripcion> lista = new ArrayList<>();
        String sql = "SELECT id_Inscripcion,COALESCE(nota,0) AS nota,id_Alumno,id_Materia FROM inscripcion WHERE id_Alumno=?";
        /*La consulta usa COALESCE para reemplazar valores null en 'nota' por 0*/
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion ins = new Inscripcion();
                ins.setIdInscripcion(rs.getInt("id_Inscripcion"));
                ins.setNota(rs.getDouble("nota"));
                ins.setAlumno(ad.buscarAlumId(rs.getInt("id_Alumno")));
                ins.setMateria(md.buscarMateria(rs.getInt("id_Materia")));
                lista.add(ins);
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las inscripciones por Alum");
        }

        return lista;
    }

    public ArrayList<Materia> listaMateInscr(int idAlumno) {
        ArrayList<Materia> listaMate = new ArrayList<>();

        String sql = "SELECT i.id_Materia,nombre, año_De_cursada,estado  FROM inscripcion i JOIN materia m ON i.id_Materia =m.id_Materia WHERE i.id_Alumno=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia mate = new Materia();

                mate.setIdMateria(rs.getInt("id_Materia"));
                mate.setNombre(rs.getString("nombre"));
                mate.setAnioMateria(rs.getInt("año_De_cursada"));
                mate.setActivo(rs.getInt("estado") == 1);
                listaMate.add(mate);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Listar Materias Inscriptas");
        }

        return listaMate;
    }

    public ArrayList<Materia> listaMateNoInscr(int idAlumno) {
        ArrayList<Materia> listaMate = new ArrayList<>();

        String sql = "SELECT * FROM materia WHERE estado=1 AND id_Materia not in (SELECT id_Materia FROM inscripcion WHERE id_Alumno=?) ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia mate = new Materia();

                mate.setIdMateria(rs.getInt("id_Materia"));
                mate.setNombre(rs.getString("nombre"));
                mate.setAnioMateria(rs.getInt("año_De_cursada"));
                mate.setActivo(rs.getInt("estado") == 1);
                listaMate.add(mate);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Listar Materias No Inscriptas");
        }

        return listaMate;
    }

    public ArrayList<Alumno> listaAlumXMate(int idMateria) {
        ArrayList<Alumno> lista = new ArrayList<>();
        String sql = "SELECT a.id_Alumno,dni,nombre,apellido,fecha_Nacimiento,estado"
                + " FROM inscripcion i,alumno a WHERE i.id_Alumno=a.id_Alumno AND id_Materia=? AND a.estado=1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alum = new Alumno();
                alum.setIdAlumno(rs.getInt("id_Alumno"));
                alum.setDni(rs.getInt("dni"));
                alum.setApellido(rs.getString("apellido"));
                alum.setNombre(rs.getString("nombre"));
                alum.setFechaNac(rs.getDate("fecha_Nacimiento").toLocalDate());
                alum.setActivo(true);
                lista.add(alum);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Listar Alumnos por Materia ");
        }

        return lista;
    }
    
    public ArrayList<Alumno> listaInscripcionesAlumnoUnicos() {
        
        ArrayList<Alumno> lista = new ArrayList<>();
        String sql = "SELECT DISTINCT id_Alumno FROM inscripcion";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               Alumno alum = new Alumno();
               alum = ad.buscarAlumId(rs.getInt("id_Alumno"));
                lista.add(alum);
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las inscripciones");
        }

        return lista;
    }

}
