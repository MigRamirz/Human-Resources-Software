package co.edu.unbosque.controller;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.ContestantDAOImplements;

public class Server extends Thread{
	
	private Socket socket;
	private Socket socketR;
	private ServerSocket server;
	private DataInputStream in;
	private DataOutputStream out;
	private int port;
	private String addressClient;
	
	private ContestantDAOImplements cdao;
	
	public Server(int port) {
		super();
		this.socket = null;
		this.socketR = null;
		this.server = null;
		this.in = null;
		this.out = null;
		this.port = port;
		this.addressClient = addressClient;
	}
	String line = "";
	@Override
	public void run() {
		while(!line.equals("Over")) {
			try {
				this.server = new ServerSocket(this.port);
				JOptionPane.showMessageDialog(null, "Server Started");
				JOptionPane.showMessageDialog(null, "Waiting for a client");
				this.socket = server.accept();
				JOptionPane.showMessageDialog(null, "Client accepted");
				
				this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				line = in.readUTF();
				if(line.contains("(1)")) {
					String nline = line.replace("(1)", "1");
					waitingForOrder(nline);
				}if(line.contains("(2)")) {
					String nline = line.replace("(2)", "2");
					waitingForOrder(nline);
				}
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Address already in use: bind");
				break;
			}
		}
		JOptionPane.showMessageDialog(null, "Closing connection");
		try {
			socket.close();
			in.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void waitingForOrder(String pLine) {
		boolean stop = false;
		while(!stop) {
			try {
				switch (Integer.parseInt(pLine)){
				case 1: {
				try {
					while(!line.equals("Over")) {
						
							this.socketR=new Socket(this.socket.getInetAddress(), this.port+1);
							this.out.writeUTF(cdao.listOneContestant(line));
							this.out.close();
			                this.socketR.close();
			                
			                this.in.close();
			                this.server.close();
					}		
				}catch (Exception e) {
					// TODO: handle exception
				}			
					break;
				}case 2: {
					try {
						while(!line.equals("Over")) {
							
								this.socketR=new Socket(this.socket.getInetAddress(), this.port+1);
								this.out.writeUTF(cdao.listContestant());
								this.out.close();
				                this.socketR.close();
				                
				                this.in.close();
				                this.server.close();
						}		
					}catch (Exception e) {
						// TODO: handle exception
					}
				}	
				default:
					System.out.println("ERROR");
					break;
				}
			}catch (NumberFormatException | InputMismatchException e) {
				// TODO: handle exception
			}
		}
	}
}
