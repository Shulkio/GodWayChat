package viewServer;

import controllerServer.ControllerServeur;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ViewServeur extends Application {
	
	public ViewServeur() {
	}
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Démarrage de GodWay Chat");
        primaryStage.setResizable(false);
        Group root = new Group();
        Scene scene = new Scene(root, 500, 300);
        
        //fermeture
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                System.exit(0);
            }
        });        
        
        // titre
        Text title = new Text("Serveur : " + controllerServeur.getPublicIP() );
        title.setX(60);
        title.setY(20);
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        
        // bouton fermer serv
        Button btn = new Button();
        btn.setLayoutX(384);
        btn.setLayoutY(4);
        btn.setStyle("-fx-font-size: 8pt;");
        btn.setMinHeight(22.0);
        btn.setPrefHeight(22.0);
        btn.setMaxHeight(22.0);
        btn.setText("Stop Serveur");
        btn.setOnAction(new EventHandler<ActionEvent>() {
        // action du bouton
        public void handle(ActionEvent event) {
                System.out.println("Fermeture du serveur. Bye bye!");
                System.exit(0);
            }
        });
        
        // bouton chat
        Button btnChat = new Button();
        btnChat.setLayoutX(403);
        btnChat.setLayoutY(275);
        btnChat.setText("Envoyer");
        btnChat.setOnAction(new EventHandler<ActionEvent>() {
        // action du bouton
        public void handle(ActionEvent event) {
                String returned = controllerServeur.envoyerMessage( textField.getText());
                textField.setText("");
                textArea.setText(textArea.getText() + "\n" + returned);
            }
        });
        
        // action quand touche entrée
        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if ( t.getCode().toString() == "ENTER" ) {
                    String returned = controllerServeur.envoyerMessage( textField.getText());
                    textField.setText("");
                    textArea.appendText("\n" + returned);
                }
            }
        });
        
        // ajout de tous les items à la scene
        root.getChildren().add(title);
        root.getChildren().add(textArea);
        root.getChildren().add(textField);
        root.getChildren().add(btn);
        root.getChildren().add(btnChat);
        primaryStage.setScene(scene);
        
        textField.requestFocus();
       
        primaryStage.show();
    }
    
    public TextArea getTextArea() {
    	return textArea;
    }
}