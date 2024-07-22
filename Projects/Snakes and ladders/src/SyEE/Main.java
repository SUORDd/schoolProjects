package SyEE;

import javax.swing.JOptionPane;

public class Main {

    
    public static void main(String[] args) {
        while (true) {

            Tablero tabler = new Tablero(100);


            tabler.agregarSerpiente(15, 7);
            tabler.agregarEscalera(25, 40);
            tabler.agregarEscalera(10, 89);
            tabler.agregarSerpiente(13, 1);
            tabler.agregarEscalera(12,87);
            tabler.agregarEscalera(14,30);
            tabler.agregarEscalera(9,40);
            tabler.agregarSerpiente(40, 12);
            tabler.agregarJugadores();

            while (true) {
                System.out.println("Comenzando "
                        + ""
                        + ""
                        + ""
                        + "nuevo turno...\n");
                tabler.jugar();

                String respuesta = JOptionPane.showInputDialog(null, "¿Deseas iniciar un nuevo juego? (s/n)");
                if (respuesta == null || !respuesta.equalsIgnoreCase("s")) { 
                    return; 
                }
                break; 
            }
        }
    }
}
