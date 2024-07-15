package GestionEstudiantes;

import ToolsJOption.tj;

public class Main {

    public static void main(String[] args) {
        RegistroEstudiante ob = new RegistroEstudiante();
        
        int op= 0;
        do {
            try {
                op = tj.Int("1. Registrar alumno\n2. Mostrar Alumnos\n3. Eliminar alumno\n4. Buscar alumno\n5. Salir");
                switch (op) {
                    case 1:
                        ob.registrarAlumnos();
                        break;
                    case 2:
                        ob.ListaCursos();
                        break;
                    case 3:
                        ob.eliminar();
                        break;
                    case 4:
                        ob.buscarCurso();
                        break;
                    case 5:
                        break;
                    default:
                        tj.print("Opción no válida.");
                        break;
                }
            } catch (Exception e) {
                tj.printError("ERROR");
            }
        } while (op != 5);
    }
}

