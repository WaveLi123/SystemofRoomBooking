package entities;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Account;
import entities.Login_Manager;

public class AccountData {
	private static AccountData accountData;

	private static String CurrAccountName;
	private List<Account> accountList;

	public AccountData() {
		accountList = new ArrayList<Account>();
		accountList.add(new Account("WaveLi", "wavejkd123", 1));
		setCurrAccountName("Admin");
	}

	public static AccountData instance() {
		if (accountData == null)
			accountData = new AccountData();
		return accountData;
	}
//changed by jkd 2nd Jan,in 2014
//	// 获取管理员的账户信息；
//	public Account getAccountByName(String username) {
//		Account currentUser = null;
//		//changed by jkd,2nd Jan in 2014
//		accountList.removeAll(accountList);
//		for (int i = 0; i < accountList.size(); i++) {
//						
//			if (accountList.get(i).getUserName().equals(username)) {
//				currentUser = accountList.get(i);
//				System.out.print(username + " ");
//			}
//		}
//		return currentUser;
//	}

	public static AccountData getAccountData() {
		return accountData;
	}

	public static void setAccountData(AccountData accountData) {
		AccountData.accountData = accountData;
	}
	// 添加管理员
	public void addAccount(Account account) {
		accountList.add(account);
	}
	// 登录检查
	public boolean loginCheck(String userName, String passWord,String type) throws SQLException, Exception {
		//changed by jkd,2nd Jan in 2014
//		Account currentAccount = getAccountByName(userName);
//		if (currentAccount.getPassWord().equals(passWord)) {
//			setCurrAccountName(userName);
//			return true;
//		} else {
//			return false;
//		}
		if(type.equalsIgnoreCase("Manager")){
			Login_Manager login = new Login_Manager();
			return (login.Test(userName,passWord));
		}		
		else if(type.equalsIgnoreCase("Employee")){
			Login_Employee login = new Login_Employee();
			return (login.Test(userName,passWord));
		}
		else{
			Login_Customer login = new Login_Customer();
			return (login.Test(userName,passWord));
		}
	}
	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	// 获取
	public List<Account> getAccountList() {
		return accountList;
	}
	public String getCurrAccountName() {
		return CurrAccountName;
	}
	public static void setCurrAccountName(String currAccountName) {
		CurrAccountName = currAccountName;
	}

}
