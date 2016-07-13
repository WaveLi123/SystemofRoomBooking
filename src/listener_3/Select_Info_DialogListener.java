package listener_3;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import entities.Transportation;
import frame_employee.ImageButton;
import frame_employee.MainFrame_3;
import frame_employee.ResultPanel;

public class Select_Info_DialogListener implements ActionListener {
	
	private JTextField jtfName;
	private JTextField jtfPhoneNum;
	private JComboBox jcbRoomType;
	private ImageButton ensure ;
	private ImageButton cancel ;
	
	public Select_Info_DialogListener(JTextField jtfName, JTextField jtfPhoneNum,
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
			String type =(String)jcbRoomType.getSelectedItem();
			if(type.equalsIgnoreCase("Bus管理模块")){
				MainFrame_3.instance().closeSelect_Info_Dialog();
				try {
					ResultPanel.instance().showBusData();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "数据库操作异常！", "提示",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}			
			}
			if(type.equalsIgnoreCase("Route线路管理模块")){
				MainFrame_3.instance().closeSelect_Info_Dialog();
				try {
					ResultPanel.instance().showRouteData();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "数据库操作异常！", "提示",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
			if(type.equalsIgnoreCase("Local线路管理模块")){
				MainFrame_3.instance().closeSelect_Info_Dialog();
				try {
					ResultPanel.instance().showLocalData();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "数据库操作异常！", "提示",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
			if(type.equalsIgnoreCase("LongDistance线路管理模块")){
				MainFrame_3.instance().closeSelect_Info_Dialog();
				try {
					ResultPanel.instance().showLongDistanceData();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "数据库操作异常！", "提示",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
			if(type.equalsIgnoreCase("Employee管理模块")){
				MainFrame_3.instance().closeSelect_Info_Dialog();
				try {
					ResultPanel.instance().showEmployeeData();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "数据库操作异常！", "提示",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
			if(type.equalsIgnoreCase("Manager管理模块")){
				MainFrame_3.instance().closeSelect_Info_Dialog();
				try {
					ResultPanel.instance().showManagerData();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "数据库操作异常！", "提示",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
			if(type.equalsIgnoreCase("Passenger管理模块")){
				MainFrame_3.instance().closeSelect_Info_Dialog();
				try {
					ResultPanel.instance().showPassengerData();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "数据库操作异常！", "提示",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
			if(type.equalsIgnoreCase("Bicycle管理模块")){
				MainFrame_3.instance().closeSelect_Info_Dialog();
				try {
					ResultPanel.instance().showBicycleData();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "数据库操作异常！", "提示",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}						
		}else if(e.getSource()==cancel){
			//关闭该面板
			MainFrame_3.instance().closeSelect_Info_Dialog();
		}
	}	
}
