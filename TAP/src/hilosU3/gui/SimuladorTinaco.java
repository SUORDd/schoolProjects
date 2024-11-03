package hilosU3.gui;

import hilosU3.model.Tinaco;
import hilosU3.threads.ProductorAgua;
import hilosU3.threads.ProductorAceite;
import hilosU3.threads.ConsumidorAgua;
import hilosU3.threads.ConsumidorAceite;
import javax.swing.*;
import java.awt.*;

/**
 * Clase SimuladorTinaco que crea una ventana para simular el llenado y consumo de agua y aceite en un tinaco.
 */
public class SimuladorTinaco extends JFrame {
    private Tinaco tinaco; // Objeto que representa el tinaco
    private boolean enEjecucion = true; // Estado de la simulación
    private JProgressBar barraAgua; // Barra para mostrar el nivel de agua
    private JProgressBar barraAceite; // Barra para mostrar el nivel de aceite
    private JTextArea areaEstado; // Área para mostrar mensajes sobre el estado del tinaco
    private JButton btnPausar; // Botón para pausar o reanudar la simulación

    /**
     * Constructor de la clase SimuladorTinaco.
     * Configura la interfaz gráfica y crea hilos para manejar la producción y el consumo.
     */
    public SimuladorTinaco() {
        tinaco = new Tinaco(); // Inicializa el tinaco
        setTitle("Simulador de Tinaco"); // Título de la ventana
        setSize(600, 600); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar la aplicación al cerrar la ventana
        setLayout(new BorderLayout()); // Usar diseño de bordes
        setBackground(new Color(245, 245, 245)); // Color de fondo

        // Panel superior con el título y el botón de pausa
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(new Color(60, 63, 65));
        panelSuperior.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Simulador de Tinaco", SwingConstants.CENTER); // Título
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setForeground(Color.WHITE);
        panelSuperior.add(titulo, BorderLayout.CENTER);

        // Botón para pausar/reanudar la simulación
        btnPausar = new JButton("Pausar");
        btnPausar.setPreferredSize(new Dimension(150, 40)); // Tamaño del botón
        btnPausar.setBackground(new Color(0, 123, 255)); // Color del botón
        btnPausar.setForeground(Color.WHITE);
        btnPausar.setFocusPainted(false); // Sin borde al hacer clic
        btnPausar.addActionListener(e -> {
            enEjecucion = !enEjecucion; // Cambia el estado de ejecución
            btnPausar.setText(enEjecucion ? "Pausar" : "Reanudar"); // Cambia el texto del botón
        });
        panelSuperior.add(btnPausar, BorderLayout.EAST);

        add(panelSuperior, BorderLayout.NORTH); // Añadir el panel superior

        // Configuración de las barras de progreso para agua y aceite
        barraAgua = new JProgressBar(0, 100); // Barra para el agua
        barraAgua.setStringPainted(true); // Muestra el porcentaje
        barraAgua.setForeground(new Color(0, 102, 204)); // Color de la barra
        barraAgua.setBackground(Color.WHITE);

        barraAceite = new JProgressBar(0, 100); // Barra para el aceite
        barraAceite.setStringPainted(true); // Muestra el porcentaje
        barraAceite.setForeground(new Color(255, 140, 0)); // Color de la barra
        barraAceite.setBackground(Color.WHITE);

        // Panel para las barras de progreso
        JPanel panelBarras = new JPanel();
        panelBarras.setBackground(new Color(245, 245, 245));
        panelBarras.setLayout(new GridLayout(4, 1, 5, 5)); // Diseño en columnas
        panelBarras.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espaciado

        // Etiquetas para las barras
        JLabel labelAgua = new JLabel("Nivel de Agua", JLabel.CENTER);
        labelAgua.setFont(new Font("Arial", Font.BOLD, 14));
        labelAgua.setForeground(new Color(0, 102, 204));

        JLabel labelAceite = new JLabel("Nivel de Aceite", JLabel.CENTER);
        labelAceite.setFont(new Font("Arial", Font.BOLD, 14));
        labelAceite.setForeground(new Color(255, 153, 51));

        panelBarras.add(labelAgua); // Añadir etiqueta de agua
        panelBarras.add(barraAgua); // Añadir barra de agua
        panelBarras.add(labelAceite); // Añadir etiqueta de aceite
        panelBarras.add(barraAceite); // Añadir barra de aceite

        add(panelBarras, BorderLayout.SOUTH); // Añadir el panel de barras

        // Panel central para mostrar el gráfico del tinaco
        add(new PanelTinaco(tinaco), BorderLayout.CENTER);

        // Área de texto para mostrar mensajes de estado
        areaEstado = new JTextArea(6, 25); // Área de texto de 6 filas y 25 columnas
        areaEstado.setEditable(false); // No se puede editar
        areaEstado.setFont(new Font("Arial", Font.PLAIN, 14));
        areaEstado.setBackground(Color.WHITE);
        areaEstado.setForeground(new Color(60, 63, 65));
        areaEstado.setBorder(BorderFactory.createLineBorder(new Color(60, 63, 65))); // Borde

        JScrollPane scroll = new JScrollPane(areaEstado); // Añadir scroll al área de texto
        scroll.setBorder(BorderFactory.createTitledBorder("Estado del Tinaco")); // Título del scroll
        scroll.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espaciado
        add(scroll, BorderLayout.EAST); // Añadir scroll al lado derecho

        // Iniciar hilos de productores y consumidores
        new Thread(new ProductorAgua(tinaco, this)).start(); // Hilo productor de agua
        new Thread(new ProductorAceite(tinaco, this)).start(); // Hilo productor de aceite
        new Thread(new ConsumidorAgua(tinaco, this)).start(); // Hilo consumidor de agua
        new Thread(new ConsumidorAceite(tinaco, this)).start(); // Hilo consumidor de aceite
    }

    /**
     * Devuelve si la simulación está en ejecución o en pausa.
     *
     * @return true si está en ejecución; false si está en pausa
     */
    public boolean isEnEjecucion() {
        return enEjecucion;
    }

    /**
     * Devuelve el área de texto donde se muestran los mensajes de estado.
     *
     * @return el JTextArea que contiene los mensajes de estado
     */
    public JTextArea getAreaEstado() {
        return areaEstado;
    }

    /**
     * Actualiza las barras de progreso para mostrar los niveles actuales de agua y aceite.
     * Refresca la interfaz gráfica.
     */
    public void actualizarBarras() {
        barraAgua.setValue(tinaco.getAgua()); // Actualiza la barra de agua
        barraAceite.setValue(tinaco.getAceite()); // Actualiza la barra de aceite
        repaint(); // Refresca la interfaz
    }

    /**
     * Método principal que inicia y muestra el simulador.
     *
     * @param args argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimuladorTinaco simulador = new SimuladorTinaco(); // Crea una instancia del simulador
            simulador.setVisible(true); // Muestra la ventana
        });
    }
}
