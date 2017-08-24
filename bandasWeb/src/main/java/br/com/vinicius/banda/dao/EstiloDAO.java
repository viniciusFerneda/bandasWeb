package br.com.vinicius.banda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vinicius.banda.model.Estilo;

public class EstiloDAO {

	private final Connection conn;

	public EstiloDAO(Connection con) {
		this.conn = con;
	}
	
	public boolean inserir(Estilo estilo) throws SQLException {
		String sql = "INSERT INTO ESTILO (EST_CODIGO, EST_NOME) VALUES (SEQ_ESTILO.nextval, ?)";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, estilo.getNome());

		return statement.executeUpdate() > 0;
	}

	public boolean alterar(Estilo estilo) throws SQLException {
		String sql = "UPDATE ESTILO SET EST_NOME = ? WHERE EST_CODIGO = ?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, estilo.getNome());

		return statement.executeUpdate() > 0;
	}

	public boolean excluir(Integer codigo) throws SQLException {
		String sql = "DELETE ESTILO WHERE EST_CODIGO = ?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, codigo);

		return statement.executeUpdate() > 0;
	}

	public List<Estilo> lista() throws SQLException {
		List<Estilo> estilos = new ArrayList<>();

		String sql = "select * from ESTILO";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("est_codigo");
					String nome = rs.getString("est_nome");
					Estilo estilo = new Estilo(id, nome);
					estilos.add(estilo);
				}
			}
		}

		return estilos;

	}
	
}
