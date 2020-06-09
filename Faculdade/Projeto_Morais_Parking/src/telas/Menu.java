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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.common.swing.MnemonicUtils;

import conexao.Conexao;
import conexao.ConexaoAreasEspeciais;
import conexao.ConexaoEventos;
import conexao.ConexaoVeiculo;
import modelo.Teste;
import modelo.Usuario;
import modelo.UsuarioVeiculo;
import modelo.Vagas;
import javax.swing.JTextField;

public class Menu extends JFrame {

	private JPanel contentPane;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat sdfBanco = new SimpleDateFormat("yyyy/MM/dd");
	private JTable table;
	private JMenuItem mntmCadastrarreasEspeciais;
	private JMenu m_Relatrios;
	private JMenuItem mi_InserirVeiculo;
	private JMenuItem mi_remover_veiculo;
	private JMenuItem mi_cadastrar_veiculo;
	private JMenuItem mi_cadastrar_evento;
	private JMenuItem mi_cadastrar_ocorrencia;
	private JMenuItem mntmDarPermissoreas;
	int xx;
	int xy;
	String local;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 946, 542);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(208, 50, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTotal = new JLabel("Total:");
		JTextPane tp_tvagas = new JTextPane();
		JLabel lblVagasEspeciis = new JLabel("Carros:");
		JTextPane tp_carros = new JTextPane();
		JLabel lblVagasMotos = new JLabel("Especiais:");
		JLabel lblMotos = new JLabel("Motos:");
		JTextPane tp_motos = new JTextPane();
		JTextPane tp_especiais = new JTextPane();
		JTextPane tp_AreasE = new JTextPane();
		JTextPane tp_Eventos = new JTextPane();

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 961, 22);
		contentPane.add(menuBar);

		JMenu m_arquivo = new JMenu("Arquivo");
		menuBar.add(m_arquivo);

		JMenuItem m_deslogar = new JMenuItem("Deslogar");
		m_deslogar.setIcon(new ImageIcon(Menu.class.getResource("/imagens/delogar.png")));
		m_deslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acesso passarTela = new Acesso();
				passarTela.setUndecorated(true);
				passarTela.setLocationRelativeTo(null);
				passarTela.setVisible(true);
				setVisible(false);

			}
		});
		m_arquivo.add(m_deslogar);

		JMenuItem m_fechar_app = new JMenuItem("Fechar");
		m_fechar_app.setIcon(new ImageIcon(Menu.class.getResource("/imagens/fechar.png")));
		m_fechar_app.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		m_arquivo.add(m_fechar_app);

		JMenu m_funcoes = new JMenu("A\u00E7\u00F5es");
		menuBar.add(m_funcoes);

		mi_remover_veiculo = new JMenuItem("Remover Ve\u00EDculos");
		mi_remover_veiculo.setIcon(new ImageIcon(Menu.class.getResource("/imagens/remover.png")));
		mi_remover_veiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RemoverVeiculo passarTela = new RemoverVeiculo();
				passarTela.setUndecorated(true);
				passarTela.setLocationRelativeTo(null);
				passarTela.setVisible(true);
				setVisible(false);
			}
		});

		mi_InserirVeiculo = new JMenuItem("Identificar Ve\u00EDculo");
		mi_InserirVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdentificarVeiculos passarTela = new IdentificarVeiculos();
				passarTela.setUndecorated(true);
				passarTela.setLocationRelativeTo(null);
				passarTela.setVisible(true);
				setVisible(false);

			}
		});
		mi_InserirVeiculo.setIcon(new ImageIcon(Menu.class.getResource("/imagens/paste_plain.png")));
		m_funcoes.add(mi_InserirVeiculo);
		m_funcoes.add(mi_remover_veiculo);

		mi_cadastrar_veiculo = new JMenuItem("Cadastrar Ve\u00EDculos");
		mi_cadastrar_veiculo.setIcon(new ImageIcon(Menu.class.getResource("/imagens/cadastrar.png")));
		mi_cadastrar_veiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroVeiculo passarTela = new CadastroVeiculo();
				passarTela.setUndecorated(true);
				passarTela.setLocationRelativeTo(null);
				passarTela.setVisible(true);
				setVisible(false);

			}
		});
		m_funcoes.add(mi_cadastrar_veiculo);

		mi_cadastrar_evento = new JMenuItem("Cadastrar Eventos");
		mi_cadastrar_evento.setIcon(new ImageIcon(Menu.class.getResource("/imagens/add.png")));
		mi_cadastrar_evento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroEvento abrirTela = new CadastroEvento();
				abrirTela.setUndecorated(true);
				abrirTela.setLocationRelativeTo(null);
				abrirTela.setVisible(true);
			}
		});
		m_funcoes.add(mi_cadastrar_evento);

		mi_cadastrar_ocorrencia = new JMenuItem("Cadastrar Ocorr\u00EAncias");
		mi_cadastrar_ocorrencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastroOcorrencia passarTela = new CadastroOcorrencia();
				passarTela.setUndecorated(true);
				passarTela.setVisible(true);
				passarTela.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		mi_cadastrar_ocorrencia.setIcon(new ImageIcon(Menu.class.getResource("/imagens/exclamation.png")));
		m_funcoes.add(mi_cadastrar_ocorrencia);

		JMenuItem mntmPesquisarPorData = new JMenuItem("Hist\u00F3rico do Estacionamento");
		mntmPesquisarPorData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoricoEstacionamento passarTela = new HistoricoEstacionamento();
				passarTela.setUndecorated(true);
				passarTela.setLocationRelativeTo(null);
				passarTela.setVisible(true);
				setVisible(false);

			}
		});
		
		mntmCadastrarreasEspeciais = new JMenuItem("Cadastrar \u00C1reas Especiais");
		mntmCadastrarreasEspeciais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroAreasEspeciais passarTela = new CadastroAreasEspeciais();
				passarTela.setUndecorated(true);
				passarTela.setLocationRelativeTo(null);
				passarTela.setVisible(true);
			}
		});
		
		mntmDarPermissoreas = new JMenuItem("Dar Permiss\u00E3o \u00C1reas E.");
		mntmDarPermissoreas.setIcon(new ImageIcon(Menu.class.getResource("/imagens/dar_permiss16.jpg")));
		mntmDarPermissoreas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DarPermissao passarTela = new DarPermissao();
				passarTela.cargo(false);
				passarTela.setUndecorated(true);
				passarTela.setLocationRelativeTo(null);
				passarTela.setVisible(true);
				
			}
		});
		m_funcoes.add(mntmDarPermissoreas);
		mntmCadastrarreasEspeciais.setIcon(new ImageIcon(Menu.class.getResource("/imagens/star.png")));
		m_funcoes.add(mntmCadastrarreasEspeciais);
		mntmPesquisarPorData.setIcon(new ImageIcon(Menu.class.getResource("/imagens/magnifier.png")));
		m_funcoes.add(mntmPesquisarPorData);

		JMenu m_Monitoramento = new JMenu("Monitoramento");
		menuBar.add(m_Monitoramento);

		JMenuItem mi_eventoMon = new JMenuItem("Eventos");
		mi_eventoMon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MonitoramentoEvento passarTela = new MonitoramentoEvento();
				passarTela.setUndecorated(true);
				passarTela.setLocationRelativeTo(null);
				passarTela.setVisible(true);

			}
		});
		mi_eventoMon.setIcon(new ImageIcon(Menu.class.getResource("/imagens/eye.png")));
		m_Monitoramento.add(mi_eventoMon);

		JMenuItem mi_OcorrenciaMon = new JMenuItem("Ocorr\u00EAncia");
		mi_OcorrenciaMon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MonitoramentoOcorrencia passarTela = new MonitoramentoOcorrencia();
				passarTela.setUndecorated(true);
				passarTela.setLocationRelativeTo(null);
				passarTela.setVisible(true);
				setVisible(false);
			}
		});
		mi_OcorrenciaMon.setIcon(new ImageIcon(Menu.class.getResource("/imagens/eye.png")));
		m_Monitoramento.add(mi_OcorrenciaMon);
		
		JMenuItem mi_AreasEspeciais = new JMenuItem("\u00C1reas Especiais");
		mi_AreasEspeciais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MonitoramentoAreasEspeciais passarTela = new MonitoramentoAreasEspeciais();
				passarTela.setUndecorated(true);
				passarTela.setLocationRelativeTo(null);
				passarTela.setVisible(true);
			}
		});
		mi_AreasEspeciais.setIcon(new ImageIcon(Menu.class.getResource("/imagens/eye.png")));
		m_Monitoramento.add(mi_AreasEspeciais);

		m_Relatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(m_Relatrios);

		JMenuItem mi_Visualizar = new JMenuItem("Visualizar/Extrair");
		mi_Visualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GerarRelatorios passarTela = new GerarRelatorios();
				passarTela.setUndecorated(true);
				passarTela.setLocationRelativeTo(null);
				passarTela.setVisible(true);
				
			}
		});
		mi_Visualizar.setIcon(new ImageIcon(Menu.class.getResource("/imagens/pdf.png")));
		m_Relatrios.add(mi_Visualizar);

		JPanel panel_Tablea = new JPanel();
		panel_Tablea.setBackground(Color.LIGHT_GRAY);
		panel_Tablea.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, null, null));
		panel_Tablea.setBounds(10, 149, 920, 375);
		contentPane.add(panel_Tablea);
		panel_Tablea.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 900, 342);
		panel_Tablea.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBounds(0, 165, 811, 277);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Matricula", "Nome", "Placa", "Marca", "Tipo", "Data", "Hora", "Status", "Bloco" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(64);
		table.getColumnModel().getColumn(1).setPreferredWidth(207);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, null, null));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 33, 920, 105);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lbl_blocos = new JLabel("Blocos:");
		lbl_blocos.setBounds(10, 15, 61, 14);
		panel.add(lbl_blocos);
		lbl_blocos.setForeground(Color.BLACK);

		JComboBox combob_blocos = new JComboBox();
		combob_blocos.setBounds(72, 11, 142, 22);
		panel.add(combob_blocos);
		combob_blocos.setBackground(Color.WHITE);
		combob_blocos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();

				String status = "PRESENTE";

				UsuarioVeiculo bloco = new UsuarioVeiculo();
				bloco.setBloco((String) combob_blocos.getSelectedItem());
				local = (String) combob_blocos.getSelectedItem();
				Vagas vagas = new Vagas((String) combob_blocos.getSelectedItem());
				// zera a tabela quando muda de bloco
				while (dtm.getRowCount() != 0) {
					dtm.removeRow(0);
				}
				try {
					// faz a conexao
					Connection conexao = new Conexao().fazer_conexao();
					ConexaoVeiculo lista = new ConexaoVeiculo(conexao);
					ConexaoEventos totalVagas = new ConexaoEventos(conexao);
					ConexaoAreasEspeciais totalVagasAE = new ConexaoAreasEspeciais(conexao);
					int total = totalVagas.totalDeVagasEventos((String) combob_blocos.getSelectedItem());
					int totalAE = totalVagasAE.qntVagas((String) combob_blocos.getSelectedItem());
					// método para setar a quantidade de vagas em seus devidos campos
					lista.qntDeVagasPorBloco(vagas, status);
					tp_motos.setText(Integer.toString(vagas.totalVagasMoto()));
					tp_carros.setText(Integer.toString(vagas.totalVagasCarro() - total - totalAE));
					tp_especiais.setText(Integer.toString(vagas.totalVagasEspeciais()));
					tp_tvagas.setText(Integer.toString(vagas.totalVagas() - total - totalAE));
					tp_AreasE.setText(Integer.toString(totalAE));
					tp_Eventos.setText(Integer.toString(total));
					// for para adicionar os elementos na tabela
					for (UsuarioVeiculo x : lista.pesquisarVeiculoPorBloco(bloco.getBloco())) {
						Object[] dado = { x.getMatricula(), x.getNome(), x.getPlaca(), x.getMarca(), x.getTipo(),
								sdf.format(x.getData()), x.getHora(), x.getStatus(), x.getBloco() };
						dtm.addRow(dado);
					}
				} catch (SQLException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		combob_blocos.setModel(new DefaultComboBoxModel(new String[] { "Selecionar...", "Bloco Central", "Bloco A",
				"Bloco B", "Bloco C", "Bloco D", "Bloco E", "Bloco F", "Bloco G" }));

		JPanel panel_Vagas = new JPanel();
		panel_Vagas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
				"Vagas Dipon\u00EDveis:", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Vagas.setBackground(Color.LIGHT_GRAY);
		panel_Vagas.setBounds(235, 11, 229, 90);
		panel.add(panel_Vagas);
		panel_Vagas.setLayout(null);

		lblTotal.setBounds(10, 30, 51, 14);
		panel_Vagas.add(lblTotal);
		lblTotal.setForeground(Color.BLACK);

		tp_tvagas.setBounds(65, 23, 37, 22);
		panel_Vagas.add(tp_tvagas);
		tp_tvagas.setEditable(false);

		lblVagasEspeciis.setBounds(10, 63, 51, 14);
		panel_Vagas.add(lblVagasEspeciis);
		lblVagasEspeciis.setForeground(Color.BLACK);

		tp_carros.setBounds(65, 57, 37, 22);
		panel_Vagas.add(tp_carros);
		tp_carros.setEditable(false);

		lblVagasMotos.setBounds(112, 30, 64, 14);
		panel_Vagas.add(lblVagasMotos);
		lblVagasMotos.setForeground(Color.BLACK);

		tp_especiais.setBounds(176, 23, 37, 22);
		panel_Vagas.add(tp_especiais);
		tp_especiais.setEditable(false);

		lblMotos.setBounds(112, 63, 60, 14);
		panel_Vagas.add(lblMotos);
		lblMotos.setForeground(Color.BLACK);

		tp_motos.setBounds(176, 57, 37, 22);
		panel_Vagas.add(tp_motos);
		tp_motos.setEditable(false);
		
		JPanel panel_Vagas_1 = new JPanel();
		panel_Vagas_1.setLayout(null);
		panel_Vagas_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Vagas Reservadas:", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Vagas_1.setBackground(Color.LIGHT_GRAY);
		panel_Vagas_1.setBounds(474, 11, 268, 64);
		panel.add(panel_Vagas_1);
		
		JLabel lblEventos = new JLabel("Eventos:");
		lblEventos.setForeground(Color.BLACK);
		lblEventos.setBounds(10, 30, 51, 14);
		panel_Vagas_1.add(lblEventos);
		
		tp_Eventos.setEditable(false);
		tp_Eventos.setBounds(68, 23, 37, 22);
		panel_Vagas_1.add(tp_Eventos);
		
		JLabel lblAreasE = new JLabel("\u00C1reas Especiais:");
		lblAreasE.setForeground(Color.BLACK);
		lblAreasE.setBounds(112, 30, 99, 14);
		panel_Vagas_1.add(lblAreasE);
		
		
		tp_AreasE.setEditable(false);
		tp_AreasE.setBounds(215, 23, 37, 22);
		panel_Vagas_1.add(tp_AreasE);

		// funções para muver a tela ao clicar
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 961, 524);
		contentPane.add(lblNewLabel);
		

		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				xx = e.getX();
				xy = e.getY();

			}
		});
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {

				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				Menu.this.setLocation(x - xx, y - xy);
			}
		});
	}
	public void cargo(Teste cargo) {
		if(cargo.getCargo().equals("Funcionário")) {
			m_Relatrios.setVisible(false);
			mntmCadastrarreasEspeciais.setVisible(false);
			mntmDarPermissoreas.setVisible(false);
		}else if(cargo.getCargo().equals("Gestor")){
			mi_InserirVeiculo.setVisible(false);
			mi_remover_veiculo.setVisible(false);
			mi_cadastrar_veiculo.setVisible(false);
			mi_cadastrar_ocorrencia.setVisible(false);
			
		}
	}
}
