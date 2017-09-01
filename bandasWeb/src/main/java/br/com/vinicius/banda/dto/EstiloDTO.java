package br.com.vinicius.banda.dto;

import br.com.vinicius.banda.model.Estilo;

public class EstiloDTO {

	private Integer codigo;
	private String nome;

	public EstiloDTO() {
	}

	public EstiloDTO(Integer codigo, String nome) {
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
	
	public Estilo toEstilo() {
		return new Estilo(this.codigo, this.nome);
	}
	
}
