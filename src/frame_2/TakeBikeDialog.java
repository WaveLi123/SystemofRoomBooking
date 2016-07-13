package frame_2;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listener_2.TakeBikeDialogListener;

public class TakeBikeDialog extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528010327207966820L;
	//private static BookRoomDialog bookRoomDialog ;
	private JLabel bg;
	private JTextField jtfPhoneNum;
	private JCheckBox jcbTake;
	public TakeBikeDialog(){
		bg=new JLabel(new ImageIcon(this.getClass().getResource("/image/TakeRoomDailog_bg .png")));
		jcbTake =new JCheckBox();
		jtfPhoneNum =new JTextField();
		ImageButton ensure = new ImageButton("ok");
		ImageButton cancel = new ImageButton("cancel");
		
		this.setSize(479, 275);
		this.setLayout(null);
		this.setOpaque(false);
		//jtfPhoneNum.setOpaque(false);
		jcbTake.setOpaque(false);
		add(jcbTake);
		add(ensure);
		add(cancel);
		add(jtfPhoneNum);
		add(bg);
		bg.setBounds(0, 0, (int) getWidth(),(int) getHeight());
		
		jtfPhoneNum.setBounds(124, 98, 100, 22);
		ensure.setBounds(350, 200, 48, 48);
		cancel.setBounds(410, 200, 48, 48);
		jcbTake.setBounds(98, 150, 30, 30);
		TakeBikeDialogListener takeRoomDialogListener =new TakeBikeDialogListener(jtfPhoneNum,
				jcbTake,ensure,cancel);
		ensure.addActionListener(takeRoomDialogListener) ;
		cancel.addActionListener(takeRoomDialogListener) ;
		this.setVisible(false);	
	}	
}
