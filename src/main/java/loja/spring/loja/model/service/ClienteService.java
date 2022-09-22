package loja.spring.loja.model.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import loja.spring.loja.model.entities.Cliente;
import loja.spring.loja.model.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Iterable<Cliente> getClientes(){
		return clienteRepository.findAll();
	}
	
	public void newCliente(@Valid Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public Cliente getClienteById(int id) {
		return clienteRepository.searchByClienteId(id);
	}
	
	public Iterable<Cliente> getClienteByName(String name) {
		return clienteRepository.searchByNameLike(name);
	}
	
	public void updateCliente(@Valid Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public void deleteCliente(int id) {
		clienteRepository.deleteById(id);
	}
}
