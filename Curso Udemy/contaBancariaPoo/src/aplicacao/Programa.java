package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidades.Conta;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Conta conta;

		System.out.print("Entre com o número da conta: ");
		int numeroDaConta = sc.nextInt();
		System.out.print("Entre com o nome do titular: ");
		sc.nextLine();
		String nomeDoCliente = sc.nextLine();
		System.out.print("Deseja realizar um depósito inicial (s/n)? ");
		char teste = sc.next().charAt(0);
		double valor;
		if (teste == 's') {
			System.out.print("Entre com o valor do depósito inicial: ");
			valor = sc.nextDouble();
			conta = new Conta(nomeDoCliente, numeroDaConta, valor);
		} else {
			conta = new Conta(nomeDoCliente, numeroDaConta);
		}
		System.out.println();
		System.out.println(conta);

		System.out.println();
		System.out.print("Entre com o valor do deposito: ");
		valor = sc.nextDouble();
		conta.deposito(valor);
		System.out.println(conta);
		System.out.println();
		System.out.print("Entre com o valor do saque: ");
		valor = sc.nextDouble();
		conta.saque(valor);
		System.out.println(conta);

		sc.close();

	}

}
