package br.com.vinicius.banda.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.vinicius.banda.dao.CantaDAO;
import br.com.vinicius.banda.jdbc.oracle.ConnectionPoolOracle;
import br.com.vinicius.banda.model.Canta;

public class CantaService {

	public void inserir(Canta canta) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new CantaDAO(con).inserir(canta);
		}
	}

	public void alterar(Canta canta) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new CantaDAO(con).alterar(canta);
		}
	}
	
	public void excluir(Integer codigo) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new CantaDAO(con).excluir(codigo);
		}
	}
	
	public List<Canta> listarCantas() throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
            return new CantaDAO(con).lista();
		}
	}
	
}
