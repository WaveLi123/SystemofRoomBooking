package frame_employee;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listener_3.Add_Info_DialogListener;

import entities.Type_of_Info;


public class Add_Info_Dialog extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528010327207966820L;
	//private static BookRoomDialog bookRoomDialog ;
	private JLabel bg;
	private JTextField jtfName;
	private JTextField jtfPhoneNum;
	private JComboBox jcbRoomType;
	
	public Add_Info_Dialog(){

		bg=new JLabel(new ImageIcon(this.getClass().getResource("/image_2/Choice.png")));
		
//		jtfName=new JTextField();
//		jtfPhoneNum =new JTextField();
		String[] obj={"客人入住登记报表","每日到达的报表"};
		
		jcbRoomType=new JComboBox(obj);
		
		ImageButton ensure = new ImageButton("ok");
		ImageButton cancel = new ImageButton("cancel");
		
		this.setSize(479, 275);
		this.setLayout(null);
	//	this.setLocation();
		
		this.setOpaque(false);		
		
		jcbRoomType.setOpaque(false);
//		jtfName.setOpaque(false);
//		jtfPhoneNum.setOpaque(false);
		bg.setOpaque(false);
		
		add(ensure);
		add(cancel);
//		add(jtfName);
//		add(jtfPhoneNum);
		add(jcbRoomType);
		add(bg);
		bg.setBounds(0, 0, (int) getWidth(),(int) getHeight());
		
		
		//jtfName.setBounds(90, 93, 100, 22);
		jcbRoomType.setBounds(135, 149, 125, 22);
//		jtfPhoneNum.setBounds(90, 93, 100, 22);
		//jcbRoomType.setBounds(133, 178, 74, 22);
		//changed by jkd,2nd Jan in 2014		
//		jtfName.setBounds(133, 178, 150, 22);
		
		ensure.setBounds(350, 200, 48, 48);
		cancel.setBounds(410, 200, 48, 48);
							
		Add_Info_DialogListener add_info_dialoglistener = new Add_Info_DialogListener(jtfName, jtfPhoneNum,
				jcbRoomType, ensure, cancel);
		
		ensure.addActionListener(add_info_dialoglistener);
		cancel.addActionListener(add_info_dialoglistener);
		this.setVisible(false);	
	}		
}
