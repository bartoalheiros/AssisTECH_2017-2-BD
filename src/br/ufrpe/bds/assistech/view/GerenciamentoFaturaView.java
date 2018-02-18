/* br.ufrpe.bds.assistech.view.GerenciamentoFaturaView
 * Author: José Bartolomeu (Bartô)    */

package br.ufrpe.bds.assistech.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ufrpe.bds.assistech.model.bean.Cliente;
import br.ufrpe.bds.assistech.model.bean.Fatura;
import br.ufrpe.bds.assistech.model.bean.Fornecedor;
import br.ufrpe.bds.assistech.model.bean.OrdemServico;
import br.ufrpe.bds.assistech.model.bean.ParcelaPagamentoFatura;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

public class GerenciamentoFaturaView<E> extends JFrame {

	private JPanel contentPane;
	private JTextField tfNumParcel;
	private JTextField tfValorTotal;
	private JTextField tf_Status;
	private JTable table;
	private JList list;
	List<Fatura> ft = new ArrayList<>();
	private JTextField tfNumOs;
	private JTextField tfCodFatura;
	private JTextField tfCodCliente;

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
					GerenciamentoFaturaView frame = new GerenciamentoFaturaView();
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
	public GerenciamentoFaturaView() {
		initComponents();
	}

	private void initComponents(){
		setTitle("Gerenciar Faturas");
		setBounds(100, 100, 878, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfNumParcel = new JTextField();
		tfNumParcel.setBounds(218, 75, 86, 20);
		contentPane.add(tfNumParcel);
		tfNumParcel.setColumns(10);

		tfValorTotal = new JTextField();
		tfValorTotal.setBounds(314, 75, 86, 20);
		contentPane.add(tfValorTotal);
		tfValorTotal.setColumns(10);

		tf_Status = new JTextField();
		tf_Status.setBounds(410, 75, 86, 20);
		contentPane.add(tf_Status);
		tf_Status.setColumns(10);

		JLabel lblCod = new JLabel("Faturas:");
		lblCod.setBounds(20, 143, 70, 14);
		contentPane.add(lblCod);

		JLabel lblNroParcelas = new JLabel("Nro. Parcelas:");
		lblNroParcelas.setBounds(218, 50, 86, 14);
		contentPane.add(lblNroParcelas);

		JLabel lblNewLabel = new JLabel("Valor total:");
		lblNewLabel.setBounds(314, 50, 70, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Status:");
		lblNewLabel_1.setBounds(410, 50, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cod. Cliente:");
		lblNewLabel_2.setBounds(20, 297, 86, 14);
		contentPane.add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 375, 862, 181);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Sequencial", "Cod_fatura", "Data_pagamento", "Data_parcela", "Juros", "Valor_total", "Valor_parcelado"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(104);
		table.getColumnModel().getColumn(2).setPreferredWidth(103);
		table.getColumnModel().getColumn(3).setPreferredWidth(93);
		table.getColumnModel().getColumn(4).setPreferredWidth(82);
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		table.getColumnModel().getColumn(6).setPreferredWidth(88);
		scrollPane.setViewportView(table);

		JLabel lblParcelas = new JLabel("Parcelas:");
		lblParcelas.setBounds(20, 354, 46, 14);
		contentPane.add(lblParcelas);

		JLabel lblFatura = new JLabel("Fatura:");
		lblFatura.setBounds(10, 22, 46, 14);
		contentPane.add(lblFatura);

		tfNumOs = new JTextField();
		tfNumOs.setBounds(518, 75, 86, 20);
		contentPane.add(tfNumOs);
		tfNumOs.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Numero_OS:");
		lblNewLabel_3.setBounds(518, 50, 70, 14);
		contentPane.add(lblNewLabel_3);

		JComboBox cbCliente = new JComboBox();
		cbCliente.setBounds(20, 321, 86, 22);
		contentPane.add(cbCliente);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 171, 814, 118);
		contentPane.add(scrollPane_1);

		list = new JList();
		scrollPane_1.setViewportView(list);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fatura o = new Fatura();

				o.setCod(Long.parseLong(tfCodFatura.getText()));
				o.setCod_cliente(Long.parseLong(tfCodCliente.getText()));
				o.setNum_parcelas(Long.parseLong(tfNumParcel.getText()));
				o.setValor_total(Float.parseFloat(tfValorTotal.getText()));
				o.setStatus(tf_Status.getText());


				Fachada fch = Fachada.getInstance();
				fch.cadastrarFatura(o);

				ft = fch.listarFaturasPorCodCliente(cbCliente.getSelectedItem().toString());
				list.setListData(ft.toArray());
			}
		});
		btnCadastrar.setBounds(20, 111, 91, 23);
		contentPane.add(btnCadastrar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fachada fch = Fachada.getInstance();
				Fatura o = new Fatura();
				
				o.setCod(Long.parseLong(tfCodFatura.getText()));
				o.setNum_parcelas(Long.parseLong(tfNumParcel.getText()));
				o.setValor_total(Float.parseFloat(tfValorTotal.getText()));
				o.setStatus(tf_Status.getText());
				o.setCod_cliente(Long.parseLong(tfCodCliente.getText()));
				
				fch.atualizarFatura(o);
				
				ft = fch.listarFaturasPorCodCliente(cbCliente.getSelectedItem().toString());
				list.setListData(ft.toArray());
			}
		});
		btnAlterar.setBounds(121, 111, 91, 23);
		contentPane.add(btnAlterar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fachada fch = Fachada.getInstance();
				Fatura o = new Fatura();
				o.setCod(Long.parseLong(tfCodFatura.getText()));

				fch.removerFatura(o);
				
				ft = fch.listarFaturasPorCodCliente(cbCliente.getSelectedItem().toString());
				list.setListData(ft.toArray());
			}
		});
		btnRemover.setBounds(234, 111, 91, 23);
		contentPane.add(btnRemover);

		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfCodFatura.setText("");
				tfCodCliente.setText("");
				tfNumParcel.setText("");
				tfValorTotal.setText("");
				tf_Status.setText("");
				tfNumOs.setText("");
			}
		});
		btnLimparCampos.setBounds(335, 111, 109, 23);
		contentPane.add(btnLimparCampos);

		tfCodFatura = new JTextField();
		tfCodFatura.setBounds(20, 75, 86, 20);
		contentPane.add(tfCodFatura);
		tfCodFatura.setColumns(10);

		JLabel lblCod_1 = new JLabel("Cod. Cliente:");
		lblCod_1.setBounds(121, 50, 70, 14);
		contentPane.add(lblCod_1);

		JLabel lbCodFatura = new JLabel("Cod.:");
		lbCodFatura.setBounds(20, 50, 70, 14);
		contentPane.add(lbCodFatura);

		tfCodCliente = new JTextField();
		tfCodCliente.setBounds(121, 75, 86, 20);
		contentPane.add(tfCodCliente);
		tfCodCliente.setColumns(10);

		list.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				list_MouseClicked(evt);
			}
		});

		Fachada fch = Fachada.getInstance();

		//carrega combobox de cliente
		for(Cliente c: fch.listarTodosClientes()){
			cbCliente.addItem(c);
		}

		cbCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ft = fch.listarFaturasPorCodCliente(cbCliente.getSelectedItem().toString());
				list.setListData(ft.toArray());
			}
		});
		
		setResizable(true);
	}


	private void list_MouseClicked(java.awt.event.MouseEvent evt){
		if (list.getSelectedIndex()!=-1) {
			String str = list.getSelectedValue().toString();
			Fachada fch = Fachada.getInstance();

			for (Fatura f : fch.listarFaturaPorCodigo(str)) {

				tfCodFatura.setText(Long.toString(f.getCod()));
				tfCodCliente.setText(Long.toString(f.getCod_cliente()));
				tfNumParcel.setText(Long.toString(f.getNum_parcelas()));
				tfValorTotal.setText(Float.toString(f.getValor_total()));
				tf_Status.setText(f.getStatus());
			}


			//para mudar o tf_NumOS quando a pessoa clicar na lita de Faturas.
			//Pois cada fatura pertence a uma únicas OS.
			for (OrdemServico os : fch.listarOrdemServicoPorCodFatura(str)) {

				tfNumOs.setText(Long.toString(os.getNumOS()));
			}

			readJTableForCodFatura(str);

		}

	}

	public void readJTableForCodFatura(String str) {
		Fachada fch = Fachada.getInstance();
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setNumRows(0);

		for (ParcelaPagamentoFatura pc : fch.listarParcelasPgtoFaturaPorCodFatura(str)) {
			modelo.addRow(new Object[]{
					pc.getSeqParcelaPgto(),
					pc.getCodFatura(),
					pc.getDtaPagto(),
					pc.getDtaParcela(),
					pc.getJuros(),
					pc.getValorTotal(),
					pc.getValorPgtoParcela()
			});}

	}
}
