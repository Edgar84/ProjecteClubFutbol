
package persones;

import java.io.Serializable;
import java.time.LocalDate;
import utils.Dni;
import utils.Email;


public class Entrenador extends Tecnic implements Serializable{
    
    private int numTrofeus;
    private double souTotal;

    public Entrenador(String nom, String cognom, Dni dni, LocalDate dataNaixement, String telefon, Email email, int numSS, double souBaseAnual, int anysExperiencia, int numTrofeus) {
        super(nom, cognom, dni, dataNaixement, telefon, email, numSS, souBaseAnual, anysExperiencia);
        this.numTrofeus = numTrofeus;
        this.souTotal = incrementarSou();
    }
    
    public Entrenador(){
        
    }
    
    public double incrementarSou() {
        // cada trofeu incrementa 5
        double souTotalincrementat = getSouBaseAnual() + (getNumTrofeus() * 5);
        return souTotalincrementat;
    }
    
    // Getters
    public int getNumTrofeus() {
        return numTrofeus;
    }
    
    @Override
    public double getSouBaseAnual() {
        return souBaseAnual;
    }
    
    // Setters
    public void setNumTrofeus(int numTrofeus) {
        this.numTrofeus = numTrofeus;
    }
    
    public double getSouTotal() {
        return souTotal;
    }
    
    @Override
    public String toString() {
        return super.toString() + " TROFEUS : " + this.getNumTrofeus() + "  TOTAL INCENTIUS: " + (getSouTotal() - getSouBaseAnual()); 
    }

    
}
