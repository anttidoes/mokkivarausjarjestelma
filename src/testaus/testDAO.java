package src.testaus;

import src.dao.*;
import src.model.*;

import java.util.List;

/**
 * Tällä testataan DAO luokkien toimivuus
 */
public class testDAO {

    public static void main(String[] args) {
        testaaLaskuDAO();
        testaaAsiakasDAO();
        testaaVarausDAO();
        testaaMokkiDAO();
    }


    private static void testaaLaskuDAO() {
        LaskuDAO dao = new LaskuDAO();

        System.out.println("== Maksamattomat laskut ==");
        List<Lasku> maksamattomat = dao.haeMaksamattomatLaskut();
        for (Lasku l : maksamattomat) {
            System.out.println("Lasku ID: " + l.getLaskuId() + ", Summa: " + l.getSumma() + ", Maksettu: " + l.isMaksettu());
        }

        if (!maksamattomat.isEmpty()) {
            int testiLaskuId = maksamattomat.get(0).getLaskuId();
            System.out.println("Merkitään lasku " + testiLaskuId + " maksetuksi...");
            dao.merkitseMaksetuksi(testiLaskuId);
        }
    }


    private static void testaaAsiakasDAO() {
        AsiakasDAO dao = new AsiakasDAO();

        System.out.println("== Haetaan yksityishenkilö ID:llä 1 ==");
        Yksityishenkilo y = dao.haeYksityishenkilo(1);
        if (y != null)
            System.out.println(y.getEtunimi() + " " + y.getSukunimi() + " (" + y.getEmail() + ")");

        System.out.println("== Haetaan yritys ID:llä 2 ==");
        Yritys yritys = dao.haeYritys(2);
        if (yritys != null)
            System.out.println(yritys.getYrityksenNimi() + " (" + yritys.getYtunnus() + ")");
    }


    private static void testaaVarausDAO() {
        VarausDAO dao = new VarausDAO();

        System.out.println("== Kaikki varaukset ==");
        for (Varaus v : dao.haeKaikkiVaraukset()) {
            System.out.println("Varaus ID: " + v.getVarausId() + ", Asiakas ID: " + v.getAsiakasId() + ", Alkaa: " + v.getAlku());
        }
    }


    private static void testaaMokkiDAO() {
        MokkiDAO dao = new MokkiDAO();

        System.out.println("== Haetaan mökki ID:llä 1 ==");
        Mokki m = dao.haeMokki(1);
        if (m != null)
            System.out.println(m.getNimi() + ", " + m.getKatuosoite() + " (" + m.getHinta() + " €/yö)");
    }
}

