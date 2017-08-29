package br.com.vinicius.banda.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.vinicius.banda.dao.GravadoraDAO;
import br.com.vinicius.banda.jdbc.oracle.ConnectionPoolOracle;
import br.com.vinicius.banda.model.Gravadora;

public class GravadoraService {

	public void inserir(Gravadora gravadora) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new GravadoraDAO(con).inserir(gravadora);
		}
	}

	public void alterar(Gravadora gravadora) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new GravadoraDAO(con).alterar(gravadora);
		}
	}
	
	public void excluir(Integer codigo) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new GravadoraDAO(con).excluir(codigo);
		}
	}
	
	public List<Gravadora> listarGravadoras() throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
            return new GravadoraDAO(con).lista();
		}
	}
	
}
