/*
package moekkikodit.db;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:sqlite:moekkikodit.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}





public class MokkiTietokantaYhteys {

    public static void main(String[] args) {

        String host = "jdbc:derby://localhost:1527/MokkiDB";
        String uName = "Your_Username_Here";
        String uPass = "Your_Password_Here";

        try {
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM Mokki";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String nimi = rs.getString("Nimi");
                String sijainti = rs.getString("Sijainti");
                double hinta = rs.getDouble("HintaPerYo");

                System.out.println(id + " " + nimi + " " + sijainti + " " + hinta + "€/yö");
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
}
*/