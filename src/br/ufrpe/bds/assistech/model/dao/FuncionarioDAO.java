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

import br.ufrpe.bds.assistech.model.bean.Chamado;
import br.ufrpe.bds.assistech.model.bean.Fornecedor;
import br.ufrpe.bds.assistech.model.bean.Funcionario;
import br.ufrpe.bds.assistech.service.ConnectionFactory;

public class FuncionarioDAO extends DAO<Funcionario>{

	public FuncionarioDAO() {
    	
    }

    public void cadastrar(Funcionario f) throws MySQLIntegrityConstraintViolationException{

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into funcionario " +
				"(Matricula, CPF, Nome, Email, CargaHoraria, MatriculaSupervisor, IdJornada, DataInicio, CodigoUnidadeDeSuporte) " +
				"values (?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, f.getMatricula());
			stmt.setLong(2, f.getCPF());
			stmt.setString(3, f.getNome());
			stmt.setString(4, f.getEmail());
			stmt.setInt(5, f.getCargaHoraria());
			stmt.setString(6, f.getMatriculaSuperv());
			stmt.setString(7, f.getIdjornada());
			stmt.setString(8, f.getDataInicio());
			stmt.setInt(9, f.getCodUnid_Suporte());
			
			stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
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

    public void atualizar(Funcionario f/*, Connection con*/) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE funcionario SET Matricula = ? ,CPF = ?,Login = ?,Senha = ?,Nome = ?, Email = ?, CargaHoraria = ?, MatriculaSupervisor = ?, IdJornada = ?, DataInicio = ?, CodigoUnidadeDeSuporte = ?  WHERE Matricula = ?");
            stmt.setString(1, f.getMatricula());
			stmt.setLong(2, f.getCPF());
			stmt.setString(3, f.getLogin());
			stmt.setString(4, f.getSenha());
			stmt.setString(5, f.getNome());
			stmt.setString(6, f.getEmail());
			stmt.setInt(7, f.getCargaHoraria());
			stmt.setString(8, f.getMatriculaSuperv());
			stmt.setString(9, f.getIdjornada());
			stmt.setString(10, f.getDataInicio());
			stmt.setInt(11, f.getCodUnid_Suporte());
			stmt.setString(1, "%"+f.getMatricula()+"%");
			
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
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
		} finally {
			closeStmt();
		}

    }

    public boolean checkLogin(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM funcionario WHERE Login = ? and Senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {

                
                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;

    }


}
