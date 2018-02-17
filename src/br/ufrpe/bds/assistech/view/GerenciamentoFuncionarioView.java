package br.ufrpe.bds.assistech.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import br.ufrpe.bds.assistech.model.bean.Funcionario;

@SuppressWarnings("serial")
public class GerenciamentoFuncionarioView extends JFrame{

	private JPanel contentPane;
	private JTextField tf_mat;
	private JTextField tf_cpf;
	private JTextField tf_login;
	private JTextField tf_password;
	private JTextField tf_name;
	private JTextField tf_email;
	private JTextField tf_carg_hora;
	private JTextField tf_mat_super;
	private JTextField tf_id_jornada;
	private JTextField tf_dt_inicio;
	private JTextField tf_cod_unid_sup;
	private JTable table;
	private JTextField tfBuscar;
	private JButton btnCadastrar;
	private JButton btnAtualizar;
	private JButton btnExcluir;

	/**
	 * Create the frame.
	 */
	public GerenciamentoFuncionarioView() {

		initComponents();


	}

	private void initComponents() {
		
		setTitle("Cadastro Funcionario");
		setBounds(100, 100, 1043, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tf_mat = new JTextField();
		tf_mat.setBounds(22, 31, 287, 20);
		contentPane.add(tf_mat);
		tf_mat.setColumns(10);

		tf_mat_super = new JTextField();
		tf_mat_super.setBounds(22, 91, 154, 20);
		contentPane.add(tf_mat_super);
		tf_mat_super.setColumns(10);

		tf_name = new JTextField();
		tf_name.setBounds(22, 152, 197, 20);
		contentPane.add(tf_name);
		tf_name.setColumns(10);

		tf_cpf = new JTextField();
		tf_cpf.setBounds(22, 218, 154, 20);
		contentPane.add(tf_cpf);
		tf_cpf.setColumns(10);

		tf_cod_unid_sup = new JTextField();
		tf_cod_unid_sup.setBounds(22, 289, 154, 20);
		contentPane.add(tf_cod_unid_sup);
		tf_cod_unid_sup.setColumns(10);

		JLabel lblNewLabel = new JLabel("Matricula Funcionário:");
		lblNewLabel.setBounds(22, 6, 125, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Matricula Supervisor:");
		lblNewLabel_1.setBounds(22, 66, 125, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setBounds(22, 122, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setBounds(22, 193, 46, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("COD Unidade de Suporte:");
		lblNewLabel_4.setBounds(22, 264, 150, 14);
		contentPane.add(lblNewLabel_4);

		tf_email = new JTextField();
		tf_email.setBounds(485, 31, 215, 20);
		contentPane.add(tf_email);
		tf_email.setColumns(10);

		tf_login = new JTextField();
		tf_login.setBounds(485, 91, 131, 20);
		contentPane.add(tf_login);
		tf_login.setColumns(10);

		tf_password = new JTextField();
		tf_password.setBounds(485, 152, 131, 20);
		contentPane.add(tf_password);
		tf_password.setColumns(10);

		tf_carg_hora = new JTextField();
		tf_carg_hora.setBounds(485, 233, 86, 20);
		contentPane.add(tf_carg_hora);
		tf_carg_hora.setColumns(10);

		tf_dt_inicio = new JTextField();
		tf_dt_inicio.setBounds(592, 233, 118, 20);
		contentPane.add(tf_dt_inicio);
		tf_dt_inicio.setColumns(10);

		tf_id_jornada = new JTextField();
		tf_id_jornada.setBounds(485, 289, 131, 20);
		contentPane.add(tf_id_jornada);
		tf_id_jornada.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setBounds(485, 6, 46, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Login:");
		lblNewLabel_6.setBounds(485, 66, 46, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Senha:");
		lblNewLabel_7.setBounds(485, 122, 46, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Carga horária:");
		lblNewLabel_8.setBounds(485, 208, 84, 14);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Data de Início:");
		lblNewLabel_9.setBounds(594, 208, 84, 14);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("ID Jornada:");
		lblNewLabel_10.setBounds(485, 264, 76, 14);
		contentPane.add(lblNewLabel_10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 381, 1017, 226);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	 tbl_FuncionarioMouseClicked(evt);
            }
        });
		 table.addKeyListener(new java.awt.event.KeyAdapter() {
	            public void keyReleased(java.awt.event.KeyEvent evt) {
	            	tbl_FuncionarioKeyReleased(evt);
	            }
	        });
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Matricula", "CPF", "Login", "Senha", "Nome", "Email", "Carga Horaria", "Matricula Supervisor", "Id Jornada", "Data In\u00EDcio", "Codigo UnidadeSuporte"
				}
				) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
					Object.class, Object.class, Object.class, Object.class, String.class, String.class, Object.class, Object.class, String.class, Object.class, Integer.class
			};
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(3).setPreferredWidth(85);
		table.getColumnModel().getColumn(5).setPreferredWidth(142);
		table.getColumnModel().getColumn(6).setPreferredWidth(81);
		table.getColumnModel().getColumn(7).setResizable(true);
		table.getColumnModel().getColumn(7).setPreferredWidth(110);
		table.getColumnModel().getColumn(10).setPreferredWidth(126);
		scrollPane.setViewportView(table);

		table.getTableHeader().setReorderingAllowed(false);
		
		JButton btn_buscar = new JButton("");
		btn_buscar.setIcon(new ImageIcon("img/search.png"));
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				readJTableForMat(tfBuscar.getText());
			}
		});
		btn_buscar.setBounds(744, 340, 60, 30);
		contentPane.add(btn_buscar);

