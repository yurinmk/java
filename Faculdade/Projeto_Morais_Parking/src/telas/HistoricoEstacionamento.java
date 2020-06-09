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
import conexao.ConexaoVeiculo;
import modelo.UsuarioVeiculo;
import modelo.Vagas;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;


public class HistoricoEstacionamento extends JFrame {

	private JPanel contentPane;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat sdfBanco = new SimpleDateFormat("yyyy/MM/dd");
	private JTable table;

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
					HistoricoEstacionamento frame = new HistoricoEstacionamento();
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
	public HistoricoEstacionamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 946, 542);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(208, 50, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Total:");
		JTextPane tp_tvagas = new JTextPane();
		JLabel lblVagasEspeciis = new JLabel("Carros:");
		JTextPane tp_carros = new JTextPane();
		JLabel lblVagasMotos = new JLabel("Especiais:");
		JLabel lblNewLabel_1 = new JLabel("Motos:");
		JTextPane tp_motos = new JTextPane();
		JTextPane tp_especiais = new JTextPane();
				
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.LIGHT_GRAY);
				panel_1.setBounds(0, 0, 951, 21);
				contentPane.add(panel_1);
				panel_1.setLayout(null);
				
				JLabel lblNewLabel_2 = new JLabel("Hist\u00F3rico Estacionamento");
				lblNewLabel_2.setBounds(10, 4, 186, 14);
				panel_1.add(lblNewLabel_2);
				
				JPanel panel_Tablea = new JPanel();
				panel_Tablea.setBackground(Color.LIGHT_GRAY);
				panel_Tablea.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, null, null));
				panel_Tablea.setBounds(10, 149, 920, 383);
				contentPane.add(panel_Tablea);
				panel_Tablea.setLayout(null);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 22, 900, 352);
				panel_Tablea.add(scrollPane);
				
				table = new JTable();
				scrollPane.setViewportView(table);
				table.setBounds(0,165, 811, 277);
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Matricula", "Nome", "Placa", "Marca", "Tipo", "Data", "Hora", "Status", "Bloco"
					}
				));
				table.getColumnModel().getColumn(0).setPreferredWidth(64);
				table.getColumnModel().getColumn(1).setPreferredWidth(205);
				
				JPanel panel = new JPanel();
				panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, null, null));
				panel.setBackground(Color.LIGHT_GRAY);
				panel.setBounds(10, 32, 920, 106);
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
							
										if(combob_blocos.getSelectedItem().equals("Selecionar...")){
											
										}else {
											
											DefaultTableModel dtm = (DefaultTableModel) table.getModel();
											
											String status = "AUSENTE";
											
											UsuarioVeiculo bloco = new UsuarioVeiculo();
											bloco.setBloco((String) combob_blocos.getSelectedItem());
											Vagas vagas = new Vagas((String) combob_blocos.getSelectedItem());
											//zera a tabela quando muda de bloco
											while(dtm.getRowCount() != 0) {
												dtm.removeRow(0);
											}
											try {
												//faz a conexao
												Connection conexao = new Conexao().fazer_conexao();
												ConexaoVeiculo lista = new ConexaoVeiculo(conexao);
												//método para setar a quantidade de vagas em seus devidos campos
												lista.qntDeVagasPorBloco(vagas, status);
												tp_motos.setText(Integer.toString(vagas.getMoto()));
												tp_carros.setText(Integer.toString(vagas.getCarro()));
												tp_especiais.setText(Integer.toString(vagas.getEspecial()));
												tp_tvagas.setText(Integer.toString(vagas.totalVagasOcupadas()));
												//for para adicionar os elementos na tabela
												for(UsuarioVeiculo x:lista.historicoEstacionamento(bloco.getBloco())) {
													Object [] dado = {x.getMatricula(),x.getNome(),x.getPlaca(),x.getMarca(),
															x.getTipo(),sdf.format(x.getData()),x.getHora(),x.getStatus(),x.getBloco()};
													dtm.addRow(dado);
												}
											} catch (SQLException | ParseException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
											
										}
											
									}
								});
								combob_blocos.setModel(new DefaultComboBoxModel(new String[] {"Selecionar...", "Bloco Central", "Bloco A", "Bloco B", "Bloco C", "Bloco D", "Bloco E", "Bloco F", "Bloco G", "Todos"}));
								
								JPanel panel_Vagas = new JPanel();
								panel_Vagas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Vagas Ocupadas", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
								panel_Vagas.setBackground(Color.LIGHT_GRAY);
								panel_Vagas.setBounds(636, 11, 229, 90);
								panel.add(panel_Vagas);
								panel_Vagas.setLayout(null);
								
								
								
								lblNewLabel_4.setBounds(10, 30, 51, 14);
								panel_Vagas.add(lblNewLabel_4);
								lblNewLabel_4.setForeground(Color.BLACK);
								
								
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
								
								
								lblNewLabel_1.setBounds(112, 63, 60, 14);
								panel_Vagas.add(lblNewLabel_1);
								lblNewLabel_1.setForeground(Color.BLACK);
								
								tp_motos.setBounds(176, 57, 37, 22);
								panel_Vagas.add(tp_motos);
								tp_motos.setEditable(false);
								
								JPanel panel_PorDara = new JPanel();
								panel_PorDara.setLayout(null);
								panel_PorDara.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Por Data", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
								panel_PorDara.setBackground(Color.LIGHT_GRAY);
								panel_PorDara.setBounds(382, 11, 229, 90);
								panel.add(panel_PorDara);
								
								JDateChooser jc_DataInicio = new JDateChooser();
								jc_DataInicio.setBounds(48, 22, 113, 22);
								panel_PorDara.add(jc_DataInicio);
								jc_DataInicio.setDateFormatString("dd/MM/yyyy");
								
								JDateChooser jc_DataFIm = new JDateChooser();
								jc_DataFIm.setBounds(48, 55, 113, 22);
								panel_PorDara.add(jc_DataFIm);
								jc_DataFIm.setDateFormatString("dd/MM/yyyy");
								
								JButton btn_Check = new JButton("");
								btn_Check.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										
										DefaultTableModel dtm = (DefaultTableModel) table.getModel();
										
										if(jc_DataInicio.getDate() == null || jc_DataFIm.getDate() == null) {
											JOptionPane.showMessageDialog(null, "Algum dos campos está vazio!");
										}else if(jc_DataInicio.getDate().getTime() > jc_DataFIm.getDate().getTime()) {
											JOptionPane.showMessageDialog(null, "Período de data inválido!");
										}else {
											try {
												while(dtm.getRowCount() != 0) {
													dtm.removeRow(0);
												}
												Connection conexao = new Conexao().fazer_conexao();
												ConexaoVeiculo pesquisarPorData = new ConexaoVeiculo(conexao);
												for(UsuarioVeiculo x : pesquisarPorData.pesquisarPorData((String)combob_blocos.getSelectedItem(), sdfBanco.format(jc_DataInicio.getDate()), 
														sdfBanco.format(jc_DataFIm.getDate()))) {
													Object[] dados = {
															x.getMatricula(),x.getNome(),x.getPlaca(),x.getMarca(),
																x.getTipo(),sdf.format(x.getData()),x.getHora(),x.getStatus(),x.getBloco()
													};
													dtm.addRow(dados);
												}
											} catch (SQLException e1) {
												JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!\nErro:" + e1);
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
								btnNewButton.setBounds(875, 35, 35, 35);
								panel.add(btnNewButton);
								
				
				//funções para muver a tela ao clicar
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
						HistoricoEstacionamento.this.setLocation(x - xx, y - xy);
					}
				});
	}
}
