package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * 
 * @author MiguelRamírez
 *
 */
public class Frame extends JFrame{

	private static final long serialVersionUID = 1L;
	/**
	 * Attribute label type located in frame module
	 */
	private JLabel tit;
	/**
	 * Attribute Pane1 type in which is instanced the panel 1
	 */
	public Pane1 p1;
	/**
	 * Attribute Pane2 type in which is instanced the panel 2
	 */
	public Pane2 p2;
	/**
	 * Attribute Pane2_2 type in which is instanced the panel 2_2
	 */
	public Pane2_2 p2_2;
	/**
	 * Attribute Pane3 type in which is instanced the panel 3
	 */
	public Pane3 p3;
	/**
	 * Attribute Pane3_2 type in which is instanced the panel 3_2
	 */
	public Pane3_2 p3_2;
	/**
	 * Constructor method
	 */
	public Frame() {

		setBounds(0,0,600,400);
		getContentPane().setBackground(new Color(236,240,241));
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		
		startComp();
		
		p1 = new Pane1();
		p1.setVisible(true);
		
		p2 = new Pane2();
		p2.setVisible(false);
		
		p2_2 = new Pane2_2();
		p2_2.setVisible(false);
		
		p3 = new Pane3();
		p3.setVisible(false);
		
		p3_2 = new Pane3_2();
		p3_2.setVisible(false);
		
		add(p1);
		add(p2);
		add(p2_2);
		add(p3);
		add(p3_2);
	}
	/**
	 * Method in which components are initialized, gets it assign a position, and gets it add into the frame
	 */
	public void startComp() {
		Font font = new Font("Leelawadee UI", Font.BOLD, 35);
		
		tit = new JLabel();
		tit.setText("Human Resources Software");
		tit.setBounds(30,30,600,50);//x,y,h,w
		tit.setFont(font);
		tit.setForeground(new Color(113, 125, 126));
		tit.setVisible(true);
		
		add(tit);
	}
}
