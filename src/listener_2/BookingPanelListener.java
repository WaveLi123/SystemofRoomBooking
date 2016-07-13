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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dao.AdressData;
import entities_2.Transport_B;
import entities_2.Bike;
import frame_2.ImageButton;
import frame_2.MainFrame_2;
import frame_2.ResultPanel;

public class BookingPanelListener implements ActionListener{

	private JTextField jtfName,jtfAge,jtfPhoneNum,jtfIdNum,jtfHomeAdress,jtfWordPlace,jtfDeposit;
	private JComboBox jtfRoomId;
	private JRadioButton jrbMal,jrbFamel;
	private JComboBox jcbProvince;
	private JComboBox jcbCity;
	private JComboBox jcbCountry;
	private JComboBox jcbRoomType;
	private ImageButton bt_back;
	private ImageButton bt_cancel;
	private ImageButton bt_ok;
	
	private JComboBox jcbYear;
	private JComboBox jcbMonth;
	private JComboBox jcbDay;
	
	private JComboBox jcbYear_leave;
	private JComboBox jcbMonth_leave;
	private JComboBox jcbDay_leave;
	private JComboBox jcbLiveDays;
	private ImageButton refresh;
	SimpleDateFormat sdf;
	public BookingPanelListener(JTextField jtfName, JTextField jtfAge,
			JTextField jtfPhoneNum, JTextField jtfIdNum,
			JTextField jtfHomeAdress, JTextField jtfWordPlace,
			JComboBox jtfRoomId, JTextField jtfDeposit, JRadioButton jrbMal,
			JRadioButton jrbFamel, JComboBox jcbProvince, JComboBox jcbCity,
			JComboBox jcbCountry, JComboBox jcbRoomType, ImageButton bt_back,
			ImageButton bt_cancel, ImageButton bt_ok, JComboBox jcbYear,
			JComboBox jcbMonth, JComboBox jcbDay, JComboBox jcbYear_leave,
			JComboBox jcbMonth_leave, JComboBox jcbDay_leave,
			JComboBox jcbLiveDays,ImageButton refresh) {
		super();
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		this.jtfName = jtfName;
		this.jtfAge = jtfAge;
		this.jtfPhoneNum = jtfPhoneNum;
		this.jtfIdNum = jtfIdNum;
		this.jtfHomeAdress = jtfHomeAdress;
		this.jtfWordPlace = jtfWordPlace;
		this.jtfRoomId = jtfRoomId;
		this.jtfDeposit = jtfDeposit;
		this.jrbMal = jrbMal;
		this.jrbFamel = jrbFamel;
		this.jcbProvince = jcbProvince;
		this.jcbCity = jcbCity;
		this.jcbCountry = jcbCountry;
		this.jcbRoomType = jcbRoomType;
		this.bt_back = bt_back;
		this.bt_cancel = bt_cancel;
		this.bt_ok = bt_ok;
		this.jcbYear = jcbYear;
		this.jcbMonth = jcbMonth;
		this.jcbDay = jcbDay;
		this.jcbYear_leave = jcbYear_leave;
		this.jcbMonth_leave = jcbMonth_leave;
		this.jcbDay_leave = jcbDay_leave;
		this.jcbLiveDays = jcbLiveDays;
		this.refresh=refresh;
		//设置两个ComboBox组的内容
		setJcbProvinceItem();
		defaultSetting();
		ChangeLeaveTimeData();			
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == bt_back) {
			try {
				MainFrame_2.instance().closeBookingPanel();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource()==jcbProvince){
			setJcbCityItem(jcbProvince.getSelectedIndex());
			jcbCity.repaint();
		}else if(e.getSource()==jcbCity){
			setJcbCountryItem((String)jcbCity.getSelectedItem() );
			jcbCountry.repaint();
		}else if(e.getSource()==jcbMonth){
			UpdateDayData(0);
			ChangeLeaveTimeData();
		}else if(e.getSource()==jcbYear){
			UpdateDayData(0);
			ChangeLeaveTimeData();
		}else if(e.getSource()==jcbDay){
			ChangeLeaveTimeData();
		}else if(e.getSource()==jcbMonth_leave){
			UpdateDayData(1);
		}else if(e.getSource()==jcbYear_leave){
			UpdateDayData(1);
		}else if(e.getSource()==jcbLiveDays){
			ChangeLeaveTimeData();
		}else if(e.getSource()==refresh){
			reset();
		}else if(e.getSource()==bt_cancel){
			try {
				MainFrame_2.instance().closeBookingPanel();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource()==jcbRoomType){
			Bike room = null;
			String roomId =Integer.toString(room.getRoomId());		
		}else if(e.getSource()==bt_ok){
			if(jtfName.getText().equals("") ||
				jtfAge.getText().equals("")||
				jtfPhoneNum.getText().equals("")||
				jtfIdNum.getText().equals("")||
				jtfHomeAdress.getText().equals("")||
				jtfWordPlace.getText().equals("")||
				jtfRoomId.getSelectedItem().equals("")||
				jtfDeposit.getText().equals("")||!(jrbMal.isSelected()||jrbFamel.isSelected())){
				JOptionPane.showMessageDialog(null, "请输入完整的信息！", "提示",
						JOptionPane.ERROR_MESSAGE);
			}else{
				String name =jtfName.getText();
				String idNum=jtfIdNum.getText();
				String workplace =jtfWordPlace.getText();
				String adress = jtfHomeAdress.getText();
				String placeFrom = jcbProvince.getSelectedItem().toString()+jcbCity.getSelectedItem().toString()+jcbCountry.getSelectedItem().toString();
				String sex =jrbMal.isSelected()?"男":"女";
				Date takeRoomTime =comboBoxDataToDate(jcbYear,jcbMonth,jcbDay);
				Date leaveTime =comboBoxDataToDate(jcbYear_leave,jcbMonth_leave,jcbDay_leave);
				int age = Integer.parseInt(jtfAge.getText());
				int liveDays =Integer.parseInt(jcbLiveDays.getSelectedItem().toString());
			
				double deposit =Double.parseDouble(jtfDeposit.getText());
				int roomId =Integer.parseInt((String)jtfRoomId.getSelectedItem());
				String roomTypeId =jcbRoomType.getSelectedItem().toString();
				String phone =jtfPhoneNum.getText();
				/*public void orderRoom(String name, String idNumber, String workplace,
						String placeForm, String home_adress, String sex,
						Date takeRomTime, Date leaveTime, int age, int liveDays,
	double deposit,int roomId,int roomTypeId,String phoneNum) */
				//检查 信息是否正确
				boolean isRoomExits = false;
				try {
					isRoomExits = Bike.isRoomExsits(jcbRoomType.getSelectedIndex()+1, roomId);
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}				
				System.out.println("isRoomExits :" +isRoomExits);
				if(!isRoomExits){
					JOptionPane.showMessageDialog(null, "房号不存在或者已经被预定", "提示",
							JOptionPane.ERROR_MESSAGE);
				}else{
				//调用录入的 方法
				try {
					Transport_B.instance().orderRoom(name, idNum, workplace, placeFrom, adress, sex, takeRoomTime, leaveTime, age, liveDays, deposit, roomId, roomTypeId, phone);
					ResultPanel.instance().showAllCustomerBasicalData();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				reset();
				}
			}
		}
	}
	
	public void reset(){
		jtfName.setText("");
		jtfAge.setText("");
		jtfPhoneNum.setText("");
		jtfIdNum.setText("");
		jtfHomeAdress.setText("");
		jtfWordPlace.setText("");
		jtfDeposit.setText("");
		String roomId = null;
		jtfRoomId.setSelectedItem(roomId);
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
///////////////////////////////////////////////////////////
	//与 SearchPanelListener 里面的代码相同 暂时不考虑整理，重用性有点差
	public void setJcbProvinceItem(){
		jcbProvince.removeAllItems();
		jcbCountry.removeAllItems();
		jcbCity.removeAllItems();
		Object[] provinceData =AdressData.instance().getPrivinceData();
		for(int i=0;i<provinceData.length;i++)
			jcbProvince.addItem(provinceData[i]);
	}
	
	public void setJcbCityItem(int id){
		jcbCountry.removeAllItems();
		jcbCity.removeAllItems();
		Object[] cityData =AdressData.instance().getCityDataById(id);
			for(int i=0;i<cityData.length;i++)
				jcbCity.addItem(cityData[i]);
			jcbCity.repaint();	
	}
	public void setJcbCountryItem(String name){

		jcbCountry.removeAllItems();
		Object[] CountryData =AdressData.instance().getCountryDataByCityName(name);
		
		for(int i=0;i<CountryData.length;i++)
			jcbCountry.addItem(CountryData[i]);
		
		jcbCountry.repaint();
	}
///////////////////////////////////////////////////////////////

	public void defaultSetting(){
		
		//初始化 liveDays
		
		for(int i =1 ;i<=30;i++){
			jcbLiveDays.addItem(i);
		}
		///////////////////////////////////
		
		
		Calendar cal=Calendar.getInstance();    
		for(int i = 2050; i>1940; i--) { 
			jcbYear.addItem(i);  
			jcbYear_leave.addItem(i);
		}
		for(int i = 1; i<=12; i++){  
			jcbMonth.addItem(i);
			jcbMonth_leave.addItem(i);
		}
		jcbYear.setSelectedItem(cal.get(Calendar.YEAR));
		jcbMonth.setSelectedItem(cal.get(Calendar.MONTH)+1);
		jcbDay.addItem(cal.get(Calendar.DATE));
		
		int days =getDayByYearAndMonth(Integer.parseInt(jcbYear.getSelectedItem().toString()),Integer.parseInt(jcbMonth.getSelectedItem().toString())) ; 
		for(int i=1;i<=days;i++){
			jcbDay.addItem(i);
			jcbDay_leave.addItem(i);
		}
		jcbDay.setSelectedItem(cal.get(Calendar.DATE));
		
	}
	
	public void ChangeLeaveTimeData(){		 	
		Object Oyear =jcbYear.getSelectedItem();
		Object OMonth =jcbMonth.getSelectedItem();
		Object Oday =jcbDay.getSelectedItem();
		if(Oyear!=null&&OMonth!=null&&Oday!=null){
			String year =Oyear.toString();
			String Month =OMonth.toString();
			String day =Oday.toString();
		Calendar cal=Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(year+"-"+Month+"-"+day));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jcbYear_leave.removeAllItems();
		jcbMonth_leave.removeAllItems();
		jcbDay_leave.removeAllItems();
		int minYear =Integer.parseInt(jcbYear.getSelectedItem().toString());
		for(int i = 2050; i>=minYear; i--) { 
			jcbYear_leave.addItem(i);
		}
		for(int i = 1; i<=12; i++){  
			jcbMonth_leave.addItem(i);
		}	
		int days =getDayByYearAndMonth(Integer.parseInt(jcbYear_leave.getSelectedItem().toString()),Integer.parseInt(jcbMonth_leave.getSelectedItem().toString())) ; 
		for(int i=1;i<=days;i++){
			jcbDay_leave.addItem(i);
		}
		cal.add(Calendar.DATE, Integer.parseInt(jcbLiveDays.getSelectedItem().toString()));
		jcbYear_leave.setSelectedItem(cal.get(Calendar.YEAR));
		jcbMonth_leave.setSelectedItem(cal.get(Calendar.MONTH)+1);
		jcbDay_leave.setSelectedItem(cal.get(Calendar.DATE));
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
	
	public void UpdateDayData(int flag){
		if(flag==0){
		jcbDay.removeAllItems();
		int days =getDayByYearAndMonth(Integer.parseInt(jcbYear.getSelectedItem().toString()),Integer.parseInt(jcbMonth.getSelectedItem().toString())) ; 
	
		for(int i=1;i<=days;i++)
			jcbDay.addItem(i);
		}else{
			jcbDay_leave.removeAllItems();
			Object Oyear =jcbYear_leave.getSelectedItem();
			Object OMonth =jcbMonth_leave.getSelectedItem();
			if(Oyear!=null&&OMonth!=null){
			int year=Integer.parseInt(Oyear.toString());
			int month=Integer.parseInt(OMonth.toString());
	
			int days =getDayByYearAndMonth(year,month); 
		//	System.out.println(days+" ");
			for(int i=1;i<=days;i++)
				jcbDay_leave.addItem(i);
			}
		}
	}
	
}
