package co.edu.unbosque.controller;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class Client extends Thread{
	
	private Socket socket;
	private ServerSocket server;
	private DataOutputStream out;
	private DataInputStream in;
	private String address;
	private int port;
	
	private Controller c;	
	public Client(String address,int port) {
		super();
		this.socket = null;
		this.server = null;
		this.out = null;
		this.in = null;
		this.address = address;
		this.port = port;
		this.c = new Controller();
	}
	String line="";
	
	@Override
	public void run() {
		try {
			this.socket = new Socket(this.address, this.port);
			JOptionPane.showMessageDialog(null, "Connected");
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(c.notifMessage()==true) {
			line = c.requestToServer();
		}
		while(!line.equals("Over")) {
			try {
				waitingForOrder(line);
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Connection refused");
			}
		}
		try {
			out.close();
			socket.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public void waitingForOrder(String line) {
		boolean stop = false;
		while (!stop) {
			try {
				switch (Integer.parseInt(line)){
				case 1: {
					String line2 = c.requestListOne();
					String txin="";
					while(!line2.equals("over")) {
						try {
							this.out = new DataOutputStream(socket.getOutputStream());
							
							this.out.writeUTF("("+line+")"+" "+line2);
							this.out.close();
							this.socket.close();
							
							this.server = new ServerSocket(this.port+1);
							this.socket = server.accept();
							this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
							txin = in.readUTF();
							c.receiveInfoOfOne(txin);
							this.in.close();
							this.server.close();
						}catch (Exception e) {
							// TODO: handle exception
						}
					}
					break;
				}case 2: {
					String txin = "";
					while(!line.equals("over")) {
						try {
							this.out = new DataOutputStream(socket.getOutputStream());
							
							this.out.writeUTF("("+line+")");
							this.out.close();
							this.socket.close();
							
							this.server = new ServerSocket(this.port+1);
							this.socket = server.accept();
							this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
							txin = in.readUTF();
							c.receiveInfoOfAll(txin);
							this.in.close();
							this.server.close();
						}catch (Exception e) {
							// TODO: handle exception
						}
					}
					break;
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
