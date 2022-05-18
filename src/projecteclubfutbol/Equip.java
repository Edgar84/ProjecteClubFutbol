
package projecteclubfutbol;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import persones.Davanter;
import persones.Defensa;
import persones.Entrenador;
import persones.Jugador;
import persones.Migcampista;
import persones.Persona;
import persones.Plantilla;
import persones.Porter;
import persones.PreparadorFisic;
import persones.Soci;
import persones.Tecnic;
import utils.Dni;
import utils.Email;

public class Equip implements Serializable {
    
    private String nom;
    private Dni cif;
    private String adreça;
    private Email email;
    private String web;
    private String telefon;
    
    //private HashSet<Plantilla> hashPlantilla = new HashSet<>();
    //private HashSet<Soci> hashSocis = new HashSet<>();
    //private List<Soci> hashSocis = new ArrayList<>();
    private Map<String,Plantilla> hashPlantilla = new HashMap<>();
    private Map<String,Soci> hashSocis = new HashMap<>();
    
     
    boolean continua = false;
    
    public Equip (String nom, Dni cif, String adreça, Email email, String web, String telefon){
        this.nom = nom;
        this.cif = cif;
        this.adreça = adreça;
        this.email = email;
        this.web = web;
        this.telefon = telefon;
    }
    
    public Equip(){
    
    }
    
    
    // Getters
    public String getNom() {
        return this.nom;
    }
    public Dni getCif() {
        return cif;
    }
    public String getAdreça() {
        return adreça;
    }
    public Email getEmail() {
        return email;
    }
    public String getWeb() {
        return web;
    }
    
    //public void setHashSet(HashSet<Soci> hashSocis) {
    //    this.hashSocis = hashSocis;
    //}

    @Override
    public String toString() {
        return this.nom.toUpperCase() + "\nCIF: " + this.cif + "\nAdreça: " + this.adreça + "\nEmail: " + this.email + "\nWeb: " + this.web + "\n";
    }
    
    
    // Mètodes
    public void menu() throws IOException{
        Scanner teclat = new Scanner(System.in); 
        //boolean continua = false;
        
        do {
            System.out.println("|************MENU PRINCIPAL*************|");
            System.out.println("|                                       |");
            System.out.println("|      1.Consultar dades del club       |");
            System.out.println("|       2.Gestionar els socis           |");
            System.out.println("|      3.Gestionar la plantilla         |");
            System.out.println("|         4.Dades econòmiques           |");
            System.out.println("|             5.Sortir                  |");
            System.out.println("|                                       |");
            System.out.println("|***************************************|");
            
            int opcioMenu = teclat.nextInt();

            switch (opcioMenu){
                case 1:
                    System.out.println(this);;
                    break;
                case 2:
                    submenuSocis();
                    break;
                case 3:
                    submenuPlantilla();
                    break;
                case 4:
                    dadesEconomiques();
                    break;
                case 5:
                    guardarDades();
                    continua = true;
                    break;
                default:
                    guardarDades();
                    continua = true;
                    break;
            }
        }while(!continua);
    }
    
