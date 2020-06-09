package classes_de_conexao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;
import com.sun.net.httpserver.Authenticator.Result;

public class Tela_de_login extends JFrame {

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
					Tela_de_login frame = new Tela_de_login();
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
	public Tela_de_login() {
		setResizable(false);
		setTitle("Tela de Acesso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 357, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbLogin = new JLabel("Login:");
		lbLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbLogin.setBounds(37, 38, 51, 45);
		contentPane.add(lbLogin);
		
		JLabel lbSenha = new JLabel("Senha:");
		lbSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbSenha.setBounds(37, 94, 51, 60);
		contentPane.add(lbSenha);
		
		tfLogin = new JTextField();
		tfLogin.setBounds(98, 47, 177, 31);
		contentPane.add(tfLogin);
		tfLogin.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setBounds(98, 111, 177, 31);
		contentPane.add(pfSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//tratamento de erro
				try {
					//Cria um objeto do tipo Connection para puxar a conexão
					Connection con = Conexao.faz_conexao();
					
					//String para dizer qual o comando sql que vou executar 
					//seleciona todos os itens (*from) da tabela dados_senhas onde (where) 
					//o usuario(variável) vai ser informado (?) e a senha(variável) que vai ser informado (?)
					String sql = "select *from dados_senhas where usuario=? and senha=?";
					
					//Verifica a decleração que está sendo feita
					//stmt = con puxa uma conexao 
					//.prepareStatement(sql) prepara a decaração feita na variável sql
					PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
					
					//passa para o objeto stmt as informações de usuario e a senha
					//pega o que foi colocado no 1 parametro (Login) tfLogin é quem armazena esse valor
					stmt.setString(1, tfLogin.getText());
					//pega o que foi colocado no 2 parametro (Senha) pfSenha é quem armazena esse valor
					//porém como é preciso passar uma String, é necessário fazer um new String no pfSenha
					stmt.setString(2, new String(pfSenha.getPassword()));
					//vai pegar a preparação dos dados (smtm) e vai realizar uma consulta no banco de dados (executeQuery)
					//e vai armazenar na variável rs se essa preparação é True ou False
					//se o usuário e senha existem no banco
					ResultSet rs = stmt.executeQuery();
					//se rs for true
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Usuário existente");
					}else {
						JOptionPane.showMessageDialog(null, "Usuário ou Senha incorreto");
					}
					stmt.close();
					con.close();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEntrar.setBounds(133, 173, 97, 31);
		contentPane.add(btnEntrar);
	}
}
