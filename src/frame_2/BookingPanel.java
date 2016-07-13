package frame_2;

import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import listener_2.BookingPanelListener;
import dao.BikeTypeData;
import entities_2.Bike;

public class BookingPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2756889947124466169L;
	private static BookingPanel bookingPanel;
	private JTextField jtfName,jtfAge,jtfPhoneNum,jtfIdNum,jtfHomeAdress,jtfWordPlace,jtfDeposit;
	JComboBox jtfRoomId;
	private JRadioButton jrbMal,jrbFamel;
	private JComboBox jcbProvince;
	private JComboBox jcbCity;
	private JComboBox jcbCountry;
	private JComboBox jcbRoomType;
	private JLabel bg;
	private ImageButton bt_back;
	private ImageButton bt_cancel;
	private ImageButton bt_ok;
	private ImageButton refresh;
	private JComboBox jcbYear;
	private JComboBox jcbMonth;
	private JComboBox jcbDay;
	
	private JComboBox jcbYear_leave;
	private JComboBox jcbMonth_leave;
	private JComboBox jcbDay_leave;
	private JComboBox jcbLiveDays;
	
	
	public BookingPanel() throws Exception, SQLException{
		ImageIcon bgIcon =new ImageIcon(this.getClass().getResource("/image/bookingPanel_bg.png"));
		bt_back=new ImageButton("back");
		bt_cancel=new ImageButton("cancel");
		bt_ok= new ImageButton("ok");
		bg=new JLabel(bgIcon);
		jrbMal=new JRadioButton();
		jrbFamel=new JRadioButton();
		jtfName=new JTextField();
		jtfAge=new JTextField();
		jtfPhoneNum=new JTextField();
		jtfIdNum=new JTextField();
		jtfHomeAdress=new JTextField();
		jtfWordPlace=new JTextField();
//		jtfRoomId=new JTextField();
		
		Bike bike = new Bike();
		String[] choice = bike.getkeyinfo(); 
		jtfRoomId=new JComboBox(choice);
		
		jtfDeposit=new JTextField();
		jcbProvince =new JComboBox();
		jcbCity =new JComboBox();
		jcbCountry =new JComboBox();
		refresh =new ImageButton("refresh");
//		Object[] roomType =BikeTypeData.instance().FormatRoomTypeName();
		String[] roomType = {"常规预定","奖励预定","提前60天预定","预付金预定"};		
		jcbRoomType =new JComboBox(roomType);
		
		jcbYear=new JComboBox();
		jcbMonth=new JComboBox();
		jcbDay=new JComboBox();
		jcbLiveDays =new JComboBox();
		
		jcbYear_leave=new JComboBox();
		jcbMonth_leave=new JComboBox();
		jcbDay_leave=new JComboBox();

		ButtonGroup buttonGroup = new ButtonGroup();
		
		buttonGroup.add(jrbFamel);
		buttonGroup.add(jrbMal);
		jcbProvince.setOpaque(false);
		jcbCity.setOpaque(false);
		jcbCountry.setOpaque(false);
		jcbRoomType.setOpaque(false);
		
		jrbMal.setOpaque(false);
		jrbFamel.setOpaque(false);
		bg.setOpaque(false);
		/*
		jtfName.setOpaque(false);
		jtfAge.setOpaque(false);
		jtfPhoneNum.setOpaque(false);
		jtfIdNum.setOpaque(false);
		jtfHomeAdress.setOpaque(false);
		jtfWordPlace.setOpaque(false);
		jtfRoomId.setOpaque(false);
		jtfDeposit.setOpaque(false);
		*/
		
		bg.setBounds(0, 0, 377, 777);
		bt_back.setBounds(300, 13, 48, 48);
		bt_cancel.setBounds(308, 594, 48, 48);
		bt_ok.setBounds(248,594,48,48);
		jtfName.setBounds(79, 122, 105, 22);
		jtfAge.setBounds(79, 157, 50, 22);
		jtfPhoneNum.setBounds(110, 187, 150, 22);
		jtfIdNum.setBounds(129, 219, 200, 22);
		jtfHomeAdress.setBounds(109, 289, 200, 22);
		jtfWordPlace.setBounds(109,320, 200, 22);
		jtfRoomId.setBounds(92, 451, 50, 22);
		jtfDeposit.setBounds(111,523, 50, 22);
		
		jcbProvince.setBounds(95,255, 70, 22);
		jcbCity.setBounds(170,255,70, 22);
		jcbCountry.setBounds(245,255, 70, 22);
		jcbRoomType.setBounds(114,420, 70, 22);
		
		jrbMal.setBounds(244, 125, 23, 20);
		jrbFamel.setBounds(304, 125, 23, 20);
		
		jcbYear.setBounds(114,354,60,20);
		jcbMonth.setBounds(200,354,50,20);
		jcbDay.setBounds(280,354,50,20);
		jcbLiveDays.setBounds(150, 388, 60, 20);
		
		jcbYear_leave.setBounds(114,488,60,20);
		jcbMonth_leave.setBounds(200,488,50,20);
		jcbDay_leave.setBounds(280,488,50,20);
		refresh.setBounds(300, 75, 48, 48);
		this.setOpaque(false);
		this.setLayout(null);
		this.setSize(377,777);
		this.setVisible(false);
		
		add(refresh);
		add(jcbYear_leave);
		add(jcbMonth_leave);
		add(jcbDay_leave);
		
		add(jcbLiveDays);
		add(jcbYear);
		add(jcbMonth);
		add(jcbDay);
		
		add(jcbProvince);
		add(jcbCity);
		add(jcbCountry);
		add(jcbRoomType);
		add(jrbMal);
		add(jrbFamel);
		add(jtfDeposit);
		add(jtfName);
		add(jtfAge);
		add(jtfPhoneNum);
		add(jtfIdNum);
		add(jtfHomeAdress);
		add(jtfWordPlace);
		add(jtfRoomId);
		add(bt_cancel);
		add(bt_ok);
		add(bt_back);
		add(bg);
		InputLimited n1 = new InputLimited(11, true);// 长度为11，且只能输入数字
		jtfPhoneNum.setDocument(n1);
		InputLimited n2 = new InputLimited(2, true);// 长度为3，且只能输入数字
		jtfAge.setDocument(n2);
		InputLimited n3 = new InputLimited(18, true);// 长度为18，且只能输入数字
		jtfIdNum.setDocument(n3);
		InputLimited n4 = new InputLimited(4, true);// 长度为4，且只能输入数字
//		jtfRoomId.setDocument(n4);
		InputLimited n5 = new InputLimited(4, true);// 长度为4，且只能输入数字
		jtfDeposit.setDocument(n5);
		addListener();		
	}
	
	public void  addListener(){
		BookingPanelListener bookingPanelListener=new BookingPanelListener(jtfName, jtfAge,
				jtfPhoneNum, jtfIdNum,
				jtfHomeAdress, jtfWordPlace,
				jtfRoomId,  jtfDeposit,  jrbMal,
				jrbFamel, jcbProvince,  jcbCity,
				 jcbCountry,  jcbRoomType,  bt_back,
				 bt_cancel,  bt_ok,  jcbYear,
				 jcbMonth,  jcbDay,  jcbYear_leave,
				 jcbMonth_leave,  jcbDay_leave,
				 jcbLiveDays,refresh);
		jcbProvince.addActionListener(bookingPanelListener);
		bt_back.addActionListener(bookingPanelListener);
		bt_cancel.addActionListener(bookingPanelListener);
		bt_ok.addActionListener(bookingPanelListener);
		jcbProvince.addActionListener(bookingPanelListener);
		jcbCity.addActionListener(bookingPanelListener);
		jcbCountry.addActionListener(bookingPanelListener);
		jcbRoomType.addActionListener(bookingPanelListener);
		jcbYear.addActionListener(bookingPanelListener);
		jcbMonth.addActionListener(bookingPanelListener);
		jcbDay.addActionListener(bookingPanelListener);
		jcbLiveDays.addActionListener(bookingPanelListener);
		
		jcbYear_leave.addActionListener(bookingPanelListener);
		jcbMonth_leave.addActionListener(bookingPanelListener);
		jcbDay_leave.addActionListener(bookingPanelListener);
		refresh.addActionListener(bookingPanelListener);
	}
	public static BookingPanel instance() throws SQLException, Exception{
		if(bookingPanel==null)
			bookingPanel=new BookingPanel();
		return bookingPanel;		
	}

	public void setDefaultInfo(String name,String phoneNum){
		jtfName.setText(name);
		jtfPhoneNum.setText(phoneNum);
	}	
}
