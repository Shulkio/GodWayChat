package controllerServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javafx.scene.control.TextArea;

public class ClientWorker implements Runnable {
	private Socket client;
	private TextArea textArea;
	
	private ArrayList<String> msgEnAttente;
	private SenderThread senderThread;
	
	private BufferedReader in;
	private PrintWriter out;
	
	private ClientWorkerSender clientWorkerSender;
	
	//Constructor
	ClientWorker(Socket client, TextArea textArea, SenderThread senderThread) {
		in = null;
		out = null;
		this.client = client;
		this.textArea = textArea;
		msgEnAttente = new ArrayList<String>();
		this.senderThread = senderThread;
	}
	
	public void envoyerMessage(String s) {
		msgEnAttente.add(s);
	}
	
	public void run(){
		String line;
		try{
			in = new BufferedReader(new 
					InputStreamReader(client.getInputStream()));
			out = new 
					PrintWriter(client.getOutputStream(), true);
    		clientWorkerSender = new ClientWorkerSender(out, msgEnAttente);
    		Thread t = new Thread(clientWorkerSender);
    		t.start();
		} catch (IOException e) {
			System.out.println("in or out failed");
			System.exit(-1);
		}

		while(true){
			try{

				// attente d'un message
				line = in.readLine();
				if ( line != null ) {
					textArea.appendText("\n" + line);
					senderThread.ajouterMsg(line);
				}				
			}catch (IOException e) {
				//System.out.println("Read failed");
				//System.exit(-1);
				
				// si on reçoit rien, on continue...
			}
		}
	}
}