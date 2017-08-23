package br.com.vinicius.banda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.vinicius.banda.model.Banda;

public class BandaDAO {

	private final Connection con;

	public BandaDAO(Connection con) {
		this.con = con;
	}

	public List<Banda> lista() throws SQLException {
		List<Banda> bandas = new ArrayList<>();

		String sql = "select * from BANDA";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
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
