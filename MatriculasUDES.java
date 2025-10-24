import java.util.ArrayList;
import java.util.List;

public class MatriculasUDES {

    public static class Estudiante {
        String nombre;

        public Estudiante(String nombre) {
            this.nombre = nombre;
        }
    }

    public static class Materia {
        String nombre;
        int creditos;
        String tipo;

        public Materia(String nombre, int creditos, String tipo) {
            this.nombre = nombre;
            this.creditos = creditos;
        }
    }

    public static class Profesor {
        String nombre;

        public Profesor(String nombre) {
            this.nombre = nombre;
        }
    }

    public static class Salon {
        String nombre;

        public Salon(String nombre) {
            this.nombre = nombre;
        }
    }

    public static class Matricula {
        Estudiante estudiante;
        String semestre;
        List<Materia> detalleMaterias; 

        public Matricula(Estudiante estudiante, String semestre) {
            this.estudiante = estudiante;
            this.semestre = semestre;
            this.detalleMaterias = new ArrayList<>();
        }
        
        public void agregarMateria(Materia materia) {
            this.detalleMaterias.add(materia); 
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            s.append("Matrícula de ").append(estudiante.nombre);
            s.append(" (").append(semestre).append(")\n");
            s.append("  Materias: (").append(detalleMaterias.size()).append(")\n");
            
            for (Materia m : detalleMaterias) {
                s.append("    - ").append(m.nombre).append(" (").append(m.creditos).append(" créditos)\n");
            }
            return s.toString();
        }
    }


    public static void main(String[] args) {
        
        List<Estudiante> estudiantes = new ArrayList<>();
        List<Materia> catalogoMaterias = new ArrayList<>();
        List<Profesor> profesores = new ArrayList<>();
        List<Salon> salones = new ArrayList<>();
        List<Matricula> registroMatriculas = new ArrayList<>();

        Estudiante ana = new Estudiante("Ana Lopez");
        Estudiante beto = new Estudiante("Beto Perez");
        estudiantes.add(ana);
        estudiantes.add(beto);
        
        Materia poo = new Materia("POO", 4, "PRO");
        Materia calculo = new Materia("Calculo I", 3, "BAS");
        Materia deporte = new Materia("Deporte", 2, "ELE");
        catalogoMaterias.add(poo);
        catalogoMaterias.add(calculo);
        catalogoMaterias.add(deporte);

        profesores.add(new Profesor("Dr. Sosa"));
        salones.add(new Salon("S201"));

        Matricula matAna = new Matricula(ana, "2025-1");
        matAna.agregarMateria(poo);
        matAna.agregarMateria(calculo);
        registroMatriculas.add(matAna);

        Matricula matBeto = new Matricula(beto, "2025-1");
        matBeto.agregarMateria(poo);
        matBeto.agregarMateria(deporte);
        registroMatriculas.add(matBeto);

        System.out.println("--- REGISTRO DEL SISTEMA ---");
        System.out.println("Total de estudiantes: " + estudiantes.size());
        System.out.println("Total de materias en catálogo: " + catalogoMaterias.size());
        
        System.out.println("\n--- DETALLE DE MATRÍCULAS ---");
        for (Matricula m : registroMatriculas) {
            System.out.println(m.toString());
        }
    }
}