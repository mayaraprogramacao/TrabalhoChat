package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChatCliente extends JFrame {

	private JPanel contentPane;
	private JLabel lblEntrada;
	private JTextField textEntrada;
	private JLabel lblSaida;
	private JTextArea textSaida;
	private JButton btnEnviar;
	
	Socket client;
	Scanner s;
	PrintStream out;

	public ChatCliente() throws Exception {
		Handler ouvinte = new Handler();
		setTitle("CHAT CLIENTE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblEntrada = new JLabel("entrada");
		lblEntrada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEntrada.setBounds(23, 199, 70, 52);
		contentPane.add(lblEntrada);
		
		textEntrada = new JTextField();
		textEntrada.setBounds(20, 241, 304, 36);
		contentPane.add(textEntrada);
		
		lblSaida = new JLabel("saida");
		lblSaida.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSaida.setBounds(23, 11, 70, 22);
		contentPane.add(lblSaida);
		
		textSaida = new JTextArea();
		textSaida.setBounds(20, 37, 304, 177);
		contentPane.add(textSaida);
		
		btnEnviar = new JButton("ENVIAR");
		btnEnviar.setBounds(235, 288, 89, 23);
		btnEnviar.addActionListener(ouvinte);
		contentPane.add(btnEnviar);
		
		setVisible(true);
		configuraRede();
	}
	
	public void limpar() {
		textEntrada.setText("");
	}
	
	 public void configuraRede() throws Exception {
	 	client = new Socket("127.0.0.1",9000);
		System.out.println("Cliente conectado ao servidor");
		
		try {
			out.close();
			s.close();	
			client.close();
		}catch(NullPointerException e) {
			
		}
	 }
		
	public class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if(e.getSource()==btnEnviar) {
				String textE = textEntrada.getText();
				
				if(   (textE.equals(""))  ) {
					JOptionPane.showMessageDialog(getContentPane(), "Todos os campos devem ser preenchidos", "Atenção!",  1);
				} else {

					textSaida.append("Cliente: " + textE + "\n");	
					
					try {	
						s = new Scanner(textE);
						out = new PrintStream(client.getOutputStream());
									
						while(s.hasNextLine()) {
							out.println(s.nextLine());
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
					limpar();
				}

			}

		}
		
	}

}