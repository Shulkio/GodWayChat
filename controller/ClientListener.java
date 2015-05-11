/*    */ package controller;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import javafx.scene.control.TextArea;
/*    */ 
/*    */ public class ClientListener implements Runnable
/*    */ {
/*    */   BufferedReader in;
/*    */   TextArea textArea;
/*    */   private boolean closingThread;
/*    */   
/*    */   public ClientListener(BufferedReader in, TextArea textArea)
/*    */   {
/* 15 */     this.in = in;
/* 16 */     this.closingThread = false;
/* 17 */     this.textArea = textArea;
/*    */   }
/*    */   
/*    */   public void run()
/*    */   {
/* 22 */     String line = "";
/* 23 */     System.out.println("Aight j'écoute!");
/* 24 */     while (!this.closingThread) {
/*    */       try {
/* 26 */         line = this.in.readLine();
/*    */       } catch (IOException e) {
/* 28 */         e.printStackTrace();
/* 29 */         line = "Probleme de lecture";
/*    */       }
/* 31 */       this.textArea.appendText("\n" + line);
/*    */     }
/*    */   }
/*    */   
/*    */   public void fermerThread() {
/* 36 */     this.closingThread = true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lewis GodGiven\Desktop\GGChat EXTERNE.jar!\controller\ClientListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */