package entidade;

import java.util.ArrayList;

//Criei uma classe Contato que tem um ArrayLista para mostrar e adicionar os contos na classe Agenda
public class Agenda {

	ArrayList<Contato> contato = new ArrayList<>();

	public void cadastrarContato(Contato valor) {
		contato.add(valor);
	}
	
	public String mostrarContatos() {
		String temp = "";
		for(Contato x : contato) {
			temp += "\n"+x; 
		}
		return temp;
	}
	
	

}
