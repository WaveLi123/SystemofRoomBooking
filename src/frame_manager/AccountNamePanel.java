package frame_manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import entities.AccountData;

public class AccountNamePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static AccountNamePanel namePanel;
	public AccountNamePanel(){
		
		setOpaque(false);
		setSize(320,100);
		setVisible(true);
	}
	
	public AccountNamePanel instance(){
		if(namePanel==null)
			namePanel=new AccountNamePanel();
		return namePanel;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		String name=AccountData.instance().getCurrAccountName();
		g.setFont(new Font("΢���ź�", Font.PLAIN, 70));
		g.setColor(Color.WHITE);
		g.drawString(name, 50, 100);
		MainFrame.instance().repaint();
	}
	
	
}
