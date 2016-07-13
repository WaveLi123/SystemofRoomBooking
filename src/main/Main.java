package main;

import java.awt.Font;
import java.util.Enumeration;

import javax.swing.UIManager;

import frame_manager.LoginFrame;
import frame_manager.MainFrame;



public class Main {

	public static void main(String[] args) {
		// …Ë÷√ƒ¨»œ◊÷ÃÂ
		Font font = new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN,11);
		Enumeration<Object> keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource)
				UIManager.put(key, font);
		}
		new Thread(new LoginFrame()).start();
		 try
		    {
		        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		        UIManager.put("TabbedPane.tabAreaInsets"
		                , new javax.swing.plaf.InsetsUIResource(3,20,2,20));		        
		    }
		    catch(Exception e)
		    {
		        //TODO exception
		    }
		new Thread(new MainFrame()).start();
	}
}
