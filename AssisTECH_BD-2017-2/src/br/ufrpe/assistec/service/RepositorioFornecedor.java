package br.ufrpe.assistec.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.assistec.model.Fornecedor;
import br.ufrpe.assistec.model.Funcionario;

public class RepositorioFornecedor implements IRepositorioFornecedor {
	Connection connection = ConnectionFactory.getConexaoMySQL();
	
	private static IRepositorioFornecedor instance = null;

	public static IRepositorioFornecedor getInstance() {
		if(instance == null) {
			instance = new RepositorioFornecedor();
		}

		return instance;
	}

	
	@Override
	public List<Fornecedor> lista() {
		List<Fornecedor> listaFornecedor = new ArrayList<>();

		String sql = "select * from fornecedor";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			Fornecedor fornecedor = new Fornecedor();
			
			while (resultset.next()) {
				
				fornecedor = new Fornecedor();
				
				fornecedor.setCNPJ(resultset.getLong("Cnpj"));
				fornecedor.setRazaoSocial(resultset.getString("Razao_social"));
				fornecedor.setEmail(resultset.getString("Email"));
				fornecedor.setTelefone(resultset.getString("Telefone"));

				listaFornecedor.add(fornecedor);

			}
			resultset.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		//System.out.println(listaFuncionario);
		
		return listaFornecedor;
	}

}
