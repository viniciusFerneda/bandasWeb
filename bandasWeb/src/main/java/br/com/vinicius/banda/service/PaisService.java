package br.com.vinicius.banda.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.vinicius.banda.dao.PaisDAO;
import br.com.vinicius.banda.dto.PaisDTO;
import br.com.vinicius.banda.jdbc.oracle.ConnectionPoolOracle;
import br.com.vinicius.banda.model.Pais;

public class PaisService {

	public void inserir(Pais pais) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new PaisDAO(con).inserir(pais);
		}
	}

	public void alterar(Pais pais) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new PaisDAO(con).alterar(pais);
		}
	}
	
	public void excluir(Integer codigo) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new PaisDAO(con).excluir(codigo);
		}
	}
	
	public List<PaisDTO> listarPaises() throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
            return new PaisDAO(con).lista();
		}
	}

	public PaisDTO buscarPaisPorCodigo(int codigo) throws SQLException {
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
            return new PaisDAO(con).buscarPaisPorCodigo(codigo);
		}
	}
	
}
