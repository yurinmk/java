package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidades.Funcionario;


public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Funcionario entrada;
		
		entrada = new Funcionario();
		
		System.out.print("Nome: ");
		entrada.nomeDoFuncionario = sc.nextLine();
		System.out.print("Salário Bruto: ");
		entrada.salarioBruto = sc.nextDouble();
		System.out.print("Imposto: ");
		entrada.imposto = sc.nextDouble();
		
		System.out.println("Empregado: " + entrada);
		
		System.out.print("Porcentagem de acréscimo no salário? ");
		double porcentagem = sc.nextDouble();
		entrada.porcentagemDeAcrescimo(porcentagem);
		
		
		System.out.print("Upgrade do Salário: " + entrada);
		
		
		sc.close();

	}

}
