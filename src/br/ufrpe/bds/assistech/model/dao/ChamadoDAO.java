package br.ufrpe.bds.assistech.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.ufrpe.bds.assistech.model.bean.Chamado;

public class ChamadoDAO extends DAO<Chamado>{
    
    public ChamadoDAO() {

    }
    
    
    public void cadastrar(Chamado c) throws Exception{

    	String sql = "insert into chamado " +
				"(Sequencial, Tipo, Status_chamado, Descricao, Prioridade, Mat_supervisor, Mat_tec_interno, Mat_atendente, Num_ordem_servico, "
				+ " Cod_cliente, Id_atendimento, Dta_abertura ) " +
				"values (?,?,?,?,?,?,?,?,?,?,?,?)";
		prepare(sql);
		getStmt().setLong(1, c.getSequencial());
		getStmt().setString(2, c.getTipo());
		getStmt().setString(3, c.getStatusChamado());
		getStmt().setString(4, c.getDescricao());
		getStmt().setString(5, c.getPrioridade());
		getStmt().setString(6, c.getMatSupervisor());
		getStmt().setString(7, c.getMatTecInterno());
		getStmt().setString(8, c.getMatAtendente());
		getStmt().setLong(9, c.getNumOrdemServico());
		getStmt().setLong(10, c.getCodCliente());
		getStmt().setLong(11, c.getIdAtendimento());
		getStmt().setString(12, c.getDataAbertura());
		

        try {
        	getStmt().execute();
			getCon().commit();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            getCon().rollback();
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar!");
            ex.printStackTrace();
        }

    }

    public List<Chamado> listarTodos() throws Exception {

    	String sql = "SELECT * FROM chamado";
		prepare(sql);
		ResultSet rs = null;


        List<Chamado> chamados = new ArrayList<>();

        try {
        	rs = getStmt().executeQuery();
			getCon().commit();
        } catch (SQLException ex) {
            getCon().rollback();
        }
        
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

        
        return chamados;

    }
    
    //busca a partir da sequencial do chamado.
    public List<Chamado> listarPorSequencial(String str) throws Exception {

    	List<Chamado> chamados = new ArrayList<>();
		String sql = "SELECT * FROM chamado WHERE Sequencial LIKE ?";
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

        return chamados;

    }

    public void atualizar(Chamado c) {

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
    public void remover(Chamado c) throws Exception {


		String sql = "DELETE FROM chamado WHERE Sequencial = ?";
		prepare(sql);
		getStmt().setLong(1, c.getSequencial());

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
