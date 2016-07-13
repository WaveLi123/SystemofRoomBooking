package frame_manager;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

import listener.MenuListener;

public class MenuGroupPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1454321970041417514L;
	private static MenuGroupPanel menuGroupPanel;
	private ImageButton bt_book,bt_taken,bt_handRoom,bt_set,bt_inf,bt_search;
	private MenuListener menuListener;
	public static MenuGroupPanel instance() {
		if (menuGroupPanel == null)
			menuGroupPanel = new MenuGroupPanel();
		return menuGroupPanel;
	}
	
	public MenuGroupPanel(){
		setOpaque(false);
		setLayout(new GridLayout(2,3));
		setPreferredSize(new Dimension(720,260));
			
		bt_book=new ImageButton("bt_menu","²éÑ¯±¨±í",45);
		bt_taken=new ImageButton("bt_menu","ï¿½Þ¸ï¿½",57);
		bt_handRoom=new ImageButton("bt_menu","¸ü¸Ä»ù¼Û",45);
		bt_set=new ImageButton("bt_menu","ï¿½ï¿½ï¿½ï¿½",57);
		bt_inf=new ImageButton("bt_menu","È·ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½",50);
		bt_search=new ImageButton("bt_menu","ï¿½ï¿½Ñ¯",57);
		
		menuListener =new MenuListener(bt_book,bt_taken,bt_handRoom,bt_set,bt_inf,bt_search);
		bt_book.setPreferredSize(new Dimension(238, 120));
		bt_taken.setPreferredSize(new Dimension(238, 120));
		bt_handRoom.setPreferredSize(new Dimension(238, 120));
		bt_set.setPreferredSize(new Dimension(238, 120));
		bt_inf.setPreferredSize(new Dimension(238, 120));
		
		
		bt_set.setVisible(false);
		bt_search.setVisible(false);
		bt_taken.setVisible(false);
		bt_inf.setVisible(false);
		
		add(bt_book);
		add(bt_taken);
		add(bt_handRoom);
		add(bt_set);
		add(bt_inf);
		add(bt_search);					
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		if(this.isEnabled()){
			bt_search.addActionListener(menuListener);
			bt_book.addActionListener(menuListener);
			bt_taken.addActionListener(menuListener);
			bt_handRoom.addActionListener(menuListener);
			bt_set.addActionListener(menuListener);
			bt_inf.addActionListener(menuListener);
		}else{
			bt_search.removeActionListener(menuListener);
			bt_book.removeActionListener(menuListener);
			bt_taken.removeActionListener(menuListener);
			bt_handRoom.removeActionListener(menuListener);
			bt_set.removeActionListener(menuListener);
			bt_inf.removeActionListener(menuListener);
		}
		
	}		
}
