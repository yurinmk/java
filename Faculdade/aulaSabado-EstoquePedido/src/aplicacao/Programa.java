package aplicacao;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidade.Supermercado;

public class Programa {

	public static void main(String[] args) {

		ArrayList<Supermercado> lista = new ArrayList<>();

		Supermercado produto1 = new Supermercado("Café", 2.50, 120);
		Supermercado produto2 = new Supermercado("Cuscuz", 1.05, 100);
		Supermercado produto3 = new Supermercado("Azeite", 6.00, 50);
		Supermercado produto4 = new Supermercado("Macarrão", 2.55, 130);
		Supermercado produto5 = new Supermercado("Arroz", 2.00, 150);

		lista.add(produto1);
		lista.add(produto2);
		lista.add(produto3);
		lista.add(produto4);
		lista.add(produto5);

		Object[] op = { "DINHEIRO", "CHEQUE", "CARTÃO" };
		
		int i = 1;
		String temp = "";
		for (Supermercado x : lista) {
			temp += i + " - " + x;
			i++;
		}

		double valorTotal = 0.0;
		String temp2 = "";
		int qnt = Integer
				.parseInt(JOptionPane.showInputDialog(temp + "\nQuantos produtos da lista você deseja comprar?"));
		for (int j = 0; j < qnt; j++) {
			int prod = Integer.parseInt(JOptionPane.showInputDialog(temp + "\nIdentificador do produto:"));
			int qntP = Integer.parseInt(JOptionPane.showInputDialog(temp + "\nQuantidade:"));
			valorTotal += lista.get(prod - 1).valorTotal(qntP);
			temp2 += lista.get(prod - 1).produto + ", " + qntP + "un. -" + " Total R$: "
					+ lista.get(prod - 1).preco * qntP + "\n";
		}
		JOptionPane.showOptionDialog(null,
				"NOTA\n\n" + temp2 + "\n" + "Valor Total da Compra: R$: " + valorTotal + "\n\nComo deseja pagar?\n\n",
				"FORMA DE PAGAMENTO", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);

	}

}
