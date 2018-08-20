/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ismael
 */
public class Capturista {
    Scanner scan = new Scanner(System.in);
    onCapturistaInterface secretaria;
    public Capturista(onCapturistaInterface secretaria){
        this.secretaria=secretaria;
    }
    public void CapturarInicio(){
        secretaria.CapturaAgregar();
        ArrayList arrayDatos = datosPaciente();
        secretaria.CapturaAgregarTerminadaInicio(arrayDatos.get(0).toString(), arrayDatos.get(1).toString(),arrayDatos.get(2).toString(), arrayDatos.get(3).toString(), arrayDatos.get(4).toString());
    }
    public void CapturarFinal(){
        secretaria.CapturaAgregar();
        ArrayList arrayDatos = datosPaciente();
        secretaria.CapturaAgregarTerminadaFinal(arrayDatos.get(0).toString(), arrayDatos.get(1).toString(),arrayDatos.get(2).toString(), arrayDatos.get(3).toString(), arrayDatos.get(4).toString());
    }
    public void CapturarMedio(){
        secretaria.CapturaAgregar();
        System.out.println("Ingresa la pocisión en la que quieres agregar al paciente: ");
        int index = scan.nextInt();
        ArrayList arrayDatos = datosPaciente();
        secretaria.CapturaAgregarTerminadaMedio(arrayDatos.get(0).toString(), arrayDatos.get(1).toString(),arrayDatos.get(2).toString(), arrayDatos.get(3).toString(), arrayDatos.get(4).toString(),index);
    }
    public void CapturaActualizar(){
        secretaria.CapturaModificado();
        System.out.println("Ingresa el nombre del Paciente:");
        String nombre = scan.next();
        secretaria.CapturaModificaTerminada(nombre);
    }
    public void EliminaMedio(){
        System.out.println("Ingresa el nombre del paciente: ");
        String nombre = scan.next();
        secretaria.CapturaBuscar(nombre);
    }
    public ArrayList datosPaciente() {
        ArrayList array = new ArrayList(); 
        System.out.println("Ingresa nombre :");
        array.add(scan.next());
        System.out.println("Ingrese el apellido paterno");
        array.add(scan.next());
        System.out.println("Ingrese el apellido materno");
        array.add(scan.next());
        System.out.println("Ingrese la edad");
        array.add(scan.next());
        System.out.println("Ingrese el número de seguro social");
        array.add(scan.next());
        
        return array;  
    }
    public interface onCapturistaInterface{
        public void CapturaAgregar();
        public void CapturaAgregarTerminadaInicio(String nombre, String paterno, String materno, String edad, String numS);
        public void CapturaAgregarTerminadaFinal(String nombre, String paterno, String materno, String edad, String numS);
        public void CapturaAgregarTerminadaMedio(String nombre, String paterno, String materno, String edad, String numS,int index);
        public void CapturaModificado();
        public void CapturaModificaTerminada(String nombre);
        public void CapturaBuscar(String nombre);
    }
}
