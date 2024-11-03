package hilosU3.threads;

import hilosU3.model.Tinaco;
import hilosU3.gui.SimuladorTinaco;
import javax.swing.SwingUtilities;

/**
 * Clase ProductorAgua que implementa Runnable y representa un hilo productor 
 * que se encarga de añadir agua al tinaco en un simulador.
 * Este hilo funciona en un bucle continuo, añadiendo cantidades aleatorias de agua
 * siempre que el simulador esté en ejecución.
 */
public class ProductorAgua implements Runnable {
    private Tinaco tinaco; // El tinaco al que se añadirá el agua
    private SimuladorTinaco simulador; // La interfaz gráfica del simulador

    /**
     * Constructor que inicializa el ProductorAgua con el tinaco y el simulador.
     *
     * @param tinaco el tinaco al que se añadirá el agua
     * @param simulador la interfaz gráfica del simulador
     */
    public ProductorAgua(Tinaco tinaco, SimuladorTinaco simulador) {
        this.tinaco = tinaco; // Inicializa el tinaco
        this.simulador = simulador; // Inicializa el simulador
    }

    /**
     * Método que define la lógica del hilo productor.
     * Se ejecuta en un bucle infinito, donde se verifica si el simulador está en ejecución
     * y se intenta añadir una cantidad aleatoria de agua al tinaco.
     * Si la adición es exitosa, se actualiza el área de estado del simulador y las barras de progreso.
     * Se duerme el hilo por un tiempo aleatorio entre cada adición.
     */
    @Override
    public void run() {
        while (true) { // Bucle infinito para el productor
            if (simulador.isEnEjecucion()) { // Verifica si el simulador está en ejecución
                int cantidad = (int) (Math.random() * 4); // Genera una cantidad aleatoria de agua para añadir
                // Intenta añadir la cantidad de agua al tinaco
                if (tinaco.agregarAgua(cantidad)) {
                    // Actualiza la interfaz gráfica en el hilo de la GUI
                    SwingUtilities.invokeLater(() -> {
                        simulador.getAreaEstado().append("Se produjeron " + cantidad + "L de agua.\n"); // Muestra un mensaje de estado
                        simulador.actualizarBarras(); // Actualiza las barras de progreso
                    });
                }
            }
            try {
                // Duerme el hilo por un tiempo aleatorio entre 0 y 2000 milisegundos
                Thread.sleep((long) (Math.random() * 2000));
            } catch (InterruptedException e) {
                e.printStackTrace(); // Manejo de interrupciones
            }
        }
    }
}
