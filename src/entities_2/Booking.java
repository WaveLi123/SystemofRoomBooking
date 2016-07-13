package entities_2;

import java.io.Serializable;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.Management;
import entities.Bus;

public class Booking implements Serializable{

	private static final long serialVersionUID = 8586408749212063870L;
	private String name;
	private String phoneNumber;
	private String roomType;
	private String PreOrderTime;

	public Booking(String name, String phoneNumber,String roomType,String PreOrderTime) {
		this.setRoomType(roomType);
		this.phoneNumber = phoneNumber;
		this.setName(name);
		this.PreOrderTime = PreOrderTime;
	}
	
	public Booking(){}

	public String getPhoneNumber() {
		return phoneNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRoomType() {
		return roomType;
	}


	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	//将信息添加到数据库中
	public void storeToDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="insert into Booking(name,phoneNumber,roomType,PreOrderTime)"
					+"values("
					+"'"+this.name+"'"+","
					+"'"+this.phoneNumber+"'"+","
					+"'"+this.roomType+"'"+","
					+"'"+this.PreOrderTime+"'"					
					+")";		
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	//更新数据库中的信息
	public void updateDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="update Booking "
					+"set "
					+"name = "+"'"+this.name+"'"+","
					+"phoneNumber = "+"'"+this.phoneNumber+"'"+","
					+"roomType = "+"'"+this.roomType+"'"+","
					+"PreOrderTime = "+"'"+this.PreOrderTime+"'"				
					+" where name = "+"'"+this.name+"'";					
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	//删除数据库中的信息
	public void deleteDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="delete "
					+"from Booking "
					+" where name = "+"'"+this.name+"'";					
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	
	//获取信息
	public static String[] getinfo(String num) throws SQLException, ClassNotFoundException{
		String sqlS="select * "
				+"from Booking "
				+" where phoneNumber = "+"'"+num+"'";		
		Management operate = new Management();
		operate.rs = operate.stmt.executeQuery(sqlS);		
		ResultSetMetaData rsmd=operate.rs.getMetaData();	//创建结果集对象
		
		int colCount = rsmd.getColumnCount();		//得到列数
		String[] name = new String[colCount];
		operate.rs.beforeFirst();
		
		String[] value = new String[colCount];		

		ArrayList<String> ar = new ArrayList<String>();  		
		while(operate.rs.next())		//得到各行的属性值
		{			
			for(int i=1;i<=colCount;i++){
				value[i-1]=operate.rs.getString(i);				
			}										
		}
		operate.rs.close();	
		return value;
	}
	//获取全部信息
	public static List<Booking> getallinfo() throws SQLException, ClassNotFoundException{
		String sqlS="select * "
				+"from Booking";							
		Management operate = new Management();
		operate.rs = operate.stmt.executeQuery(sqlS);		
		ResultSetMetaData rsmd=operate.rs.getMetaData();	//创建结果集对象
		
		int colCount = rsmd.getColumnCount();		//得到列数
		String[] name = new String[colCount];
		operate.rs.beforeFirst();
		
		String[] value = new String[colCount];		

		List<Booking> ar = new ArrayList<Booking>();  		
		while(operate.rs.next())		//得到各行的属性值
		{			
			for(int i=1;i<=colCount;i++){
				value[i-1]=operate.rs.getString(i);			
			}
			Booking temp = new Booking(value[0],value[1],value[2],value[3]);
			ar.add(temp);
		}
		operate.rs.close();	
		return ar;
	}
	//获取产品信息
	public String[] getkeyinfo_bus() throws SQLException, ClassNotFoundException{
		Management operate = new Management();
		operate.display("Booking");
		ResultSetMetaData rsmd=operate.rs.getMetaData();	//创建结果集对象
		int colCount=rsmd.getColumnCount();		//得到列数
		String[] name=new String[colCount];
		operate.rs.beforeFirst();
		
		String[] value=new String[colCount];		

		ArrayList<String> ar = new ArrayList<String>();  		
		while(operate.rs.next())		//得到各行的属性值
		{			
			for(int i=1;i<=colCount;i++){
				value[i-1]=operate.rs.getString(i);			
			}							
			ar.add(value[1]);
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
	public static Object[] formatCustomerBasicalData(Booking t_book){    
	  	//"姓名","电话号","车型"    	
	  	Object [] str =new Object[4];
	  	str[0] = t_book.getName();
	  	str[1] = t_book.getPhoneNumber();
	  	str[2] = t_book.getRoomType();	  	        
	  	str[3] = t_book.getPreOrderTime();
	  	return str;
	}
	String getPreOrderTime() {
		return this.PreOrderTime;
	}


	public static Object[][] getAllBookData() throws ClassNotFoundException, SQLException {	
		Object[][] temp =new Object[1][4];
		List<Booking> list = new ArrayList<Booking>();
		list = getallinfo();
		if(getallinfo().size()>0){
			temp = new Object[list.size()][4];
			Booking book = null;
			for(int i=0;i<list.size();i++){
				book = list.get(i);
				temp[i] = formatCustomerBasicalData(book);
			}
		}		
		return temp;
	}	 
}
