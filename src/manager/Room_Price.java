package manager;

import java.io.Serializable;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.Management;
import entities.Bus;

public class Room_Price implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 407483120453172227L;
	private float price;	
		
	public Room_Price(float price) {		
		this.price = price;		
	}
	public Room_Price(){}

	public float getPrice(){
		return price;
	}
	
	//将信息添加到数据库中
	public void storeToDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="insert into Per_Price(price)"
					+"values("
					+this.price
					+")";				
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	//更新数据库中的信息
	public void updateDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="update Per_Price "
					+"set "
					+"price = "+this.price
					+" where ID = "+1;					
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	//获取当前基价信息
	public static String getinfo(String num) throws SQLException, ClassNotFoundException{
		String sqlS="select * "
				+"from Per_Price "
				+" where ID = "+1;	
		System.out.println(sqlS+"23");
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
		return value[1];
	}
}
