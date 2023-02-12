package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.ContestantDAOImplements;
import co.edu.unbosque.view.Frame;
import co.edu.unbosque.view.OptFrame;
import co.edu.unbosque.view.OptFrame2;
import co.edu.unbosque.view.OptFrame2_0;
import co.edu.unbosque.view.OptFrame2_2;
import co.edu.unbosque.view.OptFrame2_3;
import co.edu.unbosque.view.OptFrame3;
import co.edu.unbosque.view.OptFrame3_2;
import co.edu.unbosque.view.OptFrame3_3;
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
	 * Attribute declaration for display an information frame which works on team with GUI
	 */
	private OptFrame2_0 optf2_0;
	/**
	 * Attribute declaration for display an information frame which works on team with GUI
	 */
	private OptFrame2_2 optf2_2;
	/**
	 * Attribute declaration for display an information frame which works on team with GUI
	 */
	private OptFrame2_3 optf2_3;
	/**
	 * Attribute declaration for display a information frame which works on team with GUI
	 */
	private OptFrame3 optf3;
	/**
	 * Attribute declaration for display a information frame which works on team with GUI
	 */
	private OptFrame3_2 optf3_2;
	/**
	 * Attribute declaration for display a information frame which works on team with GUI
	 */
	private OptFrame3_3 optf3_3;
	/**
	 * Attribute declaration for display a information frame which works on team with GUI
	 */
	private ContestantDAOImplements cdao;
	/**
	 * Attribute declaration for manage files
	 */
	
	/**
	 * Constructor method which allows start some attributes for a correct running
	 */
	public Controller() {
		f = new Frame();
		optf = new OptFrame();
		optf2 = new OptFrame2();
		optf2_0 = new OptFrame2_0();
		optf2_2 = new OptFrame2_2();
		optf2_3 = new OptFrame2_3();
		optf3 = new OptFrame3();
		optf3_2 = new OptFrame3_2();
		optf3_3 = new OptFrame3_3();
		cdao = new ContestantDAOImplements();
		f.setVisible(false);
		
		f.p1.getListb().addActionListener(this);
		f.p1.getAddb().addActionListener(this);
		
		optf.getYb().addActionListener(this);
		optf.getNb().addActionListener(this);
		
		optf2.getSubmit().addActionListener(this);
		optf2_0.getYb().addActionListener(this);
		optf2_0.getNb().addActionListener(this);
		optf2_2.getSubmit().addActionListener(this);
		optf2_3.getSubmit().addActionListener(this);
		
		optf3.getOk().addActionListener(this);
		optf3_2.getOk().addActionListener(this);
		optf3_3.getOk().addActionListener(this);
		
		f.p2.getSetb().addActionListener(this);
		f.p2.getRemoveb().addActionListener(this);
		f.p2.getBackb().addActionListener(this);
		
		
		f.p2_2.getBackb().addActionListener(this);
		
		f.p3.getBackb().addActionListener(this);
		f.p3.getSaveb().addActionListener(this);
		
		f.p3_2.getSaveb().addActionListener(this);
		f.p3_2.getBackb().addActionListener(this);
		
		run();
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
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("List")) {
			if(cdao.listContestant() != "") {
				optf.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "Contestant list void");
			}
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
					if(cdao.find(optf2.getTid().getText()) == true) {
						f.p2_2.getInfop().setText(cdao.listOneContestant(optf2.getTid().getText()));
						optf2.setVisible(false);
						optf2.getTid().setText("");
					}else {
						JOptionPane.showMessageDialog(null, "Contestant doesn't exists");
						optf2.getTid().setText("");
					}
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
			f.p2.getListpane().setText(cdao.listContestant());
		}
		if(e.getActionCommand().equals("Add")) {
			f.p1.setVisible(false);
			f.p2.setVisible(false);
			f.p2_2.setVisible(false);
			f.p3.setVisible(true);
		}
		if(e.getActionCommand().equals("Save")) {
			String n,s,id,post, age;
			try {
			n = f.p3.getTname().getText();
			s = f.p3.getTsurname().getText();
			age = f.p3.getTage().getText();
			id = f.p3.getTid().getText();
			post = f.p3.getTpost().getText();
			if(f.p3.getTname().getText().equals("") ||
					f.p3.getTsurname().getText().equals("") ||
					f.p3.getTage().getText().equals("") ||
					f.p3.getTid().getText().equals("") ||
					f.p3.getTpost().getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Fill all fields");
			}else {
				if( (f.p3.getTname().getText().matches("[A-z]*")) &&
						(f.p3.getTsurname().getText().matches("[A-z]*")) &&
						f.p3.getTid().getText().matches("[0-9]*") &&
						f.p3.getTage().getText().matches("[0-9]*")) {
					int age2 = Integer.parseInt(age);
					if(cdao.find(id) == true) {
						JOptionPane.showMessageDialog(null, "Contestant id alreay exists");
					}else {
						cdao.addNewContestant(n, s, age2, id, post);
						optf3.setVisible(true);
						f.p3.getTname().setText("");
						f.p3.getTsurname().setText("");
						f.p3.getTage().setText("");
						f.p3.getTid().setText("");
						f.p3.getTpost().setText("");
					}	
				}else {
					JOptionPane.showMessageDialog(null, "Invalid characters \n"
							+ "No special characteres");
				}
			}
			
			}catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Invalid characters");
			}
		}
		if(e.getActionCommand().equals("Ok")) {
			optf3.setVisible(false);
		}
		if(e.getActionCommand().equals("Set")) {
			optf2_2.setVisible(true);
		}
		if(e.getActionCommand().equals("Submit2")) {
			if(optf2_2.getTid().getText().equals("")){
				JOptionPane.showMessageDialog(null, "Field void");
			}else {
				if(optf2_2.getTid().getText().matches("[0-9]*")){
					if(cdao.find(optf2_2.getTid().getText())==true) {
						f.p2.setVisible(false);
						optf2_2.setVisible(false);
						optf2_2.getTid().setText("");
						f.p3_2.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Contestant not found");
						optf2_2.getTid().setText("");
						}
				}else {
					JOptionPane.showMessageDialog(null, "Invalid characters");
					optf2_2.getTid().setText("");
				}
			}
			
		}
		if(e.getActionCommand().equals("Save2")) {
			String n,s,id,post, age;
			try {
			id = optf2_2.getTid().getText();
			n = f.p3_2.getTname().getText();
			s = f.p3_2.getTsurname().getText();
			age = f.p3_2.getTage().getText();
			post = f.p3_2.getTpost().getText();
			
			if(f.p3_2.getTname().getText().equals("") ||
				f.p3_2.getTsurname().getText().equals("") ||
				f.p3_2.getTage().getText().equals("") ||
				f.p3_2.getTpost().getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Fill all fields");
			}else {
				if( (f.p3_2.getTname().getText().matches("[A-z]*")) && 
						(f.p3_2.getTsurname().getText().matches("[A-z]*")) &&
						f.p3_2.getTage().getText().matches("[0-9]*")) {
					int age2 = Integer.parseInt(age);
					cdao.setContestant(id, n, s, age2, post);
					optf3_2.setVisible(true);
					f.p3_2.getTname().setText("");
					f.p3_2.getTsurname().setText("");
					f.p3_2.getTage().setText("");
					f.p3_2.getTpost().setText("");
				}else {
					JOptionPane.showMessageDialog(null, "Invalid characters");
				}
			}
			
			}catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Invalid characters");
			}
		}
		if(e.getActionCommand().equals("Ok2")) {
			optf3_2.setVisible(false);
		}
		if(e.getActionCommand().equals("Remove")) {
			optf2_3.setVisible(true);
		}
		if(e.getActionCommand().equals("Submit3")) {
			if(optf2_3.getTid().getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Field void");
			}else {
				if(optf2_3.getTid().getText().matches("[0-9]*")) {
					if(cdao.find(optf2_3.getTid().getText())==true) {
						optf2_3.getTid().setText("");
						optf2_0.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Contestant not found");
						optf2_3.getTid().setText("");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Invalid characters");
					optf2_3.getTid().setText("");
				}
			}
		}
		if(e.getActionCommand().equals("Yes2")) {
			optf2_0.setVisible(false);
			optf2_3.setVisible(false);
			optf3_3.setVisible(true);
			cdao.deleteContestant(optf2_3.getTid().getText());
			f.p2.getListpane().setText(cdao.listContestant());
		}
		if(e.getActionCommand().equals("Ok3")) {
			optf3_3.setVisible(false);
		}
		if(e.getActionCommand().equals("Cancel")) {
			optf2_0.setVisible(false);
			optf2_3.setVisible(false);
		}
		
		if(e.getActionCommand().equals("Back")) {
			f.p2_2.setVisible(false);
			f.p2.setVisible(false);
			f.p3.setVisible(false);
			f.p3_2.setVisible(false);
			f.p1.setVisible(true);
		}
	}
}
