package opgave4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class InputThread extends Thread {
	
    Socket service;
    
    InputThread(Socket service) {
        this.service = service;
    }

    public void run() {
    try {
        while (true) {
        	BufferedReader input = new BufferedReader(new InputStreamReader(service.getInputStream()));
        	String sentence = input.readLine();
        	
        	System.out.println("says: " + sentence);
        }
    } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
