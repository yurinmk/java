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
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import conexao.Conexao;
import conexao.ConexaoOcorrencia;
import conexao.ConexaoVeiculo;
import modelo.Ocorrencia;
import modelo.UsuarioVeiculo;


public class CadastroOcorrencia extends JFrame {

	private JPanel contentPane;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat sdfBanco = new SimpleDateFormat("yyyy/MM/dd");
	Random aleatorio = new Random();
	double idOcorrencia = aleatorio.nextDouble() * 100;

	int xx;
	int xy;
	String local;
	private JTextField tf_Placa1;
	private JTextField tf_Matricula1;
	private JTextField tf_Nome1;
	private JTextField tf_MVeiculo1;
	private JTextField tf_TVeiculo1;
	private JTextField tf_Placa2;
	private JTextField tf_Matricula2;
	private JTextField tf_Nome2;
	private JTextField tf_MVeiculo2;
	private JTextField tf_TVeiculo2;
	private JTextField tf_Placa3;
	private JTextField tf_Matricula3;
	private JTextField tf_Nome3;
	private JTextField tf_MVeiculo3;
	private JTextField tf_TVeiculo3;
	private JTextField tf_QntOcorrencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroOcorrencia frame = new CadastroOcorrencia();
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
	public CadastroOcorrencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 946, 542);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(208, 50, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
				JPanel panel_Geral = new JPanel();
				panel_Geral.setBackground(Color.LIGHT_GRAY);
				panel_Geral.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, null, null));
				panel_Geral.setBounds(10, 35, 920, 492);
				contentPane.add(panel_Geral);
				panel_Geral.setLayout(null);
				
				JPanel panel = new JPanel();
				panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
				panel.setBackground(Color.LIGHT_GRAY);
				panel.setBounds(418, 11, 492, 44);
				panel_Geral.add(panel);
				panel.setLayout(null);
				
				JLabel lblNewLabel_1 = new JLabel("Ocorr\u00EAncia:");
				lblNewLabel_1.setBounds(17, 11, 82, 14);
				panel.add(lblNewLabel_1);
				
				JComboBox combob_Ocorrencia = new JComboBox();
				combob_Ocorrencia.setModel(new DefaultComboBoxModel(new String[] {"Selecionar...", "Batidas", "Furto ou assalto", "Estacionamento indevido", "Inuda\u00E7\u00E3o", "Dano ao ve\u00EDculo", "Outros"}));
				combob_Ocorrencia.setBackground(Color.LIGHT_GRAY);
				combob_Ocorrencia.setBounds(94, 7, 162, 22);
				panel.add(combob_Ocorrencia);
				
				JLabel lblNewLabel_1_1 = new JLabel("Local:");
				lblNewLabel_1_1.setBounds(266, 11, 48, 14);
				panel.add(lblNewLabel_1_1);
				
				JComboBox combob_Local = new JComboBox();
				combob_Local.setModel(new DefaultComboBoxModel(new String[] {"Selecionar...", "Bloco Central", "Bloco A", "Bloco B", "Bloco C", "Bloco D", "Bloco E", "Bloco F", "Bloco G"}));
				combob_Local.setBackground(Color.LIGHT_GRAY);
				combob_Local.setBounds(307, 7, 162, 22);
				panel.add(combob_Local);
				
				JPanel panel_Veiculo1 = new JPanel();
				panel_Veiculo1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
				panel_Veiculo1.setBackground(Color.LIGHT_GRAY);
				panel_Veiculo1.setBounds(10, 67, 277, 369);
				panel_Geral.add(panel_Veiculo1);
				panel_Veiculo1.setLayout(null);
				
				JLabel lbl_Placa1 = new JLabel("Placa:");
				lbl_Placa1.setBounds(10, 29, 48, 14);
				panel_Veiculo1.add(lbl_Placa1);
				
				tf_Placa1 = new JTextField();
				tf_Placa1.setBounds(10, 56, 96, 20);
				panel_Veiculo1.add(tf_Placa1);
				tf_Placa1.setColumns(10);
				
				JLabel lbl_Matricula1 = new JLabel("Matr\u00EDcula:");
				lbl_Matricula1.setBounds(10, 95, 78, 14);
				panel_Veiculo1.add(lbl_Matricula1);
				
				tf_Matricula1 = new JTextField();
				tf_Matricula1.setBounds(10, 120, 257, 20);
				panel_Veiculo1.add(tf_Matricula1);
				tf_Matricula1.setColumns(10);
				
				tf_Nome1 = new JTextField();
				tf_Nome1.setBounds(10, 173, 257, 20);
				panel_Veiculo1.add(tf_Nome1);
				tf_Nome1.setColumns(10);
				
				JLabel lbl_Nome1 = new JLabel("Nome:");
				lbl_Nome1.setBounds(10, 151, 48, 14);
				panel_Veiculo1.add(lbl_Nome1);
				
				tf_MVeiculo1 = new JTextField();
				tf_MVeiculo1.setBounds(10, 232, 257, 20);
				panel_Veiculo1.add(tf_MVeiculo1);
				tf_MVeiculo1.setColumns(10);
				
				JLabel lbl_MVeiculo1 = new JLabel("Marca do Ve\u00EDculo:");
				lbl_MVeiculo1.setBounds(10, 204, 102, 14);
				panel_Veiculo1.add(lbl_MVeiculo1);
				
				tf_TVeiculo1 = new JTextField();
				tf_TVeiculo1.setBounds(10, 294, 257, 20);
				panel_Veiculo1.add(tf_TVeiculo1);
				tf_TVeiculo1.setColumns(10);
				
				JLabel lbl_TVeiculo1 = new JLabel("Tipo do Ve\u00EDculo:");
				lbl_TVeiculo1.setBounds(10, 269, 92, 14);
				panel_Veiculo1.add(lbl_TVeiculo1);
				
				JButton btn_Lupa1 = new JButton("");
				btn_Lupa1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String placa = tf_Placa1.getText();
						try {
							Connection conexao = new Conexao().fazer_conexao();
							ConexaoVeiculo pesquisarVeiculo = new ConexaoVeiculo(conexao);
							UsuarioVeiculo veiculo = new UsuarioVeiculo(placa);
							pesquisarVeiculo.pesquisarVeiculo(veiculo);
							tf_Matricula1.setText(veiculo.getMatricula());
							tf_Nome1.setText(veiculo.getNome());
							tf_MVeiculo1.setText(veiculo.getMarca());
							tf_TVeiculo1.setText(veiculo.getTipo());
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!\nErro: " + e1);
						}
					}
				});
				btn_Lupa1.setIcon(new ImageIcon(CadastroOcorrencia.class.getResource("/imagens/magnifier.png")));
				btn_Lupa1.setBackground(Color.LIGHT_GRAY);
				btn_Lupa1.setBounds(108, 57, 16, 16);
				panel_Veiculo1.add(btn_Lupa1);
				
				JPanel panel_Veiculo2 = new JPanel();
				panel_Veiculo2.setLayout(null);
				panel_Veiculo2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
				panel_Veiculo2.setBackground(Color.LIGHT_GRAY);
				panel_Veiculo2.setBounds(321, 66, 277, 370);
				panel_Geral.add(panel_Veiculo2);
				
				JLabel lbl_Placa2 = new JLabel("Placa:");
				lbl_Placa2.setBounds(10, 29, 48, 14);
				panel_Veiculo2.add(lbl_Placa2);
				
				tf_Placa2 = new JTextField();
				tf_Placa2.setColumns(10);
				tf_Placa2.setBounds(10, 56, 96, 20);
				panel_Veiculo2.add(tf_Placa2);
				
				JLabel lbl_Matricula2 = new JLabel("Matr\u00EDcula:");
				lbl_Matricula2.setBounds(10, 95, 78, 14);
				panel_Veiculo2.add(lbl_Matricula2);
				
				tf_Matricula2 = new JTextField();
				tf_Matricula2.setColumns(10);
				tf_Matricula2.setBounds(10, 120, 257, 20);
				panel_Veiculo2.add(tf_Matricula2);
				
				tf_Nome2 = new JTextField();
				tf_Nome2.setColumns(10);
				tf_Nome2.setBounds(10, 173, 257, 20);
				panel_Veiculo2.add(tf_Nome2);
				
				JLabel lbl_Nome2 = new JLabel("Nome:");
				lbl_Nome2.setBounds(10, 151, 48, 14);
				panel_Veiculo2.add(lbl_Nome2);
				
				tf_MVeiculo2 = new JTextField();
				tf_MVeiculo2.setColumns(10);
				tf_MVeiculo2.setBounds(10, 232, 257, 20);
				panel_Veiculo2.add(tf_MVeiculo2);
				
				JLabel lbl_MVeiculo2 = new JLabel("Marca do Ve\u00EDculo:");
				lbl_MVeiculo2.setBounds(10, 204, 102, 14);
				panel_Veiculo2.add(lbl_MVeiculo2);
				
				tf_TVeiculo2 = new JTextField();
				tf_TVeiculo2.setColumns(10);
				tf_TVeiculo2.setBounds(10, 294, 257, 20);
				panel_Veiculo2.add(tf_TVeiculo2);
				
				JLabel lbl_TVeiculo2 = new JLabel("Tipo do Ve\u00EDculo:");
				lbl_TVeiculo2.setBounds(10, 269, 92, 14);
				panel_Veiculo2.add(lbl_TVeiculo2);
				
				JButton btn_Lupa2 = new JButton("");
				btn_Lupa2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String placa = tf_Placa2.getText();
						try {
							Connection conexao = new Conexao().fazer_conexao();
							ConexaoVeiculo pesquisarVeiculo = new ConexaoVeiculo(conexao);
							UsuarioVeiculo veiculo = new UsuarioVeiculo(placa);
							pesquisarVeiculo.pesquisarVeiculo(veiculo);
							tf_Matricula2.setText(veiculo.getMatricula());
							tf_Nome2.setText(veiculo.getNome());
							tf_MVeiculo2.setText(veiculo.getMarca());
							tf_TVeiculo2.setText(veiculo.getTipo());
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!\nErro: " + e1);
						}
						
					}
				});
				btn_Lupa2.setIcon(new ImageIcon(CadastroOcorrencia.class.getResource("/imagens/magnifier.png")));
				btn_Lupa2.setBackground(Color.LIGHT_GRAY);
				btn_Lupa2.setBounds(108, 57, 16, 16);
				panel_Veiculo2.add(btn_Lupa2);
				
				JPanel panel_Veiculo3 = new JPanel();
				panel_Veiculo3.setLayout(null);
				panel_Veiculo3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
				panel_Veiculo3.setBackground(Color.LIGHT_GRAY);
				panel_Veiculo3.setBounds(633, 67, 277, 369);
				panel_Geral.add(panel_Veiculo3);
				
				JLabel lbl_Placa3 = new JLabel("Placa:");
				lbl_Placa3.setBounds(10, 29, 48, 14);
				panel_Veiculo3.add(lbl_Placa3);
				
				tf_Placa3 = new JTextField();
				tf_Placa3.setColumns(10);
				tf_Placa3.setBounds(10, 56, 96, 20);
				panel_Veiculo3.add(tf_Placa3);
				
				JLabel lbl_Matricula3 = new JLabel("Matr\u00EDcula:");
				lbl_Matricula3.setBounds(10, 95, 78, 14);
				panel_Veiculo3.add(lbl_Matricula3);
				
				tf_Matricula3 = new JTextField();
				tf_Matricula3.setColumns(10);
				tf_Matricula3.setBounds(10, 120, 257, 20);
				panel_Veiculo3.add(tf_Matricula3);
				
				tf_Nome3 = new JTextField();
				tf_Nome3.setColumns(10);
				tf_Nome3.setBounds(10, 173, 257, 20);
				panel_Veiculo3.add(tf_Nome3);
				
				JLabel lbl_Nome3 = new JLabel("Nome:");
				lbl_Nome3.setBounds(10, 151, 48, 14);
				panel_Veiculo3.add(lbl_Nome3);
				
				tf_MVeiculo3 = new JTextField();
				tf_MVeiculo3.setColumns(10);
				tf_MVeiculo3.setBounds(10, 232, 257, 20);
				panel_Veiculo3.add(tf_MVeiculo3);
				
				JLabel lbl_MVeiculo3 = new JLabel("Marca do Ve\u00EDculo:");
				lbl_MVeiculo3.setBounds(10, 204, 102, 14);
				panel_Veiculo3.add(lbl_MVeiculo3);
				
				tf_TVeiculo3 = new JTextField();
				tf_TVeiculo3.setColumns(10);
				tf_TVeiculo3.setBounds(10, 294, 257, 20);
				panel_Veiculo3.add(tf_TVeiculo3);
				
				JLabel lbl_TVeiculo3 = new JLabel("Tipo do Ve\u00EDculo:");
				lbl_TVeiculo3.setBounds(10, 269, 92, 14);
				panel_Veiculo3.add(lbl_TVeiculo3);
				
				JButton btn_Lupa3 = new JButton("");
				btn_Lupa3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String placa = tf_Placa3.getText();
						try {
							Connection conexao = new Conexao().fazer_conexao();
							ConexaoVeiculo pesquisarVeiculo = new ConexaoVeiculo(conexao);
							UsuarioVeiculo veiculo = new UsuarioVeiculo(placa);
							pesquisarVeiculo.pesquisarVeiculo(veiculo);
							tf_Matricula3.setText(veiculo.getMatricula());
							tf_Nome3.setText(veiculo.getNome());
							tf_MVeiculo3.setText(veiculo.getMarca());
							tf_TVeiculo3.setText(veiculo.getTipo());
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!\nErro: " + e1);
						}
					}
				});
				btn_Lupa3.setIcon(new ImageIcon(CadastroOcorrencia.class.getResource("/imagens/magnifier.png")));
				btn_Lupa3.setBackground(Color.LIGHT_GRAY);
				btn_Lupa3.setBounds(108, 57, 16, 16);
				panel_Veiculo3.add(btn_Lupa3);
				
				JLabel lbl_QntOcorrencia = new JLabel("QNT Ocorr\u00EAncia:");
				lbl_QntOcorrencia.setBounds(10, 25, 102, 14);
				panel_Geral.add(lbl_QntOcorrencia);
				
				tf_QntOcorrencia = new JTextField();				
				tf_QntOcorrencia.setBounds(110, 22, 96, 20);
				panel_Geral.add(tf_QntOcorrencia);
				tf_QntOcorrencia.setColumns(10);
				
				
				if (tf_QntOcorrencia.getText().equals("")) {
					panel_Veiculo1.setVisible(false);
					panel_Veiculo2.setVisible(false);
					panel_Veiculo3.setVisible(false);
				}
				
				
				JButton btn_Check = new JButton("");
				btn_Check.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(combob_Ocorrencia.getSelectedItem().equals("Selecionar...") || combob_Local.getSelectedItem().equals("Selecionar...")) {
							JOptionPane.showMessageDialog(null, "Escolher uma ocorrência ou um local é obrigatório!");
						}else {
							String tipoOcorrencia = (String)combob_Ocorrencia.getSelectedItem();
							String local = (String)combob_Local.getSelectedItem();
							Object[] op = {"SIM","NÃO"};
							int rs = JOptionPane.showOptionDialog(null, "Deseja cadastrar mais ocorrências?","", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,op,op);
							if(rs == 0) {
								for(int i = 0; i < Integer.parseInt(tf_QntOcorrencia.getText()); i++) {
									if(i == 0) {
										String placa = tf_Placa1.getText();
										String matricula = tf_Matricula1.getText();
										String nome = tf_Nome1.getText();
										String marca = tf_MVeiculo1.getText();
										String tipo = tf_TVeiculo1.getText();
										try {
											Connection conexao = new Conexao().fazer_conexao();
											ConexaoOcorrencia cadastrarOcorrencia = new ConexaoOcorrencia(conexao);
											Ocorrencia ocorrencia = new Ocorrencia(placa, tipoOcorrencia, matricula, nome, marca, tipo,local, idOcorrencia);
											cadastrarOcorrencia.cadastrarOcorrencia(ocorrencia);
										} catch (SQLException e1) {
											JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!\nErro: " + e1);
										}
									}
									if(i == 1) {
										String placa = tf_Placa2.getText();
										String matricula = tf_Matricula2.getText();
										String nome = tf_Nome2.getText();
										String marca = tf_MVeiculo2.getText();
										String tipo = tf_TVeiculo2.getText();
										try {
											Connection conexao = new Conexao().fazer_conexao();
											ConexaoOcorrencia cadastrarOcorrencia = new ConexaoOcorrencia(conexao);
											Ocorrencia ocorrencia = new Ocorrencia(placa, tipoOcorrencia, matricula, nome, marca, tipo,local, idOcorrencia);
											cadastrarOcorrencia.cadastrarOcorrencia(ocorrencia);
										} catch (SQLException e1) {
											JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!\nErro: " + e1);
										}
									}
									if(i == 2) {
										String placa = tf_Placa3.getText();
										String matricula = tf_Matricula3.getText();
										String nome = tf_Nome3.getText();
										String marca = tf_MVeiculo3.getText();
										String tipo = tf_TVeiculo3.getText();
										try {
											Connection conexao = new Conexao().fazer_conexao();
											ConexaoOcorrencia cadastrarOcorrencia = new ConexaoOcorrencia(conexao);
											Ocorrencia ocorrencia = new Ocorrencia(placa, tipoOcorrencia, matricula, nome, marca, tipo,local, idOcorrencia);
											cadastrarOcorrencia.cadastrarOcorrencia(ocorrencia);
										} catch (SQLException e1) {
											JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!\nErro: " + e1);
										}
									}
								}
								panel_Veiculo1.setVisible(false);
								panel_Veiculo2.setVisible(false);
								panel_Veiculo3.setVisible(false);
								tf_QntOcorrencia.setText("");
								tf_Placa1.setText("");
								tf_Matricula1.setText("");
								tf_Nome1.setText("");
								tf_MVeiculo1.setText("");
								tf_TVeiculo1.setText("");
								tf_Placa2.setText("");
								tf_Matricula2.setText("");
								tf_Nome2.setText("");
								tf_MVeiculo2.setText("");
								tf_TVeiculo2.setText("");
								tf_Placa3.setText("");
								tf_Matricula3.setText("");
								tf_Nome3.setText("");
								tf_MVeiculo3.setText("");
								tf_TVeiculo3.setText("");
							}else if(rs == 1) {
								for(int i = 0; i < Integer.parseInt(tf_QntOcorrencia.getText()); i++) {
									if(i == 0) {
										String placa = tf_Placa1.getText();
										String matricula = tf_Matricula1.getText();
										String nome = tf_Nome1.getText();
										String marca = tf_MVeiculo1.getText();
										String tipo = tf_TVeiculo1.getText();
										try {
											Connection conexao = new Conexao().fazer_conexao();
											ConexaoOcorrencia cadastrarOcorrencia = new ConexaoOcorrencia(conexao);
											Ocorrencia ocorrencia = new Ocorrencia(placa, tipoOcorrencia, matricula, nome, marca, tipo,local, idOcorrencia);
											cadastrarOcorrencia.cadastrarOcorrencia(ocorrencia);
										} catch (SQLException e1) {
											JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!\nErro: " + e1);
										}
									}
									if(i == 1) {
										String placa = tf_Placa2.getText();
										String matricula = tf_Matricula2.getText();
										String nome = tf_Nome2.getText();
										String marca = tf_MVeiculo2.getText();
										String tipo = tf_TVeiculo2.getText();
										try {
											Connection conexao = new Conexao().fazer_conexao();
											ConexaoOcorrencia cadastrarOcorrencia = new ConexaoOcorrencia(conexao);
											Ocorrencia ocorrencia = new Ocorrencia(placa, tipoOcorrencia, matricula, nome, marca, tipo,local, idOcorrencia);
											cadastrarOcorrencia.cadastrarOcorrencia(ocorrencia);
										} catch (SQLException e1) {
											JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!\nErro: " + e1);
										}
									}
									if(i == 2) {
										String placa = tf_Placa3.getText();
										String matricula = tf_Matricula3.getText();
										String nome = tf_Nome3.getText();
										String marca = tf_MVeiculo3.getText();
										String tipo = tf_TVeiculo3.getText();
										try {
											Connection conexao = new Conexao().fazer_conexao();
											ConexaoOcorrencia cadastrarOcorrencia = new ConexaoOcorrencia(conexao);
											Ocorrencia ocorrencia = new Ocorrencia(placa, tipoOcorrencia, matricula, nome, marca, tipo,local, idOcorrencia);
											cadastrarOcorrencia.cadastrarOcorrencia(ocorrencia);
										} catch (SQLException e1) {
											JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!\nErro: " + e1);
										}
									}
								}
								JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
								idOcorrencia = aleatorio.nextDouble() * 100;
								panel_Veiculo1.setVisible(false);
								panel_Veiculo2.setVisible(false);
								panel_Veiculo3.setVisible(false);
								tf_QntOcorrencia.setText("");
								tf_Placa1.setText("");
								tf_Matricula1.setText("");
								tf_Nome1.setText("");
								tf_MVeiculo1.setText("");
								tf_TVeiculo1.setText("");
								tf_Placa2.setText("");
								tf_Matricula2.setText("");
								tf_Nome2.setText("");
								tf_MVeiculo2.setText("");
								tf_TVeiculo2.setText("");
								tf_Placa3.setText("");
								tf_Matricula3.setText("");
								tf_Nome3.setText("");
								tf_MVeiculo3.setText("");
								tf_TVeiculo3.setText("");
							}
						}
					}
						
				});
				
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
				btnNewButton.setBounds(875, 446, 35, 35);
				panel_Geral.add(btnNewButton);
				
				btn_Check.setIcon(new ImageIcon(Menu.class.getResource("/imagens/check.png")));
				btn_Check.setBounds(830, 446, 35, 35);
				panel_Geral.add(btn_Check);
				btn_Check.setBackground(Color.LIGHT_GRAY);
				
				JButton btnNewButton_1 = new JButton("");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(tf_QntOcorrencia.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Quantidade de ocorrência é obrigatório!");
						}else if(Integer.parseInt(tf_QntOcorrencia.getText()) == 1) {
							panel_Veiculo1.setVisible(true);
							panel_Veiculo2.setVisible(false);
							panel_Veiculo3.setVisible(false);
						}else if(Integer.parseInt(tf_QntOcorrencia.getText()) == 2) {
							panel_Veiculo1.setVisible(true);
							panel_Veiculo2.setVisible(true);
							panel_Veiculo3.setVisible(false);
						}else if(Integer.parseInt(tf_QntOcorrencia.getText()) == 3) {
							panel_Veiculo1.setVisible(true);
							panel_Veiculo2.setVisible(true);
							panel_Veiculo3.setVisible(true);
						}
						
						
					}
				});
				btnNewButton_1.setIcon(new ImageIcon(CadastroOcorrencia.class.getResource("/imagens/accept.png")));
				btnNewButton_1.setBackground(Color.LIGHT_GRAY);
				btnNewButton_1.setBounds(211, 22, 16, 16);
				panel_Geral.add(btnNewButton_1);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.LIGHT_GRAY);
				panel_1.setBounds(0, 0, 945, 28);
				contentPane.add(panel_1);
				panel_1.setLayout(null);
				
				JLabel lblCadatroDeOcorrncias = new JLabel("Cadatro de Ocorr\u00EAncias");
				lblCadatroDeOcorrncias.setBounds(10, 7, 271, 14);
				panel_1.add(lblCadatroDeOcorrncias);
								
				
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
						CadastroOcorrencia.this.setLocation(x - xx, y - xy);
					}
				});
	}
}
