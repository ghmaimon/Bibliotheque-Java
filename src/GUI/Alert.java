package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Alert {
    public static void display(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        window.setMinHeight(200);

        Label label = new Label(message);
        Button close = new Button("click to close");
        close.setOnAction(e -> window.close());
        VBox vb = new VBox();
        vb.getChildren().addAll(label,close);
        vb.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vb);
        window.setScene(scene);

        window.showAndWait();

    }
}
