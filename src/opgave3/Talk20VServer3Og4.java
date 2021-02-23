package opgave3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Talk20VServer3Og4 {

    public static void main(String[] args) throws IOException {
        String clientSentence;
        ServerSocket welcomeSocket = new ServerSocket(6789);
        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            System.out.println("Serveren er startet");

            ThreadLæser tl = new ThreadLæser(connectionSocket);
            tl.start();
            ThreadSkriver ts = new ThreadSkriver(connectionSocket);
            ts.start();

        }
    }

}
