package bibliotheque;

import java.util.List;
import java.util.ArrayList;

import exceptions.*;
import typedocs.*;
import typeperson.*;

public class Bibliotheque {

    private List<Document> listDocuments;
    private List<Person> listEmprunteurs;

    private int capacity_docs;
    private int capacity_pers;

    // getters/setters:

    public int get_capacity_docs() { return capacity_docs; }
    public int get_capacity_pers() { return capacity_pers; }
    public int get_pos_docs() { return listDocuments.size(); }
    public int get_pos_pers() { return listEmprunteurs.size(); }



    public Bibliotheque(List<Document> listDocuments, List<Person> listEmprunteurs,int capacity_docs,int capacity_pers) throws CapacityExceededException{
        if(listDocuments.size() > capacity_docs) throw new CapacityExceededException(listDocuments.size() - capacity_docs,"Documents");
        if(listEmprunteurs.size() > capacity_pers) throw new CapacityExceededException(listEmprunteurs.size() - capacity_pers,"Persons");
        this.listDocuments = new ArrayList<Document>(listDocuments);
        this.listEmprunteurs = new ArrayList<Person>(listEmprunteurs);
    }
    public Bibliotheque(int capacity_docs,int capacity_pers){
        this.listDocuments = new ArrayList<Document>();
        this.listEmprunteurs = new ArrayList<Person>();
        this.capacity_pers = capacity_pers;
        this.capacity_docs = capacity_docs;
    }

    public String toString(){
        String representation = "";
        representation += "La bibliotheque contient " + Integer.toString(this.listDocuments.size()) + " documents :\n";
        for(int i=0; i<this.listDocuments.size(); i++){
            representation += " + " +  this.listDocuments.get(i).get_titre() + "\n";
        }
        representation += "Il y a maintenant " + Integer.toString(this.listEmprunteurs.size()) + " Empunteurs :\n";
        for(int i=0; i<this.listEmprunteurs.size(); i++){
            representation += " + " +  this.listEmprunteurs.get(i).get_nom() +" "+ this.listEmprunteurs.get(i).get_prenom() + "\n";
        }

        return representation;
    }

    // methods:
    public List<Document> getAllDocs(){
        return this.listDocuments;
    }
    public List<Document> getDocumentByEditeur(String editeur) {
        List<Document> results = new ArrayList<Document>();
        for(int i = 0; i < this.listDocuments.size(); i++) {
            if(this.listDocuments.get(i).get_editeur().equals(editeur)){
                results.add(this.listDocuments.get(i));
            }
        }
        return results;
    }
    public Document getDocumentByISBM(int isbm) throws ElementNotFoundException{
        for(int i = 0; i < this.listDocuments.size(); i++) {
            if(this.listDocuments.get(i).get_ISBN() == isbm){
                return this.listDocuments.get(i);
            }
        }
        throw new ElementNotFoundException("Document");
    }
    public List<Document> getDocumentByAuteur(String auteur) {
        List<Document> results = new ArrayList<Document>();
        for(int i = 0; i < this.listDocuments.size(); i++) {
            if(this.listDocuments.get(i).get_auteurs().equals(auteur)){
                results.add(this.listDocuments.get(i));
            }
        }
        return results;
    }
    public List<Document> getDocumentByTitre(String Titre) {
        List<Document> results = new ArrayList<Document>();
        for(int i = 0; i < this.listDocuments.size(); i++) {
            if(this.listDocuments.get(i).get_titre().equals(Titre)){
                results.add(this.listDocuments.get(i));
            }
        }
        return results;
    }
    public Etudiant getEtudiantByCne(String cne) throws ElementNotFoundException{
        for (int i = 0; i< this.listEmprunteurs.size(); i++){
            if(this.listEmprunteurs.get(i) instanceof Etudiant){
                Etudiant E = (Etudiant)this.listEmprunteurs.get(i);
                if(E.get_cne().equals(cne)){
                    return E;
                }
            }
        }
        throw new ElementNotFoundException("Etudiant");
    }
    public Professeur getProfesseurByCin(String cin) throws ElementNotFoundException{
        for (int i = 0; i< this.listEmprunteurs.size(); i++){
            if(this.listEmprunteurs.get(i) instanceof Professeur){
                Professeur E = (Professeur)this.listEmprunteurs.get(i);
                if(E.get_cin().equals(cin)){
                    return E;
                }
            }
        }
        throw new ElementNotFoundException("Professeur");
    }
    public void supprimerDocument(String titre) throws ElementNotFoundException{
        ArrayList<Document> to_remove = (ArrayList<Document>)getDocumentByTitre(titre);
        if(!listDocuments.removeAll(to_remove)) throw new ElementNotFoundException("Document");
    }
    public void supprimerEtudiant(String cne) throws ElementNotFoundException{
        Etudiant E = getEtudiantByCne(cne);
        if(!this.listEmprunteurs.remove(E)) throw new ElementNotFoundException("Etudiant");
    }
    public void supprimerProfesseur(String cin) throws ElementNotFoundException{
        Professeur p = getProfesseurByCin(cin);
        if(!this.listEmprunteurs.remove(p)) throw new ElementNotFoundException("Professeur");
    }
    public void ajouterDocument(Document doc) throws CapacityExceededException{
        if(this.listDocuments.size() == capacity_docs) throw new CapacityExceededException(1,"Documents");
        this.listDocuments.add(doc);
    }
    public void ajouterAdherent(Person pers) throws CapacityExceededException{
        if(this.listEmprunteurs.size() == capacity_pers) throw new CapacityExceededException(1,"Person");
        this.listEmprunteurs.add(pers);
    }
    public List<Document> docsTrieAnneeAsc(){
        List<Document> results = new ArrayList<Document>(this.listDocuments);
        results.sort((doc1, doc2) -> {
            return Integer.parseInt(doc1.get_ane_edition()) > Integer.parseInt(doc1.get_ane_edition()) ? 1 :
            Integer.parseInt(doc1.get_ane_edition()) == Integer.parseInt(doc1.get_ane_edition())? 0 : -1;
        });
        return results;
    }
    public List<Document> docsTrieAnneeDesc(){
        List<Document> results = new ArrayList<Document>(this.listDocuments);
        results.sort((doc1, doc2) -> {
            return Integer.parseInt(doc1.get_ane_edition()) < Integer.parseInt(doc1.get_ane_edition()) ? 1 :
            Integer.parseInt(doc1.get_ane_edition()) == Integer.parseInt(doc1.get_ane_edition())? 0 : -1;
        });
        return results;
    }
    public List<Livre> getLivresByType(String type){
        List<Livre> results = new ArrayList<Livre>();
        for(int i = 0; i < this.listEmprunteurs.size(); i++) {
            if(this.listDocuments.get(i) instanceof Livre){
                Livre D = (Livre) this.listDocuments.get(i);
                if(D.get_type().equals(type)){
                    results.add(D);
                }
            }
            
        }
        return results;
    }
}
