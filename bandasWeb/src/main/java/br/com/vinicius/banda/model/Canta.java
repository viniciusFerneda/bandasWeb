package br.com.vinicius.banda.model;

import br.com.vinicius.banda.dto.CantaDTO;

public class Canta {

	private Integer codigo;
	private Integer anoGravacao;
	private Banda banda;
	private Musica musica;
	private Gravadora gravadora;
	private Estilo estilo;

	public Canta() {
	}

	public Canta(int codigo, int anoGravacao, Banda banda, Musica musica, Gravadora gravadora, Estilo estilo) {
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

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}

	public Gravadora getGravadora() {
		return gravadora;
	}

	public void setGravadora(Gravadora gravadora) {
		this.gravadora = gravadora;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	public CantaDTO toDTO() {
		return new CantaDTO(this.codigo, this.anoGravacao, this.banda.getNome(), this.banda.getCodigo(),
				this.musica.getNome(), this.musica.getCodigo(), this.gravadora.getNome(), this.gravadora.getCodigo(),
				this.estilo.getNome(), this.estilo.getCodigo());
	}

}
