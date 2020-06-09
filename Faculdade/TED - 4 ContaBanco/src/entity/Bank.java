package entity;

import java.util.ArrayList;

public class Bank {
	
	private final String BANK_NAME = "Central Bank";
	private ArrayList<Account> list = new ArrayList<>();
	
	public Bank() {
	}

	public ArrayList<Account> getList() {
		return list;
	}

	public void setList(ArrayList<Account> list) {
		this.list = list;
	}
	
	public void addAccount(String clientName, int accountNumber, int agencyNumber, double balance) {
		list.add(new Account(clientName, accountNumber, agencyNumber, balance));
	}
	
	public String highestBalance() {
		double tempBalance = list.get(0).getBalance();
		String temp = "";
		for (Account x : list) {
			if(tempBalance <= x.getBalance()) {
				temp = "Account With Higher Balance\n\nInstitution: " + BANK_NAME + "\n" + x;
				tempBalance = x.getBalance();
			}
		}
		return temp;
	}
}
