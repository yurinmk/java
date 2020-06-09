package uri1017;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int tempoGastoNaViagem = sc.nextInt();
		int velocidadeMediaDoVeiculo = sc.nextInt();
		
		double totalLitrosGasto = velocidadeMediaDoVeiculo / 12.0 * tempoGastoNaViagem;
		
		System.out.printf("%.3f\n" , totalLitrosGasto);
		
		sc.close();

	}

}
