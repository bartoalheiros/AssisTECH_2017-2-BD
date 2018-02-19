package br.ufrpe.bds.assistech.view;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class MenuView extends View {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuView frame = new MenuView();
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
	public MenuView() {
		setBounds(100, 100, 596, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnGerenciarFornecedores = new JButton("Gerenciar Fornecedores");
		btnGerenciarFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GerenciamentoFornecedorView().setVisible(true); 
			}
		});
		btnGerenciarFornecedores.setBounds(10, 135, 177, 23);
		contentPane.add(btnGerenciarFornecedores);

		JButton btnGerenciarFuncionrio = new JButton("Gerenciar Funcionários");
		btnGerenciarFuncionrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GerenciamentoFuncionarioView().setVisible(true); 
			}
		});
		btnGerenciarFuncionrio.setBounds(10, 169, 177, 23);
		contentPane.add(btnGerenciarFuncionrio);

		JButton btnGerenciarChamado = new JButton("Gerenciar  Chamados");
		btnGerenciarChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GerenciamentoChamadoView().setVisible(true);
			}
		});
		btnGerenciarChamado.setBounds(10, 203, 177, 23);
		contentPane.add(btnGerenciarChamado);

		JButton btnGerenciarComputadores = new JButton("Gerenciar Computadores");
		btnGerenciarComputadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GerenciamentoComputadorView().setVisible(true);
			}
		});
		btnGerenciarComputadores.setBounds(10, 237, 177, 23);
		contentPane.add(btnGerenciarComputadores);

		JLabel lblSelecioneUmaOpo = new JLabel("Selecione uma opção");
		lblSelecioneUmaOpo.setBounds(22, 21, 100, 14);
		contentPane.add(lblSelecioneUmaOpo);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img\\provider.png"));
		lblNewLabel.setBounds(32, 52, 70, 72);
		contentPane.add(lblNewLabel);
		
		JButton btnGereComponent = new JButton("Gerenciar Componentes");
		btnGereComponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GerenciamentoComponenteView().setVisible(true);
			}
		});
		btnGereComponent.setBounds(10, 271, 177, 23);
		contentPane.add(btnGereComponent);
		
		JButton btnNewButton = new JButton("Gerenciar Faturas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GerenciamentoFaturaView().setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 305, 177, 23);
		contentPane.add(btnNewButton);
		
		JButton btnGerenciarClientesE = new JButton("Gerenciar Cliente/Chamado");
		btnGerenciarClientesE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GerenciamentoChamadosClienteView().setVisible(true);
			}
		});
		btnGerenciarClientesE.setBounds(10, 339, 177, 23);
		contentPane.add(btnGerenciarClientesE);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		{{this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja sair da aplicação?", "Sair da aplicação.", JOptionPane.YES_NO_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {
					Fachada fach = Fachada.getInstance();
					try {
						fach.fecharConexao();
						JOptionPane.showMessageDialog(null, "Desconectado com sucesso!");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					closeView();
					loginView();
					try {
						fach.fecharConexao();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (resposta == JOptionPane.NO_OPTION) {
					showView();
				}

			}

			});
		}
		}
	}	
}
