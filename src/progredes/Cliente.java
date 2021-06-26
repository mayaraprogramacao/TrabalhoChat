package progredes;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) throws IOException {
		Socket client = new Socket("127.0.0.1", 10000);
		System.out.println("Cliente conectado ao servidor");
		
		Scanner s = new Scanner(System.in);
		PrintStream out = new PrintStream(client.getOutputStream());
		
		while(s.hasNextLine()) {
			out.println(s.nextLine());
		}
		
		out.close();
		s.close();
		client.close();
		
	}
}