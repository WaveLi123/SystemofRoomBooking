package frame_employee;


import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import entities.Bus;
import entities.Employee;
import entities.Local;
import entities.LongDistance;
import entities.Manager;
import entities.Passenger;
import entities.Route;
import entities_2.Bike;
import entities_2.Customer;
import listener_3.TableListener;

public class MainReslutPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4090036947302273308L;
	private static MainReslutPanel mainPanel;
	private DataTable table;
	private JScrollPane jscrolPane;
	private String dataType;

	public static MainReslutPanel instance() {
		if (mainPanel == null)
			mainPanel = new MainReslutPanel();
		return mainPanel;
	}

	public MainReslutPanel() {
		mainPanel = this;
		setOpaque(false);
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(0, 0, 5,5));
		table = new DataTable(null, null);
		jscrolPane = new JScrollPane();
		jscrolPane.setBorder(null);
		jscrolPane.setOpaque(false);
		jscrolPane.getViewport().setOpaque(false);
		add(jscrolPane);
	//	showCustomerData();
	}

	@Override
	public void paint(Graphics g) {
		ImageIcon icon = new ImageIcon(this.getClass().getResource(
				"/image/scrollpane.png"));
		Image img = icon.getImage();
		g.drawImage(img, jscrolPane.getX(), jscrolPane.getY(),
				jscrolPane.getWidth(), jscrolPane.getHeight(), this);
		super.paint(g);
	}

	public DataTable getTable() {
		return table;
	}

		public void showData(Object[][] data, Object[] head) {
		table.removeAll();
		table = new DataTable(data, head);
		jscrolPane.setViewportView(table);
	}

	//added by jkd,4st Jan in 2014
	public void showBusData() throws ClassNotFoundException, SQLException { 
		dataType = "BusData";
		Object[] head = { "锟斤拷锟斤拷","锟斤拷锟�","锟斤拷位锟斤拷","锟斤拷路锟斤拷锟�"};
		Bus bus = new Bus();
		showData(bus.getAllBusData(), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
	public void showBicycleData() throws ClassNotFoundException, SQLException { 
		dataType = "BicycleData";
		Object[] head = { "ID","锟角凤拷占锟斤拷","锟斤拷锟斤拷","锟斤拷锟斤拷锟�","锟斤拷锟斤拷"};
		Bike bike = new Bike();
		showData(bike.getAllData(), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
	public void showRouteData() throws ClassNotFoundException, SQLException { 
		dataType = "RouteData";
		Object[] head = { "ID","始锟斤拷站","锟秸碉拷站","锟斤拷站锟斤拷","锟斤拷锟斤拷时锟斤拷"};
		Route route = new Route();
		showData(route.getAllData(), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
	public void showLocalData() throws ClassNotFoundException, SQLException { 
		dataType = "LocalData";
		Object[] head = { "ID","始锟斤拷站","锟秸碉拷站","锟斤拷站锟斤拷","锟斤拷锟斤拷时锟斤拷","路锟教筹拷锟斤拷","锟斤拷路锟斤拷锟�"};
		Local local = new Local();
		showData(local.getAllData(), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
	public void showLongDistanceData() throws ClassNotFoundException, SQLException { 
		dataType = "LongDistanceData";
		Object[] head = { "ID","始锟斤拷站","锟秸碉拷站","锟斤拷站锟斤拷","锟斤拷锟斤拷时锟斤拷","始锟斤拷时锟斤拷","末锟斤拷时锟斤拷"};
		LongDistance ld = new LongDistance();
		showData(ld.getAllData(), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
	public void showEmployeeData() throws ClassNotFoundException, SQLException { 
		dataType = "EmployeeData";
		Object[] head = { "ID","锟斤拷锟斤拷","锟斤拷锟街わ拷锟�","锟斤拷锟斤拷","薪水","锟斤拷锟斤拷锟斤拷锟斤拷"};
		Employee ep = new Employee();
		showData(ep.getAllData(), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
	public void showPassengerData() throws ClassNotFoundException, SQLException { 
		dataType = "Passenger";
		Object[] head = { "ID","锟斤拷锟斤拷","锟皆憋拷","锟斤拷锟斤拷","锟斤拷注"};
		Passenger pas = new Passenger();
		showData(pas.getAllData(), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
	public void showManagerData() throws ClassNotFoundException, SQLException { 
		dataType = "ManagerData";
		Object[] head = { "ID","锟斤拷锟斤拷","锟斤拷锟街わ拷锟�","锟斤拷锟斤拷","薪水","锟斤拷锟斤拷锟斤拷锟斤拷","锟斤拷锟斤拷锟斤拷锟斤拷","锟斤拷锟杰诧拷锟斤拷","职锟斤拷"};
		Manager manager = new Manager();
		showData(manager.getAllData(), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
	//added by WaveLi,28st Feb in 2015
	//客人入住登记报表
	public void showRoom_InData() throws ClassNotFoundException, SQLException { 
		dataType = "Room_InData";
		Object[] head = {"姓名","性别","电话号码","房号","预定类型","预计居住天数","住房时间","退房时间","押金" };
		showData(Customer.getAllData(), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
	//每日到达的报表
	public void showRoom_LiveData() throws ClassNotFoundException, SQLException { 
		dataType = "Room_LiveData";
		Object[] head = {"姓名","性别","电话号码","房号","预定类型","预计居住天数","住房时间","退房时间","押金" };
		showData(Customer.getDataToday(), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
	//每日入住的报表
	public void showRewardsData() throws ClassNotFoundException, SQLException { 
		dataType = "RewardsData";
		Object[] head = {"姓名","性别","电话号码","房号","预定类型","预计居住天数","住房时间","退房时间","押金" };
		showData(Customer.getAllData(), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
	public void showFineData() throws ClassNotFoundException, SQLException { 
		dataType = "FineData";
		Object[] head = {"姓名","电话号码","预定类型","预定日期","罚金","罚款时间"};
		showData(Customer.getAllFineData(Customer.getallfine()), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
}
//	String customname;
//String phonenumber;
//String roomType;
//String ProOrderTime;
//float FinePrice;
//String FineDate;