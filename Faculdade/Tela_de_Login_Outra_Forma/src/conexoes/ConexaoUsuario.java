package conexoes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import modelo.Usuario;

public class ConexaoUsuario {
	
	private final Connection conexao;

	public ConexaoUsuario(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void inserirUsuario(Usuario usuario) throws SQLException {
		
		String sql = "insert into dados_usuario(usuario,senha) values (?,?);";
		
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		stmt.setString(1, usuario.getUsuario());
		stmt.setString(2, usuario.getSenha());
		
		stmt.execute();
		
		conexao.close();
		stmt.close();
		
	}

	public boolean verificarUsuario(Usuario usuario) throws SQLException {
		String sql = "select *from dados_usuario where usuario = ? and senha = ?";
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		
		stmt.setString(1, usuario.getUsuario());
		stmt.setString(2, usuario.getSenha());
		
		stmt.execute();
		ResultSet resultado = stmt.getResultSet();
		//se existir resultado, retorna true, se não tiver resultado, retorna false
		return resultado.next();
		
	}

}
