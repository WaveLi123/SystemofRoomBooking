package entities_2;

import java.io.Serializable;

public class AccountType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7828169834813926090L;
	private int id;
	private String typeName;
	private int userPermissions; // 0 �ͷ� 1 ����Ա
	
	public AccountType(int id ,String typeName,int userPermissions){
		this.id=id;
		this.typeName=typeName;
		this.userPermissions=userPermissions;
	}
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	public String getTypeName(){
		return typeName;
	}
	
	public void setTypeName(String typeName){
		
		this.typeName=typeName;
	}
	
	public int getUserPermissions(){
		return userPermissions;
	}
	
	public void setUserPermissions(int userPermissions){
		this.userPermissions=userPermissions;
	}
}
