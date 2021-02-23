package opgave4;
import talk20V2.copy.InputThread;
import talk20V2.copy.OutputThread;

import java.net.*;

public class Talk20VServer {

	public static void main(String[] args)throws Exception  {

		ServerSocket welcomeSocket = new ServerSocket(6789);
		System.out.println("Server Online");
//		while (true) {
//			Socket connectionSocket = welcomeSocket.accept();
//			InputThread it = new InputThread(connectionSocket);
//			OutputThread ot = new OutputThread(connectionSocket);
//			it.start();
//			ot.start();
//		}
	}
}
