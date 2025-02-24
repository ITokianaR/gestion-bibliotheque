public class Book extends Object {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    //getter
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

//    public void emprunter() {
//        /*
//        add if else condition, if book is available
//        - set availability to false
//        - print (le livre + title + a ete emprunte)
//        else print(le livre n'est pas dispo)
//        */
//        if (isAvailable) {
//            isAvailable = false;
//            System.out.println("le livre " + title + " a été emprunté\n");
//        } else {
//            System.out.println("Le livre "+ title + " n'est pas disponible\n");
//        }
//    }

//    public void retourner() {
//        /*
//        si livre n'est pas dispo:
//            - met livre en disponiblité true
//            - affiche message "a ete retourne"
//        sinon:
//            - le livre n'est pas dispo
//        */
//        if (!isAvailable) {
//            isAvailable = true;
//            System.out.println("Le livre "+ title + " a été retourné\n");
//        } else {
//            System.out.println("Le livre "+ title + " n'est pas disponible\n");
//        }
//    }

    // to display object's information


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}



