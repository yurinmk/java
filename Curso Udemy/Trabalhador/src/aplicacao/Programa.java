package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.ContratoPorHora;
import entidade.Departamento;
import entidade.Trabalhador;
import entidade.enums.NivelDoTrabalhador;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		//Feito com Scanner 

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Nome do Departamento: ");
		String nomeDepartamento = sc.nextLine();

		System.out.println("Dados do trabalhador");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Nível do Trabalhador: ");
		String nivel = sc.nextLine();
		System.out.print("Salário base: ");
		double salarioBase = sc.nextDouble();
		// NivelDoTrabalhador.valueOf(nivel) cria uma instancia do
		// tipo enumerado NivelDoTrabalhador equivalente ao que foi digitado
		// Como departamento é outro objeto
		// foi preciso instanciar o objeto passando nomeDepartamento como argumento
		Trabalhador trabalhador = new Trabalhador(nome, NivelDoTrabalhador.valueOf(nivel), salarioBase,
				new Departamento(nomeDepartamento));

		System.out.print("Quantos contratos será atribuido ao trabalhador? ");
		int qnt = sc.nextInt();
		for (int i = 0; i < qnt; i++) {
			System.out.println("Insira os dados do contarto #" + (i + 1));
			System.out.print("Data (DD/MM/YYYY): ");
			// Atribui na variavel a conversão de uma string em Date que foi digitada
			Date dataContrato = data.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Horas: ");
			int hora = sc.nextInt();
			ContratoPorHora contrato = new ContratoPorHora(dataContrato, valorPorHora, hora);
			// Adiciona o contrato na lista de contrato criada na classe Trabalhador
			trabalhador.addContrato(contrato);

		}
		System.out.print("Insira mês e ano para calcular a renda (MM/YYYY): ");
		String dataPesquisa = sc.next();
		// Recorta a data digitada apenas no ano (inicio da string posição 0, final da
		// string posição 2)
		// e converte para inteiro
		int mes = Integer.parseInt(dataPesquisa.substring(0, 2));
		// Recorta a data digitada apenas no mes (pega o resto da string a partir da
		// posição 3
		// e converte para inteiro 
		int ano = Integer.parseInt(dataPesquisa.substring(3));
		System.out.println("Nome:" + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Renda do trabalhador referente aos contratos da data " + dataPesquisa + ": "
				+ trabalhador.rendaTotal(mes, ano));
		sc.close(); 
		
		/*Feito com o JOptionPane
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		
		String nomeDepartamento = JOptionPane.showInputDialog("Nome do Departamento");
		
		String nome = JOptionPane.showInputDialog(null, "Nome:", "Insira dados do Trabalhador",
				JOptionPane.QUESTION_MESSAGE);
		
		String nivel = JOptionPane.showInputDialog(null, "Nível do Trabalhador:", "Insira dados do Trabalhador",
				JOptionPane.QUESTION_MESSAGE);
		
		double salarioBase = Double.parseDouble(JOptionPane.showInputDialog(null, "Salário Base:",
				"Insira dados do Trabalhador", JOptionPane.QUESTION_MESSAGE));
		
		Trabalhador trabalhador = new Trabalhador(nome, NivelDoTrabalhador.valueOf(nivel), salarioBase,
				new Departamento(nomeDepartamento));
		
		int qnt = Integer.parseInt(JOptionPane.showInputDialog("Quantos contratos o trabalhador vai ter?"));
		
		for (int i = 1; i <= qnt; i++) {
			Date dataContrato = data.parse(JOptionPane.showInputDialog(null, "Data (DD/MM/YYYY):",
					"Dados do contrato #" + i, JOptionPane.QUESTION_MESSAGE));
			
			double valorPorHora = Double.parseDouble(JOptionPane.showInputDialog(null, "Valor da Hora:",
					"Dados do contrato #" + i, JOptionPane.QUESTION_MESSAGE));
			
			int hora = Integer.parseInt(JOptionPane.showInputDialog(null, "Duração (Horas):", "Dados do contrato #" + i,
					JOptionPane.QUESTION_MESSAGE));
			
			ContratoPorHora contrato = new ContratoPorHora(dataContrato, valorPorHora, hora);
		}
		String dataPesquisa = JOptionPane
				.showInputDialog(null,"Data (MM/YYYY)","Insira o mês e o ano do contrato para calcular a renda", JOptionPane.QUESTION_MESSAGE);
		
		int mes = Integer.parseInt(dataPesquisa.substring(0, 2));
		int ano = Integer.parseInt(dataPesquisa.substring(3));
		
		JOptionPane.showMessageDialog(null,
				"Nome: " + trabalhador.getNome() + "\nDepartamento: " + trabalhador.getDepartamento().getNome()
						+ "\nRenda total: " + trabalhador.rendaTotal(mes, ano),
						"Contratos referetes a data" + dataPesquisa, JOptionPane.INFORMATION_MESSAGE);*/
	}

}
