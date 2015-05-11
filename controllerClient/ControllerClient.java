/*    */ package controller;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.io.PrintWriter;
/*    */ import java.net.Socket;
/*    */ import javafx.scene.control.TextArea;
/*    */ 
/*    */ public class ControllerClient
/*    */ {
/* 12 */   BufferedReader in = null;
/* 13 */   PrintWriter out = null;
/*    */   
/*    */   ClientListener clientListener;
/*    */   private String name;
/*    */   
/*    */   public ControllerClient(TextArea textArea)
/*    */   {
/* 20 */     this.name = ("Anonyme" + (int)(Math.random() * 100.0D));
/*    */     
/*    */ 
/*    */     try
/*    */     {
/* 25 */       Socket socket = new Socket("184.162.6.73", 1401);
/* 26 */       this.out = new PrintWriter(socket.getOutputStream(), 
/* 27 */         true);
/* 28 */       this.in = new BufferedReader(new java.io.InputStreamReader(
/* 29 */         socket.getInputStream()));
/*    */     } catch (java.net.UnknownHostException e) {
/* 31 */       System.out.println("Unknown host");
/* 32 */       System.exit(1);
/*    */     } catch (IOException e) {
/* 34 */       System.out.println("No I/O");
/* 35 */       System.exit(1);
/*    */     }
/*    */     
/* 38 */     this.clientListener = new ClientListener(this.in, textArea);
/* 39 */     Thread t = new Thread(this.clientListener);
/* 40 */     t.start();
/*    */   }
/*    */   
/*    */   public void envoyerMessage(String text) {
/* 44 */     if (text != "") {
/* 45 */       this.out.println(this.name + " - " + text);
/*    */     }
/*    */   }
/*    */   
/*    */   public static boolean validIP(String ip) {
/*    */     try {
/* 51 */       if ((ip == null) || (ip.isEmpty())) {
/* 52 */         return false;
/*    */       }
/*    */       
/* 55 */       String[] parts = ip.split("\\.");
/* 56 */       if (parts.length != 4) {
/* 57 */         return false;
/*    */       }
/*    */       String[] arrayOfString1;
/* 60 */       int j = (arrayOfString1 = parts).length; for (int i = 0; i < j; i++) { String s = arrayOfString1[i];
/* 61 */         int i = Integer.parseInt(s);
/* 62 */         if ((i < 0) || (i > 255)) {
/* 63 */           return false;
/*    */         }
/*    */       }
/* 66 */       if (ip.endsWith(".")) {
/* 67 */         return false;
/*    */       }
/*    */       
/* 70 */       return true;
/*    */     } catch (NumberFormatException nfe) {}
/* 72 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lewis GodGiven\Desktop\GGChat EXTERNE.jar!\controller\ControllerClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */