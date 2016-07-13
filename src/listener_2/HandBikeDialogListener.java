package listener_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entities_2.Customer;
import entities_2.Bike;
import frame_2.ImageButton;
import frame_2.MainFrame_2;
import frame_2.ResultPanel;

public class HandBikeDialogListener implements ActionListener{
	
	private JTextField jtfRoomID;
	private JComboBox jcbYear;
	private JComboBox jcbMonth;
	private JComboBox jcbDay;
	private JCheckBox jchBisAdvance;
	ImageButton ensure ;
	ImageButton cancel ;
	SimpleDateFormat sdf;
	public HandBikeDialogListener(JTextField jtfRoomID,JComboBox jcbYear,JComboBox jcbMonth,JComboBox jcbDay,
					JCheckBox jchBisAdvance,ImageButton ensure,
						ImageButton cancel ) {
		super();
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		this.jtfRoomID = jtfRoomID;
		this.jcbYear = jcbYear;
		this.jcbMonth = jcbMonth;
		this.jcbDay = jcbDay;
		this.jchBisAdvance=jchBisAdvance;
		this.ensure = ensure;
		this.cancel = cancel;
		
		Calendar cal=Calendar.getInstance();    
		for(int i = 2050; i>1940; i--)  
			jcbYear.addItem(i);  
		for(int i = 1; i<=12; i++)  
			jcbMonth.addItem(i); 
		
		jcbYear.setSelectedItem(cal.get(Calendar.YEAR));
		jcbMonth.setSelectedItem(cal.get(Calendar.MONTH)+1);
		jcbDay.addItem(cal.get(Calendar.DATE));
		int days =getDayByYearAndMonth(Integer.parseInt(jcbYear.getSelectedItem().toString()),Integer.parseInt(jcbMonth.getSelectedItem().toString())) ; 
		for(int i=1;i<=days;i++)
			jcbDay.addItem(i);
		
		jcbDay.setSelectedItem(cal.get(Calendar.DATE));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jcbMonth){
			UpdateDayData();
		}else if(e.getSource()==jcbYear){
			UpdateDayData();
		}else if(e.getSource()==ensure){
			try {
				handRoomAndPay();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				MainFrame_2.instance().closeHandRoomDialog();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource()==cancel){
			try {
				MainFrame_2.instance().closeHandRoomDialog();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource()==jchBisAdvance){
			if(jchBisAdvance.isSelected()){
				jcbYear.setEnabled(true);
				jcbMonth.setEnabled(true);
				jcbDay.setEnabled(true);
			}else{
				jcbYear.setEnabled(false);
				jcbMonth.setEnabled(false);
				jcbDay.setEnabled(false);
			}
		}
	}

	//退房结账	
	private void handRoomAndPay() throws ClassNotFoundException, SQLException {
		String roomId = jtfRoomID.getText();
		Date leaveTime =comboBoxDataToDate(jcbYear,jcbMonth,jcbDay);				
		//查询该房号是否被订出
		String temp[] = Customer.getinfo(roomId);
		if(temp[0]==null){
			JOptionPane.showMessageDialog(null, "房号不存在", "提示",
					JOptionPane.ERROR_MESSAGE);
		}
		//先找到客户信息
		ResultPanel.instance().ShowCustomerDataByRoomId(roomId);
		Date bookTime = parse(temp[7], "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
		long day = (leaveTime.getTime()-bookTime.getTime())/(24*60*60*1000);		
		float perprice = Integer.parseInt(Bike.getinfo(roomId)[4]);		
		
		//int days = temp[]
		if(JOptionPane.showConfirmDialog(null, "确定执行退房操作？", "消息",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){					
				JOptionPane.showMessageDialog(null," 总费用："+day*perprice+" 天数："+day+ "元/天："+perprice, "提示",
						JOptionPane.CLOSED_OPTION);				
				//删除销售记录中的相关信息
				Customer.deleteDB(roomId);
				//更新房间信息
				Bike bike = new Bike(Integer.parseInt(roomId),false,"常规预定","null","200");
				bike.updateDB();
				
		}
	}
	public  int getDayByYearAndMonth(int year,int month)  
    {  
        if(month==2)   
            if((year%4==0&&year%100!=0)||(year%100==0&&year%400==0))  
                return 29;  
            else return 28;  
        else if(month==1 || month==3  || month==5 || month==7 || month==8 || month==10 || month==12)  
            return 31;  
        else return 30;       
    }  
	
	public void UpdateDayData(){
		jcbDay.removeAllItems();
		int days =getDayByYearAndMonth(Integer.parseInt(jcbYear.getSelectedItem().toString()),Integer.parseInt(jcbMonth.getSelectedItem().toString())) ; 
	
		for(int i=1;i<=days;i++)
			jcbDay.addItem(i);
	}
	
	public Date comboBoxDataToDate(JComboBox jcbYear,JComboBox jcbMonth, JComboBox jcbDay){
		Object Oyear =jcbYear.getSelectedItem();
		Object OMonth =jcbMonth.getSelectedItem();
		Object Oday =jcbDay.getSelectedItem();
		Date newDate=null;
	if(Oyear!=null&&OMonth!=null&&Oday!=null){
		String year =Oyear.toString();
		String Month =OMonth.toString();
		String day =Oday.toString();
	
		try {
			newDate = sdf.parse(year+"-"+Month+"-"+day);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		}
	return newDate;
	}
	//形如Mon Dec 31 00:00:00 CST 2012字符串转换为相应日期Date 
	public static Date parse(String str, String pattern, Locale locale) { 
		if(str == null || pattern == null) { 
		    return null; 
		} 
		try { 
		    return new SimpleDateFormat(pattern, locale).parse(str); 
		} catch (ParseException e) { 
		    e.printStackTrace(); 
		} 
		return null; 
	} 
// 
	public static String format(Date date, String pattern, Locale locale) { 
	    if(date == null || pattern == null) { 
	        return null; 
	    } 
	    return new SimpleDateFormat(pattern, locale).format(date); 
	} 	

}
