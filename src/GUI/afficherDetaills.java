package GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import typedocs.*;
import typeperson.Etudiant;
import typeperson.Professeur;

public class afficherDetaills {

    static Label details;
    static Button fermerButton;
    static VBox layout;
    static Stage window;
    static Scene scene;
    public static void display(DocumentCard doc){

        window = new Stage();
        window.setTitle(doc.document.get_titre());
        window.setWidth(360);
        window.setHeight(450);
        window.setResizable(false);
        String to_show = "";

        if(doc.document.get_type().equals("Bande Dessinée")){
            to_show = ((BandeDessinee)doc.document).toString();
        }
        if(doc.document.get_type().equals("Dictionnaire")){
            to_show = ((Dictionaire)doc.document).toString();
        }
        if(doc.document.get_type().equals("Magazine")){
            to_show = ((Magazine)doc.document).toString();
        }
        if(doc.document.get_type().equals("Livrer")){
            to_show = ((Livre)doc.document).toString();
        }
        
        to_show +="\n" +  doc.typestr;
        to_show +="\n"+  doc.emprunteestr;

        details = new Label(to_show);
        details.getStyleClass().add("details");
        layout = new VBox();
        fermerButton = new Button("\t Fermer");
        fermerButton.setOnAction(e  -> window.close());
        fermerButton.getStyleClass().add("btn");

        layout.getChildren().addAll(details,fermerButton);
        layout.setPadding(new Insets(10,10,10,10));
        layout.setSpacing(10);
        
        scene = new Scene(layout);
        scene.setUserAgentStylesheet("GUI/Stylesheets/subs.css");
        window.setScene(scene);
        window.show();
    }
    public static void display(PersonCard person){

        window = new Stage();
        window.setTitle(person.person.get_prenom() + " " + person.person.get_nom());
        window.setWidth(360);
        window.setHeight(450);
        window.setResizable(false);
        String to_show="";
        if(person.person.get_type().equals("etudiant")){
            to_show = ((Etudiant)person.person).toString(); 
        }
        if(person.person.get_type().equals("professeur")){
            to_show = ((Professeur)person.person).toString(); 
        }

        to_show +="\n" +  person.typestr;
        to_show +="\n"+  person.emprunteestr;

        details = new Label(to_show);
        details.getStyleClass().add("details");
        layout = new VBox();
        fermerButton = new Button("\t Fermer");
        fermerButton.setOnAction(e  -> window.close());
        fermerButton.getStyleClass().add("btn");

        layout.getChildren().addAll(details,fermerButton);
        layout.setPadding(new Insets(10,10,10,10));
        layout.setSpacing(10);
        
        scene = new Scene(layout);
        scene.setUserAgentStylesheet("GUI/Stylesheets/subs.css");
        window.setScene(scene);
        window.show();
    }
}
