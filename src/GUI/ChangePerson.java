package GUI;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import typeperson.*;

public class ChangePerson {

    public static void display(PersonCard obj){

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Changer un Person");
        window.setMinWidth(350);
        window.setMinHeight(300);
                switch (obj.person.get_type()){
                    case "etudiant" :{
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

                        
                        TextField nomTextField = new TextField(((Etudiant)obj.person).get_nom());
                        TextField prenomTextField = new TextField(((Etudiant)obj.person).get_prenom());
                        TextField ageTextField = new TextField(Integer.toString(((Etudiant)obj.person).get_age()));
                        TextField cinTextField = new TextField(((Etudiant)obj.person).get_cin());
                        TextField addressTextField = new TextField(((Etudiant)obj.person).get_address());
                        DatePicker naissanceTextField = new DatePicker(((Etudiant)obj.person).get_naissance());
                        TextField numTelefoneTextField = new TextField(((Etudiant)obj.person).get_num_telefone());
                        TextField emailTextField = new TextField(((Etudiant)obj.person).get_email());
                        TextField cneTextField = new TextField(((Etudiant)obj.person).get_cne());
                        TextField filierTextField = new TextField(((Etudiant)obj.person).get_filier());
                        TextField niveauTextField = new TextField(Integer.toString(((Etudiant)obj.person).get_niveau()));
                        CheckBox boursieTextField = new CheckBox();
                        if(((Etudiant)obj.person).get_boursie()) boursieTextField.setSelected(true);

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
                        Label nameW = new Label("Changer un Person");

                        mainLayout_Etudiant.setPadding(new Insets(10,10,10,10));
                        gridEtudiant.setVgap(5);
                        gridEtudiant.setHgap(15);
                        mainLayout_Etudiant.setSpacing(20);

                        HBox buttonsLayout_Etudiant = new HBox();

                        Button Add_Etudiant = new Button("Changer");

                        Add_Etudiant.setOnAction(e1 -> {
                            ((Etudiant)obj.person).set_nom(nomTextField.getText());
                            ((Etudiant)obj.person).set_prenom(prenomTextField.getText());
                            ((Etudiant)obj.person).set_age(Integer.parseInt(ageTextField.getText()));
                            ((Etudiant)obj.person).set_cin(cinTextField.getText());
                            ((Etudiant)obj.person).set_address(addressTextField.getText());
                            ((Etudiant)obj.person).set_naissance(naissanceTextField.getValue()); 
                            ((Etudiant)obj.person).set_num_telefone(numTelefoneTextField.getText());
                            ((Etudiant)obj.person).set_email(emailTextField.getText());
                            ((Etudiant)obj.person).set_cne(cneTextField.getText());
                            ((Etudiant)obj.person).set_filier(filierTextField.getText());
                            ((Etudiant)obj.person).set_niveau(Integer.parseInt(niveauTextField.getText()));
                            ((Etudiant)obj.person).set_boursie(boursieTextField.isSelected());
                            window.close();
                        });
                        Button Cancel_Etudiant = new Button("Annuler");
                        Cancel_Etudiant.setOnAction(e1 -> {
                            window.close();
                        });

                        buttonsLayout_Etudiant.getChildren().addAll(Add_Etudiant,Cancel_Etudiant);
                        buttonsLayout_Etudiant.setSpacing(20);


                        mainLayout_Etudiant.getChildren().addAll(nameW,gridEtudiant,buttonsLayout_Etudiant);


                        Scene scene_etudiant = new Scene(mainLayout_Etudiant);
                        window.setScene(scene_etudiant);
                        break;
                    }
                    case "professeur" :{
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

                        
                        TextField nomTextField = new TextField(((Professeur)obj.person).get_nom());
                        TextField prenomTextField = new TextField(((Professeur)obj.person).get_prenom());
                        TextField ageTextField = new TextField(Integer.toString(((Professeur)obj.person).get_age()));
                        TextField cinTextField = new TextField(((Professeur)obj.person).get_cin());
                        TextField addressTextField = new TextField(((Professeur)obj.person).get_address());
                        DatePicker naissanceTextField = new DatePicker(((Professeur)obj.person).get_naissance());
                        TextField numTelefoneTextField = new TextField(((Professeur)obj.person).get_num_telefone());
                        TextField emailTextField = new TextField(((Professeur)obj.person).get_email());
                        TextField CoursTextField = new TextField(((Professeur)obj.person).get_cours());
                        TextField GradeTextField = new TextField(Integer.toString(((Professeur)obj.person).get_grade()));

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
                        Label nameW = new Label("Changer un Person");

                        mainLayout_Etudiant.setPadding(new Insets(10,10,10,10));
                        gridEtudiant.setVgap(5);
                        gridEtudiant.setHgap(15);
                        mainLayout_Etudiant.setSpacing(20);


                        HBox buttonsLayout_Etudiant = new HBox();

                        Button Add_Etudiant = new Button("Changer");

                        Add_Etudiant.setOnAction(e1 -> {
                            ((Professeur)obj.person).set_nom(nomTextField.getText());
                            ((Professeur)obj.person).set_prenom(prenomTextField.getText());
                            ((Professeur)obj.person).set_age(Integer.parseInt(ageTextField.getText()));
                            ((Professeur)obj.person).set_cin(cinTextField.getText());
                            ((Professeur)obj.person).set_address(addressTextField.getText());
                            ((Professeur)obj.person).set_naissance(naissanceTextField.getValue()); 
                            ((Professeur)obj.person).set_num_telefone(numTelefoneTextField.getText());
                            ((Professeur)obj.person).set_email(emailTextField.getText());
                            ((Professeur)obj.person).set_cours(CoursTextField.getText());
                            ((Professeur)obj.person).set_grade(Integer.parseInt(GradeTextField.getText()));
                            window.close();
                        });
                        Button Cancel_Etudiant = new Button("Annuler");
                        Cancel_Etudiant.setOnAction(e1 -> {
                            window.close();
                        });

                        buttonsLayout_Etudiant.getChildren().addAll(Add_Etudiant,Cancel_Etudiant);
                        buttonsLayout_Etudiant.setSpacing(20);


                        mainLayout_Etudiant.getChildren().addAll(nameW,gridEtudiant,buttonsLayout_Etudiant);


                        Scene scene_etudiant = new Scene(mainLayout_Etudiant);
                        window.setScene(scene_etudiant);
                        break;
                    }
                    default:{

                    }
                }
        window.showAndWait();
    }
}
