package br.com.vinicius.banda.model;

import br.com.vinicius.banda.dto.GravadoraDTO;

public class Gravadora {

	private Integer codigo;
	private String nome;
	private Pais pais;

	public Gravadora() {
	}

	public Gravadora(Integer codigo, String nome, Pais pais) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.pais = pais;
	}

	public Gravadora(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public GravadoraDTO toDTO() {
		return new GravadoraDTO(this.codigo, this.nome, this.pais.getNome(), this.pais.getCodigo());
	}

}
