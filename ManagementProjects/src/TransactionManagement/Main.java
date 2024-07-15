package GestionTransacciones;

import ToolsJOption.tj;

public class Main {

    public static void main(String[] args) {
        RegistroTransaccion ob=new RegistroTransaccion();
        int op=0;
        do {
            try {
            op=tj.Int("1.Registrar Transacción\n2.Mostrar saldo actual"
                    + "\n3.Mostrar Transacciones\n4.Mostrar transacciones por fecha"
                    + "\n5.Salir");
            switch(op){
                case 1:
                    ob.registrar();
                    break;
                case 2:
                    tj.print("Tu saldo actual es de $"+ob.consultarSaldo());
                    break;
                case 3:
                    ob.mostrarTransacciones();
                    break;
                case 4:
                    ob.mostrarPorFecha();
                    break;
            }
            } catch (Exception e) {
            tj.printError("ERROR !!!");
            }
            
        } while (op!=5);
        
        
        
        
    }

}
