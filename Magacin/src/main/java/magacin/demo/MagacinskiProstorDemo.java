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
            //MagacinskiProstor noviProstor = new MagacinskiProstor(0, "Trem", 1);
            //service.addMagacinskiProstor(noviProstor);
            //System.out.println("Uspesno dodat magacinski prostor: " + noviProstor);

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
            int prostorId = 8; // Mora postojati magacinski prostor sa zadatim ID-om
            service.deleteMagacinskiProstor(prostorId);
            System.out.println("Uspesno obrisan magacinski prostor sa ID-jem " + prostorId + ".");
           
        } catch (MagacinException e) {
            System.err.println("Doslo je do greske: " + e.getMessage());
            e.printStackTrace();
        }
    }
}