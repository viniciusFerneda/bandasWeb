package br.com.vinicius.banda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vinicius.banda.dto.BandaDTO;
import br.com.vinicius.banda.model.Banda;

public class BandaDAO {

	private final Connection conn;

	public BandaDAO(Connection conn) {
		this.conn = conn;
	}

	public boolean inserir(Banda banda) throws SQLException {
		String sql = "INSERT INTO BANDA (BAN_CODIGO, BAN_NOME, BAN_DT_CRIACAO, BAN_PAIS) VALUES (SEQ_BANDA.NEXTVAL, ?, ?, ?)";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, banda.getNome());
		statement.setDate(2, new Date(banda.getDtCriacao().getTime()));
		statement.setInt(3, banda.getPais().getCodigo());

		return statement.executeUpdate() > 0;
	}

	public boolean alterar(Banda banda) throws SQLException {
		String sql = "UPDATE BANDA SET BAN_NOME = ?, BAN_DT_CRIACAO = ?, BAN_PAIS = ? WHERE BAN_CODIGO = ?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, banda.getNome());
		statement.setDate(2, new Date(banda.getDtCriacao().getTime()));
		statement.setInt(3, banda.getPais().getCodigo());
		statement.setInt(4, banda.getCodigo());

		return statement.executeUpdate() > 0;
	}

	public boolean excluir(Integer codigo) throws SQLException {
		String sql = "DELETE BANDA WHERE BAN_CODIGO = ?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, codigo);

		return statement.executeUpdate() > 0;
	}

	public List<BandaDTO> lista() throws SQLException {
		List<BandaDTO> bandas = new ArrayList<>();

		String sql = "SELECT * FROM BANDA";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("BAN_CODIGO");
					String nome = rs.getString("BAN_NOME");
					Date dtCriacao = rs.getDate("BAN_DT_CRIACAO");
					BandaDTO banda = new Banda(id, nome, dtCriacao, null).toDTO();
					bandas.add(banda);
				}
			}
		}
		return bandas;
	}

	public BandaDTO buscarBandaPorCodigo(int codigo) throws SQLException {
		BandaDTO banda = new BandaDTO();

		String sql = "SELECT * FROM BANDA WHERE BAN_CODIGO = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, codigo);
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("BAN_CODIGO");
					String nome = rs.getString("BAN_NOME");
					Date dtCriacao = rs.getDate("BAN_DT_CRIACAO");
					banda = new Banda(id, nome, dtCriacao, null).toDTO();
				}
			}
		}
		
		return banda;
	}

}
