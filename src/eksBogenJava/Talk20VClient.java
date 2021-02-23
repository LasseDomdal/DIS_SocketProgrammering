package eksBogenJava;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Talk20VClient {

    public static void main(String[] args) throws IOException {

        String sendeBesked;
        String modtageBesked;
        boolean forbindelseEtableret = false;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("10.150.90.2", 6789);
        while (true) {
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            if (!forbindelseEtableret) {
                System.out.println("indtast hej besked ");
                sendeBesked = inFromUser.readLine();
                outToServer.writeBytes(sendeBesked + '\n');
                modtageBesked = inFromServer.readLine();
                if (modtageBesked.equals("ja")) {
                    forbindelseEtableret = true;
                    System.out.println("Forbindelse er etableret");
                } else {
                    clientSocket.close();
                }
            } else {
                System.out.println("Indtast besked: ");
                sendeBesked = inFromUser.readLine();
                outToServer.writeBytes(sendeBesked + '\n');
                modtageBesked = inFromServer.readLine();
                if (modtageBesked.equals("exit")) {
                    clientSocket.close();
                } else {
                    System.out.println("Besked fra modparten: " + modtageBesked);
                }
            }
        }
    }
}

