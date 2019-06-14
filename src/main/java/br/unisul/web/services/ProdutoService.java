package br.unisul.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.domain.Categoria;
import br.unisul.web.domain.Produto;
import br.unisul.web.repositories.CategoriaRepository;
import br.unisul.web.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository rep;

	@Autowired
	private CategoriaRepository categoriaRepository;

	// @Autowired
	// private CategoriaService categoriaService;

	public Produto find(Integer id) {
		Optional<Produto> obj = rep.findById(id);
		return obj.orElse(null);
	}

	public List<Produto> search(String nome, List<Integer> ids) {
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return rep.findDistinctByNomeContainingAndCategoriasIn(nome, categorias);
	}

	public Produto insert(Produto obj) {
		obj.setId(null);
		obj.setCategorias(null);
		// criar find para categorias, para identificar quais as categorias do produto
		obj = rep.save(obj);
		return obj;
	}

}
