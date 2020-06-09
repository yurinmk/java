package entidade;

public class Emprestimo {

	private String nomeAluno;
	private String matricula;
	private String nomeLivro;
	private String autorLivro;

	public Emprestimo(String nomeAluno, String matricula, String nomeLivro, String autorLivro) {
		this.matricula = matricula;
		this.nomeAluno = nomeAluno;
		this.nomeLivro = nomeLivro;
		this.autorLivro = autorLivro;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getAutorLivro() {
		return autorLivro;
	}

	public void setAutorLivro(String autorLivro) {
		this.autorLivro = autorLivro;
	}

	@Override
	public String toString() {
		return "\nAluno:" + nomeAluno + "\nMatricula: " + matricula + "\nLivro: " + nomeLivro
				+ "\nAutor: " + autorLivro;
	}



}
