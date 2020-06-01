import java.net.*;
import java.io.*;


public class SocketTesterClient {
	
	public static void main(String[] args) throws IOException {
		
		final int portNumber = 5801;
		
		/*try (
			    Socket socket = new Socket("localhost", portNumber);
				
			    PrintWriter out =
			        new PrintWriter(socket.getOutputStream(), true);
			    BufferedReader in =
			        new BufferedReader(new InputStreamReader(socket.getInputStream()));
			    BufferedReader stdIn =
			        new BufferedReader(new InputStreamReader(System.in));
				
			)*/
		
		
		FileInputStream test = new FileInputStream("/Users/jannie/socketdir/test.txt");
		
		BufferedReader br = new BufferedReader(new FileReader("/Users/jannie/socketdir/test.txt"));
		
		String socketdir = br.readLine();
		System.out.print(socketdir);
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/jannie/socketdir/test.txt"));
		
		bw.write("That's not true!", 0, 18);
		
		
		
		
		
		
		
		
		
	}
	
}
