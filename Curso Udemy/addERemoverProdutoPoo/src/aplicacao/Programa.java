package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("Digite um Produto:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Pre�o: ");
		double preco = sc.nextDouble();
		Produto produto = new Produto(nome, preco);
		
		System.out.println(produto);
		System.out.print("Quantos produtos voc� quer adicionar no estoque: ");
		int quantidade = sc.nextInt();
		produto.adicionarProdutos(quantidade);
		
		System.out.println(produto);
		
		System.out.print("Quantos produtos voc� quer remover no estoque: ");
		quantidade = sc.nextInt();
		produto.removerProdutos(quantidade);
		System.out.println(produto);
		
	
		
		sc.close();
	
	}

}
