package br.com.vinicius.banda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vinicius.banda.dto.PaisDTO;
import br.com.vinicius.banda.model.Pais;

public class PaisDAO {

	private final Connection conn;

	public PaisDAO(Connection con) {
		this.conn = con;
	}
	
	public boolean inserir(Pais pais) throws SQLException{
		String sql = "INSERT INTO PAIS (PAI_CODIGO, PAI_NOME) VALUES (SEQ_PAIS.NEXTVAL, ?)";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, pais.getNome());
		 
		return statement.executeUpdate() > 0;
	}
	
	public boolean alterar(Pais pais) throws SQLException{
		String sql = "UPDATE PAIS SET PAI_NOME = ? WHERE PAI_CODIGO = ?";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, pais.getNome());
		statement.setInt(2, pais.getCodigo());
		 
		return statement.executeUpdate() > 0;
	}
	
	public boolean excluir(int id) throws SQLException{
		String sql = "DELETE PAIS WHERE PAI_CODIGO = ?";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, id);
		 
		return statement.executeUpdate() > 0;
	}

	public List<PaisDTO> lista() throws SQLException {
		List<PaisDTO> paises = new ArrayList<>();

		String sql = "SELECT * FROM PAIS";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("PAI_CODIGO");
					String nome = rs.getString("PAI_NOME");
					Pais pais = new Pais(id, nome);
					paises.add(pais.toDTO());
				}
			}
		}

		return paises;

	}

	public PaisDTO buscarPaisPorCodigo(int codigo) throws SQLException {
		PaisDTO pais = new PaisDTO();

		String sql = "SELECT * FROM PAIS";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("PAI_CODIGO");
					String nome = rs.getString("PAI_NOME");
					pais = new Pais(id, nome).toDTO();
				}
			}
		}

		return pais;
	}

}
