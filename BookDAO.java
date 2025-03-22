import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {
    public static void addBook(int id, String title, String author) {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO books (id, title, author) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, title);
            stmt.setString(3, author);
            stmt.executeUpdate();
            System.out.println("Book Added Successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayBooks() {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM books";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Title: " + rs.getString("title") + ", Author: " + rs.getString("author"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteBook(int id) {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM books WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book Deleted Successfully!");
            } else {
                System.out.println("Book Not Found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
