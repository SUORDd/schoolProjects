package SyEE;

import ListaDoble.ListaJugadores;
import ListaDoble.Nodo;
import java.util.Random;
import javax.swing.JOptionPane;

public class Tablero {

    private int tamaño;
    private Nodo inicio;
    private ListaJugadores<Jugador> jugadores;
    private ListaSerpientesEscaleras serpientesEscaleras;

    public Tablero(int tamaño) {
        this.tamaño = tamaño;
        this.inicio = construirTablero(tamaño);
        this.jugadores = new ListaJugadores<>();
        this.serpientesEscaleras = new ListaSerpientesEscaleras();
    }

    private Nodo construirTablero(int tamaño) {
        Nodo inicio = new Nodo(0);
        Nodo recorrer = inicio;
        for (int i = 1; i <= tamaño; i++) {
            Nodo nuevo = new Nodo(i);
            recorrer.siguiente = nuevo;
            nuevo.anterior = recorrer;
            recorrer = nuevo;
        }
        return inicio;
    }

    public void agregarJugadores() {
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de jugadores:"));
        for (int i = 0; i < cantidad; i++) {
            String nombre = JOptionPane.showInputDialog("Nombre del jugador #" + (i + 1) + ":");
            jugadores.agregarAlFinal(new Jugador(nombre));
        }
    }

    public void agregarSerpiente(int inicio, int fin) {
        serpientesEscaleras.agregarSerpiente(inicio, fin);
    }

    public void agregarEscalera(int inicio, int fin) {
        serpientesEscaleras.agregarEscalera(inicio, fin);
    }

    public void jugar() {
        Random random = new Random();
        while (true) {
            for (Nodo<Jugador> nodoActual = jugadores.obtenerPrimerNodo(); nodoActual != null; nodoActual = nodoActual.siguiente) {
                Jugador jugador = nodoActual.dato;
                JOptionPane.showMessageDialog(null, "Lanzar dado", "Turno de " + jugador.getNombre(), JOptionPane.QUESTION_MESSAGE);

                int dado = random.nextInt(6) + 1;
                JOptionPane.showMessageDialog(null, dado, "Resultado del dado para: " + jugador.getNombre(), JOptionPane.INFORMATION_MESSAGE);

                int nuevaPosicion = jugador.getPosicion() + dado;
                if (nuevaPosicion > tamaño) {
                    int exceso = nuevaPosicion - tamaño;
                    nuevaPosicion = tamaño - exceso;
                } else if (nuevaPosicion == tamaño) {
                    JOptionPane.showMessageDialog(null, "¡" + jugador.getNombre() + " ha ganado!");
                    return;
                }
                Nodo<Integer> nodoNuevo = obtenerNodoPorValor(nuevaPosicion);
                if (nodoNuevo != null) {
                    int destino = serpientesEscaleras.obtenerDestino(nuevaPosicion);
                    if (destino > nuevaPosicion) {
                        nuevaPosicion = destino;
                        JOptionPane.showMessageDialog(null, jugador.getNombre() + " Encontró una ESCALERA!!", "ESCALERA!!", JOptionPane.WARNING_MESSAGE);
                        if (destino > nuevaPosicion) {
                            nuevaPosicion = destino;
                            System.out.println(jugador.getNombre() + " avanza hasta la posicion " + nuevaPosicion + "\n--------------------->>>");

                        } else if (destino < nuevaPosicion) {
                            nuevaPosicion = destino;
                            JOptionPane.showMessageDialog(null, jugador.getNombre() + " Encontró una SERPIENTE!!!", "SERPIENTE", JOptionPane.WARNING_MESSAGE);
                            System.out.println(jugador.getNombre() + " retrocede hasta la posicion " + nuevaPosicion + "\n<<<---------------------");
                        } else {
                            System.out.println(jugador.getNombre() + " avanza a la posicion " + nuevaPosicion + "\n--------------------->>>");
                        }
                    } else {
                        System.out.println(jugador.getNombre() + " avanza a la posicion " + nuevaPosicion + "\n--------------------->>>");
                    }
                    jugador.setPosicion(nuevaPosicion);
                    if (nuevaPosicion == tamaño) {
                        JOptionPane.showMessageDialog(null, "¡" + jugador.getNombre() + " ha ganado!");
                        return;
                    }
                }
            }
        }
    }

    private Nodo<Integer> obtenerNodoPorValor(int valor) {
        Nodo<Integer> recorrer = inicio;
        while (recorrer != null) {
            if (recorrer.dato == valor) {
                return recorrer;
            }
            recorrer = recorrer.siguiente;
        }
        return null;
    }
}
