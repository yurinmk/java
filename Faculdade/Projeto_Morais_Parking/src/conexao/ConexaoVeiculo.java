package conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import modelo.UsuarioVeiculo;
import modelo.Vagas;


public class ConexaoVeiculo {
	
	private Connection conexao;

	public ConexaoVeiculo() {
		// TODO Auto-generated constructor stub
	}
	
	public ConexaoVeiculo(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void inserirVeiculo(UsuarioVeiculo veiculo) throws SQLException {
		String sql = "insert into veiculos(matricula, nome, placa, marca, tipo, data, hora, status, bloco) values (?, ?, ?, ?, ?, curdate(), curtime(), 'PRESENTE', ?);";
		
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		stmt.setString(1, veiculo.getMatricula());
		stmt.setString(2, veiculo.getNome());
		stmt.setString(3, veiculo.getPlaca());
		stmt.setString(4, veiculo.getMarca());
		stmt.setString(5, veiculo.getTipo());
		stmt.setString(6, veiculo.getBloco());
		
		
		stmt.execute();
		stmt.close();
	}
	
	public boolean verificarVeiculo(UsuarioVeiculo placa) throws SQLException {
		String sql = "select * from veiculos where placa = ? and status = 'AUSENTE';";
		String sql2 = "select * from veiculos where placa = ? and status = 'PRESENTE';";
		
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		PreparedStatement stmt2 = (PreparedStatement) conexao.prepareStatement(sql2);
		
		stmt.setString(1, placa.getPlaca());
		stmt.execute();
		
		stmt2.setString(1, placa.getPlaca());
		stmt2.execute();
		
		ResultSet resultado = stmt.getResultSet();
		ResultSet resultado2 = stmt2.getResultSet();
		
		boolean temp = false;
		if(resultado.next()) {
			if(resultado2.next()) {
				JOptionPane.showMessageDialog(null, "Veículos já estacionado!");
			}else {
				placa.setMatricula(resultado.getString("matricula"));
				placa.setNome(resultado.getString("nome"));
				placa.setMarca(resultado.getString("marca"));
				placa.setTipo(resultado.getString("tipo"));
			}
			temp = true;
		}
		return temp;
		
	}
	public void inserirVeiculos(UsuarioVeiculo veiculo) throws SQLException {
		
	
		
		String sql = "insert into veiculos(matricula, nome, placa, marca, tipo, data, hora, status, bloco) values (?, ?, ?, ?, ?, curdate(), curtime(), 'PRESENTE', ?);";
		
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);

		
		stmt.setString(1, veiculo.getMatricula());
		stmt.setString(2, veiculo.getNome());
		stmt.setString(3, veiculo.getPlaca());
		stmt.setString(4, veiculo.getMarca());
		stmt.setString(5, veiculo.getTipo());
		stmt.setString(6, veiculo.getBloco());
		stmt.execute();
		stmt.close();
		
	}
	//remover seria no caso setar no campo status AUSENTE
	public void removerVeiculo(UsuarioVeiculo placa) throws SQLException {
		
		String sql = "insert into veiculos(matricula, nome, placa, marca, tipo, data, hora, status, bloco) values (?, ?, ?, ?, ?, curdate(), curtime(), 'AUSENTE', ?);";
		String sql2 = "update veiculos set status = 'AUSENTE' where placa = ? and status = 'PRESENTE';";
		String sql3 = "select * from veiculos where placa = ? and status = 'PRESENTE';";
		
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		PreparedStatement stmt2 = (PreparedStatement) conexao.prepareStatement(sql2);
		PreparedStatement stmt3 = (PreparedStatement) conexao.prepareStatement(sql3);
		
		stmt3.setString(1, placa.getPlaca());
		stmt3.execute();
		ResultSet resultado = stmt3.getResultSet();
		String blocoRecuperado = "";
		if(resultado.next()) {
			blocoRecuperado = resultado.getString("bloco");
		}
		
		stmt.setString(1, placa.getMatricula());
		stmt.setString(2, placa.getNome());
		stmt.setString(3, placa.getPlaca());
		stmt.setString(4, placa.getMarca());
		stmt.setString(5, placa.getTipo());
		stmt.setString(6, blocoRecuperado);
		stmt.execute();
		
		stmt2.setString(1, placa.getPlaca());
		stmt2.execute();
		
		stmt.close();
		stmt2.close();
		stmt3.close();
				
	}
	
