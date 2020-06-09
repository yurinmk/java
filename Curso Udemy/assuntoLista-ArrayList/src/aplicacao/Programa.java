package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Programa {

	public static void main(String[] args) {

		// Instancia uma lista do tipo String
		List<String> lista = new ArrayList<>();
		// adiciona elementos na lista
		lista.add("Yuri");
		lista.add("Najla");
		lista.add("Kruba");
		lista.add("Romany");
		lista.add("Ronaldo");
		lista.add("Rick");
		// adiciona um elemneto na posição desejada da lista
		lista.add(2, "Namikoka");
		// .size() retorna o tamanho da lista
		System.out.println(lista.size());
		// for each
		for (String x : lista) {
			System.out.println(x);
		}
		System.out.println("------------------------");
		// Remove um elemento da lista
		lista.remove(2);
		// Remove todos os elementos da lista que tiver a letra R
		lista.removeIf(x -> x.charAt(0) == 'R');
		for (String x : lista) {
			System.out.println(x);
		}
		System.out.println("------------------------");
		// Encontra a posição de um elemento da lista
		System.out.println("Index of Yuri: " + lista.indexOf("Yuri"));
		// Quando o index of não encontra um elemento na lista o retorno é -1
		System.out.println("Index of Namikoka: " + lista.indexOf("Namikoka"));
		System.out.println("------------------------");
		/*
		 * Cria uma nova lista e converte em .stream, depois usa o .filter para filtrar
		 * todos os elementos que são iguais a Y. Como o .stream não é compatível com
		 * lista, usa-se .collect(Collectors.toList()) para converter novamente em lista
		 */
		List<String> resultado = lista.stream().filter(x -> x.charAt(0) == 'Y').collect(Collectors.toList());
		for (String x : resultado) {
			System.out.println(x);
		}
		System.out.println("------------------------");
		lista.add("Yashiro");
		lista.add("Yamazaki");
		/*
		 * .findFirst() seleciona o primeiro elemento que tiver a letra Y e adiciona na variável nome 
		 * .orElse(null) vai retornar null caso não exista nenhum elemento com a letra Y
		 */
		String nome = lista.stream().filter(x -> x.charAt(0) == 'Y').findFirst().orElse(null);
		System.out.println(nome);
		nome = lista.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null);
		System.out.println(nome);
		System.out.println(lista);
	}

}
