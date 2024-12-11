/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magacin.data;

/**
 *
 * @author Lazar Lazarevic
 */
public class StavkaMagacina {
    private int proizvodId;  
    private String naziv;
    private String tip;
    private float tezina;
    private int kolicina;
    private String napomena;
    private int prostorId;  

    public StavkaMagacina() {}

    public StavkaMagacina(int proizvodId, String naziv, String tip, float tezina, int kolicina, String napomena, int prostorId) {
        this.proizvodId = proizvodId;
        this.naziv = naziv;
        this.tip = tip;
        this.tezina = tezina;
        this.kolicina = kolicina;
        this.napomena = napomena;
        this.prostorId = prostorId;
    }

    public int getProizvodId() { return proizvodId; }
    public void setProizvodId(int proizvodId) { this.proizvodId = proizvodId; }

    public String getNaziv() { return naziv; }
    public void setNaziv(String naziv) { this.naziv = naziv; }

    public String getTip() { return tip; }
    public void setTip(String tip) { this.tip = tip; }

    public float getTezina() { return tezina; }
    public void setTezina(float tezina) { this.tezina = tezina; }

    public int getKolicina() { return kolicina; }
    public void setKolicina(int kolicina) { this.kolicina = kolicina; }

    public String getNapomena() { return napomena; }
    public void setNapomena(String napomena) { this.napomena = napomena; }

    public int getProstorId() { return prostorId; }
    public void setProstorId(int prostorId) { this.prostorId = prostorId; }

    @Override
    public String toString() {
        return "StavkaMagacina{" +
                "proizvodId=" + proizvodId +
                ", naziv='" + naziv + '\'' +
                ", tip='" + tip + '\'' +
                ", tezina=" + tezina +
                ", kolicina=" + kolicina +
                ", napomena='" + napomena + '\'' +
                ", prostorId=" + prostorId +
                '}';
    }
}