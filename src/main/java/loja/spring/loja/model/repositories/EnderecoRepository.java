package loja.spring.loja.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import loja.spring.loja.model.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

	@Query("SELECT e FROM Endereco e WHERE (e.id) = :id")
	public Endereco searchByEnderecoId(@Param("id") int id);
	
	@Query("SELECT e FROM Endereco e WHERE e.estado LIKE %:estado%")
	public Iterable<Endereco> searchByEstado(@Param("estado") String estado);
	
	@Query("SELECT e FROM Endereco e WHERE e.cidade LIKE %:cidade%")
	public Iterable<Endereco> searchByCidade(@Param("cidade") String cidade);
}
