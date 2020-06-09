package conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import modelo.Ocorrencia;

public class ConexaoOcorrencia {

	private Connection conexao;

	public ConexaoOcorrencia(Connection conexao) {
		this.conexao = conexao;
	}

	public void cadastrarOcorrencia(Ocorrencia ocorrencia) throws SQLException {

		String sql = "insert into ocorrencias(placa,matricula,nome,marca,tipo,ocorrencia,data,hora,local,idOcorrencia) values(?,?,?,?,?,?,curdate(),curtime(),?,?);";

		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);

		stmt.setString(1, ocorrencia.getPlaca());
		stmt.setString(2, ocorrencia.getMatricula());
		stmt.setString(3, ocorrencia.getNome());
		stmt.setString(4, ocorrencia.getMarca());
		stmt.setString(5, ocorrencia.getTipo());
		stmt.setString(6, ocorrencia.getOcorrencia());
		stmt.setString(7, ocorrencia.getLocal());
		stmt.setString(8, Double.toString(ocorrencia.getIdOcorrencia()));

		stmt.execute();

	}

	public List<Ocorrencia> ocorrencias(String valor, String local) throws SQLException {

		List<Ocorrencia> tabela = new ArrayList<>();

		if (valor.equals("Todas") && local.equals("Selecionar...")) {

			String sql = "select * from ocorrencias order by data and ocorrencia;";
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.execute();
			ResultSet resultado = stmt.getResultSet();

			while (resultado.next()) {
				Ocorrencia ocorrencia = new Ocorrencia();
				ocorrencia.setPlaca(resultado.getString("placa"));
				ocorrencia.setMatricula(resultado.getString("matricula"));
				ocorrencia.setNome(resultado.getString("nome"));
				ocorrencia.setMarca(resultado.getString("marca"));
				ocorrencia.setTipo(resultado.getString("tipo"));
				ocorrencia.setOcorrencia(resultado.getString("ocorrencia"));
				ocorrencia.setData(resultado.getDate("data"));
				ocorrencia.setHora(resultado.getString("hora"));
				ocorrencia.setLocal(resultado.getString("local"));
				ocorrencia.setIdOcorrencia(resultado.getDouble("idOcorrencia"));
				tabela.add(ocorrencia);

			}

		} else if (!local.equals("Selecionar...") && valor.equals("Todas")) {

			String sql = "select * from ocorrencias where local = ? order by data and ocorrencia;";

			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);

			stmt.setString(1, local);
			stmt.execute();
			ResultSet resultado = stmt.getResultSet();

			while (resultado.next()) {
				Ocorrencia ocorrencia = new Ocorrencia();
				ocorrencia.setPlaca(resultado.getString("placa"));
				ocorrencia.setMatricula(resultado.getString("matricula"));
				ocorrencia.setNome(resultado.getString("nome"));
				ocorrencia.setMarca(resultado.getString("marca"));
				ocorrencia.setTipo(resultado.getString("tipo"));
				ocorrencia.setOcorrencia(resultado.getString("ocorrencia"));
				ocorrencia.setData(resultado.getDate("data"));
				ocorrencia.setHora(resultado.getString("hora"));
				ocorrencia.setLocal(resultado.getString("local"));
				ocorrencia.setIdOcorrencia(resultado.getDouble("idOcorrencia"));
				tabela.add(ocorrencia);

			}

		} else if (!local.equals("Selecionar...") && !valor.equals("Todas")) {

			String sql = "select * from ocorrencias where local = ? and ocorrencia = ? order by data;";

			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);

			stmt.setString(1, local);
			stmt.setString(2, valor);
			stmt.execute();
			ResultSet resultado = stmt.getResultSet();

			while (resultado.next()) {
				Ocorrencia ocorrencia = new Ocorrencia();
				ocorrencia.setPlaca(resultado.getString("placa"));
				ocorrencia.setMatricula(resultado.getString("matricula"));
				ocorrencia.setNome(resultado.getString("nome"));
				ocorrencia.setMarca(resultado.getString("marca"));
				ocorrencia.setTipo(resultado.getString("tipo"));
				ocorrencia.setOcorrencia(resultado.getString("ocorrencia"));
				ocorrencia.setData(resultado.getDate("data"));
				ocorrencia.setHora(resultado.getString("hora"));
				ocorrencia.setLocal(resultado.getString("local"));
				ocorrencia.setIdOcorrencia(resultado.getDouble("idOcorrencia"));
				tabela.add(ocorrencia);
			}

		} else {
			String sql = "select * from ocorrencias where ocorrencia = ? order by data and local;";
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setString(1, valor);
			stmt.execute();
			ResultSet resultado = stmt.getResultSet();

			while (resultado.next()) {
				Ocorrencia ocorrencia = new Ocorrencia();
				ocorrencia.setPlaca(resultado.getString("placa"));
				ocorrencia.setMatricula(resultado.getString("matricula"));
				ocorrencia.setNome(resultado.getString("nome"));
				ocorrencia.setMarca(resultado.getString("marca"));
				ocorrencia.setTipo(resultado.getString("tipo"));
				ocorrencia.setOcorrencia(resultado.getString("ocorrencia"));
				ocorrencia.setData(resultado.getDate("data"));
				ocorrencia.setHora(resultado.getString("hora"));
				ocorrencia.setLocal(resultado.getString("local"));
				ocorrencia.setIdOcorrencia(resultado.getDouble("idOcorrencia"));
				tabela.add(ocorrencia);

			}
		}
		return tabela;

	}

	public List<Ocorrencia> ocorrenciasPorData(String valor, String local, String dataInico, String dataFim)
			throws SQLException {

		List<Ocorrencia> tabela = new ArrayList<>();
		if (local.equals("Selecionar...") && valor.equals("Todas")) {
			String sql = "select * from ocorrencias where data between ? and ? order by data;";
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);

			stmt.setString(1, dataInico);
			stmt.setString(2, dataFim);

			stmt.execute();
			ResultSet resultado = stmt.getResultSet();

			while (resultado.next()) {
				Ocorrencia ocorrencia = new Ocorrencia();
				ocorrencia.setPlaca(resultado.getString("placa"));
				ocorrencia.setMatricula(resultado.getString("matricula"));
				ocorrencia.setNome(resultado.getString("nome"));
				ocorrencia.setMarca(resultado.getString("marca"));
				ocorrencia.setTipo(resultado.getString("tipo"));
				ocorrencia.setOcorrencia(resultado.getString("ocorrencia"));
				ocorrencia.setData(resultado.getDate("data"));
				ocorrencia.setHora(resultado.getString("hora"));
				ocorrencia.setLocal(resultado.getString("local"));
				ocorrencia.setIdOcorrencia(resultado.getDouble("idOcorrencia"));
				tabela.add(ocorrencia);

			}

		} else if (!local.equals("Selecionar...") && valor.equals("Todas")) {

			String sql = "select * from ocorrencias where local = ? and data between ? and ? order by data;";
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);

			stmt.setString(1, local);
			stmt.setString(2, dataInico);
			stmt.setString(3, dataFim);

			stmt.execute();
			ResultSet resultado = stmt.getResultSet();

			while (resultado.next()) {
				Ocorrencia ocorrencia = new Ocorrencia();
				ocorrencia.setPlaca(resultado.getString("placa"));
				ocorrencia.setMatricula(resultado.getString("matricula"));
				ocorrencia.setNome(resultado.getString("nome"));
				ocorrencia.setMarca(resultado.getString("marca"));
				ocorrencia.setTipo(resultado.getString("tipo"));
				ocorrencia.setOcorrencia(resultado.getString("ocorrencia"));
				ocorrencia.setData(resultado.getDate("data"));
				ocorrencia.setHora(resultado.getString("hora"));
				ocorrencia.setLocal(resultado.getString("local"));
				ocorrencia.setIdOcorrencia(resultado.getDouble("idOcorrencia"));
				tabela.add(ocorrencia);

			}

		} else if (local.equals("Selecionar...") && !valor.equals("Todas")) {

			String sql = "select * from ocorrencias where ocorrencia = ? and data between ? and ? order by data;";
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);

			stmt.setString(1, valor);
			stmt.setString(2, dataInico);
			stmt.setString(3, dataFim);

			stmt.execute();
			ResultSet resultado = stmt.getResultSet();

			while (resultado.next()) {
				Ocorrencia ocorrencia = new Ocorrencia();
				ocorrencia.setPlaca(resultado.getString("placa"));
				ocorrencia.setMatricula(resultado.getString("matricula"));
				ocorrencia.setNome(resultado.getString("nome"));
				ocorrencia.setMarca(resultado.getString("marca"));
				ocorrencia.setTipo(resultado.getString("tipo"));
				ocorrencia.setOcorrencia(resultado.getString("ocorrencia"));
				ocorrencia.setData(resultado.getDate("data"));
				ocorrencia.setHora(resultado.getString("hora"));
				ocorrencia.setLocal(resultado.getString("local"));
				ocorrencia.setIdOcorrencia(resultado.getDouble("idOcorrencia"));
				tabela.add(ocorrencia);

			}

		} else {

			String sql = "select * from ocorrencias where ocorrencia = ? and local = ? and data between ? and ? order by data;";
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);

			stmt.setString(1, valor);
			stmt.setString(2, local);
			stmt.setString(3, dataInico);
			stmt.setString(4, dataFim);

			stmt.execute();
			ResultSet resultado = stmt.getResultSet();

			while (resultado.next()) {
				Ocorrencia ocorrencia = new Ocorrencia();
				ocorrencia.setPlaca(resultado.getString("placa"));
				ocorrencia.setMatricula(resultado.getString("matricula"));
				ocorrencia.setNome(resultado.getString("nome"));
				ocorrencia.setMarca(resultado.getString("marca"));
				ocorrencia.setTipo(resultado.getString("tipo"));
				ocorrencia.setOcorrencia(resultado.getString("ocorrencia"));
				ocorrencia.setData(resultado.getDate("data"));
				ocorrencia.setHora(resultado.getString("hora"));
				ocorrencia.setLocal(resultado.getString("local"));
				ocorrencia.setIdOcorrencia(resultado.getDouble("idOcorrencia"));
				tabela.add(ocorrencia);

			}
		}

		return tabela;
	}

	public int totalOcorrencia(String valor, String local) throws SQLException {

		int temp = 0;

		if (valor.equals("Todas") && local.equals("Selecionar...")) {
			String sql = "select count(*) as total from ocorrencias;";
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);

			stmt.execute();
			ResultSet resultado = stmt.getResultSet();
			if (resultado.next()) {
				temp = resultado.getInt(1);
			}

		} else if (valor.equals("Todas") && !local.equals("Selecionar...")) {
			String sql = "select count(*) as total from ocorrencias where local = ?;";
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);

			stmt.setString(1, local);
			stmt.execute();
			ResultSet resultado = stmt.getResultSet();
			if (resultado.next()) {
				temp = resultado.getInt(1);
			}

		} else if (!valor.equals("Todas") && !local.equals("Selecionar...")) {
			String sql = "select count(*) as total from ocorrencias where local = ? and ocorrencia = ?;";
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);

			stmt.setString(1, local);
			stmt.setString(2, valor);
			stmt.execute();
			ResultSet resultado = stmt.getResultSet();
			if (resultado.next()) {
				temp = resultado.getInt(1);
			}
		} else if (!valor.equals("Todas") && local.equals("Selecionar...")) {
			String sql = "select count(*) as total from ocorrencias where ocorrencia = ?;";
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);

			stmt.setString(1, valor);
			stmt.execute();
			ResultSet resultado = stmt.getResultSet();
			if (resultado.next()) {
				temp = resultado.getInt(1);
			}
		}
		return temp;

	}

	public int totalOcorrenciaPorData(String valor, String local, String dataInicio, String dataFim)
			throws SQLException {

		int temp = 0;

		if (valor.equals("Todas") && local.equals("Selecionar...")) {
			String sql = "select count(*) as total from ocorrencias where data between ? and ?;";
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);

			stmt.setString(1, dataInicio);
			stmt.setString(2, dataFim);
			stmt.execute();
			ResultSet resultado = stmt.getResultSet();
			if (resultado.next()) {
				temp = resultado.getInt(1);
			}

		} else if (valor.equals("Todas") && !local.equals("Selecionar...")) {
			String sql = "select count(*) as total from ocorrencias where local = ? and data between ? and ?;";
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);

			stmt.setString(1, local);
			stmt.setString(2, dataInicio);
			stmt.setString(3, dataFim);
			stmt.execute();
			ResultSet resultado = stmt.getResultSet();
			if (resultado.next()) {
				temp = resultado.getInt(1);
			}

		} else if (!valor.equals("Todas") && !local.equals("Selecionar...")) {
			String sql = "select count(*) as total from ocorrencias where local = ? and ocorrencia = ? and data between ? and ?;";
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);

			stmt.setString(1, local);
			stmt.setString(2, valor);
			stmt.setString(3, dataInicio);
			stmt.setString(4, dataFim);
			stmt.execute();
			ResultSet resultado = stmt.getResultSet();
			if (resultado.next()) {
				temp = resultado.getInt(1);
			}
		} else if (!valor.equals("Todas") && local.equals("Selecionar...")) {
			String sql = "select count(*) as total from ocorrencias where ocorrencia = ? and data between ? and ?;";
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);

			stmt.setString(1, valor);
			stmt.setString(2, dataInicio);
			stmt.setString(3, dataFim);
			stmt.execute();
			ResultSet resultado = stmt.getResultSet();
			if (resultado.next()) {
				temp = resultado.getInt(1);
			}
		}
		return temp;

	}

}
