package opgave4;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class OutputThread extends Thread {
	
	Socket service;
	
    OutputThread(Socket service) {
        this.service = service;
    }

    public void run() {
    try {
        while (true) {
        	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        	DataOutputStream output = new DataOutputStream(service.getOutputStream());
        	String reply = inFromUser.readLine();
        	output.writeBytes(reply + '\n' );
        }
    } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
