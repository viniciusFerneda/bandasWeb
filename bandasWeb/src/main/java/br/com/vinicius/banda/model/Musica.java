package br.com.vinicius.banda.model;

public class Musica {

	private Integer codigo;
	private String nome;
	private Long duracao;

	public Musica() {
	}

	public Musica(Integer codigo, String nome, Long duracao) {
		super();
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

}
