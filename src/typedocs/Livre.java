package typedocs;

public class Livre extends Document {

    // ************** attributes:

    int numPages;
    String livre_type;
    String tome;

    // ************** getters et setters:

    public int get_num_pages() {
        return numPages;
    }
    public void set_num_pages(int num_pages) {
        this.numPages = num_pages;
    }
    public String get_livre_type() {
        return livre_type;
    }
    public void set_livre_type(String livre_type) {
        this.livre_type = livre_type;
    }
    public String get_tome() {
        return tome;
    }
    public void set_tome(String tome) {
        this.tome = tome;
    }

    // ************** methods:

    public String toString() {
        String representation = super.toString();
        representation += "\nnombre des pages: ";
        representation += Integer.toString(numPages);
        representation += "\nlivre_type: ";
        representation += livre_type;
        representation += "\ntome:";
        representation += tome;
        
        return representation;
    }
    
    // ************** Constructeur:

    public Livre(String ISBN,String titre,String auteurs,String editeur,String AneEdition,int numExemplaires,int num_pages,String livre_type,String tome) {
        super(ISBN, titre, auteurs, editeur, AneEdition, numExemplaires);
        this.livre_type = livre_type;
        this.numPages = num_pages;
        this.tome = tome;
        type = "Livre";
    }
    public Livre(int id, String ISBN,String titre,String auteurs,String editeur,String AneEdition,int numExemplaires,int num_pages,String livre_type,String tome) {
        super(id, ISBN, titre, auteurs, editeur, AneEdition, numExemplaires);
        this.livre_type = livre_type;
        this.numPages = num_pages;
        this.tome = tome;
        type = "Livre";
    }
}
