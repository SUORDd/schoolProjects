package GestionLLamadas;

import ToolsJOption.tj;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
    int op=0;
    Llamadas ob=new Llamadas();
    
        do {            
            try {
                op=tj.Int("1. Colocar Persona en espera\n2. Atender Personas en espera"
                          + "\n3. Visualizar llamadas en Espera\n4.Salir");
                switch(op){
                    case 1:
                        ob.registrarPersona();
                        break;
                    case 2:
                        ob.atenderPersona();
                        break;
                    case 3:
                        ob.LlamadasEnEspera();
                        break;
                    case 4:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Opcion Incorrecta");
                }
                
                
            } catch (HeadlessException e) {
                tj.print("Caracter Invalido");
            }
        } while (op!=4);
    
}
}