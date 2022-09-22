package loja.spring.loja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import loja.spring.loja.model.entities.Cliente;
import loja.spring.loja.model.entities.Endereco;
import loja.spring.loja.model.service.ClienteService;
import loja.spring.loja.model.service.EnderecoService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private EnderecoService enderecoService;

	@GetMapping(path = "/create")
	public String cadastrarCliente() {
		return "cadastroCliente";
	}
	
	@PostMapping(path = "/create")
	public String newCliente(@Valid Cliente cliente, @Valid Endereco endereco) {
		enderecoService.newEndereco(endereco);
		cliente.setEndereco(endereco);
		clienteService.newCliente(cliente);
		return "redirect:/cliente/all";
	}
	
	@GetMapping(path = "/all")
	public ModelAndView getClientes() {
		ModelAndView mv = new ModelAndView("listClientes"); // template com esse nome
		mv.addObject("clientes", clienteService.getClientes());
		return mv;
	}
	
	@GetMapping(path = "/{id}")
	public Cliente getClienteById(@PathVariable int id) {
		return clienteService.getClienteById(id);
	}
	
	@GetMapping(path ="/detail/{id}")
	public ModelAndView clienteDetail(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("clienteEndereco");
		mv.addObject("cliente_endereco", clienteService.getClienteById(id).getEndereco());
		return mv;
	}
	
	@GetMapping(path = "/nome/{nome}")
	public Iterable<Cliente> getClienteByName(@PathVariable String nome) {
		return clienteService.getClienteByName(nome);
	}
	
	@GetMapping(path = "/edit/{id}")
	public ModelAndView updateCliente(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("editCliente");
		mv.addObject("cliente", clienteService.getClienteById(id));
		return mv;
	}

	@PostMapping(path = "/edit/{id}")
	public String updateCliente(@Valid Cliente cliente) {
		clienteService.newCliente(cliente);
		return "redirect:/cliente/all";
	}

	@GetMapping(path = "/delete/{id}")
	public String deleteCliente(@PathVariable int id) {
		clienteService.deleteCliente(id);
		return "redirect:/cliente/all";
	}

}
