import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public void addBook(Book book) {
        String sql = "INSERT INTO books (id, title, author) VALUES (?,?,?)";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, book.getId());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.executeUpdate();
            System.out.println("Livre ajouté: " + book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * from books";
        try(Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                books.add(new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    public List<Book> getBookById(int id) {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT id, title, author from books WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            System.out.println(rs);
            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    public void updateBook(int id, String newTitle, String newAuthor) {
        String sql = "UPDATE books SET title = ?, author = ? WHERE id = ?";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newTitle);
            statement.setString(2, newAuthor);
            statement.setInt(3, id);
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("Book successfully updated");
            } else {
                System.out.println("No book were found matching ID " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id = ? ";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("Book successfully deleted");
            } else {
                System.out.println("No book were found matching ID " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
