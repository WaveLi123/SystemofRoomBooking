package listener_3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.table.DefaultTableModel;

import frame_employee.DataTable;
import frame_employee.MainFrame_3;

public class TableListener extends MouseAdapter implements ActionListener {
	private DataTable table;
	private String type;
	public TableListener(DataTable table,String tableType) {
		super();
		this.table = table;
		this.type=getType(tableType);
	}
	
	
	private String getType(String tableType) {
		// TODO Auto-generated method stub
		if(tableType.indexOf("Customer")>=0){
			return "Customer";
		}else if(tableType.indexOf("Room")>=0){
			return "Room";
		}else{
			return "other";
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		if(e.getClickCount()==2){
			if(type.equals("Customer")){
				String str=getValue(table.getSelectedRow(), 0);
				if(!str.equals("")){
				int customerId =Integer.parseInt(str);
//					MainFrame.instance().showDetailsByCustomerId(customerId);
				}
			}
		}		
	}
	private String getValue(int row, int column) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		return tableModel.getValueAt(row, column)==null?"":tableModel.getValueAt(row, column).toString();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
