package br.unisul.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.web.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	@Transactional(readOnly = true)
	@Query("select c from Categoria c where c.nome like %:nome%")
	List<Categoria> findByCategoriaContaining(@Param("nome") String nome);

// public List<Categoria> findByNomeContaining(String nome);

}
