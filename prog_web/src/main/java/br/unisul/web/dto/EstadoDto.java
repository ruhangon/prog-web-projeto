package br.unisul.web.dto;
import java.io.Serializable;
import br.unisul.web.domain.Estado;

public class EstadoDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;

	public EstadoDto(Estado e) {
		id = e.getId();
		nome = e.getNome();
	}

	public EstadoDto() {
	}

	public EstadoDto(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}
