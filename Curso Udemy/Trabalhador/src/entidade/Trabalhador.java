package entidade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidade.enums.NivelDoTrabalhador;

public class Trabalhador {
	
	//Atributos básicos
	private String nome;
	private NivelDoTrabalhador nivel;
	private Double salarioBase;
	//Associações
	//Um trabalhador tem 1 departamento
	private Departamento departamento;
	//Um trabalhador tem vários contratos, por isso precisa ser guardado em uma lista
	//Sempre que existir uma composição "tem-muitos", ou seja, uma lista
	//Essa lista tem que ser instaciada por padrão e não ser colocada no construtor
	private List<ContratoPorHora> contratos = new ArrayList<>();
	
	public Trabalhador() {
		// TODO Auto-generated constructor stub
	}
	
	//Gerar um construtor sem a lista
	public Trabalhador(String nome, NivelDoTrabalhador nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelDoTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelDoTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoPorHora> getContrados() {
		return contratos;
	}
	/*
	 * O programa não pode ter o metodo set da lista de contartos porque eu já intanciei uma lista
	 * para adicionar e remover contratos, sendo que de maneira alguma eu posso deixar que essa lista
	 * seja trocada. Pois o metodo set está recebendo uma nova lista List<ContratoPorHora> de contratos
	 * e atribuindo a lista de contratos já instanciada e isso não pode acontecer.
	 
	public void setContrados(List<ContratoPorHora> contratos) {
		this.contratos = contratos;
	}*/
	
	//Metodos para fazer e desfazer associações do contrato adicionando e removendo o contarto da lista
	public void addContrato(ContratoPorHora contrato) {
		contratos.add(contrato);
	}
	public void removerContrato(ContratoPorHora contrato) {
		contratos.remove(contrato);
	}
	
	//Metodo que compara as datas passadas como parametro com as datas dos contratos na lista
	//para poder somar todos os valores referente aos contratos com o salario base do trabalhador
	public double rendaTotal(int mes, int ano) {
		double soma = this.salarioBase;
		//Pega o instante e atribui a um calendario
		Calendar calendario = Calendar.getInstance();
		for(ContratoPorHora c : contratos) {
			//c.getData() pega a data do contrato na lista e seta (atribui) ao calendario calendario.setTime
			calendario.setTime(c.getData());
			//atribuo a variavel c_ano o ano que está no calendario
			int c_ano = calendario.get(Calendar.YEAR);
			//atribuo a variavel c_mes o mes que está no calendario
			//o +1 é porque o mes do Calendar começa com 0
			int c_mes = 1 + calendario.get(Calendar.MONTH);
			//Estou testando se o ano e o mes atribuida as variaveis são iguais as do parametro para
			//poder somar o salário base do trabalhador ao valor total do contrato que foi feito um
			//metodo na classe ContratoPorHora
			if(c_ano == ano && c_mes == mes) {
				soma += c.valorTotal();
			}
		//retorno a soma do salario base mais os contratos passado nos parametros
		}return soma;
	}
}
