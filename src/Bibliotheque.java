import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
    private List<Book> books;
    private List<Member> members;

    // constructor, initialize the list
    public Bibliotheque() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    // getter
    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void ajouterLivre(Book book) {
        books.add(book);
    }

    public void ajouterMembre(Member member) {
        members.add(member);
    }

    public void afficherLivres() {
        System.out.println("Liste des livres : ");
//      for (int i=0; i < books.size(); i++) {
//        Book book = books.get(i);
//        System.out.println(book);
//      }
        for (Book book : books) {
            System.out.println(book);
        }
    }
}











