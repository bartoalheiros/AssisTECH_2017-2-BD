package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.bean.Funcionario;
import model.dao.FuncionarioDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class ViewCadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastroFuncionario frame = new ViewCadastroFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	//FuncionarioTableModel tableModel = new FuncionarioTableModel();
	private JTable table;
	
	/**
	 * Create the frame.
	 */
	public ViewCadastroFuncionario() {
		

		
		setTitle("Cadastro Funcionario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(22, 31, 287, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(22, 91, 154, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(22, 152, 197, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(22, 218, 154, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(22, 289, 154, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Matricula Funcionário:");
		lblNewLabel.setBounds(22, 6, 118, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Matricula Supervisor:");
		lblNewLabel_1.setBounds(22, 66, 101, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setBounds(22, 122, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setBounds(22, 193, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("COD Unidade de Suporte:");
		lblNewLabel_4.setBounds(22, 264, 131, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(485, 31, 215, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(485, 91, 131, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(485, 152, 131, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(485, 233, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(592, 233, 118, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(485, 289, 131, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
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
		lblNewLabel_8.setBounds(485, 208, 76, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Data de Início:");
		lblNewLabel_9.setBounds(594, 208, 84, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("ID Jornada:");
		lblNewLabel_10.setBounds(485, 264, 76, 14);
		contentPane.add(lblNewLabel_10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 381, 849, 226);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matricula", "CPF", "Login", "Senha", "Nome", "Email", "Carga Horaria", "Marticula Supervisor", "Id Jornada", "Data In\u00EDcio", "Codigo UnidadeSuporte"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, String.class, String.class, Object.class, Object.class, String.class, Object.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, true, true, false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(3).setPreferredWidth(85);
		table.getColumnModel().getColumn(5).setPreferredWidth(142);
		table.getColumnModel().getColumn(6).setPreferredWidth(81);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(7).setPreferredWidth(110);
		table.getColumnModel().getColumn(10).setPreferredWidth(126);
		scrollPane.setViewportView(table);
		
		readJTable();
		
	}
	
	public void readJTable() {
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        modelo.setNumRows(0);
        FuncionarioDAO fdao = new FuncionarioDAO();

        for (Funcionario f : fdao.read()) {

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
}