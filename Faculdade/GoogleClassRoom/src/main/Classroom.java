package main;

import java.util.HashMap;

import javax.swing.JOptionPane;

import modelo.Aluno;
import modelo.Curso;
import modelo.Turma;

public class Classroom {
	
	public static void main(String[] args) {
		
		Curso curso1 = new Curso("SPI","Curso sobre tecnologia");
		Aluno aluno1 = new Aluno("Jose","25/12/1500");
		Aluno aluno2 = new Aluno("Yuri","04/12/1993");
		HashMap<String, Aluno> lista = new HashMap<String, Aluno>();
		lista.put("jose@gmail.com", aluno1);
		lista.put("yuri@gmail.com", aluno2);
		
		Turma turma1 = new Turma(123, "SI2020.1", curso1, lista);
		
		System.out.println(turma1.exibirAlunos());
		
		String entrada = JOptionPane.showInputDialog("Digite o email do aluno para pesquisar: ");
		
		JOptionPane.showMessageDialog(null, turma1.pesquisarElemento(entrada));
		
		
		
	}

}
