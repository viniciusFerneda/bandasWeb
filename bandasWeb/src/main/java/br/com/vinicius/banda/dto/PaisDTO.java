package br.com.vinicius.banda.dto;

import br.com.vinicius.banda.model.Pais;

public class PaisDTO {

	private Integer codigo;
	private String nome;
	
	public PaisDTO() {
	}
	
	public PaisDTO(Integer codigo, String nome) {
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

	public Pais toPais() {
		return new Pais(this.codigo, this.nome);
	}
	
}
