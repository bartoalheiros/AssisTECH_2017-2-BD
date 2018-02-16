package br.ufrpe.bds.assistech.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import br.ufrpe.bds.assistech.model.bean.Computador;
import br.ufrpe.bds.assistech.service.ConnectionFactory;


public class ComputadorDAO {
	private static ComputadorDAO instance = null;
	Connection con;

	public ComputadorDAO() {
		con = ConnectionFactory.getConnection();
	}

	public static ComputadorDAO getInstance() {
		if(instance == null) {
			instance = new ComputadorDAO();
		}

		return instance;
	}
	public void create(Computador pc/*, Connection con*/) throws MySQLIntegrityConstraintViolationException{

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("insert into funcionario " +
					"(CodEquipamento, SistemaOperacional, EnderecoIp, FabricanteBios, VersaoBios, Tipo)" +
					"values (?,?,?,?,?,?,)");
			stmt.setString(1, pc.getCodEquipamento());
			stmt.setString(2, pc.getSistemaOperacional());
			stmt.setString(3, pc.getEnderecoIp());
			stmt.setString(4, pc.getFabricanteBios());
			stmt.setString(5, pc.getVersaoBios());
			stmt.setString(6, pc.getTipo());

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
		} catch (SQLException ex) {
			System.out.println(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}
	public List<Computador> read(/*Connection con*/) {

		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Computador> computadores = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM computador");
			rs = stmt.executeQuery();

			while (rs.next()) {

				Computador computador = new Computador();

				computador.setCodEquipamento(rs.getString("Cod_equipamento"));
				computador.setSistemaOperacional(rs.getString("Sistema_operacional"));
				computador.setEnderecoIp(rs.getString("Endereco_IP"));
				computador.setFabricanteBios(rs.getString("Fabricante_bios"));
				computador.setVersaoBios(rs.getString("Versao_bios"));
				computador.setTipo(rs.getString("Tipo"));

				computadores.add(computador);

			}

		} catch (SQLException ex) {
			Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return computadores;

	}
	//busca a partir da cod do computador.
	public List<Computador> readForMat(String desc/*, Connection con*/) {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Computador> computadores = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM computador WHERE Cod_equipamento LIKE ?");
			stmt.setString(1, "%"+desc+"%");

			rs = stmt.executeQuery();

			while (rs.next()) {
				Computador computador = new Computador();

				computador.setCodEquipamento(rs.getString("Cod_equipamento"));
				computador.setSistemaOperacional(rs.getString("Sistema_operacional"));
				computador.setEnderecoIp(rs.getString("Endereco_IP"));
				computador.setFabricanteBios(rs.getString("Fabricante_bios"));
				computador.setVersaoBios(rs.getString("Versao_bios"));
				computador.setTipo(rs.getString("Tipo"));

				computadores.add(computador);

			}
		} catch (SQLException ex) {
			Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
		} 

		return computadores;

	}
	public void update(Computador pc/*, Connection con*/) {

		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("UPDATE computador SET CodEquipamento = ? ,SistemaOperacional= ?,EnderecoIp = ?,FabricanteBios = ?,VersaoBios = ?, Tipo = ? WHERE CodEquipamento = ?");
			stmt.setString(1, pc.getCodEquipamento());
			stmt.setString(2, pc.getSistemaOperacional());
			stmt.setString(3, pc.getEnderecoIp());
			stmt.setString(4, pc.getFabricanteBios());
			stmt.setString(5, pc.getVersaoBios());
			stmt.setString(6, pc.getTipo());
			stmt.setString(1, "%"+pc.getCodEquipamento()+"%");

			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
		} 
	}
    public void delete(Computador pc/*, Connection con*/) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM computador WHERE Matricula = ?");
            stmt.setString(1, pc.getCodEquipamento());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } 

    }
	public boolean checkLogin(String login, String senha) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		boolean check = false;

		try {

			stmt = con.prepareStatement("SELECT * FROM computador WHERE Login = ? and Senha = ?");
			stmt.setString(1, login);
			stmt.setString(2, senha);

			rs = stmt.executeQuery();

			if (rs.next()) {


				check = true;
			}

		} catch (SQLException ex) {
			Logger.getLogger(ComputadorDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return check;

	}


}
