package opgave4;
import java.io.*;
import java.net.*;

public class Talk20VClient {

	public static void main(String[] args) throws Exception, IOException {
			Socket dnsSocket = new Socket("localhost", 3000);
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader input = new BufferedReader(new InputStreamReader(dnsSocket.getInputStream()));
			DataOutputStream output = new DataOutputStream(dnsSocket.getOutputStream());
			String request = inFromUser.readLine();
			output.writeBytes(request + '\n' );
			String ipAdresse = input.readLine();
			
//			Socket clientSocket = new Socket(ipAdresse, 6789);
//			System.out.println("Client Online");
//			
//			InputThread it = new InputThread(clientSocket);
//			OutputThread ot = new OutputThread(clientSocket);
//			it.start();
//			ot.start();
			System.out.println(ipAdresse + "");
	}		
}
		

