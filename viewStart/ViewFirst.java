package viewStart;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ViewFirst extends Application {
	
	public ViewFirst() {
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
        Text title = new Text("Coucou PD");
        title.setX(60);
        title.setY(20);
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        
        // bouton fermer serv
        Button btnServer = new Button();
        /*btnServer.setLayoutX(384);
        btnServer.setLayoutY(4);
        btnServer.setStyle("-fx-font-size: 8pt;");
        btnServer.setMinHeight(22.0);
        btnServer.setPrefHeight(22.0);
        btnServer.setMaxHeight(22.0); */
        btnServer.setText("Serveur");
        btnServer.setOnAction(new EventHandler<ActionEvent>() {
        // action du bouton
        public void handle(ActionEvent event) {
                System.out.println("Fermeture du serveur. Bye bye!");
                System.exit(0);
            }
        });
        
        // bouton chat
        Button btnClient = new Button();
        /*btnClient.setLayoutX(403);
        btnClient.setLayoutY(275);*/
        btnClient.setText("Client");
        btnClient.setOnAction(new EventHandler<ActionEvent>() {
        // action du bouton
        public void handle(ActionEvent event) {

            }
        });
        
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(0, 20, 10, 20));
        vBox.getChildren().addAll(btnClient, btnServer);
        
        // ajout de tous les items à la scene
        root.getChildren().add(title);
        root.getChildren().add(vBox);
        primaryStage.setScene(scene);
       
        primaryStage.show();
    }
}