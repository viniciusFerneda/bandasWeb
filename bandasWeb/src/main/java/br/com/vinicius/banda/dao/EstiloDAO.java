package br.com.vinicius.banda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vinicius.banda.model.Estilo;

public class EstiloDAO {

	private final Connection con;

	public EstiloDAO(Connection con) {
		this.con = con;
	}

	public List<Estilo> lista() throws SQLException {
		List<Estilo> estilos = new ArrayList<>();

		String sql = "select * from ESTILO";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
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
