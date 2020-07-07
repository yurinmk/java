package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {
		
		Account acc = new Account(1001, "Alex", 1000.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
		
		// UPCASTING
		
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Ester", 0.0, 200.0);
		Account acc3 = new SavingsAccount(1004, "Carla", 0.0, 0.01);
		
		// DOWNCASTING
		
		BusinessAccount acc4 = (BusinessAccount) acc2;
		acc4.loan(100.0);
		
		// BusinessAccount acc5 = (BusinessAccount) acc3; - Erro
		
		if (acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount) acc3;
			acc5.loan(200.0);
			System.out.println("Emprestimo!");
		}
		
		if (acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount) acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}
		
		acc.withdraw(500.0);
		System.out.println(acc.getBalance());
		
		Account sacc = new SavingsAccount(1030,"Najla",1000.0,0.01);
		sacc.withdraw(500.0);
		System.out.println(sacc.getBalance());
		
		Account bacc1 = new BusinessAccount(1020, "Kleber", 1000.0, 200.0);
		bacc1.withdraw(500.0);
		System.out.println(bacc1.getBalance());

	}

}
