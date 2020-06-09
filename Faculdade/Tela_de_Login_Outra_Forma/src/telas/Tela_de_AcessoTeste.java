package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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



public class Tela_de_AcessoTeste extends JFrame {

	private JPanel contentPane;
	private JTextField tfLogin;
	private JPasswordField pfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_de_AcessoTeste frame = new Tela_de_AcessoTeste();
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
	public Tela_de_AcessoTeste() {
		setResizable(false);
		setTitle("Tela de Acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbLogin = new JLabel("Login:");
		lbLogin.setForeground(Color.WHITE);
		lbLogin.setBounds(125, 144, 51, 45);
		lbLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lbLogin);
		
		JLabel lbSenha = new JLabel("Senha:");
		lbSenha.setForeground(Color.WHITE);
		lbSenha.setBounds(125, 200, 51, 60);
		lbSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lbSenha);
		
		tfLogin = new JTextField();
		tfLogin.setBounds(186, 153, 229, 31);
		contentPane.add(tfLogin);
		tfLogin.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(186, 217, 229, 31);
		contentPane.add(pfSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(186, 278, 109, 31);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String usuarioTelaAcesso = tfLogin.getText();
				String senhaTelaAcesso = new String(pfSenha.getPassword());
				Usuario testeUsuario = new Usuario(usuarioTelaAcesso, senhaTelaAcesso);
				
				try {
					Connection conexaoTelaAcesso;
					conexaoTelaAcesso = new Conexao().faz_conexao();
					ConexaoUsuario usuConexao = new ConexaoUsuario(conexaoTelaAcesso);
					boolean validacao = usuConexao.verificarUsuario(testeUsuario);
					if(validacao) {
						Tela_de_MenuTeste telaDeMenu = new Tela_de_MenuTeste();
						telaDeMenu.setVisible(true);
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "Usuário ou Senha inválido!");
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}

				
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnEntrar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Tela_de_CadastroTeste telaDeCadastro = new Tela_de_CadastroTeste();
				
				telaDeCadastro.setVisible(true);
				setVisible(false);
				
			}
		});
		btnCadastrar.setBounds(306, 278, 109, 31);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Tela_de_AcessoTeste.class.getResource("/telas/imagens/uni pequeno.jpg")));
		lblNewLabel_1.setBounds(217, -29, 150, 207);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Tela_de_AcessoTeste.class.getResource("/telas/imagens/Uniesp.jpg")));
		lblNewLabel.setBounds(0, 0, 594, 381);
		contentPane.add(lblNewLabel);
	}
}
