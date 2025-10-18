package model;

import java.sql.*;

/**
 * Simple order DAO that saves order with customer_id and total_amount.
 * You can extend it to save order items later.
 */
public class OrderDAO {

    public static boolean saveOrder(int customerId, int totalAmount) {
        String sql = "INSERT INTO orders (customer_id, total_amount) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, customerId);
            pstmt.setInt(2, totalAmount);
            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
