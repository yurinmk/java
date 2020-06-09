package entidade;

//Criei uma classe Agenda para ter os atributos, um construtor e a formatação do objeto

public class Contato {

	public String nome;
	public int telefone;

	public Contato(String nome, int telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}


	public String toString() {
		return "Nome: " + nome + ", Telefone: " + telefone + "\n";
	}
	
	
	
	
	

}
