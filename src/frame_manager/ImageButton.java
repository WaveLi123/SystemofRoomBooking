package frame_manager;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class ImageButton extends JButton implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name; //��ť����
	private JLabel image;	//ͼƬ��ť
	private JLabel textPanel; // ���ְ�ť
	private Boolean pressed = false; //���õ�ǰ��ťδ�����
	private Boolean entered = false; // ������꾭������false
	private Boolean enabled = true;		//���õ�ǰ��ť������
	private String modal = "";

	public ImageButton(String name) { //ͼƬ��ť
		this.name = name;
		this.image = new JLabel();
		textPanel = new JLabel();
		add(image);
		setLayout(null);
		setBorder(null);
		setOpaque(false);
		addMouseListener(this);
	}

	public ImageButton(String btnname, String text) { //���ְ�ť Ĭ�� �����С
		this(btnname);
		textPanel.setText(text);
		textPanel.setVerticalAlignment(JLabel.CENTER);
		textPanel.setHorizontalAlignment(JLabel.CENTER);
		textPanel.setForeground(Color.LIGHT_GRAY);
		textPanel.setFont(new Font("΢���ź�",Font.PLAIN,14));
		add(textPanel);
	}

	public ImageButton(String btnname, String text, int size) {  //�������ִ�д
		this(btnname, text);
		textPanel.setFont(new Font("΢���ź�",Font.PLAIN, size)); //�������ְ�ť������
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
		if (!enabled)
			return;
		entered = true;
		if (pressed) {
			setModal("pressed");
		} else {
			setModal("entered");
		}
		
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public void mouseExited(MouseEvent e) {
		if (!enabled)
			return;
		entered = false;
		setModal("");
	}

	public void mousePressed(MouseEvent e) {
		if (!enabled)
			return;
		pressed = true;
		setModal("pressed");
	}

	public void mouseReleased(MouseEvent e) {
		if (!enabled)
			return;
		pressed = false;
		if (entered) {
			setModal("entered");
		} else {
			setModal("");
		}
	}

	public void setModal() {
		if (entered) {
			setModal("entered");
		} else {
			setModal("");
		}
	}

	public void setModal(String modal) {
		this.modal = modal;
		repaint();
	}

	public void setIBEnabled(Boolean isenabled) {
		enabled = isenabled;
		if (enabled) {
			setModal();
		} else {
			setModal("");
		}
	}

	public boolean getEnabled(){
		return enabled;
	}
	public void setText(String text) {
		this.textPanel.setText(text);
	}

	@Override
	public void setForeground(Color fg) {
		super.setForeground(fg);
		if (textPanel != null)
			textPanel.setForeground(fg);
	}

	@Override
	public void setSize(int width, int height) {
		super.setSize(width, height);
		image.setSize(width, height);
		textPanel.setSize(width, height);
	}

	@Override
	public void setFont(Font font) {
		super.setFont(font);
		if (textPanel != null) {
			textPanel.setFont(font);
			textPanel.setSize(textPanel.getPreferredSize().width,
					textPanel.getHeight());
		}
	}

	@Override
	public void paint(Graphics g) {
		try {
			ImageIcon img = null;
			if ("".equals(modal)) {
				img = new ImageIcon(this.getClass().getResource(
						"/image/" + name + ".png"));
			} else {
				img = new ImageIcon(this.getClass().getResource(
						"/image/" + name + "_" + modal + ".png"));
			}
			if (img.getImage() != null)
				g.drawImage(img.getImage(),
						(getWidth() - img.getIconWidth()) / 2,
						(getHeight() - img.getIconHeight()) / 2, image);
		} catch (NullPointerException e) {
			// super.paint(g);
		}
		if (textPanel != null) {
			g.setColor(Color.white);
			g.setFont(textPanel.getFont());
			g.drawString(textPanel.getText(), (int) (getWidth() - textPanel
					.getPreferredSize().getWidth()) / 2 +20,
					getHeight() / 2 +20);
			textPanel.paint(g);
		}
	}
}