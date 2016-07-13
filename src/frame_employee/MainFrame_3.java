package frame_employee;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;



public class MainFrame_3 extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MainFrame_3 mainFrame ;
	private static ImageButton bt_close;
	private static MenuGroupPanel menuPanel;
	private AccountNamePanel namePanel;
	private static ResultPanel resultPanel;

//	
	//added by jkd, 2nd Jan in 2014
	private static Add_Info_Dialog add_info_dialog;
	private static Update_Info_Dialog update_info_dialog;
	private static Delete_Info_Dialog delete_info_dialog;
	private static Select_Info_Dialog select_info_dialog;
	
	private static Addinfo_Bus addinfo_bus;
	private static Updateinfo_Bus updateinfo_bus;
	private static Deleteinfo_Bus deleteinfo_bus;
	
	private static Addinfo_Bicycle addinfo_Bicycle;
	private static Updateinfo_Bicycle updateinfo_Bicycle;
	private static Deleteinfo_Bicycle deleteinfo_Bicycle;
	
	private static Addinfo_Route addinfo_Route;
	private static Updateinfo_Route updateinfo_Route;
	private static Deleteinfo_Route deleteinfo_Route;

	private static Addinfo_Local addinfo_Local;
	private static Updateinfo_Local updateinfo_Local;
	private static Deleteinfo_Local deleteinfo_Local;
	
	private static Addinfo_LongDistance addinfo_LongDistance;
	private static Updateinfo_LongDistance updateinfo_LongDistance;
	private static Deleteinfo_LongDistance deleteinfo_LongDistance;
	
	private static Addinfo_Manager addinfo_Manager;
	private static Updateinfo_Manager updateinfo_Manager;
	private static Deleteinfo_Manager deleteinfo_Manager;
	
	private static Addinfo_Passenger addinfo_Passenger;
	private static Updateinfo_Passenger updateinfo_Passenger;
	private static Deleteinfo_Passenger deleteinfo_Passenger;
	
	private static Addinfo_Employee addinfo_Employee;
	private static Updateinfo_Employee updateinfo_Employee;
	private static Deleteinfo_Employee deleteinfo_Employee;
	
	public MainFrame_3(){
		setTitle("������Ϣ����ϵͳ");
		mainFrame = this;
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setMinimumSize(new Dimension(1024, 768));		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(this.getClass().getResource(
				"/image/icon.png")).getImage());
		
		
		namePanel=new AccountNamePanel();
		bt_close= new ImageButton("bt_close");
		menuPanel= new MenuGroupPanel();
		resultPanel =ResultPanel.instance();

		//added by jkd, 2nd Jan in 2014
		add_info_dialog = new Add_Info_Dialog();
		update_info_dialog = new Update_Info_Dialog();
		delete_info_dialog = new Delete_Info_Dialog();
		select_info_dialog = new Select_Info_Dialog();
		
		addinfo_bus = new Addinfo_Bus();
		updateinfo_bus = new Updateinfo_Bus();
		deleteinfo_bus = new Deleteinfo_Bus();
		
		addinfo_Bicycle = new Addinfo_Bicycle();
		updateinfo_Bicycle = new Updateinfo_Bicycle();
		deleteinfo_Bicycle = new Deleteinfo_Bicycle();
		
		addinfo_Employee = new Addinfo_Employee();
		updateinfo_Employee = new Updateinfo_Employee();
		deleteinfo_Employee = new Deleteinfo_Employee();
		
		addinfo_Passenger = new Addinfo_Passenger();
		updateinfo_Passenger = new Updateinfo_Passenger();
		deleteinfo_Passenger = new Deleteinfo_Passenger();
		
		addinfo_Manager = new Addinfo_Manager();
		updateinfo_Manager = new Updateinfo_Manager();
		deleteinfo_Manager = new Deleteinfo_Manager();
		
		addinfo_Route = new Addinfo_Route();
		updateinfo_Route = new Updateinfo_Route();
		deleteinfo_Route = new Deleteinfo_Route();
		
		addinfo_Local = new Addinfo_Local();
		updateinfo_Local = new Updateinfo_Local();
		deleteinfo_Local = new Deleteinfo_Local();
		
		addinfo_LongDistance = new Addinfo_LongDistance();
		updateinfo_LongDistance = new Updateinfo_LongDistance();
		deleteinfo_LongDistance = new Deleteinfo_LongDistance();
		
		//added by jkd , 2nd Jan in 2014
		add(add_info_dialog);
		add(update_info_dialog);
		add(delete_info_dialog);
		add(select_info_dialog);
		
		add(addinfo_bus);
		add(updateinfo_bus);
		add(deleteinfo_bus);
		
		add(addinfo_Bicycle);
		add(updateinfo_Bicycle);
		add(deleteinfo_Bicycle);
		
		add(addinfo_Employee);
		add(updateinfo_Employee);
		add(deleteinfo_Employee);
		
		add(addinfo_Passenger);
		add(updateinfo_Passenger);
		add(deleteinfo_Passenger);
		
		add(addinfo_Manager);
		add(updateinfo_Manager);
		add(deleteinfo_Manager);
		
		add(addinfo_Route);
		add(updateinfo_Route);
		add(deleteinfo_Route);
		
		add(addinfo_Local);
		add(updateinfo_Local);
		add(deleteinfo_Local);
		
		add(addinfo_LongDistance);
		add(updateinfo_LongDistance);
		add(deleteinfo_LongDistance);

		add(resultPanel);
		add(namePanel);
		add(bt_close);
		add(menuPanel);		
		setLayout(null);
		//������û��������
		namePanel.setBounds(0, 0,320, 200);
		bt_close.setBounds(getWidth()-130, 40, 76, 80);
		menuPanel.setBounds(this.getWidth()/2-230,this.getHeight()/2-130, 720,260);
		resultPanel.setBounds(getWidth()-994, 0, 996,777);
		//added by jkd,2nd Jan in 2014
		add_info_dialog.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		update_info_dialog.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		delete_info_dialog.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		select_info_dialog.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		
		addinfo_bus.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		updateinfo_bus.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		deleteinfo_bus.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		
		addinfo_Bicycle.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		updateinfo_Bicycle.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		deleteinfo_Bicycle.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		
		addinfo_Employee.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		updateinfo_Employee.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		deleteinfo_Employee.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);

		addinfo_Manager.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		updateinfo_Manager.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		deleteinfo_Manager.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);

		addinfo_Passenger.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		updateinfo_Passenger.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		deleteinfo_Passenger.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);

		addinfo_Route.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		updateinfo_Route.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		deleteinfo_Route.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		
		addinfo_Local.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		updateinfo_Local.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		deleteinfo_Local.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);

		addinfo_LongDistance.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		updateinfo_LongDistance.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		deleteinfo_LongDistance.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		
		((JPanel) this.getContentPane()).setOpaque(false);
		BackgroundPanel background = new BackgroundPanel();
		getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		bt_close.addMouseListener( new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				if(bt_close.getEnabled()){
					System.exit(0);
				}
			}			
		});
	}
	
	
	public static MainFrame_3 instance(){
		if(mainFrame==null)
			mainFrame=new MainFrame_3();
		return mainFrame;
	}
	
	public void showResultPanel(){		
		resultPanel.setVisible(true);
	}
	
	public void closeResultPanel(){
		resultPanel.setVisible(false);
	}
	public void open() {
		setVisible(true);
		LoginFrame.instance().setVisible(false);		
	}

	@Override
	public void run() {
		instance();		
	}

	
