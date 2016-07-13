package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frame_manager.ImageButton;
import frame_manager.MainFrame;

public class ResultPanelListener implements ActionListener{
	
	ImageButton bt_re_back;

	public ResultPanelListener(ImageButton bt_re_back) {
		super();
		this.bt_re_back = bt_re_back;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt_re_back) {
			MainFrame.instance().closeResultPanel();
		}
	}
}
