package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import conexoes.Conexao;
import conexoes.ConexaoUsuario;
import modelo.Usuario;





public class Tela_de_CadastroTeste extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfLogin_Cadastro;
	private JPasswordField pfSenha_Cadastro;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_de_CadastroTeste frame = new Tela_de_CadastroTeste();
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
	public Tela_de_CadastroTeste() {
		setTitle("Tela de Cadastro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(142, 77, 48, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(142, 138, 48, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(142, 208, 48, 14);
		contentPane.add(lblNewLabel_2);
		
		tfId = new JTextField();
		tfId.setBounds(201, 71, 96, 31);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfLogin_Cadastro = new JTextField();
		tfLogin_Cadastro.setBounds(200, 132, 229, 31);
		contentPane.add(tfLogin_Cadastro);
		tfLogin_Cadastro.setColumns(10);
		
		pfSenha_Cadastro = new JPasswordField();
		pfSenha_Cadastro.setBounds(200, 202, 229, 31);
		contentPane.add(pfSenha_Cadastro);
		
		JButton btnCadastrarC = new JButton("Cadastrar");
		btnCadastrarC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usuario  = tfLogin_Cadastro.getText();
				String senha  = new String(pfSenha_Cadastro.getPassword());
				
				Usuario usuairo = new Usuario(usuario, senha);
				
				try {
					if(tfLogin_Cadastro.getText().equals("") || pfSenha_Cadastro.getText().equals("")) {
						
						JOptionPane.showMessageDialog(null, "Os campos que tem * são obrigatórios!");
						
					}else {
						Connection conexao = new Conexao().faz_conexao();
						ConexaoUsuario usuConexao = new ConexaoUsuario(conexao);
						usuConexao.inserirUsuario(usuairo);
						JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
						tfLogin_Cadastro.setText("");
						pfSenha_Cadastro.setText("");
						
					}
					
					
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnCadastrarC.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCadastrarC.setBounds(201, 255, 109, 31);
		contentPane.add(btnCadastrarC);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Tela_de_AcessoTeste telaDeAcesso = new Tela_de_AcessoTeste();
				
				telaDeAcesso.setVisible(true);
				setVisible(false);
				
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVoltar.setBounds(320, 255, 109, 31);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(439, 140, 48, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("*");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(439, 208, 48, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Tela_de_CadastroTeste.class.getResource("/telas/imagens/Uniesp.jpg")));
		lblNewLabel_3.setBounds(0, 0, 595, 381);
		contentPane.add(lblNewLabel_3);
	}
}
