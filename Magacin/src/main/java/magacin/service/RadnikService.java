/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magacin.service;

/**
 *
 * @author Lazar Lazarevic
 */
import magacin.dao.RadnikDao;
import magacin.data.Radnik;
import magacin.exception.MagacinException;
import magacin.dao.ResourcesManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RadnikService {

    private RadnikDao radnikDao;

    public RadnikService() {
        this.radnikDao = new RadnikDao();
    }

    // Login metod za proveru korisničkog imena i šifre
    public Radnik login(String username, String password) throws MagacinException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            con.setAutoCommit(false);  // Disable auto-commit to manage transaction manually

            Radnik radnik = radnikDao.getByUsernameAndPassword(username, password, con);
            
            con.commit(); // Commit transaction if everything is fine
            return radnik;

        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            throw new MagacinException("Error while logging in", ex);
        } finally {
            try {
                ResourcesManager.closeConnection(con);
            } catch (MagacinException e) {
                throw new MagacinException("Failed to close connection", e);
            }
        }
    }

    // Metod za dodavanje novog radnika
    public void addRadnik(Radnik radnik) throws MagacinException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            con.setAutoCommit(false);  // Disable auto-commit

            radnikDao.create(con, radnik);

            con.commit(); // Commit transaction if everything is fine
        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            throw new MagacinException("Error while adding radnik", ex);
        } finally {
            try {
                ResourcesManager.closeConnection(con);
            } catch (MagacinException e) {
                throw new MagacinException("Failed to close connection", e);
            }
        }
    }

    // Metod za ažuriranje podataka o radniku
    public void updateRadnik(Radnik radnik) throws MagacinException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            con.setAutoCommit(false);  // Disable auto-commit

            radnikDao.update(con, radnik);

            con.commit(); // Commit transaction if everything is fine
        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            throw new MagacinException("Error while updating radnik", ex);
        } finally {
            try {
                ResourcesManager.closeConnection(con);
            } catch (MagacinException e) {
                throw new MagacinException("Failed to close connection", e);
            }
        }
    }

    // Metod za brisanje radnika
    public void deleteRadnik(int radnikId) throws MagacinException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            con.setAutoCommit(false);  // Disable auto-commit

            radnikDao.delete(con, radnikId);

            con.commit(); // Commit transaction if everything is fine
        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            throw new MagacinException("Error while deleting radnik", ex);
        } finally {
            try {
                ResourcesManager.closeConnection(con);
            } catch (MagacinException e) {
                throw new MagacinException("Failed to close connection", e);
            }
        }
    }

    // Metod za dobijanje svih radnika
    public List<Radnik> getAllRadnici() throws MagacinException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            con.setAutoCommit(false);  // Disable auto-commit

            List<Radnik> radnici = radnikDao.readAll(con);

            con.commit(); // Commit transaction if everything is fine
            return radnici;

        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            throw new MagacinException("Error while fetching radnici", ex);
        } finally {
            try {
                ResourcesManager.closeConnection(con);
            } catch (MagacinException e) {
                throw new MagacinException("Failed to close connection", e);
            }
        }
    }

    // Metod za dobijanje radnika po ID-u
    public Radnik getRadnikById(int id) throws MagacinException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            con.setAutoCommit(false);  // Disable auto-commit

            Radnik radnik = radnikDao.read(con, id); // Poziva se metoda read iz RadnikDao

            con.commit(); // Commit transaction if everything is fine
            return radnik;

        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            throw new MagacinException("Error while fetching Radnik by ID", ex);
        } finally {
            try {
                ResourcesManager.closeConnection(con);
            } catch (MagacinException e) {
                throw new MagacinException("Failed to close connection", e);
            }
        }
    }
}
