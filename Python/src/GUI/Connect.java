package GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connect {
	static Thread sent;
	static Thread receive;
	static Socket socket;

	public static boolean main(String args) {

		try {
			socket = new Socket("localhost", 8888);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			// while(true){

			out.print(args + "\r\n");
			out.flush();

			BufferedReader stdIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String in = stdIn.readLine();
			System.out.println(in);// }
			return in == "1";

		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	
}