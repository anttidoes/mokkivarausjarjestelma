package src;

import src.dao.MokkiDAO;
import model.Mokki;
import src.model.Mokki;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            String dbUrl = "jdbc:sqlite:mokkitietokanta.db";
            MokkiDAO dao = new MokkiDAO(dbUrl);

            // Testaa mökin lisäys
            Mokki uusi = new Mokki(1, "Huvila Koivu", "Koivutie 1", "80100", 120.0, "Kaunis mökki järven rannalla");
            dao.lisaaMokki(uusi);

            // Tulosta kaikki mökit
            List<Mokki> mokit = dao.haeKaikkiMokit();
            for (Mokki m : mokit) {
                System.out.println(m.getNimi() + " - " + m.getHinta() + "€");
            }

            // Testaa mökin poisto (kommentoi jos et halua poistaa)
            // dao.poistaMokki(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
