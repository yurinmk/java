package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int entrada = sc.nextInt();

		Produto[] produto = new Produto[entrada];
		
		double temp = 0.0;
		//produto.length é o tamanho do vetor criado.
		for (int i = 0; i < produto.length; i++) {
			String nomeDoProduto = sc.nextLine();
			sc.nextLine();
			double precoDoProduto = sc.nextDouble();
			produto[i] = new Produto(nomeDoProduto, precoDoProduto);
			temp += produto[i].getPrecoDoProduto();
		}
		System.out.printf("Preço Médio: %.2f" , temp / entrada);

		sc.close();
	}

}
