import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;


public class database {
    public static void main(String[] args) {

        // tämä on kaikilla sama, kun käytetään setup_test.sql
        String url = "jdbc:mysql://localhost:3306/lomakyla";
        /*
        // TODO: saada tämä toimimaan mielummin
        // nämä haetaan ympäristömuuttujina
        String user = System.getenv("OTI_USER");
        String password = System.getenv("OTI_PASS");

        if (user != null && password != null) {
            System.out.println("Environment variables: OK");
        }
        else {
            System.out.println("Environment variables: null");
            System.exit(1);
        }
        */

        String user = null;
        String password = null;
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/db_credentials.properties")) {
            properties.load(fis);
            user = properties.getProperty("db.username");
            password = properties.getProperty("db.password");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }



        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            if (connection != null) {
                System.out.println("Connected to the database!");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }


}