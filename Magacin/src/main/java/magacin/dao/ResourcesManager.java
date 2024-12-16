/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magacin.dao;

/**
 *
 * @author Lazar Lazarevic
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import magacin.exception.MagacinException;

public class ResourcesManager {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/magacin1", "root", "");
    }

    public static void closeResources(ResultSet resultSet, PreparedStatement preparedStatement) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (preparedStatement != null) {
            preparedStatement.close();
        }
    }

    public static void closeConnection(Connection con) throws MagacinException {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                throw new MagacinException("Failed to close database connection.", ex);
            }
        }
    }

    public static void rollbackTransactions(Connection con) throws MagacinException {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new MagacinException("Failed to rollback database transactions.", ex);
            }
        }
    }
}
