package br.unisul.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.web.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	@Transactional(readOnly = true)
	public List<Estado> findAllByOrderByNome();

	@Transactional(readOnly = true)
	@Query("select e from Estado e where e.nome like %:nome%")
	List<Estado> findByEstadoContaining(@Param("nome") String nome);

}
