package listener_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import frame_2.ImageButton;
import frame_2.MainFrame_2;

public class ResultPanelListener implements ActionListener{
	
	ImageButton bt_re_back;

	public ResultPanelListener(ImageButton bt_re_back) {
		super();
		this.bt_re_back = bt_re_back;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt_re_back) {
			try {
				MainFrame_2.instance().closeResultPanel();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
