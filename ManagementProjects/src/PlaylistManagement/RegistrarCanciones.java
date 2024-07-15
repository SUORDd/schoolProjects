package ReproductorMusica;

import ListaDobleCircularRep.ListaCircularDoble;
import ListaDobleCircularRep.NodoCircularDoble;
import ToolsJOption.tj;
        
public class RegistrarCanciones {
    
    ListaCircularDoble<ListaCircularDoble<PlayList>> playlists = new ListaCircularDoble<>();
    
    public void agregarPlayList() {
        String nombre = tj.String("Nombre de tu nueva PlayList:");
        PlayList a = new PlayList(nombre);
        ListaCircularDoble<PlayList> nuevo = new ListaCircularDoble<>();
        nuevo.insertar(a);
        playlists.insertar(nuevo);
        tj.print("PlayList agregada con éxito");        
    }
    
    public void agregarCanciones(PlayList play) {
        String cancion = tj.String("Ingresa el nombre de una canción:");
        play.agregarCancion(cancion);
        tj.print("Canción Agregada");
    }
    
    public void agregarCanciones() {
        String nombre = tj.String("Ingresa nombre del PlayList");
        PlayList playlistEncontrada = buscarPlayList(nombre);
        if (playlistEncontrada != null) {
            agregarCanciones(playlistEncontrada);
        } else {
            tj.print("No existe esa PlayList: " + nombre);
        }
    }
    
    public void eliminarCancion(){
        String nombre=tj.String("Ingresa nombre del PlayList");
        PlayList encontrado=buscarPlayList(nombre);
        if(encontrado!=null){
            encontrado.eliminarCancion();
        }else{
            tj.print("No existe la PlayList");
        }
    }
    
    public void mostrarCanciones() {
        String nombre = tj.String("Ingresa nombre del PlayList");
        PlayList playlistEncontrada = buscarPlayList(nombre);
        if (playlistEncontrada != null) {
            playlistEncontrada.mostrarCancion(nombre);
        } else {
            tj.print("No existe la PlayList");
        }
    }
    
    public void reproducirCanciones() {
        String nombre = tj.String("Ingresa el nombre de la PlayList a reproducir: ");
        PlayList playlistEncontrada = buscarPlayList(nombre);
        if (playlistEncontrada != null) {
            playlistEncontrada.reproducirCancion();
        } else {
            tj.print("No existe la PlayList");
        }
    }
    
    public PlayList buscarPlayList(String nombre) {
        PlayList playlistEncontrada = null;
        NodoCircularDoble<ListaCircularDoble<PlayList>> nodo = playlists.ultimo;
        while (nodo != null) {
            NodoCircularDoble<PlayList> nodito = nodo.dato.ultimo;
            while (nodito != null) {
                if (nodito.dato.getNombre().equals(nombre)) {
                    playlistEncontrada = nodito.dato;
                    return playlistEncontrada;
                }
                nodito = nodito.siguiente;
            }
            nodo = nodo.siguiente;
        }
        return playlistEncontrada;
    }
}
