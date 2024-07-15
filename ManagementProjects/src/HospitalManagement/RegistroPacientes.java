package GestionHospital;

import ListaDobleH.ListaDobleH;
import ToolsJOption.tj;

public class RegistroPacientes {

    public RegistroPacientes() {
    }

    ListaDobleH<Hospital> lista = new ListaDobleH<>();

    public void registrarPaciente() {
        String nombr = tj.String("Ingresa el nombre del Paciente");
        String grado = tj.String("Grado de Urgencias\n1.Alto\n2.Bajo");
        if (grado == null) {
            tj.print("Opcion errónea");
        } else {
            switch (grado) {
                case "1": {
                    Hospital ob = new Hospital(nombr, grado);
                    lista.agregarAlInicio(ob);
                    break;
                }
                case "2": {
                    Hospital ob = new Hospital(nombr, grado);
                    lista.agregarAlFinal(ob);
                    break;
                }
                default:
                    tj.print("Opcion errónea");
                    break;
            }
        }
    }

    public String getGradoUrgencia(String gradoUrgencias) {
        return gradoUrgencias.equals("1") ? "Alto" : "Bajo";
    }

    public void mostrarPacientes() {
        if (!lista.estaVacia()) {
            lista.mostrarDatos();
        } else {
            tj.print("Aun no hay pacientes");
        }
    }

    public void atenderPaciente() {
        if (!lista.estaVacia()) {
            lista.eliminarInicio();
        } else {
            tj.print("Todos los pacientes han sido atendidos");
        }
    }

}
