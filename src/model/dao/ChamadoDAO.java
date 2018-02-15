package model.dao;

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

import model.bean.Chamado;
import service.ConnectionFactory;

public class ChamadoDAO{
    private static ChamadoDAO instance = null;
    Connection con;
    
    public ChamadoDAO() {
    	con = ConnectionFactory.getConnection();
    }
    
    public static ChamadoDAO getInstance() {
		if(instance == null) {
			instance = new ChamadoDAO();
		}

		return instance;
	}
    
    public void create(Chamado c/*, Connection con*/) throws MySQLIntegrityConstraintViolationException{

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into chamado " +
				"(Sequencial, Tipo, Status_chamado, Descricao, Prioridade, Mat_supervisor, Mat_tec_interno, Mat_atendente, Num_ordem_servico, "
				+ " Cod_cliente, Id_atendimento, Dta_abertura ) " +
				"values (?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setLong(1, c.getSequencial());
			stmt.setString(2, c.getTipo());
			stmt.setString(3, c.getStatusChamado());
			stmt.setString(4, c.getDescricao());
			stmt.setString(5, c.getPrioridade());
			stmt.setString(6, c.getMatSupervisor());
			stmt.setString(7, c.getMatTecInterno());
			stmt.setString(8, c.getMatAtendente());
			stmt.setLong(9, c.getNumOrdemServico());
			stmt.setLong(10, c.getCodCliente());
			stmt.setLong(11, c.getIdAtendimento());
			stmt.setString(12, c.getDataAbertura());

			stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Chamado> read(/*Connection con*/) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Chamado> chamados = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM chamado");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Chamado chamado = new Chamado();

                chamado.setSequencial(rs.getLong("Sequencial"));
                chamado.setTipo(rs.getString("Tipo"));
                chamado.setStatusChamado(rs.getString("Status_chamado"));
                chamado.setDescricao(rs.getString("Descricao"));
                chamado.setPrioridade(rs.getString("Prioridade"));
                chamado.setMatSupervisor(rs.getString("Mat_supervisor"));
                chamado.setMatTecInterno(rs.getString("Mat_tec_interno"));
				chamado.setMatAtendente(rs.getString("Mat_atendente"));
				chamado.setNumOrdemServico(rs.getLong("Num_ordem_servico"));
				chamado.setCodCliente(rs.getLong("Cod_cliente"));
				chamado.setIdAtendimento(rs.getLong("Id_atendimento"));
                chamado.setDataAbertura(rs.getString("Dta_abertura"));

				chamados.add(chamado);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return chamados;

    }
    
    //busca a partir da sequencial do chamado.
    public List<Chamado> readForMat(String desc /*Connection con*/) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Chamado> chamados = new ArrayList<>();
       
        

        try {
            stmt = con.prepareStatement("SELECT * FROM chamado WHERE Sequencial LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {
            	Chamado chamado = new Chamado();

                chamado.setSequencial(rs.getLong("Sequencial"));
                chamado.setTipo(rs.getString("Tipo"));
                chamado.setStatusChamado(rs.getString("Status_chamado"));
                chamado.setDescricao(rs.getString("Descricao"));
                chamado.setPrioridade(rs.getString("Prioridade"));
                chamado.setMatSupervisor(rs.getString("Mat_supervisor"));
                chamado.setMatTecInterno(rs.getString("Mat_tec_interno"));
				chamado.setMatAtendente(rs.getString("Mat_atendente"));
				chamado.setNumOrdemServico(rs.getLong("Num_ordem_servico"));
				chamado.setCodCliente(rs.getLong("Cod_cliente"));
				chamado.setIdAtendimento(rs.getLong("Id_atendimento"));
                chamado.setDataAbertura(rs.getString("Dta_abertura"));
                
				chamados.add(chamado);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return chamados;

    }

    public void update(Chamado c/*, Connection con*/) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE chamado SET Sequencial = ? ,Tipo = ?,Status_chamado = ?,Descricao = ?,Prioridade = ?, Mat_supervisor = ?, Mat_tec_interno = ?, Mat_atendente = ?, Num_ordem-servico = ?, Cod_cliente = ?, Id_atendimento = ?, Dta_abertura = ?  WHERE Sequencial = ?");
            stmt.setLong(1, c.getSequencial());
			stmt.setString(2, c.getTipo());
			stmt.setString(3, c.getStatusChamado());
			stmt.setString(4, c.getDescricao());
			stmt.setString(5, c.getPrioridade());
			stmt.setString(6, c.getMatSupervisor());
			stmt.setString(7, c.getMatTecInterno());
			stmt.setString(8, c.getMatAtendente());
			stmt.setLong(9, c.getNumOrdemServico());
			stmt.setLong(10, c.getCodCliente());
			stmt.setLong(11, c.getIdAtendimento());
			stmt.setString(11, c.getDataAbertura());
			stmt.setString(1, "%"+c.getSequencial()+"%");
			
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } 
    }
    public void delete(Chamado c/*, Connection con*/) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM chamado WHERE Sequencial = ?");
            stmt.setLong(1, c.getSequencial());

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

            stmt = con.prepareStatement("SELECT * FROM chamado WHERE Login = ? and Senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {

                
                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;

    }


}
