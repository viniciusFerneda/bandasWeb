package br.com.vinicius.banda.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.vinicius.banda.dao.BandaDAO;
import br.com.vinicius.banda.jdbc.oracle.ConnectionPoolOracle;
import br.com.vinicius.banda.model.Banda;

public class BandaService {

	public void inserir(Banda banda) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new BandaDAO(con).inserir(banda);
		}
	}

	public void alterar(Banda banda) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new BandaDAO(con).alterar(banda);
		}
	}
	
	public void excluir(Integer codigo) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new BandaDAO(con).excluir(codigo);
		}
	}
	
	public List<Banda> listarBandas() throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
            return new BandaDAO(con).lista();
		}
	}
	
}
