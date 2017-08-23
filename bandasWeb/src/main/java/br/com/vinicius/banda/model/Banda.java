package br.com.vinicius.banda.model;

import java.util.Date;

public class Banda {

	private Integer codigo;
	private String nome;
	private Date dtCriacao;
	private Pais pais;

	public Banda() {
	}

	public Banda(Integer codigo, String nome, Date dtCriacao, Pais pais) {
		this.codigo = codigo;
		this.nome = nome;
		this.dtCriacao = dtCriacao;
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

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