	public void pesquisarVeiculo(UsuarioVeiculo veiculo) throws SQLException {
		
		String sql = "select * from veiculos where placa = ? and status = 'PRESENTE';";
		
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		
		stmt.setString(1, veiculo.getPlaca());
		
		stmt.execute();
		
		ResultSet resultado = stmt.getResultSet();
		if(resultado.next()){
			veiculo.setMatricula(resultado.getString("matricula"));
			veiculo.setNome(resultado.getString("nome"));
			veiculo.setMarca(resultado.getString("marca"));
			veiculo.setTipo(resultado.getString("tipo"));
			veiculo.setStatus(resultado.getString("status"));
		}else {
			JOptionPane.showMessageDialog(null, "Veículo não encontrado!");
		}
		stmt.close();
		
	}
	public List<UsuarioVeiculo> pesquisarVeiculoPorBloco(String bloco) throws ParseException, SQLException{
		
		
		String sql = "select * from veiculos where bloco = ? and status = 'PRESENTE';";
		
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		
		stmt.setString(1, bloco);
		
		stmt.execute();
		
		ResultSet resultado = stmt.getResultSet();
		
		List<UsuarioVeiculo> tabela = new ArrayList<>();
		
		try {

			while (resultado.next()) {
				UsuarioVeiculo usu = new UsuarioVeiculo();

				usu.setMatricula(resultado.getString("matricula"));
				usu.setNome(resultado.getString("nome"));
				usu.setPlaca(resultado.getString("placa"));
				usu.setMarca(resultado.getString("marca"));
				usu.setTipo(resultado.getString("tipo"));
				usu.setData(resultado.getDate("data"));
				usu.setHora(resultado.getString("hora"));
				usu.setStatus(resultado.getString("status"));
				usu.setBloco(resultado.getString("bloco"));
				tabela.add(usu);

			}
		} catch (SQLException ex) {
			Logger.getLogger(ConexaoVeiculo.class.getName()).log(Level.SEVERE, null, ex);

		}
		stmt.close();
		
		return tabela;
		
	}
	//em fase de teste e melhorias
	public void qntDeVagasPorBloco(Vagas local,String status) throws SQLException {
		
		if(local.getLocal().equals("Todos")) {
			String sql4 = "select tipo as 'todos', count(*) as qnt from veiculos where status = ? and tipo = 'carro' group by tipo;";
			PreparedStatement stmt4 = (PreparedStatement) conexao.prepareStatement(sql4);
			stmt4.setString(1, status);
			stmt4.execute();
			String sql5 = "select tipo as 'todos', count(*) as qnt from veiculos where status = ? and tipo = 'moto' group by tipo;";
			PreparedStatement stmt5 = (PreparedStatement) conexao.prepareStatement(sql5);
			stmt5.setString(1, status);
			stmt5.execute();
			String sql6 = "select tipo as 'todos', count(*) as qnt from veiculos where status = ? and tipo = 'especial' group by tipo;";
			PreparedStatement stmt6 = (PreparedStatement) conexao.prepareStatement(sql6);
			stmt6.setString(1, status);
			stmt6.execute();
			
			
			ResultSet resultado4 = stmt4.getResultSet();
			ResultSet resultado5 = stmt5.getResultSet();
			ResultSet resultado6 = stmt6.getResultSet();

			if(resultado4.next()) {
				local.setCarro(resultado4.getInt("qnt"));
			}
			if(resultado5.next()) {
				local.setMoto(resultado5.getInt("qnt"));
			}
			
			if(resultado6.next()) {
				local.setEspecial(resultado6.getInt("qnt"));
			}
			stmt4.close();
			stmt5.close();
			stmt6.close();
		}
	
		
		String sql = "select bloco as ?, count(*) as qnt from veiculos where status = ? and tipo = 'carro' and bloco = ? group by bloco;";
		String sql2 = "select bloco as ?, count(*) as qnt from veiculos where status = ? and tipo = 'moto' and bloco = ? group by bloco;";
		String sql3 = "select bloco as ?, count(*) as qnt from veiculos where status = ? and tipo = 'especial' and bloco = ? group by bloco;";
		
		
		
		PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
		stmt.setString(1, local.getLocal());
		stmt.setString(2, status);
		stmt.setString(3, local.getLocal());
		PreparedStatement stmt2 = (PreparedStatement) conexao.prepareStatement(sql2);
		stmt2.setString(1, local.getLocal());
		stmt2.setString(2, status);
		stmt2.setString(3, local.getLocal());
		PreparedStatement stmt3 = (PreparedStatement) conexao.prepareStatement(sql3);
		stmt3.setString(1, local.getLocal());
		stmt3.setString(2, status);
		stmt3.setString(3, local.getLocal());
		
		stmt.execute();
		stmt2.execute();
		stmt3.execute();
		ResultSet resultado = stmt.getResultSet();
		ResultSet resultado2 = stmt2.getResultSet();
		ResultSet resultado3 = stmt3.getResultSet();

		if(resultado.next()) {
			
			if(local.getLocal().equals(resultado.getString(1))) {
				local.setCarro(resultado.getInt("qnt"));
			}else if(local.getLocal().equals(resultado.getString(1))) {
				local.setCarro(resultado.getInt("qnt"));
			}else if(local.getLocal().equals(resultado.getString(1))) {
				local.setCarro(resultado.getInt("qnt"));
			}else if(local.getLocal().equals(resultado.getString(1))) {
				local.setCarro(resultado.getInt("qnt"));
			}else if(local.getLocal().equals(resultado.getString(1))) {
				local.setCarro( resultado.getInt("qnt"));
			}else if(local.getLocal().equals(resultado.getString(1))) {
				local.setCarro(resultado.getInt("qnt"));
			}else if(local.getLocal().equals(resultado.getString(1))) {
				local.setCarro(resultado.getInt("qnt"));
			}else if(local.getLocal().equals(resultado.getString(1))) {
				local.setCarro(resultado.getInt("qnt"));
			}
		}
		if(resultado2.next()) {
			
			if(local.getLocal().equals(resultado2.getString(1))) {
				local.setMoto(resultado2.getInt("qnt"));
			}else if(local.getLocal().equals(resultado2.getString(1))) {
				local.setMoto(resultado2.getInt("qnt"));
			}else if(local.getLocal().equals(resultado2.getString(1))) {
				local.setMoto(resultado2.getInt("qnt"));
			}else if(local.getLocal().equals(resultado2.getString(1))) {
				local.setMoto(resultado2.getInt("qnt"));
			}else if(local.getLocal().equals(resultado2.getString(1))) {
				local.setMoto(resultado2.getInt("qnt"));
			}else if(local.getLocal().equals(resultado2.getString(1))) {
				local.setMoto(resultado2.getInt("qnt"));
			}else if(local.getLocal().equals(resultado2.getString(1))) {
				local.setMoto(resultado2.getInt("qnt"));
			}else if(local.getLocal().equals(resultado2.getString(1))) {
				local.setMoto(resultado2.getInt("qnt"));
			}
		}
		
		if(resultado3.next()) {
			
			if(local.getLocal().equals(resultado3.getString(1))) {
				local.setEspecial(resultado3.getInt("qnt"));
			}else if(local.getLocal().equals(resultado3.getString(1))) {
				local.setEspecial(resultado3.getInt("qnt"));
			}else if(local.getLocal().equals(resultado3.getString(1))) {
				local.setEspecial(resultado3.getInt("qnt"));
			}else if(local.getLocal().equals(resultado3.getString(1))) {
				local.setEspecial(resultado3.getInt("qnt"));
			}else if(local.getLocal().equals(resultado3.getString(1))) {
				local.setEspecial(resultado3.getInt("qnt"));
			}else if(local.getLocal().equals(resultado3.getString(1))) {
				local.setEspecial(resultado3.getInt("qnt"));
			}else if(local.getLocal().equals(resultado3.getString(1))) {
				local.setEspecial(resultado3.getInt("qnt"));
			}else if(local.getLocal().equals(resultado3.getString(1))) {
				local.setEspecial(resultado3.getInt("qnt"));
			}
		}
		stmt.close();
		stmt2.close();
		stmt3.close();
		
		
	}
	
