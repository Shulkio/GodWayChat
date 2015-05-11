package controllerServer;

import java.io.PrintWriter;
import java.util.ArrayList;

public class ClientWorkerSender implements Runnable {
	
	private PrintWriter out;
	private ArrayList<String> msgEnAttente;
	
	//Constructor
	ClientWorkerSender(PrintWriter out, ArrayList<String> msgEnAttente ) {
		this.out = out;
		this.msgEnAttente = msgEnAttente;
	}
	
	public void run(){
		System.out.println("le sender démarre!");
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while ( !msgEnAttente.isEmpty() ) {
				System.out.println("Envoi de " + msgEnAttente.get(0) + " vers un client");
				out.println(msgEnAttente.get(0));
				msgEnAttente.remove(0);
			}
		}
	}
}