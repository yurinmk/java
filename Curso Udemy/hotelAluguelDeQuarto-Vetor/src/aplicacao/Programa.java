package aplicacao;

import java.util.Scanner;

import entidades.Hotel;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Hotel[] hotel = new Hotel[10];

		System.out.print("Quantos quartos serão alugados: ");
		int qntd = sc.nextInt();
		System.out.println();

		for (int i = 0; i < qntd; i++) {
			System.out.println("Aluguel #" + (i + 1));
			System.out.print("Nome: ");
			sc.nextLine();
			String nomeDoCliente = sc.nextLine();
			System.out.print("Email: ");
			String emailDoCliente = sc.nextLine();
			System.out.print("Quarto: ");
			int numeroDoQuarto = sc.nextInt();
			hotel[numeroDoQuarto] = new Hotel(nomeDoCliente, emailDoCliente, numeroDoQuarto);
			System.out.println();
		}
		for (int j = 0; j < 10; j++) {
			if (hotel[j] != null) {
				System.out.println(hotel[j].getQuartoDoCliente() + ": " + hotel[j].getNomeDoCliente() + ", "
						+ hotel[j].getEmailDoCliente());
			}
		}

		sc.close();

	}

}
