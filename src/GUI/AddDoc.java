package GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import typedocs.*;

public class AddDoc {

    public static Document obj;

    public static Document display(){

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ajouter un document");
        window.setMinWidth(350);
        window.setMinHeight(300);
        

        ComboBox<String> typeDoc = new ComboBox<String>();
        typeDoc.getItems().addAll(
            "Bande Dessinée",
            "Dictionaire",
            "Livre",
            "Magazine"
        );
        typeDoc.setPromptText("genre...");

        typeDoc.setOnAction(
            e -> {
                switch (typeDoc.getValue()){
                    case "Livre" :{
                        Label ISBNlabel = new Label("ISBN :");
                        Label Auteurlabel = new Label("Auteur :");
                        Label titrelabel = new Label("titre :");
                        Label editeurlabel = new Label("editeur :");
                        Label AneEditionlabel = new Label("Année d'edition :");
                        Label numExemplaireslabel = new Label("numero d'exemplaires :");
                        Label numPageslabel = new Label("numero des pages :");
                        Label typelabel = new Label("type :");
                        Label tomelabel = new Label("tome :");

                        GridPane gridLivre = new GridPane();

                        gridLivre.add(ISBNlabel, 0, 0,1,1);
                        gridLivre.add(Auteurlabel, 0, 1,1,1);
                        gridLivre.add(titrelabel, 0, 2,1,1);
                        gridLivre.add(editeurlabel, 0, 3,1,1);
                        gridLivre.add(AneEditionlabel, 0, 4,1,1);
                        gridLivre.add(numExemplaireslabel, 0, 5,1,1);
                        gridLivre.add(numPageslabel, 0, 6,1,1);
                        gridLivre.add(typelabel, 0, 7,1,1);
                        gridLivre.add(tomelabel, 0, 8,1,1);

                        
                        TextField ISBNTextField = new TextField();
                        TextField AuteurTextField = new TextField();
                        TextField titreTextField = new TextField();
                        TextField editeurTextField = new TextField();
                        TextField AneEditionTextField = new TextField();
                        TextField numExemplairesTextField = new TextField();
                        TextField numPagesTextField = new TextField();
                        TextField typeTextField = new TextField();
                        TextField tomeTextField = new TextField();

                        gridLivre.add(ISBNTextField, 1, 0,1,1);
                        gridLivre.add(AuteurTextField, 1, 1,1,1);
                        gridLivre.add(titreTextField, 1, 2,1,1);
                        gridLivre.add(editeurTextField, 1, 3,1,1);
                        gridLivre.add(AneEditionTextField, 1, 4,1,1);
                        gridLivre.add(numExemplairesTextField, 1, 5,1,1);
                        gridLivre.add(numPagesTextField, 1, 6,1,1);
                        gridLivre.add(typeTextField, 1, 7,1,1);
                        gridLivre.add(tomeTextField, 1, 8,1,1);

                        VBox mainLayout_Livre = new VBox();
                        Label nameW = new Label("Ajouter un document");

                        mainLayout_Livre.setPadding(new Insets(10,10,10,10));
                        gridLivre.setVgap(5);
                        gridLivre.setHgap(15);

                        HBox buttonsLayout_livre = new HBox();

                        Button Add_livre = new Button("Ajouter");

                        Add_livre.setOnAction(e1 -> {
                            int isbn =  Integer.parseInt(ISBNTextField.getText());
                            String auteur = AuteurTextField.getText();
                            String titre = titreTextField.getText();
                            String editeur = editeurTextField.getText();
                            String AneEdition = AneEditionTextField.getText();
                            int numExemplaires = Integer.parseInt(numExemplairesTextField.getText());
                            int numPages = Integer.parseInt(numPagesTextField.getText());
                            String type = typeTextField.getText();
                            String tome = tomeTextField.getText();
                            obj = new Livre(isbn,titre,auteur,editeur,AneEdition,numExemplaires,numPages,type,tome);
                            window.close();
                        });
                        Button Cancel_livre = new Button("Annuler");
                        Cancel_livre.setOnAction(e1 -> {
                            window.close();
                        });

                        buttonsLayout_livre.getChildren().addAll(Add_livre,Cancel_livre);

                        mainLayout_Livre.getChildren().addAll(nameW,typeDoc,gridLivre,buttonsLayout_livre);


                        Scene scene_livre = new Scene(mainLayout_Livre);
                        window.setScene(scene_livre);
                        break;
                    }
                    case "Dictionaire" :{
                        Label nameW = new Label("Ajouter un document");

                        Label ISBNlabel = new Label("ISBN :");
                        Label Auteurlabel = new Label("Auteur :");
                        Label titrelabel = new Label("titre :");
                        Label editeurlabel = new Label("editeur :");
                        Label AneEditionlabel = new Label("Année d'edition :");
                        Label numExemplaireslabel = new Label("numero d'exemplaires :");
                        Label numTomeslabel = new Label("numero de tomes :");
                        Label langelabel = new Label("lange :");
                        GridPane gridDict = new GridPane();

                        gridDict.add(ISBNlabel, 0, 0,1,1);
                        gridDict.add(Auteurlabel, 0, 1,1,1);
                        gridDict.add(titrelabel, 0, 2,1,1);
                        gridDict.add(editeurlabel, 0, 3,1,1);
                        gridDict.add(AneEditionlabel, 0, 4,1,1);
                        gridDict.add(numExemplaireslabel, 0, 5,1,1);
                        gridDict.add(numTomeslabel, 0, 6,1,1);
                        gridDict.add(langelabel, 0, 7,1,1);

                        TextField ISBNTextField = new TextField();
                        TextField AuteurTextField = new TextField();
                        TextField titreTextField = new TextField();
                        TextField editeurTextField = new TextField();
                        TextField AneEditionTextField = new TextField();
                        TextField numExemplairesTextField = new TextField();
                        TextField numTomesTextField = new TextField();
                        TextField langeTextField = new TextField();

                        gridDict.add(ISBNTextField, 1, 0,1,1);
                        gridDict.add(AuteurTextField, 1, 1,1,1);
                        gridDict.add(titreTextField, 1, 2,1,1);
                        gridDict.add(editeurTextField, 1, 3,1,1);
                        gridDict.add(AneEditionTextField, 1, 4,1,1);
                        gridDict.add(numExemplairesTextField, 1, 5,1,1);
                        gridDict.add(numTomesTextField, 1, 6,1,1);
                        gridDict.add(langeTextField, 1, 7,1,1);

                        VBox mainLayout_dictionnaire = new VBox();

                        mainLayout_dictionnaire.setPadding(new Insets(10,10,10,10));
                        gridDict.setVgap(5);
                        gridDict.setHgap(15);


                        HBox buttonsLayout_dictionnaire = new HBox();
                        Button Add_dictionnaire = new Button("Ajouter");
                        Button Cancel_dictionnaire = new Button("Annuler");
                        Add_dictionnaire.setOnAction(e1 -> {
                            int isbn =  Integer.parseInt(ISBNTextField.getText());
                            String auteur = AuteurTextField.getText();
                            String titre = titreTextField.getText();
                            String editeur = editeurTextField.getText();
                            String AneEdition = AneEditionTextField.getText();
                            int numExemplaires = Integer.parseInt(numExemplairesTextField.getText());
                            int numTomes = Integer.parseInt(numTomesTextField.getText());
                            String langue = langeTextField.getText();
                            obj = new Dictionaire(isbn,titre,auteur,editeur,AneEdition,numExemplaires,numTomes,langue);
                            window.close();
                        });
                        Cancel_dictionnaire.setOnAction(e1 -> {
                            window.close();
                        });
                        buttonsLayout_dictionnaire.getChildren().addAll(Add_dictionnaire,Cancel_dictionnaire);

                        mainLayout_dictionnaire.getChildren().addAll(nameW,typeDoc,gridDict,buttonsLayout_dictionnaire);

                        Scene scene_dictionnaire = new Scene(mainLayout_dictionnaire);

                        window.setScene(scene_dictionnaire);
                        break;
                    }
                    case "Bande Dessinée" :{

                        Label nameW = new Label("Ajouter un document");
                        Label ISBNlabel = new Label("ISBN :");
                        Label Auteurlabel = new Label("Auteur :");
                        Label titrelabel = new Label("titre :");
                        Label editeurlabel = new Label("editeur :");
                        Label AneEditionlabel = new Label("Année d'edition :");
                        Label numExemplaireslabel = new Label("numero d'exemplaires :");
                        Label coloreelabel = new Label("coloree :");
                        Label genrelabel = new Label("genre :");

                        GridPane gridBd = new GridPane();

                        gridBd.add(ISBNlabel, 0, 0,1,1);
                        gridBd.add(Auteurlabel, 0, 1,1,1);
                        gridBd.add(titrelabel, 0, 2,1,1);
                        gridBd.add(editeurlabel, 0, 3,1,1);
                        gridBd.add(AneEditionlabel, 0, 4,1,1);
                        gridBd.add(numExemplaireslabel, 0, 5,1,1);
                        gridBd.add(coloreelabel, 0, 6,1,1);
                        gridBd.add(genrelabel, 0, 7,1,1);

                        TextField ISBNTextField = new TextField();
                        TextField AuteurTextField = new TextField();
                        TextField titreTextField = new TextField();
                        TextField editeurTextField = new TextField();
                        TextField AneEditionTextField = new TextField();
                        TextField numExemplairesTextField = new TextField();
                        CheckBox coloreeTextField = new CheckBox();
                        TextField genreTextField = new TextField();

                        gridBd.add(ISBNTextField, 1, 0,1,1);
                        gridBd.add(AuteurTextField, 1, 1,1,1);
                        gridBd.add(titreTextField, 1, 2,1,1);
                        gridBd.add(editeurTextField, 1, 3,1,1);
                        gridBd.add(AneEditionTextField, 1, 4,1,1);
                        gridBd.add(numExemplairesTextField, 1, 5,1,1);
                        gridBd.add(coloreeTextField, 1, 6,1,1);
                        gridBd.add(genreTextField, 1, 7,1,1);

                        VBox mainLayout_bandedessinee = new VBox();

                        mainLayout_bandedessinee.setPadding(new Insets(10,10,10,10));
                        gridBd.setVgap(5);
                        gridBd.setHgap(15);
                
                
                        HBox buttonsLayout_bandedessinee = new HBox();
                        Button Add_bandedessinee = new Button("Ajouter");
                        Button Cancel_bandedessinee = new Button("Annuler");
                        Add_bandedessinee.setOnAction(e1 -> {
                            int isbn =  Integer.parseInt(ISBNTextField.getText());
                            String auteur = AuteurTextField.getText();
                            String titre = titreTextField.getText();
                            String editeur = editeurTextField.getText();
                            String AneEdition = AneEditionTextField.getText();
                            int numExemplaires = Integer.parseInt(numExemplairesTextField.getText());
                            boolean coloree = coloreeTextField.isSelected();
                            String genre = genreTextField.getText();
                            obj = new BandeDessinee(isbn,titre,auteur,editeur,AneEdition,numExemplaires,coloree,genre);
                            window.close();
                        });
                        Cancel_bandedessinee.setOnAction(e1 -> {
                            window.close();
                        });
                        buttonsLayout_bandedessinee.getChildren().addAll(Add_bandedessinee,Cancel_bandedessinee);
                
                        mainLayout_bandedessinee.getChildren().addAll(nameW,typeDoc,gridBd,buttonsLayout_bandedessinee);
                
                        Scene scene_bandedessinee = new Scene(mainLayout_bandedessinee);

                        window.setScene(scene_bandedessinee);
                        break;
                    }
                    case "Magazine" :{
                        Label nameW = new Label("Ajouter un document");

                        Label ISBNlabel = new Label("ISBN :");
                        Label Auteurlabel = new Label("Auteur :");
                        Label titrelabel = new Label("titre :");
                        Label editeurlabel = new Label("editeur :");
                        Label AneEditionlabel = new Label("Année d'edition :");
                        Label numExemplaireslabel = new Label("numero d'exemplaires :");
                        Label periodicitylabel = new Label("periodicity :");
                        Label moisEditionlabel = new Label("mois d'edition :");
                        Label jourEditionlabel = new Label("jour d'edition :");

                        GridPane gridM = new GridPane();

                        gridM.add(ISBNlabel, 0, 0,1,1);
                        gridM.add(Auteurlabel, 0, 1,1,1);
                        gridM.add(titrelabel, 0, 2,1,1);
                        gridM.add(editeurlabel, 0, 3,1,1);
                        gridM.add(AneEditionlabel, 0, 4,1,1);
                        gridM.add(numExemplaireslabel, 0, 5,1,1);
                        gridM.add(periodicitylabel, 0, 6,1,1);
                        gridM.add(moisEditionlabel, 0, 7,1,1);
                        gridM.add(jourEditionlabel, 0, 8,1,1);

                        
                        TextField ISBNTextField = new TextField();
                        TextField AuteurTextField = new TextField();
                        TextField titreTextField = new TextField();
                        TextField editeurTextField = new TextField();
                        TextField AneEditionTextField = new TextField();
                        TextField numExemplairesTextField = new TextField();
                        TextField periodicityTextField = new TextField();
                        TextField moisEditionTextField = new TextField();
                        TextField jourEditionTextField = new TextField();

                        gridM.add(ISBNTextField, 1, 0,1,1);
                        gridM.add(AuteurTextField, 1, 1,1,1);
                        gridM.add(titreTextField, 1, 2,1,1);
                        gridM.add(editeurTextField, 1, 3,1,1);
                        gridM.add(AneEditionTextField, 1, 4,1,1);
                        gridM.add(numExemplairesTextField, 1, 5,1,1);
                        gridM.add(periodicityTextField, 1, 6,1,1);
                        gridM.add(moisEditionTextField, 1, 7,1,1);
                        gridM.add(jourEditionTextField, 1, 8,1,1);

                        VBox mainLayout_magazine = new VBox();

                        mainLayout_magazine.setPadding(new Insets(10,10,10,10));
                        gridM.setVgap(5);
                        gridM.setHgap(15);
                
                        HBox buttonsLayout_magazine = new HBox();
                        Button Add_magazine = new Button("Ajouter");
                        Button Cancel_magazine = new Button("Annuler");
                        Add_magazine.setOnAction(e1 -> {
                            int isbn =  Integer.parseInt(ISBNTextField.getText());
                            String auteur = AuteurTextField.getText();
                            String titre = titreTextField.getText();
                            String editeur = editeurTextField.getText();
                            String AneEdition = AneEditionTextField.getText();
                            int numExemplaires = Integer.parseInt(numExemplairesTextField.getText());
                            int periodicity = Integer.parseInt(periodicityTextField.getText());
                            int moisEdition = Integer.parseInt(moisEditionTextField.getText());
                            int jourEdition = Integer.parseInt(jourEditionTextField.getText());
                            obj = new Magazine(isbn,titre,auteur,editeur,AneEdition,numExemplaires,periodicity,moisEdition,jourEdition);
                            window.close();
                        });
                        Cancel_magazine.setOnAction(e1 -> {
                            window.close();
                        });
                        buttonsLayout_magazine.getChildren().addAll(Add_magazine,Cancel_magazine);
                
                        mainLayout_magazine.getChildren().addAll(nameW,typeDoc,gridM,buttonsLayout_magazine);
                
                        Scene scene_magazine = new Scene(mainLayout_magazine);                

                        window.setScene(scene_magazine);
                        break;
                    }
                    default:{

                    }
                }
            }
        );
        VBox defl = new VBox();
        Label nameW = new Label("Ajouter un document");
        defl.getChildren().addAll(nameW,typeDoc);
        Scene sel = new Scene(defl);
        window.setScene(sel);
        window.showAndWait();

        return obj;
    }
}
