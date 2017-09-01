package br.com.vinicius.banda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vinicius.banda.dto.MusicaDTO;
import br.com.vinicius.banda.model.Musica;

public class MusicaDAO {

	private final Connection conn;

	public MusicaDAO(Connection con) {
		this.conn = con;
	}
	
	public boolean inserir(Musica musica) throws SQLException {
		String sql = "INSERT INTO MUSICA (MUS_CODIGO, MUS_NOME, MUS_DURACAO) VALUES (SEQ_MUSICA.NEXTVAL, ?, ?)";

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

	public List<MusicaDTO> lista() throws SQLException {
		List<MusicaDTO> musicas = new ArrayList<>();

		String sql = "SELECT * FROM MUSICA";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("MUS_CODIGO");
					String nome = rs.getString("MUS_NOME");
					long duracao = rs.getLong("MUS_DURACAO");
					Musica musica = new Musica(id, nome, duracao);
					musicas.add(musica.toDTO());
				}
			}
		}

		return musicas;

	}

	public MusicaDTO buscarMusicaPorCodigo(int codigo) throws SQLException {
		MusicaDTO musica = new MusicaDTO();

		String sql = "SELECT * FROM MUSICA WHERE MUS_CODIGO = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, codigo);
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("MUS_CODIGO");
					String nome = rs.getString("MUS_NOME");
					long duracao = rs.getLong("MUS_DURACAO");
					musica = new Musica(id, nome, duracao).toDTO();
				}
			}
		}

		return musica;
	}
	
}
