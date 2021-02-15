package za.co.directaxis.assessment.game.repository;

import za.co.directaxis.assessment.game.model.Car;
import za.co.directaxis.assessment.game.util.Util;

import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

/**
 * This class represents the data access object.
 * It makes a connection to the database and will retrieve
 * and return corresponding {@link Car} objects.
 */
public class CarDAO {

    private static final Logger fLogger = Util.getLogger(CarDAO.class);

    public List<Car> getAllCars(){
        List<Car> resultList = new ArrayList<Car>();
        Connection dbConn = getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        if(dbConn == null){
            //TODO
        }

        try {
            stmt = dbConn.createStatement();
            if( stmt.execute("SELECT model, acceleration, braking, cornering, top_speed FROM cars")) {
                rs = stmt.getResultSet();
            }
            // populate list with data from db
            while (rs.next ()){
                Car aCar = new Car();
                aCar.setModel(rs.getString ("model"));
                aCar.setAcceleration(rs.getInt ("acceleration"));
                aCar.setBraking(rs.getInt ("braking"));
                aCar.setCorneringAbility(rs.getInt ("cornering"));
                aCar.setTopSpeed(rs.getInt ("top_speed"));
                resultList.add(aCar);
            }
        } catch (SQLException ex) {
            fLogger.warning("SQLException: " + ex.getMessage());
            //TODO
            return Collections.EMPTY_LIST;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { /* ignore */ }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { /* ignore */ }
                stmt = null;
            }
        }

        return resultList;
    }

    private Connection getConnection(){
        Connection conn = null;


        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            // register MySQL Connector/J
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

        } catch (Exception ex) {
            ex.printStackTrace();
            fLogger.warning("Failed to register MySQL Connector/J");
            return null;
        }

        //TODO retrieve password from properties file

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/racing_game_db", "root", "K1ll3r$16o1");
            return conn;
        } catch (SQLException ex) {
            // TODO handle any errors
            fLogger.warning("SQLException: " + ex.getMessage());
            fLogger.warning("SQLState: " + ex.getSQLState());
            fLogger.warning("VendorError: " + ex.getErrorCode());
            return null;
        }

    }
}
