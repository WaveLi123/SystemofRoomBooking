package entities_2;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.AccountData;
import dao.BikeTypeData;

public class Transport_B{
	private static Transport_B hotel;
	private String name;
	private AccountData accountData;
	private BikeTypeData roomTypeData;	
	
	public Transport_B(){
		accountData=AccountData.instance();			
	}
	
	
	public Transport_B(String name){
		this.name=name;
		accountData=AccountData.instance();		
	}
	
	public static Transport_B instance(){
		if (hotel==null)
			hotel=new Transport_B();
		return hotel;
	}
	

	
	public  Transport_B getHotel() {
		return hotel;
	}
// ���� ����
	public static void setHotel(Transport_B hotel) {
		Transport_B.hotel = hotel;
		AccountData.setAccountData(hotel.getAccountData());			
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


	public BikeTypeData getRoomTypeData() {
		return roomTypeData;
	}

	public void setRoomTypeData(BikeTypeData roomTypeData) {
		this.roomTypeData = roomTypeData;
	}


	//ϵͳ��¼����
	public boolean login(String userName,String passWord){
		return accountData.loginCheck(userName, passWord);
	}
	
//¼�빦��
	//¼��ͻ���Ϣ
	public void orderRoom(String name, String idNumber, String workplace,
						String placeForm, String home_adress, String sex,
						Date takeRomTime, Date leaveTime, int age, int liveDays,
	double deposit,int roomId,String roomTypeId,String phoneNum) throws ClassNotFoundException, SQLException {
		Customer customer =new Customer(name, idNumber,workplace,
				placeForm, home_adress, sex,
				takeRomTime,leaveTime,age,liveDays,
				deposit,roomId, roomTypeId, phoneNum);
		
		//customerData.addCustomer(customer);
		customer.storeToDB();
		//��ǳ���״̬���Ƿ���裬�����ߣ�
		Bike room = new Bike(roomId,true,roomTypeId,String.valueOf(idNumber),"200");
		room.updateDB();
	}
}
