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
            //Dodavanje stavke
            //StavkaMagacina novaStavka = new StavkaMagacina(0, "Cevi", "Vodovod", 10 , 30, "Ekstra cena", 5);
            //StavkaMagacina novaStavka = new StavkaMagacina(0, "Prsluci", "Garderoba", 5 , 100, "Dobavljac Printex", 8);
            //StavkaMagacina novaStavka = new StavkaMagacina(0, "Kablovi", "Elektricni", 50, 100, "Visok kvalitet bakra", 10);
            //StavkaMagacina novaStavka = new StavkaMagacina(0, "Plocice", "Keramicke", 200, 500, "Razlicite dimenzije i boje", 9);
            //StavkaMagacina novaStavka = new StavkaMagacina(0, "Baterije", "Litijumske", 30, 60, "Dug vek trajanja", 6);
            //StavkaMagacina novaStavka = new StavkaMagacina(0, "Namestaj", "Kancelarijski", 20, 50, "Ergonomski dizajn", 5);
            //StavkaMagacina novaStavka = new StavkaMagacina(0, "Papir", "Stampacki", 500, 1000, "A4 format", 9);
            //StavkaMagacina novaStavka = new StavkaMagacina(0, "Uredjaji", "Kuhinjski", 10, 20, "Energetski efikasni uređaji", 6);
            //StavkaMagacina novaStavka = new StavkaMagacina(0, "Drvo", "Gradjevinsko", 80, 250, "Suvo i obradjeno", 8);
            StavkaMagacina novaStavka = new StavkaMagacina(0, "Alati", "Rucno", 15, 45, "Profesionalni alati", 10);
            
            stavkaService.addStavka(novaStavka);
            System.out.println("Uspesno dodata stavka: " + novaStavka);

            //Dobijanje stavke po ID-u
 /*           StavkaMagacina stavka = stavkaService.getStavkaById(6);
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
*/
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
