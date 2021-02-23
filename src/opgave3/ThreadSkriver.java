package opgave3;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ThreadSkriver extends Thread {
    Socket clientSocket;
    private int portNr;

    public ThreadSkriver(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.portNr = clientSocket.getPort();
    }

    @Override
    public void run() {
        while (true) {
            try {
                BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
                DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream()) ;
                String besked = inFromUser.readLine();
                outToClient.writeBytes(besked + '\n' );
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
