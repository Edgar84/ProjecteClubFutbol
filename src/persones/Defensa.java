
package persones;

import java.io.Serializable;
import java.time.LocalDate;
import utils.Dni;
import utils.Email;


public class Defensa extends Jugador implements Serializable{
    
    private int atacsAturats;
    private int balonsRecuperats;
    private double souTotal;

    public Defensa(String nom, String cognom, Dni dni, LocalDate dataNaixement, String telefon, Email email, int numSS, double souBaseAnual, boolean titular, int atacsAturats, int balonsRecuperats) {
        super(nom, cognom, dni, dataNaixement, telefon, email, numSS, souBaseAnual, titular);
        this.atacsAturats = atacsAturats;
        this.balonsRecuperats = balonsRecuperats;
        this.souTotal = incrementarSou();
    }

    public Defensa() {
    }
    
    public double incrementarSou() {
        // sou base + (atacs aturats * incentiu a.a) + (balons recuperats * incentiu balons recuperats)
        // per cada atac aturat 4 | Per cada pilota recuperada incrementa 2
        double souTotalincrementat = getSouBaseAnual() + (getAtacsAturats() * 4 ) + (getBalonsRecuperats() * 2);
        return souTotalincrementat;
    }
    
    public double getSouTotal() {
        return souTotal;
    }

    public int getAtacsAturats() {
        return atacsAturats;
    }

    public void setAtacsAturats(int atacsAturats) {
        this.atacsAturats = atacsAturats;
    }

    public int getBalonsRecuperats() {
        return balonsRecuperats;
    }

    public void setBalonsRecuperats(int balonsRecuperats) {
        this.balonsRecuperats = balonsRecuperats;
    }

    public double getSouBaseAnual() {
        return souBaseAnual;
    }

    public void setSouBaseAnual(double souBaseAnual) {
        this.souBaseAnual = souBaseAnual;
    }
    
    @Override
    public String toString() {
        return super.toString() + "  TOTAL INCENTIUS: " + (getSouTotal() - getSouBaseAnual());
    }
    
}
