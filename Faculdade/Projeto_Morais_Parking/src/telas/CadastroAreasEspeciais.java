package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import conexao.Conexao;
import conexao.ConexaoAreasEspeciais;
import conexao.ConexaoEventos;
import conexao.ConexaoVeiculo;
import modelo.AreasEspeciais;
import modelo.Eventos;
import modelo.Vagas;

public class CadastroAreasEspeciais extends JFrame {

	private JPanel contentPane;
	private JTextField tf_TotalVagas;
	private JTable table;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private DefaultTableModel dtm = new DefaultTableModel();
	String local;
	int xx;
	int xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAreasEspeciais frame = new CadastroAreasEspeciais();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroAreasEspeciais() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setType(Type.POPUP);
		setResizable(false);
		setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 611, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(208, 50, 47));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 616, 27);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_Sair = new JButton("");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		btn_Sair.setIcon(new ImageIcon(CadastroEvento.class.getResource("/imagens/fechar.png")));
		btn_Sair.setBounds(580, 5, 16, 16);
		panel.add(btn_Sair);
		
		JLabel lblCadastroDeEventos = new JLabel("Cadastro de \u00C1reas Especiais");
		lblCadastroDeEventos.setBounds(12, 5, 232, 14);
		panel.add(lblCadastroDeEventos);
		
		JPanel panel_Salvar = new JPanel();
		panel_Salvar.setBackground(Color.LIGHT_GRAY);
		panel_Salvar.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, null, null));
		panel_Salvar.setBounds(10, 40, 589, 130);
		contentPane.add(panel_Salvar);
		panel_Salvar.setLayout(null);
		
		JLabel lbl_Descricao = new JLabel("Descri\u00E7\u00E3o:");
		lbl_Descricao.setBounds(10, 42, 70, 14);
		panel_Salvar.add(lbl_Descricao);
		
		JLabel lbl_TotalVagas = new JLabel("Total Vagas:");
		lbl_TotalVagas.setBounds(76, 104, 81, 14);
		panel_Salvar.add(lbl_TotalVagas);
		
		tf_TotalVagas = new JTextField();
		tf_TotalVagas.setBounds(154, 101, 40, 20);
		panel_Salvar.add(tf_TotalVagas);
		tf_TotalVagas.setColumns(10);
		//Deixar o campo(textfild) de vagas extras visivel
		JDateChooser jc_Data_Fim = new JDateChooser();
		JDateChooser jc_Data_Inicio = new JDateChooser();
		JLabel lbl_DataFim = new JLabel("D. Fim:");
		JLabel lbl_DataInicio = new JLabel("D. Inicio:");
		JCheckBox clickbx_TempoIndeterminado = new JCheckBox("Tempo Indeterminado");
		clickbx_TempoIndeterminado.setBackground(Color.LIGHT_GRAY);
		clickbx_TempoIndeterminado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clickbx_TempoIndeterminado.isSelected()) {
					jc_Data_Inicio.setEnabled(false);
					jc_Data_Fim.setEnabled(false);
					lbl_DataInicio.setEnabled(false);
					lbl_DataFim.setEnabled(false);
				}else {
					jc_Data_Inicio.setEnabled(true);
					jc_Data_Fim.setEnabled(true);
					lbl_DataInicio.setEnabled(true);
					lbl_DataFim.setEnabled(true);
				}
				
			}
		});
		clickbx_TempoIndeterminado.setBounds(223, 100, 158, 23);
		panel_Salvar.add(clickbx_TempoIndeterminado);
		
		jc_Data_Inicio.setBounds(429, 11, 150, 20);
		panel_Salvar.add(jc_Data_Inicio);
		jc_Data_Inicio.setDateFormatString("dd/MM/yyyy");
		
		
		
		jc_Data_Fim.setBounds(429, 42, 150, 20);
		panel_Salvar.add(jc_Data_Fim);
		jc_Data_Fim.setDateFormatString("dd/MM/yyyy");
		
		lbl_DataInicio.setBounds(371, 14, 58, 14);
		panel_Salvar.add(lbl_DataInicio);
		
		
		lbl_DataFim.setBounds(371, 45, 48, 14);
		panel_Salvar.add(lbl_DataFim);
		JComboBox comboBox_Local = new JComboBox();
		JComboBox comboBox_Acesso = new JComboBox();
		JTextArea textArea_Descricao = new JTextArea();
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);

		
		JButton btn_Salvar = new JButton("");
		btn_Salvar.setBackground(Color.LIGHT_GRAY);
		//Salvar informações inseridas na tela
		btn_Salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bloco = (String) comboBox_Local.getSelectedItem();
				String acesso = (String) comboBox_Acesso.getSelectedItem();
				String descricao = textArea_Descricao.getText();
				int totalVagas = Integer.parseInt(tf_TotalVagas.getText());
				Date dataInicio = null;
				Date dataFim = null;
				String indeterminado;
				
				Vagas vagas = new Vagas(bloco);
				int total = 0;
				try {
					Connection conexao = new Conexao().fazer_conexao();
					ConexaoVeiculo lista = new ConexaoVeiculo(conexao);
					ConexaoEventos totalEventos = new ConexaoEventos(conexao);
					lista.qntDeVagasPorBloco(vagas, "PRESENTE");
					total = totalEventos.totalDeVagasEventos(bloco);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(!clickbx_TempoIndeterminado.isSelected()) {
					dataInicio = jc_Data_Inicio.getDate();
					dataFim = jc_Data_Fim.getDate();
					indeterminado = "Não";
				}else {
					indeterminado = "Sim";
				}
				dtm = (DefaultTableModel) table.getModel();
				int tv = vagas.totalVagas() - (totalVagas + total);
				if(tv < 0) {
					JOptionPane.showMessageDialog(null, "Quantidade de vagas não suportada pelo estacionamento!!");
				}else if(dataInicio == null || dataFim == null) {
					Object[] dados = {bloco,acesso,dataInicio,dataFim,indeterminado,totalVagas,descricao};
					dtm.addRow(dados);
				}else {
					Object[] dados = {bloco,acesso,sdf.format(dataInicio),sdf.format(dataFim),indeterminado,totalVagas,descricao};
					dtm.addRow(dados);
				}
				comboBox_Local.setSelectedItem("Selecionar...");
				comboBox_Acesso.setSelectedItem("Selecionar...");
				textArea_Descricao.setText("");
				tf_TotalVagas.setText("");
				jc_Data_Inicio.setDate(null);
				jc_Data_Fim.setDate(null);
				
				

			}
		});
		btn_Salvar.setIcon(new ImageIcon(CadastroEvento.class.getResource("/imagens/accept.png")));
		btn_Salvar.setBounds(524, 100, 18, 18);
		panel_Salvar.add(btn_Salvar);
		comboBox_Local.setModel(new DefaultComboBoxModel(new String[] {"Selecionar...", "Bloco Central", "Bloco A", "Bloco B", 
				"Bloco C", "Bloco D", "Bloco E", "Bloco F", "Bloco G"}));
		comboBox_Local.setBounds(78, 8, 116, 23);
		panel_Salvar.add(comboBox_Local);
		
		JLabel lblLocal = new JLabel("Local:");
		lblLocal.setBounds(10, 12, 48, 14);
		panel_Salvar.add(lblLocal);
		
		JButton btn_Remover = new JButton("");
		btn_Remover.setBackground(Color.LIGHT_GRAY);
		//deleta os campos salvos na tabela
		btn_Remover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1) {
					DefaultTableModel dtm = (DefaultTableModel) table.getModel();
					dtm.removeRow(table.getSelectedRow());
				}else {
					
				}

			}
		});
		btn_Remover.setIcon(new ImageIcon(CadastroEvento.class.getResource("/imagens/delete.png")));
		btn_Remover.setBounds(551, 100, 18, 18);
		panel_Salvar.add(btn_Remover);
		
		
		textArea_Descricao.setBounds(78, 37, 283, 56);
		panel_Salvar.add(textArea_Descricao);
		
		JLabel lblAcesso = new JLabel("Acesso:");
		lblAcesso.setBounds(197, 12, 48, 14);
		panel_Salvar.add(lblAcesso);
		
		
		comboBox_Acesso.setModel(new DefaultComboBoxModel(new String[] {"Selecionar...", "Diretoria", "Funcion\u00E1rios", "Convidados", "Outros"}));
		comboBox_Acesso.setBounds(245, 8, 116, 23);
		panel_Salvar.add(comboBox_Acesso);
		
		JPanel panel_Tabela = new JPanel();
		panel_Tabela.setBackground(Color.LIGHT_GRAY);
		panel_Tabela.setLayout(null);
		panel_Tabela.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, null, null));
		panel_Tabela.setBounds(10, 177, 589, 181);
		contentPane.add(panel_Tabela);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.LIGHT_GRAY);
		scrollPane.setBounds(10, 11, 565, 159);
		panel_Tabela.add(scrollPane);

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Bloco", "Acesso", "Inicio", "Fim", "Indeterminado", "Total Vagas", "Descri\u00E7\u00E3o"
			}
		));
		table.getColumnModel().getColumn(4).setPreferredWidth(93);
		scrollPane.setViewportView(table);
		
		JButton btn_SalvarNoBanco = new JButton("Salvar");
		btn_SalvarNoBanco.setBackground(Color.LIGHT_GRAY);
		//salvar eventos no banco de dados
		btn_SalvarNoBanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bloco = "";
				String acesso = "";
				String descricao = "";
				int totalVagas = 0;
				Date dataInicio = null;
				Date dataFim = null;
				String indeterminado = "";
				int x = 0;
				if(dtm.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Nenhuma informação adicionada na tabela!");
				}else {
					for(int i = 0; i < dtm.getRowCount();i++) {
						if(dtm.getValueAt(x, 2) == null || dtm.getValueAt(x, 3) == null) {
							try {
								Connection conexao = new Conexao().fazer_conexao();
								ConexaoAreasEspeciais cadastrarArea = new ConexaoAreasEspeciais(conexao);
								bloco = (String) dtm.getValueAt(x, 0);
								acesso =(String) dtm.getValueAt(x, 1);
								dataInicio = null;
								dataFim = null;
								indeterminado =(String) dtm.getValueAt(x, 4);
								totalVagas =(int) dtm.getValueAt(x, 5);
								descricao =(String) dtm.getValueAt(x, 6);
								AreasEspeciais novaArea = new AreasEspeciais(bloco, acesso, dataInicio, dataFim, indeterminado, descricao, totalVagas);
								cadastrarArea.cadastrarAreaEspecial(novaArea);
								JOptionPane.showMessageDialog(null, "Informações salvas com sucesso!");
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							
						}else {
							try {
								Connection conexao = new Conexao().fazer_conexao();
								ConexaoAreasEspeciais cadastrarArea = new ConexaoAreasEspeciais(conexao);
								bloco = (String) dtm.getValueAt(x, 0);
								acesso =(String) dtm.getValueAt(x, 1);
								dataInicio = sdf.parse((String)dtm.getValueAt(x, 2));
								dataFim = sdf.parse((String)dtm.getValueAt(x, 3));
								indeterminado =(String) dtm.getValueAt(x, 4);
								totalVagas =(int) dtm.getValueAt(x, 5);
								descricao =(String) dtm.getValueAt(x, 6);
								AreasEspeciais novaArea = new AreasEspeciais(bloco, acesso, dataInicio, dataFim, indeterminado, descricao, totalVagas);
								cadastrarArea.cadastrarAreaEspecial(novaArea);
								JOptionPane.showMessageDialog(null, "Informações salvas com sucesso!");
							} catch (ParseException | SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						x++;
					}
				}
				
				while(dtm.getRowCount() !=0) {
					dtm.removeRow(0);
				}

			}
		});
		btn_SalvarNoBanco.setIcon(new ImageIcon(CadastroEvento.class.getResource("/imagens/database_add.png")));
		btn_SalvarNoBanco.setBounds(496, 363, 99, 23);
		contentPane.add(btn_SalvarNoBanco);
		//função para arrastar a tela da forma que quiser
		JLabel lbl_Mover_Tela = new JLabel("");
		lbl_Mover_Tela.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				xx = e.getX();
				xy = e.getY();
			}
		});
		lbl_Mover_Tela.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				CadastroAreasEspeciais.this.setLocation(x - xx, y - xy);
				
			}
		});
		lbl_Mover_Tela.setBounds(0, 0, 605, 386);
		contentPane.add(lbl_Mover_Tela);
		

	}
}
