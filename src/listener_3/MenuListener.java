package listener_3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import frame_employee.ImageButton;
import frame_employee.MainFrame_3;
import frame_employee.ResultPanel;

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
			MainFrame_3.instance().openAdd_Info_Dialog();
		}
		
		else if((e.getSource() == bt_taken)){
			//MainFrame.instance().openTakeRoomDialog();
			MainFrame_3.instance().openUpdate_Info_Dialog();
		}
		
		else if(e.getSource()==bt_handRoom){			
			try {
				ResultPanel.instance().showFineData();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
//				JOptionPane.showMessageDialog(null, "数据库操作异常！", "提示",
//						JOptionPane.ERROR_MESSAGE);
//				e1.printStackTrace();
			}
		}else if (e.getSource()==bt_set){
//			MainFrame.instance().showConfigPanel();
		}else if(e.getSource()==bt_inf){
			MainFrame_3.instance().openSelect_Info_Dialog();
		}
	}	
}
