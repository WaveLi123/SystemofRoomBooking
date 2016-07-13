package entities_2;

import java.io.Serializable;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import manager.Room_Price;
import dao.BikeTypeData;
import database.Management;
import entities.Bus;

/**
 * @author JackCan_Liao
 *
 */
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2334900966361321333L;
	/**编号，私有顾客姓名，身份证号码，工作地点，来自地，家庭住址，性别，入住时间，离店时间*/
	private int id;
	private static int defaultId;
	private String name;
    private String idNumber;
    private String workplace;
    private String placeForm;
    private String home_adress;
    private String sex;
    private Date takeRomTime;
    private Date leaveTime;
    /**私有客户的年龄,入住天数,押金，住宿费， 房号*/
    private int age;
    private int liveDays;
    private double deposit;
    private String roomTypeId;
    private int roomId;
    private String phoneNum;
	public Customer( String name, String idNumber, String workplace,
			String placeForm, String home_adress, String sex,
			Date takeRomTime, Date leaveTime, int age, int liveDays,
			double deposit,int roomId,String roomTypeId,String phoneNum) {
		this.id =++defaultId;
		this.name = name;
		this.idNumber = idNumber;
		this.workplace = workplace;
		this.placeForm = placeForm;
		this.home_adress = home_adress;
		this.sex = sex;
		this.takeRomTime = takeRomTime;
		this.leaveTime = leaveTime;
		this.age = age;
		this.liveDays = liveDays;
		this.deposit = deposit;
		this.setRoomTypeId(roomTypeId);
		this.setRoomId(roomId);
		this.setPhoneNum(phoneNum);
	}
	
	//将信息添加到数据库中
	public void storeToDB() throws SQLException, ClassNotFoundException
	{
		String sqlS="insert into Customer(id,name,idNumber,workplace,placeForm,home_adress,sex" +
					",takeRomTime,leaveTime,age,liveDays,deposit,roomTypeId,roomId,phoneNum)"
					+"values("
					+"'"+this.id+"'"+","
					+"'"+this.name+"'"+","
					+"'"+this.idNumber+"'"+","
					+"'"+this.workplace+"'"+","
					+"'"+this.placeForm+"'"+","
					+"'"+this.home_adress+"'"+","
					+"'"+this.sex+"'"+","
					+"'"+this.takeRomTime+"'"+","
					+"'"+this.leaveTime+"'"+","
					+"'"+this.age+"'"+","
					+"'"+this.liveDays+"'"+","
					+"'"+this.deposit+"'"+","
					+"'"+this.roomTypeId+"'"+","
					+"'"+this.roomId+"'"+","					
					+"'"+this.phoneNum+"'"					
					+")";		
		System.out.println(sqlS);
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	//删除数据库中的信息
	public static void deleteDB(String ID) throws SQLException, ClassNotFoundException
	{
		String sqlS="delete "
				+"from Customer "
				+" where roomId = "+"'"+ID+"'";					
		Management operate=new Management();
		operate.stmt.executeUpdate(sqlS);
	}
	//获取信息
	public static String[] getinfo(String num) throws SQLException, ClassNotFoundException{
		String sqlS="select * "
				+"from Customer "
				+" where roomId = "+"'"+num+"'";		
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
	public static List<Customer> getallinfobymoney() throws SQLException, ClassNotFoundException{
		String sqlS="select * "
				+"from Customer";							
		Management operate = new Management();
		operate.rs = operate.stmt.executeQuery(sqlS);		
		ResultSetMetaData rsmd=operate.rs.getMetaData();	//创建结果集对象
		
		int colCount = rsmd.getColumnCount();		//得到列数
		String[] name = new String[colCount];
		operate.rs.beforeFirst();
		
		String[] value = new String[colCount];		

		List<Customer> ar = new ArrayList<Customer>();
		//获取基价信息
		float per_Price = Float.parseFloat(Room_Price.getinfo("1"));
		
		while(operate.rs.next())		//得到各行的属性值
		{			
			for(int i=1;i<=colCount;i++){
				value[i-1]=operate.rs.getString(i);			
			}
			Date date_s = parse(value[7], "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
			Date date_e = parse(value[8], "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
			
			long days = (date_e.getTime() - date_s.getTime())/(24*60*60*1000);
			value[11] = String.valueOf(days*per_Price);
			Customer temp = new Customer(value[1],value[2],value[3],value[4],value[5],
			value[6],date_s,date_e,Integer.parseInt(value[9]),Integer.parseInt(value[10]),
			Double.parseDouble(value[11]),Integer.parseInt(value[13]),value[12],value[14]);
			
			ar.add(temp);
		}
		operate.rs.close();	
		return ar;
	}

	//获取每日入住信息
	public static List<Customer> getallinfotoday() throws SQLException, ClassNotFoundException{
		String sqlS="select * "
				+"from Customer";							
		Management operate = new Management();
		operate.rs = operate.stmt.executeQuery(sqlS);		
		ResultSetMetaData rsmd=operate.rs.getMetaData();	//创建结果集对象
		
		int colCount = rsmd.getColumnCount();		//得到列数
		String[] name = new String[colCount];
		operate.rs.beforeFirst();
		
		String[] value = new String[colCount];		

		List<Customer> ar = new ArrayList<Customer>();  	
		
		while(operate.rs.next())		//得到各行的属性值
		{			
			for(int i=1;i<=colCount;i++){
				value[i-1]=operate.rs.getString(i);			
			}
			Date date_s = parse(value[7], "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
			Date date_e = parse(value[8], "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
			//获取预定时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date newDate = null;
			String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			String month = String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1);
			String day = String.valueOf(Calendar.getInstance().get(Calendar.DATE));
			try {
				newDate = sdf.parse(year+"-"+month+"-"+day);
			} catch (ParseException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}			
			String PreOrderTime = newDate.toString();
			//////////////////////////////////////////////////////
			System.out.println(value[7]);
			if(PreOrderTime.equalsIgnoreCase(value[7]))
			{
				Customer temp = new Customer(value[1],value[2],value[3],value[4],value[5],
						value[6],date_s,date_e,Integer.parseInt(value[9]),Integer.parseInt(value[10]),
						Double.parseDouble(value[11]),Integer.parseInt(value[13]),value[12],value[14]);
				ar.add(temp);
			}			
		}	
		operate.rs.close();	
		return ar;
	}
	//获取全部信息
	public static List<Customer> getallinfo() throws SQLException, ClassNotFoundException{
		String sqlS="select * "
				+"from Customer";							
		Management operate = new Management();
		operate.rs = operate.stmt.executeQuery(sqlS);		
		ResultSetMetaData rsmd=operate.rs.getMetaData();	//创建结果集对象
		
		int colCount = rsmd.getColumnCount();		//得到列数
		String[] name = new String[colCount];
		operate.rs.beforeFirst();
		
		String[] value = new String[colCount];		

		List<Customer> ar = new ArrayList<Customer>();  		
		while(operate.rs.next())		//得到各行的属性值
		{			
			for(int i=1;i<=colCount;i++){
				value[i-1]=operate.rs.getString(i);			
			}
			Date date_s = parse(value[7], "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
			Date date_e = parse(value[8], "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
			
			Customer temp = new Customer(value[1],value[2],value[3],value[4],value[5],
			value[6],date_s,date_e,Integer.parseInt(value[9]),Integer.parseInt(value[10]),
			Double.parseDouble(value[11]),Integer.parseInt(value[13]),value[12],value[14]);
			ar.add(temp);
		}
		operate.rs.close();	
		return ar;
	}
	
	//获取全部信息
	public static List<Customer> getallinfobyId(String Id) throws SQLException, ClassNotFoundException{
		String sqlS="select * "
				+" from Customer "
				+" where roomId = "+"'"+Id+"'";							
		Management operate = new Management();
		operate.rs = operate.stmt.executeQuery(sqlS);		
		ResultSetMetaData rsmd=operate.rs.getMetaData();	//创建结果集对象
		
		int colCount = rsmd.getColumnCount();		//得到列数
		String[] name = new String[colCount];
		operate.rs.beforeFirst();
		
		String[] value = new String[colCount];		

		List<Customer> ar = new ArrayList<Customer>();  		
		while(operate.rs.next())		//得到各行的属性值
		{			
			for(int i=1;i<=colCount;i++){
				value[i-1]=operate.rs.getString(i);			
			}
			Date date_s = parse(value[7], "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
			Date date_e = parse(value[8], "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
			
			Customer temp = new Customer(value[1],value[2],value[3],value[4],value[5],
			value[6],date_s,date_e,Integer.parseInt(value[9]),Integer.parseInt(value[10]),
			Double.parseDouble(value[11]),Integer.parseInt(value[13]),value[12],value[14]);
			ar.add(temp);
		}
		operate.rs.close();	
		return ar;
	}

	//added by jkd,4st Jan in 2014
	public static Object[] formatBasicalData(Customer temp){    
		//Object[] head = {"姓名","性别","电话号码","车号","车型","预计租借天数","租借时间","归还时间","费用" };
	  	Object [] str =new Object[9];
	  	str[0] = temp.getName();
	  	str[1] = temp.getSex();
	  	str[2] = temp.getPhoneNum();
	  	str[3] = temp.getRoomId();
	  	str[4] = temp.getRoomTypeId();
	  	str[5] = temp.getLiveDays();
	  	str[6] = temp.getTakeRomTime();
	  	str[7] = temp.getLeaveTime();	  	
	  	str[8] = temp.getDeposit();
	  
	  	return str;
	}
	public static Object[][] getAllData() throws ClassNotFoundException, SQLException {	
		Object[][] temp =new Object[1][14];
		if(getallinfo().size()>0){
			temp = new Object[getallinfo().size()][14];
			Customer customer = null;
			for(int i=0;i<getallinfo().size();i++){
				customer = getallinfo().get(i);
				temp[i] = formatBasicalData(customer);
			}
		}		
		return temp;
	}
	public static Object[][] getAllDatabyId(String ID) throws ClassNotFoundException, SQLException {	
		Object[][] temp =new Object[1][14];
		if(getallinfobyId(ID).size()>0){
			temp = new Object[getallinfobyId(ID).size()][14];
			Customer customer = null;
			for(int i=0;i<getallinfobyId(ID).size();i++){
				customer = getallinfobyId(ID).get(i);
				temp[i] = formatBasicalData(customer);
			}
		}		
		return temp;
	}
	public static Object[][] getAllDatabyMoney() throws ClassNotFoundException, SQLException {	
		Object[][] temp =new Object[1][14];
		if(getallinfobymoney().size()>0){
			temp = new Object[getallinfobymoney().size()][14];
			Customer customer = null;
			List<Customer> list = new ArrayList<Customer>();
			list = getallinfobymoney();
			for(int i=0;i<list.size();i++){
				customer = list.get(i);
				temp[i] = formatBasicalData(customer);
			}
		}		
		return temp;
	}
	public static Object[][] getDataToday() throws ClassNotFoundException, SQLException {	
		Object[][] temp =new Object[1][14];
		if(getallinfotoday().size()>0){
			temp = new Object[getallinfotoday().size()][14];
			Customer customer = null;
			for(int i=0;i<getallinfotoday().size();i++){
				customer = getallinfotoday().get(i);
				temp[i] = formatBasicalData(customer);
			}
		}		
		return temp;
	}
	public static int getDefaultId() {
		return defaultId;
	}


	public static void setDefaultId(int defaultId) {
		Customer.defaultId = defaultId;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getWorkplace() {
		return workplace;
	}
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	public String getPlaceForm() {
		return placeForm;
	}
	public void setPlaceForm(String placeForm) {
		this.placeForm = placeForm;
	}
	public String getHome_adress() {
		return home_adress;
	}
	public void setHome_adress(String home_adress) {
		this.home_adress = home_adress;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getTakeRomTime() {
		return takeRomTime;
	}
	public void setTakeRomTime(Date takeRomTime) {
		this.takeRomTime = takeRomTime;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getLiveDays() {
		return liveDays;
	}
	public void setLiveDays(int liveDays) {
		this.liveDays = liveDays;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	//获取费用；
	public double getFee() {
//		return (RoomTypeData.instance().getRoomTypeById(roomId).getPrice()*liveDays);
		return 0;
	}

	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
  //查找客户信息的结果
	public String getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(String roomTypeId2) {
		this.roomTypeId = roomTypeId2;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	 
	//形如Mon Dec 31 00:00:00 CST 2012字符串转换为相应日期Date 
	public static Date parse(String str, String pattern, Locale locale) { 
		if(str == null || pattern == null) { 
		    return null; 
		} 
		try { 
		    return new SimpleDateFormat(pattern, locale).parse(str); 
		} catch (ParseException e) { 
		    e.printStackTrace(); 
		} 
		return null; 
	} 
// 
	public static String format(Date date, String pattern, Locale locale) { 
	    if(date == null || pattern == null) { 
	        return null; 
	    } 
	    return new SimpleDateFormat(pattern, locale).format(date); 
	}
	public static List<Fine> getallfine() throws SQLException, ClassNotFoundException{
		List <Fine>finelist = new ArrayList<Fine>();
		Booking booking2 = new Booking();
		List<Booking> booklist = booking2.getallinfo();
//		List<Customer> customerlist = Customer.getallinfo();
		List<Booking> booklist1 = new ArrayList<Booking>();
//		float fineprice = Float.parseFloat( Room_Price.getinfo("0"));

//		for (Booking book : booklist) {
//			boolean boo = false;
//			for (Customer customer : customerlist) {
//				if(book.getName().equals(customer.getName()))
//				{	
//					boo = true;
//					break;
//				}
//			}
//			if(boo == false)
//			{
//				booklist1.add(book);
//			}
//			boo = false;
//		}
//		for (Booking booking : booklist1) {
//			Date date = new Date();
//			String orderTime;
//			Date proorderDate = parse(booking.getPreOrderTime(), "EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
//			Date orderDate ;
//				
//			if(booking.getRoomType().equals("提前60天预定"))
//			{
//				if(date.getTime()>(proorderDate.getTime()+60*24*60*60*1000))
//				{
//					finelist.add(new Fine(booking.getName(), booking.getPhoneNumber(), booking.getRoomType(), booking.getPreOrderTime(),fineprice,format(date,"EEE MMM dd HH:mm:ss zzz yyyy", Locale.US)));
//				}
//			}
//			if(booking.getRoomType().equals("预付金预定"))
//			{
//				if(date.getTime()>(proorderDate.getTime()+90*24*60*60*1000))
//				{
//					finelist.add(new Fine(booking.getName(), booking.getPhoneNumber(), booking.getRoomType(), booking.getPreOrderTime(),fineprice,format(date,"EEE MMM dd HH:mm:ss zzz yyyy", Locale.US)));
//				}
//			}
//			if(booking.getRoomType().equals("奖励预定"))
//			{
//				if(date.getTime()>(proorderDate.getTime()+30*24*60*60*1000))
//				{
//					finelist.add(new Fine(booking.getName(), booking.getPhoneNumber(), booking.getRoomType(), booking.getPreOrderTime(),fineprice,format(date,"EEE MMM dd HH:mm:ss zzz yyyy", Locale.US)));
//				}
//			}
//		} 
//		
		
		return finelist;
	}
	public static Object[] formatBasicalFineData(Fine temp){    
		//Object[] head = {"姓名","性别","电话号码","车号","车型","预计租借天数","租借时间","归还时间","费用" };
	  	Object [] str =new Object[6];
	  	str[0] = temp.getCustomname();
	  	str[1] = temp.getPhonenumber();
	  	str[2] = temp.getRoomType();
	  	str[3] = temp.getProOrderTime();
	  	str[4] = temp.getFinePrice();
	  	str[5] = temp.getFineDate();
	  	
//	  	String customname;
//		String phonenumber;
//		String roomType;
//		String ProOrderTime;
//		float FinePrice;
//		String FineDate;
	  	return str;
	}
	public static Object[][] getAllFineData(List<Fine> finelist) throws ClassNotFoundException, SQLException {	
		Object[][] temp =new Object[finelist.size()][6];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = formatBasicalFineData(finelist.get(i));
		}
		return temp;
	}
}
