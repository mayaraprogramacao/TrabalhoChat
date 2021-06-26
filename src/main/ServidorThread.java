package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ServidorThread  implements Runnable{
	private int porta2;
	
	public void setPorta(int porta2) {
		this.porta2 = porta2;
	}

	public void run() {
		
		try {
			ServerSocket server2 = new ServerSocket(porta2);
			System.out.println("Porta 9000 aberta, aguardando conexão com o cliente");
			
			Socket client1 = server2.accept();
			System.out.println("Conexão com o cliente "+client1.getInetAddress().getHostAddress());
			
			Scanner s2 = new Scanner(client1.getInputStream());
			while(s2.hasNextLine()) {
				System.out.println(s2.nextLine());
			}
			
			s2.close();
			client1.close();
			server2.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}