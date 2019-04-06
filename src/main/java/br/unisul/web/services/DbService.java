package br.unisul.web.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.domain.Categoria;
import br.unisul.web.domain.Cidade;
import br.unisul.web.domain.Cliente;
import br.unisul.web.domain.Endereco;
import br.unisul.web.domain.Estado;
import br.unisul.web.domain.Produto;
import br.unisul.web.domain.enums.TipoCliente;
import br.unisul.web.repositories.CategoriaRepository;
import br.unisul.web.repositories.CidadeRepository;
import br.unisul.web.repositories.ClienteRepository;
import br.unisul.web.repositories.EnderecoRepository;
import br.unisul.web.repositories.EstadoRepository;
import br.unisul.web.repositories.ProdutoRepository;

@Service
public class DbService {

	@Autowired
	private CategoriaRepository catRep;

	@Autowired
	private EstadoRepository estRep;

	@Autowired
	private ProdutoRepository prodRep;

	@Autowired
	private CidadeRepository cidRep;

	@Autowired
	private ClienteRepository clieRep;

	@Autowired
	private EnderecoRepository endRep;

	public void inicializaBancoDeDados() throws ParseException {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");

		Estado e1 = new Estado(null, "Paraná");
		Estado e2 = new Estado(null, "Santa Catarina");
		Estado e3 = new Estado(null, "Rio Grande do Sul");

		Cidade c1 = new Cidade(null, "Curitiba", e1);
		Cidade c2 = new Cidade(null, "Tubarão", e2);
		Cidade c3 = new Cidade(null, "Gravatal", e2);
		Cidade c4 = new Cidade(null, "Laguna", e2);
		Cidade c5 = new Cidade(null, "Porto Alegre", e3);
		Cidade c6 = new Cidade(null, "Guaíba", e3);

		e1.getCidades().addAll(Arrays.asList(c1));
		e2.getCidades().addAll(Arrays.asList(c2, c3, c4));
		e3.getCidades().addAll(Arrays.asList(c5, c6));

		Cliente cli1 = new Cliente(null, "Ruhan Gonçalves", "ruhan.exemplo1@gmail.com", "99999999999",
				TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("48999999999", "48999999998"));

		Endereco en1 = new Endereco(null, "Rua Exemplo 1", "111", "Próximo a posto", "Centro", "99999991", cli1, c2);
		Endereco en2 = new Endereco(null, "Rua Exemplo 2", "222", "Próximo a banca", "Centro", "99999991", cli1, c3);
		cli1.getEnderecos().addAll(Arrays.asList(en1, en2));

		estRep.saveAll(Arrays.asList(e1, e2, e3));
		cidRep.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));

		clieRep.saveAll(Arrays.asList(cli1));
		endRep.saveAll(Arrays.asList(en1, en2));

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		catRep.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		prodRep.saveAll(Arrays.asList(p1, p2, p3));
	}

}
