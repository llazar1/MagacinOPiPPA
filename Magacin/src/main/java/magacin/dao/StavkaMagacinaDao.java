/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magacin.dao;

/**
 *
 * @author Lazar Lazarevic
 */
import magacin.data.StavkaMagacina;
import magacin.exception.MagacinException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StavkaMagacinaDao {

    public void create(Connection con, StavkaMagacina stavka) throws MagacinException {
        String query = "INSERT INTO proizvod (naziv, tip, tezina, kolicina, napomena, prostor_id) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, stavka.getNaziv());
            ps.setString(2, stavka.getTip());
            ps.setFloat(3, stavka.getTezina());
            ps.setInt(4, stavka.getKolicina());
            ps.setString(5, stavka.getNapomena());
            ps.setInt(6, stavka.getProstorId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new MagacinException("Error creating StavkaMagacina", ex);
        } finally {
            try {
                ResourcesManager.closeResources(null, ps);
            } catch (SQLException ex) {
                throw new MagacinException("Error closing resources", ex);
            }
        }
    }

    public StavkaMagacina read(Connection con, int proizvodId) throws MagacinException {
        String query = "SELECT * FROM proizvod WHERE proizvod_id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, proizvodId);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new StavkaMagacina(
                        rs.getInt("proizvod_id"),
                        rs.getString("naziv"),
                        rs.getString("tip"),
                        rs.getFloat("tezina"),
                        rs.getInt("kolicina"),
                        rs.getString("napomena"),
                        rs.getInt("prostor_id")
                );
            }
        } catch (SQLException ex) {
            throw new MagacinException("Error reading StavkaMagacina", ex);
        } finally {
            try {
                ResourcesManager.closeResources(rs, ps);
            } catch (SQLException ex) {
                throw new MagacinException("Error closing resources", ex);
            }
        }
        return null;
    }

    public void update(Connection con, StavkaMagacina stavka) throws MagacinException {
        String query = "UPDATE proizvod SET naziv = ?, tip = ?, tezina = ?, kolicina = ?, napomena = ?, prostor_id = ? WHERE proizvod_id = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, stavka.getNaziv());
            ps.setString(2, stavka.getTip());
            ps.setFloat(3, stavka.getTezina());
            ps.setInt(4, stavka.getKolicina());
            ps.setString(5, stavka.getNapomena());
            ps.setInt(6, stavka.getProstorId());
            ps.setInt(7, stavka.getProizvodId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new MagacinException("Error updating StavkaMagacina", ex);
        } finally {
            try {
                ResourcesManager.closeResources(null, ps);
            } catch (SQLException ex) {
                throw new MagacinException("Error closing resources", ex);
            }
        }
    }

    public void delete(Connection con, int proizvodId) throws MagacinException {
        String query = "DELETE FROM proizvod WHERE proizvod_id = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, proizvodId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new MagacinException("Error deleting StavkaMagacina", ex);
        } finally {
            try {
                ResourcesManager.closeResources(null, ps);
            } catch (SQLException ex) {
                throw new MagacinException("Error closing resources", ex);
            }
        }
    }

    public List<StavkaMagacina> search(Connection con, String naziv, String tip) throws MagacinException {
        String query = "SELECT * FROM proizvod WHERE naziv LIKE ? AND tip LIKE ?";
        List<StavkaMagacina> resultList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, "%" + naziv + "%");
            ps.setString(2, "%" + tip + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                resultList.add(new StavkaMagacina(
                        rs.getInt("proizvod_id"),
                        rs.getString("naziv"),
                        rs.getString("tip"),
                        rs.getFloat("tezina"),
                        rs.getInt("kolicina"),
                        rs.getString("napomena"),
                        rs.getInt("prostor_id")
                ));
            }
        } catch (SQLException ex) {
            throw new MagacinException("Error searching StavkaMagacina", ex);
        } finally {
            try {
                ResourcesManager.closeResources(rs, ps);
            } catch (SQLException ex) {
                throw new MagacinException("Error closing resources", ex);
            }
        }
        return resultList;
    }

    public List<StavkaMagacina> getAll(Connection con) throws MagacinException {
        String query = "SELECT * FROM proizvod";
        List<StavkaMagacina> resultList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                resultList.add(new StavkaMagacina(
                        rs.getInt("proizvod_id"),
                        rs.getString("naziv"),
                        rs.getString("tip"),
                        rs.getFloat("tezina"),
                        rs.getInt("kolicina"),
                        rs.getString("napomena"),
                        rs.getInt("prostor_id")
                ));
            }
        } catch (SQLException ex) {
            throw new MagacinException("Error reading all StavkaMagacina", ex);
        } finally {
            try {
                ResourcesManager.closeResources(rs, ps);
            } catch (SQLException ex) {
                throw new MagacinException("Error closing resources", ex);
            }
        }
        return resultList;
    }
}
