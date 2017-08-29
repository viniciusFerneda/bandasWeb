package br.com.vinicius.banda.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.vinicius.banda.dao.PaisDAO;
import br.com.vinicius.banda.jdbc.oracle.ConnectionPoolOracle;
import br.com.vinicius.banda.model.Pais;

public class PaisService {

	public void inserir(String nomePais) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new PaisDAO(con).inserir(nomePais);
		}
	}

	public void alterar(int codigoPais, String nomePais) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new PaisDAO(con).alterar(codigoPais, nomePais);
		}
	}
	
	public void excluir(Integer codigo) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new PaisDAO(con).excluir(codigo);
		}
	}
	
	public List<Pais> listarPaises() throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
            return new PaisDAO(con).lista();
		}
	}
	
}
