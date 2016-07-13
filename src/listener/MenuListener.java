package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frame_manager.ImageButton;
import frame_manager.MainFrame;

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
//			MainFrame.instance().showSearchPanel();
		}
		
		else if ((e.getSource() == bt_book)) {
			MainFrame.instance().openAdd_Info_Dialog();
		}
		
		else if((e.getSource() == bt_taken)){
			//MainFrame.instance().openTakeRoomDialog();
			MainFrame.instance().openUpdate_Info_Dialog();
		}
		
		else if(e.getSource()==bt_handRoom){
			//MainFrame.instance().openHandRoomDialog();
			MainFrame.instance().openDelete_Info_Dialog();
		}else if (e.getSource()==bt_set){
//			MainFrame.instance().showConfigPanel();
		}else if(e.getSource()==bt_inf){
			MainFrame.instance().openSelect_Info_Dialog();
		}
	}	
}
