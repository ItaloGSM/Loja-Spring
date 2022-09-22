package loja.spring.loja.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import loja.spring.loja.model.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	@Query("SELECT c FROM Cliente c WHERE (c.id) = :id")
	public Cliente searchByClienteId(@Param("id") int id);
	
	@Query("SELECT c FROM Cliente c WHERE c.nome LIKE %:nome%")
	public Iterable<Cliente> searchByNameLike(@Param("nome") String parteNome);
}
