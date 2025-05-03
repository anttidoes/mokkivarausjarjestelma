package src.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        primaryStage.setTitle("Mökkivarausjärjestelmä");
        setRoot("MainMenu");  // Loads MainMenu.fxml from /resources/fxml/
        primaryStage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/" + fxml + ".fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}


/*
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
*/