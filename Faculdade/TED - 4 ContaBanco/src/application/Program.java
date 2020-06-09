package application;

import javax.swing.JOptionPane;

import entity.Bank;

public class Program {

	public static void main(String[] args) {
		
		Bank account = new Bank();
		
		account.addAccount("Yuri Christian", 11221, 1221, 1000.00);
		account.addAccount("Najla Menezes", 34443, 3443,17000.00);
		account.addAccount("Kruba Macedo", 55566, 5665, 3000.00);
		account.addAccount("Diego Christenson", 77888, 7887, 9000.00);
		account.addAccount("Romany Nobrega", 17177, 1771, 20000.00);
		
		JOptionPane.showMessageDialog(null, account.highestBalance());

	}

}
