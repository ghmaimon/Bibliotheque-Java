package typeperson;
import java.time.LocalDate;

import typedocs.Document;

public class Etudiant extends Person{

    // ************ attributes:
    private String cne;
    private String filier;
    private int niveau;
    private boolean boursie;
    // ************ getters et setters:

    public String get_cne() {
        return cne;
    }
    public void set_cne(String cne) {
        this.cne = cne;
    }
    public String get_filier() {
        return filier;
    }
    public void set_filier(String filier) {
        this.filier = filier;
    }
    public int get_niveau() {
        return niveau;
    }
    public void set_niveau(int niveau) {
        this.niveau = niveau;
    }
    public boolean get_boursie(){
        return boursie;
    }
    public void set_boursie(boolean boursie) {
        this.boursie = boursie;
    }

    public String toString(){
        String results = super.toString();
        results += "\nCNE : " + cne;
        results += "\nFilier : " + filier;
        results += "\nNiveau : " + Integer.toString(niveau);
        results += boursie? "Boursié" : "N'est pas boursié";
        return results;
    }

    // ************ constructeur:
    public Etudiant(String nom, String prenom,int age,String email, String cin,String numTelefone,String address, LocalDate naissance, String filier, int niveau,boolean boursie,String cne){
        super(nom, prenom, age, email, cin, numTelefone, address, naissance);
        this.numEmpruntsMax = 3;
        this.niveau = niveau;
        this.filier = filier;
        this.boursie = boursie;
        type = "etudiant";
        empruntes = new Document[numEmpruntsMax];
    }
}
