package model;

import java.sql.*;

/**
 * Simple DAO to save customer.
 * Reused from your DBVersion1 project with minimal changes.
 */
public class CustomerDAO {

    public static int saveCustomer(String name, String email, String contact) {
        String sql = "INSERT INTO customers (name, email, contact) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, contact);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
