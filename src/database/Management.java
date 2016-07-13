//Management.java �����Ը����ֲ�Ʒ���й���ķ���
package database;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Management
{
	//data
	Connection con;					//�����ض����ݿ������ʵ��
	public Statement stmt;			//���������ݿⷢ��SQL����statement����
	public ResultSet rs;			//��������������ܲ�ѯ������صĶ���
	public static int maxId;		//��ŵ�ǰ��Ʒ��ŵ����ֵ
	
	//method
	//���������Ĺ��캯��
	public Management() throws ClassNotFoundException, SQLException	
	{
		con=null;
		stmt=null;
		rs=null;
		maxId=0;		
		//sqlserver
//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");		
//		con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=��������ϵͳ","WaveLi123","00100100");
		
		//oracle11g
		Class.forName("oracle.jdbc.driver.OracleDriver");		
		con = DriverManager.getConnection("jdbc:oracle:thin:@10.10.133.240:1521:PRO1","scott","root");
		
		//mysql
//		Class.forName("com.mysql.jdbc.Driver");		
//		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");	
		
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
	}
	protected void finalize()throws Throwable		//��������
	{
		if(rs!=null)
			rs.close();
		if(stmt!=null)
			stmt.close();
		if(con!=null)
			con.close();
	}
	//��ʾ��������Ϣ
	//**********************************************************
	public void display(String name)
	{	
		try{
			rs = stmt.executeQuery("select * from "+name);	//Executes the given SQL statement
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}