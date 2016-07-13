package entities;
import database.Management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Employee 
{
//	create table Employee(
//			编号 varchar(23),
//			姓名 varchar(23),
//			身份证号 varchar(23),
//			年龄 varchar(23),
//			薪水 varchar(23),
//			所属部门 varchar(23),	
//		)

	
	private static final long serialVersionUID = 20101025L;
	//data
	public String 编号;
	public String 姓名; 
	public String 身份证号; 
	public String 年龄; 
	public String 薪水; 
	public String 所属部门; 
		
	//带参数的构造函数
	public Employee(String str0,String str1,String str2,String str3,String str4
					,String str5)
	{
		this.编号 = str0;
		this.姓名 = str1;
		this.身份证号 = str2;
		this.年龄 = str3;
		this.薪水 = str4;
		this.所属部门 = str5;	
	}
	//不带参数的构造函数
	public Employee(){}
	
	//获取相关信息
	public void get_info(String str0,String str1,String str2,String str3,String str4
			,String str5){
		this.编号 = str0;
		this.姓名 = str1;
		this.身份证号 = str2;
		this.年龄 = str3;
		this.薪水 = str4;
		this.所属部门 = str5;
	}
	
	//将信息添加到数据库中
	public void storeToDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="insert into Employee(编号,姓名,身份证号,年龄,薪水,所属部门)"
					+"values("
					+"'"+this.编号+"'"+","
					+"'"+this.姓名+"'"+","
					+"'"+this.身份证号+"'"+","
					+"'"+this.年龄+"'"+","
					+"'"+this.薪水+"'"+","
					+"'"+this.所属部门+"'"
					+")";				
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	//更新数据库中的信息
	public void updateDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="update Employee "
					+"set "
					+"编号 = "+"'"+this.编号+"'"+","
					+"姓名 = "+"'"+this.姓名+"'"+","
					+"身份证号 = "+"'"+this.身份证号+"'"+","
					+"年龄 = "+"'"+this.年龄+"'"+","
					+"薪水 = "+"'"+this.薪水+"'"+","
					+"所属部门 = "+"'"+this.所属部门+"'"
					+" where 编号  = "+"'"+this.编号+"'";					
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	//删除数据库中的信息
	public void deleteDB(String num) throws SQLException, ClassNotFoundException
	{
		String sqlS="delete "
					+"from Employee "
					+" where 编号 = "+"'"+num+"'";					
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	
	//获取信息
	public String[] getinfo(String num) throws SQLException, ClassNotFoundException{
		String sqlS="select * "
				+"from Employee "
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
	public List<Employee> getallinfo() throws SQLException, ClassNotFoundException{
		String sqlS="select * "
				+"from Employee";							
		Management operate = new Management();
		operate.rs = operate.stmt.executeQuery(sqlS);		
		ResultSetMetaData rsmd=operate.rs.getMetaData();	//创建结果集对象
		
		int colCount = rsmd.getColumnCount();		//得到列数
		String[] name = new String[colCount];
		operate.rs.beforeFirst();
		
		String[] value = new String[colCount];		

		List<Employee> ar = new ArrayList<Employee>();  		
		while(operate.rs.next())		//得到各行的属性值
		{			
			for(int i=1;i<=colCount;i++){
				value[i-1]=operate.rs.getString(i);			
			}
			Employee temp = new Employee(value[0],value[1],value[2],value[3],value[4]
											,value[5]);
			ar.add(temp);
		}
		operate.rs.close();	
		return ar;
	}
	//获取产品信息
	public String[] getkeyinfo() throws SQLException, ClassNotFoundException{
		Management operate = new Management();
		operate.display("Employee");
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
	public Object[] formatCustomerBasicalData(Employee temp){        	
	  	Object [] str =new Object[6];
	  	str[0] = temp.编号;
	  	str[1] = temp.姓名;
	  	str[2] = temp.身份证号;
	  	str[3] = temp.年龄;
	  	str[4] = temp.薪水;
	  	str[5] = temp.所属部门;
	  	return str;
	}
	public Object[][] getAllData() throws ClassNotFoundException, SQLException {	
		Object[][] temp =new Object[1][6];
		if(getallinfo().size()>0){
			temp = new Object[getallinfo().size()][6];
			Employee t = null;
			for(int i=0;i<getallinfo().size();i++){
				t = getallinfo().get(i);
				temp[i] = formatCustomerBasicalData(t);
			}
		}		
		return temp;
	}		 
}
