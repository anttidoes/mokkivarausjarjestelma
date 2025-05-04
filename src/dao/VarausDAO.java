package src.dao;

import src.model.*;
import src.database.Database;

import java.sql.*;
import java.util.*;


public class VarausDAO {
    public List<Varaus> haeKaikkiVaraukset() {
        List<Varaus> varaukset = new ArrayList<>();
        String sql = "SELECT * FROM Varaus";
        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                varaukset.add(new Varaus(
                        rs.getInt("varaus_id"),
                        rs.getInt("asiakas_id"),
                        rs.getInt("mokki_id"),
                        rs.getDate("alkupvm"),
                        rs.getDate("loppupvm"),
                        rs.getDate("varaus_pvm")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return varaukset;
    }
}
