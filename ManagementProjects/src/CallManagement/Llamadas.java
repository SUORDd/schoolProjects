package GestionLLamadas;

import PilaP.Pila;
import ToolsJOption.tj;
import javax.swing.JOptionPane;

public class Llamadas {
    
    Pila<String>lista=new Pila<>(20);
    
    public void registrarPersona(){
        String nombre=JOptionPane.showInputDialog(null,"Nueva persona en espera","Llamada en espera",JOptionPane.INFORMATION_MESSAGE);
        lista.push(nombre);
        
    }
    
    public void atenderPersona(){
        int an=0;
        an=tj.Int("En llamada con: "+lista.pop()+"\n\n1.Colgar\n2.Salir");
        do {            
            switch(an){
                case 1:
                if(!lista.estaVacia()){
                an=tj.Int("En llamada con: "+lista.pop()+"\n\n1.Colgar\n2.Salir");
                }else{
                    tj.print("Todas las llamadas han sido atendidas");
                    return;
                }
                break;
                case 2:
                    break;
                default:
                    tj.print("Opcion Incorrecta");
        }
        } while (an!=2);
    }
   
    public void LlamadasEnEspera(){
        lista.imprimir();
    }
    
}