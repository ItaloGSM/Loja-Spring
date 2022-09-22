package loja.spring.loja.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import loja.spring.loja.model.entities.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	@Query("SELECT p FROM Produto p WHERE (p.id) = :id")
	public Produto searchByProdutoId(@Param("id") int id);
	
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNameLike(@Param("nome") String parteNome);
	
}
