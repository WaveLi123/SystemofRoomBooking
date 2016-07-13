package frame_employee;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class BackgroundPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BackgroundPanel() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, (int) screenSize.getWidth(),
				(int) screenSize.getHeight());
		this.setOpaque(false);
	}

	public void paint(Graphics g) {
		super.paint(g);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, (int) screenSize.getWidth(),
				(int) screenSize.getHeight());
		
		ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource("/image/bg.png"));
		g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);

	}
}
