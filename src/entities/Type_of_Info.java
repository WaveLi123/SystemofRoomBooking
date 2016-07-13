package entities;

import java.util.ArrayList;
import java.util.List;

public class Type_of_Info{

	public static Object[] FormatInfoTypeName(){
		List<String> tempName=new ArrayList<String>();
		tempName.add("预计房间入住报表");
		tempName.add("预计房间收入报表");
		tempName.add("奖励报表");
		return tempName.toArray();	
	}
}
