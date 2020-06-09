package entidade;

import java.util.ArrayList;

public class Emprestimo {

	public String nome;
	public String nomeDoLivro;
	
	ArrayList<Emprestimo> lista = new ArrayList<>();
	
	public Emprestimo() {
		
	}

	public Emprestimo(String nome, String nomeDoLivro) {
		this.nome = nome;
		this.nomeDoLivro = nomeDoLivro;
	}
	
	public void realizarEmprestimo(Emprestimo valor) {
		lista.add(valor);
		
	}
	public String mostrarEmprestimos() {
		String temp = "";
		for(Emprestimo x : lista) {
			temp += "\n" + x;
		}
		return temp;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + ", Livro: " + nomeDoLivro +"\n";
	}

	
	
	

}
