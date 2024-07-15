package GestionEstudiantes;

public class Estudiante {
    private String nombre;
    private String id;
    private float promedio;

    public Estudiante(String nombre, String id, float promedio) {
        this.nombre = nombre;
        this.id = id;
        this.promedio = promedio;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nID: " + id + "\nPromedio: " + promedio;
    }
}
    
