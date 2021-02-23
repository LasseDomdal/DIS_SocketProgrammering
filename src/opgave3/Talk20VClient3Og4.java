package opgave3;

import java.io.IOException;
import java.net.Socket;

public class Talk20VClient3Og4 {

    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket("10.150.90.2", 6789);

                ThreadLæser tl = new ThreadLæser(clientSocket);
                tl.start();
                ThreadSkriver ts = new ThreadSkriver(clientSocket);
                ts.start();

    }
}

