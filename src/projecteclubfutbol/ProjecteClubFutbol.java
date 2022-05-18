
package projecteclubfutbol;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashSet;
import persones.Jugador;
import persones.Plantilla;
import persones.Soci;
import persones.Tecnic;
import utils.Dni;
import utils.Email;

public class ProjecteClubFutbol implements Serializable{

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        Equip trr = new Equip("Tàrrega F.C.", new Dni("8523659C"), "Av. Tarragona s/n", new Email("fctarrega@trr.com"), "www.trr.com", "93456852896");  
        
        if(new File("files/equip.bin").exists()){
            File fitxerEquip = new File("files/equip.bin");
            FileInputStream flujoFichero = new FileInputStream(fitxerEquip);
            ObjectInputStream deserializador = new ObjectInputStream(flujoFichero);
            
            trr = (Equip)deserializador.readObject();
            
            //Soci.setLocalitat((int)int.readObject());
            Soci.setNumSoci((int)deserializador.readObject());              //mètodes estàtics
            Soci.setNumLocalitat((int)deserializador.readObject());         //mètodes estàtics
            Plantilla.setNumEmpleat((int)deserializador.readObject());      //mètodes estàtics
            Jugador.setAsignarDorsal((int)deserializador.readObject());     //mètodes estàtics
            Jugador.setDorsalUsat((int)deserializador.readObject());        //mètodes estàtics
            
            deserializador.close();
        }else{
            trr.altaPersones();
        }
        
        trr.menu();
        
    }
    
}
