package br.com.vinicius.banda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vinicius.banda.model.Gravadora;

public class GravadoraDAO {

	private final Connection conn;

	public GravadoraDAO(Connection con) {
		this.conn = con;
	}
	
	public boolean inserir(Gravadora gravadora) throws SQLException {
		String sql = "INSERT INTO GRAVADORA (GRA_CODIGO, GRA_NOME, GRA_PAIS) VALUES (SEQ_GRAVADORA.nextval, ?, ?)";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, gravadora.getNome());
		statement.setInt(2, gravadora.getPais().getCodigo());

		return statement.executeUpdate() > 0;
	}

	public boolean alterar(Gravadora gravadora) throws SQLException {
		String sql = "UPDATE GRAVADORA SET GRA_NOME = ?, GRA_PAIS = ? WHERE GRA_CODIGO = ?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, gravadora.getNome());
		statement.setInt(2, gravadora.getPais().getCodigo());
		statement.setInt(3, gravadora.getCodigo());

		return statement.executeUpdate() > 0;
	}

	public boolean excluir(Integer codigo) throws SQLException {
		String sql = "DELETE GRAVADORA WHERE GRA_CODIGO = ?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, codigo);

		return statement.executeUpdate() > 0;
	}

	public List<Gravadora> lista() throws SQLException {
		List<Gravadora> paises = new ArrayList<>();

		String sql = "select * from GRAVADORA";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("gra_codigo");
					String nome = rs.getString("gra_nome");
					Gravadora gravadora = new Gravadora(id, nome, null);
					paises.add(gravadora);
				}
			}
		}

		return paises;

	}
	
}

