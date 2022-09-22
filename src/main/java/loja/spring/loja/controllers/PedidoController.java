package loja.spring.loja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import loja.spring.loja.model.entities.Pedido;
import loja.spring.loja.model.service.ClienteService;
import loja.spring.loja.model.service.EnderecoService;
import loja.spring.loja.model.service.PedidoService;
import loja.spring.loja.model.service.ProdutoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private EnderecoService enderecoService;
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(path ="/create")
	public ModelAndView cadastroPedido() {
		ModelAndView mv = new ModelAndView("cadastroPedido");
		mv.addObject("produtos", produtoService.getProdutos());
		mv.addObject("enderecos", enderecoService.getEnderecos());
		mv.addObject("clientes", clienteService.getClientes());
		return mv;
	}
	
	@PostMapping(path ="/create")
	public String newPedido(@Valid Pedido pedido) {
		pedidoService.newPedido(pedido);
		return "redirect:/pedido/all";
	}
	
	/*
	@PostMapping(path ="/create")
	public String newPedido(@Valid Pedido pedido, @RequestParam("produto") int produto_id) {
		pedido.getProduto().add(produtoService.getProdutoById(produto_id));
		pedidoService.newPedido(pedido);
		return "redirect:/pedido/all";
	}
	*/
	
	@GetMapping(path ="/detail/{id}")
	public ModelAndView pedidoDetail(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("pedidoDetail");
		mv.addObject("pedido_produtos", pedidoService.getPedidoById(id).getProduto());
		return mv;
	}
	
	@GetMapping(path = "/all")
	public ModelAndView getPedidos() {
		ModelAndView mv = new ModelAndView("listPedidos"); // template com esse nome
		mv.addObject("pedidos", pedidoService.getPedidos());
		return mv;
	}
	
	@GetMapping(path = "/{id}")
	public Pedido getPedidoById(@PathVariable int id) {
		return pedidoService.getPedidoById(id);
	}
	
	@GetMapping(path = "/cliente/{clienteid}")
	public Iterable<Pedido> getPedidoByClienteId(@PathVariable int cliente_id){
		return pedidoService.getPedidoByClienteId(cliente_id);
	}
	
	
	@GetMapping(path = "/delete/{id}")
	public String deletePedido(@PathVariable int id) {
		pedidoService.deletePedido(id);
		return "redirect:/pedido/all";
	}
}
