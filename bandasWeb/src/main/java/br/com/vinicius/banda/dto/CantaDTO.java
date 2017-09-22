package br.com.vinicius.banda.dto;

import br.com.vinicius.banda.model.Banda;
import br.com.vinicius.banda.model.Canta;
import br.com.vinicius.banda.model.Estilo;
import br.com.vinicius.banda.model.Gravadora;
import br.com.vinicius.banda.model.Musica;

public class CantaDTO {

	private Integer codigo;
	private Integer anoGravacao;
	private String banda;
	private Integer codigoBanda;
	private String musica;
	private Integer codigoMusica;
	private String gravadora;
	private Integer codigoGravadora;
	private String estilo;
	private Integer codigoEstilo;

	public CantaDTO() {
	}

	public CantaDTO(Integer codigo, Integer anoGravacao, String banda, Integer codigoBanda, String musica,
			Integer codigoMusica, String gravadora, Integer codigoGravadora, String estilo, Integer codigoEstilo) {
		super();
		this.codigo = codigo;
		this.anoGravacao = anoGravacao;
		this.banda = banda;
		this.codigoBanda = codigoBanda;
		this.musica = musica;
		this.codigoMusica = codigoMusica;
		this.gravadora = gravadora;
		this.codigoGravadora = codigoGravadora;
		this.estilo = estilo;
		this.codigoEstilo = codigoEstilo;
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

	public Integer getCodigoBanda() {
		return codigoBanda;
	}

	public void setCodigoBanda(Integer codigoBanda) {
		this.codigoBanda = codigoBanda;
	}

	public Integer getCodigoMusica() {
		return codigoMusica;
	}

	public void setCodigoMusica(Integer codigoMusica) {
		this.codigoMusica = codigoMusica;
	}

	public Integer getCodigoGravadora() {
		return codigoGravadora;
	}

	public void setCodigoGravadora(Integer codigoGravadora) {
		this.codigoGravadora = codigoGravadora;
	}

	public Integer getCodigoEstilo() {
		return codigoEstilo;
	}

	public void setCodigoEstilo(Integer codigoEstilo) {
		this.codigoEstilo = codigoEstilo;
	}

	public Canta toCanta() {
		return new Canta(this.codigo, this.anoGravacao, new Banda(this.codigoBanda),
				new Musica(this.codigoMusica), new Gravadora(this.codigoGravadora),
				new Estilo(this.codigoEstilo));
	}

}
