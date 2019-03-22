package br.unisul.web.dto;
import java.io.Serializable;
import br.unisul.web.domain.Categoria;

public class CategoriaDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;

	public CategoriaDto(Categoria c) {
		id = c.getId();
		nome = c.getNome();
	}

	public CategoriaDto() {

	}

	public CategoriaDto(Integer id, String nome) {
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
