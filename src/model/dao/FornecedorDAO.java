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
import model.bean.Fornecedor;
import model.bean.Funcionario;
import service.ConnectionFactory;

public class FornecedorDAO{

private static FornecedorDAO instance = null;
Connection con;

public FornecedorDAO() {
	con = ConnectionFactory.getConnection();
}

public static FornecedorDAO getInstance() {
	if(instance == null) {
		instance = new FornecedorDAO();
	}

	return instance;
}

public void create(Fornecedor f/*, Connection con*/) throws MySQLIntegrityConstraintViolationException{

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("insert into fornecedor " +
				"(Cnpj,Razao_social,Email,Telefone) " +
				"values (?,?,?,?)");
            stmt.setLong(1, f.getCnpj());
			stmt.setString(2, f.getRazaoSocial());
			stmt.setString(3, f.getEmail());
			stmt.setString(4, f.getTelefone());
			
			stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

public List<Fornecedor> read(/*Connection con*/) {

    PreparedStatement stmt = null;
    ResultSet rs = null;

    List<Fornecedor> fornecedores = new ArrayList<>();

    try {
        stmt = con.prepareStatement("SELECT * FROM fornecedor");
        rs = stmt.executeQuery();

        while (rs.next()) {

            Fornecedor fornecedor = new Fornecedor();

            fornecedor.setCnpj(rs.getLong("Cnpj"));
            fornecedor.setRazaoSocial(rs.getString("Razao_social"));
            fornecedor.setEmail(rs.getString("Email"));
            fornecedor.setTelefone(rs.getString("Telefone"));
            
			

			fornecedores.add(fornecedor);
        }

    } catch (SQLException ex) {
        Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        ConnectionFactory.closeConnection(con, stmt, rs);
    }

    return fornecedores;

}


    
}
