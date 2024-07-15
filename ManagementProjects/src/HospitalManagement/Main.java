package GestionHospital;

import ToolsJOption.tj;

public class Main {

    public static void main(String[] args) {
        
        RegistroPacientes ob=new RegistroPacientes();
        int op=0;
        do {            
            try {
                op=tj.Int("1.Registrar paciente\n2.Sala de espera\n3.Atender paciente"
                        + "\n4.Salir");
                switch(op){
                    case 1:
                        ob.registrarPaciente();
                        break;
                    case 2:
                        ob.mostrarPacientes();
                        break;
                    case 3:
                        ob.atenderPaciente();
                        break;
                    case 4:
                        break;
                    default:
                        tj.print("Opcion incorrecta");
                }
                
            } catch (Exception e) {
                tj.print("Opcion errónea");
            }
        } while (op!=4);
    }

}