	public List<UsuarioVeiculo> pesquisarPorData(String local, String dataInicio, String dataFim) throws SQLException{
		
		List<UsuarioVeiculo> tabela = new ArrayList<>();
		
		if(local.equals("Todos")) {
			String sql = "select * from veiculos where status = 'AUSENTE' and data between ? and ?";
			
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setString(1, dataInicio);
			stmt.setString(2, dataFim);
			
			
			stmt.execute();
			
			ResultSet resultado = stmt.getResultSet();
			
			while(resultado.next()) {
				UsuarioVeiculo veiculo = new UsuarioVeiculo();
				
				veiculo.setMatricula(resultado.getString("matricula"));
				veiculo.setNome(resultado.getString("nome"));
				veiculo.setPlaca(resultado.getString("placa"));
				veiculo.setMarca(resultado.getString("marca"));
				veiculo.setTipo(resultado.getString("tipo"));
				veiculo.setData(resultado.getDate("data"));
				veiculo.setHora(resultado.getString("hora"));
				veiculo.setStatus(resultado.getString("status"));
				veiculo.setBloco(resultado.getString("bloco"));
				tabela.add(veiculo);
			}
		}else {
			
			String sql = "select * from veiculos where bloco = ? and status = 'AUSENTE' and data between ? and ?";
			
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
			stmt.setString(1, local);
			stmt.setString(2, dataInicio);
			stmt.setString(3, dataFim);
			
			
			stmt.execute();
			
			ResultSet resultado = stmt.getResultSet();
			
			while(resultado.next()) {
				UsuarioVeiculo veiculo = new UsuarioVeiculo();
				
				veiculo.setMatricula(resultado.getString("matricula"));
				veiculo.setNome(resultado.getString("nome"));
				veiculo.setPlaca(resultado.getString("placa"));
				veiculo.setMarca(resultado.getString("marca"));
				veiculo.setTipo(resultado.getString("tipo"));
				veiculo.setData(resultado.getDate("data"));
				veiculo.setHora(resultado.getString("hora"));
				veiculo.setStatus(resultado.getString("status"));
				veiculo.setBloco(resultado.getString("bloco"));
				tabela.add(veiculo);
			}
		}
		
		return tabela;
		
	}
public List<UsuarioVeiculo> historicoEstacionamento(String bloco) throws ParseException, SQLException{
	
		List<UsuarioVeiculo> tabela = new ArrayList<>();
	
		if(bloco.equals("Todos")) {
			String sql = "select * from veiculos where status = 'AUSENTE';";
			
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
			
			stmt.execute();
			
			ResultSet resultado = stmt.getResultSet();
			
			try {

				while (resultado.next()) {
					UsuarioVeiculo usu = new UsuarioVeiculo();

					usu.setMatricula(resultado.getString("matricula"));
					usu.setNome(resultado.getString("nome"));
					usu.setPlaca(resultado.getString("placa"));
					usu.setMarca(resultado.getString("marca"));
					usu.setTipo(resultado.getString("tipo"));
					usu.setData(resultado.getDate("data"));
					usu.setHora(resultado.getString("hora"));
					usu.setStatus(resultado.getString("status"));
					usu.setBloco(resultado.getString("bloco"));
					tabela.add(usu);

				}
			} catch (SQLException ex) {
				Logger.getLogger(ConexaoVeiculo.class.getName()).log(Level.SEVERE, null, ex);

			}
			stmt.close();
		}else {
			
			String sql = "select * from veiculos where bloco = ? and status = 'AUSENTE';";
			
			PreparedStatement stmt = (PreparedStatement) conexao.prepareStatement(sql);
			
			stmt.setString(1, bloco);
			
			stmt.execute();
			
			ResultSet resultado = stmt.getResultSet();
			
			try {

				while (resultado.next()) {
					UsuarioVeiculo usu = new UsuarioVeiculo();

					usu.setMatricula(resultado.getString("matricula"));
					usu.setNome(resultado.getString("nome"));
					usu.setPlaca(resultado.getString("placa"));
					usu.setMarca(resultado.getString("marca"));
					usu.setTipo(resultado.getString("tipo"));
					usu.setData(resultado.getDate("data"));
					usu.setHora(resultado.getString("hora"));
					usu.setStatus(resultado.getString("status"));
					usu.setBloco(resultado.getString("bloco"));
					tabela.add(usu);

				}
			} catch (SQLException ex) {
				Logger.getLogger(ConexaoVeiculo.class.getName()).log(Level.SEVERE, null, ex);

			}
			stmt.close();
			
		}
		
		
		return tabela;
		
	}

}
