package dao;

import java.util.ArrayList;
import java.util.List;


public class BikeTypeData{	
	public static BikeTypeData roomTypeData;
	
	
//����ģʽ��ֻ����һ��ʵ����������ʵ���Զ������ջ��ƻ���	
	public static BikeTypeData instance(){
		if(roomTypeData==null){
			roomTypeData=new BikeTypeData();
		}	
		return roomTypeData;
	}
	
	
	public Object[] FormatRoomTypeName(){
		List<String> tempName=new ArrayList<String>();
		tempName.add("�ɸ�");
		tempName.add("��ͨ");
		tempName.add("�ƴ�");
		tempName.add("����");
		tempName.add("���");
		tempName.add("�й�");
		tempName.add("����");
		return tempName.toArray();
	}
	public static BikeTypeData getRoomTypeData() {
		return roomTypeData;
	}
	public static void setRoomTypeData(BikeTypeData roomTypeData) {
		BikeTypeData.roomTypeData = roomTypeData;
	}
}
