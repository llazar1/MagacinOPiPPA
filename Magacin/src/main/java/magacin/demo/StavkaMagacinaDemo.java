/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magacin.demo;

/**
 *
 * @author Lazar Lazarevic
 */
import magacin.data.StavkaMagacina;
import magacin.exception.MagacinException;
import magacin.service.StavkaMagacinaService;

public class StavkaMagacinaDemo {
    public static void main(String[] args) {
        StavkaMagacinaService stavkaService = new StavkaMagacinaService();

        try {
            // Dodavanje stavke
            //StavkaMagacina novaStavka = new StavkaMagacina(1, "Cevi", "Vodovod", 10 , 30, "Ekstra cena", 1);
            //stavkaService.addStavka(novaStavka);
            //System.out.println("Uspesno dodata stavka: " + novaStavka);

            //Dobijanje stavke po ID-u
            StavkaMagacina stavka = stavkaService.getStavkaById(6);
            System.out.println("Dobijena stavka po ID-u: " + stavka);

            // Auriranje stavke 
            if (stavka != null) {
                stavka.setNaziv("Kada");
                stavka.setTip("Kupatilo");
                stavka.setTezina(40.5f); 
                stavka.setKolicina(10); 
                stavka.setNapomena("Bela boja"); 
                stavkaService.updateStavka(stavka);
                System.out.println("Uspesno azurirana stavka: " + stavka);
            }

            // Brisanje stavke iz magacina
            //int stavkaId = 4; // Mora postojati stavka sa zadatim ID-om
            //stavkaService.deleteStavka(stavkaId);
            //System.out.println("Uspesno obrisana stavka sa ID-jem " + stavkaId);

        } catch (MagacinException e) {
            System.err.println("Doslo je do greske: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
