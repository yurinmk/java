package modelo;

public class Curso {
	
	private String nome;
	private String descricaoCurso;
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public Curso(String nome, String descricaoCurso) {
		this.nome = nome;
		this.descricaoCurso = descricaoCurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricaoCurso() {
		return descricaoCurso;
	}

	public void setDescricaoCurso(String descricaoCurso) {
		this.descricaoCurso = descricaoCurso;
	}

	@Override
	public String toString() {
		return "Curso\nNome: " + nome + ", Descricao: " + descricaoCurso;
	}
	

}