    public void submenuSocis() throws IOException{
        Scanner teclat = new Scanner(System.in);
        do {
            System.out.println("|************GESTIÓ DE SOCIS************|");
            System.out.println("|                                       |");
            System.out.println("|            1.Alta nou soci            |");
            System.out.println("|             2.Baixa soci              |");
            System.out.println("|           3.Modificar soci            |");
            System.out.println("|         4.Veure socis per cognom      |");
            System.out.println("|       5.Veure socis per localitat     |");
            System.out.println("|        6.Veure socis per quota        |");
            System.out.println("|               7.Tornar                |");
            System.out.println("|               8.Sortir                |");
            System.out.println("|                                       |");
            System.out.println("|***************************************|");
            
            int opcioMenu = teclat.nextInt();
            Soci soci = new Soci();
            String missatge = "";

            switch (opcioMenu){
                case 1:
                    soci.alta(hashSocis);
                    //altaPersones();
                    break;
                case 2:
                    //soci.baixa(hashSocis);
                    eliminarPersones(hashSocis);
                    break;
                case 3:
                    soci.modificar(hashSocis);
                    break;
                case 4:
                    socisPerCognom(toArrayList(hashSocis));
                    break;
                case 5:
                    //soci.socisPerLocalitat(hashSocis);
                    socisPerLocalitat(toArrayList(hashSocis));
                    break;
                case 6:
                    //soci.socisPerQuota(hashSocis);
                    socisPerQuota(toArrayList(hashSocis));
                    break;
                case 7:
                    menu();
                    break;
                case 8:
                    guardarDades();
                    continua = true;
                    break;
                default:
                    guardarDades();
                    continua = true;
                    break;
            }
        }while(!continua);
    }
    
    public void submenuPlantilla() throws IOException {
        Scanner teclat = new Scanner(System.in);
        Jugador jugador = new Jugador();
        Tecnic tecnic = new Tecnic();
        do {
            try{
                System.out.println("|**********GESTIONAR PLANTILLA**********|");
                System.out.println("|                                       |");
                System.out.println("|                1.Alta                 |");
                System.out.println("|               2.Baixa                 |");
                System.out.println("|              3.Modificar              |");
                System.out.println("|            4.Veure per rol            |");
                System.out.println("|       5.Veure per sou incentivat      |");
                System.out.println("|               6.Tornar                |");
                System.out.println("|               7.Sortir                |");
                System.out.println("|                                       |");
                System.out.println("|***************************************|");

                int opcioMenu = teclat.nextInt();

                switch (opcioMenu){
                    case 1:
                        altaPlantilla();
                        break;
                    case 2:
                        //jugador.baixa(hashPlantilla);
                        eliminarPersones(hashPlantilla);
                        break;
                    case 3:
                        modificarDadesPlantilla();
                        break;
                    case 4:
                        veurePerRol();
                        break;
                    case 5:
                        veurePerSouIncentivat(toArrayList(hashPlantilla));
                        break;
                    case 6:
                        submenuSocis();
                        break;
                    case 7:
                        guardarDades();
                        continua = true;
                        break;
                    default:
                        guardarDades();
                        continua = true;
                        break;
                }
            }catch (InputMismatchException ex){
                System.out.println("Opció incorrecta");
                teclat.next();
                continua = false;
            }
        }while(!continua);
    }
    
    public void dadesEconomiques(){
        double despeses = despesesClub();
        double ingresos = ingresosClub();
        double total = ingresos - despeses;
        System.out.println(this.getNom() + " ha obtingut uns ingresos de\n-   " + ingresos + "€");
        System.out.println("I un total de despeses de\n(equivalen al total dels incentius)\n-   " + despeses + "€");
        if(total > 0){
            System.out.println("Ha obtingut uns beneficis de : " + total);
        }else{
            System.out.println("Ha tingutt un dèficid de : " + total + "€");
        }
        
    }
    
    private double despesesClub(){
        double totalDespeses = 0;
        double totalSouBase = 0;
        double diferenciaSouBase = 0;
        
        Iterator<String> it = hashPlantilla.keySet().iterator();
        while(it.hasNext()){
            String dni = it.next();
            Plantilla plantilla = hashPlantilla.get(dni);
            totalSouBase += plantilla.getSouBaseAnual();
            diferenciaSouBase += plantilla.getSouTotal();
        }
        totalDespeses = diferenciaSouBase - totalSouBase;
        return totalDespeses;
    }
    
