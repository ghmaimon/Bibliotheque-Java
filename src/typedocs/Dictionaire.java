package typedocs;

public class Dictionaire extends Document {
    // ************** attributes:

    int numTomes;
    String langue;

    // ************** getters et setters:

    public int get_num_tomes() {
        return numTomes;
    }
    public void set_num_tomes(int num_tomes) {
        this.numTomes = num_tomes;
    }
    public String get_langue() {
        return langue;
    }
    public void set_langue(String langue) {
        this.langue = langue;
    }

    // ************** methods:

    public String toString() {
        String representation = super.toString();
        representation += "\nnombre des tomes: ";
        representation += Integer.toString(numTomes);
        representation += "\nlangue: " ;
        representation += langue;
        
        return representation;
    }
    
    // ************** Constructeur:

    public Dictionaire(int ISBN,String titre,String auteurs,String editeur,String AneEdition,int numExemplaires,int num_tomes,String langue) {
        super(ISBN, titre, auteurs, editeur, AneEdition, numExemplaires);
        this.langue = langue;
        this.numTomes = num_tomes;
        type = "Dictionnaire";
    }
}
