package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> lista = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int entrada = sc.nextInt();
		
		for (int i = 1; i <= entrada; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char res = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income:");
			double anualIncome = sc.nextDouble();
			if(res == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				lista.add(new Individual(name, anualIncome, healthExpenditures));
			}else if(res == 'c') {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				lista.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}
		System.out.println();
		System.out.println("TAXES PAID:");
		double temp = 0.0;
		for(TaxPayer tp : lista) {
			System.out.println(tp.getName()+": $ " + String.format("%.2f", tp.tax()));
			temp += tp.tax();
		}
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", temp));
		sc.close();

	}

}
