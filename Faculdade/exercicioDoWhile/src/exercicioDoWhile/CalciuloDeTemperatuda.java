package exercicioDoWhile;

import java.util.Scanner;

public class CalciuloDeTemperatuda {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		char pergunta;
		do {
			System.out.print("Digite uma temperatuda em Celsius: ");
			double celsius = sc.nextDouble();
			double fahrenheit = ((9 * celsius) / 5) + 32;
			System.out.print("Equivalente em Fahrenheit: " + fahrenheit);
			System.out.print("\nDeseja repetir (s/n)? ");
			
			pergunta = sc.next().charAt(0);
		}while(pergunta  ==	 's');
		
		sc.close();

	}

}
