
package persones;

import java.io.Serializable;
import java.time.LocalDate;
import utils.Dni;
import utils.Email;


public class Migcampista extends Jugador implements Serializable{
    
    private int assitenciesGol;
    private int balonsRecuperats;
    private double souTotal;

    public Migcampista(String nom, String cognom, Dni dni, LocalDate dataNaixement, String telefon, Email email, int numSS, double souBaseAnual, boolean titular, int assitenciesGol, int balonsRecuperats) {
        super(nom, cognom, dni, dataNaixement, telefon, email, numSS, souBaseAnual, titular);
        this.assitenciesGol = assitenciesGol;
        this.balonsRecuperats = balonsRecuperats;
        this.souTotal = incrementarSou();
    }

    public Migcampista() {
        
    }
    
    public double incrementarSou() {
        // = sou base + (assistències gol * incentiu assistències gol) + (balons recuperats * incentiu balons recuperats)
        // per cada asistencia 2 | Per cada pilota recuperada incrementa 2
        double souTotalincrementat = getSouBaseAnual() + (getAssitenciesGol() * 2 ) + (getBalonsRecuperats() * 2);
        return souTotalincrementat;
    }

    //Getters y setters
    public int getAssitenciesGol() {
        return assitenciesGol;
    }

    public void setAssitenciesGol(int assitenciesGol) {
        this.assitenciesGol = assitenciesGol;
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
    
    public double getSouTotal() {
        return souTotal;
    }
    
    @Override
    public String toString() {
        return super.toString() + "  TOTAL INCENTIUS: " + (getSouTotal() - getSouBaseAnual());
    }
}
