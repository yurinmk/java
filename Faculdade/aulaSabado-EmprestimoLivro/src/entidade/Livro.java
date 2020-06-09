package entidade;

import java.util.ArrayList;

public class Livro {


	ArrayList<String> listaDeLivros = new ArrayList<>() {
		{
			add("Agora e nunca");
			add("J� foi e n�o volta mais");
			add("Voltou e quer partir");
			add("Partiu e quer voltar");
			add("Terminando o intermin�vel");
		}
	};
	
	

	//Outra forma de add elementos predefinidos a uma lista
	//List<String> lista = Arrays.asList("um valor", "outro valor", "mais um valor");

	public ArrayList<String> getListaDeLivros() {
		return listaDeLivros;
	}



	public void setListaDeLivros(ArrayList<String> listaDeLivros) {
		this.listaDeLivros = listaDeLivros;
	}



	public String listaDeLivros() {
		String temp = "";
		int z = 0;
		for (String x : listaDeLivros) {
			temp += z + 1 + " - Livro: " + x + "\n";
			z++;
		}
		return temp;

	}

}
