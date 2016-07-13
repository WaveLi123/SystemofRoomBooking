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
import entities_2.Bike;
import frame_manager.MainFrame;


public class Deleteinfo_Bicycle extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528010327207966820L;
	//private static BookRoomDialog bookRoomDialog ;
	private JLabel bg;
	private JTextField jtf1;
	private JComboBox jtf2;
	private JTextField jtf3;
	private JTextField jtf4;
	private JComboBox jtf5;
	
	public Deleteinfo_Bicycle(){

		bg=new JLabel(new ImageIcon(this.getClass().getResource("/image_2/Bicycle_Info.png")));
		
		jtf1 = new JTextField();
		String [] value1 = {"飞鸽","京通","黄达","流星","年代","中古","环游"};
		jtf2 = new JComboBox(value1);
		jtf3 = new JTextField();
		jtf4 = new JTextField();
		jtf4.setText("无");
		String [] value2 = {"false","true"}; 
		jtf5 = new JComboBox(value2);
		
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
		add(bg);
		
		bg.setBounds(0, 0, (int) getWidth(),(int) getHeight());
		
		//部件位置摆放
		jtf1.setBounds(133, 72, 74, 22);
		jtf2.setBounds(133, 106, 74, 22);
		jtf3.setBounds(133, 146, 74, 22);
		jtf4.setBounds(133, 178, 74, 22);
		jtf5.setBounds(133, 218, 74, 22);		
		//设置控件不可编辑
		jtf1.setEditable(false);
		jtf2.setEditable(false);
		jtf3.setEditable(false);
		jtf4.setEditable(false);
		jtf5.setEditable(false);
		
		
		ensure.setBounds(350, 200, 48, 48);
		cancel.setBounds(410, 200, 48, 48);
							
		ensure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(jtf1.getText().equalsIgnoreCase("") 
					||jtf2.getSelectedItem().toString().equalsIgnoreCase("") 
					||jtf3.getText().equalsIgnoreCase("")
					||jtf4.getText().equalsIgnoreCase("")
					||jtf5.getSelectedItem().toString().equalsIgnoreCase("") ){
					
					JOptionPane.showMessageDialog(null, "请输入完整的信息！", "提示",JOptionPane.ERROR_MESSAGE);
				}
				else{					
					Bike temp = new Bike(Integer.parseInt(jtf1.getText()),Boolean.parseBoolean(jtf2.getSelectedItem().toString()),jtf3.getText(),jtf4.getText(),jtf5.getSelectedItem().toString());
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
					MainFrame.instance().closeDeleteinfo_Bicycle();
				}				
			}
			
		});
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {				
				MainFrame.instance().closeDeleteinfo_Bicycle();
			}
		});
		this.setVisible(false);	
	}
	public void setDefaultInfo(String Num) throws ClassNotFoundException, SQLException{		
		int i = 0; 
		Bike temp = new Bike();
		String [] value = temp.getinfo(Num);
		jtf1.setText(value[i++]);
		jtf2.setToolTipText(value[i++]);
		jtf3.setText(value[i++]);
		jtf4.setText(value[i++]);
		jtf5.setToolTipText(value[i++]);
	}
}