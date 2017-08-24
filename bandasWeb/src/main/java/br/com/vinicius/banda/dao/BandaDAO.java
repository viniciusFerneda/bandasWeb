package br.com.vinicius.banda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vinicius.banda.model.Banda;

public class BandaDAO {

	private final Connection conn;

	public BandaDAO(Connection conn) {
		this.conn = conn;
	}

	public boolean inserir(Banda banda) throws SQLException {
		String sql = "INSERT INTO BANDA (BAN_CODIGO, BAN_NOME, BAN_DT_CRIACAO, BAN_PAIS) VALUES (SEQ_BANDA.nextval, ?, ?, ?)";

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
	
	public List<Banda> lista() throws SQLException {
		List<Banda> bandas = new ArrayList<>();

		String sql = "select * from BANDA";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("ban_codigo");
					String nome = rs.getString("ban_nome");
					Date dtCriacao = rs.getDate("ban_dt_criacao");
					Banda banda = new Banda(id, nome, dtCriacao, null);
					bandas.add(banda);
				}
			}
		}
		return bandas;
	}
	
}
