package frame_2;

import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listener_2.ResultPanelListener;

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

	//changed by jkd,5st Jan in 2014
	public void showBookingData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ResultTabel.showRoomsBookedData();
		try {
			MainFrame_2.instance().showResultPanel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showAllCustomerBasicalData() throws ClassNotFoundException, SQLException{
		ResultTabel.showAllCustomerBasicalData();
		try {
			MainFrame_2.instance().showResultPanel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void ShowCustomerDataByRoomId(String roomId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ResultTabel.showSearchResultByRoomId(roomId);
		try {
			MainFrame_2.instance().showResultPanel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
