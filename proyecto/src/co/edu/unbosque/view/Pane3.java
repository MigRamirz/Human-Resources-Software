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
import javax.swing.JTextField;
/**
 * 
 * @author MiguelRamírez
 *
 */
public class Pane3 extends JPanel{

	private static final long serialVersionUID = 1L;
	/**
	 * Attribute label type located in pane3 module
	 */
	private JLabel tit;
	/**
	 * Attribute label type located in pane3 module
	 */
	private JLabel lname;
	/**
	 * Attribute label type located in pane3 module
	 */
	private JLabel lsurname;
	/**
	 * Attribute label type located in pane3 module
	 */
	private JLabel lage;
	/**
	 * Attribute label type located in pane3 module
	 */
	private JLabel lid;
	/**
	 * Attribute label type located in pane3 module
	 */
	private JLabel lpost;
	/**
	 * Attribute text field type located in pane3 module
	 */
	private JTextField tname;
	/**
	 * Attribute text field type located in pane3 module
	 */
	private JTextField tsurname;
	/**
	 * Attribute text field type located in pane3 module
	 */
	private JTextField tage;
	/**
	 * Attribute text field type located in pane3 module
	 */
	private JTextField tid;
	/**
	 * Attribute text field type located in pane3 module
	 */
	private JTextField tpost;
	/**
	 * Attribute label type located in pane3 module
	 */
	private JLabel img;
	/**
	 * Attribute button type located in pane3 module
	 */
	private JButton backb;
	/**
	 * Attribute button type located in pane3 module
	 */
	private JButton saveb;
	/**
	 * Constructor method
	 */
	public Pane3() {
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
		Font font2 = new Font("Label",Font.BOLD,20);
		
		tit = new JLabel();
		tit.setText("Add new contestant");
		tit.setFont(font);
		tit.setBounds(20,20,380,30);
		tit.setForeground(new Color(113, 125, 126));
		tit.setVisible(true);
		
		lname = new JLabel();
		lname.setText("Name 1");
		lname.setFont(font2);
		lname.setBounds(80,60,70,20);
		lname.setForeground(new Color(113, 125, 126));
		lname.setVisible(true);
		
		tname = new JTextField();
		tname.setFont(font2);
		tname.setBounds(80,85,200,30);
		tname.setVisible(true);
		
		
		lsurname = new JLabel();
		lsurname.setText("Surname 1");
		lsurname.setFont(font2);
		lsurname.setBounds(300,60,200,20);
		lsurname.setForeground(new Color(113, 125, 126));
		lsurname.setVisible(true);
		
		tsurname = new JTextField();
		tsurname.setFont(font2);
		tsurname.setBounds(300,85,200,30);
		tsurname.setVisible(true);
		
		
		lage = new JLabel();
		lage.setText("Age");
		lage.setFont(font2);
		lage.setBounds(80,120,60,25);
		lage.setForeground(new Color(113, 125, 126));
		lage.setVisible(true);
		
		tage = new JTextField();
		tage.setFont(font2);
		tage.setBounds(80,145,60,30);
		tage.setVisible(true);
		
		
		lid = new JLabel();
		lid.setText("Id");
		lid.setFont(font2);
		lid.setBounds(150,120,30,20);
		lid.setForeground(new Color(113, 125, 126));
		lid.setVisible(true);
		
		tid = new JTextField();
		tid.setFont(font2);
		tid.setBounds(150,145,150,30);
		tid.setVisible(true);
		
		lpost = new JLabel();
		lpost.setText("Post");
		lpost.setFont(font2);
		lpost.setBounds(80,180,50,20);
		lpost.setForeground(new Color(113, 125, 126));
		lpost.setVisible(true);
		
		tpost = new JTextField();
		tpost.setFont(font2);
		tpost.setBounds(80,205,200,30);
		tpost.setVisible(true);
		
		saveb = new JButton();
		saveb.setText("Save");
		saveb.setFont(font2);
		saveb.setForeground(new Color(255,255,255));
		
		saveb.setBounds(380,180,100,40);
		saveb.setBackground(new Color(113, 125, 126));
		saveb.setActionCommand("Save");
		saveb.setVisible(true);
		
		
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
		add(lname);
		add(lsurname);
		add(lid);
		add(lage);
		add(lpost);
		add(tname);
		add(tsurname);
		add(tage);
		add(tid);
		add(tpost);
		add(saveb);
		add(backb);
	}
/**
 * 
 * @return tit
 */
	public JLabel getTit() {
		return tit;
	}
/**
 * 
 * @param tit
 */
	public void setTit(JLabel tit) {
		this.tit = tit;
	}
/**
 * 
 * @return tname
 */
	public JTextField getTname() {
		return tname;
	}
/**
 * 
 * @param tname
 */
	public void setTname(JTextField tname) {
		this.tname = tname;
	}
/**
 * 
 * @return tsurname
 */
	public JTextField getTsurname() {
		return tsurname;
	}
/**
 * 
 * @param tsurname
 */
	public void setTsurname(JTextField tsurname) {
		this.tsurname = tsurname;
	}
/**
 * 
 * @return tage
 */
	public JTextField getTage() {
		return tage;
	}
/**
 * 
 * @param tage
 */
	public void setTage(JTextField tage) {
		this.tage = tage;
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
 * @return tpost
 */
	public JTextField getTpost() {
		return tpost;
	}
/**
 * 
 * @param tpost
 */
	public void setTpost(JTextField tpost) {
		this.tpost = tpost;
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
 * @return saveb
 */
	public JButton getSaveb() {
		return saveb;
	}
/**
 * 
 * @param saveb
 */
	public void setSaveb(JButton saveb) {
		this.saveb = saveb;
	}
	
}
