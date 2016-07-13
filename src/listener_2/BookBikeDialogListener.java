package listener_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.BikeTypeData;
import entities_2.Booking;
import entities_2.Transport_B;
import frame_2.ImageButton;
import frame_2.MainFrame_2;
import frame_2.ResultPanel;

public class BookBikeDialogListener implements ActionListener {
	
	private JTextField jtfName;
	private JTextField jtfPhoneNum;
	private JComboBox jcbRoomType;
	private ImageButton ensure ;
	private ImageButton cancel ;
	
	public BookBikeDialogListener(JTextField jtfName, JTextField jtfPhoneNum,
			JComboBox jcbRoomType, ImageButton ensure, ImageButton cancel) {
		super();
		this.jtfName = jtfName;
		this.jtfPhoneNum = jtfPhoneNum;
		this.jcbRoomType = jcbRoomType;
		this.ensure = ensure;
		this.cancel = cancel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ensure){
			//插入预定列表
			String name =jtfName.getText();
			String phoneNum =jtfPhoneNum.getText();
			String type =(String)jcbRoomType.getSelectedItem();
			if(name==""||name.length()==0)
				JOptionPane.showMessageDialog(null, "请输入姓名！", "提示",
						JOptionPane.ERROR_MESSAGE);
			
			else if(phoneNum==""||phoneNum.length()==0)
				JOptionPane.showMessageDialog(null, "请输入电话号码！", "提示",
						JOptionPane.ERROR_MESSAGE);
			else{			
			//获取预定时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date newDate = null;
			String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			String month = String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1);
			String day = String.valueOf(Calendar.getInstance().get(Calendar.DATE));
			try {
				newDate = sdf.parse(year+"-"+month+"-"+day);
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}			
			String PreOrderTime = newDate.toString();
			/*------------------------------------------------------------------------*/
			Booking book = new Booking(jtfName.getText(),jtfPhoneNum.getText(),jcbRoomType.getSelectedItem().toString(),PreOrderTime);
			
			try {
				book.storeToDB();
				ResultPanel.instance().showBookingData();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
				try {
					MainFrame_2.instance().closeBookRoomDialog();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}					
		}else if(e.getSource()==cancel){
			//关闭该面板
			try {
				MainFrame_2.instance().closeBookRoomDialog();
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
