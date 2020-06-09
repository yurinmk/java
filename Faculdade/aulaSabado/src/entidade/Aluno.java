package entidade;

public class Aluno {
	
	public String nome;
	public String endereco;
	public String cpf;
	public int matricula;
	
	public Aluno(String nome, String endereco, String cpf, int matricula) {
		
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.matricula = matricula;
	}
	public String toString() {
		return "Nome: " + this.nome 
				+ ",\nEndereço: " + this.endereco 
				+ ",\nCPF: " + this.cpf 
				+ ",\nMatrícula: " + this.matricula;
				}
	
	

}
