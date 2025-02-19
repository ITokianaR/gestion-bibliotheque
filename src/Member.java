public class Member {
    private String nom;
    private int idMember;

    public Member(int idMember, String nom) {
        this.idMember = idMember;
        this.nom = nom;
    }

    //getter
    public String getNom() {
        return nom;
    }

    public int getIdMember() {
        return idMember;
    }

//    //setter
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public void setIdMembre(int idMembre) {
//        this.idMembre = idMembre;
//    }

    public void retournerLivre(Book book){
        String title = book.getTitle();
        System.out.println(nom + " retourne le livre " + title);
        book.retourner();
    }

    public void emprunterLivre(Book book){
        String title = book.getTitle();
        System.out.println(nom + " tente d'emprunter le livre " + title);
        book.emprunter();
    }

    @Override
    public String toString() {
        return "Member{" +
                "nom='" + nom + '\'' +
                ", idMember=" + idMember +
                '}';
    }
}
