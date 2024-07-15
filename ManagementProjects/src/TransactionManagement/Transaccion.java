package GestionTransacciones;

public class Transaccion {
    
    String descripcion;
    String fecha;
    int monto;
    
    public Transaccion(String descripcion, String fecha, int monto) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.monto = monto;
    }


    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Transaccion" + "\nDescripcion:  " + descripcion + "\nFecha:  " + fecha + "\nMonto:  $" + monto ;
    }
}