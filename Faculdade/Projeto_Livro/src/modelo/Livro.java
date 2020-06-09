package modelo;

import java.util.Arrays;

public class Livro {
	
	private String titulo;
	private int paginas;
	private Livro[] lista = new Livro[200];
	
	public Livro() {
		// TODO Auto-generated constructor stub
	}
	
	public Livro(String titulo, int paginas) {
		this.titulo = titulo;
		this.paginas = paginas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	public Livro[] getLista() {
		return lista;
	}

	public void setLista(Livro[] lista) {
		this.lista = lista;
	}
	

	@Override
	public String toString() {
		return "Livro titulo: " + titulo + ", paginas: " + paginas;
	}

	
	
	

}
