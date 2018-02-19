package br.ufrpe.bds.assistech.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import br.ufrpe.bds.assistech.model.bean.Componente;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class GerenciamentoComponenteView extends JFrame {

	private JPanel contentPane;
	private JTextField tf_cod;
	private JTextField tf_tipo;
	private JTextField tf_mod;
	private JTextField tf_fab;
	private JTextField tf_num_ser;
	private JTextField tf_onb;
	private JTextField tf_con;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciamentoComponenteView frame = new GerenciamentoComponenteView();
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
	public GerenciamentoComponenteView() {
		iniComponents();
	}
		
		private void iniComponents() {
		// TODO Auto-generated method stub
		setTitle("Cadastro componente");
		setBounds(100, 100, 712, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		tf_cod = new JTextField();
		tf_cod.setBounds(110, 8, 86, 20);
		contentPane.add(tf_cod);
		tf_cod.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 36, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(10, 59, 46, 14);
		contentPane.add(lblModelo);
		
		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setBounds(10, 84, 67, 14);
		contentPane.add(lblFabricante);
		
		JLabel lblNmeroDeSrie = new JLabel("Número de série:");
		lblNmeroDeSrie.setBounds(10, 109, 103, 14);
		contentPane.add(lblNmeroDeSrie);
		
		JLabel lblOnboard = new JLabel("Onboard:");
		lblOnboard.setBounds(10, 134, 67, 14);
		contentPane.add(lblOnboard);
		
		tf_tipo = new JTextField();
		tf_tipo.setColumns(10);
		tf_tipo.setBounds(110, 33, 86, 20);
		contentPane.add(tf_tipo);
		
		tf_mod = new JTextField();
		tf_mod.setColumns(10);
		tf_mod.setBounds(111, 56, 86, 20);
		contentPane.add(tf_mod);
		
		tf_fab = new JTextField();
		tf_fab.setColumns(10);
		tf_fab.setBounds(112, 81, 86, 20);
		contentPane.add(tf_fab);
		
		tf_num_ser = new JTextField();
		tf_num_ser.setColumns(10);
		tf_num_ser.setBounds(111, 106, 86, 20);
		contentPane.add(tf_num_ser);
		
		tf_onb = new JTextField();
		tf_onb.setColumns(10);
		tf_onb.setBounds(112, 131, 86, 20);
		contentPane.add(tf_onb);
		
		tf_con = new JTextField();
		tf_con.setColumns(10);
		tf_con.setBounds(10, 159, 103, 20);
		contentPane.add(tf_con);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Componente co = new Componente();
				co.setCod(Long.parseLong(tf_cod.getText()));
				co.setTipo(tf_tipo.getText());
				co.setModelo(tf_mod.getText());
				co.setFabricante(tf_fab.getText());
				co.setNumeroSerie(tf_num_ser.getText());
				co.setOnboard(tf_onb.getText());
				Fachada fch = Fachada.getInstance();
				fch.cadastrarComponente(co);
				try {
					readJTable();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCadastrar.setBounds(213, 7, 96, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Componente co = new Componente();
				co.setCod(Long.parseLong(tf_cod.getText()));
				co.setTipo(tf_tipo.getText());
				co.setModelo(tf_mod.getText());
				co.setFabricante(tf_fab.getText());
				co.setNumeroSerie(tf_num_ser.getText());
				co.setOnboard(tf_onb.getText());
				Fachada coc = Fachada.getInstance();

				coc.removerComponente(co);

				try {
					readJTable();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnExcluir.setBounds(213, 36, 89, 23);
		contentPane.add(btnExcluir);
		
		
		//OBS. não tô encontrando
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(213, 67, 89, 23);
		contentPane.add(btnEditar);
		
			
		JButton btnSalvarAlteraes = new JButton("Salvar alterações");
		btnSalvarAlteraes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fachada coch = Fachada.getInstance();
				Componente co = new Componente();//Obs.REVELAR qual a razão do o
				co.setCod(Long.parseLong(tf_cod.getText()));
				co.setTipo(tf_tipo.getText());
				co.setModelo(tf_mod.getText());
				co.setFabricante(tf_fab.getText());
				co.setNumeroSerie(tf_num_ser.getText());
				co.setOnboard(tf_onb.getText());
				
				coch.atualizarComponente(co);
			}
		});
		btnSalvarAlteraes.setBounds(214, 126, 138, 23);
		contentPane.add(btnSalvarAlteraes);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				readJTableForCod(btnConsultar.getText());
				preencherFormulario();
			}
		});
		btnConsultar.setBounds(122, 158, 103, 23);
		contentPane.add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 190, 691, 250);
		contentPane.add(scrollPane);
		
		
		
		table = new JTable();
		
		table.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				tbl_ComponenteKeyReleased(evt);
			}
		});

		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tbl_ComponenteMouseClicked(evt);
			}
		});

		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Cod", "Tipo", "Modelo", "Fabricante", "NumSerie", "Onboard"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		scrollPane.setViewportView(table);
		
		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tf_cod.setText("");
				tf_tipo.setText("");
				tf_mod.setText("");
				tf_fab.setText("");
				tf_num_ser.setText("");
				tf_onb.setText("");

			}
		});
		btnLimparCampos.setBounds(213, 98, 126, 23);
		contentPane.add(btnLimparCampos);
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		try {
			readJTable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setResizable(true);

	}


		private void tbl_ComponenteMouseClicked(java.awt.event.MouseEvent evt){
			if (table.getSelectedRow() != -1) {

				tf_cod.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				tf_tipo.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				tf_mod.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				tf_fab.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				tf_num_ser.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				tf_onb.setText(table.getValueAt(table.getSelectedRow(), 5).toString());

			}

		}

		private void tbl_ComponenteKeyReleased(java.awt.event.KeyEvent evt) {
			if (table.getSelectedRow() != -1) {

				tf_cod.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				tf_tipo.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				tf_mod.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				tf_fab.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				tf_num_ser.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				tf_onb.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
			}

		}	 
		public void readJTable() throws Exception {

			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setNumRows(0);
			Fachada fch = Fachada.getInstance();

			for (Componente co : fch.listarTodosComponentes()) {

				modelo.addRow(new Object[]{
						co.getCod(),
						co.getTipo(),
						co.getModelo(),
						co.getFabricante(),
						co.getNumeroSerie(),
						co.getOnboard()

				});
			}
		}
		public void readJTableForCod(String str) {
			Fachada coch = Fachada.getInstance();
			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setNumRows(0);

			for (Componente co : coch.listarComponentePorCod(str)) {
				modelo.addRow(new Object[]{
						co.getCod(),
						co.getTipo(),
						co.getModelo(),
						co.getFabricante(),
						co.getNumeroSerie(),
						co.getOnboard()
				});}

		}

		private void preencherFormulario(){
			tf_cod.setText(table.getValueAt(0, 0).toString());
			tf_tipo.setText(table.getValueAt(0, 1).toString());
			tf_mod.setText(table.getValueAt(0, 2).toString());
			tf_fab.setText(table.getValueAt(0, 3).toString());
			tf_num_ser.setText(table.getValueAt(0, 4).toString());
			tf_onb.setText(table.getValueAt(0, 5).toString());

		}
	}