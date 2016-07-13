package listener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entities.Transportation;
import frame_manager.ImageButton;
import frame_manager.MainFrame;
import frame_manager.ResultPanel;

public class Add_Info_DialogListener implements ActionListener {
	
	private JTextField jtfName;
	private JTextField jtfPhoneNum;
	private JComboBox jcbRoomType;
	private ImageButton ensure ;
	private ImageButton cancel ;
	
	public Add_Info_DialogListener(JTextField jtfName, JTextField jtfPhoneNum,
			JComboBox jcbRoomType, ImageButton ensure2, ImageButton cancel2) {
		super();
		this.jtfName = jtfName;
		this.jtfPhoneNum = jtfPhoneNum;
		this.jcbRoomType = jcbRoomType;
		this.ensure = ensure2;
		this.cancel = cancel2;
	}

	public Add_Info_DialogListener(JTextField jtfName2,
			JTextField jtfPhoneNum2, JComboBox jcbRoomType2,
			frame_employee.ImageButton ensure2, frame_employee.ImageButton cancel2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ensure){
			String type =(String)jcbRoomType.getSelectedItem();
			if(type.equalsIgnoreCase("预计房间入住报表")){				
				MainFrame.instance().closeAdd_Info_Dialog();
				try {
					ResultPanel.instance().showRoom_InData();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "数据库操作异常！", "提示",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}	
			}
			if(type.equalsIgnoreCase("预计房间收入报表")){
				MainFrame.instance().closeAdd_Info_Dialog();
				try {
					ResultPanel.instance().showRoom_MoneyData();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "数据库操作异常！", "提示",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}				
			}
			if(type.equalsIgnoreCase("奖励报表")){
				MainFrame.instance().closeAdd_Info_Dialog();
				try {
					ResultPanel.instance().showRewardsData();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "数据库操作异常！", "提示",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}				
			}
//			if(type.equalsIgnoreCase("Bus管理模块")){
//				MainFrame.instance().closeAdd_Info_Dialog();
//				MainFrame.instance().openAddinfo_Bus();				
//			}
//			if(type.equalsIgnoreCase("Route线路管理模块")){
//				MainFrame.instance().closeAdd_Info_Dialog();
//				MainFrame.instance().openAddinfo_Route();				
//			}
//			if(type.equalsIgnoreCase("Local线路管理模块")){
//				MainFrame.instance().closeAdd_Info_Dialog();
//				MainFrame.instance().openAddinfo_Local();				
//			}
//			if(type.equalsIgnoreCase("LongDistance线路管理模块")){
//				MainFrame.instance().closeAdd_Info_Dialog();
//				MainFrame.instance().openAddinfo_LongDistance();				
//			}
//			if(type.equalsIgnoreCase("Employee管理模块")){
//				MainFrame.instance().closeAdd_Info_Dialog();
//				MainFrame.instance().openAddinfo_Employee();				
//			}
//			if(type.equalsIgnoreCase("Manager管理模块")){
//				MainFrame.instance().closeAdd_Info_Dialog();
//				MainFrame.instance().openAddinfo_Manager();				
//			}
//			if(type.equalsIgnoreCase("Passenger管理模块")){
//				MainFrame.instance().closeAdd_Info_Dialog();
//				MainFrame.instance().openAddinfo_Passenger();				
//			}
//			if(type.equalsIgnoreCase("Bicycle管理模块")){
//				MainFrame.instance().closeAdd_Info_Dialog();
//				MainFrame.instance().openAddinfo_Bicycle();				
//			}			
		}else if(e.getSource()==cancel){
			//关闭该面板
			MainFrame.instance().closeAdd_Info_Dialog();
		}
	}		
}
