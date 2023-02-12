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
public class OptFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	/**
	 * Attribute label type located in optframe module
	 */
	private JLabel label;
	/**
	 * Attribute button type located in optframe module
	 */
	private JButton yb;
	/**
	 * Attribute button type located in optframe module
	 */
	private JButton nb;
	/**
	 * Constructor method
	 */
	public OptFrame() {
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
		label.setText("List just one?");
		label.setBounds(10,10,200,40);
		label.setFont(font);
		label.setForeground(new Color(113, 125, 126));
		label.setVisible(true);
		
		
		yb = new JButton();
		yb.setText("Yes");
		yb.setFont(font2);
		yb.setForeground(new Color(255,255,255));
		
		yb.setBounds(33,80,100,40);
		yb.setBackground(new Color(113, 125, 126));
		yb.setActionCommand("Yes");
		yb.setVisible(true);
		
		
		nb = new JButton();
		nb.setText("No");
		nb.setFont(font2);
		nb.setForeground(new Color(255,255,255));
		
		nb.setBounds(157,80,100,40);
		nb.setBackground(new Color(113, 125, 126));
		nb.setActionCommand("No");
		nb.setVisible(true);
		
		add(label);
		add(yb);
		add(nb);
	}
/**
 * 
 * @return yb
 */
	public JButton getYb() {
		return yb;
	}
/**
 * 
 * @param yb
 */
	public void setYb(JButton yb) {
		this.yb = yb;
	}
/**
 * 
 * @return yb
 */
	public JButton getNb() {
		return nb;
	}
/**
 * 
 * @param nb
 */
	public void setNb(JButton nb) {
		this.nb = nb;
	}
	
}
