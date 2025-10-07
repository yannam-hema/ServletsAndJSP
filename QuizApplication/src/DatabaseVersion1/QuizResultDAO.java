package DatabaseVersion1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuizResultDAO {
    
    public static boolean saveQuizResult(int userId, int score, int questionsAnswered) {
        String sql = "INSERT INTO quiz_results (user_id, score, questions_answered) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, userId);
            pstmt.setInt(2, score);
            pstmt.setInt(3, questionsAnswered);
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("✅ Quiz result saved successfully!");
                return true;
            }
            
        } catch (SQLException e) {
            System.err.println("❌ Error saving quiz result:");
            e.printStackTrace();
        }
        
        return false;
    }
    

    public static List<QuizResult> getUserResults(int userId) {
        List<QuizResult> results = new ArrayList<>();
        String sql = "SELECT * FROM quiz_results WHERE user_id = ? ORDER BY quiz_date DESC";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                results.add(new QuizResult(
                    rs.getInt("result_id"),
                    rs.getInt("user_id"),
                    rs.getInt("score"),
                    rs.getInt("total_questions"),
                    rs.getTimestamp("quiz_date")
                ));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return results;
    }
   
    public static List<LeaderboardEntry> getTopScores(int limit) {
        List<LeaderboardEntry> leaderboard = new ArrayList<>();
        String sql = "SELECT u.name, u.email, qr.score, qr.quiz_date " +
                     "FROM quiz_results qr " +
                     "JOIN users u ON qr.user_id = u.user_id " +
                     "ORDER BY qr.score DESC, qr.quiz_date DESC " +
                     "LIMIT ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, limit);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                leaderboard.add(new LeaderboardEntry(
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getInt("score"),
                    rs.getTimestamp("quiz_date")
                ));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return leaderboard;
    }
    
   
    public static int getUserBestScore(int userId) {
        String sql = "SELECT MAX(score) as best_score FROM quiz_results WHERE user_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("best_score");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }
}

class QuizResult {
    private int resultId;
    private int userId;
    private int score;
    private int totalQuestions;
    private Timestamp quizDate;
    
    public QuizResult(int resultId, int userId, int score, int totalQuestions, Timestamp quizDate) {
        this.resultId = resultId;
        this.userId = userId;
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.quizDate = quizDate;
    }
    
    // Getters
    public int getResultId() { return resultId; }
    public int getUserId() { return userId; }
    public int getScore() { return score; }
    public int getTotalQuestions() { return totalQuestions; }
    public Timestamp getQuizDate() { return quizDate; }
}

class LeaderboardEntry {
    private String name;
    private String email;
    private int score;
    private Timestamp quizDate;
    
    public LeaderboardEntry(String name, String email, int score, Timestamp quizDate) {
        this.name = name;
        this.email = email;
        this.score = score;
        this.quizDate = quizDate;
    }
    
    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getScore() { return score; }
    public Timestamp getQuizDate() { return quizDate; }
}