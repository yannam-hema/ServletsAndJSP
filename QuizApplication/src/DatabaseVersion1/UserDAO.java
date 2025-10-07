package DatabaseVersion1;

import java.sql.*;


public class UserDAO {
 
    public static int saveUser(String name, String email) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
              
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    int userId = rs.getInt(1);
                    System.out.println("✅ User saved! ID: " + userId);
                    return userId;
                }
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error saving user to database:");
            e.printStackTrace();
        }
        
        return -1; // Failed
    }
    
    /**
     * Get user by ID
     * @param userId User ID
     * @return User object or null if not found
     */
    public static User getUserById(int userId) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new User(
                    rs.getInt("user_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getTimestamp("created_at")
                );
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * Check if email already exists
     * @param email Email to check
     * @return true if exists, false otherwise
     */
    public static boolean emailExists(String email) {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
}

class User {
    private int userId;
    private String name;
    private String email;
    private Timestamp createdAt;
    
    public User(int userId, String name, String email, Timestamp createdAt) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }
    
    // Getters
    public int getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Timestamp getCreatedAt() { return createdAt; }
}