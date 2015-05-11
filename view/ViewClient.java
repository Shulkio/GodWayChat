/*     */ package view;
/*     */ 
/*     */ import controller.ControllerClient;
/*     */ import java.io.PrintStream;
/*     */ import javafx.collections.ObservableList;
/*     */ import javafx.event.ActionEvent;
/*     */ import javafx.event.EventHandler;
/*     */ import javafx.scene.Group;
/*     */ import javafx.scene.Scene;
/*     */ import javafx.scene.control.Button;
/*     */ import javafx.scene.control.TextArea;
/*     */ import javafx.scene.control.TextField;
/*     */ import javafx.scene.input.KeyEvent;
/*     */ import javafx.scene.text.FontWeight;
/*     */ import javafx.scene.text.Text;
/*     */ import javafx.stage.Stage;
/*     */ import javafx.stage.WindowEvent;
/*     */ 
/*     */ public class ViewClient extends javafx.application.Application
/*     */ {
/*     */   private ControllerClient controllerClient;
/*     */   private TextArea textArea;
/*     */   
/*     */   public ViewClient()
/*     */   {
/*  26 */     this.textArea = new TextArea("Console effective");
/*  27 */     this.controllerClient = new ControllerClient(this.textArea);
/*     */   }
/*     */   
/*     */   public void start(Stage primaryStage)
/*     */   {
/*  32 */     primaryStage.setTitle("GodGivenChat");
/*  33 */     primaryStage.setResizable(false);
/*  34 */     Group root = new Group();
/*  35 */     Scene scene = new Scene(root, 500.0D, 300.0D);
/*     */     
/*     */ 
/*  38 */     primaryStage.setOnCloseRequest(new EventHandler() {
/*     */       public void handle(WindowEvent we) {
/*  40 */         System.out.println("Fermeture du client. Bye bye!");
/*  41 */         System.exit(0);
/*     */       }
/*     */       
/*     */ 
/*  45 */     });
/*  46 */     Text title = new Text("Client : Anonyme");
/*  47 */     title.setX(60.0D);
/*  48 */     title.setY(20.0D);
/*  49 */     title.setFont(javafx.scene.text.Font.font("Verdana", FontWeight.BOLD, 12.0D));
/*     */     
/*     */ 
/*  52 */     final TextField textField = new TextField();
/*  53 */     textField.setLayoutX(60.0D);
/*  54 */     textField.setLayoutY(275.0D);
/*  55 */     textField.setPrefWidth(330.0D);
/*     */     
/*     */ 
/*  58 */     this.textArea.setPrefSize(400.0D, 235.0D);
/*  59 */     this.textArea.setWrapText(true);
/*  60 */     this.textArea.setLayoutX(60.0D);
/*  61 */     this.textArea.setLayoutY(30.0D);
/*  62 */     this.textArea.setEditable(false);
/*     */     
/*     */ 
/*  65 */     Button btn = new Button();
/*  66 */     btn.setLayoutX(384.0D);
/*  67 */     btn.setLayoutY(4.0D);
/*  68 */     btn.setStyle("-fx-font-size: 8pt;");
/*  69 */     btn.setMinHeight(22.0D);
/*  70 */     btn.setPrefHeight(22.0D);
/*  71 */     btn.setMaxHeight(22.0D);
/*  72 */     btn.setText("Se déconnecter");
/*  73 */     btn.setOnAction(new EventHandler()
/*     */     {
/*     */       public void handle(ActionEvent event) {
/*  76 */         System.out.println("Fermeture du client. Bye bye!");
/*  77 */         System.exit(0);
/*     */       }
/*     */       
/*     */ 
/*  81 */     });
/*  82 */     Button btnChat = new Button();
/*  83 */     btnChat.setLayoutX(403.0D);
/*  84 */     btnChat.setLayoutY(275.0D);
/*  85 */     btnChat.setText("Envoyer");
/*  86 */     btnChat.setOnAction(new EventHandler()
/*     */     {
/*     */       public void handle(ActionEvent event) {
/*  89 */         ViewClient.this.controllerClient.envoyerMessage(textField.getText());
/*  90 */         textField.setText("");
/*     */       }
/*     */       
/*     */ 
/*  94 */     });
/*  95 */     textField.setOnKeyPressed(new EventHandler()
/*     */     {
/*     */       public void handle(KeyEvent t) {
/*  98 */         if (t.getCode().toString() == "ENTER") {
/*  99 */           ViewClient.this.controllerClient.envoyerMessage(textField.getText());
/* 100 */           textField.setText("");
/*     */         }
/*     */         
/*     */       }
/*     */       
/* 105 */     });
/* 106 */     root.getChildren().add(title);
/* 107 */     root.getChildren().add(this.textArea);
/* 108 */     root.getChildren().add(textField);
/* 109 */     root.getChildren().add(btn);
/* 110 */     root.getChildren().add(btnChat);
/* 111 */     primaryStage.setScene(scene);
/*     */     
/* 113 */     textField.requestFocus();
/*     */     
/* 115 */     primaryStage.show();
/*     */   }
/*     */   
/*     */   public TextArea getTextArea() {
/* 119 */     return this.textArea;
/*     */   }
/*     */ }


/* Location:              C:\Users\Lewis GodGiven\Desktop\GGChat EXTERNE.jar!\view\ViewClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */