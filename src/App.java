
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;


import exceptions.CapacityExceededException;
import exceptions.ElementNotFoundException;

import GUI.*;
import bibliotheque.Bibliotheque;
import typedocs.*;
import typeperson.*;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App extends Application implements EventHandler<ActionEvent>{


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
    Menu ChercherMenu;
    Menu ChercherDoc;
    MenuItem ChercherProf;
    MenuItem ChercherEtud;
    SeparatorMenuItem ChercherSepar;
    MenuItem ChercherDocByISBM;
    MenuItem ChercherDocByTitre;
    MenuItem ChercherDocByAuteur;
    MenuItem ChercherDocByEditeur;
    //partie gauche:
    VBox Glayout;
    Button tousDocs;
    Button tousPersons;
    Button empruntee;
    Button nonEmpuntee;    
    //partie centre;
    VBox Clayout,CBlayout;
    HBox CUlayout;
    ScrollPane spane;
    TextField cherchField;
    Button chercher;

    //partie droite:
    VBox Dlayout;
    Button tri_asc;
    Button tri_decs;
    Label tri_date;
    Label persons;
    Label documents;
    Button bande_dessinee;
    Button livre;
    Button dictionaire;
    Button magazine;
    Button etudiant;
    Button professeur;

    //database connection:
    ResultSet rs;
    Statement st;
    Connection conn;
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost/bibliotheque";
    String username = "biblio_admin";
    String password = "Halazona1998";
    String query;
    Document tempDoc;
    Person tempPers;
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        Class.forName(driver);
        conn = DriverManager.getConnection(url, username, password);
        st = conn.createStatement();

        bibliotheque = new Bibliotheque(1000, 1200);

        primaryStage.setTitle("Bibliotheque");
        primaryStage.setResizable(false);
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
        // menu pour supprimer:
        supprimerMenu = new Menu("_Supprimer");
        supprimerDocument = new MenuItem("_Document...");
        supprimerDocument.setOnAction(this);
        supprimerProf = new MenuItem("_Professeur...");
        supprimerProf.setOnAction(this);
        supprimerEtud = new MenuItem("_Etudiant...");
        supprimerEtud.setOnAction(this);
        supprimerSepar = new SeparatorMenuItem();
        supprimerMenu.getItems().addAll(supprimerDocument,supprimerSepar,supprimerEtud,supprimerProf);
        supprimerProf.setId("dd");
        // menu pour chercher:
        ChercherMenu = new Menu("_Chercher");
        ChercherDoc = new Menu("_Document");
        ChercherProf = new MenuItem("_Professeur...");
        ChercherProf.setOnAction(this);
        ChercherEtud = new MenuItem("_Etudiant...");
        ChercherEtud.setOnAction(this);
        ChercherSepar = new SeparatorMenuItem();
        ChercherDocByISBM = new MenuItem("_ISBN...");
        ChercherDocByISBM.setOnAction(this);
        ChercherDocByTitre = new MenuItem("_Titre...");
        ChercherDocByTitre.setOnAction(this);
        ChercherDocByAuteur = new MenuItem("_Auteur...");
        ChercherDocByAuteur.setOnAction(this);
        ChercherDocByEditeur = new MenuItem("_Edieur...");
        ChercherDocByEditeur.setOnAction(this);

        ChercherDoc.getItems().addAll(ChercherDocByISBM,ChercherDocByTitre,ChercherDocByAuteur,ChercherDocByEditeur);
        ChercherMenu.getItems().addAll(ChercherDoc,ChercherSepar,ChercherProf,ChercherEtud);

        menu.getMenus().addAll(ajouterMenu,supprimerMenu,ChercherMenu);
        mainLayout.setTop(menu);

        //partie gauch:
        Glayout = new VBox();
        Glayout.setId("gl");
        tousDocs = new Button("\n\n\n\n\n\nTous les documents");
        tousDocs.getStyleClass().add("buttonGauch");
        tousDocs.setId("tousDocs");
        tousDocs.setOnAction(this);
        tousPersons = new Button("\n\n\n\n\n\nTous les personnes");
        tousPersons.getStyleClass().add("buttonGauch");
        tousPersons.setId("tousPersonnes");
        tousPersons.setOnAction(this);
        empruntee = new Button("\n\n\n\n\n\nempruntés");
        empruntee.getStyleClass().add("buttonGauch");
        empruntee.setId("empruntee");
        empruntee.setOnAction(this);
        nonEmpuntee = new Button("\n\n\n\n\n\nNon empruntés");  
        nonEmpuntee.getStyleClass().add("buttonGauch");  
        nonEmpuntee.setId("nonEmpuntee");
        nonEmpuntee.setOnAction(this);

        Glayout.getChildren().addAll(tousDocs,tousPersons,empruntee,nonEmpuntee);
        mainLayout.setLeft(Glayout);
        //partie centre:
        Clayout = new VBox();
        CBlayout = new VBox();
        mainLayout.setCenter(Clayout);
        spane = new ScrollPane(CBlayout);
        spane.setPannable(true);
        spane.setMinHeight(600);
        spane.getStyleClass().add("centerLayout");

        CUlayout = new HBox();
        cherchField = new TextField();
        cherchField.getStyleClass().add("text-field");

        chercher = new Button("Chercher");
        chercher.setId("chercher");

        CUlayout.getChildren().addAll(cherchField,chercher);

        Clayout.getChildren().addAll(CUlayout,spane);
        CUlayout.setId("up");

        //partie droite:
        Dlayout = new VBox();
        tri_asc = new Button();
        tri_decs = new Button();
        tri_date = new Label("    Documents\n    Triés par année\n    d'édition");
        persons = new Label("          Persons");
        documents = new Label("        Documents");
        bande_dessinee = new Button("Bande dessinées");
        livre = new Button("Livres");
        magazine = new Button("Magazines");
        dictionaire = new Button("Dictionaires");
        professeur = new Button("Professeurs");
        etudiant = new Button("Etudiants");
        Dlayout.getChildren().addAll(tri_date,tri_asc,tri_decs,persons,etudiant,professeur,documents,bande_dessinee,livre,magazine,dictionaire);
        documents.getStyleClass().add("tril");
        persons.getStyleClass().add("tril");
        tri_date.getStyleClass().add("tril");
        bande_dessinee.getStyleClass().add("dbutton");
        livre.getStyleClass().add("dbutton");
        magazine.getStyleClass().add("dbutton");
        dictionaire.getStyleClass().add("dbutton");
        professeur.getStyleClass().add("dbutton");
        etudiant.getStyleClass().add("dbutton");
        tri_decs.getStyleClass().add("dbutton");
        tri_asc.getStyleClass().add("dbutton");
        Dlayout.setId("dl");
        tri_asc.setId("asc");
        tri_decs.setId("desc");
        tri_date.setId("tdate");

        mainLayout.setRight(Dlayout);

        scene = new Scene(mainLayout, 1200,700);
        primaryStage.setScene(scene);
        scene.getStylesheets().add("GUI/Stylesheets/lButtons.css");
        scene.getStylesheets().add("GUI/Stylesheets/Upper.css");
        scene.getStylesheets().add("GUI/Stylesheets/DocCard.css");
        scene.getStylesheets().add("GUI/Stylesheets/PersCar.css");

        //fetch data:

        //persons:
        query = "SELECT nom, prenom, p.cin, address,"
                +"numTelefon, email, type, id, "
                +"cours, grade, cne, filier,"
                +"niveau, boursie "
                +"FROM Person p "
                +"LEFT JOIN Etudiant e "
                +"ON p.cin = e.cin "
                +"LEFT JOIN Professeur pr "
                +"ON pr.cin = p.cin "
                +" ORDER BY id;";
        rs = st.executeQuery(query);

        while(rs.next()){
            switch(rs.getString("type")){
                case "etudiant":{
                    tempPers = new Etudiant(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getString("cin"),
                        rs.getString("numTelefon"),
                        rs.getString("address"),
                        rs.getDate("naissance").toLocalDate(),
                        rs.getString("filier"),
                        rs.getInt("niveau"),
                        rs.getBoolean("boursie"),
                        rs.getString("cne"));
                    bibliotheque.ajouterAdherent(tempPers);
                    break;
                }
                case "professeur":{
                    tempPers = new Professeur(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getString("cin"),
                        rs.getString("numTelefon"),
                        rs.getString("address"),
                        rs.getDate("naissance").toLocalDate(),
                        rs.getString("cours"),
                        rs.getInt("grade"));
                    bibliotheque.ajouterAdherent(tempPers);
                    break;
                }
            }
        }
        //documents:
        query = "SELECT id,d.isbn, d.titre, d.auteur, d.cin_emprunteur, d.anneeEdition, d.editeur, d.numExemplaires,"
                +" d.type, b.coloree, b.genre, di.langue, di.numTomes, l.livre_type, l.numPages,l.tome, m.jourEdition,"
                +" m.moisEdition, m.periodicity FROM Document d INNER JOIN BandeDessinee b ON d.isbn = b.isbn"
                +" INNER JOIN Dictionaire di ON di.isbn = d.isbn INNER JOIN Livre l ON d.isbn = l.isbn"
                +" INNER JOIN Magazine m ON m.isbn = d.isbn"
                +" ORDER BY id";
        
        rs = st.executeQuery(query);

        while(rs.next()){
            switch(rs.getString("type")){
                case "Bande Dessinée":{
                    tempDoc = new BandeDessinee(rs.getInt("id"),
                    rs.getString("isbn"),rs.getString("titre"),
                    rs.getString("auteur"),rs.getString("editeur"),
                    rs.getString("anneeEdition"),
                    rs.getInt("numExemplaires"),
                    rs.getBoolean("coloree"),
                    rs.getString("genre"));
                    try{
                        tempPers = bibliotheque.getPersibByCin(rs.getString("cin_emprunteur"));
                        tempDoc.set_emprunteur(tempPers);
                        bibliotheque.ajouterDocument(tempDoc);
                    } catch (ElementNotFoundException e) {
                        System.exit(1);
                    }
                }
                case "Dictionaire":{
                    tempDoc = new Dictionaire(rs.getInt("id"),
                    rs.getString("isbn"),rs.getString("titre"),
                    rs.getString("auteur"),rs.getString("editeur"),
                    rs.getString("anneeEdition"),
                    rs.getInt("numExemplaires"),
                    rs.getInt("numTomes"),
                    rs.getString("langue"));
                    try{
                        tempPers = bibliotheque.getPersibByCin(rs.getString("cin_emprunteur"));
                        tempDoc.set_emprunteur(tempPers);
                        bibliotheque.ajouterDocument(tempDoc);
                    } catch (ElementNotFoundException e) {
                        System.exit(1);
                    }
                }
                case "Livre":{
                    tempDoc = new Livre(
                        rs.getInt("id"),
                        rs.getString("isbn"),
                        rs.getString("titre"),
                        rs.getString("auteur"),
                        rs.getString("editeur"),
                        rs.getString("anneeEdition"),
                        rs.getInt("numExemplaires"),
                        rs.getInt("numPages"),
                        rs.getString("livre_type"),
                        rs.getString("tome")
                    );
                    try{
                        tempPers = bibliotheque.getPersibByCin(rs.getString("cin_emprunteur"));
                        tempDoc.set_emprunteur(tempPers);
                        bibliotheque.ajouterDocument(tempDoc);
                    } catch (ElementNotFoundException e) {
                        System.exit(1);
                    }
                }
                case "Magazine":{
                    tempDoc = new Livre(
                        rs.getInt("id"),
                        rs.getString("isbn"),
                        rs.getString("titre"),
                        rs.getString("auteur"),
                        rs.getString("editeur"),
                        rs.getString("anneeEdition"),
                        rs.getInt("numExemplaires"),
                        rs.getInt("periodicity"),
                        rs.getString("moisEdition"),
                        rs.getString("jourEdition")
                    );
                    try{
                        tempPers = bibliotheque.getPersibByCin(rs.getString("cin_emprunteur"));
                        tempDoc.set_emprunteur(tempPers);
                        bibliotheque.ajouterDocument(tempDoc);
                    } catch (ElementNotFoundException e) {
                        System.exit(1);
                    }
                }
            }
        }
        ShowAllDocs();
        primaryStage.setOnCloseRequest(e->{
            try {
                st.close();
                conn.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
        primaryStage.show();
    }
    void ShowAllDocs(){
        int pos_docs = bibliotheque.get_pos_docs();
        List<Document> docs = bibliotheque.getAllDocs();
        CBlayout.getChildren().clear();
        for(int i = 0; i <pos_docs; i++){
            DocumentCard dc = new DocumentCard(docs.get(i),CBlayout.getChildren(),bibliotheque);
            CBlayout.getChildren().add(dc);
        }
    }
    void ShowAllPersons(){
        int pos_persons = bibliotheque.get_pos_pers();
        List<Person> persons = bibliotheque.getAllPersons();
        CBlayout.getChildren().clear();
        for(int i = 0; i <pos_persons; i++){
            PersonCard dc = new PersonCard(persons.get(i),CBlayout.getChildren(),bibliotheque);
            CBlayout.getChildren().add(dc);
        }
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == ajouterDocument){
            Document doc = AddDoc.display();
            if(doc!= null){
                try {
                    bibliotheque.ajouterDocument(doc);
                    ShowAllDocs();
                    Alert cee = new Alert(AlertType.INFORMATION);
                    cee.setTitle("ajoute d'un document");
                    cee.setContentText("le document est ajouté !");
                    cee.setHeaderText("succes");
                    cee.showAndWait();
                    AddDoc.obj = null;
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
                    ShowAllPersons();
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
            String isbm = SuppDoc.ISBMASupp();
            if(isbm != null){
                try {
                    bibliotheque.supprimerDocument(isbm);
                    ShowAllDocs();
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
        if(event.getSource() == tousDocs){
            ShowAllDocs();
        }
        if(event.getSource() == tousPersons){
            ShowAllPersons();
        }
        if(event.getSource() == empruntee){
            int pos_docs = bibliotheque.get_pos_docs();
            List<Document> docs = bibliotheque.getAllDocs();
            CBlayout.getChildren().clear();
            for(int i = 0; i <pos_docs; i++){
                if(docs.get(i).get_emprunteur() != null){
                    DocumentCard dc = new DocumentCard(docs.get(i),CBlayout.getChildren(),bibliotheque);
                    CBlayout.getChildren().add(dc);
                } 
            }
        }
        if(event.getSource() == nonEmpuntee){
            int pos_docs = bibliotheque.get_pos_docs();
            List<Document> docs = bibliotheque.getAllDocs();
            CBlayout.getChildren().clear();
            for(int i = 0; i <pos_docs; i++){
                if(docs.get(i).get_emprunteur() == null){
                    DocumentCard dc = new DocumentCard(docs.get(i),CBlayout.getChildren(),bibliotheque);
                    CBlayout.getChildren().add(dc);
                } 
            }
        }
        if(event.getSource() == ChercherProf){
            String cin = ChercherPers.cinACher();
            if(cin != null){
                int pos_docs = bibliotheque.get_pos_pers();
                List<Person> docs = bibliotheque.getAllPersons();
                CBlayout.getChildren().clear();
                for(int i = 0; i <pos_docs; i++){
                    if(docs.get(i).get_nom().equals(cin)&&docs.get(i).get_type().equals("professeur")){
                        PersonCard dc = new PersonCard(docs.get(i),CBlayout.getChildren(),bibliotheque);
                        CBlayout.getChildren().add(dc);
                    } 
                }
            }
        }
        if(event.getSource() == ChercherEtud){
            String cne = ChercherPers.cneACher();
            if(cne != null){
                int pos_docs = bibliotheque.get_pos_pers();
                List<Person> docs = bibliotheque.getAllPersons();
                CBlayout.getChildren().clear();
                for(int i = 0; i <pos_docs; i++){
                    if(docs.get(i).get_nom().equals(cne)&&docs.get(i).get_type().equals("professeur")){
                        PersonCard dc = new PersonCard(docs.get(i),CBlayout.getChildren(),bibliotheque);
                        CBlayout.getChildren().add(dc);
                    } 
                }
            }
        }
    }
}
