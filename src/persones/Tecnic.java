
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


public class Tecnic extends Plantilla implements Serializable{
    
    public int anysExperiencia;
    private double souTotal;
    
    // Constructors
    public Tecnic(String nom, String cognom, Dni dni, LocalDate dataNaixement, String telefon, Email email, int numSS, double souBaseAnual, int anysExperiencia) {
        super(nom, cognom, dni, dataNaixement, telefon, email, numSS, souBaseAnual);
        this.anysExperiencia = anysExperiencia;
    }

    public Tecnic() {
    }
    
    @Override
    public void alta(Map hashPlantilla) {
        hashPlantilla.put("55845699T", new PreparadorFisic("Nou preparador", "García", new Dni("55845699T"), LocalDate.parse("1991-04-12"), "944442601", new Email("nouPreparador@trr.com"), 422923332, 14000, 1));
        System.out.println("Nou Tècnic Afegit");
    }
    /*
    @Override
    public void baixa(Map hashPlantilla) {
        Scanner teclat = new Scanner(System.in);
        boolean continua = false;
        String dni = "";
        Tecnic tecnicPerEliminar = new Tecnic();
        
        do {
            try{
                System.out.println("Escriu el DNI del tècnic que vols doanr de baixa:");
                dni = teclat.nextLine();
                while (!hashPlantilla.containsKey(dni)) {                    
                    System.out.println("El DNI no coincideix amb el de cap tècnic");
                    dni = teclat.nextLine();
                }
                tecnicPerEliminar = (Tecnic)hashPlantilla.get(dni);

                System.out.println("Estás segur que vols eliminar del registre:");
                System.out.println(tecnicPerEliminar);
                System.out.println("s / n");
                String opcioMenu = teclat.nextLine();
                continua = true;

                switch(opcioMenu){
                    case "s":
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
        
        System.out.println("Tècnic eliminat correctament del registre");
    }
    */
    @Override
    public void modificar(Map hashPlantilla){
        Scanner teclat = new Scanner(System.in);
        boolean continua = false;
        String dni = "";
        Tecnic tecnicAmodificar = new Tecnic();
        
        do {
            System.out.println("Escriu el DNI del jugador a modificar:");
            dni = teclat.nextLine();
            while (!hashPlantilla.containsKey(dni) || hashPlantilla.get(dni) instanceof Jugador) {                    
                System.out.println("El DNI no coincideix amb el de cap tècnic");
                dni = teclat.nextLine();
            }
            tecnicAmodificar = (Tecnic)hashPlantilla.get(dni);
            System.out.println(tecnicAmodificar);
            modificarDades(tecnicAmodificar);
            continua = true;
        }while (!continua);  
    }
    
    public void modificarDades(Tecnic tecnicAmodificar) {
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
                        tecnicAmodificar.setTelefon(telNou);
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
                        tecnicAmodificar.setEmail(emailNou);
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
                        tecnicAmodificar.setSouBaseAnual(souBaseNou);
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
        System.out.println(tecnicAmodificar);
    }

    
    // Getters
    public int getAnysExperiencia() {
        return anysExperiencia;
    }

    public double getSouTotal() {
        return souTotal;
    }
    
    // Setters

    public void setAnysExperiencia(int anysExperiencia) {
        this.anysExperiencia = anysExperiencia;
    }
    
    public void setSouTotal(double souTotal) {
        this.souTotal = souTotal;
    }

    @Override
    public void baixa(Map hashmap) {
        System.out.println("Donar de baixa a un tècnic");
    }

}
