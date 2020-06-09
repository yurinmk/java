package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
	
	private String endereco = "jdbc:mysql://localhost/db_morais_parking?allowPublicKeyRetrieval=true&useSSL=false";
	private String usuario = "root";
	private String senha = "0412@NamiKoKa#Foda1810";
	
	//Método para fazer conexao
	public Connection fazer_conexao() throws SQLException {
		//faço uma conexao do tipo Cennection
		//Onde é preciso chamar o DriverManager para pegar uma conexao .getConnection
		Connection fazer_conexao = DriverManager.getConnection(endereco,usuario,senha);
		//Como o método é do tipo Connection, é preciso retornar uma conexao
		return fazer_conexao;
		
		
	}

}
