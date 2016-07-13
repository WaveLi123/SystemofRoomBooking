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

public class Updateinfo_Bus extends JPanel {
	
	private static final long serialVersionUID = -2528010327207966820L;	
	private JLabel bg;
	private JTextField jtftype;
	private JTextField jtfnumber;
	private JTextField jtfcapatify;
	private JTextField jtfroutenumber;
	
	public Updateinfo_Bus(){
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
		
		bg.setOpaque(false);
		
		add(ensure);
		add(cancel);
		add(jtftype);
		add(jtfnumber);
		add(jtfcapatify);
		add(jtfroutenumber);
		add(bg);
		bg.setBounds(0, 0, (int) getWidth(),(int) getHeight());
		
		//部件位置摆放
		jtftype.setBounds(133, 50, 74, 22);
		jtftype.setBounds(133, 98, 74, 22);
		jtfnumber.setBounds(133, 128, 74, 22);
		jtfcapatify.setBounds(133, 166, 74, 22);
		jtfroutenumber.setBounds(133, 197, 74, 22);		
		
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
						bus.updateDB();
						JOptionPane.showMessageDialog(null, "您修改的信息已保存！", "提示",JOptionPane.ERROR_MESSAGE);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "数据库插入异常！", "提示",JOptionPane.ERROR_MESSAGE);
					}
					MainFrame_3.instance().closeUpdateinfo_Bus();
				}				
			}
			
		});
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {				
				MainFrame_3.instance().closeUpdateinfo_Bus();
			}
		});
		this.setVisible(false);	
	}
	
	public void setDefaultInfo(String Num) throws ClassNotFoundException, SQLException{		
		int i = 0; 
		Bus bus = new Bus();
		String [] value = bus.getinfo_bus(Num);
		jtftype.setText(value[i++]);
		jtfnumber.setText(value[i++]);
		jtfcapatify.setText(value[i++]);
		jtfroutenumber.setText(value[i++]);		
	}
}
