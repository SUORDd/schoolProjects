package ReproductorMusica;

import ListaDobleCircularRep.ListaCircularDoble;
import ToolsJOption.tj;

public class PlayList {
    
    String nombre;
    ListaCircularDoble<String> canciones;
    
    public PlayList(String nombre) {
        this.nombre = nombre;
        this.canciones = new ListaCircularDoble<>();
    }
    
    public void agregarCancion(String cancion) {
        canciones.insertar(cancion);
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void mostrarCancion(String cancion) {
        if (!canciones.estaVacia()) {
            canciones.mostrarDatos();
        } else {
            tj.print("No hay canciones en esta PlayList");
        }
    }
    public void eliminarCancion(){
        String eliminar=tj.String("Ingresa la cancion a eliminar");
        if(!canciones.estaVacia()){
            canciones.eliminar(eliminar);
            tj.print("Cancion eliminada con éxito");
        }else{
            tj.print("No hay canciones por eliminar");
        }
    }
    
    public void reproducirCancion() {
        if (!canciones.estaVacia()) {
            canciones.Reproductor();
        } else {
            tj.print("No hay canciones");
        }        
    }
    
}
