package br.com.vinicius.banda.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.vinicius.banda.dao.MusicaDAO;
import br.com.vinicius.banda.dto.MusicaDTO;
import br.com.vinicius.banda.jdbc.oracle.ConnectionPoolOracle;
import br.com.vinicius.banda.model.Musica;

public class MusicaService {

	public void inserir(Musica musica) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new MusicaDAO(con).inserir(musica);
		}
	}

	public void alterar(Musica musica) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new MusicaDAO(con).alterar(musica);
		}
	}
	
	public void excluir(Integer codigo) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			new MusicaDAO(con).excluir(codigo);
		}
	}
	
	public List<MusicaDTO> listarMusicas() throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
            return new MusicaDAO(con).lista();
		}
	}

	public MusicaDTO buscarMusicaPorCodigo(int codigo) throws SQLException {
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
            return new MusicaDAO(con).buscarMusicaPorCodigo(codigo);
		}
	}
	
}
