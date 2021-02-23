package opgave4;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class DnsServer {
	
	public static void main(String[] args)throws Exception  {

		ServerSocket welcomeSocket = new ServerSocket(3000);
		Socket connectionSocket = welcomeSocket.accept();
		BufferedReader input = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		DataOutputStream output = new DataOutputStream(connectionSocket.getOutputStream());
		String navn = input.readLine();
		Map<String, String> navne = new HashMap<>();
		navne.put("Lasse", "10.150.90.3");
		navne.put("Daniel", "10.150.90.7");
		navne.put("Frederik", "10.150.90.9");
		navne.put("Casper", "10.150.90.2");
		output.writeBytes(navne.get(navn) + '\n' );
	}
}
