/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magacin.service;

/**
 *
 * @author Lazar Lazarevic
 */
import magacin.dao.StavkaMagacinaDao;
import magacin.data.StavkaMagacina;
import magacin.exception.MagacinException;
import magacin.dao.ResourcesManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StavkaMagacinaService {

    private StavkaMagacinaDao stavkaMagacinaDao;

    public StavkaMagacinaService() {
        this.stavkaMagacinaDao = new StavkaMagacinaDao();
    }

    // Metod za pretragu stavki po nazivu i tipu
    public List<StavkaMagacina> searchStavke(String naziv, String tip) throws MagacinException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            con.setAutoCommit(false);

            List<StavkaMagacina> stavke = stavkaMagacinaDao.search(con, naziv, tip);
            
            con.commit();
            return stavke;

        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            throw new MagacinException("Error while searching stavke", ex);
        } finally {
            try {
                ResourcesManager.closeConnection(con);
            } catch (MagacinException e) {
                throw new MagacinException("Failed to close connection", e);
            }
        }
    }

    // Metod za dodavanje nove stavke u magacin
    public void addStavka(StavkaMagacina stavka) throws MagacinException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            con.setAutoCommit(false);

            stavkaMagacinaDao.create(con, stavka);

            con.commit();
        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            throw new MagacinException("Error while adding stavka", ex);
        } finally {
            try {
                ResourcesManager.closeConnection(con);
            } catch (MagacinException e) {
                throw new MagacinException("Failed to close connection", e);
            }
        }
    }

    // Metod za ažuriranje stavke magacina
    public void updateStavka(StavkaMagacina stavka) throws MagacinException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            con.setAutoCommit(false);

            stavkaMagacinaDao.update(con, stavka);

            con.commit();
        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            throw new MagacinException("Error while updating stavka", ex);
        } finally {
            try {
                ResourcesManager.closeConnection(con);
            } catch (MagacinException e) {
                throw new MagacinException("Failed to close connection", e);
            }
        }
    }

    // Metod za brisanje stavke iz magacina
    public void deleteStavka(int stavkaId) throws MagacinException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            con.setAutoCommit(false);

            stavkaMagacinaDao.delete(con, stavkaId);

            con.commit();
        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            throw new MagacinException("Error while deleting stavka", ex);
        } finally {
            try {
                ResourcesManager.closeConnection(con);
            } catch (MagacinException e) {
                throw new MagacinException("Failed to close connection", e);
            }
        }
    }

    // Metod za dobijanje svih stavki magacina
    public List<StavkaMagacina> getAllStavke() throws MagacinException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            con.setAutoCommit(false);

            List<StavkaMagacina> stavke = stavkaMagacinaDao.getAll(con);

            con.commit();
            return stavke;

        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            throw new MagacinException("Error while fetching stavke", ex);
        } finally {
            try {
                ResourcesManager.closeConnection(con);
            } catch (MagacinException e) {
                throw new MagacinException("Failed to close connection", e);
            }
        }
    }

    // Metod za dobijanje stavke magacina po ID-u
    public StavkaMagacina getStavkaById(int stavkaId) throws MagacinException {
        Connection con = null;
        try {
            con = ResourcesManager.getConnection();
            con.setAutoCommit(false);

            StavkaMagacina stavka = stavkaMagacinaDao.read(con, stavkaId);

            con.commit();
            return stavka;

        } catch (SQLException ex) {
            ResourcesManager.rollbackTransactions(con);
            throw new MagacinException("Error while fetching stavka by ID", ex);
        } finally {
            try {
                ResourcesManager.closeConnection(con);
            } catch (MagacinException e) {
                throw new MagacinException("Failed to close connection", e);
            }
        }
    }
}