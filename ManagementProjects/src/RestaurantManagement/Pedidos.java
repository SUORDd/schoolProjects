package GestionRestaurante;

import ColaRes.Cola;
import ToolsJOption.tj;

public class Pedidos {
    
    Cola<String>lista=new Cola<>();
    
    public void registrarPedido(){
        String ped=tj.String("Ingrese su pedido: ");
        lista.insertar(ped);
    }
    
    public void tomarPedido(){
        tj.print("Pedido Tomado: "+lista.quitar());
    }
    
    public void verPedidos(){
        if(!lista.estaVacia()){
        lista.imprimir();
    }else{
            tj.print("Todos los pedidos han sido atendidos");
        }}
}