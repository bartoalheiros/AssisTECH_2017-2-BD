package br.ufrpe.bds.assistech.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.ufrpe.bds.assistech.model.bean.Computador;


public class ComputadorDAO extends DAO<Computador>{

	public ComputadorDAO() {

	}

	public void cadastrar(Computador o) throws Exception{

		String sql = "insert into computador " +
				"(Cod_equipamento, Sistema_operacional, Endereco_IP, Fabricante_Bios, Versao_Bios, Tipo)" +
				"values (?,?,?,?,?,?)";
		prepare(sql);
		getStmt().setString(1, o.getCodEquipamento());
		getStmt().setString(2, o.getSistemaOperacional());
		getStmt().setString(3, o.getEnderecoIp());
		getStmt().setString(4, o.getFabricanteBios());
		getStmt().setString(5, o.getVersaoBios());
		getStmt().setString(6, o.getTipo());

		try {
			getStmt().execute();
			getCon().commit();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
		} catch (SQLException ex) {
			getCon().rollback();
			JOptionPane.showMessageDialog(null,"Não foi possível cadastrar!");
			ex.printStackTrace();
		}

	}
	public List<Computador> listarTodos() throws Exception {
		String sql = "SELECT * FROM computador";
		prepare(sql);
		ResultSet rs = null;

		List<Computador> computadores = new ArrayList<>();

		try {
			
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException ex) {
			getCon().rollback();
			ex.printStackTrace();
		}
		
		while (rs.next()) {

			Computador computador = new Computador();

			computador.setCodEquipamento(rs.getString("Cod_equipamento"));
			computador.setSistemaOperacional(rs.getString("Sistema_operacional"));
			computador.setEnderecoIp(rs.getString("Endereco_IP"));
			computador.setFabricanteBios(rs.getString("Fabricante_Bios"));
			computador.setVersaoBios(rs.getString("Versao_Bios"));
			computador.setTipo(rs.getString("Tipo"));

			computadores.add(computador);

		}
		
		return computadores;

	}

	public List<Computador> listarPorCodigo(String str) throws Exception {
		
		List<Computador> computadores = new ArrayList<>();
		
		String sql = "SELECT * FROM computador WHERE Cod_equipamento LIKE ?";
		prepare(sql);
		getStmt().setString(1, str);
		ResultSet rs = null;

		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException ex) {
			getCon().rollback();
			JOptionPane.showMessageDialog(null, "Erro na busca!");
			ex.printStackTrace();
		}
		
		while (rs.next()) {
			Computador computador = new Computador();

			computador.setCodEquipamento(rs.getString("Cod_equipamento"));
			computador.setSistemaOperacional(rs.getString("Sistema_operacional"));
			computador.setEnderecoIp(rs.getString("Endereco_IP"));
			computador.setFabricanteBios(rs.getString("Fabricante_Bios"));
			computador.setVersaoBios(rs.getString("Versao_Bios"));
			computador.setTipo(rs.getString("Tipo"));

			computadores.add(computador);

		}

		return computadores;

	}

	public void atualizar(Computador o) throws Exception {

		String sql = "UPDATE computador SET Sistema_operacional= ?,Endereco_IP = ?,Fabricante_Bios = ?,Versao_Bios = ?, Tipo = ? WHERE Cod_equipamento = ?";
		prepare(sql);
		
		getStmt().setString(1, o.getSistemaOperacional());
		getStmt().setString(2, o.getEnderecoIp());
		getStmt().setString(3, o.getFabricanteBios());
		getStmt().setString(4, o.getVersaoBios());
		getStmt().setString(5, o.getTipo());
		getStmt().setString(6, o.getCodEquipamento());

		try {
			getStmt().execute();
			getCon().commit();
			JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
		} catch (SQLException ex) {
			getCon().rollback();
			JOptionPane.showMessageDialog(null,"Não foi possível alterar!");
			ex.printStackTrace();
		} 
	}

	public void remover(Computador o) throws Exception {

		String sql = "DELETE FROM computador WHERE Cod_equipamento = ?";
		prepare(sql);
		getStmt().setString(1, o.getCodEquipamento());

		try {
			getStmt().execute();
			getCon().commit();
			JOptionPane.showMessageDialog(null,"Remoção realizada com sucesso!");
		} catch (SQLException ex) {
			getCon().rollback();
			JOptionPane.showMessageDialog(null,"Não foi possível remover!");
			ex.printStackTrace();
		} 

	}


}
