package hilosU3.model;

/**
 * Clase Tinaco que representa un contenedor capaz de almacenar agua y aceite.
 * Permite agregar y extraer cantidades de agua y aceite de manera sincronizada,
 * asegurando que la capacidad máxima del tinaco no sea superada.
 */
public class Tinaco {
    private int agua = 0; // Cantidad actual de agua en el tinaco
    private int aceite = 0; // Cantidad actual de aceite en el tinaco
    private final int capacidadMax = 100; // Capacidad máxima del tinaco

    /**
     * Agrega una cantidad específica de agua al tinaco de manera sincronizada.
     * Verifica que la cantidad total de agua y aceite no supere la capacidad máxima.
     *
     * @param cantidad la cantidad de agua a agregar
     * @return true si el agua fue agregada exitosamente, false si no se pudo agregar
     */
    public synchronized boolean agregarAgua(int cantidad) {
        // Verifica si se puede agregar el agua sin exceder la capacidad máxima
        if (agua + aceite + cantidad <= capacidadMax) {
            agua += cantidad; // Aumenta el nivel de agua
            notifyAll(); // Notifica a otros hilos que están esperando
            return true; // La operación fue exitosa
        }
        return false; // No se pudo agregar el agua
    }

    /**
     * Agrega una cantidad específica de aceite al tinaco de manera sincronizada.
     * Verifica que la cantidad total de agua y aceite no supere la capacidad máxima.
     *
     * @param cantidad la cantidad de aceite a agregar
     * @return true si el aceite fue agregado exitosamente, false si no se pudo agregar
     */
    public synchronized boolean agregarAceite(int cantidad) {
        // Verifica si se puede agregar el aceite sin exceder la capacidad máxima
        if (agua + aceite + cantidad <= capacidadMax) {
            aceite += cantidad; // Aumenta el nivel de aceite
            notifyAll(); // Notifica a otros hilos que están esperando
            return true; // La operación fue exitosa
        }
        return false; // No se pudo agregar el aceite
    }

    /**
     * Extrae una cantidad específica de agua del tinaco de manera sincronizada.
     * La operación se realiza solo si hay suficiente agua disponible.
     *
     * @param cantidad la cantidad de agua a extraer
     * @return true si el agua fue extraída exitosamente, false si no hay suficiente agua
     */
    public synchronized boolean sacarAgua(int cantidad) {
        // Verifica si hay suficiente agua para la extracción
        if (agua >= cantidad) {
            agua -= cantidad; // Disminuye el nivel de agua
            notifyAll(); // Notifica a otros hilos que están esperando
            return true; // La operación fue exitosa
        }
        return false; // No se pudo extraer el agua
    }

    /**
     * Extrae una cantidad específica de aceite del tinaco de manera sincronizada.
     * La operación se realiza bajo ciertas condiciones para asegurar la correcta extracción.
     *
     * @param cantidad la cantidad de aceite a extraer
     * @return true si el aceite fue extraído exitosamente, false si no hay suficiente aceite
     */
    public synchronized boolean sacarAceite(int cantidad) {
        // Verifica las condiciones para la extracción de aceite
        if (agua + aceite > 50 && agua <= 50 && aceite >= cantidad) {
            aceite -= cantidad; // Disminuye el nivel de aceite
            notifyAll(); // Notifica a otros hilos que están esperando
            return true; // La operación fue exitosa
        }
        return false; // No se pudo extraer el aceite
    }

    /**
     * Obtiene la cantidad actual de agua en el tinaco.
     *
     * @return la cantidad de agua en el tinaco
     */
    public int getAgua() {
        return agua; // Devuelve la cantidad de agua
    }

    /**
     * Obtiene la cantidad actual de aceite en el tinaco.
     *
     * @return la cantidad de aceite en el tinaco
     */
    public int getAceite() {
        return aceite; // Devuelve la cantidad de aceite
    }

    /**
     * Obtiene la capacidad máxima del tinaco.
     *
     * @return la capacidad máxima del tinaco
     */
    public int getCapacidadMax() {
        return capacidadMax; // Devuelve la capacidad máxima
    }
}
