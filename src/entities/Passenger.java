package entities;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.Management;

public class Passenger 
{
//	create table Passenger(
//			编号 varchar(23),
//			姓名 varchar(23),
//			性别 varchar(23),
//			年龄 varchar(23),
//			备注 varchar(23)
//		)



	
	private static final long serialVersionUID = 20101025L;
	//data
	public String 编号;
	public String 姓名; 
	public String 性别; 
	public String 年龄; 
	public String 备注; 	 
		
	//带参数的构造函数
	public Passenger(String str0,String str1,String str2,String str3,String str4)
	{
		this.编号 = str0;
		this.姓名 = str1;
		this.性别 = str2;
		this.年龄 = str3;
		this.备注 = str4;
	}
	//不带参数的构造函数
	public Passenger(){}
	
	//获取相关信息
	public void get_info(String str0,String str1,String str2,String str3,String str4){
		this.编号 = str0;
		this.姓名 = str1;
		this.性别 = str2;
		this.年龄 = str3;
		this.备注 = str4;
	}
	
	//将信息添加到数据库中
	public void storeToDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="insert into Passenger(编号,姓名,性别,年龄,备注)"
					+"values("
					+"'"+this.编号+"'"+","
					+"'"+this.姓名+"'"+","
					+"'"+this.性别+"'"+","
					+"'"+this.年龄+"'"+","
					+"'"+this.备注+"'"
					+")";				
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	//更新数据库中的信息
	public void updateDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="update Passenger "
					+"set "
					+"编号 = "+"'"+this.编号+"'"+","
					+"姓名 = "+"'"+this.姓名+"'"+","
					+"性别 = "+"'"+this.性别+"'"+","
					+"年龄 = "+"'"+this.年龄+"'"+","
					+"年龄 = "+"'"+this.备注+"'"+","
					+" where 编号  = "+"'"+this.编号+"'";					
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	//删除数据库中的信息
	public void deleteDB(String num) throws SQLException, ClassNotFoundException
	{
		String sqlS="delete "
					+"from Passenger "
					+" where 编号 = "+"'"+num+"'";					
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	
	//获取信息
	public String[] getinfo(String num) throws SQLException, ClassNotFoundException{
		String sqlS="select * "
				+"from Passenger "
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
	public List<Passenger> getallinfo() throws SQLException, ClassNotFoundException{
		String sqlS="select * "
				+"from Passenger";							
		Management operate = new Management();
		operate.rs = operate.stmt.executeQuery(sqlS);		
		ResultSetMetaData rsmd=operate.rs.getMetaData();	//创建结果集对象
		
		int colCount = rsmd.getColumnCount();		//得到列数
		String[] name = new String[colCount];
		operate.rs.beforeFirst();
		
		String[] value = new String[colCount];		

		List<Passenger> ar = new ArrayList<Passenger>();  		
		while(operate.rs.next())		//得到各行的属性值
		{			
			for(int i=1;i<=colCount;i++){
				value[i-1]=operate.rs.getString(i);			
			}
			Passenger temp = new Passenger(value[0],value[1],value[2],value[3],value[4]);
			ar.add(temp);
		}
		operate.rs.close();	
		return ar;
	}
	//获取产品信息
	public String[] getkeyinfo() throws SQLException, ClassNotFoundException{
		Management operate = new Management();
		operate.display("Passenger");
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
	public Object[] formatCustomerBasicalData(Passenger temp){        	
	  	Object [] str =new Object[5];
	  	str[0] = temp.编号;
	  	str[1] = temp.姓名;
	  	str[2] = temp.性别;
	  	str[3] = temp.年龄;
	  	str[4] = temp.备注;	  	
	  	return str;
	}
	public Object[][] getAllData() throws ClassNotFoundException, SQLException {	
		Object[][] temp =new Object[1][5];
		if(getallinfo().size()>0){
			temp = new Object[getallinfo().size()][5];
			Passenger t = null;
			for(int i=0;i<getallinfo().size();i++){
				t = getallinfo().get(i);
				temp[i] = formatCustomerBasicalData(t);
			}
		}		
		return temp;
	}		 
}
