package GestionContactos;

public class Contactos {

    String nombre, telefono, correo, fechaAgregado;

    public Contactos(String nombre, String telefono, String correo, String fechaAgregado) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaAgregado = fechaAgregado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFechaAgregado(String fechaAgregado) {
        this.fechaAgregado = fechaAgregado;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nTelefono: "
                + telefono + "\nCorreo: " + correo + "\nFecha de Añadido: " + fechaAgregado;
    }

}
