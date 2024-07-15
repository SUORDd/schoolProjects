package GestionInventario;


public class Productos {
    
    
    String nombre;
    int precio;
    int cantidad;

    public Productos(String nombre, int precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    @Override
    public String toString() {
        return "Nombre del Producto: " + nombre + "\nPrecio: $" + precio + "\nCantidad:" + cantidad;
    }

    
    
}