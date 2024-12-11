/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magacin.dao;

/**
 *
 * @author Lazar Lazarevic
 */
import magacin.data.MagacinskiProstor;
import magacin.exception.MagacinException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MagacinskiProstorDao {

    // Metod za kreiranje novog magacinskog prostora
    public void create(Connection con, MagacinskiProstor prostor) throws MagacinException {
        String query = "INSERT INTO prostor (ime_magacina, radnik_id) VALUES (?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, prostor.getNaziv());
            ps.setInt(2, prostor.getRadnikId());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    prostor.setId(rs.getInt(1));
                }
            }
        } catch (SQLException ex) {
            throw new MagacinException("Error creating prostor", ex);
        }
    }

    // Metod za čitanje magacinskog prostora na osnovu ID-a
    public MagacinskiProstor read(Connection con, int prostorId) throws MagacinException {
        String query = "SELECT * FROM prostor WHERE prostor_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, prostorId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new MagacinskiProstor(
                        rs.getInt("prostor_id"),
                        rs.getString("ime_magacina"),
                        rs.getInt("radnik_id")
                    );
                }
            }
        } catch (SQLException ex) {
            throw new MagacinException("Error fetching prostor by ID", ex);
        }
        return null;
    }

    // Metod za ažuriranje magacinskog prostora
    public void update(Connection con, MagacinskiProstor prostor) throws MagacinException {
        String query = "UPDATE prostor SET ime_magacina = ?, radnik_id = ? WHERE prostor_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, prostor.getNaziv());
            ps.setInt(2, prostor.getRadnikId());
            ps.setInt(3, prostor.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new MagacinException("Error updating prostor", ex);
        }
    }

    // Metod za brisanje magacinskog prostora
    public void delete(Connection con, int prostorId) throws MagacinException {
        String query = "DELETE FROM prostor WHERE prostor_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, prostorId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new MagacinException("Error deleting prostor", ex);
        }
    }

    // Metod za dobijanje svih magacinskih prostora
    public List<MagacinskiProstor> getAll(Connection con) throws MagacinException {
        String query = "SELECT * FROM prostor";
        List<MagacinskiProstor> resultList = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                resultList.add(new MagacinskiProstor(
                    rs.getInt("prostor_id"),
                    rs.getString("ime_magacina"),
                    rs.getInt("radnik_id")
                ));
            }
        } catch (SQLException ex) {
            throw new MagacinException("Error reading all prostor", ex);
        }
        return resultList;
    }
}