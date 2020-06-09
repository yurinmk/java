package conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import modelo.AreasEspeciais;

public class ConexaoAreasEspeciais {
	
	private Connection conexao;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private Date dataAtual = new Date();

	public ConexaoAreasEspeciais(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void cadastrarAreaEspecial(AreasEspeciais novaArea) throws SQLException {
		
		String sql = "insert into areas_especiais(bloco,acesso,inicio,fim,indeterminado,vagas,descricao,status) values(?,?,?,?,?,?,?,?);";
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		if(novaArea.getDataInicio() == null || novaArea.getDataFim() == null) {
			stmt.setString(1, novaArea.getBloco());
			stmt.setString(2, novaArea.getAcesso());
			stmt.setString(3, null);
			stmt.setString(4, null);
			stmt.setString(5, novaArea.getIndeterminado());
			stmt.setInt(6, novaArea.getTotalVagas());
			stmt.setString(7, novaArea.getDescricao());
			stmt.setString(8, "ativa");
			stmt.execute();
		}else {
			stmt.setString(1, novaArea.getBloco());
			stmt.setString(2, novaArea.getAcesso());
			stmt.setString(3, sdf.format(novaArea.getDataInicio()));
			stmt.setString(4, sdf.format(novaArea.getDataFim()));
			stmt.setString(5, novaArea.getIndeterminado());
			stmt.setInt(6, novaArea.getTotalVagas());
			stmt.setString(7, novaArea.getDescricao());
			stmt.setString(8, "ativa");
			stmt.execute();
		}
		
	}
	public int qntVagas(String bloco) throws SQLException, ParseException  {
		int valor1 = 0;
		int valor2 = 0;

		String sql1 = "select sum(vagas) as total from areas_especiais where bloco = ? and indeterminado = 'não';";
		PreparedStatement stmt1 = (PreparedStatement) conexao.prepareStatement(sql1);
		stmt1.setString(1, bloco);
		stmt1.execute();
		ResultSet resultado1 = stmt1.getResultSet();
		if (resultado1.next()) {
			valor1 = resultado1.getInt(1);
		}

		String sql2 = "select sum(vagas) as total from areas_especiais where bloco = ? and indeterminado = 'sim';";
		PreparedStatement stmt2 = (PreparedStatement) conexao.prepareStatement(sql2);
		stmt2.setString(1, bloco);
		stmt2.execute();
		ResultSet resultado2 = stmt2.getResultSet();
		if (resultado2.next()) {
			valor2 = resultado2.getInt(1);
		}
				
			
		int total = valor1 + valor2;
		return total;
	}
	public List<AreasEspeciais> pesquisarAreasEspeciais(String bloco,String acesso) throws SQLException {
		
		List<AreasEspeciais> lista = new ArrayList<>();
		if(bloco.equals("Todos") && acesso.equals("Todas")) {
			String sql = "select * from areas_especiais;";
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.execute();
			ResultSet resultado = stmt.getResultSet();
			while(resultado.next()) {
				if(!resultado.getString("status").equals("inativa")) {
					AreasEspeciais areasEspeciais = new AreasEspeciais();
					areasEspeciais.setId(resultado.getInt("id"));
					areasEspeciais.setBloco(resultado.getString("bloco"));
					areasEspeciais.setAcesso(resultado.getString("acesso"));
					areasEspeciais.setDataInicio(resultado.getDate("inicio"));
					areasEspeciais.setDataFim(resultado.getDate("fim"));
					areasEspeciais.setIndeterminado(resultado.getString("indeterminado"));
					areasEspeciais.setTotalVagas(resultado.getInt("vagas"));
					areasEspeciais.setDescricao(resultado.getString("descricao"));
					areasEspeciais.setStatus(resultado.getString("status"));
					lista.add(areasEspeciais);
				}
			}
		}else if(!bloco.equals("Selecionar...") && acesso.equals("Todas")) {
			String sql = "select * from areas_especiais where bloco = ?;";
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setString(1, bloco);
			stmt.execute();
			ResultSet resultado = stmt.getResultSet();
			while(resultado.next()) {
				if(!resultado.getString("status").equals("inativa")) {
					AreasEspeciais areasEspeciais = new AreasEspeciais();
					areasEspeciais.setId(resultado.getInt("id"));
					areasEspeciais.setBloco(resultado.getString("bloco"));
					areasEspeciais.setAcesso(resultado.getString("acesso"));
					areasEspeciais.setDataInicio(resultado.getDate("inicio"));
					areasEspeciais.setDataFim(resultado.getDate("fim"));
					areasEspeciais.setIndeterminado(resultado.getString("indeterminado"));
					areasEspeciais.setTotalVagas(resultado.getInt("vagas"));
					areasEspeciais.setDescricao(resultado.getString("descricao"));
					areasEspeciais.setStatus(resultado.getString("status"));
					lista.add(areasEspeciais);
				}
				
			}
		}else if(bloco.equals("Todos") && !acesso.equals("Selecionar...")) {
			String sql = "select * from areas_especiais where acesso = ?;";
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setString(1, acesso);
			stmt.execute();
			ResultSet resultado = stmt.getResultSet();
			while(resultado.next()) {
				if(!resultado.getString("status").equals("inativa")) {
					AreasEspeciais areasEspeciais = new AreasEspeciais();
					areasEspeciais.setId(resultado.getInt("id"));
					areasEspeciais.setBloco(resultado.getString("bloco"));
					areasEspeciais.setAcesso(resultado.getString("acesso"));
					areasEspeciais.setDataInicio(resultado.getDate("inicio"));
					areasEspeciais.setDataFim(resultado.getDate("fim"));
					areasEspeciais.setIndeterminado(resultado.getString("indeterminado"));
					areasEspeciais.setTotalVagas(resultado.getInt("vagas"));
					areasEspeciais.setDescricao(resultado.getString("descricao"));
					areasEspeciais.setStatus(resultado.getString("status"));
					lista.add(areasEspeciais);
				}
				
			}
		}else if(!bloco.equals("Selecionar...") && !acesso.equals("Selecionar...")) {
			String sql = "select * from areas_especiais where bloco = ? and acesso = ?;";
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setString(1, bloco);
			stmt.setString(2, acesso);
			stmt.execute();
			ResultSet resultado = stmt.getResultSet();
			while(resultado.next()) {
				if(!resultado.getString("status").equals("inativa")) {
					AreasEspeciais areasEspeciais = new AreasEspeciais();
					areasEspeciais.setId(resultado.getInt("id"));
					areasEspeciais.setBloco(resultado.getString("bloco"));
					areasEspeciais.setAcesso(resultado.getString("acesso"));
					areasEspeciais.setDataInicio(resultado.getDate("inicio"));
					areasEspeciais.setDataFim(resultado.getDate("fim"));
					areasEspeciais.setIndeterminado(resultado.getString("indeterminado"));
					areasEspeciais.setTotalVagas(resultado.getInt("vagas"));
					areasEspeciais.setDescricao(resultado.getString("descricao"));
					areasEspeciais.setStatus(resultado.getString("status"));
					lista.add(areasEspeciais);
				}
			}
		}
		return lista;
		
	}
	public void removerAreaEspecial(int id) throws SQLException {
		String sql = "update areas_especiais set status = 'inativa' where id = ?;";
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
	}
	public void darPermissao(int id, String valor) throws SQLException {
		String sql = "update areas_especiais set acesso = ? where id = ?;";
		
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		
		stmt.setString(1, valor);
		stmt.setString(2, Integer.toString(id));
		stmt.execute();
	}
	

}
