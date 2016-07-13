package frame_manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listener.Delete_Info_DialogListener;
import listener.Update_Info_DialogListener;

import entities.Type_of_Info;

public class Delete_Info_Dialog extends JPanel {

	private static final long serialVersionUID = -2528010327207966820L;
	//private static BookRoomDialog bookRoomDialog ;
	private JLabel bg;
	private JTextField jtfNum;
	private JComboBox jcbRoomType;		
	public Delete_Info_Dialog(){

		bg=new JLabel(new ImageIcon(this.getClass().getResource("/image_2/Choice.png")));
		
		jtfNum =new JTextField();
		Object[] obj=Type_of_Info.FormatInfoTypeName();
		jcbRoomType=new JComboBox(obj);
		
		ImageButton ensure = new ImageButton("ok");
		ImageButton cancel = new ImageButton("cancel");
		
		this.setSize(479, 275);
		this.setLayout(null);
	//	this.setLocation();
		
		this.setOpaque(false);		
//		jcbRoomType.setOpaque(false);
//		jtfNum.setOpaque(false);
		bg.setOpaque(false);
		
		add(ensure);
		add(cancel);
		add(jtfNum);
//		add(jcbRoomType);
		add(bg);
		bg.setBounds(0, 0, (int) getWidth(),(int) getHeight());
				
		jcbRoomType.setBounds(150, 105, 125, 22);
		jtfNum.setBounds(150, 155, 125, 22);		
		//jtfName.setBounds(90, 93, 100, 22);
//		jcbRoomType.setBounds(135, 140, 125, 22);
//		jtfPhoneNum.setBounds(90, 93, 100, 22);
		//jcbRoomType.setBounds(133, 178, 74, 22);
		//changed by jkd,2nd Jan in 2014		
//		jtfName.setBounds(133, 178, 150, 22);
		
		ensure.setBounds(350, 200, 48, 48);
		cancel.setBounds(410, 200, 48, 48);
							
		Delete_Info_DialogListener delete_info_dialoglistener = new Delete_Info_DialogListener(jtfNum,jcbRoomType, ensure, cancel);		
		ensure.addActionListener(delete_info_dialoglistener);
		cancel.addActionListener(delete_info_dialoglistener);
		this.setVisible(false);	
	}		
}
