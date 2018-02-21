package br.ufrpe.bds.assistech.model.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import br.ufrpe.bds.assistech.model.bean.Componente;

public class ComponenteDAO extends DAO<Componente> {

	public ComponenteDAO(){

	}
	public void cadastrar(Componente co) throws Exception{
		String sql = "insert into componente " + "(Co,Tipo,Modelo,Fabricante,NumSerie,Onboard) " +
				"values (?,?,?,?,?,?)";
		prepare(sql);
		getStmt().setLong(1, co.getCod());
		getStmt().setString(2, co.getTipo());
		getStmt().setString(3, co.getModelo());
		getStmt().setString(4, co.getFabricante());
		getStmt().setString(5, co.getNumeroSerie());
		getStmt().setString(6, co.getOnboard());

		try {
			getStmt().execute();
			getCon().commit();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
		} catch (SQLException e) {
			getCon().rollback();
			JOptionPane.showMessageDialog(null,"Não foi possível cadastrar!");
		}

	}

	public List<Componente> listarTodos() throws Exception {

		String sql = "SELECT * FROM componente";
		prepare(sql);
		ResultSet rs = null;

		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException e) {
			getCon().rollback();
		}

		List<Componente> componentes = new ArrayList<>();

		while (rs.next()) {
			Componente componente = new Componente();

			componente.setCod(rs.getLong("Cod"));
			componente.setTipo(rs.getString("Tipo"));
			componente.setModelo(rs.getString("Modelo"));
			componente.setFabricante(rs.getString("Fabricante"));
			componente.setNumeroSerie(rs.getString("NumSerie"));
			componente.setOnboard(rs.getString("Onboard"));

			componentes.add(componente);

		}

		rs.close();

		return componentes;
	}

	public List<Componente> listarPorCod(String str) throws Exception {
		List<Componente> componentes = new ArrayList<>();
		String sql = "SELECT * FROM componente WHERE Cod LIKE ?";
		prepare(sql);
		getStmt().setString(1, str);
		ResultSet rs = null;


		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException ex) {
			getCon().rollback();
			JOptionPane.showMessageDialog(null, "Erro na busca!");
		}

		while (rs.next()) {
			Componente componente = new Componente();
			componente.setCod(rs.getLong("Cod"));
			componente.setTipo(rs.getString("Tipo"));
			componente.setModelo(rs.getString("Modelo"));
			componente.setFabricante(rs.getString("Fabricante"));
			componente.setNumeroSerie(rs.getString("NumSerie"));
			componente.setOnboard(rs.getString("Onboard"));

			componentes.add(componente);
		}


		return componentes;

	}

	@Override
	public void atualizar(Componente co) throws Exception {
		String sql = "UPDATE componente SET `Tipo` = ?, `Modelo` = ?, `Fabricante` = ?, `NumSerie` = ?, `Onboard` = ?  WHERE `Cod` = ?";
		prepare(sql);
		getStmt().setString(1, co.getTipo());
		getStmt().setString(2, co.getModelo());
		getStmt().setString(3, co.getFabricante());
		getStmt().setString(4, co.getNumeroSerie());
		getStmt().setString(5, co.getOnboard());
		getStmt().setLong(6, co.getCod());

		try {
			getStmt().execute();
			getCon().commit();
			JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
		} catch (SQLException e) {
			getCon().rollback();
			JOptionPane.showMessageDialog(null,"Não foi possível alterar!");
		}
	}

	@Override
	public void remover(Componente co) throws Exception {
		String sql = "DELETE FROM componente WHERE Cod LIKE ?";
		prepare(sql);
		getStmt().setLong(1, co.getCod());

		try {
			getStmt().execute();
			getCon().commit();
			JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso!");
		} catch (SQLException e) {
			getCon().rollback();
			JOptionPane.showMessageDialog(null,"Não foi possível remover!");
		}

	}

	public List<Componente> listarComponentePorCodComputador(String str) throws Exception {
		String sql = "SELECT * FROM componente where Cod_equipamento LIKE ?";
		prepare(sql);
		getStmt().setString(1, str);
		ResultSet rs = null;
		
		List<Componente> componentes = new ArrayList<>();
		
		try {
			rs = getStmt().executeQuery();
			getCon().commit();
		} catch (SQLException ex) {
			getCon().rollback();
			JOptionPane.showMessageDialog(null, "Erro na busca!");
		}

		while (rs.next()) {
			Componente componente = new Componente();
			componente.setCod(rs.getLong("Cod"));
			componente.setTipo(rs.getString("Tipo"));
			componente.setModelo(rs.getString("Modelo"));
			componente.setFabricante(rs.getString("Fabricante"));
			componente.setNumeroSerie(rs.getString("NumSerie"));
			componente.setOnboard(rs.getString("Onboard"));

			componentes.add(componente);
		}


		return componentes;
	}

}
