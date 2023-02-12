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
/**
 * 
 * @author MiguelRamírez
 *
 */
public class Pane1 extends JPanel{

	private static final long serialVersionUID = 1L;
	/**
	 * Attribute label type located in pane1 module
	 */
	private JLabel tit;
	/**
	 * Attribute button type located in pane1 module
	 */
	private JButton listb;
	/**
	 * Attribute button type located in pane1 module
	 */
	private JButton addb;
	/**
	 * Attribute label type located in pane1 module
	 */
	private JLabel img;
	/**
	 * Attribute label type located in pane1 module
	 */
	private JLabel imgp;
	/**
	 * Constructor method
	 */
	public Pane1() {
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
		
		Font font = new Font("Leelawadee UI",Font.BOLD,40);
		Font font2 = new Font("Leelawadee UI",Font.BOLD,25);
		
		tit = new JLabel();
		tit.setText("Contestants");
		tit.setFont(font);
		tit.setBounds(20,20,240,35);
		tit.setForeground(new Color(113, 125, 126));
		tit.setVisible(true);
		
		listb = new JButton();
		listb.setText("List");
		listb.setFont(font2);
		listb.setForeground(new Color(255,255,255));
		
		listb.setBounds(125,200,100,40);
		listb.setBackground(new Color(113, 125, 126));
		listb.setActionCommand("List");
		listb.setVisible(true);
		
		
		addb = new JButton();
		addb.setText("Add");
		addb.setFont(font2);
		addb.setForeground(new Color(255,255,255));
		
		addb.setBounds(350,200,100,40);
		addb.setBackground(new Color(113, 125, 126));
		addb.setActionCommand("Add");
		addb.setVisible(true);
		
		img = new JLabel();
		img.setBounds(0,0,312,240);
		BufferedImage bi = null;
		
		try {
			bi = ImageIO.read(new File("src/co/edu/unbosque/model/util/img/DrawKit Vector Illustration Team Work (6).png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		Image redim = bi.getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH);
		
		imgp = new JLabel();
		imgp.setBounds(125,0,312,240);
		imgp.setIcon(new ImageIcon(redim));
		imgp.setLayout(null);
		imgp.setVisible(true);
		
		add(tit);
		add(listb);
		add(addb);
		add(imgp);
	}
/**
 *  
 * @return listb
 */
	public JButton getListb() {
		return listb;
	}
/**
 * 
 * @param listb
 */
	public void setListb(JButton listb) {
		this.listb = listb;
	}
/**
 * 
 * @return addb
 */
	public JButton getAddb() {
		return addb;
	}
/**
 * 
 * @param addb
 */
	public void setAddb(JButton addb) {
		this.addb = addb;
	}
	
}
