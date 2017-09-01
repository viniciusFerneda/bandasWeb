package br.com.vinicius.banda.dto;

import br.com.vinicius.banda.model.Gravadora;

public class GravadoraDTO {

	private Integer codigo;
	private String nome;
	private String pais;

	public GravadoraDTO() {
	}

	public GravadoraDTO(Integer codigo, String nome, String pais) {
		this.codigo = codigo;
		this.nome = nome;
		this.pais = pais;
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Gravadora toGravadora() {
		return new Gravadora(this.codigo, this.nome, null);
	}
}
