package ListaDoble;

public class Nodo<T> {
    public T dato;
    public Nodo<T> siguiente, anterior;

    public Nodo(T dato, Nodo<T> siguiente, Nodo<T> anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}