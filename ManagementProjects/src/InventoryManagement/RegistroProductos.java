package GestionInventario;

import ToolsJOption.tj;
import ListaDobleI.ListaDoble;
import ListaDobleI.NodoDoble;
public class RegistroProductos {
    ListaDoble<Productos>lista=new ListaDoble<>();
    
    
    public void registrar(){
        String nombr=tj.String("Ingrese un nuevo producto:");
        int prec=tj.Int("Precio general");
        int cant=tj.Int("Cantidad actual");
        Productos ob=new Productos(nombr, prec, cant);
        lista.agregarAlFinal(ob);
    }
    
    public void eliminar(){
        String pro=tj.String("Introduce el producto a elimina:");
        NodoDoble<Productos>nodo=lista.inicio;
        while(nodo!=null){
            if(nodo.dato.getNombre().equals(pro)){
                lista.eliminarDato(nodo.dato);
            }
            nodo=nodo.siguiente;
        }
    }
    
    public void actualizar(){
        String pro=tj.String("Ingrese el producto:");
        NodoDoble<Productos>nodo=lista.inicio;
        while(nodo!=null){
            if(nodo.dato.getNombre().equals(pro)){
                int cant=nodo.dato.getCantidad();
                int rest=tj.Int("Cantidad a llevarse:");
                cant=cant-rest;
                nodo.dato.setCantidad(cant);
                if(cant<0){
                    tj.print("No hay suficientes insumos");
                }
            }
            nodo=nodo.siguiente;
        }
    }
    
    public void mostrar(){
        if(!lista.estaVacia()){
        lista.mostrarDatos();
    }else{
         tj.print("No hay insumos");
        }
    }
    
    public boolean buscar(){
        boolean encontrado=false;
        String pro=tj.String("Introduce el producto a buscar:");
        NodoDoble<Productos>nodo=lista.inicio;
        while(nodo!=null){
            if(nodo.dato.getNombre().equals(pro)){
                encontrado=true;
                break;
            }
            nodo=nodo.siguiente;
        }
        if(encontrado){
            tj.print("El producto si esta en el inventario");
        }else{
            tj.print("El producto no esta en el inventario");
        }
        return encontrado;
    }
    
    
    
}