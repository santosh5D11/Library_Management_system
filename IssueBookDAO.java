import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IssueBookDAO {
    public static void issueBook(int bookId, String issuedTo) {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO issued_books (book_id, issued_to) VALUES (?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, bookId);
            stmt.setString(2, issuedTo);
            stmt.executeUpdate();
            System.out.println("Book Issued Successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void returnBook(int bookId) {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM issued_books WHERE book_id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, bookId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book Returned Successfully!");
            } else {
                System.out.println("Book Not Found in Issued List!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void displayIssuedBooks() {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM issued_books";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Book ID: " + rs.getInt("book_id") + ", Issued To: " + rs.getString("issued_to"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
