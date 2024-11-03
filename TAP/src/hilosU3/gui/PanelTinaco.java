package hilosU3.gui;

import javax.swing.*;
import java.awt.*;
import hilosU3.model.Tinaco;

/**
 * Clase PanelTinaco que muestra un tinaco con niveles de agua y aceite.
 */
public class PanelTinaco extends JPanel {
    private Tinaco tinaco; // Objeto Tinaco para conocer los niveles de agua y aceite

    /**
     * Constructor de la clase PanelTinaco.
     *
     * @param tinaco el objeto Tinaco que contiene los niveles actuales de agua y aceite
     */
    public PanelTinaco(Tinaco tinaco) {
        this.tinaco = tinaco; // Guardamos el objeto Tinaco
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Agrega espacio alrededor del panel
    }

    /**
     * Método para dibujar el tinaco y los niveles de agua y aceite.
     *
     * @param g el objeto Graphics que permite el dibujo en el componente
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Definimos el tamaño del tinaco
        int alturaTinaco = getHeight() - 200; // Altura del tinaco menos un margen
        int anchoTinaco = 100; // Ancho del tinaco
        int x = (getWidth() - anchoTinaco) / 2; // Posición horizontal centrada
        int y = 70; // Posición vertical inicial

        // Dibuja el contorno del tinaco
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(x, y, anchoTinaco, alturaTinaco); // Dibuja el cuerpo del tinaco
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x, y, anchoTinaco, alturaTinaco); // Dibuja el borde del tinaco

        // Cálculo de los niveles de agua y aceite
        int alturaAgua = (int) ((double) tinaco.getAgua() / tinaco.getCapacidadMax() * alturaTinaco); // Nivel de agua
        int alturaAceite = (int) ((double) tinaco.getAceite() / tinaco.getCapacidadMax() * alturaTinaco); // Nivel de aceite

        // Dibuja el nivel de agua
        g2d.setColor(new Color(0, 0, 255, 150)); // Color azul con algo de transparencia
        g2d.fillRect(x, y + alturaTinaco - alturaAgua, anchoTinaco, alturaAgua); // Dibuja el agua

        // Dibuja el nivel de aceite, encima del agua
        g2d.setColor(new Color(255, 165, 0, 150)); // Color naranja con algo de transparencia
        g2d.fillRect(x, y + alturaTinaco - (alturaAgua + alturaAceite), anchoTinaco, alturaAceite); // Dibuja el aceite
    }
}
