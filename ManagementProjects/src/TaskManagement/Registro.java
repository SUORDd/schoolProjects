package GestionTareas;

public class Registro {
    
    String tarea;
    String fechaVencimiento;

    public Registro() {
    }

    @Override
    public String toString() {
        return tarea + "\nFecha limite:\n" + fechaVencimiento ;
    }
    
    
    
    public Registro(String tarea, String fechaVencimiento) {
        this.tarea = tarea;
        this.fechaVencimiento = fechaVencimiento;
    }
    
}