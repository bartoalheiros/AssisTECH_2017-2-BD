package br.ufrpe.bds.assistech.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.ufrpe.bds.assistech.control.ControladorChamado;
import br.ufrpe.bds.assistech.model.bean.Chamado;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class GerenciamentoChamadoView extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_seq;
	private JTextField tf_tip;
	private JTextField tf_status_ch;
	private JTextField tf_desc;
	private JTextField tf_prio;
	private JTextField tf_mat_sup;
	private JTextField tf_mat_tec_int;
	private JTextField tf_mat_aten;
	private JTextField tf_num_ord_serv;
	private JTextField tf_cod_cli;
	private JTextField tf_id_aten;
	private JTextField tf_dat_aber;

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
					GerenciamentoChamadoView frame = new GerenciamentoChamadoView(/*con*/);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JTable table;
	private JTextField textField;
	private JButton btnCadastrar;
	private JButton btnAtualizar;
	private JButton btnExcluir;


	/**
	 * Create the frame.
	 */
	public GerenciamentoChamadoView() {
		
		initComponents(/*con*/);
		
	}
	private void initComponents(/*Connection con*/) {
		
		setTitle("Cadastro Chamado");
		setBounds(100, 100, 1043, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(313, 9, 86, 20));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tf_seq = new JTextField();
		tf_seq.setBounds(109, 9, 110, 20);
		contentPane.add(tf_seq);
		tf_seq.setColumns(10);

		tf_tip = new JTextField();
		tf_tip.setBounds(109, 57, 110, 20);
		contentPane.add(tf_tip);
		tf_tip.setColumns(10);

		tf_status_ch = new JTextField();
		tf_status_ch.setBounds(111, 98, 108, 20);
		contentPane.add(tf_status_ch);
		tf_status_ch.setColumns(10);

		tf_desc = new JTextField();
		tf_desc.setBounds(112, 145, 107, 20);
		contentPane.add(tf_desc);
		tf_desc.setColumns(10);

		tf_prio = new JTextField();
		tf_prio.setBounds(113, 193, 106, 20);
		contentPane.add(tf_prio);
		tf_prio.setColumns(10);
		
		tf_mat_sup = new JTextField();
		tf_mat_sup.setBounds(113, 243, 106, 20);
		contentPane.add(tf_mat_sup);
		tf_mat_sup.setColumns(10);

		tf_mat_tec_int = new JTextField();
		tf_mat_tec_int.setBounds(406, 9, 110, 20);
		contentPane.add(tf_mat_tec_int);
		tf_mat_tec_int.setColumns(10);

		tf_mat_aten = new JTextField();
		tf_mat_aten.setBounds(406, 57, 110, 20);
		contentPane.add(tf_mat_aten);
		tf_mat_aten.setColumns(10);

		tf_num_ord_serv = new JTextField();
		tf_num_ord_serv.setBounds(406, 96, 110, 20);
		contentPane.add(tf_num_ord_serv);
		tf_num_ord_serv.setColumns(10);
		
	    tf_cod_cli = new JTextField();
		tf_cod_cli.setBounds(406, 145, 110, 20);
		contentPane.add(tf_cod_cli);
		tf_cod_cli.setColumns(10);

		tf_id_aten = new JTextField();
		tf_id_aten.setBounds(406, 193, 110, 20);
		contentPane.add(tf_id_aten);
		tf_id_aten.setColumns(10);

		tf_dat_aber = new JTextField();
		tf_dat_aber.setBounds(406, 242, 110, 20);
		contentPane.add(tf_dat_aber);
		tf_dat_aber.setColumns(10);

		JLabel lblNewLabel = new JLabel("Sequencial:");
		lblNewLabel.setBounds(23, 12, 77, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tipo:");
		lblNewLabel_1.setBounds(23, 60, 60, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Status chamado:");
		lblNewLabel_2.setBounds(22, 101, 86, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Descrição:");
		lblNewLabel_3.setBounds(22, 148, 86, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Prioridade:");
		lblNewLabel_4.setBounds(22, 196, 70, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Mat. supervisor: *");
		lblNewLabel_5.setBounds(23, 244, 99, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Mat. tec. interno:");
		lblNewLabel_6.setBounds(305, 12, 91, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Mat. atendente:");
		lblNewLabel_7.setBounds(305, 60, 84, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Num. ord. serviço:");
		lblNewLabel_8.setBounds(303, 101, 99, 14);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Cod. cliente:");
		lblNewLabel_9.setBounds(305, 148, 84, 14);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("ID atendimento:");
		lblNewLabel_10.setBounds(308, 196, 86, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Data abertura:");
		lblNewLabel_11.setBounds(305, 243, 99, 14);
		contentPane.add(lblNewLabel_11);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 381, 1017, 226);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	 tbl_ChamadoMouseClicked(evt);
            }
        });
		 table.addKeyListener(new java.awt.event.KeyAdapter() {
	            public void keyReleased(java.awt.event.KeyEvent evt) {
	            	tbl_ChamadoKeyReleased(evt);
	            }
	        });
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Sequencial", "Tipo", "Status_chamado", "Descricao", "Prioridade", "Mat_supervisor", "Mat_tecnico_interno", "Mat_atendente", "Num_ordem_servico", "Cod_cliente", "Id_atendimento", "Dta_abertura"
				}
				) {
		
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false, false, false, false, false
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
				readJTableForSeq(tf_seq.getText());
			}
		});
		
		btn_buscar.setBounds(902, 340, 60, 30);
		contentPane.add(btn_buscar);

		textField = new JTextField();
		textField.setBounds(670, 350, 197, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chamado c = new Chamado();
				c.setSequencial(Long.parseLong(tf_seq.getText()));
				c.setTipo(tf_tip.getText());
				c.setStatusChamado(tf_status_ch.getText());
				c.setDescricao(tf_desc.getText());
				c.setPrioridade(tf_prio.getText());
				c.setMatSupervisor(tf_mat_sup.getText());
				c.setMatTecInterno(tf_mat_tec_int.getText());
				c.setMatAtendente(tf_mat_aten.getText());
				c.setNumOrdemServico(Long.parseLong(tf_num_ord_serv.getText()));
				c.setCodCliente(Long.parseLong(tf_cod_cli.getText()));
				c.setIdAtendimento(Long.parseLong(tf_id_aten.getText()));
				c.setDataAbertura(tf_dat_aber.getText());
				Fachada fch = Fachada.getInstance();
				
				fch.cadastrarChamado(c);
				
			}
		});
		btnCadastrar.setBounds(542, 8, 86, 23);
		contentPane.add(btnCadastrar);

		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(543, 97, 82, 23);
		contentPane.add(btnAtualizar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				Chamado c = new Chamado();
				c.setSequencial(Long.parseLong(tf_seq.getText()));
				c.setTipo(tf_tip.getText());
				c.setStatusChamado(tf_status_ch.getText());
				c.setDescricao(tf_desc.getText());
				c.setPrioridade(tf_prio.getText());
				c.setMatSupervisor(tf_mat_sup.getText());
				c.setMatTecInterno(tf_mat_tec_int.getText());
				c.setMatAtendente(tf_mat_aten.getText());
				c.setNumOrdemServico(Long.parseLong(tf_num_ord_serv.getText()));
				c.setCodCliente(Long.parseLong(tf_cod_cli.getText()));
				c.setIdAtendimento(Long.parseLong(tf_id_aten.getText()));
				c.setDataAbertura(tf_dat_aber.getText());
				ControladorChamado cCc = new ControladorChamado();
				cCc.delete(c);
			}
		});		
		
		btnExcluir.setBounds(542, 54, 86, 23);
		contentPane.add(btnExcluir);
		
		JButton btnLimparDados = new JButton("Limpar Dados");
		btnLimparDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tf_seq.setText("");
				tf_tip.setText("");
				tf_status_ch.setText("");
				tf_desc.setText("");
				tf_prio.setText("");
				tf_mat_sup.setText("");
				tf_mat_tec_int.setText("");
				tf_mat_aten.setText("");
				tf_num_ord_serv.setText("");
				tf_cod_cli.setText("");
				tf_id_aten.setText("");
				tf_dat_aber.setText("");
			}
		});
		btnLimparDados.setIcon(new ImageIcon("img\\refresh.png"));
		btnLimparDados.setBounds(544, 142, 103, 23);
		contentPane.add(btnLimparDados);
		
		JButton btnVol = new JButton("Voltar para dados");
		btnVol.setIcon(new ImageIcon("img\\back.png"));
		btnVol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				readJTable();
			}
		});		
		btnVol.setBounds(850, 8, 154, 23);
		contentPane.add(btnVol);

		readJTable();
		
		setResizable(false);
		
	}
	
	public void readJTable() {

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);
		Fachada fch = Fachada.getInstance();

		for (Chamado c : fch.listarTodosChamados()) {

			modelo.addRow(new Object[]{
					c.getSequencial(),
					c.getTipo(),
					c.getStatusChamado(),
					c.getDescricao(),
					c.getPrioridade(),
					c.getMatSupervisor(),
					c.getMatTecInterno(),
					c.getMatAtendente(),
					c.getNumOrdemServico(),
					c.getCodCliente(),
					c.getIdAtendimento(),
					c.getDataAbertura()
			});
		}
	}
	
			private void readJTableForSeq(String seq) {
				
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.setNumRows(0);
				Fachada fch = Fachada.getInstance();

				for (Chamado c : fch.listarChamadoPorSequencial(seq)) {
					modelo.addRow(new Object[]{
							c.getSequencial(),
							c.getTipo(),
							c.getStatusChamado(),
							c.getDescricao(),
							c.getPrioridade(),
							c.getMatSupervisor(),
							c.getMatTecInterno(),
							c.getMatAtendente(),
							c.getNumOrdemServico(),
							c.getCodCliente(),
							c.getIdAtendimento(),
							c.getDataAbertura()
					});
					}
			}
			
			private void tbl_ChamadoMouseClicked(java.awt.event.MouseEvent evt){
				 if (table.getSelectedRow() != -1) {

			            tf_seq.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
			            tf_tip.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
			            tf_status_ch.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
			            tf_desc.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
			            tf_prio.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
			            tf_mat_sup.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
			            tf_mat_tec_int.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
			            tf_mat_aten.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
			            tf_num_ord_serv.setText(table.getValueAt(table.getSelectedRow(), 8).toString());
			            tf_cod_cli.setText(table.getValueAt(table.getSelectedRow(), 9).toString());
			            tf_id_aten.setText(table.getValueAt(table.getSelectedRow(), 10).toString());
			            tf_dat_aber.setText(table.getValueAt(table.getSelectedRow(), 10).toString());


			        }
				 
			 }
			
			private void tbl_ChamadoKeyReleased(java.awt.event.KeyEvent evt) {
				 if (table.getSelectedRow() != -1) {

			            tf_seq.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
			            tf_tip.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
			            tf_status_ch.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
			            tf_desc.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
			            tf_prio.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
			            tf_mat_sup.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
			            tf_mat_tec_int.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
			            tf_mat_aten.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
			            tf_num_ord_serv.setText(table.getValueAt(table.getSelectedRow(), 8).toString());
			            tf_cod_cli.setText(table.getValueAt(table.getSelectedRow(), 9).toString());
			            tf_id_aten.setText(table.getValueAt(table.getSelectedRow(), 10).toString());
			            tf_dat_aber.setText(table.getValueAt(table.getSelectedRow(), 10).toString());


			        }
				 
			 }
			
}
