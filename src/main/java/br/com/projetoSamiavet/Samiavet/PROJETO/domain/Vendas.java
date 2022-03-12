package br.com.projetoSamiavet.Samiavet.PROJETO.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "VENDAS")
public class Vendas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_venda")
	private Long idVenda;
	private Double valor;
	private Double taxa;
	private int parcelas;
	private String data_venda;
	private String nome_cliente;
	private String cpf;
	private String forma_pagamento;
	
	
	@OneToMany(fetch = FetchType.LAZY)
    private List<Produtos> produtos= new ArrayList<Produtos>();

	
	public Vendas() {
	}

	


	public Vendas(Long id_venda, Double valor, Double taxa, int parcelas, String data_venda,
			String nome_cliente, String cpf, String forma_pagamento, List<Produtos> produtos) {
		this.idVenda = id_venda;
		this.valor = valor;
		this.taxa = taxa;
		this.parcelas = parcelas;
		this.data_venda = data_venda;
		this.nome_cliente = nome_cliente;
		this.cpf = cpf;
		this.forma_pagamento = forma_pagamento;
		this.produtos = produtos;
	}



	public Long getId_venda() {
		return idVenda;
	}

	public void setId_venda(Long id_venda) {
		this.idVenda = id_venda;
	}

	

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public String getData_venda() {
		return data_venda;
	}

	public void setData_venda(String data_venda) {
		this.data_venda = data_venda;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getForma_pagamento() {
		return forma_pagamento;
	}

	public void setForma_pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}



	public List<Produtos> getProdutos() {
		return produtos;
	}



	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}




	public Long getIdVenda() {
		return idVenda;
	}




	public void setIdVenda(Long idVenda) {
		this.idVenda = idVenda;
	}
	
	
	
}
	
	
	

