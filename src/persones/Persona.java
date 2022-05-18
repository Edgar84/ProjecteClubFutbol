
package persones;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import utils.Dni;
import utils.Email;

public abstract class Persona implements Serializable {
    
    private String nom;
    private String cognom;
    private Dni dni;
    private LocalDate dataNaixement;  //localDate.parse("2005-12-02")
    protected String telefon;
    protected Email email;

    // Constructor
    public Persona(String nom, String cognom, Dni dni, LocalDate dataNaixement, String telefon, Email email) {
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
        this.dataNaixement = dataNaixement;
        this.telefon = telefon;
        this.email = email;
    }
    
    public Persona(){
    
    }
    

    // Métodes
    public abstract void alta(Map hashmap);
    public abstract void baixa(Map hashmap);
    public abstract void modificar(Map hashmap);
    
    
    
    //Getters
    public String getNom() {    
        return nom;
    }

    public String getCognom() {
        return this.cognom;
    }

    public Dni getDni() {
        return dni;
    }

    public LocalDate getDataNaixement() {
        return dataNaixement;
    }

    public String getTelefon() {
        return telefon;
    }
    
    public Email getEmail() {    
        return email;
    }
    // Setters

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return " - " + this.getNom() + " " + this.getCognom() + ", DNI: " + this.getDni() + ", DATA NAIXEMENT: " + this.getDataNaixement() + ", TELEFON: " + this.getTelefon() + ", EMAIL: " + this.getEmail();
    }
    
    
    
}
