package utilerias;
import acciones.Capturista;
import acciones.Capturista.onCapturistaInterface;
import acciones.Consultor;
import acciones.Consultor.Nodo;
import acciones.Consultor.onConsultorInterface;
import java.util.ArrayList;
import java.util.Scanner;
public class Secretaria implements onConsultorInterface,onCapturistaInterface{
    Consultor consultor;
    Capturista capturista;
    boolean eliminarMedio = false, modificar = false;
    public Secretaria(){
        consultor = new Consultor(this);
        capturista = new Capturista(this);
        int opcion;
        do {
            opcion = menu();  
            accionOpcion(opcion);
        } while (0 != opcion); 
    }
    private static int menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1- Ingresar inicio\n"+
                           "2- Ingresar en medio\n"+
                           "3- Ingresar al final\n"+
                           "4- Actualizar\n"+
                           "5- Eliminar inicio\n"+
                           "6- Eliminar en medio\n"+
                           "7- Eliminar al final\n"+
                           "8- Buscar\n"+
                           "9- Mostrar todo");
        int opc = scan.nextInt();
       return opc;
    }
    private void accionOpcion(int opcion) {
        switch(opcion){
            case 1:
                capturista.CapturarInicio();
                break;
            case 2:
                capturista.CapturarMedio();
                break;
            case 3:
                capturista.CapturarFinal();
                break;
            case 4:
                modificar = true;
                capturista.CapturaActualizar();
                break;
            case 5:
                consultor.eliminarInicio();
                break;
            case 6:
                eliminarMedio = true;
                capturista.EliminaMedio();
                break;
            case 7:
                consultor.eliminarFinal();
                break;
            case 8:
                capturista.EliminaMedio();
                break;
            case 9:
                consultor.mostrar();
                break;
            default:
                System.out.println("Ingresa una opcion valida");
                break;
        }
    }
    @Override
    public void onAgregado(){
        System.out.println("******Paciente agregado correctamente*****");
    }
    @Override
    public void onElimina(){
        System.out.println("******El paciente ha sido eliminado correctamente*******");
    };
    @Override
    public void onModificado(){
        System.out.println("*****El paciente ha sido actualizado correctamente*****");
    };
    @Override
    public void onBuscar(Nodo puntero){
        System.out.println("El paciente ha sido encontrado:");
        System.out.println(puntero.paciente.getNombre()+" "+puntero.paciente.getPaterno()
                                    +" "+puntero.paciente.getMaterno()+" con la edad: "+puntero.paciente.getEdad()
                                    + " con el numero de seguro social: "+puntero.paciente.getNumS()+" con un siguiente: "
                                    +puntero.paciente+"\n _______________________");
        
    }
    @Override
    public void onError(){
        System.out.println("El paciente no ha sido encontrado o ha sido eliminado");
    }
    @Override
    public void onMostrar(){
        System.out.println("Los pasientes son:");
    }
    @Override
    public void CapturaAgregar(){
        System.out.println("Iniciando la captura del nuevo paciente->>>>>");
    };
    @Override
    public void CapturaAgregarTerminadaInicio(String nombre, String paterno, String materno, String edad, String numS){
        System.out.println("La captura del paciente con el numero de seguro social: " + numS + " ha concluido ------->");
        consultor.capturaInicio(nombre, paterno, materno, edad, numS);
    };
    @Override
    public void CapturaAgregarTerminadaFinal(String nombre, String paterno, String materno, String edad, String numS){
        System.out.println("La captura del paciente con el numero de seguro social: " + numS + " ha concluido ------->");
        consultor.capturaFinal(nombre, paterno, materno, edad, numS);
    }
    @Override
    public void CapturaAgregarTerminadaMedio(String nombre, String paterno, String materno, String edad, String numS,int index){
        System.out.println("La captura del paciente con el numero de seguro social: " + numS + " ha concluido ------->");
        consultor.capturaMedio(nombre, paterno, materno, edad, numS,index);
    }
    @Override
    public void CapturaModificado(){
        System.out.println("Iniciando la captura del nuevo paciente->>>>>");
    };
    @Override
    public void CapturaModificaTerminada(String nombre){
       this.CapturaBuscar(nombre);
    }
    @Override
    public void CapturaBuscar(String nombre){
        System.out.println("Espere un momento....->>>>>");
        int posicion = consultor.buscar(nombre);
        if ((eliminarMedio || modificar) && posicion != 0 ) {
            if (eliminarMedio) {
                eliminarMedio = false;
                consultor.eliminarMedio(posicion);
            }else{
                modificar = false;
                ArrayList arrayDatos = capturista.datosPaciente();
                consultor.modificar(posicion,arrayDatos.get(0).toString(), arrayDatos.get(1).toString(),arrayDatos.get(2).toString(), arrayDatos.get(3).toString(), arrayDatos.get(4).toString());
            }
        }
    }
}
