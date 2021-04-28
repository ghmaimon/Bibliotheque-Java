package GUI;

import java.time.LocalDate;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import typeperson.*;

public class AddPerson {

    public static Person obj;

    public static Person display(){

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ajouter un Person");
        window.setMinWidth(350);
        window.setMinHeight(300);
        

        ComboBox<String> typeDoc = new ComboBox<String>();
        typeDoc.getItems().addAll(
            "Etudiant",
            "Professeur"
        );
        typeDoc.setPromptText("Person...");
        typeDoc.setOnAction(
            e -> {
                switch (typeDoc.getValue()){
                    case "Etudiant" :{
                        Label nomlabel = new Label("Nom :");
                        Label prenomlabel = new Label("Prenom :");
                        Label agelabel = new Label("Age :");
                        Label cinlabel = new Label("CIN :");
                        Label addresslabel = new Label("Address :");
                        Label naissancelabel = new Label("Naissance :");
                        Label numTelefonelabel = new Label("Numero de telefon :");
                        Label emaillabel = new Label("Email :");
                        Label cnelabel = new Label("CNE :");
                        Label filierlabel = new Label("Filier :");
                        Label niveaulabel = new Label("Niveau :");
                        Label boursielabel = new Label("Boursié(e) :");

                        GridPane gridEtudiant = new GridPane();

                        gridEtudiant.add(nomlabel, 0, 0,1,1);
                        gridEtudiant.add(prenomlabel, 0, 1,1,1);
                        gridEtudiant.add(agelabel, 0, 2,1,1);
                        gridEtudiant.add(cinlabel, 0, 3,1,1);
                        gridEtudiant.add(addresslabel, 0, 4,1,1);
                        gridEtudiant.add(naissancelabel, 0, 5,1,1);
                        gridEtudiant.add(numTelefonelabel, 0, 6,1,1);
                        gridEtudiant.add(emaillabel, 0, 7,1,1);
                        gridEtudiant.add(cnelabel, 0, 8,1,1);
                        gridEtudiant.add(filierlabel, 0, 9,1,1);
                        gridEtudiant.add(niveaulabel, 0, 10,1,1);
                        gridEtudiant.add(boursielabel, 0, 11,1,1);

                        
                        TextField nomTextField = new TextField();
                        TextField prenomTextField = new TextField();
                        TextField ageTextField = new TextField();
                        TextField cinTextField = new TextField();
                        TextField addressTextField = new TextField();
                        DatePicker naissanceTextField = new DatePicker();
                        TextField numTelefoneTextField = new TextField();
                        TextField emailTextField = new TextField();
                        TextField cneTextField = new TextField();
                        TextField filierTextField = new TextField();
                        TextField niveauTextField = new TextField();
                        CheckBox boursieTextField = new CheckBox();

                        gridEtudiant.add(nomTextField, 1, 0,1,1);
                        gridEtudiant.add(prenomTextField, 1, 1,1,1);
                        gridEtudiant.add(ageTextField, 1, 2,1,1);
                        gridEtudiant.add(cinTextField, 1, 3,1,1);
                        gridEtudiant.add(addressTextField, 1, 4,1,1);
                        gridEtudiant.add(naissanceTextField, 1, 5,1,1);
                        gridEtudiant.add(numTelefoneTextField, 1, 6,1,1);
                        gridEtudiant.add(emailTextField, 1, 7,1,1);
                        gridEtudiant.add(cneTextField, 1, 8,1,1);
                        gridEtudiant.add(filierTextField, 1, 9,1,1);
                        gridEtudiant.add(niveauTextField, 1, 10,1,1);
                        gridEtudiant.add(boursieTextField, 1, 11,1,1);

                        VBox mainLayout_Etudiant = new VBox();
                        Label nameW = new Label("Ajouter un Person");

                        mainLayout_Etudiant.setPadding(new Insets(10,10,10,10));
                        gridEtudiant.setVgap(5);
                        gridEtudiant.setHgap(15);

                        HBox buttonsLayout_Etudiant = new HBox();

                        Button Add_Etudiant = new Button("Ajouter");

                        Add_Etudiant.setOnAction(e1 -> {
                            String nom = nomTextField.getText();
                            String prenom= prenomTextField.getText();
                            int age= Integer.parseInt(ageTextField.getText());
                            String cin = cinTextField.getText();
                            String address = addressTextField.getText();;
                            LocalDate naissance = naissanceTextField.getValue(); 
                            System.out.println(naissance);
                            String numTelefone = numTelefoneTextField.getText();
                            String email = emailTextField.getText();
                            String cne = cneTextField.getText();
                            String filier = filierTextField.getText();
                            int niveau = Integer.parseInt(niveauTextField.getText());
                            boolean boursie = boursieTextField.isSelected();
                            obj = new Etudiant(nom,prenom,age,email,cin,numTelefone,address,naissance,filier,niveau,boursie,cne);
                            window.close();
                        });
                        Button Cancel_Etudiant = new Button("Annuler");
                        Cancel_Etudiant.setOnAction(e1 -> {
                            window.close();
                        });

                        buttonsLayout_Etudiant.getChildren().addAll(Add_Etudiant,Cancel_Etudiant);

                        mainLayout_Etudiant.getChildren().addAll(nameW,typeDoc,gridEtudiant,buttonsLayout_Etudiant);


                        Scene scene_etudiant = new Scene(mainLayout_Etudiant);
                        window.setScene(scene_etudiant);
                        break;
                    }
                    case "Professeur" :{
                        Label nomlabel = new Label("Nom :");
                        Label prenomlabel = new Label("Prenom :");
                        Label agelabel = new Label("Age :");
                        Label cinlabel = new Label("CIN :");
                        Label addresslabel = new Label("Address :");
                        Label naissancelabel = new Label("Naissance :");
                        Label numTelefonelabel = new Label("Numero de telefon :");
                        Label emaillabel = new Label("Email :");
                        Label Courslabel = new Label("Cours :");
                        Label Gradelabel = new Label("Grade :");

                        GridPane gridEtudiant = new GridPane();

                        gridEtudiant.add(nomlabel, 0, 0,1,1);
                        gridEtudiant.add(prenomlabel, 0, 1,1,1);
                        gridEtudiant.add(agelabel, 0, 2,1,1);
                        gridEtudiant.add(cinlabel, 0, 3,1,1);
                        gridEtudiant.add(addresslabel, 0, 4,1,1);
                        gridEtudiant.add(naissancelabel, 0, 5,1,1);
                        gridEtudiant.add(numTelefonelabel, 0, 6,1,1);
                        gridEtudiant.add(emaillabel, 0, 7,1,1);
                        gridEtudiant.add(Courslabel, 0, 8,1,1);
                        gridEtudiant.add(Gradelabel, 0, 9,1,1);

                        
                        TextField nomTextField = new TextField();
                        TextField prenomTextField = new TextField();
                        TextField ageTextField = new TextField();
                        TextField cinTextField = new TextField();
                        TextField addressTextField = new TextField();
                        DatePicker naissanceTextField = new DatePicker();
                        TextField numTelefoneTextField = new TextField();
                        TextField emailTextField = new TextField();
                        TextField CoursTextField = new TextField();
                        TextField GradeTextField = new TextField();

                        gridEtudiant.add(nomTextField, 1, 0,1,1);
                        gridEtudiant.add(prenomTextField, 1, 1,1,1);
                        gridEtudiant.add(ageTextField, 1, 2,1,1);
                        gridEtudiant.add(cinTextField, 1, 3,1,1);
                        gridEtudiant.add(addressTextField, 1, 4,1,1);
                        gridEtudiant.add(naissanceTextField, 1, 5,1,1);
                        gridEtudiant.add(numTelefoneTextField, 1, 6,1,1);
                        gridEtudiant.add(emailTextField, 1, 7,1,1);
                        gridEtudiant.add(CoursTextField, 1, 8,1,1);
                        gridEtudiant.add(GradeTextField, 1, 9,1,1);

                        VBox mainLayout_Etudiant = new VBox();
                        Label nameW = new Label("Ajouter un Person");

                        mainLayout_Etudiant.setPadding(new Insets(10,10,10,10));
                        gridEtudiant.setVgap(5);
                        gridEtudiant.setHgap(15);

                        HBox buttonsLayout_Etudiant = new HBox();

                        Button Add_Etudiant = new Button("Ajouter");

                        Add_Etudiant.setOnAction(e1 -> {
                            String nom = nomTextField.getText();
                            String prenom= prenomTextField.getText();
                            int age= Integer.parseInt(ageTextField.getText());
                            String cin = cinTextField.getText();
                            String address = addressTextField.getText();;
                            LocalDate naissance = naissanceTextField.getValue(); 
                            String numTelefone = numTelefoneTextField.getText();
                            String email = emailTextField.getText();
                            String cours = CoursTextField.getText();
                            int grade = Integer.parseInt(GradeTextField.getText());
                            obj = new Professeur(nom,prenom,age,email,cin,numTelefone,address,naissance,cours,grade);
                            window.close();
                        });
                        Button Cancel_Etudiant = new Button("Annuler");
                        Cancel_Etudiant.setOnAction(e1 -> {
                            window.close();
                        });

                        buttonsLayout_Etudiant.getChildren().addAll(Add_Etudiant,Cancel_Etudiant);

                        mainLayout_Etudiant.getChildren().addAll(nameW,typeDoc,gridEtudiant,buttonsLayout_Etudiant);


                        Scene scene_etudiant = new Scene(mainLayout_Etudiant);
                        window.setScene(scene_etudiant);
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
