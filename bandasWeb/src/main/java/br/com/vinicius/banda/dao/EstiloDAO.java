package br.com.vinicius.banda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vinicius.banda.dto.EstiloDTO;
import br.com.vinicius.banda.model.Estilo;

public class EstiloDAO {

	private final Connection conn;

	public EstiloDAO(Connection con) {
		this.conn = con;
	}
	
	public boolean inserir(Estilo estilo) throws SQLException {
		String sql = "INSERT INTO ESTILO (EST_CODIGO, EST_NOME) VALUES (SEQ_ESTILO.NEXTVAL, ?)";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, estilo.getNome());

		return statement.executeUpdate() > 0;
	}

	public boolean alterar(Estilo estilo) throws SQLException {
		String sql = "UPDATE ESTILO SET EST_NOME = ? WHERE EST_CODIGO = ?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, estilo.getNome());
		statement.setInt(2, estilo.getCodigo());
		
		return statement.executeUpdate() > 0;
	}

	public boolean excluir(Integer codigo) throws SQLException {
		String sql = "DELETE ESTILO WHERE EST_CODIGO = ?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, codigo);

		return statement.executeUpdate() > 0;
	}

	public List<EstiloDTO> lista() throws SQLException {
		List<EstiloDTO> estilos = new ArrayList<>();

		String sql = "SELECT * FROM ESTILO";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("EST_CODIGO");
					String nome = rs.getString("EST_NOME");
					Estilo estilo = new Estilo(id, nome);
					estilos.add(estilo.toDTO());
				}
			}
		}

		return estilos;

	}

	public EstiloDTO buscarEstiloPorCodigo(int codigo) throws SQLException {
		EstiloDTO estilo = new EstiloDTO();

		String sql = "SELECT * FROM ESTILO WHERE EST_CODIGO = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, codigo);
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("EST_CODIGO");
					String nome = rs.getString("EST_NOME");
					estilo = new Estilo(id, nome).toDTO();
				}
			}
		}

		return estilo;
	}
	
}
