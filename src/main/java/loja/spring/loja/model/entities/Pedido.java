package loja.spring.loja.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToMany()
	private List<Produto> produtos = new ArrayList<>(); 

	@ManyToOne(fetch = FetchType.EAGER) 
	//automaticamente quando eu pesquisar pelo pedido, virá o cliente junto
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco cliente_endereco;

	public Pedido() {
	}

	public Pedido(int id, List<Produto> produtos, Cliente cliente, Endereco endereco) {
		super();
		this.id = id;
		this.produtos = produtos;
		this.cliente = cliente;
		this.cliente_endereco = endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Produto> getProduto() {
		return produtos;
	}

	public void setProduto(List<Produto> produto) {
		this.produtos = produto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return cliente_endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.cliente_endereco = endereco;
	}
	
	
}
