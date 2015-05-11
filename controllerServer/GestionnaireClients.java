package controllerServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

import javafx.scene.control.TextArea;

public class GestionnaireClients implements Runnable {
	
    private ServerSocket serverSocket;
    private TextArea textArea;
    
    private ArrayList<ClientWorker> clients;
    private SenderThread senderThread;
    
    public GestionnaireClients(TextArea textArea){
    	this.textArea = textArea;
    	clients = new ArrayList<ClientWorker>();
    	senderThread = new SenderThread(clients);
		Thread sender = new Thread(senderThread);
		sender.start();
    }

    public void run() {

    	try {

    		serverSocket = new ServerSocket(1401);

    		while(true){

    			ClientWorker w;
    			try{
    				//server.accept returns a client connection
    				w = new ClientWorker(serverSocket.accept(), textArea, senderThread );
    				clients.add(w);
    				Thread t = new Thread(w);
    				t.start();
    			} catch (IOException e) {
    				System.out.println("Acceptation ratee: Port 1401");
    				System.exit(0);
    			}
    		}

    	} catch (IOException e) {
    		System.out.println("La socket n'a pu etre cree");
    		e.printStackTrace();
    		System.exit(0);
    	}
    }
    
    public void envoiGeneral ( String s ) {
    	senderThread.ajouterMsg(s);
    }
}