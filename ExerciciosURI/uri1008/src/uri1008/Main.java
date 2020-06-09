package uri1008;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		int numDoFuncionario = sc.nextInt();
		double numDeHorasTrabalhada = sc.nextDouble();
		double valorRecebidoPorHora = sc.nextDouble();
		
		double salary = numDeHorasTrabalhada * valorRecebidoPorHora;
		System.out.println("NUMBER = " + numDoFuncionario);
		System.out.printf("SALARY = U$ %.2f\n" , salary);
		
		sc.close();

	}

}
