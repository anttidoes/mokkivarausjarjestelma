package src.dao;

import src.model.*;
import src.database.Database;

import java.sql.*;
import java.util.*;


public class AsiakasDAO {

    public Yksityishenkilo haeYksityishenkilo(int asiakasId) {
        String sql = "SELECT * FROM Asiakas " +
                "JOIN Yksityishenkilo USING(asiakas_id) " +
                "JOIN Postialue USING(postinumero) WHERE asiakas_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, asiakasId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Postialue pa = new Postialue(rs.getString("postinumero"), rs.getString("kunta"), rs.getString("maa"));
                return new Yksityishenkilo(
                        rs.getInt("asiakas_id"),
                        rs.getString("katuosoite"),
                        rs.getString("email"),
                        rs.getString("puhelin"),
                        pa,
                        rs.getString("etunimi"),
                        rs.getString("sukunimi")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Yritys haeYritys(int asiakasId) {
        String sql = "SELECT * FROM Asiakas " +
                "JOIN Yritys USING(asiakas_id) " +
                "JOIN Postialue USING(postinumero) WHERE asiakas_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, asiakasId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Postialue pa = new Postialue(rs.getString("postinumero"), rs.getString("kunta"), rs.getString("maa"));
                return new Yritys(
                        rs.getInt("asiakas_id"),
                        rs.getString("katuosoite"),
                        rs.getString("email"),
                        rs.getString("puhelin"),
                        pa,
                        rs.getString("yrityksen_nimi"),
                        rs.getString("y_tunnus")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

