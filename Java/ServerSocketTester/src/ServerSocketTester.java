import java.net.*;
import java.io.*;

public class ServerSocketTester {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		final int portNumber = 5801;
		System.out.println("Creating server socket on port " + portNumber);
		ServerSocket serverSocket = new ServerSocket(portNumber);
		
		while (true){
			
			Socket socket = serverSocket.accept();
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);
			pw.println("What's your name?");

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String name = br.readLine();

			pw.println("Hello, " + name);
			//pw.close();
			//socket.close();

			System.out.println("Just said hello to: " + name);
		}
		

	}
	
	

}
