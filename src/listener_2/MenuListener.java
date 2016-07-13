package listener_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import frame_2.ImageButton;
import frame_2.MainFrame_2;

public class MenuListener implements ActionListener {
	
	private ImageButton bt_book,bt_taken,bt_handRoom,bt_set,bt_inf,bt_search;

	public MenuListener(ImageButton bt_book, ImageButton bt_taken,
			ImageButton bt_handRoom, ImageButton bt_set, ImageButton bt_inf,
			ImageButton bt_search) {
		super();
		this.bt_book = bt_book;
		this.bt_taken = bt_taken;
		this.bt_handRoom = bt_handRoom;
		this.bt_set = bt_set;
		this.bt_inf = bt_inf;
		this.bt_search = bt_search;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ((e.getSource() == bt_search)) {
		}
		
		else if ((e.getSource() == bt_book)) {
			try {
				MainFrame_2.instance().openBookRoomDialog();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if((e.getSource() == bt_taken)){
			try {
				MainFrame_2.instance().openTakeRoomDialog();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if(e.getSource()==bt_handRoom){
			try {
				MainFrame_2.instance().openHandRoomDialog();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (e.getSource()==bt_set){			
		}else if(e.getSource()==bt_inf){
			
		}
	}
	
}
