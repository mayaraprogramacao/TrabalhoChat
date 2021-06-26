package main;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteThread implements Runnable{
	private String endereco1;
	private int porta1;
	
	public void setEndereco(String endereco1) {
		this.endereco1 = endereco1;
	}
	
	public void setPorta(int porta1) {
		this.porta1 = porta1;
	}

	public void run() {
	
		try {
			Socket client1 = new Socket(endereco1,porta1);
			System.out.println("Cliente conectado ao servidor");
			
			Scanner s1 = new Scanner(System.in);
			PrintStream out1 = new PrintStream(client1.getOutputStream());
			
			while(s1.hasNextLine()) {
				out1.println(s1.nextLine());
			}
			
			out1.close();
			s1.close();
			client1.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}