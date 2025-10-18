package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBConnection placeholder.
 * Update URL, USER and PASSWORD to match your MySQL instance.
 *
 * Note for Tomcat 10 / Jakarta:
 * If using Tomcat-managed DataSource, configure it in context.xml and use JNDI lookup instead.
 */
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Yannam@300323";

    public static Connection getConnection() throws SQLException {
        try {
            // MySQL driver class load (optional with JDBC 4+)
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // Driver not on classpath. Place mysql-connector-java jar into WEB-INF/lib
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
