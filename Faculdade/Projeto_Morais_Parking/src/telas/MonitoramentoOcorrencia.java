package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;
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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import conexao.Conexao;
import conexao.ConexaoOcorrencia;
import conexao.ConexaoVeiculo;
import modelo.Ocorrencia;
import modelo.UsuarioVeiculo;
import modelo.Vagas;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;

public class MonitoramentoOcorrencia extends JFrame {

	private JPanel contentPane;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat sdfBanco = new SimpleDateFormat("yyyy-MM-dd");
	private JTable table;

	int xx;
	int xy;
	private JTextField tf_TOcorrencias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonitoramentoOcorrencia frame = new MonitoramentoOcorrencia();
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
	public MonitoramentoOcorrencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 946, 542);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(208, 50, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox combob_Ocorrencia = new JComboBox();
		JComboBox combob_Blocos = new JComboBox();

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 0, 967, 21);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Monitoramento de Ocorr\u00EAncias");
		lblNewLabel_2.setBounds(10, 4, 206, 14);
		panel_1.add(lblNewLabel_2);

		JPanel panel_Tablea = new JPanel();
		panel_Tablea.setBackground(Color.LIGHT_GRAY);
		panel_Tablea.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, null, null));
		panel_Tablea.setBounds(10, 149, 920, 382);
		contentPane.add(panel_Tablea);
		panel_Tablea.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 900, 349);
		panel_Tablea.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBounds(0, 165, 811, 277);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Placa", "Matricula", "Nome", "Marca", "TIpo", "Ocorrencia", "Data", "Hora", "Local", "Protocolo"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(112);
		table.getColumnModel().getColumn(2).setPreferredWidth(246);
		table.getColumnModel().getColumn(5).setPreferredWidth(161);
		table.getColumnModel().getColumn(6).setPreferredWidth(96);
		table.getColumnModel().getColumn(8).setPreferredWidth(125);
		table.getColumnModel().getColumn(9).setPreferredWidth(179);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, null, null));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 32, 920, 106);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_PorDara = new JPanel();
		panel_PorDara.setLayout(null);
		panel_PorDara.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Por Data",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_PorDara.setBackground(Color.LIGHT_GRAY);
		panel_PorDara.setBounds(283, 11, 229, 90);
		panel.add(panel_PorDara);

		JDateChooser jc_DataInicio = new JDateChooser();
		jc_DataInicio.setBounds(48, 22, 113, 22);
		panel_PorDara.add(jc_DataInicio);
		jc_DataInicio.setDateFormatString("dd/MM/yyyy");

		JDateChooser jc_DataFim = new JDateChooser();
		jc_DataFim.setBounds(48, 55, 113, 22);
		panel_PorDara.add(jc_DataFim);
		jc_DataFim.setDateFormatString("dd/MM/yyyy");

		JButton btn_Check = new JButton("");
		btn_Check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				
				String valor = (String) combob_Ocorrencia.getSelectedItem();
				String local = (String) combob_Blocos.getSelectedItem();
				String dataInicio = sdfBanco.format(jc_DataInicio.getDate());
				String dataFim = sdfBanco.format(jc_DataFim.getDate());
				while (dtm.getRowCount() != 0) {
					dtm.removeRow(0);
				}
				if(jc_DataInicio.getDate().getTime() > jc_DataFim.getDate().getTime()) {
					JOptionPane.showMessageDialog(null, "Período de data inválido!");
				}else {
					try {
						Connection conexao = new Conexao().fazer_conexao();
						ConexaoOcorrencia retornarOcorrencias = new ConexaoOcorrencia(conexao);
						for (Ocorrencia x : retornarOcorrencias.ocorrenciasPorData(valor, local, dataInicio, dataFim)) {
							Object[] lista = { x.getPlaca(), x.getMatricula(), x.getNome(), x.getMarca(), x.getTipo(),
									x.getOcorrencia(), sdf.format(x.getData()), x.getHora(), x.getLocal(),
									x.getIdOcorrencia() };
							dtm.addRow(lista);
						}
						tf_TOcorrencias.setText(Integer.toString(retornarOcorrencias.totalOcorrenciaPorData(valor, local, dataInicio, dataFim)));
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Erro ao conectar com obanco!\nErro: " +e1);
					}
				}
				
			}
		});
		btn_Check.setIcon(new ImageIcon(Menu.class.getResource("/imagens/check.png")));
		btn_Check.setBounds(174, 28, 35, 35);
		panel_PorDara.add(btn_Check);
		btn_Check.setBackground(Color.LIGHT_GRAY);

		JLabel lblInicio = new JLabel("Inicio:");
		lblInicio.setBounds(10, 24, 48, 14);
		panel_PorDara.add(lblInicio);

		JLabel lblFim = new JLabel("Fim:");
		lblFim.setBounds(10, 57, 48, 14);
		panel_PorDara.add(lblFim);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu passarTela = new Menu();
				passarTela.setUndecorated(true);
				passarTela.setLocationRelativeTo(null);
				passarTela.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(HistoricoEstacionamento.class.getResource("/imagens/back.png")));
		btnNewButton.setBounds(875, 34, 35, 35);
		panel.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Total de Ocorr\u00EAncias:");
		lblNewLabel_1.setBounds(522, 24, 124, 14);
		panel.add(lblNewLabel_1);

		tf_TOcorrencias = new JTextField();
		tf_TOcorrencias.setBounds(656, 21, 49, 20);
		panel.add(tf_TOcorrencias);
		tf_TOcorrencias.setColumns(10);

		JPanel panel_Geral = new JPanel();
		panel_Geral.setLayout(null);
		panel_Geral.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Geral",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Geral.setBackground(Color.LIGHT_GRAY);
		panel_Geral.setBounds(12, 11, 261, 90);
		panel.add(panel_Geral);

		JLabel lbl_Ocorrencia = new JLabel("Ocorr\u00EAncia:");
		lbl_Ocorrencia.setBounds(10, 27, 89, 14);
		panel_Geral.add(lbl_Ocorrencia);
		lbl_Ocorrencia.setForeground(Color.BLACK);
		

		combob_Blocos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				String valor = (String) combob_Ocorrencia.getSelectedItem();
				String local = (String) combob_Blocos.getSelectedItem();
				while (dtm.getRowCount() != 0) {
					dtm.removeRow(0);
				}
				jc_DataInicio.setDate(null);
				jc_DataFim.setDate(null);
				try {
					Connection conexao = new Conexao().fazer_conexao();
					ConexaoOcorrencia retornarOcorrencias = new ConexaoOcorrencia(conexao);

					for (Ocorrencia x : retornarOcorrencias.ocorrencias(valor, local)) {
						Object[] lista = { x.getPlaca(), x.getMatricula(), x.getNome(), x.getMarca(), x.getTipo(),
								x.getOcorrencia(), sdf.format(x.getData()), x.getHora(), x.getLocal(),
								x.getIdOcorrencia() };
						dtm.addRow(lista);
					}
					tf_TOcorrencias.setText(Integer.toString(retornarOcorrencias.totalOcorrencia(valor, local)));

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		combob_Ocorrencia.setBounds(83, 24, 168, 22);
		panel_Geral.add(combob_Ocorrencia);
		combob_Ocorrencia.setBackground(Color.WHITE);
		combob_Ocorrencia.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				String valor = (String) combob_Ocorrencia.getSelectedItem();
				String local = (String) combob_Blocos.getSelectedItem();
				while (dtm.getRowCount() != 0) {
					dtm.removeRow(0);
				}
				jc_DataInicio.setDate(null);
				jc_DataFim.setDate(null);
				try {
					Connection conexao = new Conexao().fazer_conexao();
					ConexaoOcorrencia retornarOcorrencias = new ConexaoOcorrencia(conexao);

					for (Ocorrencia x : retornarOcorrencias.ocorrencias(valor, local)) {
						Object[] lista = { x.getPlaca(), x.getMatricula(), x.getNome(), x.getMarca(), x.getTipo(),
								x.getOcorrencia(), sdf.format(x.getData()), x.getHora(), x.getLocal(),
								x.getIdOcorrencia() };
						dtm.addRow(lista);
					}
					tf_TOcorrencias.setText(Integer.toString(retornarOcorrencias.totalOcorrencia(valor, local)));

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		combob_Ocorrencia.setModel(new DefaultComboBoxModel(new String[] { "Selecionar...", "Todas", "Batidas",
				"Furto ou assalto", "Estacion. indevido", "Inuda\u00E7\u00E3o", "Dano ao ve\u00EDculo", "Outros" }));

		JLabel lbl_blocos = new JLabel("Blocos:");
		lbl_blocos.setBounds(10, 61, 61, 14);
		panel_Geral.add(lbl_blocos);
		lbl_blocos.setForeground(Color.BLACK);

		combob_Blocos.setBounds(83, 57, 168, 22);
		panel_Geral.add(combob_Blocos);
		combob_Blocos.setModel(new DefaultComboBoxModel(new String[] { "Selecionar...", "Bloco Central", "Bloco A",
				"Bloco B", "Bloco C", "Bloco D", "Bloco E", "Bloco F", "Bloco G" }));
		combob_Blocos.setBackground(Color.WHITE);

		// funções para muver a tela ao clicar
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 811, 471);
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
				MonitoramentoOcorrencia.this.setLocation(x - xx, y - xy);
			}
		});
	}
}
