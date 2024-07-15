package GestionInventario;

import ToolsJOption.tj;

public class Main {
    
    
    public static void main(String[] args) {
        RegistroProductos ob=new RegistroProductos();
        int op=0;
        
        do {            
            op=tj.Int("1. Registrar Producto\n2. Buscar Producto\n3. Mostrar Productos"
                    + "\n4. Sustraer Producto\n5. Eliminar productos\n6. Salir");
            switch(op){             
                case 1:
                    ob.registrar();
                    break;
                case 2:
                    ob.buscar();
                    break;
                case 3:
                    ob.mostrar();
                    break;
                case 4:
                    ob.actualizar();
                    break;
                case 5:
                    ob.eliminar();
                    break;
                case 6:
                    break;
                default:
                    tj.print("Opcion incorrecta");
            }
            
        } while (op!=6);
        
    }
}