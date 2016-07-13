package entities;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Transportation{
	private static Transportation hotel;
	private String name;
	private AccountData accountData;
//	private AccountTypeData accountTypeData;
//	private CustomerData customerData;
//	private RoomData roomData;
//	private RoomTypeData roomTypeData;
//	private BookingData bookingData;
	
	public Transportation(){
		accountData=AccountData.instance();
//		accountTypeData=AccountTypeData.instance();
//		customerData=CustomerData.instance();
//		roomData=RoomData.instance();
//		roomTypeData=RoomTypeData.instance();
//		bookingData =BookingData.instance();
	}
	
	
	public Transportation(String name){
		this.name=name;
		accountData=AccountData.instance();
//		accountTypeData=AccountTypeData.instance();
//		customerData=CustomerData.instance();
//		roomData=RoomData.instance();
//		roomTypeData=RoomTypeData.instance();
//		bookingData =BookingData.instance();
	}
	
	public static Transportation instance(){
		if (hotel==null)
			hotel=new Transportation();
		return hotel;
	}
	

	
	public  Transportation getHotel() {
		return hotel;
	}
// 载入 配置
	public static void setHotel(Transportation hotel) {
		Transportation.hotel = hotel;
		AccountData.setAccountData(hotel.getAccountData());
//		AccountTypeData.setAccountTypeData(hotel.getAccountTypeData());
//		BookingData.setBookingData(hotel.getBookingData());
//		CustomerData.setCustomerData(hotel.getCustomerData());
//		RoomData.setRoomData(hotel.getRoomData());
//		RoomTypeData.setRoomTypeData(hotel.getRoomTypeData());
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AccountData getAccountData() {
		return accountData;
	}

	public void setAccountData(AccountData accountData) {
		this.accountData = accountData;
	}

//	public AccountTypeData getAccountTypeData() {
//		return accountTypeData;
//	}

//	public void setAccountTypeData(AccountTypeData accountTypeData) {
//		this.accountTypeData = accountTypeData;
//	}

//	public CustomerData getCustomerData() {
//		return customerData;
//	}

//	public void setCustomerData(CustomerData customerData) {
//		this.customerData = customerData;
//	}

//	public RoomData getRoomData() {
//		return roomData;
//	}

//	public void setRoomData(RoomData roomData) {
//		this.roomData = roomData;
//	}

//	public RoomTypeData getRoomTypeData() {
//		return roomTypeData;
//	}

//	public void setRoomTypeData(RoomTypeData roomTypeData) {
//		this.roomTypeData = roomTypeData;
//	}

//	public BookingData getBookingData() {
//		return bookingData;
//	}

//	public void setBookingData(BookingData bookingData) {
//		this.bookingData = bookingData;
//	}
	//系统登录功能
	public boolean login(String userName,String passWord,String type) throws SQLException, Exception{
		return accountData.loginCheck(userName, passWord,type);
	}
	
//录入功能
//	//预定基本信息的录入
//	public void bookRoom(String name,String phoneNum,int roomTypeId){
//		Booking booking =new Booking(name ,phoneNum,roomTypeId);
//		bookingData.addBooking(booking);
//	}
	//录入客户信息
//	public void orderRoom(String name, String idNumber, String workplace,
//						String placeForm, String home_adress, String sex,
//						Date takeRomTime, Date leaveTime, int age, int liveDays,
//	double deposit,int roomId,int roomTypeId,String phoneNum) {
//		Customer customer =new Customer(name, idNumber,workplace,
//				placeForm, home_adress, sex,
//				takeRomTime,leaveTime,age,liveDays,
//				deposit,roomId, roomTypeId, phoneNum);
//		
//		customerData.addCustomer(customer);
//	//	System.out.print(roomId+" ");
//		//将房间标记为占用,房间客人Id 更新;
//		Room room=RoomData.instance().getRoomByRoomId(roomId);
//		room.setTaken(true);
//		room.setCoustomerId(customer.getId());
//	}
	
	//录入房间信息
	
//	public void addRoom(int roomId ,boolean isTaken, int roomTypeId, int coustomerId){
//		
//		Room room =new Room(roomId ,isTaken,roomTypeId,coustomerId);
//		roomData.addRoom(room);
//	}
	
	//录入客服账户
	
	public void addAccount(String userName,String passWord,int accountTypeId){
		
		Account account =new Account(userName,passWord,accountTypeId);
		accountData.addAccount(account);
	}
	// 修改账户密码	
	public void  setAccountPassword(String password){
		String username=accountData.getCurrAccountName();
//		accountData.getAccountByName(username).setPassWord(password);
	}
	//录入房间类型信息
	
//	public void addRoomType(String typeName,double price){
//		RoomType roomType=new RoomType(typeName,price);
//		roomTypeData.addRoomType(roomType);
//		
//	}
	
	//修改房间价格
	
//	public void setPriceOfRoom(int roomTypeId,double price){
//		roomTypeData.getRoomTypeById(roomTypeId).setPrice(price);
//	}
//查询功能
	//查询客户信息
//	public Customer[] searchCustomerByName(String name){
//		Customer[] customers=customerData.getCustomerByName(name).toArray(null);
//		return customers;
//	}
	
//	public Customer[] searchCustomerBySex(String sex){
//		Customer[] customers =customerData.getCustomerBySex(sex).toArray(null);
//		
//		return customers;
//	}
	
//	public Customer[] searchCustomerByPlaceForm(String placeForm){
//		Customer [] customers =customerData.getCustomerByPlace(placeForm).toArray(null);
//		return customers;
//	}
	
//	public Customer searchCustomerById(int id){
//		Customer  customers =customerData.getCustomerById(id);
//		return customers;
//	}
	
//	public Customer[] searchCustomerByWorkPlace(String workPlace){
//		Customer[]  customers =customerData.getCustomerByWorkPlace(workPlace).toArray(null);
//		return customers;
//	}
	//查询客房信息
	
//	public Room[] searchRoomByState(boolean isTaken){
//		Room[] room =roomData.getRoomByState(isTaken).toArray(new Room[1]);
//		return room;
//	}
//	public Room[] searchRoomByTypeId(int typeId){
//		Room[] room =roomData.getRoomByTypeId(typeId).toArray(null);
//		return room;
//	}
	
//	public Room searchRoomByCustomerId(int customerId){
//		Room room =roomData.getRoomByCustomerId(customerId);
//		return room;
//	}
	
//退房结账信息
	//精简信息表
//	public String[] getPayInfo(Customer customer,Date realLeaveDate){
//		//，显示客人缴纳押金金额、实际入住天数、客房价格、实际住宿费、住宿费差额及余额等信息。
//		String [] info=new String[7];
//		info[0]=Integer.toString(customer.getId());
//		info[1]=Double.toString(customer.getDeposit());
//		long realLiveDays =getRealLiveDays(customer.getTakeRomTime(),realLeaveDate);
//		info[2]=Long.toString(realLiveDays);
//		
//		System.out.print(customer.getRoomTypeId() );
//		
//		double priceOfRoom =roomTypeData.getRoomTypeById(customer.getRoomTypeId()).getPrice();
//		info[3]=Double.toString(priceOfRoom);
//		double price =priceOfRoom*realLiveDays;
//		info[4]=Double.toString(price);
//		info[5]=Double.toString(price-customer.getDeposit());
//		info[6]=Double.toString(customer.getDeposit()-price);	
//		
//		return info;
//	}
//	
//	//根据客户ID获取详细信息表
//		public Object[] getDetailsByCustomerId(int customerId) {
//			// TODO Auto-generated method stub
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//			Object[] info=new Object[21];
//			int roomId =CustomerData.instance().getCustomerById(customerId).getRoomId();
//			Room room =RoomData.instance().getRoomByRoomId(roomId);
//			
//			//房间信息
//			info[0]=roomId;
//			info[1]=RoomTypeData.instance().getRoomTypeById(room.getRoomTypeId()).getTypeName();
//			double priceOfRoom=RoomTypeData.instance().getRoomTypeById(room.getRoomTypeId()).getPrice();
//			info[2]=priceOfRoom;
//			info[3]=room.isTaken()?"占用":"可用";
//			
//			//客户信息
//			Customer customer =CustomerData.instance().getCustomerById(customerId);
//			info[4]=Integer.toString(customerId);
//			info[5]=customer.getName();
//			info[6]=customer.getSex();
//			info[7]=Integer.toString(customer.getAge());
//			info[8]=customer.getIdNumber();
//			info[9]=customer.getPhoneNum();
//			info[10]=customer.getWorkplace();
//			info[11]=customer.getPlaceForm();
//			info[12]=customer.getHome_adress();
//			info[13]=((customer.getTakeRomTime()==null)? "":formatter.format(customer.getTakeRomTime()));
//			info[14]=customer.getLiveDays();
//			info[15]=((customer.getLeaveTime()==null)? "":formatter.format(customer.getLeaveTime()));
//			
//			//付费信息
//			if(room.getCoustomerId()==customerId)
//				info[16]="未付费";
//			else
//				info[16]="已付费";
//			info[17]=customer.getDeposit();
//			long realLiveDays =getRealLiveDays(customer.getTakeRomTime(),new Date());
//
//			if(realLiveDays<0){
//				info[18]="--";
//				info[19]="--";
//				info[20]=0;
//			}else{
//				if(realLiveDays==0){
//					realLiveDays+=1;
//				}
//				
//				info[18]=realLiveDays;
//				double price =priceOfRoom*realLiveDays;
//				info[19]=price;
//				if(info[16].toString().equals("未付费")){
//					info[20]=price-customer.getDeposit();
//				}else{
//					info[20]="--";
//				}
//			}
//			
//			return info;
//		}
//	//退房标记
//		public void handRoom(Customer cu,Date leaveTime){		
//			//将房间标记为可用,房间客人Id 更新为-1 ，表示没有客户;
//			//如果退房时间超出预定的退房时间，则更新客户信息然后 做退房标记
//			if(leaveTime.after(cu.getLeaveTime())){
//				cu.setLeaveTime(leaveTime);
//			}
//			Room room =RoomData.instance().getRoomByRoomId(cu.getRoomId());
//			room.setCoustomerId(-1);
//			room.setTaken(false);
//		}
//
////获取实际入住时间	
//	public long getRealLiveDays(Date beginDate,Date endDate){
//		
//	     long day=0;
//	        //SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");    
//	        day=(endDate.getTime()-beginDate.getTime())/(24*60*60*1000);    
//			//System.out.println("相隔的天数="+day);      
//	     return day;   
//	     
//	}
//	
//
//	
//// 统计功能
//	
//	//统计一段时间内各类客房的入住情况
//	public int[] CountInfoOfDifferentTypeBytime(Date beginDate,Date endDate){
//		int [] countInfo =new int[roomTypeData.getRoomTypeList().size()];
//		List<Customer> customerList = customerData.getCustomerList();
//		for(int i=0;i<customerList.size();i++){
//			Customer customer =customerList.get(i);
//			if(customer.getTakeRomTime().after(beginDate)&&customer.getTakeRomTime().before(endDate))
//			{
//				countInfo[customer.getRoomTypeId()]++;
//			}
//		}
//		
//		return countInfo;
//	}
////统计全年各月份的客房收入
//	public double[] perMonthIncome(int year){
//		Calendar cal =Calendar.getInstance();
//		double [] Income =new double[12];
//		Customer customer;
//		List<Customer> customerList = customerData.getCustomerList();
//		for(int i=0;i<customerList.size();i++){
//		
//			customer = customerList.get(i);
//			if(customer.getLeaveTime()!=null){
//				long days =(customer.getLeaveTime().getTime()-customer.getTakeRomTime().getTime())/(24*60*60*1000);
//				double pay =roomTypeData.getRoomTypeById(customer.getRoomTypeId()).getPrice()*days;
//				cal.setTime(customer.getTakeRomTime());
//				Income[cal.get(Calendar.MONTH)+1]+=pay;
//			}
//			
//			
//		}
//		return Income;
//		
//	}
////统计一段时间内各类客房的入住率
//
//
//
//	
////
//	
	
}
