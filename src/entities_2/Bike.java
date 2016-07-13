package entities_2;

import java.io.Serializable;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.Management;
import entities.Bus;

public class Bike implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 407483120453172227L;
	private int roomId;
	private boolean isTaken;
	private String roomTypeId;
	private String coustomerId;
	private String perPrice;
		
	public Bike(int roomId ,boolean isTaken, String roomTypeId, String coustomerId, String perPrice) {		
		this.roomId =roomId;
		this.isTaken = isTaken;
		this.roomTypeId = roomTypeId;
		this.coustomerId = coustomerId;
		this.perPrice = perPrice;
	}
	public Bike(int roomId ,boolean isTaken, String roomTypeId, String coustomerId) {		
		this.roomId =roomId;
		this.isTaken = isTaken;
		this.roomTypeId = roomTypeId;
		this.coustomerId = coustomerId;		
	}
	public Bike(){}

	public int getRoomId(){
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public boolean isTaken() {
		return isTaken;
	}

	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}

	public String getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(String roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getCoustomerId() {
		return coustomerId;
	}
	public String getperPrice() {
		return perPrice;
	}
	public void setCoustomerId(String coustomerId) {
		this.coustomerId = coustomerId;
	}
	//����Ϣ��ӵ����ݿ���
	public void storeToDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="insert into Bike(roomId,isTaken,roomTypeId,coustomerId,perPrice)"
					+"values("
					+"'"+this.roomId+"'"+","
					+"'"+this.isTaken+"'"+","
					+"'"+this.roomTypeId+"'"+","
					+"'"+this.coustomerId+"'"+","
					+"'"+this.perPrice+"'"
					+")";				
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	//�������ݿ��е���Ϣ
	public void updateDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="update Bike "
					+"set "
					+"roomId = "+"'"+this.roomId+"'"+","
					+"isTaken = "+"'"+this.isTaken+"'"+","
					+"roomTypeId = "+"'"+this.roomTypeId+"'"+","
					+"coustomerId = "+"'"+this.coustomerId+"'"+","
					+"perPrice = "+"'"+this.perPrice+"'"
					+" where roomId = "+"'"+this.roomId+"'";					
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	//ɾ�����ݿ��е���Ϣ
	public void deleteDB(String num) throws SQLException, ClassNotFoundException{
		String sqlS="delete "
					+"from Bike "
					+" where roomId = "+"'"+num+"'";					
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}		
	//��ȡ��Ϣ
	public static String[] getinfo(String num) throws SQLException, ClassNotFoundException{
		String sqlS="select * "
				+"from Bike "
				+" where roomId = "+"'"+num+"'";	
		System.out.println(sqlS);
		Management operate = new Management();
		operate.rs = operate.stmt.executeQuery(sqlS);		
		ResultSetMetaData rsmd=operate.rs.getMetaData();	//�������������
		
		int colCount = rsmd.getColumnCount();		//�õ�����
		String[] name = new String[colCount];
		operate.rs.beforeFirst();
		
		String[] value = new String[colCount];		

		ArrayList<String> ar = new ArrayList<String>();  		
		while(operate.rs.next())		//�õ����е�����ֵ
		{			
			for(int i=1;i<=colCount;i++){
				value[i-1]=operate.rs.getString(i);					
			}										
		}
		operate.rs.close();
		return value;
	}
	//��ȡȫ����Ϣ
	public List<Bike> getallinfo() throws SQLException, ClassNotFoundException{
		String sqlS="select * "
				+"from Bike";							
		Management operate = new Management();
		operate.rs = operate.stmt.executeQuery(sqlS);		
		ResultSetMetaData rsmd=operate.rs.getMetaData();	//�������������
		
		int colCount = rsmd.getColumnCount();		//�õ�����
		String[] name = new String[colCount];
		operate.rs.beforeFirst();
		
		String[] value = new String[colCount];		

		List<Bike> ar = new ArrayList<Bike>();  		
		while(operate.rs.next())		//�õ����е�����ֵ
		{			
			for(int i=1;i<=colCount;i++){
				value[i-1]=operate.rs.getString(i);			
			}
			Bike temp = new Bike(Integer.parseInt(value[0]),Boolean.parseBoolean(value[1]),value[2],value[3],value[4]);
			ar.add(temp);
		}
		operate.rs.close();	
		return ar;
	}
	
	//��ȡ��Ʒ��Ϣ
	public String[] getkeyinfo() throws SQLException, ClassNotFoundException{
		Management operate = new Management();
		operate.display("Bike");
		ResultSetMetaData rsmd=operate.rs.getMetaData();	//�������������
		int colCount=rsmd.getColumnCount();		//�õ�����
		String[] name=new String[colCount];
		operate.rs.beforeFirst();
		
		String[] value=new String[colCount];		

		ArrayList<String> ar = new ArrayList<String>();  		
		while(operate.rs.next())		//�õ����е�����ֵ
		{			
			for(int i=1;i<=colCount;i++){
				value[i-1]=operate.rs.getString(i);			
			}							
			ar.add(value[0]);
		}
		operate.rs.close();
		String [] t_value = new String[ar.size()];
		int j = 0;
		for(int p = 0; p< ar.size(); p ++){
			t_value[p] = ar.get(p);			
		}
		return t_value;
	}
	//added by jkd,4st Jan in 2014
	public Object[] formatCustomerBasicalData(Bike temp){        	
	  	Object [] str =new Object[5];
	  	str[0] = temp.roomId;
	  	str[1] = String.valueOf(temp.isTaken);
	  	str[2] = temp.roomTypeId;
	  	str[3] = temp.coustomerId;
	  	str[4] = temp.perPrice;
	  	return str;
	}
	public Object[][] getAllData() throws ClassNotFoundException, SQLException {	
		Object[][] temp = new Object[1][5];
		if(getallinfo().size()>0){
			temp = new Object[getallinfo().size()][5];
			Bike bike = null;
			for(int i=0;i<getallinfo().size();i++){
				bike=getallinfo().get(i);
				temp[i] = formatCustomerBasicalData(bike);
			}
		}		
		return temp;
	}
	//��⳵���Ƿ����	
	public static boolean isRoomExsits(int roomTypeid ,int roomId) throws ClassNotFoundException, SQLException{
		String [] t_value = getinfo(String.valueOf(roomId));
		if((t_value[0] != null)&&(t_value[1].equalsIgnoreCase(String.valueOf(false)))){
			return true;
		}
		else{
			return false;
		}		
	}		
}
