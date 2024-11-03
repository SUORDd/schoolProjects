package hilosU3.threads;

import hilosU3.model.Tinaco;
import hilosU3.gui.SimuladorTinaco;
import javax.swing.SwingUtilities;

/**
 * Clase ConsumidorAceite que implementa Runnable y representa un hilo consumidor 
 * que se encarga de extraer aceite del tinaco en un simulador.
 * Este hilo funciona en un bucle continuo, extrayendo cantidades aleatorias de aceite
 * siempre que el simulador esté en ejecución.
 */
public class ConsumidorAceite implements Runnable {
    private Tinaco tinaco; // El tinaco del cual se extraerá el aceite
    private SimuladorTinaco simulador; // La interfaz gráfica del simulador

    /**
     * Constructor que inicializa el ConsumidorAceite con el tinaco y el simulador.
     *
     * @param tinaco el tinaco del que se extraerá el aceite
     * @param simulador la interfaz gráfica del simulador
     */
    public ConsumidorAceite(Tinaco tinaco, SimuladorTinaco simulador) {
        this.tinaco = tinaco; // Inicializa el tinaco
        this.simulador = simulador; // Inicializa el simulador
    }

    /**
     * Método que define la lógica del hilo consumidor.
     * Se ejecuta en un bucle infinito, donde se verifica si el simulador está en ejecución
     * y se intenta extraer una cantidad aleatoria de aceite del tinaco.
     * Si la extracción es exitosa, se actualiza el área de estado del simulador y las barras de progreso.
     * Se duerme el hilo por un tiempo aleatorio entre cada extracción.
     */
    @Override
    public void run() {
        while (true) { // Bucle infinito para el consumidor
            if (simulador.isEnEjecucion()) { // Verifica si el simulador está en ejecución
                int cantidad = (int) (Math.random() * 2); // Genera una cantidad aleatoria de aceite para extraer
                // Intenta extraer la cantidad de aceite del tinaco
                if (tinaco.sacarAceite(cantidad)) {
                    // Actualiza la interfaz gráfica en el hilo de la GUI
                    SwingUtilities.invokeLater(() -> {
                        simulador.getAreaEstado().append("Se consumieron " + cantidad + "L de aceite.\n"); // Muestra un mensaje de estado
                        simulador.actualizarBarras(); // Actualiza las barras de progreso
                    });
                }
            }
            try {
                // Duerme el hilo por un tiempo aleatorio entre 0 y 3500 milisegundos
                Thread.sleep((long) (Math.random() * 3500));
            } catch (InterruptedException e) {
                e.printStackTrace(); // Manejo de interrupciones
            }
        }
    }
}
