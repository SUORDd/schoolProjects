package GestionTareas;

import ListaSimpleTar.ListaSimple;
import ToolsJOption.tj;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Tareas {

    String listaInvitados[] = null;
    ListaSimple<Registro> lista = new ListaSimple<>();
    Registro ob=new Registro();
    
    public void agregarInvitado() {
        int tam = tj.Int("Cantidad a Invitar:");
        listaInvitados = new String[tam];
        for (int i = 0; i < listaInvitados.length; i++) {
            listaInvitados[i] = tj.String("Mandar invitacion a:");
        }
    }

    public void mostrarInvitados() {
        StringBuilder cad = new StringBuilder();
        for (int i = 0; i < listaInvitados.length; i++) {
            cad.append(i+1).append(".-").append(listaInvitados[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null,cad,"Lista de Invitados",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void marcarCompletado() {
        if(!lista.estaVacia()){
        lista.mostrarDatos();
        }else{
            tj.print("Todas las Tareas han sido completadas");
        }
    }
    
    private void registro(String proveedor){
        String fecha=tj.String("Ingresa una fecha de Vencimiento:(dd//MM/yyyy");
        try {
            SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            Date pars = f.parse(fecha);
        } catch (ParseException ex) {
            tj.print("Formato de fecha incorrecto");
        }
        ob=new Registro(proveedor, fecha);
        lista.agregarAlFinal(ob);
        
    }
    

    public void añadirProveedores() {
        int op = 0;
        op = tj.Int("¿A que proveedor deseas contratar?\n1. Decoración\n2. Servicios de Fotografia\n3. Música"
                + "\n4. Refrescos\n5. Seguridad\n6. Inflables\n7. Animadores\n8. Agregar otro:");
        switch (op) {
            case 1:
                registro("Proveedor de Decoracion");
                break;
            case 2:
                registro("Proveedor de Servicios de Fotografia");
                break;
            case 3:
                registro("Proveedor de Música");
                break;
            case 4:
                registro("Proveedor de Refrescos");
                break;
            case 5:
                registro("Proveedor de Seguridad");
                break;
            case 6:
                registro("Proveedor de Inflables");
                break;
            case 7:
                registro("Proveedor de Animadores");
                break;
            case 8:
                String nuevo=tj.String("Nuevo Proveedor:");
                registro(nuevo);
                break;
        }}
    

    public void añadirLugar() {
        int op = 0;
        op = tj.Int("¿A que lugar deseas reservar?\n1. Playa\n2. Cabañas\n3. Campo"
                + "\n4. Salon\n5. Albercas\n6. Gym\n7. Agregar otro:");
        switch (op) {
            case 1:
                registro("Reservacion en: Playa");
                break;
            case 2:
                registro("Reservacion en: Cabañas");
                break;
            case 3:
                registro("Reservacion en: Campo");
                break;
            case 4:
                registro("Reservacion en: Salon");
                break;
            case 5:
                registro("Reservacion en: Albercas");
                break;
            case 6:
                registro("Reservacion en: Gym");
                break;
            case 7:
                String nuevo=tj.String("Nuevo Lugar:");
                registro(nuevo);
                break;
        }}
    
    

}
