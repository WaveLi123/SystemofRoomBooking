package entities;
import database.Management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class LongDistance 
{
//	create table Local(
//	编号 varchar(23),
//	始发站 varchar(23),
//	终点站 varchar(23),
//	经站数 varchar(23),
//	所需时长 varchar(23),
//	路程长度 varchar(23),
//	线路编号 varchar(23),
//	始发时间 varchar(23),
//	末发时间 varchar(23)
//)
	private static final long serialVersionUID = 20101025L;
	//data
	public String 编号;
	public String 始发站; 
	public String 终点站; 
	public String 经站数; 
	public String 所需时长; 
	public String 始发时间;
	public String 末发时间;
	
	//带参数的构造函数
	public LongDistance(String str0,String str1,String str2,String str3,String str4,String str5,String str6)
	{
		this.编号 = str0;
		this.始发站 = str1;
		this.终点站 = str2;
		this.经站数 = str3;
		this.所需时长 = str4;
		this.始发时间 = str5;
		this.末发时间 = str6;
	
	}
	
	//不带参数的构造函数
	public LongDistance(){}
	
	//获取相关信息
	public void get_info(String str0,String str1,String str2,String str3,String str4,String str5,String str6){
		this.编号 = str0;
		this.始发站 = str1;
		this.终点站 = str2;
		this.经站数 = str3;
		this.所需时长 = str4;
		this.始发时间 = str5;
		this.末发时间 = str6;
	}
	
	//将信息添加到数据库中
	public void storeToDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="insert into LongDistance(编号,始发站,终点站,经站数,所需时长,始发时间,末发时间)"
					+"values("
					+"'"+this.编号+"'"+","
					+"'"+this.始发站+"'"+","
					+"'"+this.终点站+"'"+","
					+"'"+this.经站数+"'"+","
					+"'"+this.所需时长+"'"+","
					+"'"+this.始发时间+"'"+","
					+"'"+this.末发时间+"'"
					+")";				
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	//更新数据库中的信息
	public void updateDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="update LongDistance "
					+"set "
					+"编号 = "+"'"+this.编号+"'"+","
					+"始发站 = "+"'"+this.始发站+"'"+","
					+"终点站 = "+"'"+this.终点站+"'"+","
					+"经站数 = "+"'"+this.经站数+"'"+","
					+"所需时长 = "+"'"+this.所需时长+"'"+","
					+"始发时间 = "+"'"+this.始发时间+"'"+","
					+"末发时间 = "+"'"+this.末发时间+"'"
					+" where 编号  = "+"'"+this.编号+"'";					
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	//删除数据库中的信息
	public void deleteDB(String num) throws SQLException, ClassNotFoundException
	{
		String sqlS="delete "
					+"from LongDistance "
					+" where 编号 = "+"'"+num+"'";					
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	
	//获取信息
	public String[] getinfo(String num) throws SQLException, ClassNotFoundException{
		String sqlS="select * "
				+"from LongDistance "
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
	public List<LongDistance> getallinfo() throws SQLException, ClassNotFoundException{
		String sqlS="select * "
				+"from LongDistance";							
		Management operate = new Management();
		operate.rs = operate.stmt.executeQuery(sqlS);		
		ResultSetMetaData rsmd=operate.rs.getMetaData();	//创建结果集对象
		
		int colCount = rsmd.getColumnCount();		//得到列数
		String[] name = new String[colCount];
		operate.rs.beforeFirst();
		
		String[] value = new String[colCount];		

		List<LongDistance> ar = new ArrayList<LongDistance>();  		
		while(operate.rs.next())		//得到各行的属性值
		{			
			for(int i=1;i<=colCount;i++){
				value[i-1]=operate.rs.getString(i);			
			}
			LongDistance temp = new LongDistance(value[0],value[1],value[2],value[3],value[4],value[5],value[6]);
			ar.add(temp);
		}
		operate.rs.close();	
		return ar;
	}
	//获取产品信息
	public String[] getkeyinfo() throws SQLException, ClassNotFoundException{
		Management operate = new Management();
		operate.display("LongDistance");
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
	public Object[] formatCustomerBasicalData(LongDistance temp){    
	  	//"类型","编号","座位数","线路编号"    	
	  	Object [] str =new Object[7];
	  	str[0] = temp.编号;
	  	str[1] = temp.始发站;
	  	str[2] = temp.终点站;
	  	str[3] = temp.经站数;	  	
	  	str[4] = temp.所需时长;
	  	str[5] = temp.始发时间;
	  	str[6] = temp.末发时间;
	  	return str;
	}
	public Object[][] getAllData() throws ClassNotFoundException, SQLException {	
		Object[][] temp =new Object[1][7];
		if(getallinfo().size()>0){
			temp = new Object[getallinfo().size()][5];
			LongDistance t = null;
			for(int i=0;i<getallinfo().size();i++){
				t = getallinfo().get(i);
				temp[i] = formatCustomerBasicalData(t);
			}
		}		
		return temp;
	}		 
}