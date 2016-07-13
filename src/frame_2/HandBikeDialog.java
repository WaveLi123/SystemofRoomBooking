package frame_2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listener_2.HandBikeDialogListener;

public class HandBikeDialog extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5897276432192793728L;
	private static HandBikeDialog handRoomDialog ;
	private JLabel bg ;
	private  JTextField jtfRoomID;
	private JComboBox jcbYear;
	private JComboBox jcbMonth;
	private JComboBox jcbDay;
	private JCheckBox jchBisAdvance;
	public HandBikeDialog (){
		bg=new JLabel(new ImageIcon(this.getClass().getResource("/image/handRoomDialog_bg.png")));
		ImageButton ensure = new ImageButton("ok");
		ImageButton cancel = new ImageButton("cancel");
		
		jtfRoomID=new JTextField();
		jcbYear=new JComboBox();
		jcbMonth=new JComboBox();
		jcbDay=new JComboBox();
		jchBisAdvance =new JCheckBox("提前退房");
		jchBisAdvance.setFont(new Font("微软雅黑",Font.PLAIN,20));
		jchBisAdvance.setForeground(Color.white);
		
		
		jcbYear.setOpaque(false);
		jcbMonth.setOpaque(false);
		jcbDay.setOpaque(false);
		jchBisAdvance.setOpaque(false);
		
		jcbYear.setEnabled(false);
		jcbMonth.setEnabled(false);
		jcbDay.setEnabled(false);
		
		this.setVisible(false);
		this.setSize(479, 275);
		this.setOpaque(false);
		setLayout(null);
		
		jchBisAdvance.setBounds(253, 100, 200, 30);
		jtfRoomID.setBounds(103, 105, 80, 20);
		jcbYear.setBounds(160,157,70,20);
		jcbMonth.setBounds(257,157,70,20);
		jcbDay.setBounds(349,157,70,20);
		ensure.setBounds(350, 200, 48, 48);
		cancel.setBounds(410, 200, 48, 48);
		bg.setBounds(0, 0, 479, 275);
		
		add(jchBisAdvance);
		add(jtfRoomID);
		add(jcbYear);
		add(jcbMonth);
		add(jcbDay);
		add(ensure);
		add(cancel);
		add(bg);
		
		HandBikeDialogListener	handRoomDialogListener=new HandBikeDialogListener(jtfRoomID,jcbYear,jcbMonth,jcbDay,
				jchBisAdvance,ensure,cancel );
		
		jtfRoomID.addActionListener(handRoomDialogListener);
		jcbYear.addActionListener(handRoomDialogListener);
		jcbMonth.addActionListener(handRoomDialogListener);
		jcbDay.addActionListener(handRoomDialogListener);
		jchBisAdvance.addActionListener(handRoomDialogListener);
		ensure.addActionListener(handRoomDialogListener);
		cancel.addActionListener(handRoomDialogListener);
	}
	
	public static HandBikeDialog instance(){
		if(handRoomDialog==null){
			handRoomDialog=new HandBikeDialog();
		}
		return handRoomDialog;
	}	
}
