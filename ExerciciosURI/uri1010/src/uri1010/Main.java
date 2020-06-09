package uri1010;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int codPeca1, qntdDePeca1,codPeca2, qntdDePeca2;
		double valorDaPeca1,valorDaPeca2,totalParaPagar;
		
		codPeca1 = sc.nextInt();
		qntdDePeca1 = sc.nextInt();
		valorDaPeca1 = sc.nextDouble();
		codPeca2 = sc.nextInt();
		qntdDePeca2 = sc.nextInt();
		valorDaPeca2 = sc.nextDouble();
		
		totalParaPagar = (valorDaPeca1 * qntdDePeca1) + (valorDaPeca2 * qntdDePeca2); 
		
		System.out.printf("VALOR A PAGAR: R$ %.2f\n" , totalParaPagar);
		

		
		sc.close();

	}

}
