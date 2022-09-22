package loja.spring.loja.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import loja.spring.loja.model.entities.Endereco;
import loja.spring.loja.model.service.EnderecoService;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping(path = "/create")
	public String cadastroEndereco() {
		return "cadastroEndereco";
	}

	@PostMapping(path = "/create")
	public String newEndereco(Endereco endereco) {
		enderecoService.newEndereco(endereco);
		return "redirect:/endereco/all";
	}

	@GetMapping(path = "/all")
	public ModelAndView getEnderecos() {
		ModelAndView mv = new ModelAndView("listEnderecos");
		mv.addObject("enderecos", enderecoService.getEnderecos());
		return mv;
	}

	@GetMapping(path = "/{id}")
	public Endereco getEnderecoById(@PathVariable int id) {
		return enderecoService.getEnderecoById(id);
	}

	@GetMapping(path = "/cidade/{cidade}")
	public Iterable<Endereco> getEnderecoByCidade(@PathVariable String cidade) {
		return enderecoService.getEnderecobyCidade(cidade);
	}

	@GetMapping(path = "/estado/{estado}")
	public Iterable<Endereco> getEnderecoByEstado(@PathVariable String estado) {
		return enderecoService.getEnderecobyEstado(estado);
	}

	@GetMapping(path = "/edit/{id}")
	public ModelAndView updateEndereco(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("editEndereco");
		mv.addObject("endereco", enderecoService.getEnderecoById(id));
		return mv;
	}

	@PostMapping(path = "/edit/{id}")
	public String updateEndereco(@Valid Endereco endereco) {
		enderecoService.updateEndereco(endereco);
		return "redirect:/endereco/all";
	}

	@GetMapping(path = "/delete/{id}")
	public String deleteEndereco(@PathVariable int id) {
		enderecoService.deleteEndereco(id);
		return "redirect:/endereco/all";
	}
}
