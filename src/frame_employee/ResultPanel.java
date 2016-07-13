package frame_employee;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listener_3.ResultPanelListener;

public class ResultPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7078040137616703672L;
	private static ResultPanel resultPanel;
	private static JLabel logo;
	private static JLabel background;
	private ImageButton bt_re_back;
	private MainReslutPanel ResultTabel;
	
	public ResultPanel(){
		
		ImageIcon bg= new ImageIcon(this.getClass().getResource("/image/Result_bg.png"));
		ImageIcon logoImage= new ImageIcon(this.getClass().getResource("/image/result_logo.png"));

		ResultTabel=new MainReslutPanel();
		bt_re_back=new ImageButton("re_back");
		background= new JLabel(bg);
		logo=new JLabel(logoImage);
		logo.setOpaque(false);
		background.setOpaque(false);
		ResultTabel.setOpaque(false);
		add(ResultTabel);
		add(bt_re_back);
		add(logo);
		add(background);
		ResultTabel.setBounds(30,90,950,670);
		logo.setBounds(821, 19,131,65);
		background.setBounds(0, 0, 996,777);
		bt_re_back.setBounds(20, 10, 48, 48);
		setLayout(null);
		setSize(996,777);
		this.setVisible(false);
		this.setOpaque(false);
		
		ResultPanelListener resultPanelListener =new ResultPanelListener(bt_re_back);
		bt_re_back.addActionListener(resultPanelListener);
	}
	
	public static ResultPanel instance(){
		if(resultPanel==null)
			resultPanel=new ResultPanel();
		return resultPanel;
	}

	public void open(){
		setVisible(true);
	}

	//added by jkd, 4st Jan in 2014
	public void showBusData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ResultTabel.showBusData();
		MainFrame_3.instance().showResultPanel();
	}
	public void showBicycleData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ResultTabel.showBicycleData();
		MainFrame_3.instance().showResultPanel();
	}
	public void showRouteData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ResultTabel.showRouteData();
		MainFrame_3.instance().showResultPanel();
	}
	public void showLocalData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ResultTabel.showLocalData();
		MainFrame_3.instance().showResultPanel();
	}
	public void showLongDistanceData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ResultTabel.showLongDistanceData();
		MainFrame_3.instance().showResultPanel();
	}
	public void showEmployeeData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ResultTabel.showEmployeeData();
		MainFrame_3.instance().showResultPanel();
	}
	public void showPassengerData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ResultTabel.showPassengerData();
		MainFrame_3.instance().showResultPanel();
	}
	public void showManagerData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ResultTabel.showManagerData();
		MainFrame_3.instance().showResultPanel();
	}
	//added by WaveLi,28st Feb in 2015
	//预计入住房间报表
	public void showRoom_InData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ResultTabel.showRoom_InData();
		MainFrame_3.instance().showResultPanel();
	}
	//预计入住收入报表
	public void showRoom_MoneyData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ResultTabel.showRoom_LiveData();
		MainFrame_3.instance().showResultPanel();
	}
	//奖励报表
	public void showRewardsData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ResultTabel.showRewardsData();
		MainFrame_3.instance().showResultPanel();
	}
	//生成罚单
	public void showFineData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ResultTabel.showFineData();
		MainFrame_3.instance().showResultPanel();
	}
}
