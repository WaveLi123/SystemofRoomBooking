package frame_2;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.BikeTypeData;

import listener_2.BookBikeDialogListener;

public class BookBikeDialog extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528010327207966820L;
	//private static BookRoomDialog bookRoomDialog ;
	private JLabel bg;
	private JTextField jtfName;
	private JTextField jtfPhoneNum;
	private JComboBox jcbRoomType;
	
	public BookBikeDialog(){

		bg=new JLabel(new ImageIcon(this.getClass().getResource("/image/BookDailog_bg.png")));
		
		jtfName=new JTextField();
		jtfPhoneNum =new JTextField();
//		Object[] obj = BikeTypeData.instance().FormatRoomTypeName();
		String[] obj = {"常规预定","奖励预定","提前60天预定","预付金预定"};
		jcbRoomType=new JComboBox(obj);
		
		ImageButton ensure = new ImageButton("ok");
		ImageButton cancel = new ImageButton("cancel");
		
		this.setSize(479, 275);
		this.setLayout(null);
	//	this.setLocation();
		this.setOpaque(false);
		jcbRoomType.setOpaque(false);
		//jtfName.setOpaque(false);
	//	jtfPhoneNum.setOpaque(false);
		
		add(ensure);
		add(cancel);
		add(jtfName);
		add(jtfPhoneNum);
		add(jcbRoomType);
		add(bg);
		bg.setBounds(0, 0, (int) getWidth(),(int) getHeight());
		
		jtfName.setBounds(110, 93, 100, 22);
		jtfPhoneNum.setBounds(151, 141, 100, 22);
		jcbRoomType.setBounds(151, 179, 74, 22);
		ensure.setBounds(350, 200, 48, 48);
		cancel.setBounds(410, 200, 48, 48);
		
		BookBikeDialogListener bookRoomDialogListener= new BookBikeDialogListener(jtfName, jtfPhoneNum,
				jcbRoomType, ensure, cancel);
		
		ensure.addActionListener(bookRoomDialogListener) ;
		cancel.addActionListener(bookRoomDialogListener) ;
		this.setVisible(false);	
	}	
}
