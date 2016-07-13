package entities;
import database.Management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Bus 
{
//	create table bus(
//			类型 varchar(23),
//			编号 varchar(23),
//			座位数 varchar(23),
//			线路编号 varchar(23)
//		)
	private static final long serialVersionUID = 20101025L;
	
	//data
	String 类型; 
	String 编号; 
	String 座位数; 
	String 线路编号; 
	
	//带参数的构造函数
	public Bus(String type,String number,String capatify,String routenumber)
	{
		this.类型 = type;
		this.编号 = number;
		this.座位数 = capatify;
		this.线路编号 = routenumber;
	}
	//不带参数的构造函数
	public Bus(){}
	
	//获取相关信息
	public void get_info(String type,String number,String capatify,String routenumber){
		this.类型 = type;
		this.编号 = number;
		this.座位数 = capatify;
		this.线路编号 = routenumber;
	}
	
	//将信息添加到数据库中
	public void storeToDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="insert into bus(类型,编号,座位数,线路编号)"
					+"values("
					+"'"+this.类型+"'"+","
					+"'"+this.编号+"'"+","
					+"'"+this.座位数+"'"+","
					+"'"+this.线路编号+"'"
					+")";				
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	//更新数据库中的信息
	public void updateDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="update bus "
					+"set "
					+"类型 = "+"'"+this.类型+"'"+","
					+"编号 = "+"'"+this.编号+"'"+","
					+"座位数 = "+"'"+this.座位数+"'"+","
					+"线路编号 = "+"'"+this.线路编号+"'"
					+" where 编号 = "+"'"+this.编号+"'";					
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	//删除数据库中的信息
	public void deleteDB(String num) throws SQLException, ClassNotFoundException
	{
		String sqlS="delete "
					+"from bus "
					+" where 编号 = "+"'"+num+"'";					
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	
	//获取信息
	public String[] getinfo_bus(String num) throws SQLException, ClassNotFoundException{
		String sqlS="select * "
				+"from bus "
				+" where 编号 = "+"'"+num+"'";				
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
	public List<Bus> getallinfo_bus() throws SQLException, ClassNotFoundException{
		String sqlS="select * "
				+"from bus";							
		Management operate = new Management();
		operate.rs = operate.stmt.executeQuery(sqlS);		
		ResultSetMetaData rsmd=operate.rs.getMetaData();	//创建结果集对象
		
		int colCount = rsmd.getColumnCount();		//得到列数
		String[] name = new String[colCount];
		operate.rs.beforeFirst();
		
		String[] value = new String[colCount];		

		List<Bus> ar = new ArrayList<Bus>();  		
		while(operate.rs.next())		//得到各行的属性值
		{			
			for(int i=1;i<=colCount;i++){
				value[i-1]=operate.rs.getString(i);			
			}
			Bus temp_bus = new Bus(value[0],value[1],value[2],value[3]);
			ar.add(temp_bus);
		}
		operate.rs.close();	
		return ar;
	}
	//获取产品信息
	public String[] getkeyinfo_bus() throws SQLException, ClassNotFoundException{
		Management operate = new Management();
		operate.display("bus");
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
	public Object[] formatCustomerBasicalData(Bus t_bus){    
	  	//"类型","编号","座位数","线路编号"    	
	  	Object [] str =new Object[4];
	  	str[0] = t_bus.getType();
	  	str[1] = t_bus.getNumber();
	  	str[2] = t_bus.getCapatify();
	  	str[3] = t_bus.getRouteNumber();        	
	  	return str;
	}
	public Object[][] getAllBusData() throws ClassNotFoundException, SQLException {	
		Object[][] tempBus =new Object[1][4];
		if(getallinfo_bus().size()>0){
			tempBus=new Object[getallinfo_bus().size()][4];
			Bus bus = null;
			for(int i=0;i<getallinfo_bus().size();i++){
				bus=getallinfo_bus().get(i);
				tempBus[i] = formatCustomerBasicalData(bus);
			}
		}		
		return tempBus;
	}
	
	public String getType(){
		return this.类型;
	}
	public String getNumber(){
		return this.编号;
	}
	public String getCapatify(){
		return this.座位数;
	}  
	public String getRouteNumber(){
		return this.线路编号;
	}  
}