package frame_employee;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import frame_employee.LoginFrame;
import frame_manager.BackgroundPanel;
import frame_manager.GravatarPanel;
import frame_manager.ImageButton;
import listener_3.LoginListener;

public class LoginFrame extends JFrame implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static LoginFrame loginFrame;
	private static JPanel loginPanel;
	private static JPanel logoPanel;
	private static GravatarPanel gravatar;
	private JTextField jtfUserName;
	private JPasswordField jpfPassword;

	//added by jkd,5st Jan in 2014
	private JRadioButton jrdMal;
	private JRadioButton jrdFamel;
	private JLabel jrdMaltext;
	private JLabel jrdFameltext;
	//added by WaveLi,27th Feb in 2015
	private JComboBox login_choose;
	private JLabel login_meaning;
	
	public static LoginFrame instance() {
		if (loginFrame == null)
			loginFrame = new LoginFrame();
		return loginFrame;
	}
	
	public LoginFrame(){
		
		super("Login");
		
		loginFrame=this;
		//全锟斤拷锟斤拷小..
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setMinimumSize(new Dimension(1024, 768));
		//锟斤拷锟斤拷锟斤拷录锟斤拷锟�
		loginPanel = new JPanel();
		logoPanel = new JPanel();
		//锟斤拷锟斤拷锟侥憋拷锟津，猴拷一锟斤拷锟斤拷录锟斤拷钮
		jtfUserName = new JTextField();
		jpfPassword = new JPasswordField();
		//锟斤拷录权锟斤拷选锟斤拷
		jrdMal = new JRadioButton();
		jrdFamel = new JRadioButton();
		jrdMaltext = new JLabel("锟斤拷锟斤拷员锟斤拷录");
		jrdMaltext.setFont(new Font("微锟斤拷锟脚猴拷", 50, 20));
		jrdMaltext.setForeground(Color.white);
		jrdFameltext = new JLabel("锟矫伙拷锟斤拷录");
		jrdFameltext.setFont(new Font("微锟斤拷锟脚猴拷", 50, 20));
		jrdFameltext.setForeground(Color.white);
		//added by WaveLi,27th Feb in 2015
		String[] choice = {"---","Manager","Employee"};
		login_choose = new JComboBox(choice);
		login_meaning = new JLabel("锟斤拷陆锟斤拷色选锟斤拷:");
		//锟斤拷锟斤拷 锟剿伙拷头锟斤拷
		gravatar=(new GravatarPanel().instance());
		
		final ImageButton loginButton =new ImageButton("bt_login");
		final ImageButton closeButton =new ImageButton("bt_close");
		//锟斤拷锟矫碉拷录锟斤拷锟侥达拷小,锟斤拷锟斤拷透锟斤拷
		loginPanel.setSize(screenSize.width,366);
		loginPanel.setOpaque(false);
		loginPanel.setLayout(null);
		//锟斤拷锟斤拷logo锟斤拷锟侥达拷小,锟斤拷锟斤拷透锟斤拷
		logoPanel.setSize(320,screenSize.width);
		logoPanel.setOpaque(false);
		logoPanel.setLayout(null);
		
		//锟斤拷录锟斤拷灞筹拷锟� 锟斤拷logo锟斤拷锟斤拷	
		JLabel loginBg = new JLabel(new ImageIcon(this.getClass().getResource("/image/loginPanel_bg.png")));
		JLabel loginLogo= new JLabel(new ImageIcon(this.getClass().getResource("/image/Login_logo.png")));
		//锟斤拷录锟斤拷锟斤拷锟接帮拷钮锟斤拷锟侥憋拷锟斤拷
		
		loginPanel.add(jtfUserName);
		loginPanel.add(jpfPassword);
		loginPanel.add(loginButton);
		loginPanel.add(gravatar);
		loginPanel.add(loginBg);
		ButtonGroup group = new ButtonGroup();
		group.add(jrdMal);
		group.add(jrdFamel);
		jrdMal.setOpaque(false);
		jrdFamel.setOpaque(false);
		//changed by WaveLi,27th in 2015
//		loginPanel.add(jrdMal);
//		loginPanel.add(jrdFamel);
//		loginPanel.add(jrdMaltext);
//		loginPanel.add(jrdFameltext);
		/*----------------------------*/
		loginPanel.add(login_choose);
		loginPanel.add(login_meaning);
		//loge锟斤拷锟斤拷锟斤拷logo 锟皆硷拷 一锟斤拷锟截闭帮拷钮
		logoPanel.add(loginLogo);
		add(closeButton);
		//锟斤拷录锟斤拷锟侥控硷拷锟斤拷锟斤拷锟斤拷锟矫ｏ拷
		jtfUserName.setBorder(null);
		jtfUserName.setOpaque(false);
		jtfUserName.setForeground(Color.GRAY);
		jpfPassword.setBorder(null);
		jpfPassword.setOpaque(false);
		jpfPassword.setForeground(Color.GRAY);
		jtfUserName.setSelectionColor(Color.BLUE);
		jpfPassword.setSelectionColor(Color.BLUE);
		jtfUserName.setFont(new Font("微锟斤拷锟脚猴拷", Font.PLAIN, 20));
		jpfPassword.setFont(new Font("微锟斤拷锟脚猴拷", Font.PLAIN, 20));
		//锟斤拷录锟斤拷锟� 锟截硷拷 锟斤拷锟斤拷位锟斤拷
		BackgroundPanel background = new BackgroundPanel();
		loginBg.setBounds(0, 0, (int) loginPanel.getWidth(),(int) loginPanel.getHeight());
		jtfUserName.setBounds(loginBg.getWidth()/2-112, loginPanel.getHeight()/2-28, 225, 28);
	    jpfPassword.setBounds(loginBg.getWidth()/2-112, loginPanel.getHeight()/2+18, 225, 28);
	    
	    //changed by WaveLi,27th in 2015
	    login_meaning.setBounds(loginBg.getWidth()/2-115, loginPanel.getHeight()/2+64,100,20);
	    login_choose.setBounds(loginBg.getWidth()/2-115+100, loginPanel.getHeight()/2+64,100,20);
//	    login_meaning.setOpaque(false);
//	    login_choose.setOpaque(false);
//	    jrdMal.setBounds(loginBg.getWidth()/2-120, loginPanel.getHeight()/2+64,23,20);
//	    jrdMaltext.setBounds(loginBg.getWidth()/2-120+23, loginPanel.getHeight()/2+64,100,20);
//	    jrdFamel.setBounds(loginBg.getWidth()/2-112+117, loginPanel.getHeight()/2+64,23,20);
//	    jrdFameltext.setBounds(loginBg.getWidth()/2-112+117+23, loginPanel.getHeight()/2+64,100,20);
//	    jrdMal.setOpaque(false);
//	    jrdFamel.setOpaque(false);	    	    
//	    jrdMaltext.setOpaque(false);
//	    jrdFameltext.setOpaque(false);	    
	    /*-------------------------------------------------------------------------------------------*/
	    
		loginButton.setBounds(loginBg.getWidth()/2+150, loginPanel.getHeight()/2-18, 52, 52);
		gravatar.setBounds(loginBg.getWidth()/2-235, loginPanel.getHeight()/2-40, 90, 90);
		//logo锟斤拷锟� 锟截硷拷位锟斤拷 锟斤拷锟斤拷
		loginLogo.setBounds(40,40, 320, 140);
		closeButton.setBounds(background.getWidth()-130, 40, 76, 80);
		//锟斤拷锟斤拷锟节的憋拷锟斤拷锟斤拷锟斤拷为 透锟斤拷
		((JPanel) this.getContentPane()).setOpaque(false);
		//锟斤拷颖锟斤拷锟斤拷锟斤拷
		
		getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
//锟斤拷锟絣ogo 锟斤拷锟铰硷拷锟藉；
		
		setLayout(null);
		add(loginPanel);
		add(logoPanel);
		setSize(screenSize);
		
		logoPanel.setBounds(0, 0, 1366, 200);
		loginPanel.setBounds(0, 200,screenSize.width,366);
		//锟斤拷锟斤拷默锟较碉拷装锟斤拷;
		setUndecorated(true);
		setBackground(Color.black);
		setLocationRelativeTo(null);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(1024, 768));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(this.getClass().getResource("/image/icon.png")).getImage());
		
		//锟斤拷锟矫硷拷锟斤拷锟斤拷锟斤拷
		LoginListener loginListener=new  LoginListener(jtfUserName, jpfPassword,
				loginButton,closeButton,login_choose);
		
		jtfUserName.addActionListener(loginListener);
		jpfPassword.addActionListener(loginListener);
		loginButton.addActionListener(loginListener);
		closeButton.addActionListener(loginListener);

	}
	
	public void open() {
		jtfUserName.setText("");
		jpfPassword.setText("");
		jtfUserName.requestFocus();

		setVisible(true);
		loginPanel.setVisible(true);
		if(!LoginFrame.instance().isVisible())
			LoginFrame.instance().dispose();
	}
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		instance().open();
	}
	
}
