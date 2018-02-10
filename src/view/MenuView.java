package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class MenuView extends JFrame {

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGerenciarFornecedores = new JButton("Gerenciar Fornecedores");
		btnGerenciarFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new CadastroFornecedorView().setVisible(true); 
			}
		});
		btnGerenciarFornecedores.setBounds(10, 135, 156, 23);
		contentPane.add(btnGerenciarFornecedores);
		
		JButton btnGerenciarFuncionrio = new JButton("Gerenciar Funcionários");
		btnGerenciarFuncionrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 new CadastroFuncionarioView().setVisible(true); 
			}
		});
		btnGerenciarFuncionrio.setBounds(10, 169, 156, 23);
		contentPane.add(btnGerenciarFuncionrio);
		
		JButton btnGerenciarChamado = new JButton("Gerenciar  Chamados");
		btnGerenciarChamado.setBounds(10, 203, 156, 23);
		contentPane.add(btnGerenciarChamado);
		
		JButton btnGerenciarComputadores = new JButton("Gerenciar Computadores");
		btnGerenciarComputadores.setBounds(10, 237, 156, 23);
		contentPane.add(btnGerenciarComputadores);
		
		JButton btnGerenciarPeas = new JButton("Gerenciar Peças");
		btnGerenciarPeas.setBounds(10, 271, 156, 23);
		contentPane.add(btnGerenciarPeas);
		
		JLabel lblSelecioneUmaOpo = new JLabel("Selecione uma opção");
		lblSelecioneUmaOpo.setBounds(22, 21, 100, 14);
		contentPane.add(lblSelecioneUmaOpo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img\\provider.png"));
		lblNewLabel.setBounds(32, 52, 70, 72);
		contentPane.add(lblNewLabel);
	}
}
