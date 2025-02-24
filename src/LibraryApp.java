import java.util.List;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        BookDao bookDAO = new BookDao();
        List<Book> books = bookDAO.getAllBooks();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n-----Menu-----");
            System.out.println("1 - Add book");
            System.out.println("2 - Display books");
            System.out.println("3 - Update books");
            System.out.println("4 - Delete books");
            System.out.println("5 - Quit");
            System.out.println("Choose an option");
            choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Enter ID");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter title");
                    String title = scanner.nextLine();
                    System.out.print("Enter author");
                    String author = scanner.nextLine();
                    bookDAO.addBook(new Book(id, title, author));
                    break;
                case 2:
                    books.forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Enter ID");
                    int udpatedId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new title");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new author");
                    String newAuthor = scanner.nextLine();
                    bookDAO.updateBook(udpatedId, newTitle, newAuthor);
                    break;
                case 4:
                    System.out.print("Enter ID of the book to delete");
                    int deleteId = scanner.nextInt();
                    bookDAO.deleteBook(deleteId);
                    break;
                case 5:
                    System.out.println("goodbye");
                    break;
                case 6:
                    System.out.println("Enter book id you want to show");
                    int bookId = scanner.nextInt();
                    bookDAO.getBookById(bookId);
                default:
                    System.out.println("Invalid Option");
            }
        } while (choice != 5);

        scanner.close();
    }
}
