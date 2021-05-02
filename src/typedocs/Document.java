package typedocs;

import typeperson.Person;

public abstract class Document {


    // ************** attributes:

    private String ISBN;
    private String titre;
    private String auteurs;
    private String editeur;
    private String AneEdition;
    private int numExemplaires;
    protected String type;
    private Person emprunteur;


    // ************** getters and setters:

    public Person get_emprunteur(){
        return emprunteur;
    }
    public void set_emprunteur(Person emp){
        this.emprunteur = emp;
    }

    // * ISBN:
    public String get_ISBN() {
        return ISBN;
    }
    public void set_ISBN(String isbn) {
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

    public String get_type(){
        return type;
    }
    // ************** methods:

    public String toString(){
        String representation = "ISBN: " + ISBN + "\ntitre: " + titre + "\nauteurs: " + auteurs;
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

    public Document(String ISBN,String titre,String auteurs,String editeur,String AneEdition,int numExemplaires){
        this.titre = titre;
        this.auteurs = auteurs;
        this.editeur = editeur;
        this.numExemplaires = numExemplaires;
        this.AneEdition = AneEdition;
        this.ISBN = ISBN;
    }

}