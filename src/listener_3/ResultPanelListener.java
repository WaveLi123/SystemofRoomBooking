package listener_3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frame_employee.ImageButton;
import frame_employee.MainFrame_3;

public class ResultPanelListener implements ActionListener{
	
	ImageButton bt_re_back;

	public ResultPanelListener(ImageButton bt_re_back) {
		super();
		this.bt_re_back = bt_re_back;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt_re_back) {
			MainFrame_3.instance().closeResultPanel();
		}
	}
}
