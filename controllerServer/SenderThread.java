package controllerServer;

import java.util.ArrayList;

public class SenderThread implements Runnable {

	private ArrayList<String> msgThreadsClients;
	private ArrayList<ClientWorker> clients;
	
	private boolean stopThread;
	
	public SenderThread ( ArrayList<ClientWorker> clients ) {
		msgThreadsClients = new ArrayList<String>();
		this.clients = clients;
		stopThread = false;
	}
	
	@Override
	public void run() {
		String msg;
		while ( !stopThread ) {
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			while ( !msgThreadsClients.isEmpty() ) {
				msg = msgThreadsClients.get(0);
				for ( ClientWorker c : clients ) {
					c.envoyerMessage(msg);
				}
				msgThreadsClients.remove(0);
			}
		}
	}
	
	public void ajouterMsg ( String msg ) {
		msgThreadsClients.add(msg);
	}
	
	public void closeServerThread () {
		stopThread = true;
	}

}