		tfBuscar = new JTextField();
		tfBuscar.setBounds(537, 350, 197, 20);
		contentPane.add(tfBuscar);
		tfBuscar.setColumns(10);

		btnCadastrar = new JButton("+ Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario f = new Funcionario();
				f.setMatricula(tf_mat.getText());
				f.setCPF(Long.parseLong(tf_cpf.getText()));
				f.setLogin(tf_login.getText());
				f.setSenha(tf_password.getText());
				f.setNome(tf_name.getText());
				f.setEmail(tf_email.getText());
				f.setCargaHoraria(Integer.parseInt(tf_carg_hora.getText()));
				f.setMatriculaSuperv(tf_mat_super.getText());
				f.setId_jornada(tf_id_jornada.getText());
				f.setData_inicio(tf_dt_inicio.getText());
				f.setCodUnid_Suporte(Integer.parseInt(tf_cod_unid_sup.getText()));
				Fachada fch = Fachada.getInstance();
				
				fch.cadastrarFuncionario(f);
				readJTable();
			}
		});
		btnCadastrar.setBounds(10, 347, 108, 23);
		contentPane.add(btnCadastrar);

		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fachada fch = Fachada.getInstance();
				Funcionario f = new Funcionario();
				f.setMatricula(tf_mat.getText());
				f.setCPF(Long.parseLong(tf_cpf.getText()));
				f.setLogin(tf_login.getText());
				f.setSenha(tf_password.getText());
				f.setNome(tf_name.getText());
				f.setEmail(tf_email.getText());
				f.setCargaHoraria(Integer.parseInt(tf_carg_hora.getText()));
				f.setMatriculaSuperv(tf_mat_super.getText());
				f.setId_jornada(tf_id_jornada.getText());
				f.setData_inicio(tf_dt_inicio.getText());
				f.setCodUnid_Suporte(Integer.parseInt(tf_cod_unid_sup.getText()));
				fch.atualizarFuncionario(f);
				readJTable();
			}
		});
		btnAtualizar.setBounds(128, 347, 91, 23);
		contentPane.add(btnAtualizar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				Funcionario f = new Funcionario();
				f.setMatricula(tf_mat.getText());
				f.setCPF(Long.parseLong(tf_cpf.getText()));
				f.setLogin(tf_login.getText());
				f.setSenha(tf_password.getText());
				f.setNome(tf_name.getText());
				f.setEmail(tf_email.getText());
				f.setCargaHoraria(Integer.parseInt(tf_carg_hora.getText()));
				f.setMatriculaSuperv(tf_mat_super.getText());
				f.setId_jornada(tf_id_jornada.getText());
				f.setData_inicio(tf_dt_inicio.getText());
				f.setCodUnid_Suporte(Integer.parseInt(tf_cod_unid_sup.getText()));
				Fachada fch = Fachada.getInstance();
				
				fch.removerFuncionario(f);
				
				readJTable();
			}
		});
		btnExcluir.setBounds(232, 347, 91, 23);
		contentPane.add(btnExcluir);
		
		JButton btnLimparDados = new JButton("Limpar Dados");
		btnLimparDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tf_mat.setText("");
				tf_cpf.setText("");
				tf_login.setText("");
				tf_password.setText("");
				tf_name.setText("");
				tf_email.setText("");
				tf_carg_hora.setText("");
				tf_mat_super.setText("");
				tf_id_jornada.setText("");
				tf_dt_inicio.setText("");
				tf_cod_unid_sup.setText("");
			}
		});
		btnLimparDados.setIcon(new ImageIcon("img\\refresh.png"));
		btnLimparDados.setBounds(333, 347, 125, 23);
		contentPane.add(btnLimparDados);
		
		JButton btnVol = new JButton("Voltar para dados");
		btnVol.setIcon(new ImageIcon("img\\back.png"));
		btnVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				readJTable();
			}
		});
		btnVol.setBounds(834, 340, 154, 23);
		contentPane.add(btnVol);
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		readJTable();
		
		setResizable(false);

	}

	public void readJTable() {

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		Fachada fch = Fachada.getInstance();

		for (Funcionario f : fch.listarTodosFuncionarios()) {

			modelo.addRow(new Object[]{
					f.getMatricula(),
					f.getCPF(),
					f.getLogin(),
					f.getSenha(),
					f.getNome(),
					f.getEmail(),
					f.getCargaHoraria(),
					f.getMatriculaSuperv(),
					f.getIdjornada(),
					f.getDataInicio(),
					f.getCodUnid_Suporte()
			});
		}
	}

	public void readJTableForMat(String mat) {

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		Fachada fch = Fachada.getInstance();

		for (Funcionario f : fch.listarFuncionarioPorMatricula(mat)) {
			modelo.addRow(new Object[]{
				f.getMatricula(),
				f.getCPF(),
				f.getLogin(),
				f.getSenha(),
				f.getNome(),
				f.getEmail(),
				f.getCargaHoraria(),
				f.getMatriculaSuperv(),
				f.getIdjornada(),
				f.getDataInicio(),
				f.getCodUnid_Suporte()
			});
		}

	}
	
	 //método para selecionar a linha da tabela e jogar nos TextFields, quando a linha é selecionada
	// com o clique do mouse.
	 private void tbl_FuncionarioMouseClicked(java.awt.event.MouseEvent evt){
		 if (table.getSelectedRow() != -1) {

	            tf_mat.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
	            tf_cpf.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
	            tf_login.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
	            tf_password.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
	            tf_name.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
	            tf_email.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
	            tf_carg_hora.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
	            tf_mat_super.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
	            tf_id_jornada.setText(table.getValueAt(table.getSelectedRow(), 8).toString());
	            tf_dt_inicio.setText(table.getValueAt(table.getSelectedRow(), 9).toString());
	            tf_cod_unid_sup.setText(table.getValueAt(table.getSelectedRow(), 10).toString());

	        }
		 
	 }
	 
	 //método para selecionar a linha da tabela e jogar nos TextFields, quando a linha é selecionada pelas
	 //teclas direcionais do teclado.
	 private void tbl_FuncionarioKeyReleased(java.awt.event.KeyEvent evt) {
		 if (table.getSelectedRow() != -1) {

	            tf_mat.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
	            tf_cpf.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
	            tf_login.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
	            tf_password.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
	            tf_name.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
	            tf_email.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
	            tf_carg_hora.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
	            tf_mat_super.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
	            tf_id_jornada.setText(table.getValueAt(table.getSelectedRow(), 8).toString());
	            tf_dt_inicio.setText(table.getValueAt(table.getSelectedRow(), 9).toString());
	            tf_cod_unid_sup.setText(table.getValueAt(table.getSelectedRow(), 10).toString());

	        }
	 }
}
