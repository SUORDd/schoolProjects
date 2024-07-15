package GestionContactos;

import ToolsJOption.tj;

public class Main {

    public static void main(String[] args) {
        RegistrarContactos ob = new RegistrarContactos();

        int op = 0;

        do {
            try {
                op=tj.Int("1. Registrar contacto\n2. Editar contacto\n3. Mostrar contactos"
                        + "\n4. Buscar contacto\n5. Eliminar contacto\n6. Salir");
                switch (op) {
                    case 1:
                        ob.registrarContacto();
                        break;
                    case 2:
                        ob.editarContacto();
                        break;
                    case 3:
                        ob.mostrarDatos();
                        break;
                    case 4:
                        ob.buscarContacto();
                        break;
                    case 5:
                        ob.eliminarContacto();
                        break;
                    case 6:
                        break;
                    default:
                        tj.print("Opcion Incorrecta");
                }

            } catch (Exception e) {
                tj.printError("Error de caracter");
            }
        } while (op != 6);

    }
}
