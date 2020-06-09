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
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import conexao.Conexao;
import conexao.ConexaoEventos;
import conexao.ConexaoVeiculo;
import modelo.Eventos;
import modelo.Vagas;

import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class CadastroEvento extends JFrame {

	private JPanel contentPane;
	private JTextField tf_Evento;
	private JTextField tf_Vagas;
	private JTextField tf_VagasExtras;
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
					CadastroEvento frame = new CadastroEvento();
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
	public CadastroEvento() {
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
		btn_Sair.setToolTipText("sair");
		btn_Sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		btn_Sair.setIcon(new ImageIcon(CadastroEvento.class.getResource("/imagens/fechar.png")));
		btn_Sair.setBounds(580, 5, 16, 16);
		panel.add(btn_Sair);
		
		JLabel lblCadastroDeEventos = new JLabel("Cadastro de Eventos");
		lblCadastroDeEventos.setBounds(12, 5, 120, 14);
		panel.add(lblCadastroDeEventos);
		
		JPanel panel_Salvar = new JPanel();
		panel_Salvar.setBackground(Color.LIGHT_GRAY);
		panel_Salvar.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.GRAY, null, null));
		panel_Salvar.setBounds(10, 40, 589, 130);
		contentPane.add(panel_Salvar);
		panel_Salvar.setLayout(null);
		
		JLabel lbl_Envento = new JLabel("Evento:");
		lbl_Envento.setBounds(10, 11, 48, 14);
		panel_Salvar.add(lbl_Envento);
		
		tf_Evento = new JTextField();
		tf_Evento.setBounds(57, 8, 262, 20);
		panel_Salvar.add(tf_Evento);
		tf_Evento.setColumns(10);
		
		JLabel lbl_Vagas = new JLabel("Vagas Necess\u00E1rias:");
		lbl_Vagas.setBounds(10, 42, 116, 14);
		panel_Salvar.add(lbl_Vagas);
		
		tf_Vagas = new JTextField();
		tf_Vagas.setBounds(136, 39, 183, 20);
		panel_Salvar.add(tf_Vagas);
		tf_Vagas.setColumns(10);
		//Deixar o campo(textfild) de vagas extras visivel
		JCheckBox clickbx_VagasExtras = new JCheckBox("Vagas Extras");
		clickbx_VagasExtras.setBackground(Color.LIGHT_GRAY);
		clickbx_VagasExtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(clickbx_VagasExtras.isSelected()) {
					tf_VagasExtras.setEditable(true);
				}else {
					tf_VagasExtras.setEditable(false);
				}
			}
		});
		clickbx_VagasExtras.setBounds(10, 69, 108, 23);
		panel_Salvar.add(clickbx_VagasExtras);
		
		tf_VagasExtras = new JTextField();
		tf_VagasExtras.setEditable(false);
		tf_VagasExtras.setBounds(136, 70, 183, 20);
		panel_Salvar.add(tf_VagasExtras);
		tf_VagasExtras.setColumns(10);
		
		JDateChooser jc_Data_Inicio = new JDateChooser();
		jc_Data_Inicio.setBounds(419, 8, 150, 20);
		panel_Salvar.add(jc_Data_Inicio);
		jc_Data_Inicio.setDateFormatString("dd/MM/yyyy");
		
		JDateChooser jc_Data_Fim = new JDateChooser();
		jc_Data_Fim.setBounds(419, 39, 150, 20);
		panel_Salvar.add(jc_Data_Fim);
		jc_Data_Fim.setDateFormatString("dd/MM/yyyy");
		
		JLabel lbl_DataInicio = new JLabel("D. Inicio:");
		lbl_DataInicio.setBounds(351, 11, 58, 14);
		panel_Salvar.add(lbl_DataInicio);
		
		JLabel lbl_DataFim = new JLabel("D. Fim:");
		lbl_DataFim.setBounds(351, 42, 48, 14);
		panel_Salvar.add(lbl_DataFim);
		JComboBox comboBox = new JComboBox();
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);

		
		JButton btn_Salvar = new JButton("");
		btn_Salvar.setBackground(Color.LIGHT_GRAY);
		//Salvar informa��es inseridas na tela
		btn_Salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Vagas tVagas = new Vagas((String)comboBox.getSelectedItem());
				try {
					Connection conexao = new Conexao().fazer_conexao();
					ConexaoVeiculo lista = new ConexaoVeiculo(conexao);
					lista.qntDeVagasPorBloco(tVagas, "PRESENTE");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				int vagasExtras = 0;
				if(clickbx_VagasExtras.isSelected()) {
					vagasExtras = Integer.parseInt(tf_VagasExtras.getText());
				}
				int tv = tVagas.totalVagas() - (Integer.parseInt(tf_Vagas.getText()) + vagasExtras);
				if(tv < 0) {
					JOptionPane.showMessageDialog(null, "Quantidade de vagas n�o suportada pelo estacionamento!!");
					tf_Evento.setText("");
					jc_Data_Inicio.setCalendar(null);
					jc_Data_Fim.setCalendar(null);
					tf_Vagas.setText("");
					tf_VagasExtras.setText(Integer.toString(0));
					comboBox.setSelectedItem("Selecionar...");
				//verifica se os campos est�o vazios para lan�ar um erro
				}else if(tf_Evento.getText().equals("") || jc_Data_Inicio.getDate() == null ||
						jc_Data_Fim.getDate() == null || tf_Vagas.getText().equals("")  || 
								comboBox.getSelectedItem().equals("Selecionar...")){
					if(clickbx_VagasExtras.isSelected() && tf_VagasExtras.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Campos * s�o obrigat�rios!");
					}
					JOptionPane.showMessageDialog(null, "Campos * s�o obrigat�rios!");
				//caso nenhum campo esteja vazio, inserir os campos na tabela	
				}else {
					dtm = (DefaultTableModel) table.getModel();
					String novoEvento = tf_Evento.getText();
					Date dataInicio = jc_Data_Inicio.getDate();
					Date dataFim = jc_Data_Fim.getDate();
					int vagas = Integer.parseInt(tf_Vagas.getText());
					//verificar se o click box est� visivel para pergar o texto
					if(clickbx_VagasExtras.isSelected()) {
						vagasExtras = Integer.parseInt(tf_VagasExtras.getText());
					}
					Eventos evento = new Eventos(novoEvento, dataInicio, dataFim, (String)comboBox.getSelectedItem(), vagas, vagasExtras);
					//add os dados na tabela
					Object [] dados = {
							evento.getNomeEvento(),sdf.format(evento.getDataInicio()),sdf.format(evento.getDataFim()),evento.getBlocoRealizado(),
							evento.getVagasConsumidas(),evento.getVagaExtras()};
					dtm.addRow(dados);
					
					//seta vazio nos campos ap�s salvar
					tf_Evento.setText("");
					jc_Data_Inicio.setCalendar(null);
					jc_Data_Fim.setCalendar(null);
					tf_Vagas.setText("");
					tf_VagasExtras.setText(Integer.toString(0));
					comboBox.setSelectedItem("Selecionar...");
				}
			}
		});
		btn_Salvar.setIcon(new ImageIcon(CadastroEvento.class.getResource("/imagens/accept.png")));
		btn_Salvar.setBounds(523, 100, 18, 18);
		panel_Salvar.add(btn_Salvar);
		
		
		comboBox.addActionListener(new ActionListener() {
			
			//verifica em qual op��o o combo box est� selecionado
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Selecionar...")){
					
				}else if(comboBox.getSelectedItem().equals("Bloco A")){
					local = "bloco_A";
				}else if(comboBox.getSelectedItem().equals("Bloco B")){
					local = "bloco_B";
				}else if(comboBox.getSelectedItem().equals("Bloco C")){
					local = "bloco_C";
				}else if(comboBox.getSelectedItem().equals("Bloco D")){
					local = "bloco_D";
				}else if(comboBox.getSelectedItem().equals("Bloco E")){
					local = "bloco_E";
				}else if(comboBox.getSelectedItem().equals("Bloco F")){
					local = "bloco_F";
				}else if(comboBox.getSelectedItem().equals("Bloco G")){
					local = "bloco_G";
				}else if(comboBox.getSelectedItem().equals("Bloco Central")){
					local = "bloco_central";
				}
				
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecionar...", "Bloco Central", "Bloco A", "Bloco B", 
				"Bloco C", "Bloco D", "Bloco E", "Bloco F", "Bloco G"}));
		comboBox.setBounds(419, 69, 150, 23);
		panel_Salvar.add(comboBox);
		
		JLabel lblLocal = new JLabel("Local:");
		lblLocal.setBounds(351, 73, 48, 14);
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
		
		JLabel label = new JLabel("*");
		label.setBounds(322, 11, 18, 14);
		panel_Salvar.add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setBounds(322, 39, 18, 14);
		panel_Salvar.add(label_1);
		
		JLabel label_4 = new JLabel("*");
		label_4.setBounds(572, 39, 18, 14);
		panel_Salvar.add(label_4);
		
		JLabel label_5 = new JLabel("*");
		label_5.setBounds(572, 69, 18, 14);
		panel_Salvar.add(label_5);
		
		JLabel label_3 = new JLabel("*");
		label_3.setBounds(572, 8, 18, 14);
		panel_Salvar.add(label_3);
		
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
				"Evento", "Inicio", "Fim", "Local", "Total Vagas", "Vagas Extras"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btn_SalvarNoBanco = new JButton("Salvar");
		btn_SalvarNoBanco.setBackground(Color.LIGHT_GRAY);
		//salvar eventos no banco de dados
		btn_SalvarNoBanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String novoEvento;
				Date inicio;
				Date fim;
				String local;
				int vagas;
				int vagasExtras = 0;
				int x = 0;
				if(dtm.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "N�o existe evento cadastrado!");
					}else {
						for(int i = 0; i < dtm.getRowCount(); i++ ) {
							try {
								//fazer a conexao
								Connection conexao = new Conexao().fazer_conexao();
								ConexaoEventos inserirEvento = new ConexaoEventos(conexao);
								//pegar os valores da linha(row) x nas colunas 0 em diante
								novoEvento = (String) dtm.getValueAt(x, 0);
								inicio = sdf.parse((String) dtm.getValueAt(x, 1));
								fim = sdf.parse((String) dtm.getValueAt(x, 2));
								local = (String) dtm.getValueAt(x, 3);
								vagas = (int) dtm.getValueAt(x, 4);
								//verificar se vagas extras est� selecionado
								if(clickbx_VagasExtras.isSelected()) {
									vagasExtras = (int) dtm.getValueAt(x, 5);
								}
								//salvar os valores da tabela no banco
								Eventos evento = new Eventos(novoEvento, inicio, fim, local, vagas, vagasExtras);
								inserirEvento.inserirEvento(evento);
							}catch (ParseException | SQLException e1) {
								JOptionPane.showMessageDialog(null, "Erro ao converter data ou com a conex�o com o banco!" + e1);
							}
							//incremento da linha
							x++;
						}
						JOptionPane.showMessageDialog(null, "Dados salvos com sucessso!");
						//remover todos os itens da tabela
						while(dtm.getRowCount() !=0) {
							dtm.removeRow(0);
						}
					}
			}
		});
		btn_SalvarNoBanco.setIcon(new ImageIcon(CadastroEvento.class.getResource("/imagens/database_add.png")));
		btn_SalvarNoBanco.setBounds(496, 363, 99, 23);
		contentPane.add(btn_SalvarNoBanco);
		//fun��o para arrastar a tela da forma que quiser
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
				CadastroEvento.this.setLocation(x - xx, y - xy);
				
			}
		});
		lbl_Mover_Tela.setBounds(0, 0, 605, 386);
		contentPane.add(lbl_Mover_Tela);
		

	}
}
