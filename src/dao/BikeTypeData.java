package dao;

import java.util.ArrayList;
import java.util.List;


public class BikeTypeData{	
	public static BikeTypeData roomTypeData;
	
	
//单例模式，只保留一个实例，其它的实例自动被回收机制回收	
	public static BikeTypeData instance(){
		if(roomTypeData==null){
			roomTypeData=new BikeTypeData();
		}	
		return roomTypeData;
	}
	
	
	public Object[] FormatRoomTypeName(){
		List<String> tempName=new ArrayList<String>();
		tempName.add("飞鸽");
		tempName.add("京通");
		tempName.add("黄达");
		tempName.add("流星");
		tempName.add("年代");
		tempName.add("中古");
		tempName.add("环游");
		return tempName.toArray();
	}
	public static BikeTypeData getRoomTypeData() {
		return roomTypeData;
	}
	public static void setRoomTypeData(BikeTypeData roomTypeData) {
		BikeTypeData.roomTypeData = roomTypeData;
	}
}
