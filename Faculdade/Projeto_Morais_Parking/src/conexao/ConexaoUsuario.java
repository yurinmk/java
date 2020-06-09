package conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import modelo.Usuario;

public class ConexaoUsuario {
	
	//� preciso criar uma constante do tipo Connectio e um construtor para que a consexao do usuario seja feita
	private final Connection conexao;	

	public ConexaoUsuario(Connection conexao) {
		this.conexao = conexao;
	}

	public void inserirConexao(Usuario usuario) throws SQLException {
		//Fazer a String sql para inserir os campos na tabela
		String sql = "insert into funcionarios(usuario,senha,email, cargo) values (?, ?, ?, ?);";
		//preparar a conexao da String sql
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		//Passar os par�mentro 1, 2 e 3 nos respectivo ?, ?, ?  
		stmt.setString(1, usuario.getUsuario());
		stmt.setString(2, usuario.getSenha());
		stmt.setString(3, usuario.getEmail());
		stmt.setString(4, usuario.getCargo());
		
		stmt.execute();
	}
	
	
	public boolean verificarUsuario(Usuario usuario) throws SQLException {
		
		String sql = "select *from funcionarios where usuario = ? and senha = ? and cargo = ?";
		
		
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		
		stmt.setString(1, usuario.getUsuario());
		stmt.setString(2, usuario.getSenha());
		stmt.setString(3, usuario.getCargo());
		stmt.execute();
		//Armazena o resultado da execu��o na variavel resultado 
		ResultSet resultado = stmt.getResultSet();
		boolean temp = resultado.next(); 
		
		
		//o resultado guarda o valor true, por�m o resultado.next() v� se tem pr�xima linha ou n�o
		return temp;
	
	}
	

}
