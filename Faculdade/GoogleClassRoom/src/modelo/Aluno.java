package modelo;

public class Aluno {
	
	private String nome;
	private String dataNascimento;
	
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}


	public Aluno(String nome, String dataNascimento) {

		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	@Override
	public String toString() {
		return "Aluno\nNome: " + nome + ", Data de Nascimento: " + dataNascimento;
	}
	

}
