package br.com.vinicius.banda.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.vinicius.banda.dao.EstiloDAO;
import br.com.vinicius.banda.jdbc.oracle.ConnectionPoolOracle;
import br.com.vinicius.banda.model.Estilo;

public class EstiloService {

	public void inserir(Estilo estilo) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new EstiloDAO(con).inserir(estilo);
		}
	}

	public void alterar(Estilo estilo) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new EstiloDAO(con).alterar(estilo);
		}
	}
	
	public void excluir(Integer codigo) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new EstiloDAO(con).excluir(codigo);
		}
	}
	
	public List<Estilo> listarEstilos() throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
            return new EstiloDAO(con).lista();
		}
	}
	
}
