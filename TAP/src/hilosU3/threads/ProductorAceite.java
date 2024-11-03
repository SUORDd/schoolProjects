package hilosU3.threads;

import hilosU3.model.Tinaco;
import hilosU3.gui.SimuladorTinaco;
import javax.swing.SwingUtilities;

/**
 * Clase ProductorAceite que implementa Runnable y representa un hilo productor 
 * que se encarga de añadir aceite al tinaco en un simulador.
 * Este hilo funciona en un bucle continuo, añadiendo cantidades aleatorias de aceite
 * siempre que el simulador esté en ejecución.
 */
public class ProductorAceite implements Runnable {
    private Tinaco tinaco; // El tinaco al que se añadirá el aceite
    private SimuladorTinaco simulador; // La interfaz gráfica del simulador

    /**
     * Constructor que inicializa el ProductorAceite con el tinaco y el simulador.
     *
     * @param tinaco el tinaco al que se añadirá el aceite
     * @param simulador la interfaz gráfica del simulador
     */
    public ProductorAceite(Tinaco tinaco, SimuladorTinaco simulador) {
        this.tinaco = tinaco; // Inicializa el tinaco
        this.simulador = simulador; // Inicializa el simulador
    }

    /**
     * Método que define la lógica del hilo productor.
     * Se ejecuta en un bucle infinito, donde se verifica si el simulador está en ejecución
     * y se intenta añadir una cantidad aleatoria de aceite al tinaco.
     * Si la adición es exitosa, se actualiza el área de estado del simulador y las barras de progreso.
     * Se duerme el hilo por un tiempo aleatorio entre cada adición.
     */
    @Override
    public void run() {
        while (true) { // Bucle infinito para el productor
            if (simulador.isEnEjecucion()) { // Verifica si el simulador está en ejecución
                int cantidad = (int) (Math.random() * 3); // Genera una cantidad aleatoria de aceite para añadir
                // Intenta añadir la cantidad de aceite al tinaco
                if (tinaco.agregarAceite(cantidad)) {
                    // Actualiza la interfaz gráfica en el hilo de la GUI
                    SwingUtilities.invokeLater(() -> {
                        simulador.getAreaEstado().append("Se produjeron " + cantidad + "L de aceite.\n"); // Muestra un mensaje de estado
                        simulador.actualizarBarras(); // Actualiza las barras de progreso
                    });
                }
            }
            try {
                // Duerme el hilo por un tiempo aleatorio entre 0 y 2500 milisegundos
                Thread.sleep((long) (Math.random() * 2500));
            } catch (InterruptedException e) {
                e.printStackTrace(); // Manejo de interrupciones
            }
        }
    }
}
