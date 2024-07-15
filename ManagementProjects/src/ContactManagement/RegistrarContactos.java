package GestionContactos;

import ListaSimpleCon.ListaSimple;
import ListaSimpleCon.NodoSimple;
import ToolsJOption.tj;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrarContactos {
    
    
    ListaSimple<Contactos> lista = new ListaSimple<>();

    public void registrarContacto() {
        String nombr = tj.String("Dame el nombre");
        String telefono = tj.String("Número:");
        String correo = tj.String("Correo electronico:");
        String fechaAgregado = tj.String("Fecha de añadido(dd-MM-yyyy)");
        try {
            
            SimpleDateFormat cad = new SimpleDateFormat("dd-MM-yyyy");
            Date pars = cad.parse(fechaAgregado);

        } catch (ParseException e) {
            tj.printError("Formato de Fecha Incorrecto");
        }
        Contactos list = new Contactos(nombr, telefono, correo, fechaAgregado);
        lista.agregarAlFinal(list);
    }

    public void mostrarDatos() {
        if (!lista.estaVacia()) {
            lista.mostrarDatos();
        } else {
            tj.print("Aun no hay contactos");
        }
    }
    
    public boolean buscarContacto() {
        boolean encontrado = false;
        String nombre = tj.String("Contacto a Buscar");
        NodoSimple<Contactos> nodo = lista.inicio;
        while (nodo != null) {
            if (nodo.dato.getNombre().equals(nombre)) {
                encontrado = true;
            }
            nodo = nodo.siguiente;
        }
        if (encontrado) {
            tj.print("El contacto si existe!!");
        } else {
            tj.print("El contacto no existe");
        }
        return encontrado;
    }

    public void eliminarContacto() {
        String nombre = tj.String("Contacto a eliminar:");
        NodoSimple<Contactos> nodo = lista.inicio;
        while (nodo != null) {
            if (nodo.dato.getNombre().equals(nombre)) {
                lista.eliminarDato(nodo.dato);
                tj.print("Contacto eliminado correctamente");
            }else{
                tj.print("No se encontro el contacto");
            }
            nodo = nodo.siguiente;
        
        }
    }

    public boolean editarContacto() {
        boolean encontrado = false;
        String nombre = tj.String("Ingrese el contacto a editar");
        NodoSimple<Contactos> nodo = lista.inicio;
        while (nodo != null) {
            if (nodo.dato.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = true;
                break;
                
            }
            nodo = nodo.siguiente;
        }
        if (encontrado) {
            int op=0;
            do {
                op = tj.Int("Que desea editar de " + nodo.dato.getNombre() + "\n"
                        + "1.Nombre\n2.Numero\n3.Correo\n4.Fecha de agregamiento\n5.Salir");
                switch (op) {
                    case 1:
                        String nuevoNombre = tj.String("Nuevo nombre para: " + nodo.dato.getNombre());
                        nodo.dato.setNombre(nuevoNombre);
                        break;
                    case 2:
                        String nuevoNumero = tj.String("Nuevo número para: " + nodo.dato.getNombre());
                        nodo.dato.setTelefono(nuevoNumero);
                        break;
                    case 3:
                        String nuevoCorreo = tj.String("Nuevo correo para: " + nodo.dato.getNombre());
                        nodo.dato.setCorreo(nuevoCorreo);
                        break;
                    case 4:
                        String nuevaFecha = tj.String("Nueva Fecha de agregamiento(dd/MM/yyyy)");
                        nodo.dato.setFechaAgregado(nuevaFecha);
                        break;
                    case 5:
                        break;
                }
            } while (op != 5);
        } else {
            tj.print("No existe el contacto");
        }
        return encontrado;
    }

}
