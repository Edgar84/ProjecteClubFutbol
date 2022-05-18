
package persones;

import java.io.Serializable;
import java.time.LocalDate;
import utils.Dni;
import utils.Email;


public abstract class Plantilla extends Persona implements Serializable{
    
    static int numEmpleat;
    
    private int numSS;
    public double souBaseAnual;
    private int empleat;
    private double souTotal;

    public Plantilla(String nom, String cognom, Dni dni, LocalDate dataNaixement, String telefon, Email email, int numSS, double souBaseAnual) {
        super(nom, cognom, dni, dataNaixement, telefon, email);
        this.numSS = numSS;
        this.souBaseAnual = souBaseAnual;
        numEmpleat++;
        setEmpleat(getNumEmpleat());
    }

    public Plantilla() {
    }
    
    // Mètodes
    //public abstract double incrementarSou();
    
    // Getters
    public static int getNumEmpleat() {
        return numEmpleat;
    }
    
    public int getEmpleat(){
        return empleat;
    }

    public int getNumSS() {
        return numSS;
    }

    public double getSouBaseAnual() {
        return souBaseAnual;
    }

    public double getSouTotal() {
        return souTotal;
    }
    
    
    // Setters
    public static void setNumEmpleat(int numeroEmpleat) {
        numEmpleat = numeroEmpleat;
    }
    
    public void setEmpleat(int empleat) {
        this.empleat = empleat;
    }

    public void setNumSS(int numSS) {
        this.numSS = numSS;
    }

    public void setSouBaseAnual(double souBaseAnual) {
        this.souBaseAnual = souBaseAnual;
    }

    @Override
    public String toString() {
        return "NUM.EMPLEAT: " + this.getEmpleat() + "" + super.toString() + ", SS: " + this.getNumSS() + ", SOU BASE: " + this.getSouBaseAnual();
    }
    
    
    
}
