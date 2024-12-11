/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magacin.data;

/**
 *
 * @author Lazar Lazarevic
 */
public class MagacinskiProstor {
    private int id;
    private String naziv;
    private int radnikId; // Dodato polje za povezivanje sa radnikom

    public MagacinskiProstor() {}

    public MagacinskiProstor(int id, String naziv, int radnikId) {
        this.id = id;
        this.naziv = naziv;
        this.radnikId = radnikId;
    }

    // Getteri i setteri
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getRadnikId() { // Getter za radnikId
        return radnikId;
    }

    public void setRadnikId(int radnikId) { // Setter za radnikId
        this.radnikId = radnikId;
    }

    @Override
    public String toString() {
        return "MagacinskiProstor{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", radnikId=" + radnikId +
                '}';
    }
}
