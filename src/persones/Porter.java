
package persones;

import java.io.Serializable;
import java.time.LocalDate;
import utils.Dni;
import utils.Email;

public class Porter extends Jugador implements Serializable{
    
    private int golsAturats;
    private int golsRebuts;
    private double souTotal;

    public Porter(String nom, String cognom, Dni dni, LocalDate dataNaixement, String telefon, Email email,int numSS, double souBaseAnual, boolean titular, int golsAturats, int golsRebuts) {
        super(nom, cognom, dni, dataNaixement, telefon, email, numSS, souBaseAnual, titular);
        this.golsAturats = golsAturats;
        this.golsRebuts = golsRebuts;
        this.souTotal = incrementarSou();
    }

    public Porter() {
    }
    
    public double incrementarSou() {
        // sou base + (gols aturats * incentiu g.a.)
        // per cada gol aturat 3 
        double souTotalincrementat = getSouBaseAnual() + (getGolsAturats() * 3 );
        return souTotalincrementat;
    }

    
    public int getGolsAturats() {
        return golsAturats;
    }

    public void setGolsAturats(int golsAturats) {
        this.golsAturats = golsAturats;
    }

    public int getGolsRebuts() {
        return golsRebuts;
    }

    public void setGolsRebuts(int golsRebuts) {
        this.golsRebuts = golsRebuts;
    }

    public double getSouTotal() {
        return souTotal;
    }
    
    

    @Override
    public double getSouBaseAnual() {
        return souBaseAnual;
    }

    @Override
    public void setSouBaseAnual(double souBaseAnual) {
        this.souBaseAnual = souBaseAnual;
    }

    @Override
    public String toString() {
        return super.toString() + "  TOTAL INCENTIUS: " + (getSouTotal() - getSouBaseAnual());
    }
    
    
    
}
