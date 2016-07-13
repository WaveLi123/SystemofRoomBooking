package frame_employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entities.Bus;


public class Addinfo_Bus extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528010327207966820L;
	//private static BookRoomDialog bookRoomDialog ;
	private JLabel bg;
	private JTextField jtftype;
	private JTextField jtfnumber;
	private JTextField jtfcapatify;
	private JTextField jtfroutenumber;
	
	public Addinfo_Bus(){

		bg=new JLabel(new ImageIcon(this.getClass().getResource("/image_2/Bus_Info.png")));
		
		jtftype = new JTextField();
		jtfnumber = new JTextField();
		jtfcapatify = new JTextField();
		jtfroutenumber = new JTextField();					
		ImageButton ensure = new ImageButton("ok");
		ImageButton cancel = new ImageButton("cancel");
		
		this.setSize(479, 275);
		this.setLayout(null);
		this.setOpaque(false);
		
//		jtftype.setOpaque(false);
//		jtfnumber.setOpaque(false);
//		jtfcapatify.setOpaque(false);
//		jtfroutenumber.setOpaque(false);		
		bg.setOpaque(false);
		
		add(ensure);
		add(cancel);
		add(jtftype);
		add(jtfnumber);
		add(jtfcapatify);
		add(jtfroutenumber);
		add(bg);
		bg.setBounds(0, 0, (int) getWidth(),(int) getHeight());
		
		jtftype.setBounds(133, 50, 74, 22);
		jtftype.setBounds(133, 98, 74, 22);
		jtfnumber.setBounds(133, 128, 74, 22);
		jtfcapatify.setBounds(133, 166, 74, 22);
		jtfroutenumber.setBounds(133, 197, 74, 22);
		
//		jtfName.setBounds(90, 93, 100, 22);
//		jtfPhoneNum.setBounds(133, 145, 100, 22);
//		jtfPhoneNum.setBounds(90, 93, 100, 22);
//		jcbRoomType.setBounds(133, 178, 74, 22);
		//changed by jkd,2nd Jan in 2014		
//		jtfName.setBounds(133, 178, 150, 22);
		
		ensure.setBounds(350, 200, 48, 48);
		cancel.setBounds(410, 200, 48, 48);
							
		ensure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(jtftype.getText().equalsIgnoreCase("") 
					||jtfnumber.getText().equalsIgnoreCase("") 
					||jtfcapatify.getText().equalsIgnoreCase("") 
					||jtfroutenumber.getText().equalsIgnoreCase("") ){
					
					JOptionPane.showMessageDialog(null, "请输入完整的信息！", "提示",JOptionPane.ERROR_MESSAGE);
				}
				else{
					Bus bus = new Bus(jtftype.getText(),jtfnumber.getText(),jtfcapatify.getText(),jtfroutenumber.getText());
					try {
						bus.storeToDB();						
						JOptionPane.showMessageDialog(null, "您添加的信息已保存！", "提示",JOptionPane.ERROR_MESSAGE);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "数据库插入异常！", "提示",JOptionPane.ERROR_MESSAGE);
					}
					MainFrame_3.instance().closeAddinfo_Bus();
				}				
			}
			
		});
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {				
				MainFrame_3.instance().closeAddinfo_Bus();
			}
		});
		this.setVisible(false);	
	}		
}
