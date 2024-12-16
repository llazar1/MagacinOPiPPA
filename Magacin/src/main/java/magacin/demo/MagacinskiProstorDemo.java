/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magacin.demo;

/**
 *
 * @author Lazar Lazarevic
 */
import magacin.data.MagacinskiProstor;
import magacin.exception.MagacinException;
import magacin.service.MagacinskiProstorService;

import java.util.List;

public class MagacinskiProstorDemo {

    public static void main(String[] args) {
        MagacinskiProstorService service = new MagacinskiProstorService();

        try {
            
            // Dodavanje magacinskog prostora sa ID-jem radnika 
            //MagacinskiProstor noviProstor = new MagacinskiProstor(0, "Hala 1", 1);
            //MagacinskiProstor noviProstor = new MagacinskiProstor(0, "Hala 2", 2);
            //MagacinskiProstor noviProstor = new MagacinskiProstor(0, "Skladiste A", 3);
            //MagacinskiProstor noviProstor = new MagacinskiProstor(0, "Skladiste B", 4);
            //MagacinskiProstor noviProstor = new MagacinskiProstor(0, "Hala 3", 8);
            //MagacinskiProstor noviProstor = new MagacinskiProstor(0, "Skladiste C", 9);
            //MagacinskiProstor noviProstor = new MagacinskiProstor(0, "Hala 4", 10);
            //MagacinskiProstor noviProstor = new MagacinskiProstor(0, "Hala 5", 11);
            //MagacinskiProstor noviProstor = new MagacinskiProstor(0, "Skladiste D", 12);
            //MagacinskiProstor noviProstor = new MagacinskiProstor(0, "Skladiste E", 14);
            MagacinskiProstor noviProstor = new MagacinskiProstor(0, "Hala 6", 13);
            
            service.addMagacinskiProstor(noviProstor);
            System.out.println("Uspesno dodat magacinski prostor: " + noviProstor);

            // Dobijanje magacinskog prostora po ID-u
            //MagacinskiProstor prostor = service.getMagacinskiProstorById(1);
            //System.out.println("Dobijeni magacinski prostor: " + prostor);

            // Azuriranje naziva magacniskog prostora
            //prostor.setNaziv("Glavni magacin NOV");
            //service.updateMagacinskiProstor(prostor);
            //System.out.println("Uspesno azuriran magacinski prostor: " + prostor);

            // Prikaz svih magacinskih prostora
            //List<MagacinskiProstor> prostori = service.getAllMagacinskiProstori();
            //System.out.println("Svi magacinski prostori:");
            //for (MagacinskiProstor p : prostori) {
            //    System.out.println(p);
            //}

            // Brisanje magacinskog prostora
            //int prostorId = 8; // Mora postojati magacinski prostor sa zadatim ID-om
            //service.deleteMagacinskiProstor(prostorId);
            //System.out.println("Uspesno obrisan magacinski prostor sa ID-jem " + prostorId + ".");
           
        } catch (MagacinException e) {
            System.err.println("Doslo je do greske: " + e.getMessage());
            e.printStackTrace();
        }
    }
}