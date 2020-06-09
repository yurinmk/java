package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private String endereco = "jdbc:mysql://localhost/usuarios?useSSL=false";
	private String usuario = "namikoka";
	private String senha = "Y1832902204c";
	
	public Connection faz_conexao() throws SQLException {
		
		Connection conexao = DriverManager.getConnection(endereco,usuario,senha);
		return conexao;
		
	}
}
