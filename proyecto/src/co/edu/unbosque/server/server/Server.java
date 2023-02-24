package co.edu.unbosque.server.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
	
	private Socket socketM;// for send info to contestants
	private ServerSocket server;
	private DataInputStream in;
	private DataOutputStream out;
	private int port;
	private String addressClient;
	
	public Server(int port) {
		super();
		this.socketM = null;
		this.server = null;
		this.in = null;
		this.out = null;
		this.port = port;
		this.addressClient = addressClient;
	}
	
	@Override
	public void run() {
		String line = "";
		while(!line.equals("Over")) {
			try {
				this.server = new ServerSocket(this.port);
				System.out.println("yes1");
				this.socketM = server.accept();
				System.out.println("yes2");
				this.in = new DataInputStream(new BufferedInputStream(socketM.getInputStream()));
				
				line = in.readUTF();
//				print in server info
//				System.out.println(line);
				
//				send message to contestant
//				create a socket to send message
				this.socketM = new Socket(this.socketM.getInetAddress(),this.port+1);
//				sends output to the socket contestant
				this.out = new DataOutputStream(socketM.getOutputStream());
				this.out.writeUTF("Sent");
				this.out.close();
				this.socketM.close();
				
				this.in.close();
				this.server.close();
			}catch (Exception i) {
				System.out.println(i);
			}
			
//			close connection
			try {
				socketM.close();
				in.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
