package classes_de_conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	//Os atributos precisam ser static para poderem ser utilizados
	
	//usuario geral do banco de dados
	private static String usuario = "namikoka";
	//senha do usuário root
	private static String senha ="Y1832902204c";
	//endereço da conexão onde ta o banco de dados
	//conexão do tipo = jdbc:mysql// 
	//onde se encontra o BD localhost (na máquina local)/ 
	//qual o BD utilizado nome_do_banco (db_senhas) 
	//?useSSL=false é preciso para definir que a verificação é confiável no servidor
	private static String endereco = "jdbc:mysql://localhost/db_senhas?useSSL=false";
	
	//Método para fazer a conexão com o banco de dados
	public static Connection faz_conexao() throws SQLException {
		
		//tratamento de erro
		try {
			
			//instrução para fazer as conexões
			
			//Carrega o Driver que é do tipo jdbc
			Class.forName("com.mysql.jdbc.Driver");
			//retorno que faz a conexão DriverManager = gerenciamento do Drive
			//getConnection() = pega a conexão
			return DriverManager.getConnection(endereco, usuario, senha);
			
		//Pesquisar o que é depois	
		} catch (ClassNotFoundException e) {
			
			//instruções do erro
			throw new SQLException(e.getException());
			
		}
	}
	
	
}
