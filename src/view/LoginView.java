package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.dao.FuncionarioDAO;
import model.dao.LoginDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LoginView extends View {

	private JPanel contentPane;
	private JTextField tf_Login;
	private JPasswordField pf_password;



	/**
	 * Create the frame.
	 */
	public LoginView() {
		initComponents();

	}

	private void initComponents() {
		setTitle("Assistech - Área de Acesso");
		setBounds(100, 100, 544, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 61, 528, 291);
		contentPane.add(panel);
		panel.setLayout(null);

		setResizable(false);
		setLocationRelativeTo(null);
		tf_Login = new JTextField();
		tf_Login.setBounds(98, 98, 260, 20);
		panel.add(tf_Login);
		tf_Login.setColumns(10);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(98, 73, 46, 14);
		panel.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(98, 151, 46, 14);
		panel.add(lblSenha);

		pf_password = new JPasswordField();
		pf_password.setBounds(98, 174, 260, 20);
		panel.add(pf_password);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Fachada fach = Fachada.getInstance();

				try {
					fach.fazerLogin(tf_Login.getText(),pf_password.getText());
					JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso!");
					new MenuView().setVisible(true);
					closeView();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Login ou Senha incorretos!");
				}
			}	
		});
		btnEntrar.setBounds(272, 244, 89, 23);
		panel.add(btnEntrar);

		JLabel lblBoasVindas = new JLabel("AssisTECH - Bem Vindo!");
		lblBoasVindas.setBounds(191, 11, 120, 14);
		contentPane.add(lblBoasVindas);

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja fechar a aplicação?", "Sair da aplicação.", JOptionPane.YES_NO_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {
					closeView();
				} else if (resposta == JOptionPane.NO_OPTION) {
					showView();
				}
			};
		});

	}

}
