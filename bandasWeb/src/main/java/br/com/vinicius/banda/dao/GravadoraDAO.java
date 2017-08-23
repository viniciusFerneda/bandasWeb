package br.com.vinicius.banda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vinicius.banda.model.Gravadora;

public class GravadoraDAO {

	private final Connection con;

	public GravadoraDAO(Connection con) {
		this.con = con;
	}

	public List<Gravadora> lista() throws SQLException {
		List<Gravadora> paises = new ArrayList<>();

		String sql = "select * from GRAVADORA";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
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

