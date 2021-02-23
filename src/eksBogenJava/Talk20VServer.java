package eksBogenJava;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Talk20VServer {

    public static void main(String[] args) throws IOException {
        String clientSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        ServerSocket welcomeSocket = new ServerSocket(6789);
        while (true) {
            System.out.println("Serveren er startet");
            Socket connectionSocket = welcomeSocket.accept();
            while (true) {
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                clientSentence = inFromClient.readLine();
                System.out.println("Besked fra modpart: " + clientSentence);
                System.out.println("Indtast svar");
                String reply = inFromUser.readLine();
                outToClient.writeBytes(reply + '\n');
            }
        }
    }

}
