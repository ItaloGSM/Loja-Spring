package loja.spring.loja.model.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import loja.spring.loja.model.entities.Pedido;
import loja.spring.loja.model.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Iterable<Pedido> getPedidos(){
		return pedidoRepository.findAll();
	}
	
	public void newPedido(@Valid Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	public Pedido getPedidoById(int id) {
		return pedidoRepository.searchByPedidoId(id);
	}
	
	public Iterable<Pedido> getPedidoByClienteId(int id){
		return pedidoRepository.searchPedidoByClienteId(id);
	}
	
	public void updatePedido(@Valid Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	public void deletePedido(int id) {
		pedidoRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
