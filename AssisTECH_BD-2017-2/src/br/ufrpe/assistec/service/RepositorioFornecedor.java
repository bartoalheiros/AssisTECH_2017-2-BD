package br.ufrpe.assistec.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.assistec.model.Fornecedor;

public class RepositorioFornecedor implements IRepositorioFornecedor {

	@Override
	public List<Fornecedor> lista(Connection connection) {
		List<Fornecedor> listaFornecedor = new ArrayList<>();

		String sql = "select * from fornecedor";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			Fornecedor f = new Fornecedor();
			
			while (resultset.next()) {
				
				//fornecedor.dadosDoResultSet()
				//procurar nos outros repositorios

				listaFornecedor.add(f);

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
