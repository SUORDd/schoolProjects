package SyE;

public class ListaSerpientesEscaleras {

   
    class NodoSerpienteEscalera {

        int inicio;
        int fin;
        NodoSerpienteEscalera siguiente;

        public NodoSerpienteEscalera(int inicio, int fin) {
            this.inicio = inicio;
            this.fin = fin;
            this.siguiente = null;
        }
    }

    private NodoSerpienteEscalera inicio;

    public ListaSerpientesEscaleras() {
        this.inicio = null;
    }

    public void agregarSerpiente(int inicio, int fin) {
        NodoSerpienteEscalera nuevaSerpiente = new NodoSerpienteEscalera(inicio, fin);
        if (this.inicio == null) {
            this.inicio = nuevaSerpiente;
        } else {
            NodoSerpienteEscalera temp = this.inicio;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevaSerpiente;
        }
    }

    public void agregarEscalera(int inicio, int fin) {
        NodoSerpienteEscalera nuevaEscalera = new NodoSerpienteEscalera(inicio, fin);
        if (this.inicio == null) {
            this.inicio = nuevaEscalera;
        } else {
            NodoSerpienteEscalera temp = this.inicio;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevaEscalera;
        }
    }

    public int obtenerDestino(int posicion) {
        NodoSerpienteEscalera temp = this.inicio;
        while (temp != null) {
            if (temp.inicio == posicion) {
                return temp.fin;
            }
            temp = temp.siguiente;
        }
        return posicion;
    }

}
