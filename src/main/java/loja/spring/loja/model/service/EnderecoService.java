package loja.spring.loja.model.service;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import loja.spring.loja.model.entities.Endereco;
import loja.spring.loja.model.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Iterable<Endereco> getEnderecos(){
		return enderecoRepository.findAll();
	}
	
	public void newEndereco(@Valid Endereco endereco) {
		enderecoRepository.save(endereco);
	}
	
	public Endereco getEnderecoById(int id) {
		return enderecoRepository.searchByEnderecoId(id);
	}
	
	public Iterable<Endereco> getEnderecobyEstado(String estado) {
		return enderecoRepository.searchByEstado(estado);
	}
	
	public Iterable<Endereco> getEnderecobyCidade(String cidade) {
		return enderecoRepository.searchByCidade(cidade);
	}
	
	public void updateEndereco(@Valid Endereco endereco) {
		enderecoRepository.save(endereco);
	}
	
	public void deleteEndereco(int id) {
		enderecoRepository.deleteById(id);
	}
}
