package typedocs;

public class Livre extends Document {

    // ************** attributes:

    int numPages;
    String type;
    String tome;

    // ************** getters et setters:

    public int get_num_pages() {
        return numPages;
    }
    public void set_num_pages(int num_pages) {
        this.numPages = num_pages;
    }
    public String get_type() {
        return type;
    }
    public void set_type(String type) {
        this.type = type;
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
        representation += "\ntype: ";
        representation += type;
        representation += "\ntome:";
        representation += tome;
        
        return representation;
    }
    
    // ************** Constructeur:

    public Livre(int ISBN,String titre,String auteurs,String editeur,String AneEdition,int numExemplaires,int num_pages,String type,String tome) {
        super(ISBN, titre, auteurs, editeur, AneEdition, numExemplaires);
        this.type = type;
        this.numPages = num_pages;
        this.tome = tome;
        type = "Livre";
    }
}
