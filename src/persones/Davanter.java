
package persones;

import java.io.Serializable;
import java.time.LocalDate;
import utils.Dni;
import utils.Email;


public class Davanter extends Jugador implements Serializable{
    
    private int golsFets;
    private int balonsRecuperats;
    private double souTotal;

    public Davanter(String nom, String cognom, Dni dni, LocalDate dataNaixement, String telefon, Email email, int numSS, double souBaseAnual, boolean titular, int golsFets, int balonsRecuperats) {
        super(nom, cognom, dni, dataNaixement, telefon, email, numSS, souBaseAnual, titular);
        this.golsFets = golsFets;
        this.balonsRecuperats = balonsRecuperats;
        this.souTotal = incrementarSou();
    }

    public Davanter() {
    }
    
    public double incrementarSou() {
        // SOU = sou base + (gols marcats * incentiu gols marcats) + (balons recuperats * incentiu g balons recuperats)
        // per cada gol incrementa 5 | Per cada pilota recuperada incrementa 2
        double souTotalincrementat = getSouBaseAnual() + (getGolsFets() * 5 ) + (getBalonsRecuperats() * 2);
        return souTotalincrementat;
    }
    
    // Getters
    public int getGolsFets() {
        return golsFets;
    }

    public int getBalonsRecuperats() {
        return balonsRecuperats;
    }

    public double getSouBaseAnual() {
        return souBaseAnual;
    }
    
    // Setters
    public void setGolsFets(int golsFets) {
        this.golsFets = golsFets;
    }

    public void setBalonsRecuperats(int balonsRecuperats) {
        this.balonsRecuperats = balonsRecuperats;
    }

    public double getSouTotal() {
        return souTotal;
    }
    
    @Override
    public String toString() {
        return super.toString() + "  TOTAL INCENTIUS: " + (getSouTotal() - getSouBaseAnual());
    }
    
}
