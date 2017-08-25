package br.com.vinicius.banda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vinicius.banda.model.Musica;

public class MusicaDAO {

	private final Connection conn;

	public MusicaDAO(Connection con) {
		this.conn = con;
	}
	
	public boolean inserir(Musica musica) throws SQLException {
		String sql = "INSERT INTO MUSICA (MUS_CODIGO, MUS_NOME, MUS_DURACAO) VALUES (SEQ_MUSICA.nextval, ?, ?)";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, musica.getNome());
		statement.setLong(2, musica.getDuracao());

		return statement.executeUpdate() > 0;
	}

	public boolean alterar(Musica musica) throws SQLException {
		String sql = "UPDATE MUSICA SET MUS_NOME = ?, MUS_DURACAO = ? WHERE MUS_CODIGO = ?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, musica.getNome());
		statement.setLong(2, musica.getDuracao());
		statement.setInt(3, musica.getCodigo());
		
		return statement.executeUpdate() > 0;
	}

	public boolean excluir(Integer codigo) throws SQLException {
		String sql = "DELETE MUSICA WHERE MUS_CODIGO = ?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, codigo);

		return statement.executeUpdate() > 0;
	}

	public List<Musica> lista() throws SQLException {
		List<Musica> paises = new ArrayList<>();

		String sql = "select * from MUSICA";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("mus_codigo");
					String nome = rs.getString("mus_nome");
					long duracao = rs.getLong("mus_duracao");
					Musica musica = new Musica(id, nome, duracao);
					paises.add(musica);
				}
			}
		}

		return paises;

	}
	
}
