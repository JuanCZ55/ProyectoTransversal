package Vista;

import Modelo.Alumno;
import Persistencia.AlumnoData;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ProyectoTransversal {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int aux;
        Alumno juanc = new Alumno(43057480, "Zegarra", "Juan Cruz", LocalDate.of(2000, 5, 9), true);
        Alumno ariel = new Alumno(44993241, "Miranda Salmin", "Ariel Ismael", LocalDate.of(2003, 9, 27), true);
        Alumno leandro = new Alumno(00000000, "Troncoso", "Leandro", LocalDate.of(2000, 2, 9), true);
        Alumno zoe = new Alumno(00000001, "Lucero", "Zoe", LocalDate.of(2001, 2, 9), true);
        Alumno miguel = new Alumno(00000002, "Orozco", "Miguel", LocalDate.of(2002, 2, 9), true);
        Alumno alumnoParaEliminar = new Alumno(99999999, "Apellido", "Nombre", LocalDate.of(2000, 2, 9), true);
        
        AlumnoData alu = new AlumnoData();
        
        System.out.println("<--------------------------------------------->");
        System.out.println("Se agregaran los alumnos");
        alu.guardarAlumno(juanc);
        alu.guardarAlumno(ariel);
        alu.guardarAlumno(leandro);
        alu.guardarAlumno(zoe);
        alu.guardarAlumno(miguel);
        alu.guardarAlumno(alumnoParaEliminar);
        
        System.out.println("<--------------------------------------------->");
        System.out.println("Se actualizara un alumno\nDigite la id del alumno: ");
        aux = entrada.nextInt();
        alu.actualizarAlumno(new Alumno(aux, 12121212, "Actualizar", "Alumno", LocalDate.of(2003, 9, 27), true));

        System.out.println("<--------------------------------------------->");
        System.out.println("Se dara de baja un alumno\nDigite la id del alumno: ");
        aux = entrada.nextInt();
        alu.bajaLogica(aux);
        
        System.out.println("<--------------------------------------------->");
        System.out.println("Se habilitara un alumno\nDigite la id del alumno: ");
        aux = entrada.nextInt();
        alu.altaLogica(aux);
        
        System.out.println("<--------------------------------------------->");
        System.out.println("Se buscara un alumno\nDigite la id del alumno: ");
        aux = entrada.nextInt();
        Alumno alumnoEncontrado = alu.buscarAlumno(aux);
        if (alumnoEncontrado != null) {
            System.out.println("Alumno \n" + alumnoEncontrado.toString());
        }
        
        System.out.println("<--------------------------------------------->");
        System.out.println("Se eliminara un alumno\nDigite la id del alumno: ");
        aux = entrada.nextInt();
        alu.eliminarAlumno(aux);
        System.out.println("<--------------------------------------------->");
    }
}
