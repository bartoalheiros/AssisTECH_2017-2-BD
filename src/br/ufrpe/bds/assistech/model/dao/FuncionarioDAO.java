package br.ufrpe.bds.assistech.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.ufrpe.bds.assistech.model.bean.Funcionario;

public class FuncionarioDAO extends DAO<Funcionario>{

	public FuncionarioDAO() {

	}

	public void cadastrar(Funcionario f) throws Exception{
		String sql = "insert into funcionario " +
				"(Matricula, CPF, Login, Senha, Nome, Email, CargaHoraria, MatriculaSupervisor, IdJornada, DataInicio, CodigoUnidadeDeSuporte) " +
				"values (?,?,?,?,?,?,?,?,?,?,?)";
		prepare(sql);
		getStmt().setString(1, f.getMatricula());
		getStmt().setLong(2, f.getCPF());
		getStmt().setString(3, f.getLogin());
		getStmt().setString(4, f.getSenha());
		getStmt().setString(5, f.getNome());
		getStmt().setString(6, f.getEmail());
		getStmt().setInt(7, f.getCargaHoraria());
		getStmt().setString(8, f.getMatriculaSuperv());
		getStmt().setString(9, f.getIdjornada());
		getStmt().setString(10, f.getDataInicio());
		getStmt().setInt(11, f.getCodUnid_Suporte());
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

	public List<Funcionario> listarTodos() throws Exception {

		ResultSet rs = null;
		String sql = "SELECT * FROM funcionario";
		prepare(sql);

		try {
			rs = getStmt().executeQuery();
			getCon().commit();

		} catch (SQLException ex) {
			getCon().rollback();
		} 
		
		System.out.println("rs: " + rs);
		
		List<Funcionario> funcionarios = new ArrayList<>();

		while (rs.next()) {

			Funcionario funcionario = new Funcionario();

			funcionario.setMatricula(rs.getString("Matricula"));
			funcionario.setCPF(rs.getLong("CPF"));
			funcionario.setLogin(rs.getString("Login"));
			funcionario.setSenha(rs.getString("Senha"));
			funcionario.setNome(rs.getString("Nome"));
			funcionario.setEmail(rs.getString("Email"));
			funcionario.setCargaHoraria(rs.getInt("CargaHoraria"));
			funcionario.setMatriculaSuperv(rs.getString("MatriculaSupervisor"));
			funcionario.setData_inicio(rs.getString("DataInicio"));
			funcionario.setCodUnid_Suporte(rs.getInt("CodigoUnidadeDeSuporte"));
			funcionario.setId_jornada(rs.getString("IdJornada"));

			funcionarios.add(funcionario);

		}

		return funcionarios;

	}

	//busca a partir da matrícula do funcionario.
	public List<Funcionario> listarPorMatricula(String str) throws Exception {

		List<Funcionario> funcionarios = new ArrayList<>();
		String sql = "SELECT * FROM funcionario WHERE Matricula LIKE ?";
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
			Funcionario funcionario = new Funcionario();
			funcionario.setMatricula(rs.getString("Matricula"));
			funcionario.setCPF(rs.getLong("CPF"));
			funcionario.setLogin(rs.getString("Login"));
			funcionario.setSenha(rs.getString("Senha"));
			funcionario.setNome(rs.getString("Nome"));
			funcionario.setEmail(rs.getString("Email"));
			funcionario.setCargaHoraria(rs.getInt("CargaHoraria"));
			funcionario.setMatriculaSuperv(rs.getString("MatriculaSupervisor"));
			funcionario.setData_inicio(rs.getString("DataInicio"));
			funcionario.setCodUnid_Suporte(rs.getInt("CodigoUnidadeDeSuporte"));
			funcionario.setId_jornada(rs.getString("IdJornada"));
			funcionarios.add(funcionario);
		}

		return funcionarios;

	}

	public void atualizar(Funcionario f) throws Exception {

		String sql = "UPDATE funcionario SET Login = ?,Senha = ?,Nome = ?, Email = ?, CargaHoraria = ?, MatriculaSupervisor = ?, IdJornada = ?, DataInicio = ?, CodigoUnidadeDeSuporte = ?  WHERE Matricula = ?";
		prepare(sql);
		getStmt().setString(1, f.getLogin());
		getStmt().setString(2, f.getSenha());
		getStmt().setString(3, f.getNome());
		getStmt().setString(4, f.getEmail());
		getStmt().setInt(5, f.getCargaHoraria());
		getStmt().setString(6, f.getMatriculaSuperv());
		getStmt().setString(7, f.getIdjornada());
		getStmt().setString(8, f.getDataInicio());
		getStmt().setInt(9, f.getCodUnid_Suporte());
		getStmt().setString(10, f.getMatricula());

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
	
	public void remover(Funcionario f) throws Exception {

		String sql = "DELETE FROM funcionario WHERE Matricula = ?";
		prepare(sql);
		getStmt().setString(1, f.getMatricula());

		try {
			getStmt().execute();
			getCon().commit();
			JOptionPane.showMessageDialog(null,"Remoção realizada com sucesso!");
		} catch (SQLException e) {
			getCon().rollback();
			JOptionPane.showMessageDialog(null,"Não foi possível remover!");
			e.printStackTrace();
		}

	}

}
