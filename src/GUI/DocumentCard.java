package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import typedocs.*;
import typeperson.*;

public class DocumentCard extends Group implements EventHandler<ActionEvent> {

    public Document document;
    public GridPane grid;
    public Person emprunteur;
    public Button emprunter;
    public Button supprimer;
    public Button afficher;
    public Button changer;
    public Label image;
    public Label titre;
    public Label empruntee;
    public Label type;
    public DocumentCard(Document doc,Person person){
        String typestr =" Type : " +doc.get_type();
        String emprunteestr = (person == null) ? " Etat : n'est pas emprunté" : "Etat : emprunté par " + person.get_nom() + " " + person.get_prenom();
        this.document = doc;
        this.emprunteur = (person == null)?null:person;
        emprunter = new Button("Emprunter");
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
        image.getStyleClass().add("doc_card_image");
        titre = new Label(document.get_titre());
        empruntee = new Label(emprunteestr);
        titre.getStyleClass().add("doc_card_titre");
        type = new Label(typestr);
        empruntee.getStyleClass().add("detail");
        type.getStyleClass().add("detail");
        grid = new GridPane();
        grid.add(image, 0, 0, 1, 4);
        grid.add(titre,1,0,4,1);
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

    }
}
