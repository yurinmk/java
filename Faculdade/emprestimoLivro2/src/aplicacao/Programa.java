package aplicacao;

import javax.swing.JOptionPane;

import entidade.Biblioteca;
import entidade.Emprestimo;

public class Programa {

	public static void main(String[] args) {

		Biblioteca biblioteca = new Biblioteca();
		biblioteca.addLivros();

		String nomeAluno = JOptionPane.showInputDialog("Nome:");
		String matricula = JOptionPane.showInputDialog("Matrícula:");
		int qnt = Integer.parseInt(JOptionPane
				.showInputDialog(biblioteca.mostrarListaDeLivros() + "\nDeseja alugar quantos livros da lista?"));
		for (int i = 0; i < qnt; i++) {
			int ident = Integer.parseInt(JOptionPane.showInputDialog(null,
					biblioteca.mostrarListaDeLivros() + "\nDigite o identificador para escolher um livro", "Aluguel",
					JOptionPane.INFORMATION_MESSAGE));
			Emprestimo emprestimo = new Emprestimo(nomeAluno, matricula, biblioteca.getLivros().get(ident - 1).getNome(),
					biblioteca.getLivros().get(ident - 1).getAutor());
			biblioteca.addEmprestimo(emprestimo);

		}
		JOptionPane.showMessageDialog(null, biblioteca.mostrarEmprestimos() + "\n", "NOTA DO ALUGUEL", JOptionPane.CLOSED_OPTION);

	}

}
