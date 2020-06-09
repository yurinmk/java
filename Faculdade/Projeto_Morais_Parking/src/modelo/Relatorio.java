package modelo;


import java.sql.Connection;
import java.sql.SQLException;


import conexao.Conexao;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio {
	
	public void gerarRelatórioVeiculos(String query) throws JRException, SQLException {
		
		Connection conexao = new Conexao().fazer_conexao();
		//InputStream fonte = Relatorio.class.getResourceAsStream("/report/Teste.jrxml");
		
		JasperDesign fonte2 = JRXmlLoader.load("C:\\Temp\\ws-eclipse\\Faculdade\\Projeto_Morais_Parking\\src\\report\\Veiculos.jrxml");
		String sql = query;
		JRDesignQuery novaConsulta = new JRDesignQuery();
		
		novaConsulta.setText(sql);
		fonte2.setQuery(novaConsulta);
		JasperReport jr = JasperCompileManager.compileReport(fonte2);
		JasperPrint print = JasperFillManager.fillReport(jr, null, conexao);
		JasperViewer.viewReport(print,false);
	}
	public void gerarRelatórioOcorrencias(String query) throws JRException, SQLException {
		
		Connection conexao = new Conexao().fazer_conexao();
		//InputStream fonte = Relatorio.class.getResourceAsStream("/report/Teste.jrxml");
		
		JasperDesign fonte2 = JRXmlLoader.load("C:\\Temp\\ws-eclipse\\Faculdade\\Projeto_Morais_Parking\\src\\report\\Ocorrencias.jrxml");
		String sql = query;
		JRDesignQuery novaConsulta = new JRDesignQuery();
		
		novaConsulta.setText(sql);
		fonte2.setQuery(novaConsulta);
		JasperReport jr = JasperCompileManager.compileReport(fonte2);
		JasperPrint print = JasperFillManager.fillReport(jr, null, conexao);
		JasperViewer.viewReport(print,false);
	}
	public void gerarRelatórioEventos(String query) throws JRException, SQLException {
		
		Connection conexao = new Conexao().fazer_conexao();
		//InputStream fonte = Relatorio.class.getResourceAsStream("/report/Teste.jrxml");
		
		JasperDesign fonte2 = JRXmlLoader.load("C:\\Temp\\ws-eclipse\\Faculdade\\Projeto_Morais_Parking\\src\\report\\Eventos.jrxml");
		String sql = query;
		JRDesignQuery novaConsulta = new JRDesignQuery();
		
		novaConsulta.setText(sql);
		fonte2.setQuery(novaConsulta);
		JasperReport jr = JasperCompileManager.compileReport(fonte2);
		JasperPrint print = JasperFillManager.fillReport(jr, null, conexao);
		JasperViewer.viewReport(print,false);
	}

}
