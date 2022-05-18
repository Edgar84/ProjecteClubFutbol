
package persones;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import utils.Dni;
import utils.Email;

public class Jugador extends Plantilla implements Serializable{
    
    static int asignarDorsal;
    static int dorsalUsat = 0;
    
    private int dorsal;
    private boolean titular;
    
    // Constructors
    public Jugador(String nom, String cognom, Dni dni, LocalDate dataNaixement, String telefon, Email email, int numSS, double souBaseAnual, boolean  titular) {
        super(nom, cognom, dni, dataNaixement, telefon, email, numSS, souBaseAnual);
        this.titular = titular;
        if(dorsalUsat == 0){
            //setAsignarDorsal();
            asignarDorsal++;
            setDorsal(getAsignarDorsal());
        }else{
            setDorsal(getDorsalUsat());
            dorsalUsat = 0;
        }
        
    }

    public Jugador() {
    }
    
    // Metodes

    @Override
    public void alta(Map hashPlantilla) {
        hashPlantilla.put("32145678K", new Porter("Nou", "Porter", new Dni("32145678K"), LocalDate.parse("1990-03-11"), "691107201", new Email("nouPorter@trr.com"), 111963385, 150000, false, 6, 4));
        //hashPlantilla.put("12399378A", new Defensa("Nou", "Migcampista", new Dni("12399378A"), LocalDate.parse("1999-09-09"), "603284201", new Email("nouMigcampista@trr.com"), 229522123, 3000, true, 4, 2));
        System.out.println("Nou Jugador Afegit");
    }
    /*
    @Override
    public void baixa(Map hashPlantilla) {
        Scanner teclat = new Scanner(System.in);
        boolean continua = false;
        String dni = "";
        Jugador jugadorPerEliminar = new Jugador();
        
        do {
            try{
                System.out.println("Escriu el DNI del jugador que vols doanr de baixa:");
                dni = teclat.nextLine();
                while (!hashPlantilla.containsKey(dni)) {                    
                    System.out.println("El DNI no coincideix amb el de cap jugador");
                    dni = teclat.nextLine();
                }
                jugadorPerEliminar = (Jugador)hashPlantilla.get(dni);

                System.out.println("Estás segur que vols eliminar del registre:");
                System.out.println(jugadorPerEliminar);
                System.out.println("s / n");
                String opcioMenu = teclat.nextLine();
                continua = true;

                switch(opcioMenu){
                    case "s":
                        System.out.println("ELIMINAR: " + jugadorPerEliminar.getNom() + " - " + jugadorPerEliminar.getDorsal());
                        jugadorPerEliminar.setDorsalUsat(jugadorPerEliminar.getDorsal());
                        hashPlantilla.remove(dni);
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
        
        System.out.println("Jugador eliminat correctament del registre");
    }
    */
    @Override
    public void modificar(Map hashPlantilla){
        Scanner teclat = new Scanner(System.in);
        boolean continua = false;
        String dni = "";
        Jugador jugadorAmodificar = new Jugador();
        
        do {
            System.out.println("Escriu el DNI del jugador a modificar:");
            dni = teclat.nextLine();
            while (!hashPlantilla.containsKey(dni) || hashPlantilla.get(dni) instanceof Tecnic) {                    
                System.out.println("El DNI no coincideix amb el de cap jugador");
                dni = teclat.nextLine();
            }
            jugadorAmodificar = (Jugador)hashPlantilla.get(dni);
            System.out.println(jugadorAmodificar);
            modificarDades(jugadorAmodificar);
            continua = true;
        }while (!continua);  
    }
    
    public void modificarDades(Jugador jugadorAmodificar) {
        Scanner teclat = new Scanner(System.in);
        boolean continua = false;
        Email emailNou = null;
        String telNou = "";
        double souBaseNou = 0;
        boolean titularNou = false;
        
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
                        jugadorAmodificar.setTelefon(telNou);
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
                        jugadorAmodificar.setEmail(emailNou);
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
                System.out.println("Vols editar el sou base anual?");
                System.out.println("s / n");
                String opcioMenu = teclat.nextLine();
                continua = true;

                switch(opcioMenu){
                    case "s":
                        System.out.println("Introdueix el nou sou:");
                        souBaseNou = teclat.nextDouble();
                        jugadorAmodificar.setSouBaseAnual(souBaseNou);
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
                System.out.println("Vols editar la titularitat?");
                System.out.println("s / n");
                String opcioMenu = teclat.nextLine();
                continua = true;

                switch(opcioMenu){
                    case "s":
                        System.out.println("Introdueix el nou valor:");
                        try{
                            switch(opcioMenu){
                                case "s":
                                    titularNou = true;
                                    break;
                                case "n":
                                    titularNou = false;
                                    break;
                                default:
                                    System.out.println("Opció incorrecta");
                                    continua = false;
                                    break;
                            }
                        }catch (InputMismatchException ex){
                            System.out.println("Opció incorrecta");
                            teclat.next();
                            continua = false;
                        }
                        jugadorAmodificar.setTitular(titularNou);
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
        System.out.println(jugadorAmodificar);
    }
    
    // Getters
    public static int getAsignarDorsal() {
        return asignarDorsal;
    }

    public int getDorsal() {
        return dorsal;
    }

    public boolean isTitular() {
        return titular;
    }
    
    public static int getDorsalUsat(){
        return dorsalUsat;
    }
    
    // Setters
    public static void setAsignarDorsal(int asignarNumeroDorsal) {
        asignarDorsal = asignarNumeroDorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public void setTitular(boolean titular) {
        this.titular = titular;
    }
    
    public static void setDorsalUsat(int numDorsalUsat){
        dorsalUsat = numDorsalUsat;
    }

    @Override
    public String toString() {
        return super.toString() + ", DORSAL: " + this.getDorsal() + ", TITULAR: " + (this.isTitular() == true ? "Si" : "No") ; 
    }

    @Override
    public void baixa(Map hashmap) {
        System.out.println("Donar de baixa un Jugador");
    }
    

    
}
