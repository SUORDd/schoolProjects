package ReproductorMusica;

import ToolsJOption.tj;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        RegistrarCanciones ob = new RegistrarCanciones();
        int op = 0;
        do {
        
            try {
                op = tj.Int("1. Agregar PlayList\n2. Agregar canciones\n3. Mostrar Canciones"
                        + "\n4. Reproducir canciones\n5. Eliminar cancion\n6. Salir");
                switch (op) {
                    case 1:
                        ob.agregarPlayList();
                        break;
                    case 2:
                        ob.agregarCanciones();
                        break;
                    case 3:                         
                        ob.mostrarCanciones();
                        break;
                    case 4:
                        ob.reproducirCanciones();
                        break;
                    case 5:
                        ob.eliminarCancion();
                        break;
                    case 6:
                        break;
                    default:
                        tj.print("Opcion incorrecta");
                }
                
            } catch (Exception e) {
                tj.print("Error");
            }
        } while (op != 6);

    }
}
