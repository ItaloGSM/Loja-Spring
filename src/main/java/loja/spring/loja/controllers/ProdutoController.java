package loja.spring.loja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import loja.spring.loja.model.entities.Produto;
import loja.spring.loja.model.service.ProdutoService;

@Controller
@RequestMapping(path = "/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping(path = "/create")
	public String cadastrarProduto() {
		return "cadastroProduto";
	}

	@PostMapping(path = "/create")
	public String newProduto(Produto produto) {
		produtoService.newProduto(produto);
		return "redirect:/produto/all";
	}

	@GetMapping(path = "/all")
	public ModelAndView getProdutos() {
		ModelAndView mv = new ModelAndView("listProdutos"); // template com esse nome
		mv.addObject("produtos", produtoService.getProdutos());
		return mv;
	}

	@GetMapping(path = "/{id}")
	public Produto getProdutoById(@PathVariable int id) {
		return produtoService.getProdutoById(id);
	}

	@GetMapping(path = "/nome/{nome}")
	public Iterable<Produto> getProdutoByName(@PathVariable String nome) {
		return produtoService.getProdutoByName(nome);
	}

	@GetMapping(path = "/edit/{id}")
	public ModelAndView updateProduto(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("editProduto");
		mv.addObject("produto", produtoService.getProdutoById(id));
		return mv;
	}

	@PostMapping(path = "/edit/{id}")
	public String updateProduto(@Valid Produto produto) {
		produtoService.newProduto(produto);
		return "redirect:/produto/all";
	}

	@GetMapping(path = "delete/{id}")
	public String deleteProduto(@PathVariable int id) {
		produtoService.deleteProduto(id);
		return "redirect:/produto/all";
	}

}
