package br.com.vinicius.banda.model;

import br.com.vinicius.banda.dto.EstiloDTO;

public class Estilo {

	private Integer codigo;
	private String nome;

	public Estilo() {
	}

	public Estilo(Integer codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
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
	
	public EstiloDTO toDTO() {
		return new EstiloDTO(this.codigo, this.nome);
	}

}
