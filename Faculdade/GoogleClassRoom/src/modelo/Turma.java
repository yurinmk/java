package modelo;

import java.util.HashMap;
import java.util.Map.Entry;

public class Turma {
	
	private int idTurma;
	private String nomeTurma;
	
	private Curso curso;
	private HashMap<String, Aluno> listaAlunos;
	
	
	public Turma() {
		// TODO Auto-generated constructor stub
	}

	public Turma(int idTurma, String nomeTurma, Curso curso, HashMap<String, Aluno> listaAlunos) {
		this.idTurma = idTurma;
		this.nomeTurma = nomeTurma;
		this.curso = curso;
		this.listaAlunos = listaAlunos;
	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public HashMap<String, Aluno> getListaAlunos() {
		return listaAlunos;
	}

	public void setListaAlunos(HashMap<String, Aluno> listaAlunos) {
		this.listaAlunos = listaAlunos;
	}

	@Override
	public String toString() {
		return "Turma\nID: " + idTurma + ", Nome da Turma: " + nomeTurma + ", Curso: " + curso + ", ListaAlunos: "
				+ listaAlunos;
	}
	
	public String pesquisarElemento(String valor) {
		int elemento = 0;
		String resultado = "";
		for(Entry<String, Aluno> lista : this.listaAlunos.entrySet()) {
			if(lista.getKey().equals(valor)) {
				resultado += "Elemento encontrado:\nChave: " + lista.getKey()+" - Conteúdo: " + lista.getValue();
			}else {
				elemento ++;
			}
		}
		if(elemento >0) {
			resultado += "Elemento não encontrado!";
		}
		return resultado;
	}
	
	
	public String exibirAlunos() {
		
		String saida = "";
		
		for(Entry<String, Aluno> pair : this.listaAlunos.entrySet()) {
			saida += "\nChave: " + pair.getKey()+" - Conteúdo: " + pair.getValue();
		}
		return saida;
	}

}
