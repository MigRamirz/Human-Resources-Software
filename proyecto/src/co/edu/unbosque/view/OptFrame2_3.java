package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * 
 * @author MiguelRamírez
 *
 */
public class OptFrame2_3 extends JFrame{

	private static final long serialVersionUID = 1L;
	/**
	 * Attribute label type located in optframe2_3 module
	 */
	private JLabel label;
	/**
	 * Attribute text field type located in optframe2_3 module
	 */
	private JTextField tid;
	/**
	 * Attribute button type located in optframe2_3 module
	 */
	private JButton submit;
	/**
	 * Constructor method
	 */
	public OptFrame2_3() {
		setBounds(40,60,300,200);
		getContentPane().setBackground(new Color(236,240,241));
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setVisible(false);
		
		startComp();
	}
	/**
	 * Method in which components are initialized, gets it assign a position, and gets it add into the frame
	 */
	public void startComp() {
		Font font = new Font("Label", Font.BOLD, 20);
		Font font2 = new Font("Label", Font.BOLD, 15);
		
		label = new JLabel();
		label.setText("Type contestant id");
		label.setBounds(10,10,200,40);
		label.setFont(font);
		label.setForeground(new Color(113, 125, 126));
		label.setVisible(true);
		
		
		submit = new JButton();
		submit.setText("Submit");
		submit.setFont(font2);
		submit.setForeground(new Color(255,255,255));
		
		submit.setBounds(100,120,100,25);
		submit.setBackground(new Color(113, 125, 126));
		submit.setActionCommand("Submit3");
		submit.setVisible(true);
		
		tid = new JTextField();
		tid.setFont(font2);
		tid.setBounds(75,75,150,25);
		tid.setVisible(true);
		
		add(label);
		add(submit);
		add(tid);
	}
/**
 * 
 * @return tid
 */
	public JTextField getTid() {
		return tid;
	}
/**
 * 
 * @param tid
 */
	public void setTid(JTextField tid) {
		this.tid = tid;
	}
/**
 * 
 * @return submit
 */
	public JButton getSubmit() {
		return submit;
	}
/**
 * 
 * @param submit
 */
	public void setSubmit(JButton submit) {
		this.submit = submit;
	}

	
}
