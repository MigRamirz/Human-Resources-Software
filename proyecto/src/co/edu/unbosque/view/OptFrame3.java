package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * 
 * @author MiguelRamírez
 *
 */
public class OptFrame3 extends JFrame{

	private static final long serialVersionUID = 1L;
	/**
	 * Attribute label type located in optframe3 module
	 */
	private JLabel label;
	/**
	 * Attribute button type located in optframe3 module
	 */
	private JButton okb;
	/**
	 * Constructor method
	 */
	public OptFrame3() {
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
		label.setText("Added successful!");
		label.setBounds(10,10,200,40);
		label.setFont(font);
		label.setForeground(new Color(113, 125, 126));
		label.setVisible(true);
		
		
		okb = new JButton();
		okb.setText("Ok");
		okb.setFont(font2);
		okb.setForeground(new Color(255,255,255));
		
		okb.setBounds(100,60,100,40);
		okb.setBackground(new Color(113, 125, 126));
		okb.setActionCommand("Ok");
		okb.setVisible(true);
		
		add(label);
		add(okb);
	}
/**
 * 
 * @return okb
 */
	public JButton getOk() {
		return okb;
	}
/**
 * 
 * @param okb
 */
	public void setOk(JButton okb) {
		this.okb = okb;
	}
	
}
