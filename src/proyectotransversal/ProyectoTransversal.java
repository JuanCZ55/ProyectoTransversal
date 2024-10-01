package proyectotransversal;

import AccesoADatos.AlumnoData;
import Entidades.Alumno;
import java.time.LocalDate;

public class ProyectoTransversal {

    public static void main(String[] args) {
        Alumno juanc = new Alumno(43057480, "Zegarra", "Juan Cruz", LocalDate.of(2000, 5, 9), true);
        AlumnoData alu =new AlumnoData();
        alu.guardarAlumno(juanc);
    }

}
