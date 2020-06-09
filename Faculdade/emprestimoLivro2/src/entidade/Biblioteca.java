package entidade;

import java.util.ArrayList;

public class Biblioteca {

	ArrayList<Livro> livros = new ArrayList<>();
	ArrayList<Emprestimo> emprestimos = new ArrayList<>();

	Livro livro1 = new Livro("Quem mais faz, faz menos que eu", "Laureano Trambolho");
	Livro livro2 = new Livro("Já foi e não volta mais", "Lacerda Lancely");
	Livro livro3 = new Livro("Voltou e quer partir", "Mendonça Sacana");
	Livro livro4 = new Livro("Partiu e quer voltar", "Minoto Jacimoto");
	Livro livro5 = new Livro("Terminando o interminável", "Yuri Namikoka");

	public Biblioteca() {
	}

	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}

	public ArrayList<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}

	public void addEmprestimo(Emprestimo entreda) {
		emprestimos.add(entreda);

	}

	public void addLivros() {
		livros.add(livro1);
		livros.add(livro2);
		livros.add(livro3);
		livros.add(livro4);
		livros.add(livro5);
	}

	public String mostrarListaDeLivros() {
		String temp = "";
		int i = 1;
		for (Livro x : livros) {
			temp += i + " - " + x + "\n";
			i++;
		}
		return temp;
	}
	public String mostrarEmprestimos() {
		String temp = "";
		for (Emprestimo x : emprestimos) {
			temp += x + "\n";
		}
		return temp;
	}

}
