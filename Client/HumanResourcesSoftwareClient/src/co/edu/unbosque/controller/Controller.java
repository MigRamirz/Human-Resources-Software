package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.unbosque.view.Frame;
import co.edu.unbosque.view.OptFrame;
import co.edu.unbosque.view.OptFrame2;
/**
 * Class that manage the program, allows classes interactions
 * @author MiguelRamírez
 *
 */
public class Controller implements ActionListener{
	/**
	 * Attribute declaration for display a GUI
	 */
	private Frame f;
	/**
	 * Attribute declaration for display an information frame which works on team with GUI
	 */
	private OptFrame optf;
	/**
	 * Attribute declaration for display an information frame which works on team with GUI
	 */
	private OptFrame2 optf2;
	
	/**
	 * Constructor method which allows start some attributes for a correct running
	 */
	public Controller() {
		f = new Frame();
		optf = new OptFrame();
		optf2 = new OptFrame2();
		f.setVisible(false);
		
		f.p1.getListb().addActionListener(this);
		
		optf.getYb().addActionListener(this);
		optf.getNb().addActionListener(this);
		
		optf2.getSubmit().addActionListener(this);
		
		f.p2.getBackb().addActionListener(this);
		
		
		f.p2_2.getBackb().addActionListener(this);
	}
	
	/**
	 * Method which allows show the GUI, and allows running the program
	 */
	public void run() {
		f.setVisible(true);
	}

	/**
	 * Method which allows all methods executions
	 */
	
	String id1;
	@Override
	public void actionPerformed(ActionEvent e) {
		int num;
		if(e.getActionCommand().equals("List")) {
				optf.setVisible(true);
		}
		if(e.getActionCommand().equals("Yes")) {
			optf.setVisible(false);
			f.p1.setVisible(false);
			f.p2_2.setVisible(true);
			optf2.setVisible(true);
		}
		if(e.getActionCommand().equals("Submit1")) {
			if(optf2.getTid().getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Field void");
			}else {
				if(optf2.getTid().getText().matches("[0-9]*")){
					num = 1;
					id1 = optf2.getTid().getText();
					selection(num);
				}else {
					JOptionPane.showMessageDialog(null, "Invalid characters");
					optf2.getTid().setText("");
				}
			}
		}
		if(e.getActionCommand().equals("No")) {
			optf.setVisible(false);
			f.p1.setVisible(false);
			f.p2.setVisible(true);
			num = 2;
			selection(num);
		}
		if(e.getActionCommand().equals("Back")) {
			f.p2_2.setVisible(false);
			f.p2.setVisible(false);
			f.p1.setVisible(true);
		}
	}
	public void selection(int pNum) {
		int num = pNum;
		boolean stop = false;
		while(!stop) {
			switch (num) {
			case 1: {
//				request info of one
				request(num);
				stop = true;
				break;
			}
			case 2: {
//				request info of all
				request(num);
				stop = true;
				break;
			}
			default:
				System.out.println("ERROR");
				break;
			}
		}
	}
	
//	for request 
	int num1 = 0;
	public void request(int pNum) {
		num1 = pNum;
	}
	boolean notif = false;
	public String requestToServer() {
		String rts = num1+"";
		if(rts == "1" || rts == "2") {
			notif = true;
		}
		return rts;
	}
	
	public boolean notifMessage() {
		return notif;
	}
//	for request list one
	public String requestListOne() {
		return id1;
	}

//	for receive info 1 and 2
	String infoofone = "";
	public String receiveInfoOfOne(String message) {
		infoofone = message;
		f.p2_2.getInfop().setText(receiveInfoOfOne(infoofone));
		optf2.setVisible(false);
		optf2.getTid().setText("");
		return infoofone;
	}
	public String receiveInfoOfAll(String pInfoall) {
		String infoall = pInfoall;
		f.p2.getListpane().setText(infoall);
		return infoall;
	}
}
