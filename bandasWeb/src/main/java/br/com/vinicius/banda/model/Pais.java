package br.com.vinicius.banda.model;

public class Pais {

	private Integer codigo;
	private String nome;

	public Pais() {
	}
	
	public Pais(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
