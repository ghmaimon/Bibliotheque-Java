package typeperson;
import java.time.LocalDate;


public class Professeur extends Person {
    // ************ attributes:
    private String cours;
    private int grade;
    // ************ getters et setters:

    public String get_cours() {
        return cours;
    }
    public void set_cours(String cours) {
        this.cours = cours;
    }
    public int get_grade() {
        return grade;
    }
    public void set_grade(int grade) {
        this.grade = grade;
    }
    // ************ constructeur:
    public Professeur(String nom, String prenom,int age,String email, String cin,String numTelefone,String address, LocalDate naissance, String cours, int grade){
        super(nom, prenom, age, email, cin, numTelefone, address, naissance);
        this.numEmpruntsMax = 5;
        this.grade = grade;
        this.cours = cours;
    }
}
