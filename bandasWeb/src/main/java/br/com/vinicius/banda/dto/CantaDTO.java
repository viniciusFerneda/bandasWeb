package br.com.vinicius.banda.dto;

import br.com.vinicius.banda.model.Canta;

public class CantaDTO {

	private Integer codigo;
	private Integer anoGravacao;
	private String banda;
	private String musica;
	private String gravadora;
	private String estilo;
	
	public CantaDTO() {
	}

	public CantaDTO(Integer codigo, Integer anoGravacao, String banda, String musica, String gravadora, String estilo) {
		super();
		this.codigo = codigo;
		this.anoGravacao = anoGravacao;
		this.banda = banda;
		this.musica = musica;
		this.gravadora = gravadora;
		this.estilo = estilo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getAnoGravacao() {
		return anoGravacao;
	}

	public void setAnoGravacao(Integer anoGravacao) {
		this.anoGravacao = anoGravacao;
	}

	public String getBanda() {
		return banda;
	}

	public void setBanda(String banda) {
		this.banda = banda;
	}

	public String getMusica() {
		return musica;
	}

	public void setMusica(String musica) {
		this.musica = musica;
	}

	public String getGravadora() {
		return gravadora;
	}

	public void setGravadora(String gravadora) {
		this.gravadora = gravadora;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	
	public Canta toCanta() {
		return new Canta(this.codigo, this.anoGravacao,null, null, null, null);
	}	
	
}
