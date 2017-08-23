package br.com.vinicius.banda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vinicius.banda.model.Musica;

public class MusicaDAO {

	private final Connection con;

	public MusicaDAO(Connection con) {
		this.con = con;
	}

	public List<Musica> lista() throws SQLException {
		List<Musica> paises = new ArrayList<>();

		String sql = "select * from MUSICA";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
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
