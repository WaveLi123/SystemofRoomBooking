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
import entities.Employee;
import entities.LongDistance;
import entities.Manager;
import entities_2.Bike;
import frame_manager.MainFrame;

public class Deleteinfo_Manager extends JPanel {

	private static final long serialVersionUID = -2528010327207966820L;
	private JLabel bg;
	private JTextField jtf1;
	private JTextField jtf2;
	private JTextField jtf3;
	private JTextField jtf4;
	private JTextField jtf5;
	private JTextField jtf6;
	private JTextField jtf7;
	private JTextField jtf8;
	private JTextField jtf9;
	
	public Deleteinfo_Manager(){

		bg=new JLabel(new ImageIcon(this.getClass().getResource("/image_2/Manager_Info.png")));
		
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		jtf4 = new JTextField();
		jtf5 = new JTextField();
		jtf6 = new JTextField();
		jtf7 = new JTextField();
		jtf8 = new JTextField();
		jtf9 = new JTextField();
		ImageButton ensure = new ImageButton("ok");
		ImageButton cancel = new ImageButton("cancel");
		
		this.setSize(479, 275);
		this.setLayout(null);
		this.setOpaque(false);
				
		bg.setOpaque(false);
		
		add(ensure);
		add(cancel);
		add(jtf1);
		add(jtf2);
		add(jtf3);
		add(jtf4);
		add(jtf5);
		add(jtf6);
		add(jtf7);
		add(jtf8);
		add(jtf9);
		add(bg);
		
		bg.setBounds(0, 0, (int) getWidth(),(int) getHeight());
		
		//部件位置摆放
		jtf1.setBounds(117, 68, 74, 16);
		jtf2.setBounds(117, 89, 74, 16);
		jtf3.setBounds(117, 112, 74, 16);
		jtf4.setBounds(117, 137, 74, 16);
		jtf5.setBounds(117, 158, 74, 16);
		jtf6.setBounds(117, 183, 74, 16);
		jtf7.setBounds(117, 206, 74, 16);
		jtf8.setBounds(117, 232, 74, 16);
		jtf9.setBounds(117, 256, 74, 16);
		//设置控件不可编辑
		jtf1.setEditable(false);
		jtf2.setEditable(false);
		jtf3.setEditable(false);
		jtf4.setEditable(false);
		jtf5.setEditable(false);
		jtf6.setEditable(false);
		jtf7.setEditable(false);
		jtf8.setEditable(false);
		jtf9.setEditable(false);
		
		ensure.setBounds(350, 200, 48, 48);
		cancel.setBounds(410, 200, 48, 48);
							
		ensure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(jtf1.getText().equalsIgnoreCase("") 
					||jtf2.getText().equalsIgnoreCase("") 
					||jtf3.getText().equalsIgnoreCase("")
					||jtf4.getText().equalsIgnoreCase("")
					||jtf5.getText().equalsIgnoreCase("")
					||jtf6.getText().equalsIgnoreCase("")
					||jtf7.getText().equalsIgnoreCase("")
					||jtf8.getText().equalsIgnoreCase("")
					||jtf9.getText().equalsIgnoreCase("") ){
					
					JOptionPane.showMessageDialog(null, "请输入完整的信息！", "提示",JOptionPane.ERROR_MESSAGE);
				}
				else{					
					Manager temp = new Manager(jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf7.getText(),jtf8.getText(),jtf9.getText());
					try {
						temp.deleteDB(jtf1.getText());						
						JOptionPane.showMessageDialog(null, "您选择的信息已删除！", "提示",JOptionPane.ERROR_MESSAGE);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "数据库插入异常！", "提示",JOptionPane.ERROR_MESSAGE);
					}
					MainFrame.instance().closeDeleteinfo_Manager();
				}				
			}
			
		});
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {				
				MainFrame.instance().closeDeleteinfo_Manager();
			}
		});
		this.setVisible(false);	
	}
	public void setDefaultInfo(String Num) throws ClassNotFoundException, SQLException{		
		int i = 0; 
		Manager temp = new Manager();
		String [] value = temp.getinfo(Num);
		jtf1.setText(value[i++]);
		jtf2.setText(value[i++]);
		jtf3.setText(value[i++]);
		jtf4.setText(value[i++]);
		jtf5.setText(value[i++]);
		jtf6.setText(value[i++]);
		jtf7.setText(value[i++]);
		jtf8.setText(value[i++]);
		jtf9.setText(value[i++]);		
	}
}
