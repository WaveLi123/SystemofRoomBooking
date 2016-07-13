package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entities.Bus;
import entities.Employee;
import entities.Transportation;
import entities.Local;
import entities.LongDistance;
import entities.Manager;
import entities.Passenger;
import entities.Route;
import entities_2.Bike;
import frame_manager.ImageButton;
import frame_manager.MainFrame;
import frame_manager.ResultPanel;

public class Update_Info_DialogListener implements ActionListener {
		
	private JTextField jtfNum;
	private JComboBox jcbRoomType;
	private ImageButton ensure ;
	private ImageButton cancel ;
	
	public Update_Info_DialogListener(JTextField jtfNum,JComboBox jcbRoomType, ImageButton ensure, ImageButton cancel) {
		super();		
		this.jtfNum = jtfNum;
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
				try {					
					if(jtfNum.getText().equalsIgnoreCase("")){
						JOptionPane.showMessageDialog(null, "请输入完整的信息！", "提示",JOptionPane.ERROR_MESSAGE);
					}
					else{
						Bus bus = new Bus();
						int i = 0;
						for(i = 0; i < bus.getkeyinfo_bus().length; i ++){
							if(jtfNum.getText().equalsIgnoreCase(bus.getkeyinfo_bus()[i])){
								break;
							}
						}
						if(i == bus.getkeyinfo_bus().length){
							JOptionPane.showMessageDialog(null, "您选择的信息不存在！", "提示",JOptionPane.ERROR_MESSAGE);	
						}
						else{
							MainFrame.instance().closeUpdate_Info_Dialog();
							MainFrame.instance().openUpdateinfo_Bus(jtfNum.getText());	
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
						Route route = new Route();
						int i = 0;
						for(i = 0; i < route.getkeyinfo().length; i ++){
							if(jtfNum.getText().equalsIgnoreCase(route.getkeyinfo()[i])){
								break;
							}
						}
						if(i == route.getkeyinfo().length){
							JOptionPane.showMessageDialog(null, "您选择的信息不存在！", "提示",JOptionPane.ERROR_MESSAGE);	
						}
						else{
							MainFrame.instance().closeUpdate_Info_Dialog();
							MainFrame.instance().openUpdateinfo_Route(jtfNum.getText());	
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
							MainFrame.instance().closeUpdate_Info_Dialog();
							MainFrame.instance().openUpdateinfo_Local(jtfNum.getText());	
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
							MainFrame.instance().closeUpdate_Info_Dialog();
							MainFrame.instance().openUpdateinfo_LongDistance(jtfNum.getText());	
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
							MainFrame.instance().closeUpdate_Info_Dialog();
							MainFrame.instance().openUpdateinfo_Employee(jtfNum.getText());	
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
							MainFrame.instance().closeUpdate_Info_Dialog();
							MainFrame.instance().openUpdateinfo_Manager(jtfNum.getText());	
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
							MainFrame.instance().closeUpdate_Info_Dialog();
							MainFrame.instance().openUpdateinfo_Passenger(jtfNum.getText());	
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
						Bike Bicycle = new Bike();
						int i = 0;
						for(i = 0; i < Bicycle.getkeyinfo().length; i ++){
							if(jtfNum.getText().equalsIgnoreCase(Bicycle.getkeyinfo()[i])){
								break;
							}
						}
						if(i == Bicycle.getkeyinfo().length){
							JOptionPane.showMessageDialog(null, "您选择的信息不存在！", "提示",JOptionPane.ERROR_MESSAGE);	
						}
						else{
							MainFrame.instance().closeUpdate_Info_Dialog();
							MainFrame.instance().openUpdateinfo_Bicycle(jtfNum.getText());	
						}
					}					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}							
		}else if(e.getSource()==cancel){
			//关闭该面板
			MainFrame.instance().closeUpdate_Info_Dialog();
		}
	}	
}
