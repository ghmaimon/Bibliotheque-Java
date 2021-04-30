package GUI;

import bibliotheque.Bibliotheque;
import exceptions.ElementNotFoundException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import typeperson.*;

public class PersonCard extends Group implements EventHandler<ActionEvent> {

    public GridPane grid;
    public Person person;
    public Button emprunter;
    public Button supprimer;
    public Button afficher;
    public Button changer;
    public Label image;
    public Label nom;
    public Label empruntee;
    public Label type;
    ObservableList<Node> list;
    Bibliotheque bib;
    public String emprunteestr;
    public String typestr ;

    public PersonCard(Person person,ObservableList<Node> list,Bibliotheque bib){
        this.list = list;
        this.bib = bib;
        typestr =" Identité : " +person.get_type();
        this.person = person;
        emprunteestr = "Numéro d'empruntes : " + person.get_numEmprunts() + "/" + person.get_numEmpruntsMax();
        emprunter = new Button("Empruntes");
        emprunter.setOnAction(this);
        emprunter.getStyleClass().add("btn_card");
        supprimer = new Button("Supprimer");
        supprimer.setOnAction(this);
        supprimer.getStyleClass().add("btn_card");
        afficher = new Button("Afficher");
        afficher.setOnAction(this);
        afficher.getStyleClass().add("btn_card");
        changer = new Button("Changer");
        changer.setOnAction(this);
        changer.getStyleClass().add("btn_card");
        image = new Label();
        if(person.get_type().equals("etudiant"))image.getStyleClass().add("etud_card_image");
        if(person.get_type().equals("professeur"))image.getStyleClass().add("prof_card_image");
        nom = new Label(person.get_prenom() + " " + person.get_nom());
        empruntee = new Label(emprunteestr);
        nom.getStyleClass().add("doc_card_titre");
        type = new Label(typestr);
        empruntee.getStyleClass().add("detail");
        type.getStyleClass().add("detail");
        grid = new GridPane();
        grid.add(image, 0, 0, 1, 4);
        grid.add(nom,1,0,4,1);
        grid.add(empruntee,1,1,4,1);
        grid.add(type,1,2,4,1);
        grid.add(changer,1,3,1,1);
        grid.add(afficher,2,3,1,1);
        grid.add(supprimer,3,3,1,1);
        grid.add(emprunter,4,3,1,1);
        this.getChildren().add(grid);
    }

    @Override
    public void handle(ActionEvent event){
        if(event.getSource() == supprimer){
            try {
                ButtonType oui = new ButtonType("Oui",ButtonData.YES);
                ButtonType non = new ButtonType("Non",ButtonData.NO);
                Alert supAl = new Alert(Alert.AlertType.CONFIRMATION);
                supAl.getButtonTypes().setAll(oui,non);
                supAl.setHeaderText("vous êtes sûr ?");
                if(supAl.showAndWait().get() == oui){
                    list.remove((Object)this);
                    if(this.person.get_type().equals("etudiant"))bib.supprimerEtudiant(((Etudiant)person).get_cne());
                    else if(this.person.get_type().equals("professeur"))bib.supprimerProfesseur(((Professeur)person).get_cin());
                    Alert cee = new Alert(AlertType.INFORMATION);
                    cee.setTitle("suppression");
                    cee.setContentText("la personne est supprimée !");
                    cee.setHeaderText("succes");
                    cee.showAndWait();
                }
            } catch (ElementNotFoundException e) {
                Alert cee = new Alert(AlertType.ERROR);
                cee.setTitle("erreur de suppression");
                cee.setContentText("cette personne n'existe pas !");
                cee.setHeaderText("erreur de suppression");
                cee.showAndWait();
            }
        }
        if(event.getSource() == afficher){
            afficherDetaills.display(this);
        }
        if(event.getSource() == changer){
            ChangePerson.display(this);
            nom.setText(person.get_nom() + " " + person.get_prenom());
        }
        if(event.getSource() == emprunter){
            list.clear();
            for(int i=0;i<this.person.get_numEmprunts()+1;i++){
                DocumentCard dc = new DocumentCard(this.person.empruntes[i],list,bib);
                list.add(dc);
            }
        }
    }
}
