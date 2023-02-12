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
import javax.swing.JTextArea;
/**
 * 
 * @author MiguelRamírez
 *
 */
public class Pane2_2 extends JPanel{

	private static final long serialVersionUID = 1L;
	/**
	 * Attribute button type located in pane2_2 module
	 */
	private JButton backb;
	/**
	 * Attribute label type located in pane2_2 module
	 */
	private JLabel tit;
	/**
	 * Attribute text area type located in pane2_2 module
	 */
	private JTextArea infop;
	/**
	 * Attribute label type located in pane2_2 module
	 */
	private JLabel img;
	/**
	 * Constructor method
	 */
	public Pane2_2() {
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
		
		tit = new JLabel();
		tit.setText("List to...");
		tit.setFont(font);
		tit.setBounds(20,20,240,30);
		tit.setForeground(new Color(113, 125, 126));
		tit.setVisible(true);
		
		infop = new JTextArea();
		infop.setBounds(15,60,540,130);
		infop.setEditable(false);
		infop.setLayout(null);
		infop.setVisible(true);
		
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
		add(infop);
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
 * @return infop
 */
	public JTextArea getInfop() {
		return infop;
	}
/**
 * 
 * @param infop
 */
	public void setInfop(JTextArea infop) {
		this.infop = infop;
	}
	
}
