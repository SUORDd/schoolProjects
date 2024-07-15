package GestionTareas;

import ToolsJOption.tj;

public class Main {

    public static void main(String[] args) {
        Tareas ob=new Tareas();
        int op = 0;
        do {
            try {
                op = tj.Int("1. Mandar Invitaciones\n2. Reservar lugar"
                        + "\n3. Añadir Proveedores\n4. Mostrar Invitados\n5."
                        + " Marcar como completada\n6. Salir");
                switch (op) {
                    case 1:
                        ob.agregarInvitado();
                        break;
                    case 2:
                        ob.añadirLugar();
                        break;
                    case 3:
                        ob.añadirProveedores();
                        break;
                    case 4:
                        ob.mostrarInvitados();
                        break;
                    case 5:
                        ob.marcarCompletado();
                        break;
                    case 6:
                        break;
                    default:
                        tj.print("Opcion Incorrecta");
                }
            } catch (Exception e) {
                tj.print("Caracter Incorrecto");
            }
        } while (op != 6);
    }

}
