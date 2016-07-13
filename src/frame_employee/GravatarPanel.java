package frame_employee;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GravatarPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private static ImageIcon gravatar;
	private static GravatarPanel gravatarPanel;
	public GravatarPanel(){
		gravatar =new ImageIcon(this.getClass().getResource("/image/default_tx.png"));
		setSize(92,97);
		this.setLayout(null);
		this.setOpaque(false);
	}
	
	public GravatarPanel instance(){
		if(gravatarPanel==null)
			gravatarPanel=new GravatarPanel();
		return gravatarPanel;
			
	}
	public void paint(Graphics g) {
		super.paint(g);
		ImageIcon gravatar_bg =new ImageIcon(this.getClass().getResource("/image/login_avatar_bg.png"));
		g.drawImage(gravatar_bg.getImage(), 0, 0, getWidth(), getHeight(), this);
		g.drawImage(gravatar.getImage(),5, 5,gravatar.getIconWidth(),gravatar.getIconHeight(), this);
	}
}
