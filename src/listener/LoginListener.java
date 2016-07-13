package listener;


import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import entities.Transportation;
import frame_2.MainFrame_2;
import frame_employee.MainFrame_3;
import frame_manager.MainFrame;
import frame_manager.ImageButton;
import frame_manager.LoginFrame;
import frame_manager.MainFrame;

public class LoginListener extends MouseAdapter implements ActionListener {

	private JTextField jtfUserName;
	private JPasswordField jpfPassword;
	private ImageButton loginButton;
	private ImageButton closeButton;
	private JRadioButton jrdMal;
	private JRadioButton jrdFamel;
	//added by WaveLi,27th Feb in 2015
	private JComboBox login_choose;
	
	public LoginListener(JTextField jtfUserName, JPasswordField jpfPassword,
			ImageButton loginButton, ImageButton closeButton,JComboBox login_choose) {
		this.jtfUserName = jtfUserName;
		this.jpfPassword = jpfPassword;
		this.loginButton = loginButton;
		this.closeButton = closeButton;
		this.login_choose = login_choose;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jtfUserName || e.getSource() == jpfPassword
				|| e.getSource() == loginButton) {
			if (jtfUserName.getText().equals("")
					|| jpfPassword.getPassword().length == 0) {
				JOptionPane.showMessageDialog(null, "请输入用户名密码！", "提示",
						JOptionPane.ERROR_MESSAGE);

			} else
				try {
					if (true){						
//						String sex=jrdFamel.isSelected()?"用户登录":"管理员登录";
						String sex = (String)login_choose.getSelectedItem();
						if(sex.equalsIgnoreCase("---")){
							JOptionPane.showMessageDialog(null, "请选择用户类别！", "提示",
									JOptionPane.ERROR_MESSAGE);
						}else{														
							if(Transportation.instance().login(jtfUserName.getText(),
									String.valueOf(jpfPassword.getPassword()),sex)){
								if(sex.equalsIgnoreCase("Manager")){		
									System.out.println("Manager");
									LoginFrame.instance().setVisible(false);
									MainFrame.instance().open();
								}
								else if(sex.equalsIgnoreCase("Employee")){
									System.out.println("Employee");
									LoginFrame.instance().setVisible(false);
									MainFrame_3.instance().open();									
								}
								else{//for user "Customer"
									System.out.println("Customer");
									LoginFrame.instance().setVisible(false);
									MainFrame_2.instance().open();
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "用户名或密码错误！", "提示",
										JOptionPane.ERROR_MESSAGE);
							}												
						}
					} 
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		} else if (e.getSource() == closeButton) {
			 System.exit(0);
		}
	}
}
