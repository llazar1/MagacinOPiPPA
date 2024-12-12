/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magacin.service;

/**
 *
 * @author Lazar Lazarevic
 */
import magacin.dao.MagacinskiProstorDao;
import magacin.data.MagacinskiProstor;
import magacin.exception.MagacinException;
import magacin.dao.ResourcesManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MagacinskiProstorService {

    private final MagacinskiProstorDao magacinskiProstorDao;

    public MagacinskiProstorService() {
        this.magacinskiProstorDao = new MagacinskiProstorDao();
    }

    public void addMagacinskiProstor(MagacinskiProstor prostor) throws MagacinException {
        try (Connection con = ResourcesManager.getConnection()) {
            con.setAutoCommit(false);
            magacinskiProstorDao.create(con, prostor);
            con.commit();
        } catch (SQLException ex) {
            throw new MagacinException("Error while adding magacinski prostor", ex);
        }
    }

    public void updateMagacinskiProstor(MagacinskiProstor prostor) throws MagacinException {
        try (Connection con = ResourcesManager.getConnection()) {
            con.setAutoCommit(false);
            magacinskiProstorDao.update(con, prostor);
            con.commit();
        } catch (SQLException ex) {
            throw new MagacinException("Error while updating magacinski prostor", ex);
        }
    }

    public void deleteMagacinskiProstor(int prostorId) throws MagacinException {
        try (Connection con = ResourcesManager.getConnection()) {
            con.setAutoCommit(false);
            magacinskiProstorDao.delete(con, prostorId);
            con.commit();
        } catch (SQLException ex) {
            throw new MagacinException("Error while deleting magacinski prostor", ex);
        }
    }

    public List<MagacinskiProstor> getAllMagacinskiProstori() throws MagacinException {
        try (Connection con = ResourcesManager.getConnection()) {
            return magacinskiProstorDao.getAll(con);
        } catch (SQLException ex) {
            throw new MagacinException("Error while fetching magacinski prostori", ex);
        }
    }

    public MagacinskiProstor getMagacinskiProstorById(int prostorId) throws MagacinException {
        try (Connection con = ResourcesManager.getConnection()) {
            return magacinskiProstorDao.read(con, prostorId);
        } catch (SQLException ex) {
            throw new MagacinException("Error while fetching magacinski prostor by ID", ex);
        }
    }
}