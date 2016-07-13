package listener_2;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entities_2.Booking;
import entities_2.Transport_B;
import frame_2.ImageButton;
import frame_2.MainFrame_2;

public class TakeBikeDialogListener implements ActionListener{

	private JTextField jtfPhoneNum;
	private JCheckBox jcbTake;
	ImageButton ensure;
	ImageButton cancel;
	public TakeBikeDialogListener(JTextField jtfPhoneNum, JCheckBox jcbTake,
			ImageButton ensure, ImageButton cancel) {
		super();
		this.jtfPhoneNum = jtfPhoneNum;
		this.jcbTake = jcbTake;
		this.ensure = ensure;
		this.cancel = cancel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==ensure){
			if(jcbTake.isSelected()){
				try {
					MainFrame_2.instance().showBookingPanel();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(jtfPhoneNum.getText()==""||jtfPhoneNum.getText().length()==0){
				JOptionPane.showMessageDialog(null, "请输入电话号码！", "提示",
						JOptionPane.ERROR_MESSAGE);
			}else{							
				String value[] = null;
				try {
					value = Booking.getinfo(jtfPhoneNum.getText());
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} 				
				if(value[0] == null){
					JOptionPane.showMessageDialog(null, "该号码没有预定房间！", "提示",
							JOptionPane.ERROR_MESSAGE);
				}else{
					try {
						MainFrame_2.instance().showBookingPanel(value[0],value[1]);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		try {
			MainFrame_2.instance().closeTakeRoomDialog();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}else if(e.getSource()==cancel){
			try {
				MainFrame_2.instance().closeTakeRoomDialog();
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
