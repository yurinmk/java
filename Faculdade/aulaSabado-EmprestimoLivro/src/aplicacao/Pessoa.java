package aplicacao;

import javax.swing.JOptionPane;

import entidade.Emprestimo;
import entidade.Livro;

public class Pessoa {

	public static void main(String[] args) {

		Livro livros = new Livro();
		Emprestimo aluguel = new Emprestimo();
		int qnt = Integer.parseInt(
				JOptionPane.showInputDialog(null, livros.listaDeLivros() + "\n" + "Quantos livros você deseja alugar:",
						"Quantidade de aluguel", JOptionPane.QUESTION_MESSAGE));
		String nome = JOptionPane.showInputDialog(null, "Nome:", "Digite seu Nome", JOptionPane.QUESTION_MESSAGE);

		for (int i = 0; i < qnt; i++) {
			int ident = Integer.parseInt(JOptionPane.showInputDialog(null, livros.listaDeLivros(),
					"Identificador(es) do livro que deseja alugar", JOptionPane.INFORMATION_MESSAGE));
			Emprestimo addEmp = new Emprestimo(nome, livros.getListaDeLivros().get(ident - 1));
			aluguel.realizarEmprestimo(addEmp);

		}
		JOptionPane.showMessageDialog(null, aluguel.mostrarEmprestimos(), "Emprestimos",
				JOptionPane.INFORMATION_MESSAGE);

	}

}
