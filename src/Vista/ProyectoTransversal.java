package Vista;

import Modelo.Alumno;
import Modelo.Materia;
import Persistencia.AlumnoData;
import Persistencia.MateriaData;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ProyectoTransversal {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int aux;
        Alumno juanc = new Alumno(44567879, "Zegarra", "Juan Cruz", LocalDate.of(2000, 5, 9), true);
        Alumno ariel = new Alumno(44993241, "Miranda Salmin", "Ariel Ismael", LocalDate.of(2003, 9, 27), true);
        Alumno leandro = new Alumno(00000000, "Troncoso", "Leandro", LocalDate.of(2000, 2, 9), true);
        Alumno zoe = new Alumno(00000001, "Lucero", "Zoe", LocalDate.of(2001, 2, 9), true);
        Alumno miguel = new Alumno(00000002, "Orozco", "Miguel", LocalDate.of(2002, 2, 9), true);
        Alumno alumnoParaEliminar = new Alumno(99999999, "Apellido", "Nombre", LocalDate.of(2000, 2, 9), true);
        
        AlumnoData alu = new AlumnoData();
        MateriaData materiaData = new MateriaData();
        
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
         
        System.out.println("Lista De Alumnos:\n");
       
        for (Alumno al :  alu.listarAlumnos()) {
            System.out.println(al.toString());
        }
        
        // test para algunas materias
        Materia matematicas = new Materia("Matemáticas", 2024, true);
        Materia fisica = new Materia("Física", 2024, true);
        Materia quimica = new Materia("Química", 2024, true);
        Materia historia = new Materia("Historia", 2024, true);
        Materia biologia = new Materia("Biología", 2024, true);
      
        System.out.println("<--------------------------------------------->");
        System.out.println("Se guardan las materias");
        materiaData.guardarMateria(matematicas);
        materiaData.guardarMateria(fisica);
        materiaData.guardarMateria(quimica);
        materiaData.guardarMateria(historia);
        materiaData.guardarMateria(biologia);

     
        System.out.println("<--------------------------------------------->");
        System.out.println("Se actualizará una materia\nDigite la ID de la materia: ");
        aux = entrada.nextInt();
        materiaData.actualizarMateria(new Materia(aux, "Matemáticas Avanzadas", 2024, true));

        
        System.out.println("<--------------------------------------------->");
        System.out.println("Se da baja una materia\nDigite la ID de la materia: ");
        aux = entrada.nextInt();
        materiaData.bajaLogica(aux);

       
        System.out.println("<--------------------------------------------->");
        System.out.println("Alta de una materia\nDigite la ID de la materia: ");
        aux = entrada.nextInt();
        materiaData.altaLogica(aux);

       
        System.out.println("<--------------------------------------------->");
        System.out.println("Se buscará una materia\nDigite la ID de la materia: ");
        aux = entrada.nextInt();
        Materia materiaEncontrada = materiaData.buscarMateria(aux);
        if (materiaEncontrada != null) {
            System.out.println("Materia \n" + materiaEncontrada.toString());
        }else{
            System.out.println("La Materia con ID "+ aux +" no se a encontrado");
        }

        System.out.println("<--------------------------------------------->");
        System.out.println("Se eliminará una materia\nDigite la ID de la materia: ");
        aux = entrada.nextInt();
        materiaData.eliminarMateria(aux);
        
      
        System.out.println("<--------------------------------------------->");
        System.out.println("Lista de Materias:\n");
        for (Materia mate : materiaData.listarMaterias()) {
            System.out.println(mate.toString());
        }
    }
}
