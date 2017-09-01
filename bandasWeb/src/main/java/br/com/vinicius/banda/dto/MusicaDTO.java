package br.com.vinicius.banda.dto;

import br.com.vinicius.banda.model.Musica;

public class MusicaDTO {

	private Integer codigo;
	private String nome;
	private Long duracao;

	public MusicaDTO() {
	}

	public MusicaDTO(Integer codigo, String nome, Long duracao) {
		this.codigo = codigo;
		this.nome = nome;
		this.duracao = duracao;
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

	public Long getDuracao() {
		return duracao;
	}

	public void setDuracao(Long duracao) {
		this.duracao = duracao;
	}
	
	public Musica toMusica() {
		return new Musica(this.codigo, this.nome, this.duracao);
	}
	
}
