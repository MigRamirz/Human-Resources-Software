package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * 
 * @author MiguelRamírez
 *
 */
public class Pane2 extends JPanel{

	private static final long serialVersionUID = 1L;
	/**
	 * Attribute label type located in pan2 module
	 */
	private JLabel tit;
	/**
	 * Attribute label type located in pan2 module
	 */
	private JLabel img;
	/**
	 * Attribute text area type located in pan2 module
	 */
	private JTextArea listpane;
	/**
	 * Attribute button type located in pan2 module
	 */
	private JButton backb;
	/**
	 * Attribute scrollpane type located in pan2 module
	 */
	private JScrollPane scrollpane;
	/**
	 * Constructor method
	 */
	public Pane2() {
		setBounds(5,100,575,255);
		setBackground(new Color(179, 182, 183));
		setLayout(null);
		setVisible(true);
		
		startComp();
	}
	/**
	 * Method in which components are initialized, gets it assign a position, and gets it add into the frame
	 */
	public void startComp() {
		
		Font font = new Font("Label",Font.BOLD,40);
		Font font2 = new Font("Label",Font.BOLD,25);
		
		tit = new JLabel();
		tit.setText("List");
		tit.setFont(font);
		tit.setBounds(20,20,240,30);
		tit.setForeground(new Color(113, 125, 126));
		tit.setVisible(true);
		
		listpane = new JTextArea(10,30);
		listpane.setEditable(false);
		
		scrollpane = new JScrollPane(listpane);
		scrollpane.setBounds(15,60,540,130);
		
		img = new JLabel();
		img.setBounds(0,0,50,50);
		BufferedImage bi = null;
		
		try {
			bi = ImageIO.read(new File("src/co/edu/unbosque/model/util/img/arrow_back.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		Image redim = bi.getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH);
		
		backb = new JButton();
		backb.setBounds(0,205,50,50);
		backb.setBackground(new Color(113, 125, 126));
		backb.setIcon(new ImageIcon(redim));
		backb.setActionCommand("Back");
		backb.setVisible(true);
		
		add(tit);
		add(scrollpane);
		add(backb);
	}
/**
 * 
 * @return backb
 */
	public JButton getBackb() {
		return backb;
	}
/**
 * 
 * @param backb
 */
	public void setBackb(JButton backb) {
		this.backb = backb;
	}
/**
 * 
 * @return listpane
 */
	public JTextArea getListpane() {
		return listpane;
	}
/**
 * 
 * @param listpane
 */
	public void setListpane(JTextArea listpane) {
		this.listpane = listpane;
	}
	
}
