package GestionTransacciones;

import ListaSimpleET.ListaSimple;
import ListaSimpleET.NodoSimple;
import ToolsJOption.tj;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class RegistroTransaccion {
    
    ListaSimple<Transaccion>lista=new ListaSimple<>();
    int saldo;

    public RegistroTransaccion() {
        saldo=tj.Int("Ingresa tu saldo");
    }
    public void registrar(){
        String descripcion=tj.String("Descripción de la Transaccion");
        String fechaStr=JOptionPane.showInputDialog("Fecha actual:","");
        int monto=tj.Int("Ingresa monto");
        try {
            SimpleDateFormat dat=new SimpleDateFormat("dd-MM-yyyy");
            Date pars=dat.parse(fechaStr);
        } catch (ParseException e) {
            tj.print("Formato de Fecha erroneo");
        }
        if(saldo<monto){
            tj.print("No cuentas con saldo suficiente");
        }else{
            saldo=saldo-monto;
            Transaccion trs=new Transaccion(descripcion, fechaStr, monto);
            lista.agregarAlFinal(trs);
        }
    }
    
    public int consultarSaldo(){
        return saldo;
    }
    
    public void mostrarTransacciones(){
        if(!lista.estaVacia()){
        lista.mostrarDatos();
    }else{
          tj.print("Aun no hay transacciones");
        }}
    
    public boolean buscarTransacciones(String fecha){
        boolean encontrado=false;
        StringBuilder cad=new StringBuilder();
        NodoSimple<Transaccion>actual=lista.inicio;
        while(actual!=null){           
            if(actual.dato.getFecha().equals(fecha)){
                 cad.append(actual.dato).append("\n----------------------------\n");
                 encontrado=true;
            }
            actual=actual.siguiente;
        }
            if(encontrado){
                JOptionPane.showMessageDialog(null, cad);
            }else{
                tj.print("No hay transiciones en esa fecha");
        }
        return encontrado;
}
    

    
    public void mostrarPorFecha(){
        if(!lista.estaVacia()){
        String fecha=tj.String("Ingresa la fecha");
        buscarTransacciones(fecha);
    }else{
            tj.print("Aun no hay transacciones");
        }
    }
}