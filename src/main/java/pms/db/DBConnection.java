package pms.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    static Connection con;
    private static final Logger LOGGER = Logger.getLogger(DBConnection.class.getName());

    public static Connection createConnection() {
        try {
            // Load properties file
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/db.properties");
            props.load(fis);

            // Retrieve properties
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.username");
            String pass = props.getProperty("db.password");

            // Create connection
            con = DriverManager.getConnection(url, user, pass);
            LOGGER.log(Level.INFO, "Database connection established sucessfully.");

        } catch (IOException e) {
          LOGGER.log(Level.SEVERE, "Error loading database properties file: {0}" + e.getMessage());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Database connection failed: {0}", e.getMessage());
          
        }
        return con;
    }
}
