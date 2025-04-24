package src.model;

public class Mokki {

private int MokkiId;
private String nimi;
private String katuosoite;
private String postinumero;
private double hinta;
private String kuvaus;



    // Konstruktori
    public Mokki(int mokkiId, String nimi, String katuosoite, String postinumero, double hinta, String kuvaus) {
        this.MokkiId = mokkiId;
        this.nimi = nimi;
        this.katuosoite = katuosoite;
        this.postinumero = postinumero;
        this.hinta = hinta;
        this.kuvaus = kuvaus;
    }


    // Getterit ja setterit...
    public int getMokkiId() { return MokkiId; }
    public String getNimi() { return nimi; }
    public void setNimi(String nimi) { this.nimi = nimi; }
    // Lisää muut getterit ja setterit


}





