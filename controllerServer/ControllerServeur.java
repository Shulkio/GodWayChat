package controllerServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.scene.control.TextArea;

public class ControllerServeur {

	String historyChat;
	GestionnaireClients gestionnaireClients;
	
	public ControllerServeur ( TextArea textArea ) {
		gestionnaireClients = new GestionnaireClients(textArea);
		Thread t = new Thread(gestionnaireClients);
        t.start();
	}
	
	public String getPublicIP() {
		URL whatismyip;
		String ip = "";
		try {
			whatismyip = new URL("http://checkip.amazonaws.com");
			BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
			ip = in.readLine();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ip;
	}

	public String envoyerMessage(String s) {

		if ( s == "/stop" )
			System.exit(0);
		else if ( s == "/bonjour")
			return "Euh... bonjour?";
		else if ( s == "/help" ) {
			return "/stop : fermeture serveur\n" +
					"/bonjour : ?\n" + 
					"/help : affichage des commandes existantes";
		}
		else if ( s.startsWith("/say ")) {
			s = s.substring(5);
			gestionnaireClients.envoiGeneral(s);
			return "Envoi général : " + s;
		}
		
		return "Commande inconnue. /help pour les commandes existantes";
	}
}

