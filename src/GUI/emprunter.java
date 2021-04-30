package GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class emprunter {
    static String cne;
    static String choix;
    public static String getCNE(){
        cne = null;
        Stage window = new Stage();
        Button ok = new Button("Ok");
        TextField cneT = new TextField();
        VBox layout = new VBox();
        HBox hl = new HBox();
        Label cnel = new Label("CNE : ");
        hl.getChildren().addAll(cnel,cneT);

        layout.getChildren().addAll(hl,ok);

        ok.setOnAction(e -> {
            cne = cneT.getText();
            if(cne.isEmpty()) cne = null;
            window.close();
        });
        Scene scene = new Scene(layout);
        layout.setPadding(new Insets(10,10,10,10));
        window.setScene(scene);
        window.showAndWait();
        return cne;
    }
    public static String getCIN(){
        cne = null;
        Stage window = new Stage();
        Button ok = new Button("Ok");
        TextField cneT = new TextField();
        VBox layout = new VBox();
        HBox hl = new HBox();
        Label cnel = new Label("CIN : ");
        hl.getChildren().addAll(cnel,cneT);

        layout.getChildren().addAll(hl,ok);

        ok.setOnAction(e -> {
            cne = cneT.getText();
            if(cne.isEmpty()) cne = null;
            window.close();
        });
        Scene scene = new Scene(layout);
        window.setScene(scene);
        layout.setPadding(new Insets(10,10,10,10));

        window.showAndWait();
        return cne;
    }
    public static String choix(){
        choix = null;
        Stage window = new Stage();
        Button ok = new Button("Ok");
        ComboBox<String> chose = new ComboBox<String>();
        chose.getItems().addAll("Etudiant","Professeur");
        VBox layout = new VBox();

        layout.getChildren().addAll(chose,ok);

        ok.setOnAction(e -> {
            choix = chose.getValue();
            if(choix.isEmpty()) choix = null;
            window.close();
        });
        layout.setPadding(new Insets(10,10,10,10));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        return choix;
    }
}
