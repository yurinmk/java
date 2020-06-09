package entity;

public class Account {
	
	private String clientName;
	private int accountNumber;
	private int agencyNumber;
	private double balance;
	
	public Account() {
	}

	public Account(String clientName, int accountNumber, int agencyNumber, double balance) {
		this.clientName = clientName;
		this.accountNumber = accountNumber;
		this.agencyNumber = agencyNumber;
		this.balance = balance;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAgencyNumber() {
		return accountNumber;
	}

	public void setAgencyNumber(int agencyNumber) {
		this.agencyNumber = agencyNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Name: " + clientName 
				+ "\nAccount: " + accountNumber 
				+ "\nAgency: "
				+ agencyNumber + "\nBalance: " + balance;
	}
	

}
