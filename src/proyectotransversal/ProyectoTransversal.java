package proyectotransversal;

import AccesoADatos.AlumnoData;
import AccesoADatos.InscripcionData;
import AccesoADatos.MateriaData;
import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.time.LocalDate;

public class ProyectoTransversal {

    public static void main(String[] args) {
        Alumno juanc = new Alumno(43057480, "Zegarra", "Juan Cruz", LocalDate.of(2000, 5, 9), true);
        AlumnoData alu =new AlumnoData();
        alu.guardarAlumno(juanc);
        
        Materia materia1 = new Materia("matematica", 1, true);
        MateriaData mat = new MateriaData();
        mat.guardarMateria(materia1);
        
        Inscripcion inc = new Inscripcion(juanc, materia1, 10);
        InscripcionData incData = new InscripcionData();
        incData.inscripcionAluMat(juanc, materia1, inc);
    }

}
