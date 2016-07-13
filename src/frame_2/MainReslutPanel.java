package frame_2;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import listener_2.TableListener;

import entities_2.Booking;
import entities_2.Customer;

public class MainReslutPanel extends JPanel {
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
	
	public void showRoomsBookedData() throws ClassNotFoundException, SQLException {
		dataType = "BikesBooked";
		Object[] head = { "姓名","电话号码","预定类型","预定时间"};				
		showData(Booking.getAllBookData(), head);		
	}
	
	public void showAllCustomerBasicalData() throws ClassNotFoundException, SQLException {  // "---","1全部客户","2指定姓名","3指定性别","4指定来自地","5指定工作地点","6指定房号"
		dataType = "CustomerData";
		Object[] head = {"姓名","性别","电话号码","房号","预定类型","预计居住天数","住房时间","退房时间","押金" };
		showData(Customer.getAllData(), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);	
	}
	public void showSearchResultByRoomId(String roomId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		dataType = "CustomerDataByRoomId";
		Object[] head = {"姓名","性别","电话号码","房号","预定类型","预计居住天数","住房时间","退房时间","押金" };
		showData(Customer.getAllDatabyId(roomId), head);
		TableListener tableListener =new TableListener(table,dataType);
		table.addMouseListener(tableListener);
	}
}
