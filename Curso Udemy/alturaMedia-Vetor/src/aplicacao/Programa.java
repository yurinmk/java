package aplicacao;

import java.util.Locale;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		double[] vetor = new double[n];
		double media = 0.0;
		
		for(int i = 0; i < n; i++) {
			vetor[i] = sc.nextDouble();
			media += vetor[i]; 
		}
		System.out.printf("Altura média: %.2f" , media / n);
		
		sc.close();

	}

}
