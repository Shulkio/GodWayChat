package viewClient;

import controllerClient.ControllerClient;

import java.io.PrintStream;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ViewClient extends javafx.application.Application
{
	private ControllerClient controllerClient;
	private TextArea textArea;

	public ViewClient()
	{
		this.textArea = new TextArea("Console effective");
		this.controllerClient = new ControllerClient(this.textArea);
	}

	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("GodGivenChat");
		primaryStage.setResizable(false);
		Group root = new Group();
		Scene scene = new Scene(root, 500.0D, 300.0D);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				System.out.println("Fermeture du client. Bye bye!");
				System.exit(0);
			}
		});

		Text title = new Text("Client : Anonyme");
		title.setX(60.0D);
		title.setY(20.0D);
		title.setFont(javafx.scene.text.Font.font("Verdana", FontWeight.BOLD, 12.0D));


		final TextField textField = new TextField();
		textField.setLayoutX(60.0D);
		textField.setLayoutY(275.0D);
		textField.setPrefWidth(330.0D);


		this.textArea.setPrefSize(400.0D, 235.0D);
		this.textArea.setWrapText(true);
		this.textArea.setLayoutX(60.0D);
		this.textArea.setLayoutY(30.0D);
		this.textArea.setEditable(false);


		Button btn = new Button();
		btn.setLayoutX(384.0D);
		btn.setLayoutY(4.0D);
		btn.setStyle("-fx-font-size: 8pt;");
		btn.setMinHeight(22.0D);
		btn.setPrefHeight(22.0D);
		btn.setMaxHeight(22.0D);
		btn.setText("Se déconnecter");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("Fermeture du client. Bye bye!");
				System.exit(0);
			}
		});
		
		Button btnChat = new Button();
		btnChat.setLayoutX(403.0D);
		btnChat.setLayoutY(275.0D);
		btnChat.setText("Envoyer");
		btnChat.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				ViewClient.this.controllerClient.envoyerMessage(textField.getText());
				textField.setText("");
			}
		});
		
		textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent t) {
				if (t.getCode().toString() == "ENTER") {
					ViewClient.this.controllerClient.envoyerMessage(textField.getText());
					textField.setText("");
				}
			}
		});
		
		root.getChildren().add(title);
		root.getChildren().add(this.textArea);
		root.getChildren().add(textField);
		root.getChildren().add(btn);
		root.getChildren().add(btnChat);
		primaryStage.setScene(scene);

		textField.requestFocus();

		primaryStage.show();
	}

	public TextArea getTextArea() {
		return this.textArea;
	}
}