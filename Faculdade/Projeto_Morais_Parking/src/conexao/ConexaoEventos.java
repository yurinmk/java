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

import modelo.Eventos;

public class ConexaoEventos {
	
	private Connection conexao;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	public ConexaoEventos(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void inserirEvento(Eventos evento) throws SQLException, ParseException {
		 
		String sql = "insert into eventos(evento, data_inicio, data_fim, local, vagas, vagas_extras, status) values(?,?,?,?,?,?, '-')";
		
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		
		stmt.setString(1, evento.getNomeEvento());
		stmt.setString(2, sdf.format(evento.getDataInicio()));
		stmt.setString(3, sdf.format(evento.getDataFim()));
		stmt.setString(4, evento.getBlocoRealizado());
		stmt.setInt(5, evento.getVagasConsumidas());
		stmt.setInt(6, evento.getVagaExtras());
		
		
		stmt.execute();
		mudarStatusEvento();
		
	}
	
	public List<Eventos> pesquisarEvento(String status) throws SQLException {
		
		String sql = "select * from eventos where status = ?;";
		
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		
		stmt.setString(1, status);
		
		stmt.execute();
		
		List<Eventos> tabela = new ArrayList<>();
		
		ResultSet resultado = stmt.getResultSet();
		
		
		while(resultado.next()) {
			Eventos evento = new Eventos();
			evento.setNomeEvento(resultado.getString("evento"));
			evento.setDataInicio(resultado.getDate("data_inicio"));
			evento.setDataFim(resultado.getDate("data_fim"));
			evento.setBlocoRealizado(resultado.getString("local"));
			evento.setVagasConsumidas(resultado.getInt("vagas"));
			evento.setVagaExtras(resultado.getInt("vagas_extras"));
			evento.setStatus(resultado.getString("status"));
			tabela.add(evento);
		}
		return tabela;	
		
	}
	public void mudarStatusEvento() throws SQLException, ParseException {
		
		Date dataAtual = new Date(System.currentTimeMillis());
		String sql = "select * from eventos;";
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		stmt.execute();
		ResultSet resultado = stmt.getResultSet();
		List<Eventos> lista = new ArrayList<>();
		while(resultado.next()) {
			Eventos evento = new Eventos();
			evento.setId(resultado.getInt("id"));
			evento.setNomeEvento(resultado.getString("evento"));
			evento.setDataInicio(resultado.getDate("data_inicio"));
			evento.setDataFim(resultado.getDate("data_fim"));
			evento.setBlocoRealizado(resultado.getString("local"));
			evento.setVagasConsumidas(resultado.getInt("vagas"));
			evento.setVagaExtras(resultado.getInt("vagas_extras"));
			evento.setStatus(resultado.getString("status"));
			lista.add(evento);
		}
		for(Eventos x: lista) {
		
			if(sdf.parse(sdf.format(x.getDataFim())).getTime() < sdf.parse(sdf.format(dataAtual)).getTime()) {
				String sql2 = "update eventos set status = 'finalizado' where id = "+"'"+x.getId()+"';";
				PreparedStatement stmt2 = (PreparedStatement) conexao.prepareStatement(sql2);
				stmt2.execute();
			}else if(sdf.parse(sdf.format(dataAtual)).getTime() < sdf.parse(sdf.format(x.getDataInicio())).getTime()) {
				String sql2 = "update eventos set status = 'futuro' where id = "+"'"+x.getId()+"';";
				PreparedStatement stmt2 = (PreparedStatement) conexao.prepareStatement(sql2);
				stmt2.execute();
			}else if(sdf.parse(sdf.format(x.getDataInicio())).getTime() >= sdf.parse(sdf.format(dataAtual)).getTime() 
					&& sdf.parse(sdf.format(dataAtual)).getTime() <= sdf.parse(sdf.format(x.getDataFim())).getTime()) {
				String sql2 = "update eventos set status = 'em_andamento' where id = "+"'"+x.getId()+"';";
				PreparedStatement stmt2 = (PreparedStatement) conexao.prepareStatement(sql2);
				stmt2.execute();
			}else if(sdf.parse(sdf.format(x.getDataInicio())).getTime() < sdf.parse(sdf.format(dataAtual)).getTime() 
					&& sdf.parse(sdf.format(dataAtual)).getTime() <= sdf.parse(sdf.format(x.getDataFim())).getTime()) {
				String sql2 = "update eventos set status = 'em_andamento' where id = "+"'"+x.getId()+"';";
				PreparedStatement stmt2 = (PreparedStatement) conexao.prepareStatement(sql2);
				stmt2.execute();
			}
		}			
	}
	public int totalDeVagasEventos(String local) throws SQLException {
		int valor1 = 0;
		int valor2 = 0;
		int total = 0;
		
		String sql = "select sum(vagas_extras) as total from eventos where local = ? and status = 'em_andamento'";
		String sql2 = "select sum(vagas) as total from eventos where local = ? and status = 'em_andamento'";
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		PreparedStatement stmt2 = (PreparedStatement) conexao.prepareStatement(sql2);
		
		stmt.setString(1, local);
		stmt2.setString(1, local);
		
		stmt.execute();
		ResultSet resultado = stmt.getResultSet();
		stmt2.execute();
		ResultSet resultado2 = stmt2.getResultSet();
		
		if(resultado.next()) {
			valor1 = resultado.getInt("total");
		}
		if(resultado2.next()) {
			valor2 = resultado2.getInt("total");
		}
		total = valor1 + valor2;
		return total;
	}
	
}
