package br.unisul.web.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.unisul.web.domain.Produto;
import br.unisul.web.dto.ProdutoDto;
import br.unisul.web.resources.utils.URL;
import br.unisul.web.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable Integer id) {
		Produto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProdutoDto>> find(@RequestParam(value = "nome", defaultValue = "") String nome,
			@RequestParam(value = "categorias", defaultValue = "") String categorias) {

		String nomeDecoded = URL.decodeParam(nome);
		List<Integer> ids = URL.decodeIntList(categorias);
		List<Produto> list = service.search(nomeDecoded, ids);
		List<ProdutoDto> listDto = new ArrayList<ProdutoDto>();
		for (Produto p : list) {
			listDto.add(new ProdutoDto(p));
		}
		return ResponseEntity.ok().body(listDto);

	}
}
