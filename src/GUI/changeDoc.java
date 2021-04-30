package GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import typedocs.*;

public class changeDoc {

    public static void display(DocumentCard obj){

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Changer un Document");
        window.setMinWidth(350);
        window.setMinHeight(300);
                switch (obj.document.get_type()){
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

                        
                        TextField ISBNTextField = new TextField(((Livre)obj.document).get_ISBN());
                        TextField AuteurTextField = new TextField(((Livre)obj.document).get_auteurs());
                        TextField titreTextField = new TextField(((Livre)obj.document).get_titre());
                        TextField editeurTextField = new TextField(((Livre)obj.document).get_editeur());
                        TextField AneEditionTextField = new TextField(((Livre)obj.document).get_ane_edition());
                        TextField numExemplairesTextField = new TextField(Integer.toString(((Livre)obj.document).get_num_exemplaires()));
                        TextField numPagesTextField = new TextField(Integer.toString(((Livre)obj.document).get_num_pages()));
                        TextField typeTextField = new TextField(((Livre)obj.document).get_livre_type());
                        TextField tomeTextField = new TextField(((Livre)obj.document).get_tome());

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
                        Label nameW = new Label("Changer un Document");

                        mainLayout_Livre.setPadding(new Insets(10,10,10,10));
                        gridLivre.setVgap(5);
                        gridLivre.setHgap(15);

                        HBox buttonsLayout_livre = new HBox();

                        Button Add_livre = new Button("Changer");

                        Add_livre.setOnAction(e1 -> {
                            ((Livre)obj.document).set_ISBN(ISBNTextField.getText());
                            ((Livre)obj.document).set_auteurs(AuteurTextField.getText());
                            ((Livre)obj.document).set_titre(titreTextField.getText());
                            ((Livre)obj.document).set_editeur(editeurTextField.getText());
                            ((Livre)obj.document).set_ane_edition(AneEditionTextField.getText());
                            ((Livre)obj.document).set_num_exemplaires(Integer.parseInt(numExemplairesTextField.getText()));
                            ((Livre)obj.document).set_num_pages(Integer.parseInt(numPagesTextField.getText()));
                            ((Livre)obj.document).set_livre_type(typeTextField.getText());
                            ((Livre)obj.document).set_tome(tomeTextField.getText());
                            window.close();
                        });
                        Button Cancel_livre = new Button("Annuler");
                        Cancel_livre.setOnAction(e1 -> {
                            window.close();
                        });

                        buttonsLayout_livre.getChildren().addAll(Add_livre,Cancel_livre);
                        buttonsLayout_livre.setSpacing(20);


                        mainLayout_Livre.getChildren().addAll(nameW,gridLivre,buttonsLayout_livre);
                        mainLayout_Livre.setSpacing(20);

                        Scene scene_livre = new Scene(mainLayout_Livre);
                        window.setScene(scene_livre);
                        break;
                    }
                    case "Dictionaire" :{
                        Label nameW = new Label("Changer un Document");
                        Label ISBNlabel = new Label("ISBN :");
                        Label Auteurlabel = new Label("Auteur :");
                        Label titrelabel = new Label("titre :");
                        Label editeurlabel = new Label("editeur :");
                        Label AneEditionlabel = new Label("Année d'edition :");
                        Label numExemplaireslabel = new Label("numero d'exemplaires :");
                        Label numTomeslabel = new Label("numero de tomes :");
                        Label langelabel = new Label("langue :");
                        GridPane gridDict = new GridPane();

                        gridDict.add(ISBNlabel, 0, 0,1,1);
                        gridDict.add(Auteurlabel, 0, 1,1,1);
                        gridDict.add(titrelabel, 0, 2,1,1);
                        gridDict.add(editeurlabel, 0, 3,1,1);
                        gridDict.add(AneEditionlabel, 0, 4,1,1);
                        gridDict.add(numExemplaireslabel, 0, 5,1,1);
                        gridDict.add(numTomeslabel, 0, 6,1,1);
                        gridDict.add(langelabel, 0, 7,1,1);

                        TextField ISBNTextField = new TextField(((Dictionaire)obj.document).get_ISBN());
                        TextField AuteurTextField = new TextField(((Dictionaire)obj.document).get_auteurs());
                        TextField titreTextField = new TextField(((Dictionaire)obj.document).get_titre());
                        TextField editeurTextField = new TextField(((Dictionaire)obj.document).get_editeur());
                        TextField AneEditionTextField = new TextField(((Dictionaire)obj.document).get_ane_edition());
                        TextField numExemplairesTextField = new TextField(Integer.toString(((Dictionaire)obj.document).get_num_exemplaires()));
                        TextField numTomesTextField = new TextField(Integer.toString(((Dictionaire)obj.document).get_num_tomes()));
                        TextField langeTextField = new TextField(((Dictionaire)obj.document).get_langue());

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
                        mainLayout_dictionnaire.setSpacing(20);
                        gridDict.setVgap(5);
                        gridDict.setHgap(15);


                        HBox buttonsLayout_dictionnaire = new HBox();
                        Button Add_dictionnaire = new Button("Changer");
                        Button Cancel_dictionnaire = new Button("Annuler");
                        Add_dictionnaire.setOnAction(e1 -> {
                            ((Dictionaire)obj.document).set_ISBN(ISBNTextField.getText());
                            ((Dictionaire)obj.document).set_auteurs(AuteurTextField.getText());
                            ((Dictionaire)obj.document).set_titre(titreTextField.getText());
                            ((Dictionaire)obj.document).set_editeur(editeurTextField.getText());
                            ((Dictionaire)obj.document).set_ane_edition(AneEditionTextField.getText());
                            ((Dictionaire)obj.document).set_num_exemplaires(Integer.parseInt(numExemplairesTextField.getText()));
                            ((Dictionaire)obj.document).set_num_tomes(Integer.parseInt(numTomesTextField.getText()));
                            ((Dictionaire)obj.document).set_langue(langeTextField.getText());
                            window.close();
                        });
                        Cancel_dictionnaire.setOnAction(e1 -> {
                            window.close();
                        });
                        buttonsLayout_dictionnaire.getChildren().addAll(Add_dictionnaire,Cancel_dictionnaire);
                        buttonsLayout_dictionnaire.setSpacing(20);

                        mainLayout_dictionnaire.getChildren().addAll(nameW,gridDict,buttonsLayout_dictionnaire);

                        Scene scene_dictionnaire = new Scene(mainLayout_dictionnaire);

                        window.setScene(scene_dictionnaire);
                        break;
                    }
                    case "Bande Dessinée" :{

                        Label nameW = new Label("Changer un Document");
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

                        
                        TextField ISBNTextField = new TextField(((BandeDessinee)obj.document).get_ISBN());
                        TextField AuteurTextField = new TextField(((BandeDessinee)obj.document).get_auteurs());
                        TextField titreTextField = new TextField(((BandeDessinee)obj.document).get_titre());
                        TextField editeurTextField = new TextField(((BandeDessinee)obj.document).get_editeur());
                        TextField AneEditionTextField = new TextField(((BandeDessinee)obj.document).get_ane_edition());
                        TextField numExemplairesTextField = new TextField(Integer.toString(((BandeDessinee)obj.document).get_num_exemplaires()));
                        CheckBox coloreeTextField = new CheckBox();
                        if(((BandeDessinee)obj.document).get_coloree()) coloreeTextField.setSelected(true);

                        TextField genreTextField = new TextField(((BandeDessinee)obj.document).get_genre());

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
                        mainLayout_bandedessinee.setSpacing(20);

                
                
                        HBox buttonsLayout_bandedessinee = new HBox();
                        Button Add_bandedessinee = new Button("Changer");
                        Button Cancel_bandedessinee = new Button("Annuler");
                        Add_bandedessinee.setOnAction(e1 -> {
                            ((BandeDessinee)obj.document).set_ISBN(ISBNTextField.getText());
                            ((BandeDessinee)obj.document).set_auteurs(AuteurTextField.getText());
                            ((BandeDessinee)obj.document).set_titre(titreTextField.getText());
                            ((BandeDessinee)obj.document).set_editeur(editeurTextField.getText());
                            ((BandeDessinee)obj.document).set_ane_edition(AneEditionTextField.getText());
                            ((BandeDessinee)obj.document).set_num_exemplaires(Integer.parseInt(numExemplairesTextField.getText()));
                            ((BandeDessinee)obj.document).set_coloree(coloreeTextField.isSelected());
                            ((BandeDessinee)obj.document).set_genre(genreTextField.getText());
                            window.close();
                        });
                        Cancel_bandedessinee.setOnAction(e1 -> {
                            window.close();
                        });
                        buttonsLayout_bandedessinee.getChildren().addAll(Add_bandedessinee,Cancel_bandedessinee);
                        buttonsLayout_bandedessinee.setSpacing(20);

                
                        mainLayout_bandedessinee.getChildren().addAll(nameW,gridBd,buttonsLayout_bandedessinee);
                
                        Scene scene_bandedessinee = new Scene(mainLayout_bandedessinee);

                        window.setScene(scene_bandedessinee);
                        break;
                    }
                    case "Magazine" :{
                        Label nameW = new Label("Changer un Document");

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

                        
                        TextField ISBNTextField = new TextField(((Magazine)obj.document).get_ISBN());
                        TextField AuteurTextField = new TextField(((Magazine)obj.document).get_auteurs());
                        TextField titreTextField = new TextField(((Magazine)obj.document).get_titre());
                        TextField editeurTextField = new TextField(((Magazine)obj.document).get_editeur());
                        TextField AneEditionTextField = new TextField(((Magazine)obj.document).get_ane_edition());
                        TextField numExemplairesTextField = new TextField(Integer.toString(((Magazine)obj.document).get_num_exemplaires()));
                        TextField periodicityTextField = new TextField(((Magazine)obj.document).get_ISBN());
                        TextField moisEditionTextField = new TextField(Integer.toString(((Magazine)obj.document).get_mois_edition()));
                        TextField jourEditionTextField = new TextField(Integer.toString(((Magazine)obj.document).get_jour_edition()));

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
                        mainLayout_magazine.setSpacing(20);

                        HBox buttonsLayout_magazine = new HBox();
                        Button Add_magazine = new Button("Changer");
                        Button Cancel_magazine = new Button("Annuler");
                        Add_magazine.setOnAction(e1 -> {
                            ((Magazine)obj.document).set_ISBN(ISBNTextField.getText());
                            ((Magazine)obj.document).set_auteurs(AuteurTextField.getText());
                            ((Magazine)obj.document).set_titre(titreTextField.getText());
                            ((Magazine)obj.document).set_editeur(editeurTextField.getText());
                            ((Magazine)obj.document).set_ane_edition(AneEditionTextField.getText());
                            ((Magazine)obj.document).set_num_exemplaires(Integer.parseInt(numExemplairesTextField.getText()));
                            ((Magazine)obj.document).set_periodicity(Integer.parseInt(periodicityTextField.getText()));
                            ((Magazine)obj.document).set_mois_edition(Integer.parseInt(moisEditionTextField.getText()));
                            ((Magazine)obj.document).set_jour_edition(Integer.parseInt(jourEditionTextField.getText()));
                            window.close();
                        });
                        Cancel_magazine.setOnAction(e1 -> {
                            window.close();
                        });
                        buttonsLayout_magazine.getChildren().addAll(Add_magazine,Cancel_magazine);
                        buttonsLayout_magazine.setSpacing(20);

                
                        mainLayout_magazine.getChildren().addAll(nameW,gridM,buttonsLayout_magazine);
                
                        Scene scene_magazine = new Scene(mainLayout_magazine);                

                        window.setScene(scene_magazine);
                        break;
                    }
                    default:{

                    }
        }
        window.showAndWait();
    }
}
