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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import com.toedter.calendar.JDateChooser;

import conexao.Conexao;
import conexao.ConexaoEventos;
import modelo.Relatorio;
import net.sf.jasperreports.engine.JRException;

public class GerarRelatorios extends JFrame {

	private JPanel contentPane;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat sdfBanco = new SimpleDateFormat("yyyy-MM-dd");
	int xx;
	int xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerarRelatorios frame = new GerarRelatorios();
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
	public GerarRelatorios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setType(Type.POPUP);
		setResizable(false);
		setBackground(Color.LIGHT_GRAY);
		setBounds(100, 100, 642, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(208, 50, 47));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 742, 27);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_Sair = new JButton("");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		btn_Sair.setIcon(new ImageIcon(CadastroEvento.class.getResource("/imagens/fechar.png")));
		btn_Sair.setBounds(607, 3, 16, 16);
		panel.add(btn_Sair);
		
		JLabel lblRelatorios = new JLabel("Relat\u00F3rios");
		lblRelatorios.setBounds(12, 7, 120, 14);
		panel.add(lblRelatorios);
		
		JPanel panel_Estacionamento = new JPanel();
		JPanel panel_Estacionamento2 = new JPanel();
		JLabel lblLocal = new JLabel("Local:");
		JLabel lbl_DataFim = new JLabel("D. Fim:");
		JLabel lbl_DataInicio = new JLabel("D. Inicio:");
		JComboBox combob_Local_Es = new JComboBox();
		JDateChooser jc_Data_FimEs = new JDateChooser();
		JDateChooser jc_Data_InicioEs = new JDateChooser();
		JCheckBox chckbxAusentes = new JCheckBox("Ausentes");
		JCheckBox chckbxPresentes = new JCheckBox("Presentes");
		
		panel_Estacionamento.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_Estacionamento.setBackground(Color.LIGHT_GRAY);
		panel_Estacionamento.setBounds(10, 34, 304, 21);
		contentPane.add(panel_Estacionamento);
		panel_Estacionamento.setLayout(null);
		
		JLabel lblEstacionamento = new JLabel("Estacionamento");
		lblEstacionamento.setBounds(10, 3, 143, 14);
		panel_Estacionamento.add(lblEstacionamento);
		
		
		
		
		JPanel panel_Ocorrencias2 = new JPanel();
		JLabel lblOcorrncias = new JLabel("Ocorr\u00EAncias");
		JLabel lbl_DataInicio_Oc = new JLabel("D. Inicio:");
		JLabel lbl_DataFim_Oc = new JLabel("D. Fim:");
		JDateChooser jc_Data_Inicio_Oc = new JDateChooser();
		JDateChooser jc_Data_Fim_Oc = new JDateChooser();
		JComboBox comboBox_Local_Oc = new JComboBox();
		comboBox_Local_Oc.setModel(new DefaultComboBoxModel(new String[] {"Selecionar...", "Bloco Central", "Bloco A", "Bloco B", "Bloco C", "Bloco D", "Bloco E", "Bloco F", "Bloco G", "Todos"}));
		JLabel lblLocal_Oc = new JLabel("Local:");
		JLabel lblOcorrencia2 = new JLabel("Ocorr\u00EAncia:");
		JComboBox comboBox_Ocorrencia = new JComboBox();
		comboBox_Ocorrencia.setModel(new DefaultComboBoxModel(new String[] {"Selecionar...", "Todas", "Batidas", "Furto ou assalto", "Estacionamento indevido", "Inuda\u00E7\u00E3o", "Dano ao ve\u00EDculo", "Outros"}));
		
		JButton btn_VisualizarOc = new JButton("");
		btn_VisualizarOc.setIcon(new ImageIcon(GerarRelatorios.class.getResource("/imagens/check.png")));
		btn_VisualizarOc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio relatorio = new Relatorio();
				if (((String) comboBox_Local_Oc.getSelectedItem()).equals("Todos")
						&& ((String) comboBox_Ocorrencia.getSelectedItem()).equals("Todas")
						&& jc_Data_Inicio_Oc.getDate() == null && jc_Data_Fim_Oc.getDate() == null) {
					String query = "select * from ocorrencias";
					try {
						relatorio.gerarRelatórioOcorrencias(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (((String) comboBox_Local_Oc.getSelectedItem()).equals("Todos")
						&& ((String) comboBox_Ocorrencia.getSelectedItem()).equals("Todas")
						&& !jc_Data_Inicio_Oc.getDate().equals(null) && !jc_Data_Fim_Oc.getDate().equals(null)) {

					String dataInico = sdfBanco.format(jc_Data_Inicio_Oc.getDate());
					String dataFim = sdfBanco.format(jc_Data_Fim_Oc.getDate());
					String query = "select * from ocorrencias where data between " + "'" + dataInico + "'" + " and "
							+ "'" + dataFim + "'";
					try {
						relatorio.gerarRelatórioOcorrencias(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (!((String) comboBox_Local_Oc.getSelectedItem()).equals("Todos")
						&& ((String) comboBox_Ocorrencia.getSelectedItem()).equals("Todas")
						&& jc_Data_Inicio_Oc.getDate() == null && jc_Data_Fim_Oc.getDate() == null) {
					String local = (String) comboBox_Local_Oc.getSelectedItem();
					String query = "select * from ocorrencias where local = " + "'" + local + "'";
					try {
						relatorio.gerarRelatórioOcorrencias(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (!((String) comboBox_Local_Oc.getSelectedItem()).equals("Todos")
						&& ((String) comboBox_Ocorrencia.getSelectedItem()).equals("Todas")
						&& jc_Data_Inicio_Oc.getDate() != null && jc_Data_Fim_Oc.getDate() != null) {

					String dataInico = sdfBanco.format(jc_Data_Inicio_Oc.getDate());
					String dataFim = sdfBanco.format(jc_Data_Fim_Oc.getDate());
					String local = (String) comboBox_Local_Oc.getSelectedItem();
					String query = "select * from ocorrencias where local = " + "'" + local + "' and data between "
							+ "'" + dataInico + "'" + " and " + "'" + dataFim + "'";
					try {
						relatorio.gerarRelatórioOcorrencias(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (!((String) comboBox_Local_Oc.getSelectedItem()).equals("Todos")
						&& !((String) comboBox_Ocorrencia.getSelectedItem()).equals("Selecionar...")
						&& jc_Data_Inicio_Oc.getDate() == null && jc_Data_Fim_Oc.getDate() == null) {
					String local = (String) comboBox_Local_Oc.getSelectedItem();
					String ocorrencia = (String) comboBox_Ocorrencia.getSelectedItem();
					String query = "select * from ocorrencias where local = " + "'" + local + "' and ocorrencia = "
							+ "'" + ocorrencia + "'";
					try {
						relatorio.gerarRelatórioOcorrencias(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (!((String) comboBox_Local_Oc.getSelectedItem()).equals("Todos")
						&& !((String) comboBox_Ocorrencia.getSelectedItem()).equals("Selecionar...")
						&& jc_Data_Inicio_Oc.getDate() != null && jc_Data_Fim_Oc.getDate() != null) {
					String dataInico = sdfBanco.format(jc_Data_Inicio_Oc.getDate());
					String dataFim = sdfBanco.format(jc_Data_Fim_Oc.getDate());
					String local = (String) comboBox_Local_Oc.getSelectedItem();
					String ocorrencia = (String) comboBox_Ocorrencia.getSelectedItem();
					String query = "select * from ocorrencias where local = " + "'" + local + "' and ocorrencia = "
							+ "'" + ocorrencia + "' and data between " + "'" + dataInico + "'" + " and " + "'" + dataFim
							+ "'";
					try {
						relatorio.gerarRelatórioOcorrencias(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (((String) comboBox_Local_Oc.getSelectedItem()).equals("Todos")
						&& !((String) comboBox_Ocorrencia.getSelectedItem()).equals("Selecionar...")
						&& jc_Data_Inicio_Oc.getDate() == null && jc_Data_Fim_Oc.getDate() == null) {

					String ocorrencia = (String) comboBox_Ocorrencia.getSelectedItem();
					String query = "select * from ocorrencias where ocorrencia = '" + ocorrencia + "'";
					try {
						relatorio.gerarRelatórioOcorrencias(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (((String) comboBox_Local_Oc.getSelectedItem()).equals("Todos")
						&& !((String) comboBox_Ocorrencia.getSelectedItem()).equals("Selecionar...")
						&& jc_Data_Inicio_Oc.getDate() != null && jc_Data_Fim_Oc.getDate() != null) {

					String dataInico = sdfBanco.format(jc_Data_Inicio_Oc.getDate());
					String dataFim = sdfBanco.format(jc_Data_Fim_Oc.getDate());
					String ocorrencia = (String) comboBox_Ocorrencia.getSelectedItem();
					String query = "select * from ocorrencias where ocorrencia = '" + ocorrencia + "'"
							+ " and data between " + "'" + dataInico + "'" + " and " + "'" + dataFim + "'";
					try {
						relatorio.gerarRelatórioOcorrencias(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		JButton btn_VisualizarEs = new JButton("");
		btn_VisualizarEs.setIcon(new ImageIcon(GerarRelatorios.class.getResource("/imagens/check.png")));
		
		btn_VisualizarEs.addActionListener(new ActionListener() {
			Relatorio relatorio = new Relatorio();
			public void actionPerformed(ActionEvent e) {
				
				if (((String) combob_Local_Es.getSelectedItem()).equals("Todos") && chckbxPresentes.isSelected()
						&& jc_Data_InicioEs.getDate() == null && jc_Data_FimEs.getDate() == null
						&& !chckbxAusentes.isSelected()) {

					String query = "select * from veiculos where status = 'presente'";
					try {
						relatorio.gerarRelatórioVeiculos(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (((String) combob_Local_Es.getSelectedItem()).equals("Todos") && !chckbxPresentes.isSelected()
						&& jc_Data_InicioEs.getDate() == null && jc_Data_FimEs.getDate() == null
						&& chckbxAusentes.isSelected()) {
					System.out.println("dfdfsdfsdf");
					String query = "select * from veiculos where status = 'ausente'";
					try {
						relatorio.gerarRelatórioVeiculos(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (((String) combob_Local_Es.getSelectedItem()).equals("Todos")
						&& jc_Data_InicioEs.getDate() == null && jc_Data_FimEs.getDate() == null
						&& !chckbxPresentes.isSelected() && !chckbxAusentes.isSelected()) {

					String query = "select * from veiculos";
					try {
						relatorio.gerarRelatórioVeiculos(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (((String) combob_Local_Es.getSelectedItem()).equals("Todos")
						&& !jc_Data_InicioEs.getDate().equals(null) && !jc_Data_FimEs.getDate().equals(null)
						&& !chckbxAusentes.isSelected()) {
					String dataInicio = sdfBanco.format(jc_Data_InicioEs.getDate());
					String dataFim = sdfBanco.format(jc_Data_FimEs.getDate());
					String query = "select * from veiculos where data between " + "'" + dataInicio + "'" + "and" + "'"
							+ dataFim + "'";
					try {
						relatorio.gerarRelatórioVeiculos(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (((String) combob_Local_Es.getSelectedItem()).equals("Todos")
						&& !jc_Data_InicioEs.getDate().equals(null) && !jc_Data_FimEs.getDate().equals(null)
						&& chckbxAusentes.isSelected()) {
					String dataInicio = sdfBanco.format(jc_Data_InicioEs.getDate());
					String dataFim = sdfBanco.format(jc_Data_FimEs.getDate());
					String query = "select * from veiculos where status = 'ausente' and data between " + "'"
							+ dataInicio + "'" + "and" + "'" + dataFim + "'";
					try {
						relatorio.gerarRelatórioVeiculos(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (!((String) combob_Local_Es.getSelectedItem()).equals("Todos")
						&& jc_Data_InicioEs.getDate() == null && jc_Data_FimEs.getDate() == null
						&& !chckbxAusentes.isSelected() && !chckbxPresentes.isSelected()) {
					String bloco = (String) combob_Local_Es.getSelectedItem();
					String query = "select * from veiculos where bloco = " + "'" + bloco + "'";
					try {
						relatorio.gerarRelatórioVeiculos(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (!((String) combob_Local_Es.getSelectedItem()).equals("Todos")
						&& jc_Data_InicioEs.getDate() != null && jc_Data_FimEs.getDate() != null
						&& !chckbxAusentes.isSelected() && !chckbxPresentes.isSelected()) {
					String bloco = (String) combob_Local_Es.getSelectedItem();
					String dataInicio = sdfBanco.format(jc_Data_InicioEs.getDate());
					String dataFim = sdfBanco.format(jc_Data_FimEs.getDate());
					String query = "select * from veiculos where bloco = " + "'" + bloco + "'" + " and data between "
							+ "'" + dataInicio + "'" + "and" + "'" + dataFim + "'";
					try {
						relatorio.gerarRelatórioVeiculos(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (!((String) combob_Local_Es.getSelectedItem()).equals("Todos")
						&& jc_Data_InicioEs.getDate() != null && jc_Data_FimEs.getDate() != null
						&& chckbxAusentes.isSelected() && !chckbxPresentes.isSelected()) {
					String bloco = (String) combob_Local_Es.getSelectedItem();
					String dataInicio = sdfBanco.format(jc_Data_InicioEs.getDate());
					String dataFim = sdfBanco.format(jc_Data_FimEs.getDate());
					String query = "select * from veiculos where status = 'ausente' and bloco = " + "'" + bloco + "'"
							+ " and data between " + "'" + dataInicio + "'" + "and" + "'" + dataFim + "'";
					try {
						relatorio.gerarRelatórioVeiculos(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (!((String) combob_Local_Es.getSelectedItem()).equals("Todos")
						&& jc_Data_InicioEs.getDate() != null && jc_Data_FimEs.getDate() != null
						&& !chckbxAusentes.isSelected() && chckbxPresentes.isSelected()) {
					String bloco = (String) combob_Local_Es.getSelectedItem();
					String dataInicio = sdfBanco.format(jc_Data_InicioEs.getDate());
					String dataFim = sdfBanco.format(jc_Data_FimEs.getDate());
					String query = "select * from veiculos where status = 'presente' and bloco = " + "'" + bloco + "'"
							+ " and data between " + "'" + dataInicio + "'" + "and" + "'" + dataFim + "'";
					try {
						relatorio.gerarRelatórioVeiculos(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (!((String) combob_Local_Es.getSelectedItem()).equals("Todos")
						&& jc_Data_InicioEs.getDate() == null && jc_Data_FimEs.getDate() == null
						&& !chckbxAusentes.isSelected() && chckbxPresentes.isSelected()) {
					String bloco = (String) combob_Local_Es.getSelectedItem();
					String query = "select * from veiculos where status = 'presente' and bloco = " + "'" + bloco + "'";
					try {
						relatorio.gerarRelatórioVeiculos(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (!((String) combob_Local_Es.getSelectedItem()).equals("Todos")
						&& jc_Data_InicioEs.getDate() == null && jc_Data_FimEs.getDate() == null
						&& chckbxAusentes.isSelected() && !chckbxPresentes.isSelected()) {
					String bloco = (String) combob_Local_Es.getSelectedItem();
					String query = "select * from veiculos where status = 'ausente' and bloco = " + "'" + bloco + "'";
					try {
						relatorio.gerarRelatórioVeiculos(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}			
				
			}
			
		});
		
		
		JLabel lblLocal_Ev = new JLabel("Status:");
		JLabel lbl_DataInicio_Ev = new JLabel("D. Inicio:");
		JLabel lbl_DataFim_Ev = new JLabel("D. Fim:");
		JComboBox combob_Eventos = new JComboBox();
		JDateChooser jc_Data_Fim_Ev = new JDateChooser();
		JDateChooser jc_Data_Inicio_Ev = new JDateChooser();
		
		JButton btn_VisualizarEv = new JButton("");
		btn_VisualizarEv.setIcon(new ImageIcon(GerarRelatorios.class.getResource("/imagens/check.png")));
		btn_VisualizarEv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				 	Connection conexao = new Conexao().fazer_conexao();
					ConexaoEventos mudarStatusDoEvento = new ConexaoEventos(conexao);
					mudarStatusDoEvento.mudarStatusEvento();
				} catch (SQLException | ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				Relatorio relatorios = new Relatorio();
				if (((String) combob_Eventos.getSelectedItem()).equals("Todos") && jc_Data_Inicio_Ev.getDate() == null
						&& jc_Data_Fim_Ev.getDate() == null) {

					String query = "select * from eventos";
					try {
						relatorios.gerarRelatórioEventos(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (((String) combob_Eventos.getSelectedItem()).equals("Em andamento")
						&& jc_Data_Inicio_Ev.getDate() == null && jc_Data_Fim_Ev.getDate() == null) {

					String query = "select * from eventos where status = 'em_andamento'";
					try {
						relatorios.gerarRelatórioEventos(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (((String) combob_Eventos.getSelectedItem()).equals("Finalizados")
						&& jc_Data_Inicio_Ev.getDate() == null && jc_Data_Fim_Ev.getDate() == null) {

					String query = "select * from eventos where status = 'finalizado'";
					try {
						relatorios.gerarRelatórioEventos(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (((String) combob_Eventos.getSelectedItem()).equals("Futuros")
						&& jc_Data_Inicio_Ev.getDate() == null && jc_Data_Fim_Ev.getDate() == null) {

					String query = "select * from eventos where status = 'futuro'";
					try {
						relatorios.gerarRelatórioEventos(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (((String) combob_Eventos.getSelectedItem()).equals("Todos")
						&& jc_Data_Inicio_Ev.getDate() != null && jc_Data_Fim_Ev.getDate() != null) {
					String dataInicio = sdfBanco.format(jc_Data_Inicio_Ev.getDate());
					String dataFim = sdfBanco.format(jc_Data_Fim_Ev.getDate());
					String query = "select * from eventos where data_inicio and data_fim between " + "'" + dataInicio + "'" + " and " + "'"
							+ dataFim + "'";
					try {
						relatorios.gerarRelatórioEventos(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (!((String) combob_Eventos.getSelectedItem()).equals("Selecionar...")
						&& jc_Data_Inicio_Ev.getDate() != null && jc_Data_Fim_Ev.getDate() != null) {
					String dataInicio = sdfBanco.format(jc_Data_Inicio_Ev.getDate());
					String dataFim = sdfBanco.format(jc_Data_Fim_Ev.getDate());
					String status = (String) combob_Eventos.getSelectedItem();
					String query = "select * from eventos where status = " + "'" + status + "'" + " and data_inicio and data_fim between "
							+ "'" + dataInicio + "'" + " and " + "'" + dataFim + "'";
					try {
						relatorios.gerarRelatórioEventos(query);
					} catch (JRException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if (((String) combob_Eventos.getSelectedItem()).equals("Selecionar...")
						|| jc_Data_Inicio_Ev.getDate().getTime() > jc_Data_Fim_Ev.getDate().getTime()) {
					JOptionPane.showMessageDialog(null, "Erro! Revise os elementos preenchidos!");
				}
				
				
			}
		});
		
		
		JCheckBox checkb_Ocorrencias = new JCheckBox("");
		checkb_Ocorrencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (checkb_Ocorrencias.isSelected()) {
					lblLocal_Oc.setEnabled(true);
					lbl_DataFim_Oc.setEnabled(true);
					lbl_DataInicio_Oc.setEnabled(true);
					lblOcorrencia2.setEnabled(true);
					comboBox_Ocorrencia.setEnabled(true);
					comboBox_Local_Oc.setEnabled(true);
					jc_Data_Inicio_Oc.setEnabled(true);
					jc_Data_Fim_Oc.setEnabled(true);
					btn_VisualizarOc.setEnabled(true);

				} else {
					lblLocal_Oc.setEnabled(false);
					lbl_DataFim_Oc.setEnabled(false);
					lbl_DataInicio_Oc.setEnabled(false);
					lblOcorrencia2.setEnabled(false);
					comboBox_Ocorrencia.setEnabled(false);
					comboBox_Local_Oc.setEnabled(false);
					jc_Data_Inicio_Oc.setEnabled(false);
					jc_Data_Fim_Oc.setEnabled(false);
					btn_VisualizarOc.setEnabled(false);
				}
				
				
			}
		});
		
		
		if(!checkb_Ocorrencias.isSelected()) {
			lblLocal_Oc.setEnabled(false);
			lbl_DataFim_Oc.setEnabled(false);
			lbl_DataInicio_Oc.setEnabled(false);
			lblOcorrencia2.setEnabled(false);
			comboBox_Ocorrencia.setEnabled(false);
			comboBox_Local_Oc.setEnabled(false);
			jc_Data_Inicio_Oc.setEnabled(false);
			jc_Data_Fim_Oc.setEnabled(false);
			btn_VisualizarOc.setEnabled(false);
		}
		
		
		JCheckBox checkb_Estacionamento = new JCheckBox("");
		if(!checkb_Estacionamento.isSelected()) {
			lblLocal.setEnabled(false);
			lbl_DataFim.setEnabled(false);
			lbl_DataInicio.setEnabled(false);
			combob_Local_Es.setEnabled(false);
			chckbxPresentes.setEnabled(false);
			chckbxAusentes.setEnabled(false);
			jc_Data_InicioEs.setEnabled(false);
			jc_Data_FimEs.setEnabled(false);
			btn_VisualizarEs.setEnabled(false);
		}
		
		checkb_Estacionamento.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
								
				if (checkb_Estacionamento.isSelected()) {
					lblLocal.setEnabled(true);
					lbl_DataFim.setEnabled(true);
					lbl_DataInicio.setEnabled(true);
					combob_Local_Es.setEnabled(true);
					chckbxPresentes.setEnabled(true);
					chckbxAusentes.setEnabled(true);
					jc_Data_InicioEs.setEnabled(true);
					jc_Data_FimEs.setEnabled(true);
					btn_VisualizarEs.setEnabled(true);

				} else {
					lblLocal.setEnabled(false);
					lbl_DataFim.setEnabled(false);
					lbl_DataInicio.setEnabled(false);
					combob_Local_Es.setEnabled(false);
					chckbxPresentes.setEnabled(false);
					chckbxAusentes.setEnabled(false);
					jc_Data_InicioEs.setEnabled(false);
					jc_Data_FimEs.setEnabled(false);
					btn_VisualizarEs.setEnabled(false);
				}
	
			}
		});
		checkb_Estacionamento.setBackground(Color.LIGHT_GRAY);
		checkb_Estacionamento.setBounds(277, 2, 21, 18);
		panel_Estacionamento.add(checkb_Estacionamento);
		
		
		panel_Estacionamento2.setBackground(Color.LIGHT_GRAY);
		panel_Estacionamento2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_Estacionamento2.setBounds(10, 61, 304, 130);
		contentPane.add(panel_Estacionamento2);
		panel_Estacionamento2.setLayout(null);
		
		jc_Data_InicioEs.setBounds(78, 45, 150, 20);
		panel_Estacionamento2.add(jc_Data_InicioEs);
		jc_Data_InicioEs.setDateFormatString("dd/MM/yyyy");
		
		
		jc_Data_FimEs.setBounds(78, 76, 150, 20);
		panel_Estacionamento2.add(jc_Data_FimEs);
		jc_Data_FimEs.setDateFormatString("dd/MM/yyyy");
		
		lbl_DataInicio.setBounds(10, 48, 58, 14);
		panel_Estacionamento2.add(lbl_DataInicio);
		
		
		lbl_DataFim.setBounds(10, 79, 48, 14);
		panel_Estacionamento2.add(lbl_DataFim);
		
		
		combob_Local_Es.setModel(new DefaultComboBoxModel(new String[] {"Selecionar...", "Bloco Central", "Bloco A", "Bloco B", "Bloco C", "Bloco D", "Bloco E", "Bloco F", "Bloco G", "Todos"}));
		combob_Local_Es.setBounds(78, 11, 150, 23);
		panel_Estacionamento2.add(combob_Local_Es);
		
		
		lblLocal.setBounds(10, 15, 48, 14);
		panel_Estacionamento2.add(lblLocal);
		
		chckbxPresentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxAusentes.setSelected(false);
			}
		});
		chckbxPresentes.setBackground(Color.LIGHT_GRAY);
		chckbxPresentes.setBounds(49, 103, 97, 23);
		panel_Estacionamento2.add(chckbxPresentes);
		
		
		chckbxAusentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxPresentes.setSelected(false);
			}
		});
		chckbxAusentes.setBackground(Color.LIGHT_GRAY);
		chckbxAusentes.setBounds(156, 103, 97, 23);
		panel_Estacionamento2.add(chckbxAusentes);
		
		
		btn_VisualizarEs.setBackground(Color.LIGHT_GRAY);
		btn_VisualizarEs.setBounds(246, 49, 32, 32);
		btn_VisualizarEs.setBorder(null);
		panel_Estacionamento2.add(btn_VisualizarEs);
		
		JPanel panel_Eventos = new JPanel();
		panel_Eventos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_Eventos.setBackground(Color.LIGHT_GRAY);
		panel_Eventos.setBounds(324, 34, 304, 21);
		contentPane.add(panel_Eventos);
		panel_Eventos.setLayout(null);
		
		JLabel lblEventos = new JLabel("Eventos");
		lblEventos.setBounds(10, 3, 48, 14);
		panel_Eventos.add(lblEventos);
		
		
		
		combob_Eventos.setModel(new DefaultComboBoxModel(new String[] {"Selecionar...", "Todos", "Em_andamento", "Finalizados", "Futuros"}));
		
		
		if(!checkb_Estacionamento.isSelected()) {
			lblLocal_Ev.setEnabled(false);
			lbl_DataFim_Ev.setEnabled(false);
			lbl_DataInicio_Ev.setEnabled(false);
			combob_Eventos.setEnabled(false);
			jc_Data_Inicio_Ev.setEnabled(false);
			jc_Data_Fim_Ev.setEnabled(false);
			btn_VisualizarEv.setEnabled(false);
		}
		JCheckBox checkb_Eventos = new JCheckBox("");
		checkb_Eventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (checkb_Eventos.isSelected()) {
					lblLocal_Ev.setEnabled(true);
					lbl_DataFim_Ev.setEnabled(true);
					lbl_DataInicio_Ev.setEnabled(true);
					combob_Eventos.setEnabled(true);
					jc_Data_Inicio_Ev.setEnabled(true);
					jc_Data_Fim_Ev.setEnabled(true);
					btn_VisualizarEv.setEnabled(true);

				} else {
					lblLocal_Ev.setEnabled(false);
					lbl_DataFim_Ev.setEnabled(false);
					lbl_DataInicio_Ev.setEnabled(false);
					combob_Eventos.setEnabled(false);
					jc_Data_Inicio_Ev.setEnabled(false);
					jc_Data_Fim_Ev.setEnabled(false);
					btn_VisualizarEv.setEnabled(false);
				}
			}
		});
		checkb_Eventos.setBackground(Color.LIGHT_GRAY);
		checkb_Eventos.setBounds(277, 2, 21, 18);
		panel_Eventos.add(checkb_Eventos);
		
		JPanel panel_Eventos2 = new JPanel();
		panel_Eventos2.setLayout(null);
		panel_Eventos2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_Eventos2.setBackground(Color.LIGHT_GRAY);
		panel_Eventos2.setBounds(324, 61, 304, 130);
		contentPane.add(panel_Eventos2);
		
		jc_Data_Inicio_Ev.setDateFormatString("dd/MM/yyyy");
		jc_Data_Inicio_Ev.setBounds(78, 45, 150, 20);
		panel_Eventos2.add(jc_Data_Inicio_Ev);
		
		jc_Data_Fim_Ev.setDateFormatString("dd/MM/yyyy");
		jc_Data_Fim_Ev.setBounds(78, 76, 150, 20);
		panel_Eventos2.add(jc_Data_Fim_Ev);
		
		
		lbl_DataInicio_Ev.setBounds(10, 48, 58, 14);
		panel_Eventos2.add(lbl_DataInicio_Ev);
		
		
		lbl_DataFim_Ev.setBounds(10, 79, 48, 14);
		panel_Eventos2.add(lbl_DataFim_Ev);
		
		combob_Eventos.setBounds(78, 11, 150, 23);
		panel_Eventos2.add(combob_Eventos);
		
		
		lblLocal_Ev.setBounds(10, 15, 48, 14);
		panel_Eventos2.add(lblLocal_Ev);
		
		
		btn_VisualizarEv.setBackground(Color.LIGHT_GRAY);
		btn_VisualizarEv.setBounds(246, 49, 32, 32);
		btn_VisualizarEv.setBorder(null);
		panel_Eventos2.add(btn_VisualizarEv);
		
		JPanel panel_Ocorrencias = new JPanel();
		panel_Ocorrencias.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_Ocorrencias.setBackground(Color.LIGHT_GRAY);
		panel_Ocorrencias.setBounds(62, 196, 532, 21);
		contentPane.add(panel_Ocorrencias);
		panel_Ocorrencias.setLayout(null);
		
		
		
		lblOcorrncias.setBounds(10, 3, 97, 14);
		panel_Ocorrencias.add(lblOcorrncias);
		
		
		checkb_Ocorrencias.setBackground(Color.LIGHT_GRAY);
		checkb_Ocorrencias.setBounds(505, 2, 21, 18);
		panel_Ocorrencias.add(checkb_Ocorrencias);
		
		
		panel_Ocorrencias2.setLayout(null);
		panel_Ocorrencias2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_Ocorrencias2.setBackground(Color.LIGHT_GRAY);
		panel_Ocorrencias2.setBounds(62, 222, 532, 130);
		contentPane.add(panel_Ocorrencias2);
		
		jc_Data_Inicio_Oc.setDateFormatString("dd/MM/yyyy");
		jc_Data_Inicio_Oc.setBounds(78, 45, 150, 20);
		panel_Ocorrencias2.add(jc_Data_Inicio_Oc);
		
		jc_Data_Fim_Oc.setDateFormatString("dd/MM/yyyy");
		jc_Data_Fim_Oc.setBounds(78, 76, 150, 20);
		panel_Ocorrencias2.add(jc_Data_Fim_Oc);
		
		
		lbl_DataInicio_Oc.setBounds(10, 48, 58, 14);
		panel_Ocorrencias2.add(lbl_DataInicio_Oc);
		
		
		lbl_DataFim_Oc.setBounds(10, 79, 48, 14);
		panel_Ocorrencias2.add(lbl_DataFim_Oc);
		
		
		comboBox_Local_Oc.setBounds(78, 11, 150, 23);
		panel_Ocorrencias2.add(comboBox_Local_Oc);
		
		
		lblLocal_Oc.setBounds(10, 15, 48, 14);
		panel_Ocorrencias2.add(lblLocal_Oc);
		
		
		lblOcorrencia2.setBounds(238, 15, 76, 14);
		panel_Ocorrencias2.add(lblOcorrencia2);
		
		
		comboBox_Ocorrencia.setBounds(324, 11, 180, 23);
		panel_Ocorrencias2.add(comboBox_Ocorrencia);
		
		
		btn_VisualizarOc.setBackground(Color.LIGHT_GRAY);
		btn_VisualizarOc.setBounds(453, 56, 32, 32);
		btn_VisualizarOc.setBorder(null);
		panel_Ocorrencias2.add(btn_VisualizarOc);
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
				GerarRelatorios.this.setLocation(x - xx, y - xy);
				
			}
		});
		lbl_Mover_Tela.setBounds(0, 0, 650, 415);
		contentPane.add(lbl_Mover_Tela);
		

	}
}
