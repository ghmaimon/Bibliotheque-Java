package typeperson;

import java.time.LocalDate;

import typedocs.Document;

public abstract class Person {

    // ************ attributes:

    private String nom;
    private String prenom;
    private int age;
    private String cin;
    private String address;
    private LocalDate naissance; 
    private String numTelefone;
    private String email;
    protected int numEmpruntsMax;
    protected String type;
    public Document[] empruntes;
    private int numEmprunts;


    protected static int id_counter = 0;

    // ************ getters et setters:

    public String get_type(){
        return type;
    }

    public String get_nom() {
        return nom;
    }
    public void set_nom(String nom) {
        this.nom = nom;
    }
    public int get_numEmprunts() {
        return numEmprunts;
    }
    public void set_numEmprunts(int numEmprunts) {
        this.numEmprunts = numEmprunts;
    }
    public String get_prenom() {
        return prenom;
    }
    public void set_prenom(String prenom) {
        this.prenom = prenom;
    }
    public int get_age() {
        return age;
    }
    public void set_age(int age){
        this.age = age;
    }
    public String get_cin(){
        return cin;
    }
    public void set_cin(String cin){
        this.cin = cin;
    }
    public String get_address(){
        return address;
    } 
    public void set_address(String address){
        this.address = address;
    }
    public LocalDate get_naissance(){
        return naissance;
    }
    public void set_naissance(LocalDate naissance){
        this.naissance = naissance;
    }
    public String get_num_telefone(){
        return numTelefone;
    }
    public void set_num_telefone(String numTelefone){
        this.numTelefone = numTelefone;
    }
    public String get_email() {
        return email;
    }
    public void set_email(String email){
        this.email = email;
    }
    public int get_numEmpruntsMax(){
        return numEmpruntsMax;
    }

    public String toString(){
        String results = "";
        results += "Nom : " + nom;
        results += "\nPrenom:" + prenom;
        results += "\nAge : " + Integer.toString(age);
        results += "\nAddress : " + address;
        results += "\nNaissance : " + naissance;
        results += "\nnuméro de telefon : " + numTelefone;
        results += "\nEmail : " + email;
        return results;
    }

    // ************** constructeur:

    public Person(String nom, String prenom,int age,String email, String cin,String numTelefone,String address, LocalDate naissance) {

        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.email = email;
        this.cin = cin;
        this.naissance = naissance;
        this.address = address;
        this.numTelefone = numTelefone;
        numEmprunts = 0;
    }
}
