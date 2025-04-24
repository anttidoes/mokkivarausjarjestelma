package src.dao;

import model.Mokki;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MokkiDAO {
    private Connection conn;

    public MokkiDAO(String dbUrl) throws SQLException {
        this.conn = DriverManager.getConnection(dbUrl);
    }

    public void lisaaMokki(Mokki mokki) throws SQLException {
        String sql = "INSERT INTO mokki (mokki_id, nimi, katuosoite, postinumero, hinta, kuvaus) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, mokki.getMokkiId());
            stmt.setString(2, mokki.getNimi());
            stmt.setString(3, mokki.getKatuosoite());
            stmt.setString(4, mokki.getPostinumero());
            stmt.setDouble(5, mokki.getHinta());
            stmt.setString(6, mokki.getKuvaus());
            stmt.executeUpdate();
        }
    }

    public List<Mokki> haeKaikkiMokit() throws SQLException {
        List<Mokki> lista = new ArrayList<>();
        String sql = "SELECT * FROM mokki";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Mokki m = new Mokki(
                        rs.getInt("mokki_id"),
                        rs.getString("nimi"),
                        rs.getString("katuosoite"),
                        rs.getString("postinumero"),
                        rs.getDouble("hinta"),
                        rs.getString("kuvaus")
                );
                lista.add(m);
            }
        }
        return lista;
    }

    public void poistaMokki(int id) throws SQLException {
        String sql = "DELETE FROM mokki WHERE mokki_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // Lisää halutessa päivitäMokki(...) metodi
}
