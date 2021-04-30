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

public class SuppDoc {
    static String ISBM;
    public static String ISBMASupp(){
        ISBM = null;
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Supprimer un document");

        VBox layout = new VBox();
        HBox layoutButtons = new HBox();
        HBox layoutForm = new HBox();
        Button supprimer = new Button("Supprimer");
        Button annuler = new Button("Annuler");
        Label ISBMLabel = new Label("ISBN : ");
        TextField ISBMTextField = new TextField();
        layout.getChildren().addAll(layoutForm,layoutButtons);
        supprimer.setDisable(true);
        ISBMTextField.textProperty().addListener (e-> {
            if(ISBMTextField.getText().isEmpty()){
                supprimer.setDisable(true);
            }
            else{
                supprimer.setDisable(false);
            }
        });
        supprimer.setOnAction(e -> {
            ButtonType oui = new ButtonType("Oui",ButtonBar.ButtonData.YES);
            ButtonType non = new ButtonType("Non",ButtonBar.ButtonData.NO);
            Alert supAl = new Alert(Alert.AlertType.CONFIRMATION);
            supAl.getButtonTypes().setAll(oui,non);
            supAl.setHeaderText("vous êtes sûr ?");
            if(supAl.showAndWait().get() == oui){
                ISBM = ISBMTextField.getText();
                window.close();
            }else{
                window.close();
            }
        });
        annuler.setOnAction(e -> {
            window.close();
        });
        layoutButtons.getChildren().addAll(supprimer,annuler);
        layoutForm.getChildren().addAll(ISBMLabel,ISBMTextField);
        
        layout.setPadding(new Insets(10,10,10,10));
        Scene scene = new Scene(layout);
        layout.setPadding(new Insets(10,10,10,10));

        window.setScene(scene);
        window.showAndWait();

        return ISBM;
    }
}
