package GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChercherPers {

    static String cin,cne;

    public static String cinACher(){
        cin = null;
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Supprimer un Professeur");

        VBox layout = new VBox();
        HBox layoutButtons = new HBox();
        HBox layoutForm = new HBox();
        Button supprimer = new Button("Supprimer");
        Button annuler = new Button("Annuler");
        Label cinLabel = new Label("CIN : ");
        TextField cinTextField = new TextField();
        layout.getChildren().addAll(layoutForm,layoutButtons);
        supprimer.setDisable(true);
        cinTextField.textProperty().addListener (e-> {
            if(cinTextField.getText().isEmpty()){
                supprimer.setDisable(true);
            }
            else{
                supprimer.setDisable(false);
            }
        });
        supprimer.setOnAction(e -> {
            cin = cinTextField.getText();
            window.close();
        });
        annuler.setOnAction(e -> {
            window.close();
        });
        layoutButtons.getChildren().addAll(supprimer,annuler);
        layoutForm.getChildren().addAll(cinLabel,cinTextField);
        
        layout.setPadding(new Insets(10,10,10,10));
        Scene scene = new Scene(layout);
        window.setScene(scene);
        layout.setPadding(new Insets(10,10,10,10));

        window.showAndWait();

        return cin;
    }
    public static String cneACher(){
        cne = null;
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Supprimer un Professeur");

        VBox layout = new VBox();
        HBox layoutButtons = new HBox();
        HBox layoutForm = new HBox();
        Button supprimer = new Button("Supprimer");
        Button annuler = new Button("Annuler");
        Label cneLabel = new Label("CNE : ");
        TextField cneTextField = new TextField();
        layout.getChildren().addAll(layoutForm,layoutButtons);
        supprimer.setDisable(true);
        cneTextField.textProperty().addListener (e-> {
            if(cneTextField.getText().isEmpty()){
                supprimer.setDisable(true);
            }
            else{
                supprimer.setDisable(false);
            }
        });
        supprimer.setOnAction(e -> {
            cne = cneTextField.getText();
            window.close();
        });
        annuler.setOnAction(e -> {
            window.close();
        });
        layoutButtons.getChildren().addAll(supprimer,annuler);
        layoutForm.getChildren().addAll(cneLabel,cneTextField);
        
        layout.setPadding(new Insets(10,10,10,10));
        Scene scene = new Scene(layout);
        window.setScene(scene);
        layout.setPadding(new Insets(10,10,10,10));

        window.showAndWait();

        return cne;
    }
}
