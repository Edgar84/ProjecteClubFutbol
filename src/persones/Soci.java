
package persones;

import java.util.*;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.Collator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import sun.security.pkcs11.P11Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;
import utils.Dni;
import utils.Email;

public class Soci extends Persona implements Serializable, Comparable<Soci> {
    
    static int numSoci = 0;
    static int numLocalitat = 500;
    private double quotaAnual;
    private int soci;
    private int localitat;
    
    
    // Constructor
    public Soci(String nom, String cognom, Dni dni, LocalDate dataNaixement, String telefon, Email email, double quotaAnual) {
        super(nom, cognom, dni, dataNaixement, telefon, email);
        this.quotaAnual = quotaAnual;
        numSoci++;
        numLocalitat++;
        this.soci = getNumSoci();
        this.localitat = getNumLocalitat();
    }
    
    public Soci(){
    }
    
     
    // Mètodes
    
    @Override
    public void alta(Map hashSocis){
        hashSocis.put("44910978J", new Soci("Philippe", "Lacheau", new Dni("44910978J"), LocalDate.parse("1984-08-19"), "646667601", new Email("Lacheau@gmail.com"), 1950));
        hashSocis.put("221811178K", new Soci("Élodie", "Fontan", new Dni("221811178K"), LocalDate.parse("2008-12-21"), "614567001", new Email("EFontan@gmail.com"), 3690));
        hashSocis.put("65923780M", new Soci("Julien", "Arruti", new Dni("65923780M"), LocalDate.parse("2010-07-18"), "610927601", new Email("ArrutiJulien@gmail.com"), 960));
        System.out.println("Nou soci donat d'alta");
    }
    
    @Override
    public void modificar(Map hashSocis){
        Scanner teclat = new Scanner(System.in);
        boolean continua = false;
        String dni = "";
        Soci sociAmodificar = new Soci();
        
        do {
            System.out.println("Escriu el DNI del soci a modificar:");
            dni = teclat.nextLine();
            while (!hashSocis.containsKey(dni)) {                    
                System.out.println("El DNI no coincideix amb el de cap soci");
                dni = teclat.nextLine();
            }
            sociAmodificar = (Soci)hashSocis.get(dni);
            System.out.println(sociAmodificar);
            modificarDades(sociAmodificar);
            continua = true;
        }while (!continua);  
    }
    
    private void modificarDades(Soci sociAmodificar){
        Scanner teclat = new Scanner(System.in);
        boolean continua = false;
        Email emailNou = null;
        String telNou = "";
        double quotaNova = 0;
        
        do {
            try{
                System.out.println("Vols editar el Telèfon?");
                System.out.println("s / n");
                String opcioMenu = teclat.nextLine();
                continua = true;

                switch(opcioMenu){
                    case "s":
                        System.out.println("Escriu el nou telèfon:");
                        telNou = teclat.nextLine();
                        sociAmodificar.setTelefon(telNou);
                    case "n":
                        continua = true;
                        break;
                    default:
                        System.out.println("Opció incorrecta");
                        continua = false;
                        break;
                }
                continua = true;
            }catch (InputMismatchException ex){
                System.out.println("Opció incorrecta");
                teclat.next();
                continua = false;
            }
        }while (!continua);
        
        do {
            try{
                System.out.println("Vols editar el Email?");
                System.out.println("s / n");
                String opcioMenu = teclat.nextLine();
                continua = true;

                switch(opcioMenu){
                    case "s":
                        System.out.println("Escriu el nou Email:");
                        emailNou = new Email(teclat.nextLine());
                        sociAmodificar.setEmail(emailNou);
                    case "n":
                        continua = true;
                        break;
                    default:
                        System.out.println("Opció incorrecta");
                        continua = false;
                        break;
                }
                continua = true;
            }catch (InputMismatchException ex){
                System.out.println("Opció incorrecta");
                teclat.next();
                continua = false;
            }
        }while (!continua);
        
        do {
            try{
                System.out.println("Vols editar la quota anual?");
                System.out.println("s / n");
                String opcioMenu = teclat.nextLine();
                continua = true;

                switch(opcioMenu){
                    case "s":
                        System.out.println("Introdueix la nova quota:");
                        quotaNova = teclat.nextDouble();
                        sociAmodificar.setQuotaAnual(quotaNova);
                    case "n":
                        continua = true;
                        break;
                    default:
                        System.out.println("Opció incorrecta");
                        continua = false;
                        break;
                }
                continua = true;
            }catch (InputMismatchException ex){
                System.out.println("Opció incorrecta");
                teclat.next();
                continua = false;
            }
        }while (!continua);
        
        System.out.println("Dades editades correctament");
        System.out.println(sociAmodificar);
        
    }
    
    @Override
    public void baixa(Map hashSocis){
        Scanner teclat = new Scanner(System.in);
        boolean continua = false;
        String dni = "";
        Soci sociPerEliminar = new Soci();
        
        do {
            try{
                System.out.println("Escriu el DNI del soci que vols doanr de baixa:");
                dni = teclat.nextLine();
                while (!hashSocis.containsKey(dni)) {                    
                    System.out.println("El DNI no coincideix amb el de cap soci");
                    dni = teclat.nextLine();
                }
                sociPerEliminar = (Soci)hashSocis.get(dni);
                
                System.out.println("Estás segur que vols eliminar del registre:");
                System.out.println(sociPerEliminar);
                System.out.println("s / n");
                String opcioMenu = teclat.nextLine();
                continua = true;

                switch(opcioMenu){
                    case "s":
                        hashSocis.remove(dni);
                    case "n":
                        continua = true;
                        break;
                    default:
                        System.out.println("Opció incorrecta");
                        continua = false;
                        break;
                }
                continua = true;
            
            }catch (InputMismatchException ex){
                System.out.println("Opció incorrecta");
                teclat.next();
                continua = false;
            }
        }while (!continua); 
        
        System.out.println("Soci eliminat correctament del registre");
    }
    
    
    // Getters
    public static int getNumSoci() {
        return numSoci;
    }
    
    public int getSoci() {
        return soci;
    }

    public static int getNumLocalitat() {
        return numLocalitat;
    }
    
    public int getLocalitat() {
        return localitat;
    }

    public double getQuotaAnual() {
        return quotaAnual;
    }
    
    // Setters
    public static void setNumSoci(int numeroSoci) {
        numSoci = numeroSoci;
    }

    public static void setNumLocalitat(int numeroLocalitat) {
        //numLocalitat++;
        numLocalitat = numeroLocalitat;
    }

    public void setQuotaAnual(double quotaAnual) {
        this.quotaAnual = quotaAnual;
    }
    
    public void setNumEmail(Email email) {
        this.email = email;
    }
    
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    @Override
    public String toString() {
        return "NUM SOCI:" + this.getSoci() + super.toString() + ", LOCALITAT: " + this.getLocalitat() + ", QUOTA ANUAL: " + this.getQuotaAnual(); 
    }

    @Override
    public int compareTo(Soci soci) {
        return this.getCognom().compareTo(soci.getCognom());
    }
}