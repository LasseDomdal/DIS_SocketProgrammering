package opgave3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ThreadLæser extends Thread{
    Socket clientSocket;
    private int portNr;

    public ThreadLæser(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.portNr = clientSocket.getPort();
    }

    @Override
    public void run() {
        while (true) {
            try {
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String besked = inFromServer.readLine();
                    System.out.println("besked: " +  besked);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
