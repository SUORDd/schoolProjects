package GestionRestaurante;

import ToolsJOption.tj;

public class Main {

    public static void main(String[] args) {
        Pedidos ob = new Pedidos();
        int op = 0;
        do {
            op = tj.Int("1. Registrar pedido\n2. Atender Pedidos"
                    + "\n3. Pedidos pendientes\n4. Salir");
            switch (op) {
                case 1:
                    ob.registrarPedido();
                    break;
                case 2:
                    ob.tomarPedido();
                    break;
                case 3:
                    ob.verPedidos();
                    break;
                case 4:
                    break;
                default:
                    tj.print("Opcion Incorrecta");
            }
        } while (op != 4);

    }
}
