package loja.spring.loja.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import loja.spring.loja.model.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

	@Query("SELECT p FROM Pedido p WHERE (p.id) = :id")
	public Pedido searchByPedidoId(@Param("id") int id);
	
	@Query("SELECT p FROM Pedido p WHERE (p.cliente) = :id")
	public Iterable<Pedido> searchPedidoByClienteId(@Param("id") int id);
}
