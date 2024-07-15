package GestionHospital;

public class Hospital {
    
    String nombre;
    String gradoUrgencias;

    public Hospital() {
    }
    
    public Hospital(String nombre,  String gradoUrgencias) {
        this.nombre = nombre;
        this.gradoUrgencias = gradoUrgencias;
    }

    
    RegistroPacientes ob=new RegistroPacientes();
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nGrado de Urgencias: " +ob.getGradoUrgencia(gradoUrgencias) ;
    }
    
    
    
    
    
    
    
}