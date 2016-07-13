package dao;

import java.util.ArrayList;
import java.util.List;

import entities_2.Account;

public class AccountData {
	private static AccountData accountData;

	private static String CurrAccountName;
	private List<Account> accountList;

	public AccountData() {
		accountList = new ArrayList<Account>();
		accountList.add(new Account("admin", "admin", 1));
		setCurrAccountName("User");
	}

	public static AccountData instance() {
		if (accountData == null)
			accountData = new AccountData();
		return accountData;
	}

	// 获取管理员的账户信息；
	public Account getAccountByName(String username) {
		Account currentUser = null;
		for (int i = 0; i < accountList.size(); i++) {

			if (accountList.get(i).getUserName().equals(username)) {
				currentUser = accountList.get(i);
				System.out.print(username + " ");
			}
		}
		return currentUser;

	}

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
	public boolean loginCheck(String userName, String passWord) {
		Account currentAccount = getAccountByName(userName);
		if (currentAccount.getPassWord().equals(passWord)) {
			setCurrAccountName(userName);
			return true;
		} else {
			return false;
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
