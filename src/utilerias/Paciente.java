/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilerias;

/**
 *
 * @author Ismael
 */
public class Paciente {
    private String nombre, paterno, materno, edad, numS;
    
    public Paciente(String nombre,String paterno,String materno,String edad,String num){
      this.nombre = nombre;
      this.paterno = paterno;
      this.materno = materno;
      this.edad = edad;
      this.numS = num;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNumS() {
        return numS;
    }

    public void setNumS(String numS) {
        this.numS = numS;
    }
    
}
