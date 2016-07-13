package listener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;








import manager.Room_Price;
import entities.Bus;
import entities.Employee;
import entities.Local;
import entities.LongDistance;
import entities.Manager;
import entities.Passenger;
import entities.Route;
import entities_2.Bike;
import frame_manager.ImageButton;
import frame_manager.MainFrame;
import frame_manager.ResultPanel;

public class Delete_Info_DialogListener implements ActionListener {
		
	private JTextField jtfNum;
	private JComboBox jcbRoomType;
	private ImageButton ensure ;
	private ImageButton cancel ;
	
	public Delete_Info_DialogListener(JTextField jtfNum,JComboBox jcbRoomType, ImageButton ensure2, ImageButton cancel2) {
		super();		
		this.jtfNum = jtfNum;
		this.jcbRoomType = jcbRoomType;
		this.ensure = ensure2;
		this.cancel = cancel2;
		//获取当前基价
		try {
			this.jtfNum.setText(Room_Price.getinfo("1"));
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//获取新的基价并进行存储
		String new_price = this.jtfNum.getText();		
		Room_Price room_price = new Room_Price(Float.parseFloat(new_price));
		try {
			room_price.updateDB();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}		
		if(e.getSource()==ensure){
			JOptionPane.showMessageDialog(null, "您的修改已经完成！", "提示",JOptionPane.ERROR_MESSAGE);
			MainFrame.instance().closeDelete_Info_Dialog();
			
			String type =(String)jcbRoomType.getSelectedItem();
			if(type.equalsIgnoreCase("Bus管理模块")){				
				try {
					if(jtfNum.getText().equalsIgnoreCase("")){
						JOptionPane.showMessageDialog(null, "请输入完整的信息！", "提示",JOptionPane.ERROR_MESSAGE);
					}
					else{
						Bus temp = new Bus();
						int i = 0;
						for(i = 0; i < temp.getkeyinfo_bus().length; i ++){
							if(jtfNum.getText().equalsIgnoreCase(temp.getkeyinfo_bus()[i])){
								break;
							}
						}
						if(i == temp.getkeyinfo_bus().length){
							JOptionPane.showMessageDialog(null, "您选择的信息不存在！", "提示",JOptionPane.ERROR_MESSAGE);	
						}
						else{
							MainFrame.instance().closeDelete_Info_Dialog();				
							MainFrame.instance().openDeleteinfo_Bus(jtfNum.getText());	
						}						
					}				
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
			if(type.equalsIgnoreCase("Route线路管理模块")){
				try {
					if(jtfNum.getText().equalsIgnoreCase("")){
						JOptionPane.showMessageDialog(null, "请输入完整的信息！", "提示",JOptionPane.ERROR_MESSAGE);
					}
					else{
						Route temp = new Route();
						int i = 0;
						for(i = 0; i < temp.getkeyinfo().length; i ++){
							if(jtfNum.getText().equalsIgnoreCase(temp.getkeyinfo()[i])){
								break;
							}
						}
						if(i == temp.getkeyinfo().length){
							JOptionPane.showMessageDialog(null, "您选择的信息不存在！", "提示",JOptionPane.ERROR_MESSAGE);	
						}
						else{
							MainFrame.instance().closeDelete_Info_Dialog();				
							MainFrame.instance().openDeleteinfo_Route(jtfNum.getText());	
						}						
					}				
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(type.equalsIgnoreCase("Local线路管理模块")){
				try {
					if(jtfNum.getText().equalsIgnoreCase("")){
						JOptionPane.showMessageDialog(null, "请输入完整的信息！", "提示",JOptionPane.ERROR_MESSAGE);
					}
					else{
						Local temp = new Local();
						int i = 0;
						for(i = 0; i < temp.getkeyinfo().length; i ++){
							if(jtfNum.getText().equalsIgnoreCase(temp.getkeyinfo()[i])){
								break;
							}
						}
						if(i == temp.getkeyinfo().length){
							JOptionPane.showMessageDialog(null, "您选择的信息不存在！", "提示",JOptionPane.ERROR_MESSAGE);	
						}
						else{
							MainFrame.instance().closeDelete_Info_Dialog();				
							MainFrame.instance().openDeleteinfo_Local(jtfNum.getText());	
						}						
					}				
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(type.equalsIgnoreCase("LongDistance线路管理模块")){
				try {
					if(jtfNum.getText().equalsIgnoreCase("")){
						JOptionPane.showMessageDialog(null, "请输入完整的信息！", "提示",JOptionPane.ERROR_MESSAGE);
					}
					else{
						LongDistance temp = new LongDistance();
						int i = 0;
						for(i = 0; i < temp.getkeyinfo().length; i ++){
							if(jtfNum.getText().equalsIgnoreCase(temp.getkeyinfo()[i])){
								break;
							}
						}
						if(i == temp.getkeyinfo().length){
							JOptionPane.showMessageDialog(null, "您选择的信息不存在！", "提示",JOptionPane.ERROR_MESSAGE);	
						}
						else{
							MainFrame.instance().closeDelete_Info_Dialog();				
							MainFrame.instance().openDeleteinfo_LongDistance(jtfNum.getText());	
						}						
					}				
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(type.equalsIgnoreCase("Employee管理模块")){
				try {
					if(jtfNum.getText().equalsIgnoreCase("")){
						JOptionPane.showMessageDialog(null, "请输入完整的信息！", "提示",JOptionPane.ERROR_MESSAGE);
					}
					else{
						Employee temp = new Employee();
						int i = 0;
						for(i = 0; i < temp.getkeyinfo().length; i ++){
							if(jtfNum.getText().equalsIgnoreCase(temp.getkeyinfo()[i])){
								break;
							}
						}
						if(i == temp.getkeyinfo().length){
							JOptionPane.showMessageDialog(null, "您选择的信息不存在！", "提示",JOptionPane.ERROR_MESSAGE);	
						}
						else{
							MainFrame.instance().closeDelete_Info_Dialog();				
							MainFrame.instance().openDeleteinfo_Employee(jtfNum.getText());	
						}						
					}				
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(type.equalsIgnoreCase("Manager管理模块")){
				try {
					if(jtfNum.getText().equalsIgnoreCase("")){
						JOptionPane.showMessageDialog(null, "请输入完整的信息！", "提示",JOptionPane.ERROR_MESSAGE);
					}
					else{
						Manager temp = new Manager();
						int i = 0;
						for(i = 0; i < temp.getkeyinfo().length; i ++){
							if(jtfNum.getText().equalsIgnoreCase(temp.getkeyinfo()[i])){
								break;
							}
						}
						if(i == temp.getkeyinfo().length){
							JOptionPane.showMessageDialog(null, "您选择的信息不存在！", "提示",JOptionPane.ERROR_MESSAGE);	
						}
						else{
							MainFrame.instance().closeDelete_Info_Dialog();				
							MainFrame.instance().openDeleteinfo_Manager(jtfNum.getText());	
						}						
					}				
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(type.equalsIgnoreCase("Passenger管理模块")){
				try {
					if(jtfNum.getText().equalsIgnoreCase("")){
						JOptionPane.showMessageDialog(null, "请输入完整的信息！", "提示",JOptionPane.ERROR_MESSAGE);
					}
					else{
						Passenger temp = new Passenger();
						int i = 0;
						for(i = 0; i < temp.getkeyinfo().length; i ++){
							if(jtfNum.getText().equalsIgnoreCase(temp.getkeyinfo()[i])){
								break;
							}
						}
						if(i == temp.getkeyinfo().length){
							JOptionPane.showMessageDialog(null, "您选择的信息不存在！", "提示",JOptionPane.ERROR_MESSAGE);	
						}
						else{
							MainFrame.instance().closeDelete_Info_Dialog();				
							MainFrame.instance().openDeleteinfo_Passenger(jtfNum.getText());	
						}						
					}				
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(type.equalsIgnoreCase("Bicycle管理模块")){
				try {
					if(jtfNum.getText().equalsIgnoreCase("")){
						JOptionPane.showMessageDialog(null, "请输入完整的信息！", "提示",JOptionPane.ERROR_MESSAGE);
					}
					else{
						Bike temp = new Bike();
						int i = 0;
						for(i = 0; i < temp.getkeyinfo().length; i ++){
							if(jtfNum.getText().equalsIgnoreCase(temp.getkeyinfo()[i])){
								break;
							}
						}
						if(i == temp.getkeyinfo().length){
							JOptionPane.showMessageDialog(null, "您选择的信息不存在！", "提示",JOptionPane.ERROR_MESSAGE);	
						}
						else{
							MainFrame.instance().closeDelete_Info_Dialog();				
							MainFrame.instance().openDeleteinfo_Bicycle(jtfNum.getText());	
						}						
					}				
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}						
		}else if(e.getSource()==cancel){
			//关闭该面板			
			MainFrame.instance().closeDelete_Info_Dialog();
		}
	}	
}
