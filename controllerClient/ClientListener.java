package controllerClient;

import java.io.BufferedReader;
import java.io.IOException;
import javafx.scene.control.TextArea;

public class ClientListener implements Runnable
{
	BufferedReader in;
	TextArea textArea;
	private boolean closingThread;

	public ClientListener(BufferedReader in, TextArea textArea)
	{
		this.in = in;
		this.closingThread = false;
		this.textArea = textArea;
	}

	public void run()
	{
		String line = "";
		System.out.println("Aight j'écoute!");
		while (!this.closingThread) {
			try {
				line = this.in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				line = "Probleme de lecture";
			}
			this.textArea.appendText("\n" + line);
		}
	}

	public void fermerThread() {
		this.closingThread = true;
	}
}