package br.com.vinicius.banda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vinicius.banda.model.Pais;

public class PaisDAO {

	private final Connection conn;

	public PaisDAO(Connection con) {
		this.conn = con;
	}
	
	public boolean inserir(String nome) throws SQLException{
		String sql = "INSERT INTO PAIS (pai_codigo, pai_nome) VALUES (SEQ_PAIS.nextval, ?)";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, nome);
		 
		return statement.executeUpdate() > 0;
	}
	
	public boolean alterar(int id, String nome) throws SQLException{
		String sql = "UPDATE PAIS SET pai_nome = ? WHERE pai_codigo = ?";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, nome);
		statement.setInt(2, id);
		 
		return statement.executeUpdate() > 0;
	}
	
	public boolean excluir(int id) throws SQLException{
		String sql = "DELETE PAIS WHERE pai_codigo = ?";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, id);
		 
		return statement.executeUpdate() > 0;
	}

	public List<Pais> lista() throws SQLException {
		List<Pais> paises = new ArrayList<>();

		String sql = "select * from PAIS";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("pai_codigo");
					String nome = rs.getString("pai_nome");
					Pais pais = new Pais(id, nome);
					paises.add(pais);
				}
			}
		}

		return paises;

	}

}
