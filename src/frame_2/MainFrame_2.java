package frame_2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import entities_2.Transport_B;
import frame_manager.LoginFrame;

public class MainFrame_2 extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MainFrame_2 mainFrame ;
	private static ImageButton bt_close;
	private static MenuGroupPanel menuPanel;
	private AccountNamePanel namePanel;
	private static ResultPanel resultPanel;
	private static BookingPanel bookingPanel;
	private static BookBikeDialog bookRoomDialog;
	private static HandBikeDialog handRoomDialog;
	private static TakeBikeDialog takeRoomDialog;
	public MainFrame_2() throws SQLException, Exception{
		setTitle("宾房信息管理系统");

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
		bookingPanel=new BookingPanel();
		bookRoomDialog = new BookBikeDialog();
		takeRoomDialog =new TakeBikeDialog();
		handRoomDialog =new HandBikeDialog();
		
		
		add(handRoomDialog);
		add(bookRoomDialog);
		add(takeRoomDialog);
		add(bookingPanel);
		add(resultPanel);
		add(namePanel);
		add(bt_close);
		add(menuPanel);
		

		setLayout(null);
		//添加了用户名称面板
		namePanel.setBounds(0, 0,320, 200);
		bt_close.setBounds(getWidth()-130, 40, 76, 80);
		menuPanel.setBounds(this.getWidth()/2-230,this.getHeight()/2-130, 720,260);
		resultPanel.setBounds(getWidth()-994, 0, 996,777);
		bookingPanel.setBounds(0, 0, 377, 777);
		bookRoomDialog.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		takeRoomDialog.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
		handRoomDialog.setBounds(this.getWidth()/2-479/2, this.getHeight()/2-275/2, 479, 275);
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
		
	public static MainFrame_2 instance() throws SQLException, Exception{
		if(mainFrame==null)
			mainFrame=new MainFrame_2();
		return mainFrame;
	}
	public void open() {		
		setVisible(true);
		LoginFrame.instance().setVisible(false);	
	}
	@Override
	public void run() {
		try {
			instance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	//订车面板操作
	public void showBookingPanel() {
		// TODO Auto-generated method stub
		bookingPanel.setVisible(true);
	}
	public void showBookingPanel(String name, String phoneNum){
		//默认填好预定基本信息；
		bookingPanel.setDefaultInfo(name, phoneNum);
		bookingPanel.setVisible(true);
	}	
	public void closeBookingPanel(){
		bookingPanel.setVisible(false);
		//打开背面面板的事件

	}
	public void openBookRoomDialog() {
		// TODO Auto-generated method stub
		bookRoomDialog.setVisible(true);
		menuPanel.setEnabled(false);
	}
	public void closeBookRoomDialog() {
		// TODO Auto-generated method stub
		bookRoomDialog.setVisible(false);
		menuPanel.setEnabled(true);
	}

	//拿车面板操作
	public void openTakeRoomDialog() {
		// TODO Auto-generated method stub
		takeRoomDialog.setVisible(true);
		//
		menuPanel.setEnabled(false);
	}
	public void closeTakeRoomDialog() {
		// TODO Auto-generated method stub
		takeRoomDialog.setVisible(false);
		menuPanel.setEnabled(true);
	}

	//还车面板操作
	public void openHandRoomDialog() {
		// TODO Auto-generated method stub
		handRoomDialog.setVisible(true);
		menuPanel.setEnabled(false);
	}
	public void closeHandRoomDialog() {
		// TODO Auto-generated method stub
		handRoomDialog.setVisible(false);
		menuPanel.setEnabled(true);
	}
	
	//结果显示面板控制
	public void showResultPanel(){		
		resultPanel.setVisible(true);
	}
	
	public void closeResultPanel(){
		resultPanel.setVisible(false);
	}
}
