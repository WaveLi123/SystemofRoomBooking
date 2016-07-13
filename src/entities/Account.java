package entities;

import java.io.Serializable;

public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1955439152117092230L;
	private int id;
	private static int defualtId;
	private String userName;
	private String passWord;
	private int accountTypeId;
	
	public Account(String userName,String passWord,int accountTypeId){
		setId(++defualtId);
		this.userName=userName;
		this.passWord=passWord;
		this.accountTypeId=accountTypeId;
	}
	
	public String getUserName(){
		
		return userName;
	}
	
	public void setUserName(String userName){
		
		this.userName=userName;
	}
	
	public String getPassWord(){
		return passWord;
	}
	
	public void setPassWord(String passWord){
		this.passWord=passWord;
	}
	
	public int getAccountType(){
		
		return accountTypeId;
	}
	
	public void setAccountType(int accountTypeId){
		
		this.accountTypeId=accountTypeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
