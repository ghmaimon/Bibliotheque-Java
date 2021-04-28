package GUI;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import exceptions.CapacityExceededException;
import exceptions.ElementNotFoundException;
import bibliotheque.Bibliotheque;
import typedocs.*;
import typeperson.*;

public class MainWindow extends Application implements EventHandler<ActionEvent>{

    Bibliotheque bibliotheque = new Bibliotheque(1000,1000);
    //scene:
    BorderPane mainLayout;
    Scene scene;
    //menu:
    MenuItem ajouterDocument;
    MenuItem ajouterPerson;
    Menu ajouterMenu;
    MenuBar menu;
    Menu supprimerMenu;
    MenuItem supprimerDocument;
    MenuItem supprimerProf;
    MenuItem supprimerEtud;
    SeparatorMenuItem supprimerSepar;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("GUI test");
        mainLayout = new BorderPane();
        // menu :
        menu = new MenuBar();
        // menu pour ajouter:
        ajouterMenu = new Menu("_Ajouter");
        ajouterDocument = new MenuItem("_Document...");
        ajouterDocument.setOnAction(this);
        ajouterPerson = new MenuItem("_Personne...");
        ajouterPerson.setOnAction(this);
        ajouterMenu.getItems().addAll(ajouterPerson,ajouterDocument);
        // menu poura supprimer:
        supprimerMenu = new Menu("_Supprimer");
        supprimerDocument = new MenuItem("_Document...");
        supprimerDocument.setOnAction(this);
        supprimerProf = new MenuItem("_Professeur...");
        supprimerProf.setOnAction(this);
        supprimerEtud = new MenuItem("_Etudiant...");
        supprimerEtud.setOnAction(this);
        supprimerSepar = new SeparatorMenuItem();
        supprimerMenu.getItems().addAll(supprimerDocument,supprimerSepar,supprimerEtud,supprimerProf);


        menu.getMenus().addAll(ajouterMenu,supprimerMenu);
        mainLayout.setTop(menu);
        scene = new Scene(mainLayout, 800,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == ajouterDocument){
            Document doc = AddDoc.display();
            if(doc!= null){
                try {
                    bibliotheque.ajouterDocument(doc);
                    Alert cee = new Alert(AlertType.INFORMATION);
                    cee.setTitle("ajoute d'un document");
                    cee.setContentText("le document est ajouté !");
                    cee.setHeaderText("succes");
                    cee.showAndWait();
                } catch (CapacityExceededException e) {
                    Alert cee = new Alert(AlertType.ERROR);
                    cee.setTitle("erreur d'addition du document");
                    cee.setContentText("la capacity des document est dépassé !");
                    cee.setHeaderText("erreur d'addition du document");
                    cee.showAndWait();
                }
            }
        }
        if(event.getSource() == ajouterPerson){
            Person person = AddPerson.display();
            if(person!= null){
                try {
                    bibliotheque.ajouterAdherent(person);
                    Alert cee = new Alert(AlertType.INFORMATION);
                    cee.setTitle("ajoute d'une personne");
                    cee.setContentText("la personne est ajouté !");
                    cee.setHeaderText("succes");
                    cee.showAndWait();
                } catch (CapacityExceededException e) {
                    Alert cee = new Alert(AlertType.ERROR);
                    cee.setTitle("erreur d'addition d'une personne");
                    cee.setContentText("la capacity des persnnes est dépassé !");
                    cee.setHeaderText("erreur d'addition de la person");
                    cee.showAndWait();
                }
            }
        }
        if(event.getSource() == supprimerDocument){
            String titre = SuppDoc.titreASupp();
            if(titre != null){
                try {
                    bibliotheque.supprimerDocument(titre);
                    Alert cee = new Alert(AlertType.INFORMATION);
                    cee.setTitle("suppression");
                    cee.setContentText("le document est supprimé !");
                    cee.setHeaderText("succes");
                    cee.showAndWait();
                } catch (ElementNotFoundException e) {
                    Alert cee = new Alert(AlertType.ERROR);
                    cee.setTitle("erreur de suppression");
                    cee.setContentText("ce document n'existe pas !");
                    cee.setHeaderText("erreur de suppression");
                    cee.showAndWait();
                }
            }
        }
        if(event.getSource() == supprimerEtud){
            String cne = SuppEtud.cneASupp();
            if(cne != null){
                try {
                    bibliotheque.supprimerEtudiant(cne);
                    Alert cee = new Alert(AlertType.INFORMATION);
                    cee.setTitle("suppression");
                    cee.setContentText("l'etudiant est supprimé !");
                    cee.setHeaderText("succes");
                    cee.showAndWait();
                } catch (ElementNotFoundException e) {
                    Alert cee = new Alert(AlertType.ERROR);
                    cee.setTitle("erreur de suppression");
                    cee.setContentText("cet etudiant n'existe pas !");
                    cee.setHeaderText("erreur de suppression");
                    cee.showAndWait();
                }
            }
        }
        if(event.getSource() == supprimerProf){
            String cin = SuppProf.cinASupp();
            if(cin != null){
                try {
                    bibliotheque.supprimerProfesseur(cin);
                    Alert cee = new Alert(AlertType.INFORMATION);
                    cee.setTitle("suppression");
                    cee.setContentText("le professeur est supprimé !");
                    cee.setHeaderText("succes");
                    cee.showAndWait();
                } catch (ElementNotFoundException e) {
                    Alert cee = new Alert(AlertType.ERROR);
                    cee.setTitle("erreur de suppression");
                    cee.setContentText("cet professeur n'existe pas !");
                    cee.setHeaderText("erreur de suppression");
                    cee.showAndWait();
                }
            }
        }
    }
}
