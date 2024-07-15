package ListaDoble;

public class ListaJugadores<T> {

    private Nodo<T> inicio, fin;

    public ListaJugadores() {
        inicio = fin = null;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public void agregarAlFinal(T dato) {
        if (!estaVacia()) {
            fin = new Nodo<>(dato, null, fin);
            fin.anterior.siguiente = fin;
        } else {
            inicio = fin = new Nodo<>(dato);
        }
    }

    public void agregarAlInicio(T dato) {
        if (!estaVacia()) {
            inicio = new Nodo<>(dato, inicio, null);
            inicio.siguiente.anterior = inicio;
        } else {
            inicio = fin = new Nodo<>(dato);
        }
    }

    public T eliminarInicio() {
        T dato = inicio.dato;
        if (inicio == fin) {
            inicio = fin = null;
        } else {
            inicio = inicio.siguiente;
            inicio.anterior = null;
        }
        return dato;
    }

    public T eliminarFinal() {
        T dato = fin.dato;
        if (inicio == fin) {
            inicio = fin = null;
        } else {
            fin = fin.anterior;
            fin.siguiente = null;
        }
        return dato;
    }

    public void mostrarDatos() {
        Nodo<T> recorrer = inicio;
        StringBuilder cad = new StringBuilder();
        do {
            cad.append(recorrer.dato).append("-->");
            recorrer = recorrer.siguiente;
        } while (recorrer != null);
        System.out.println(cad);
    }

    public void mostrarDatosReversa() {
        Nodo<T> recorrer = fin;
        StringBuilder cad = new StringBuilder();
        do {
            cad.append(recorrer.dato).append("-->");
            recorrer = recorrer.anterior;
        } while (recorrer != null);
        System.out.println(cad);
    }

  
    public Nodo<T> obtenerPrimerNodo() {
        return inicio;
    }
}
