/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import utilerias.Paciente;


public class Consultor {
    onConsultorInterface secretaria;
    private Paciente paciente;
    private Nodo primero = null;
    private int longitud = 0;
    
    public static class Nodo{
        public Paciente paciente;
        public Nodo siguiente;
        public Nodo(Paciente paciente){
            this.paciente = paciente;
            this.siguiente = null;
        }
    }
    public Consultor(onConsultorInterface secretaria){
        this.secretaria=secretaria;
    }
    public void capturaInicio(String nombre, String paterno, String materno, String edad, String numS){
        paciente = new Paciente(nombre,paterno,materno,edad,numS);
        Nodo nodo = new Nodo(paciente);
        Nodo puntero = primero;
        if (primero == null) {
            primero = nodo;
            nodo.siguiente = null;
            longitud++;
            System.out.println("Paciente agregado con los siguientes datos: "+nodo.paciente.getNombre()+" "+nodo.paciente.getPaterno()
                                    +" "+nodo.paciente.getMaterno()+" con la edad: "+nodo.paciente.getEdad()
                                    +" con el numero de seguro social: "+nodo.paciente.getNumS()+" este es su siguiente: "
                                    +nodo.siguiente+"\n_______________________");
            secretaria.onAgregado();
        }else{
            primero = nodo;
            primero.siguiente = puntero;
            longitud++;
            System.out.println("Paciente Nuevo con los siguientes datos: "+nodo.paciente.getNombre()+" "+nodo.paciente.getPaterno()
                                    +" "+nodo.paciente.getMaterno()+" con la edad: "+nodo.paciente.getEdad()
                                    +" con el numero de seguro social: "+nodo.paciente.getNumS()+" este es su siguiente: "
                                    +nodo.siguiente+"\n_______________________");
            System.out.println("Paciente Despues con los siguientes datos: "+nodo.siguiente.paciente.getNombre()+" "+nodo.siguiente.paciente.getPaterno()
                                    +" "+nodo.siguiente.paciente.getMaterno()+" con la edad: "+nodo.siguiente.paciente.getEdad()
                                    +" con el numero de seguro social: "+nodo.siguiente.paciente.getNumS()+" este es su siguiente: "
                                    +nodo.siguiente.siguiente+"\n_______________________");
            secretaria.onAgregado();
        }
       
    }
    public void capturaMedio(String nombre, String paterno, String materno, String edad, String numS,int index){
        paciente = new Paciente(nombre,paterno,materno,edad,numS);
        Nodo nodo = new Nodo(paciente);
        Nodo puntero = primero;
        Nodo punteroAn =null;
        Nodo punteroDe = null;
        int contador = 1;
        if (primero == null) {
            primero = nodo;
            longitud++;
            System.out.println("Paciente agregado con los siguientes datos: "+nodo.paciente.getNombre()+" "+nodo.paciente.getPaterno()
                                    +" "+nodo.paciente.getMaterno()+" con la edad: "+nodo.paciente.getEdad()
                                    +" con el numero de seguro social: "+nodo.paciente.getNumS()+" este es su siguiente: "
                                    +nodo.siguiente+"\n_______________________");
            secretaria.onAgregado();
        }else{
            if (index == longitud+1) {
                puntero.siguiente = nodo;
                longitud++;
                System.out.println("Paciente Antes con los siguientes datos: "+puntero.paciente.getNombre()+" "+puntero.paciente.getPaterno()
                                    +" "+puntero.paciente.getMaterno()+" con la edad: "+puntero.paciente.getEdad()
                                    +" con el numero de seguro social: "+puntero.paciente.getNumS()+" este es su siguiente: "
                                    +nodo.siguiente+"\n_______________________");
                System.out.println("Paciente agregado con los siguientes datos: "+nodo.paciente.getNombre()+" "+nodo.paciente.getPaterno()
                                    +" "+nodo.paciente.getMaterno()+" con la edad: "+nodo.paciente.getEdad()
                                    +" con el numero de seguro social: "+nodo.paciente.getNumS()+" este es su siguiente: "
                                    +nodo.siguiente+"\n_______________________");
                secretaria.onAgregado();
            }else{
                while (contador != index) {
                    punteroAn = puntero;
                    puntero = puntero.siguiente ;
                    contador++;
                }
                punteroAn.siguiente = nodo;
                nodo.siguiente = puntero;
                System.out.println("Este es el paciente Antes agregado: "+punteroAn.paciente.getNombre()+ " y su next es: "+ punteroAn.siguiente+" con el nombre"+
                        punteroAn.siguiente.paciente.getNombre());
                System.out.println("Este es el Nuevo agregado: "+nodo.paciente.getNombre()+ " y su next es: "+ nodo.siguiente+" con el nombre"+
                        nodo.siguiente.paciente.getNombre());
                 System.out.println("Este es el paciente Despues agregado: "+puntero.paciente.getNombre()+ " y su next es: "+ puntero.siguiente);
                longitud++;
                secretaria.onAgregado();
                
            }
        }
    }
    public void capturaFinal(String nombre, String paterno, String materno, String edad, String numS){
        paciente = new Paciente(nombre,paterno,materno,edad,numS);
        Nodo nodo = new Nodo(paciente);
        Nodo puntero = primero;
        if (primero == null) {
            primero = nodo;
            puntero = primero;
            longitud++;
            System.out.println("Paciente agregado con los siguientes datos: "+nodo.paciente.getNombre()+" "+nodo.paciente.getPaterno()
                                    +" "+nodo.paciente.getMaterno()+" con la edad: "+nodo.paciente.getEdad()
                                    +" con el numero de seguro social: "+nodo.paciente.getNumS()+" este es su siguiente: "
                                    +nodo.siguiente+"\n_______________________");
            secretaria.onAgregado();
        }else{
            while (puntero.siguiente != null) {
                puntero = puntero.siguiente ;
            }
            puntero.siguiente = nodo;
            System.out.println("Paciente Antes con los siguientes datos: "+puntero.paciente.getNombre()+" "+puntero.paciente.getPaterno()
                                    +" "+puntero.paciente.getMaterno()+" con la edad: "+puntero.paciente.getEdad()
                                    +" con el numero de seguro social: "+puntero.paciente.getNumS()+" este es su siguiente: "
                                    +puntero.siguiente+"\n_______________________");
            System.out.println("Paciente Nuevo con los siguientes datos: "+nodo.paciente.getNombre()+" "+nodo.paciente.getPaterno()
                                    +" "+nodo.paciente.getMaterno()+" con la edad: "+nodo.paciente.getEdad()
                                    +" con el numero de seguro social: "+nodo.paciente.getNumS()+" este es su siguiente: "
                                    +nodo.siguiente+"\n_______________________");
            secretaria.onAgregado();
            longitud++;
           
        }
    }
    public void modificar(int index,String nombre, String paterno, String materno, String edad, String numS){
        int contador = 1;
        Nodo puntero = primero;
         while (contador != index) {
            puntero = puntero.siguiente ;
            contador++;
        }
        puntero.paciente.setNombre(nombre);
        puntero.paciente.setPaterno(paterno);
        puntero.paciente.setMaterno(materno);
        puntero.paciente.setEdad(edad);
        puntero.paciente.setNumS(numS);
        secretaria.onModificado();
    }
    public void eliminarInicio(){
        Nodo puntero = primero;
        Nodo punteroDes = null;
        int cont = 1;
        if (primero == null) {
            System.out.println("La lista esta vacia*******+");
        }else if (longitud == 1) {
            System.out.println("Paciente Eliminado con los siguientes datos: "+primero.paciente.getNombre()+" "+primero.paciente.getPaterno()
                                    +" "+primero.paciente.getMaterno()+" con la edad: "+primero.paciente.getEdad()
                                    +" con el numero de seguro social: "+primero.paciente.getNumS()+" este es su siguiente: "
                                    +primero.siguiente+"\n_______________________");
            primero = null;
            puntero = null;
            longitud--;
            secretaria.onElimina();
        }else{
            System.out.println("Paciente Eliminado con los siguientes datos: "+primero.paciente.getNombre()+" "+primero.paciente.getPaterno()
                                    +" "+primero.paciente.getMaterno()+" con la edad: "+primero.paciente.getEdad()
                                    +" con el numero de seguro social: "+primero.paciente.getNumS()+" este es su siguiente: "
                                    +primero.siguiente+"\n_______________________");
            primero = primero.siguiente;
            puntero.siguiente = null;
            puntero = null;
            System.out.println("Paciente En la posicion Inicial con los siguientes datos: "+primero.paciente.getNombre()+" "+primero.paciente.getPaterno()
                                    +" "+primero.paciente.getMaterno()+" con la edad: "+primero.paciente.getEdad()
                                    +" con el numero de seguro social: "+primero.paciente.getNumS()+" este es su siguiente: "
                                    +primero.siguiente+"\n_______________________");
            longitud--;
            secretaria.onElimina();
        }
    }
    public void eliminarMedio(int index){
        Nodo puntero = primero;
        Nodo punteroAn = null;
        int cont = 1;
        if (primero == null) {
            System.out.println("La lista esta vacia*****");
            secretaria.onError();
        }else if (index == 1) {
            eliminarInicio();
        }else if (index == longitud) {
            eliminarFinal();
        }else{
            while (cont != index) {
                punteroAn = puntero;
                puntero = puntero.siguiente ;
                cont++;
            }
            punteroAn.siguiente = puntero.siguiente;
            System.out.println("Paciente Antes con los siguientes datos: "+punteroAn.paciente.getNombre()+" "+punteroAn.paciente.getPaterno()
                                    +" "+punteroAn.paciente.getMaterno()+" con la edad: "+punteroAn.paciente.getEdad()
                                    +" con el numero de seguro social: "+punteroAn.paciente.getNumS()+" este es su siguiente: "
                                    +punteroAn.siguiente.paciente.getNombre()+"\n_______________________");
            System.out.println("Paciente Eliminado con los siguientes datos: "+puntero.paciente.getNombre()+" "+puntero.paciente.getPaterno()
                                    +" "+puntero.paciente.getMaterno()+" con la edad: "+puntero.paciente.getEdad()
                                    +" con el numero de seguro social: "+puntero.paciente.getNumS()+" este es su siguiente: "
                                    +puntero.siguiente+"\n_______________________");
            punteroAn.siguiente = puntero.siguiente;
            puntero = null;
            System.out.println("Paciente Despues con los siguientes datos: "+punteroAn.siguiente.paciente.getNombre()+" "+punteroAn.siguiente.paciente.getPaterno()
                                    +" "+punteroAn.siguiente.paciente.getMaterno()+" con la edad: "+punteroAn.siguiente.paciente.getEdad()
                                    +" con el numero de seguro social: "+punteroAn.paciente.getNumS()+" este es su siguiente: "
                                    +punteroAn.siguiente.siguiente+"\n_______________________");
             longitud--;
            secretaria.onElimina();
        }
    }
    public void eliminarFinal(){
        Nodo puntero = primero;
        Nodo punteroAn = null;
        if (primero == null) {
            System.out.println("La lista esta vacia******");
            secretaria.onError();
        }else if(longitud == 1){
            eliminarInicio();
        }else{
            while (puntero.siguiente != null) {
                   punteroAn = puntero;
                      System.out.println(punteroAn.paciente.getNombre());
                   puntero = puntero.siguiente;
                   System.out.println(puntero.paciente.getNombre());
            }
            punteroAn.siguiente = null;
            System.out.println("Paciente Antes con los siguientes datos: "+punteroAn.paciente.getNombre()+" "+punteroAn.paciente.getPaterno()
                                    +" "+punteroAn.paciente.getMaterno()+" con la edad: "+punteroAn.paciente.getEdad()
                                    +" con el numero de seguro social: "+punteroAn.paciente.getNumS()+" este es su siguiente: "
                                    +punteroAn.siguiente.paciente.getNombre()+"\n_______________________");
            System.out.println("Paciente Eliminado con los siguientes datos: "+puntero.paciente.getNombre()+" "+puntero.paciente.getPaterno()
                                    +" "+puntero.paciente.getMaterno()+" con la edad: "+puntero.paciente.getEdad()
                                    +" con el numero de seguro social: "+puntero.paciente.getNumS()+" este es su siguiente: "
                                    +puntero.siguiente+"\n_______________________");
            
            punteroAn.siguiente = null;
            puntero = null;
            longitud--;
            secretaria.onElimina();
        }
    }
    public int buscar(String nombre){
        int cont = 1;
        if (primero == null) {
            secretaria.onError();
            return 0;
        }else{
            Nodo puntero = primero;
            while (cont <= longitud) {
                if (nombre.equals(puntero.paciente.getNombre())) {
                    secretaria.onBuscar(puntero);
                    return cont;
                }
                cont++;
                puntero = puntero.siguiente;
            }
        }
        secretaria.onError();
        return 0;
    } 
    public void mostrar(){
        secretaria.onMostrar();
        Nodo puntero = primero;
        if (primero == null) {
            System.out.println("No hay Pacientes"); 
        }else{
            for (int i = 1; i <= longitud; i++) {
                System.out.println(i+"- "+puntero.paciente.getNombre()+" "+puntero.paciente.getPaterno()
                                    +" "+puntero.paciente.getMaterno()+" con la edad: "+puntero.paciente.getEdad()
                                    + " con el numero de seguro social: "+puntero.paciente.getNumS()+" con un siguiente: "
                                    +puntero.paciente+"\n _______________________");
                puntero = puntero.siguiente;
            
            }
        }
    }
    public interface onConsultorInterface{
        public void onAgregado();
        public void onElimina();
        public void onModificado();
        public void onBuscar(Nodo paciente);
        public void onError();
        public void onMostrar();
    }
}
