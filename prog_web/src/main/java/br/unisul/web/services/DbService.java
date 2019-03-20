package br.unisul.web.services;
import java.text.ParseException;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.unisul.web.domain.Categoria;
import br.unisul.web.repositories.CategoriaRepository;

@Service
public class DbService {

	@Autowired
	private CategoriaRepository rep;

	public void inicializaBancoDeDados() throws ParseException {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");

		rep.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
	}

}