//added by jkd, 2nd Jan in 2014
	public void openAdd_Info_Dialog() {
		// TODO Auto-generated method stub
		add_info_dialog.setVisible(true);
		menuPanel.setEnabled(false);
	}
	public void closeAdd_Info_Dialog() {
		// TODO Auto-generated method stub
		add_info_dialog.setVisible(false);
		menuPanel.setEnabled(true);
	}	
	public void openUpdate_Info_Dialog() {
		// TODO Auto-generated method stub
		update_info_dialog.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeUpdate_Info_Dialog() {
		// TODO Auto-generated method stub
		update_info_dialog.setVisible(false);
		menuPanel.setEnabled(true);
	}
	public void openDelete_Info_Dialog() {
		// TODO Auto-generated method stub
		delete_info_dialog.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeDelete_Info_Dialog() {
		// TODO Auto-generated method stub
		delete_info_dialog.setVisible(false);
		menuPanel.setEnabled(true);
	}
	public void openSelect_Info_Dialog(){
		// TODO Auto-generated method stub		
		select_info_dialog.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeSelect_Info_Dialog() {
		// TODO Auto-generated method stub
		select_info_dialog.setVisible(false);
		menuPanel.setEnabled(true);
	}
	//bus
	public void openAddinfo_Bus() {
		// TODO Auto-generated method stub
		addinfo_bus.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeAddinfo_Bus() {
		// TODO Auto-generated method stub
		addinfo_bus.setVisible(false);
		menuPanel.setEnabled(true);
	}
	
	public void openUpdateinfo_Bus(String num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		updateinfo_bus.setDefaultInfo(num);
		updateinfo_bus.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeUpdateinfo_Bus() {
		// TODO Auto-generated method stub
		updateinfo_bus.setVisible(false);
		menuPanel.setEnabled(true);
	}
	public void openDeleteinfo_Bus(String num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		deleteinfo_bus.setDefaultInfo(num);
		deleteinfo_bus.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeDeleteinfo_Bus() {
		// TODO Auto-generated method stub
		deleteinfo_bus.setVisible(false);
		menuPanel.setEnabled(true);
	}
	//bicycle	
	public void openAddinfo_Bicycle() {
		// TODO Auto-generated method stub
		addinfo_Bicycle.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeAddinfo_Bicycle() {
		// TODO Auto-generated method stub
		addinfo_Bicycle.setVisible(false);
		menuPanel.setEnabled(true);
	}
	
	public void openUpdateinfo_Bicycle(String num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		updateinfo_Bicycle.setDefaultInfo(num);
		updateinfo_Bicycle.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeUpdateinfo_Bicycle() {
		// TODO Auto-generated method stub
		updateinfo_Bicycle.setVisible(false);
		menuPanel.setEnabled(true);
	}
	public void openDeleteinfo_Bicycle(String num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		deleteinfo_Bicycle.setDefaultInfo(num);
		deleteinfo_Bicycle.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeDeleteinfo_Bicycle() {
		// TODO Auto-generated method stub
		deleteinfo_Bicycle.setVisible(false);
		menuPanel.setEnabled(true);
	}
	//Employee
	public void openAddinfo_Employee() {
		// TODO Auto-generated method stub
		addinfo_Employee.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeAddinfo_Employee() {
		// TODO Auto-generated method stub
		addinfo_Employee.setVisible(false);
		menuPanel.setEnabled(true);
	}
	
	public void openUpdateinfo_Employee(String num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		updateinfo_Employee.setDefaultInfo(num);
		updateinfo_Employee.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeUpdateinfo_Employee() {
		// TODO Auto-generated method stub
		updateinfo_Employee.setVisible(false);
		menuPanel.setEnabled(true);
	}
	public void openDeleteinfo_Employee(String num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		deleteinfo_Employee.setDefaultInfo(num);
		deleteinfo_Employee.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeDeleteinfo_Employee() {
		// TODO Auto-generated method stub
		deleteinfo_Employee.setVisible(false);
		menuPanel.setEnabled(true);
	}
	//Passenger
	public void openAddinfo_Passenger() {
		// TODO Auto-generated method stub
		addinfo_Passenger.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeAddinfo_Passenger() {
		// TODO Auto-generated method stub
		addinfo_Passenger.setVisible(false);
		menuPanel.setEnabled(true);
	}
	
	public void openUpdateinfo_Passenger(String num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		updateinfo_Passenger.setDefaultInfo(num);
		updateinfo_Passenger.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeUpdateinfo_Passenger() {
		// TODO Auto-generated method stub
		updateinfo_Passenger.setVisible(false);
		menuPanel.setEnabled(true);
	}
	public void openDeleteinfo_Passenger(String num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		deleteinfo_Passenger.setDefaultInfo(num);
		deleteinfo_Passenger.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeDeleteinfo_Passenger() {
		// TODO Auto-generated method stub
		deleteinfo_Passenger.setVisible(false);
		menuPanel.setEnabled(true);
	}
	//Manager
	public void openAddinfo_Manager() {
		// TODO Auto-generated method stub
		addinfo_Manager.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeAddinfo_Manager() {
		// TODO Auto-generated method stub
		addinfo_Manager.setVisible(false);
		menuPanel.setEnabled(true);
	}
	
	public void openUpdateinfo_Manager(String num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		updateinfo_Manager.setDefaultInfo(num);
		updateinfo_Manager.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeUpdateinfo_Manager() {
		// TODO Auto-generated method stub
		updateinfo_Manager.setVisible(false);
		menuPanel.setEnabled(true);
	}
	public void openDeleteinfo_Manager(String num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		deleteinfo_Manager.setDefaultInfo(num);
		deleteinfo_Manager.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeDeleteinfo_Manager() {
		// TODO Auto-generated method stub
		deleteinfo_Manager.setVisible(false);
		menuPanel.setEnabled(true);
	}
	//Route
	public void openAddinfo_Route() {
		// TODO Auto-generated method stub
		addinfo_Route.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeAddinfo_Route() {
		// TODO Auto-generated method stub
		addinfo_Route.setVisible(false);
		menuPanel.setEnabled(true);
	}
	
	public void openUpdateinfo_Route(String num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		updateinfo_Route.setDefaultInfo(num);
		updateinfo_Route.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeUpdateinfo_Route() {
		// TODO Auto-generated method stub
		updateinfo_Route.setVisible(false);
		menuPanel.setEnabled(true);
	}
	public void openDeleteinfo_Route(String num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		deleteinfo_Route.setDefaultInfo(num);
		deleteinfo_Route.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeDeleteinfo_Route() {
		// TODO Auto-generated method stub
		deleteinfo_Route.setVisible(false);
		menuPanel.setEnabled(true);
	}
	//Local
	public void openAddinfo_Local() {
		// TODO Auto-generated method stub
		addinfo_Local.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeAddinfo_Local() {
		// TODO Auto-generated method stub
		addinfo_Local.setVisible(false);
		menuPanel.setEnabled(true);
	}
	
	public void openUpdateinfo_Local(String num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		updateinfo_Local.setDefaultInfo(num);
		updateinfo_Local.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeUpdateinfo_Local() {
		// TODO Auto-generated method stub
		updateinfo_Local.setVisible(false);
		menuPanel.setEnabled(true);
	}
	public void openDeleteinfo_Local(String num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		deleteinfo_Local.setDefaultInfo(num);
		deleteinfo_Local.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeDeleteinfo_Local() {
		// TODO Auto-generated method stub
		deleteinfo_Local.setVisible(false);
		menuPanel.setEnabled(true);
	}
	//LongDistance
	public void openAddinfo_LongDistance() {
		// TODO Auto-generated method stub
		addinfo_LongDistance.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeAddinfo_LongDistance() {
		// TODO Auto-generated method stub
		addinfo_LongDistance.setVisible(false);
		menuPanel.setEnabled(true);
	}
	
	public void openUpdateinfo_LongDistance(String num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		updateinfo_LongDistance.setDefaultInfo(num);
		updateinfo_LongDistance.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeUpdateinfo_LongDistance() {
		// TODO Auto-generated method stub
		updateinfo_LongDistance.setVisible(false);
		menuPanel.setEnabled(true);
	}
	public void openDeleteinfo_LongDistance(String num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		deleteinfo_LongDistance.setDefaultInfo(num);
		deleteinfo_LongDistance.setVisible(true);		
		menuPanel.setEnabled(false);
	}
	public void closeDeleteinfo_LongDistance() {
		// TODO Auto-generated method stub
		deleteinfo_LongDistance.setVisible(false);
		menuPanel.setEnabled(true);
	}						
}
