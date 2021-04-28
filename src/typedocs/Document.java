package typedocs;

public abstract class Document {


    // ************** attributes:

    private int ISBN;
    private String titre;
    private String auteurs;
    private String editeur;
    private String AneEdition;
    private int numExemplaires;
    protected String type;

    private final int numEnregistrement;

    private static int nextNumEnregistrement = 0;

    // ************** getters and setters:

    // * ISBN:
    public int get_ISBN() {
        return ISBN;
    }
    public void set_ISBN(int isbn) {
        this.ISBN = isbn;
    }
    // * titre:
    public String get_titre() {
        return this.titre;
    }
    public void set_titre(String titre) {
        this.titre = titre;
    }
    // * auteurs:
    public String get_auteurs() {
        return auteurs;
    }
    public void set_auteurs(String auteurs) {
        this.auteurs = auteurs;
    }
    // * editeur:
    public String get_editeur() {
        return editeur;
    }
    public void set_editeur(String editeur) {
        this.editeur = editeur;
    }
    // * ane d'edition:
    public String get_ane_edition() {
        return this.AneEdition;
    }
    public void set_ane_edition(String ane_edition) {
        this.AneEdition = ane_edition;
    }
    // * nombre d'exemplaires:
    public int get_num_exemplaires() {
        return numExemplaires;
    }
    public void set_num_exemplaires(int num_exemplaires) {
        this.numExemplaires = num_exemplaires;
    }

    public static int get_next_num_enregistrement(){
        return nextNumEnregistrement;
    }
    public static void set_next_num_enregistrement(int nextNumEnregistrement){
        Document.nextNumEnregistrement = nextNumEnregistrement;
    }
    public int get_num_enregistrement() {
        return this.numEnregistrement;
    }
    public String get_type(){
        return type;
    }
    // ************** methods:

    public String toString(){
        String representation = "numero d'enregistrement: " +numEnregistrement+ "\nISBN: " + Integer.toString(ISBN) + "\ntitre: " + titre + "\nauteurs: " + auteurs;
        representation += "\nediteur: " + editeur;
        representation += "\nnumero d'exemplaires: " +Integer.toString(numExemplaires);
        representation += "\nannee d'edition: " + AneEdition;
        return representation;
    } 

    public void inc_num_exp(){
        set_num_exemplaires(get_num_exemplaires() +1);
    }
    public void dec_num_exp(){
        set_num_exemplaires(get_num_exemplaires() -1);
    }

    // ************** constructeur:

    public Document(int ISBN,String titre,String auteurs,String editeur,String AneEdition,int numExemplaires){
        this.titre = titre;
        this.auteurs = auteurs;
        this.editeur = editeur;
        this.numExemplaires = numExemplaires;
        this.AneEdition = AneEdition;
        this.ISBN = ISBN;

        this.numEnregistrement = get_next_num_enregistrement();
        set_next_num_enregistrement(get_next_num_enregistrement() + 1);
    }

}