     private double ingresosClub(){
        double totalIngresos = 0;
        
        Iterator<String> it = hashSocis.keySet().iterator();
        while(it.hasNext()){
            String dni = it.next();
            Soci soci = hashSocis.get(dni);
            totalIngresos += soci.getQuotaAnual();
        }
        return totalIngresos;
    }
    
    
    public void guardarDades() throws FileNotFoundException, IOException{
        
        File fitxerEquip = new File("files/equip.bin");
        
        FileOutputStream flujoFicheroo = new FileOutputStream(fitxerEquip);
        ObjectOutputStream serialitzador = new ObjectOutputStream(flujoFicheroo);
        
        serialitzador.writeObject(this);
        serialitzador.writeObject(Soci.getNumSoci());               //mètodes estàtics
        serialitzador.writeObject(Soci.getNumLocalitat());          //mètodes estàtics
        serialitzador.writeObject(Plantilla.getNumEmpleat());       //mètodes estàtics
        serialitzador.writeObject(Jugador.getAsignarDorsal());      //mètodes estàtics
        serialitzador.writeObject(Jugador.getDorsalUsat());         //mètodes estàtics
        
        serialitzador.close();
    }
    
    public void altaPlantilla(){
        Scanner teclat = new Scanner(System.in);
        
        try {
            System.out.println("QUE VOLS DONAR D'ALTA?");
            System.out.println("1. Jugador");
            System.out.println("2. Tècnic");

            int opcioMenu = teclat.nextInt();

            switch (opcioMenu){
                case 1:
                    Jugador jugador = new Jugador();
                    jugador.alta(hashPlantilla);
                    break;
                case 2:
                    Tecnic tecnic = new Tecnic();
                    tecnic.alta(hashPlantilla);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("Opció incorrecta");
            teclat.nextInt();
            continua = false;
        }
    }
    
    public void modificarDadesPlantilla(){
        Scanner teclat = new Scanner(System.in);
        
        try {
            System.out.println("QUE VOLS EDITAR?");
            System.out.println("1. Jugador");
            System.out.println("2. Tècnic");

            int opcioMenu = teclat.nextInt();

            switch (opcioMenu){
                case 1:
                    Jugador jugador = new Jugador();
                    jugador.modificar(hashPlantilla);
                    break;
                case 2:
                    Tecnic tecnic = new Tecnic();
                    tecnic.modificar(hashPlantilla);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("Opció incorrecta");
            teclat.nextInt();
            continua = false;
        }
        
    }
    
    public void eliminarPersones(Map hashMapPerEliminar){
        
        Scanner teclat = new Scanner(System.in);
        String dni = "";
        String missatge = "Registre eliminat correctament";
        do {
            try{
                System.out.println("Escriu el DNI que vols donar de baixa:");
                dni = teclat.nextLine();
                while (!hashMapPerEliminar.containsKey(dni)) {                    
                    System.out.println("El DNI no coincideix amb el de cap registre");
                    dni = teclat.nextLine();
                }
                
                
                System.out.println("Estás segur que vols eliminar del registre:");
                System.out.println(hashMapPerEliminar.get(dni));
                System.out.println("s / n");
                String opcioMenu = teclat.nextLine();
                continua = true;

                switch(opcioMenu){
                    case "s":
                        if(hashMapPerEliminar.get(dni) instanceof Jugador){
                            Jugador jugadorPerEliminar = new Jugador();
                            jugadorPerEliminar = (Jugador)hashMapPerEliminar.get(dni);
                            jugadorPerEliminar.setDorsalUsat(jugadorPerEliminar.getDorsal());
                            missatge = "Jugador eliminat correctament del registre";
                        }else if(hashMapPerEliminar.get(dni) instanceof Tecnic){
                            missatge = "Tècnic eliminat correctament del registre";
                        }else if(hashMapPerEliminar.get(dni) instanceof Soci){
                            missatge = "Soci eliminat correctament del registre";
                        }
                        hashMapPerEliminar.remove(dni);
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
        
        System.out.println(missatge);
        continua = false;
    }
    
    
    public void socisPerCognom(ArrayList<Soci> arrSocis){
        
        Collections.sort(arrSocis);
        
        for(Soci s : arrSocis){
            System.out.println(s);
        }
    }
    
    public void socisPerLocalitat(ArrayList<Soci> arrSocis){
        arrSocis.sort(new Comparator<Soci>(){
            @Override
            public int compare(Soci s1, Soci s2){
                return s1.getLocalitat() - (s2.getLocalitat());
            }
        });
        mostrarArrayOrdenats(arrSocis);
    }
    
    public void socisPerQuota(ArrayList<Soci> arrSocis){
        arrSocis.sort(new Comparator<Soci>(){
            @Override
            public int compare(Soci s1, Soci s2){
                return (int)(s1.getQuotaAnual() - (s2.getQuotaAnual()));
            }
        });
        mostrarArrayOrdenats(arrSocis);
    }
    
    private ArrayList toArrayList(Map hashMapToArrList){
        Collection<Soci> values = hashMapToArrList.values();
        ArrayList<Soci> newArrayList = new ArrayList<>(values);
        return newArrayList;
    }
    
    private void mostrarArrayOrdenats(ArrayList arrayOrdenat){
        arrayOrdenat.forEach( (elem) -> System.out.println(elem) );
    }
    
    public  void veurePerRol(){
        System.out.println("\nENTRENADORS");
        hashPlantilla.entrySet().forEach(entry->{
            if(entry.getValue() instanceof Entrenador){
                System.out.println(entry.getValue());  
            }
        });
        System.out.println("\nPREPARADORS FÍSICS");
        hashPlantilla.entrySet().forEach(entry->{
            if(entry.getValue() instanceof PreparadorFisic){
                System.out.println(entry.getValue());  
            }
        }); 
        System.out.println("\nPORTERS");
        hashPlantilla.entrySet().forEach(entry->{
            if(entry.getValue() instanceof Porter){
                System.out.println(entry.getValue());  
            }
        }); 
        System.out.println("\nDEFENSES");
        hashPlantilla.entrySet().forEach(entry->{
            if(entry.getValue() instanceof Defensa){
                System.out.println(entry.getValue());  
            }
        }); 
        System.out.println("\nMIGCAMPISTES");
        hashPlantilla.entrySet().forEach(entry->{
            if(entry.getValue() instanceof Migcampista){
                System.out.println(entry.getValue());  
            }
        }); 
        System.out.println("\nDAVANTERS");
        hashPlantilla.entrySet().forEach(entry->{
            if(entry.getValue() instanceof Davanter){
                System.out.println(entry.getValue());  
            }
        }); 
        System.out.println("\n");
    }
    
    public void veurePerSouIncentivat(ArrayList<Plantilla> arrPlantilla){
        
        arrPlantilla.sort(new Comparator<Plantilla>(){
            @Override
            public int compare(Plantilla s1, Plantilla s2){
                return (int) ( (s1.getSouTotal() - s1.getSouBaseAnual()) - (s2.getSouTotal() - s2.getSouBaseAnual()) );
            }
        });
        mostrarArrayOrdenats(arrPlantilla);
    
    }
    
    public void altaPersones(){
       
       // Tècnics 
       hashPlantilla.put("12345678L", new Entrenador("Johan", "Cruyff", new Dni("12345678L"), LocalDate.parse("2005-12-02"), "645852001", new Email("johanCr@trr.com"), 222555333, 80000, 18, 5));
       hashPlantilla.put("12345678V", new PreparadorFisic("Elvis", "Presley", new Dni("12345678V"), LocalDate.parse("1995-02-05"), "962142001", new Email("theking@trr.com"), 444123333, 30000, 3));
       // Porter 
       hashPlantilla.put("12345678M", new Porter("Claudio", "Bravo", new Dni("12345678M"), LocalDate.parse("1992-11-06"), "699202001", new Email("cbravo@trr.com"), 111963333, 93000, true, 18, 9));
       // Defensa 
       hashPlantilla.put("12345678C", new Defensa("Alex", "Moreno", new Dni("12345678C"), LocalDate.parse("1990-02-09"), "653252001", new Email("amoreno@trr.com"), 999555123, 93000, true, 3, 6));
       hashPlantilla.put("12345678S", new Defensa("Marc", "Bartra", new Dni("12345678S"), LocalDate.parse("1989-03-22"), "622012001", new Email("mbartra@trr.com"), 777663333, 98500, true, 11, 15));
       hashPlantilla.put("12345678Q", new Defensa("Pezzella", "Nuit", new Dni("12345678Q"), LocalDate.parse("1998-08-14"), "337852001", new Email("pzzn@trr.com"), 881555333, 73000, false, 7, 2));
       hashPlantilla.put("12345338E", new Defensa("Sabaly", "Tuariz", new Dni("12345338E"), LocalDate.parse("1997-10-06"), "110252001", new Email("sabalyTuariz@trr.com"), 990533363, 73500, true, 9, 9));
       // Migcampista 
       hashPlantilla.put("12345678W", new Migcampista("William", "Carvalho", new Dni("12345678W"), LocalDate.parse("1996-12-30"), "669852001", new Email("wcarva@trr.com"), 123555312, 104000, true, 6, 3));
       hashPlantilla.put("12366678I", new Migcampista("Guido", "Rodriguez", new Dni("12366678I"), LocalDate.parse("1994-12-14"), "3695852001", new Email("guido_r@trr.com"), 555555333, 81300, true, 14, 7));
       hashPlantilla.put("15545678R", new Migcampista("Canales", "Codificados", new Dni("15545678R"), LocalDate.parse("1992-09-17"), "699602001", new Email("canalPlus@trr.com"), 778555003, 72600, false, 3, 1));
       hashPlantilla.put("12225678X", new Migcampista("Martín", "Montoya", new Dni("12225678X"), LocalDate.parse("2005-07-02"), "600122001", new Email("martinM@trr.com"), 287655113, 99650, true, 8, 4));
       hashPlantilla.put("12311678Z", new Migcampista("Hector", "Bellerín", new Dni("12311678Z"), LocalDate.parse("2002-08-23"), "699652001", new Email("H_Bellerin@trr.com"), 209255373, 77000, false, 5, 10));
       // Davanter 
       hashPlantilla.put("15335633E", new Davanter("Juanmi", "Jimenez", new Dni("15335633E"), LocalDate.parse("1992-07-17"), "693302051", new Email("j.j@trr.com"), 111531093, 74000, true, 3, 1));
       hashPlantilla.put("12091678V", new Davanter("Borja", "Iglesias", new Dni("12091678V"), LocalDate.parse("2005-07-18"), "600181101", new Email("iglesias@trr.com"), 255855053, 86050, true, 8, 4));
       hashPlantilla.put("12881678H", new Davanter("Fekir", "Napetiloun", new Dni("12881678H"), LocalDate.parse("2002-03-14"), "695552001", new Email("fNapetiloun@trr.com"), 283255398, 77300, true, 5, 10));
       // Socis 
       hashSocis.put("00311378R", new Soci("Tom", "Hanks", new Dni("00311378R"), LocalDate.parse("1984-03-14"), "644567601", new Email("tomH@gmail.com"), 450));
       hashSocis.put("88915678V", new Soci("Tom", "Sizemore", new Dni("88915678V"), LocalDate.parse("1981-08-14"), "644567601", new Email("toms@gmail.com"), 450));
       hashSocis.put("98011178B", new Soci("Edward", "Burns", new Dni("98011178B"), LocalDate.parse("1978-11-23"), "644567601", new Email("eDbUR@gmail.com"), 450));
       hashSocis.put("44351178Y", new Soci("Matt", "Damon", new Dni("44351178Y"), LocalDate.parse("1972-02-14"), "644567601", new Email("MattD@gmail.com"), 450));
       hashSocis.put("45671878Y", new Soci("Barry", "Pepper", new Dni("45671878Y"), LocalDate.parse("1999-05-04"), "644567601", new Email("Bpepper@gmail.com"), 450));
       hashSocis.put("10833178R", new Soci("Giovanni", "Ribisi", new Dni("10833178R"), LocalDate.parse("2006-03-02"), "644567601", new Email("GioRi@gmail.com"), 600));
       hashSocis.put("10810978J", new Soci("Adam", "Goldberg", new Dni("10810978J"), LocalDate.parse("1984-08-19"), "644567601", new Email("Adam@gmail.com"), 650));
       hashSocis.put("10811178K", new Soci("Jeremy", "Davies", new Dni("10811178K"), LocalDate.parse("2008-12-21"), "644567601", new Email("Jere@gmail.com"), 250));
       hashSocis.put("7762378M", new Soci("Vin", "Diesel", new Dni("7762378M"), LocalDate.parse("2010-07-18"), "644567601", new Email("vinDiesel@gmail.com"), 700));
       hashSocis.put("00917178N", new Soci("Ted", "Danson", new Dni("00917178N"), LocalDate.parse("2015-03-19"), "644567601", new Email("tedD@gmail.com"), 750));
       hashSocis.put("43516478U", new Soci("Paul", "Giamatti", new Dni("43516478U"), LocalDate.parse("1994-03-13"), "644567601", new Email("paulG@gmail.com"), 720));
       hashSocis.put("65713338R", new Soci("Max", "Martini", new Dni("65713338R"), LocalDate.parse("1970-11-14"), "644567601", new Email("MaxM@gmail.com"), 940));
       hashSocis.put("67112178O", new Soci("Dennis", "Farina", new Dni("67112178O"), LocalDate.parse("2020-05-15"), "644567601", new Email("DennisF@gmail.com"), 380));
       hashSocis.put("445100178P", new Soci("Harrison", "Young", new Dni("445100178P"), LocalDate.parse("1973-03-07"), "644567601", new Email("Harr@gmail.com"), 950));
       hashSocis.put("66718778W", new Soci("Kathleen", "Byron", new Dni("66718778W"), LocalDate.parse("2001-07-26"), "644567601", new Email("katBy@gmail.com"), 870));
       hashSocis.put("89911178Q", new Soci("Harve", "Presnell", new Dni("89911178Q"), LocalDate.parse("2002-06-29"), "644567601", new Email("Harv@gmail.com"), 330));
       hashSocis.put("90815558R", new Soci("Dale", "Dye", new Dni("90815558R"), LocalDate.parse("1996-02-21"), "644567601", new Email("DaleDye@gmail.com"), 970));
       hashSocis.put("88701178R", new Soci("Leland", "Orser", new Dni("88701178R"), LocalDate.parse("1993-01-03"), "644567601", new Email("lelaor@gmail.com"), 850));
       hashSocis.put("33211658T", new Soci("Bryan", "Cranston", new Dni("33211658T"), LocalDate.parse("1989-04-07"), "644567601", new Email("BryanCra@gmail.com"), 650));
       hashSocis.put("11488178E", new Soci("Nathan", "Fillion", new Dni("11488178E"), LocalDate.parse("1984-03-19"), "644567601", new Email("Nathan@gmail.com"), 1200));
       
    }
    
}
//hashPlantilla.put(new Porter(*******);
// new Davanter(*****)
// new Porter(*******);
// new Davanter(*******);



//out.writeObject(this);                        per guardar tot
// out.writeObject(Soci.getNumSocis())          mètodes estàtics
// out.writeObject(Soci.getNumLocalitats())     mètodes estàtics
// out.writeObject(Soci.getNumTreballador())    mètodes estàtics
// out.writeObject(Soci.getNumDorsals())        mètodes estàtics