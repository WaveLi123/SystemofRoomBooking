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

public class Add_Info_DialogListener implements ActionListener {
	
	private JTextField jtfName;
	private JTextField jtfPhoneNum;
	private JComboBox jcbRoomType;
	private ImageButton ensure ;
	private ImageButton cancel ;
	
	public Add_Info_DialogListener(JTextField jtfName, JTextField jtfPhoneNum,
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
			System.out.println(type);
			if(type.equalsIgnoreCase("������ס�ǼǱ���")){				
				MainFrame_3.instance().closeAdd_Info_Dialog();
				try {
					ResultPanel.instance().showRoom_InData();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "���ݿ�����쳣��", "��ʾ",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}	
			}
			if(type.equalsIgnoreCase("ÿ�յ���ı���")){
				MainFrame_3.instance().closeAdd_Info_Dialog();
				try {
					ResultPanel.instance().showRoom_MoneyData();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "���ݿ�����쳣��", "��ʾ",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}				
			}
			if(type.equalsIgnoreCase("ÿ����ס�ı���")){
				MainFrame_3.instance().closeAdd_Info_Dialog();
				try {
					ResultPanel.instance().showRewardsData();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "���ݿ�����쳣��", "��ʾ",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}				
			}
//			if(type.equalsIgnoreCase("Bus����ģ��")){
//				MainFrame.instance().closeAdd_Info_Dialog();
//				MainFrame.instance().openAddinfo_Bus();				
//			}
//			if(type.equalsIgnoreCase("Route��·����ģ��")){
//				MainFrame.instance().closeAdd_Info_Dialog();
//				MainFrame.instance().openAddinfo_Route();				
//			}
//			if(type.equalsIgnoreCase("Local��·����ģ��")){
//				MainFrame.instance().closeAdd_Info_Dialog();
//				MainFrame.instance().openAddinfo_Local();				
//			}
//			if(type.equalsIgnoreCase("LongDistance��·����ģ��")){
//				MainFrame.instance().closeAdd_Info_Dialog();
//				MainFrame.instance().openAddinfo_LongDistance();				
//			}
//			if(type.equalsIgnoreCase("Employee����ģ��")){
//				MainFrame.instance().closeAdd_Info_Dialog();
//				MainFrame.instance().openAddinfo_Employee();				
//			}
//			if(type.equalsIgnoreCase("Manager����ģ��")){
//				MainFrame.instance().closeAdd_Info_Dialog();
//				MainFrame.instance().openAddinfo_Manager();				
//			}
//			if(type.equalsIgnoreCase("Passenger����ģ��")){
//				MainFrame.instance().closeAdd_Info_Dialog();
//				MainFrame.instance().openAddinfo_Passenger();				
//			}
//			if(type.equalsIgnoreCase("Bicycle����ģ��")){
//				MainFrame.instance().closeAdd_Info_Dialog();
//				MainFrame.instance().openAddinfo_Bicycle();				
//			}			
		}else if(e.getSource()==cancel){
			//�رո����
			MainFrame_3.instance().closeAdd_Info_Dialog();
		}
	}
}
