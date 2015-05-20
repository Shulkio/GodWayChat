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
        primaryStage.setTitle("GodWay Chat");
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
        Text title = new Text("Bienvenue dans le GodWay Chat!");
        title.setX(80);
        title.setY(40);
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        
        // descrption sous le titre
        Text titleDesc = new Text("Choisissez si vous voulez demarrer un serveur ou un client");
        titleDesc.setX(45);
        titleDesc.setY(60);
        titleDesc.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
        
        // Description serveur
        Text servDesc = new Text("Configurer un serveur");
        servDesc.setX(285);
        servDesc.setY(240);
        servDesc.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
        
        // Description client
        Text servClient = new Text("Ouvrir un client");
        servClient.setX(80);
        servClient.setY(240);
        servClient.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
                
        // bouton CLIENT
        Button btnClient = new Button();
        btnClient.setText("Client");
        
        btnClient.setLayoutX(70);
        btnClient.setLayoutY(100);
        
        btnClient.setStyle("-fx-font-size: 16pt;");
        
        btnClient.setMinHeight(120.0);
        btnClient.setPrefHeight(120.0);
        btnClient.setMaxHeight(120.0);
        
        btnClient.setMinWidth(140.0);
        btnClient.setPrefWidth(140.0);
        btnClient.setMaxWidth(140.0);
        
        btnClient.setOnAction(new EventHandler<ActionEvent>() {
        	// action du bouton
        	public void handle(ActionEvent event) {
        	// TODO fermeture de tous les threads
                System.exit(0);
            }
        });
        
        // bouton SERVEUR
        Button btnServer = new Button();
        btnServer.setText("Serveur");
        
        btnServer.setLayoutX(290);
        btnServer.setLayoutY(100);
        
        btnServer.setStyle("-fx-font-size: 16pt;");
        
        btnServer.setMinHeight(120.0);
        btnServer.setPrefHeight(120.0);
        btnServer.setMaxHeight(120.0);
        
        btnServer.setMinWidth(140.0);
        btnServer.setPrefWidth(140.0);
        btnServer.setMaxWidth(140.0);
        
        btnServer.setOnAction(new EventHandler<ActionEvent>() {
        	// action du bouton
        	public void handle(ActionEvent event) {
        	// TODO fermeture de tous les threads
                System.exit(0);
            }
        });
        
        // ajout de tous les items a la scene
        root.getChildren().add(title);
        root.getChildren().add(titleDesc);
        root.getChildren().add(servDesc);
        root.getChildren().add(servClient);
        root.getChildren().add(btnClient);
        root.getChildren().add(btnServer);
        primaryStage.setScene(scene);
       
        primaryStage.show();
    }
}
