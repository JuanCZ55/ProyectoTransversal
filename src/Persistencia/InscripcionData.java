package Persistencia;

import Modelo.Conexion;
import Modelo.Alumno;
import Modelo.Inscripcion;
import Modelo.Materia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;

public class InscripcionData {
    private Connection con = null;
    
    public InscripcionData(){
        con= (Connection) Conexion.getConexion();
    }
    
    public void inscripcionAluMat(Inscripcion inscripcion){
        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (?, ?, ?)";
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
    
    }