package controllerClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import javafx.scene.control.TextArea;

public class ControllerClient
{
	BufferedReader in = null;
	PrintWriter out = null;

	ClientListener clientListener;
	private String name;

	public ControllerClient(TextArea textArea)
	{
		this.name = ("Anonyme" + (int)(Math.random() * 100.0D));


		try
		{
			Socket socket = new Socket("184.162.6.73", 1401);
			this.out = new PrintWriter(socket.getOutputStream(), 
					true);
			this.in = new BufferedReader(new java.io.InputStreamReader(
					socket.getInputStream()));
		} catch (java.net.UnknownHostException e) {
			System.out.println("Unknown host");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("No I/O");
			System.exit(1);
		}

		this.clientListener = new ClientListener(this.in, textArea);
		Thread t = new Thread(this.clientListener);
		t.start();
	}

	public void envoyerMessage(String text) {
		if (text != "") {
			this.out.println(this.name + " - " + text);
		}
	}

	public static boolean validIP(String ip) {
		try {
			if ((ip == null) || (ip.isEmpty())) {
				return false;
			}

			String[] parts = ip.split("\\.");
			if (parts.length != 4) {
				return false;
			}
			String[] arrayOfString1;
			int j = (arrayOfString1 = parts).length;
			for (int i = 0; i < j; i++) {
				String s = arrayOfString1[i];
				int k = Integer.parseInt(s);
				if ((k < 0) || (k > 255)) {
					return false;
				}
			}
			if (ip.endsWith(".")) {
				return false;
			}

			return true;
		} catch (NumberFormatException nfe) {}
		return false;
	}
}