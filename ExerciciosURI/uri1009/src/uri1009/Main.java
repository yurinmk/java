package uri1009;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		String nomeDoVendedor = sc.nextLine();
		double salarioFixo = sc.nextDouble();
		double totalDeVendas = sc.nextDouble();
		
		double bonus = totalDeVendas * 0.15;
		double salarioTotal = salarioFixo + bonus;
		
		System.out.printf("TOTAL = R$ %.2f\n" , salarioTotal);
		
		sc.close();
		
	}

}
