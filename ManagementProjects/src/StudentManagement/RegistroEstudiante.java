package GestionEstudiantes;

import ListaSimpleET.ListaSimple;
import ListaSimpleET.NodoSimple;
import ToolsJOption.tj;

public class RegistroEstudiante {

    private ListaSimple<Estudiante> ingles = new ListaSimple<>();
    private ListaSimple<Estudiante> matematicas = new ListaSimple<>();
    private ListaSimple<Estudiante> ciencias = new ListaSimple<>();
    private ListaSimple<Estudiante> programacion = new ListaSimple<>();

//-------------------------------------------------------------------------------------------------------------------------------
    public void registrarAlumnos() {
        String nombre = tj.String("Nombre del alumno");
        String id = tj.String("ID del alumno");
        float promedio = validarPromedio();
        Estudiante estudiante = new Estudiante(nombre, id, promedio);
        RegistrarCursos(estudiante);
    }

    private float validarPromedio() {
        float promedio;
        do {
            promedio = tj.Float("Promedio del alumno");
            if (promedio > 10 || promedio < 0) {
                tj.print("Promedio inválido, vuelva a generarlo");
            }
        } while (promedio > 10 || promedio < 0);
        return promedio;
    }

    private void RegistrarCursos(Estudiante estudiante) {
        int op = tj.Int("¿En qué curso está inscrito?:\n1.Inglés\n2.Matemáticas\n3.Ciencias\n4.Programación");
        switch (op) {
            case 1:
                ingles.agregarAlFinal(estudiante);
                break;
            case 2:
                matematicas.agregarAlFinal(estudiante);
                break;
            case 3:
                ciencias.agregarAlFinal(estudiante);
                break;
            case 4:
                programacion.agregarAlFinal(estudiante);
                break;
            default:
                tj.print("Opción no válida.");
                break;
        }
    }
//-----------------------------------------------------------------------------------------------------------------------    

    public void eliminar() {
        int op = tj.Int("¿En qué curso está inscrito?:\n1.Inglés\n2.Matemáticas\n3.Ciencias\n4.Programación");
        ListaSimple<Estudiante> curso = obtenerLista(op);
        if (!curso.estaVacia()) {
            String nombre = tj.String("Ingrese el nombre del estudiante a eliminar:");
            eliminarPorNombre(nombre, curso);
        } else {
            tj.print("No hay alumnos en esta clase");
        }
    }

    private ListaSimple<Estudiante> obtenerLista(int op) {
        switch (op) {
            case 1:
                return ingles;
            case 2:
                return matematicas;
            case 3:
                return ciencias;
            case 4:
                return programacion;
            default:
                return null;
        }
    }

    private void eliminarPorNombre(String nombre, ListaSimple<Estudiante> curso) {
        NodoSimple<Estudiante> actual = curso.inicio;
        while (actual != null) {
            if (actual.dato.getNombre().equals(nombre)) {
                curso.eliminarDato(actual.dato);
            }
            actual = actual.siguiente;
        }
    }

//---------------------------------------------------------------------------------------------------------------------
    public void buscarCurso() {
        int op = tj.Int("¿En qué curso está inscrito?:\n1.Inglés\n2.Matemáticas\n3.Ciencias\n4.Programación");
        ListaSimple<Estudiante> curso = obtenerLista(op);
        if (curso != null) {
            if (!curso.estaVacia()) {
                String nombre = tj.String("Ingrese el nombre del estudiante a buscar:");
                if (buscarEstudiante(nombre, curso)) {
                    tj.print("El alumno está inscrito en este curso.");
                } else {
                    tj.print("El alumno no se encuentra en este curso.");
                }
            } else {
                tj.print("No hay alumnos en esta clase");
            }
        } else {
            tj.print("Opción no válida.");
        }
    }

    private boolean buscarEstudiante(String nombre, ListaSimple<Estudiante> curso) {
        NodoSimple<Estudiante> actual = curso.inicio;
        while (actual != null) {
            if (actual.dato.getNombre().equals(nombre)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }
//---------------------------------------------------------------------------------------------------------------------

    public void ListaCursos() {
        int op = tj.Int("Alumnos del curso:\n1.Inglés\n2.Matemáticas\n3.Ciencias\n4.Programación");
        ListaSimple<Estudiante> curso = obtenerLista(op);
        if (curso != null) {
            if (!curso.estaVacia()) {
                curso.mostrarDatos();
            } else {
                tj.print("No hay alumnos en este curso.");
            }
        } else {
            tj.print("Opción no válida.");
        }
    }

}
