package DatabaseVersion1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/quiz_app_db";
    private static final String DB_USER = "root"; 
    private static final String DB_PASSWORD = "Yannam@300323"; 
    
    private static Connection connection = null;
    
 
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                // Load Driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Create connection
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                System.out.println("✅ Database connected successfully!");
            }
            return connection;
            
        } catch (ClassNotFoundException e) {
            System.err.println("❌ MySQL JDBC Driver not found!");
            System.err.println("Add mysql-connector-java to your project.");
            e.printStackTrace();
            return null;
            
        } catch (SQLException e) {
            System.err.println("❌ Database connection failed!");
            System.err.println("Check your MySQL credentials and ensure MySQL is running.");
            e.printStackTrace();
            return null;
        }
    }
    

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
 
    public static boolean testConnection() {
        Connection conn = getConnection();
        return conn != null;
    }
}
