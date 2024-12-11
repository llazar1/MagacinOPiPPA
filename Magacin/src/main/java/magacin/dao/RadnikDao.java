/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magacin.dao;

/**
 *
 * @author Lazar Lazarevic
 */
import magacin.data.Radnik;
import magacin.exception.MagacinException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RadnikDao {

    public void create(Connection con, Radnik radnik) throws MagacinException {
        String query = "INSERT INTO radnik (ime_i_prezime, username, password, telefon) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            // Pretpostavlja se da se ime i prezime kombinuju kao jedno polje
            ps.setString(1, radnik.getIme() + " " + radnik.getPrezime());
            ps.setString(2, radnik.getUsername());
            ps.setString(3, radnik.getPassword());
            ps.setString(4, radnik.getTelefon());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new MagacinException("Error creating Radnik", ex);
        }
    }

    public Radnik read(Connection con, int id) throws MagacinException {
        String query = "SELECT * FROM radnik WHERE radnik_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Radnik(
                            rs.getInt("radnik_id"),
                            rs.getString("ime_i_prezime").split(" ")[0], // Pretpostavlja se da je ime i prezime spojeno
                            rs.getString("ime_i_prezime").split(" ")[1], // Splićenje za prezime
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("telefon")
                    );
                }
            }
        } catch (SQLException ex) {
            throw new MagacinException("Error reading Radnik", ex);
        }
        return null;
    }

    public void update(Connection con, Radnik radnik) throws MagacinException {
        String query = "UPDATE radnik SET ime_i_prezime = ?, username = ?, password = ?, telefon = ? WHERE radnik_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, radnik.getIme() + " " + radnik.getPrezime());
            ps.setString(2, radnik.getUsername());
            ps.setString(3, radnik.getPassword());
            ps.setString(4, radnik.getTelefon());
            ps.setInt(5, radnik.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new MagacinException("Error updating Radnik", ex);
        }
    }

    public void delete(Connection con, int id) throws MagacinException {
        String query = "DELETE FROM radnik WHERE radnik_id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new MagacinException("Error deleting Radnik", ex);
        }
    }

    public List<Radnik> readAll(Connection con) throws MagacinException {
        String query = "SELECT * FROM radnik";
        List<Radnik> resultList = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                resultList.add(new Radnik(
                        rs.getInt("radnik_id"),
                        rs.getString("ime_i_prezime").split(" ")[0], // Pretpostavlja se da je ime i prezime spojeno
                        rs.getString("ime_i_prezime").split(" ")[1], // Splićenje za prezime
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("telefon")
                ));
            }
        } catch (SQLException ex) {
            throw new MagacinException("Error reading all Radnik", ex);
        }
        return resultList;
    }

    public Radnik getByUsernameAndPassword(String username, String password, Connection con) throws MagacinException {
        String query = "SELECT * FROM radnik WHERE username = ? AND password = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Radnik(
                            rs.getInt("radnik_id"),
                            rs.getString("ime_i_prezime").split(" ")[0], // Pretpostavlja se da je ime i prezime spojeno
                            rs.getString("ime_i_prezime").split(" ")[1], // Splićenje za prezime
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("telefon")
                    );
                } else {
                    return null; // Ako radnik nije pronađen, vraća se null
                }
            }
        } catch (SQLException ex) {
            throw new MagacinException("Error fetching Radnik by username and password", ex);
        }
    }
}