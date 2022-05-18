
package persones;

import java.io.Serializable;
import java.time.LocalDate;
import utils.Dni;
import utils.Email;


public class PreparadorFisic extends Tecnic implements Serializable{
    
    //private int anysExperiencia;
    private double souTotal;

    public PreparadorFisic(String nom, String cognom, Dni dni, LocalDate dataNaixement, String telefon, Email email, int numSS, double souBaseAnual, int anysExperiencia) {
        super(nom, cognom, dni, dataNaixement, telefon, email, numSS, souBaseAnual, anysExperiencia);
        this.souTotal = incrementarSou();
    }

    public PreparadorFisic() {
        
    }
    
    public double incrementarSou() {
        // cada any d'experiencia incrementa 3
        double souTotalincrementat = getSouBaseAnual() + (getAnysExperiencia() * 3 );
        return souTotalincrementat;
    }
    
    // Getters
    
    @Override
    public int getAnysExperiencia() {
        return anysExperiencia;
    }

    @Override
    public double getSouBaseAnual() {
        return souBaseAnual;
    }
    
    // Setters
    
    @Override
    public void setSouBaseAnual(double souBaseAnual) {
        this.souBaseAnual = souBaseAnual;
    }

    @Override
    public void setAnysExperiencia(int anysExperiencia) {
        this.anysExperiencia = anysExperiencia;
    }
    
    public double getSouTotal() {
        return souTotal;
    }

    @Override
    public String toString() {
        return super.toString() + " EXPERIENCIA: " + this.getAnysExperiencia() + "  TOTAL INCENTIUS: " + (getSouTotal() - getSouBaseAnual()); 
    }
    
    
}
