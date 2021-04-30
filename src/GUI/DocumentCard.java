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
import typedocs.*;
import typeperson.*;

public class DocumentCard extends Group implements EventHandler<ActionEvent> {

    public Document document;
    public GridPane grid;
    public Person emprunteur;
    public Button emps;
    public Button supprimer;
    public Button afficher;
    public Button changer;
    public Label image;
    public Label titre;
    public Label empruntee;
    public Label type;
    ObservableList<Node> list;
    Bibliotheque bib;
    public String emprunteestr;
    public String typestr ;

    public DocumentCard(Document doc,ObservableList<Node> list,Bibliotheque bib){
        this.list = list;
        this.bib = bib;
        typestr =" Type : " +doc.get_type();
        emprunteestr = (doc.get_emprunteur() == null) ? " Etat : n'est pas emprunté" : "Etat : emprunté par " + doc.get_emprunteur().get_nom() + " " + doc.get_emprunteur().get_prenom();
        this.document = doc;
        this.emprunteur = (doc.get_emprunteur() == null)?null:doc.get_emprunteur();
        emps = new Button("emprunter");
        emps.setOnAction(this);
        emps.getStyleClass().add("btn_card");
        if(doc.get_emprunteur() != null) emps.setDisable(true);
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
        grid.add(emps,4,3,1,1);
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
                    bib.supprimerDocument(this.document.get_ISBN());
                    Alert cee = new Alert(AlertType.INFORMATION);
                    cee.setTitle("suppression");
                    cee.setContentText("le document est supprimé !");
                    cee.setHeaderText("succes");
                    cee.showAndWait();
                }
            } catch (ElementNotFoundException e) {
                Alert cee = new Alert(AlertType.ERROR);
                cee.setTitle("erreur de suppression");
                cee.setContentText("ce document n'existe pas !");
                cee.setHeaderText("erreur de suppression");
                cee.showAndWait();
            }
        }
        if(event.getSource() == afficher){
            afficherDetaills.display(this);
        }
        if(event.getSource() == changer){
            changeDoc.display(this);
            titre.setText(document.get_titre());
        }
        if(event.getSource() == emps){
            String choix = emprunter.choix();
            if(choix!=null){
                switch(choix){
                    case "Etudiant":{
                        String cne = emprunter.getCNE();
                        if(cne!=null){
                        try {
                            Person per = bib.getEtudiantByCne(cne);
                            if(per.get_numEmprunts() < per.get_numEmpruntsMax()-1){
                                this.emprunteur = per;
                                this.emprunteur.empruntes[this.emprunteur.get_numEmprunts()] = this.document;
                                this.emprunteur.set_numEmprunts(this.emprunteur.get_numEmprunts()+1);
                                this.document.set_emprunteur(per);
                                this.emps.setDisable(true);
                                empruntee.setText("Etat : emprunté par " + this.document.get_emprunteur().get_nom() + " " + this.document.get_emprunteur().get_prenom());
                            }               
                            else{
                                Alert cee = new Alert(AlertType.ERROR);
                                cee.setTitle("Interdit");
                                cee.setContentText("cette Personne a dépassée son numéro maximum des emprunts!");
                                cee.setHeaderText("Interdit");
                                cee.showAndWait();
                            }       
                        }
                        catch (ElementNotFoundException e) {
                            Alert cee = new Alert(AlertType.ERROR);
                            cee.setTitle("erreur d'emprunter");
                            cee.setContentText("cette parsonne n'existe pas !");
                            cee.setHeaderText("erreur d'emprunter");
                            cee.showAndWait();
                        }
                    }
                        break;
                    }
                    case "Professeur":{
                        String cin = emprunter.getCIN();
                        if(cin!=null){
                        try {
                            Person per = bib.getProfesseurByCin(cin);
                            if(per.get_numEmprunts() < per.get_numEmpruntsMax()-1){
                                this.emprunteur = per;
                                this.emprunteur.empruntes[this.emprunteur.get_numEmprunts()] = this.document;
                                this.emprunteur.set_numEmprunts(this.emprunteur.get_numEmprunts()+1);
                                this.document.set_emprunteur(per);
                                this.emps.setDisable(true);
                                empruntee.setText("Etat : emprunté par " + this.document.get_emprunteur().get_nom() + " " + this.document.get_emprunteur().get_prenom());
                            }               
                            else{
                                Alert cee = new Alert(AlertType.ERROR);
                                cee.setTitle("Interdit");
                                cee.setContentText("cette Personne a dépassée son numéro maximum des emprunts!");
                                cee.setHeaderText("Interdit");
                                cee.showAndWait();
                            }       
                        }
                        catch (ElementNotFoundException e) {
                            Alert cee = new Alert(AlertType.ERROR);
                            cee.setTitle("erreur d'emprunter");
                            cee.setContentText("cette parsonne n'existe pas !");
                            cee.setHeaderText("erreur d'emprunter");
                            cee.showAndWait();
                        }
                    }
                    break;
                    }
                }
            
            }    
        }
    }
}
