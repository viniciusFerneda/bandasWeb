package br.com.vinicius.banda.dto;

import java.util.Date;

import br.com.vinicius.banda.model.Banda;

public class BandaDTO {

	private Integer codigo;
	private String nome;
	private Date dtCriacao;
	private String pais;
	
	public BandaDTO() {
	}

	public BandaDTO(Integer codigo, String nome, Date dtCriacao, String pais) {
		super();
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public Banda toBanda() {
		return new Banda(this.codigo, this.nome, this.dtCriacao, null);
	}
	
}
