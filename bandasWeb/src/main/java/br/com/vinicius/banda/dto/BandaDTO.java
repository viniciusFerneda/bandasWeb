package br.com.vinicius.banda.dto;

import br.com.vinicius.banda.model.Banda;
import br.com.vinicius.banda.model.Pais;
import br.com.vinicius.banda.utils.DateUtils;

public class BandaDTO {

	private Integer codigo;
	private String nome;
	private String dtCriacao;
	private String pais;
	private Integer codigoPais;

	public BandaDTO() {
	}

	public BandaDTO(Integer codigo, String nome, String dtCriacao, String pais, Integer codigoPais) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dtCriacao = dtCriacao;
		this.pais = pais;
		this.codigoPais = codigoPais;
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

	public String getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(String dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(Integer codigoPais) {
		this.codigoPais = codigoPais;
	}

	public Banda toBanda() {
		return new Banda(this.codigo, this.nome, DateUtils.parseData(this.dtCriacao, DateUtils.PATTERN_DATA_PADRAO),
				new Pais(this.codigoPais, this.pais));
	}

}
