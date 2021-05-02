package typedocs;

public class Magazine extends Document {
    // ************** attributes:

    int periodicity;
    int moisEdition;
    int jourEdition;

    // ************** getters et setters:

    public int get_periodicity() {
        return periodicity;
    }
    public void set_periodicity(int periodicity) {
        this.periodicity = periodicity;
    }
    public int get_mois_edition() {
        return moisEdition;
    }
    public void set_mois_edition(int mois_edition) {
        this.moisEdition = mois_edition;
    }
    public int get_jour_edition() {
        return jourEdition;
    }
    public void set_jour_edition(int jour_edition) {
        this.jourEdition = jour_edition;
    }
    
    // ************** methods:

    public String toString() {
        String representation = super.toString();
        representation += "\nperiodicite: " ;
        representation += Integer.toString(periodicity);
        representation += "\nmois d'edition: ";
        representation += Integer.toString(moisEdition);
        representation += "\njour d'edition: ";
        representation += Integer.toString(jourEdition);
        
        return representation;
    }
    
    // ************** Constructeur:

    public Magazine(String ISBN,String titre,String auteurs,String editeur,String AneEdition,int numExemplaires,int periodicity,int mois_edition,int jour_edition) {
        super(ISBN, titre, auteurs, editeur, AneEdition, numExemplaires);
        this.periodicity = periodicity;
        this.moisEdition = mois_edition;
        this.jourEdition = jour_edition;
        type = "Magazine";
    }
}
