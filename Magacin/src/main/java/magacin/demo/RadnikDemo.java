/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magacin.demo;

/**
 *
 * @author Lazar Lazarevic
 */
import magacin.data.Radnik;
import magacin.exception.MagacinException;
import magacin.service.RadnikService;

import java.util.List;

public class RadnikDemo {
    public static void main(String[] args) {
        RadnikService radnikService = new RadnikService();

        try {
            // Dodavanje radnika
            //Radnik radnikZaKreiranje = new Radnik(0, "Ivana", "Kostic", "ivanak555", "ivkost555", "0622233445");
            //radnikService.addRadnik(radnikZaKreiranje);
            //System.out.println("Uspesno dodat radnik: " + radnikZaKreiranje);

            // Ispis svih radnika iz baze
            List<Radnik> radnici = radnikService.getAllRadnici();
            if (radnici.isEmpty()) {
                System.out.println("Nema radnika u bazi.");
            } else {
                System.out.println("Lista svih radnika:");
                for (Radnik radnik : radnici) {
                    System.out.println(radnik);
                }
            }

            /*
            // Dobijanje radnika po ID-u
            Radnik radnik = radnikService.getRadnikById(2); // Pretpostavlja se da je ID 2 validan
            System.out.println("Dobijen radnik po ID-u: " + radnik);

            // Azuriranje podataka radnika
            if (radnik != null) {
                radnik.setTelefon("061546474");
                radnikService.updateRadnik(radnik);
                System.out.println("Uspesno azuriran radnik: " + radnik);
            }
            */

            /*
            // Brisanje radnika
            int radnikId = 7; // Mora postojati radnik sa zadatim ID-om
            radnikService.deleteRadnik(radnikId);
            System.out.println("Uspesno obrisan radnik sa ID-jem " + radnikId);
            */

        } catch (MagacinException e) {
            System.err.println("Doslo je do greske: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
