package classes_de_conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	//Os atributos precisam ser static para poderem ser utilizados
	
	//usuario geral do banco de dados
	private static String usuario = "namikoka";
	//senha do usu�rio root
	private static String senha ="Y1832902204c";
	//endere�o da conex�o onde ta o banco de dados
	//conex�o do tipo = jdbc:mysql// 
	//onde se encontra o BD localhost (na m�quina local)/ 
	//qual o BD utilizado nome_do_banco (db_senhas) 
	//?useSSL=false � preciso para definir que a verifica��o � confi�vel no servidor
	private static String endereco = "jdbc:mysql://localhost/db_senhas?useSSL=false";
	
	//M�todo para fazer a conex�o com o banco de dados
	public static Connection faz_conexao() throws SQLException {
		
		//tratamento de erro
		try {
			
			//instru��o para fazer as conex�es
			
			//Carrega o Driver que � do tipo jdbc
			Class.forName("com.mysql.jdbc.Driver");
			//retorno que faz a conex�o DriverManager = gerenciamento do Drive
			//getConnection() = pega a conex�o
			return DriverManager.getConnection(endereco, usuario, senha);
			
		//Pesquisar o que � depois	
		} catch (ClassNotFoundException e) {
			
			//instru��es do erro
			throw new SQLException(e.getException());
			
		}
	}
	
	
}
