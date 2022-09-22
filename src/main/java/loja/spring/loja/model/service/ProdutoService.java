package loja.spring.loja.model.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import loja.spring.loja.model.entities.Produto;
import loja.spring.loja.model.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Iterable<Produto> getProdutos(){
		return produtoRepository.findAll();
	}
	
	public void newProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
	}
	
	public Produto getProdutoById(int id) {
		return produtoRepository.searchByProdutoId(id);
	}
	
	public Iterable<Produto> getProdutoByName(String name) {
		return produtoRepository.searchByNameLike(name);
	}
	
	public void updateProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
	}
	
	public void deleteProduto(int id) {
		produtoRepository.deleteById(id);
	}
	
}
