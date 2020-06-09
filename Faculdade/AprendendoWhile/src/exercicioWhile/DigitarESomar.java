package exercicioWhile;

import java.util.Scanner;

public class DigitarESomar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double entrada = sc.nextDouble(); 
		double soma = 0;
		while(entrada != 0) {
			soma += entrada;
			entrada = sc.nextDouble();
		}
		System.out.println(soma);
		
		sc.close();

	}

}
