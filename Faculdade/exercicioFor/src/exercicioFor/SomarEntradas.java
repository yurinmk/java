package exercicioFor;

import java.util.Scanner;

public class SomarEntradas {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int entrada = sc.nextInt();
		int soma = 0;
		for(int i = 0; i < entrada; i++) {
			int enter = sc.nextInt();
			soma += enter;
		}
		System.out.println(soma);
		
		sc.close();
		
	}

}
