package br.com.projetoSamiavet.Samiavet.PROJETO.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="servicosPrestados")
public class ServicosPrestados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_servico")
	private Long idServico;
	private Double valor;
	private int parcelas;
	private String data;
	private String nome_cliente;
	private String forma_pagamento;
	private String descricao;
	private String tipo;
	private String nomeAnimal;


	

	public ServicosPrestados(Long idServico, Double valor, Double taxa, int parcelas, String data_venda,
			String nome_cliente, String cpf, String forma_pagamento, String descricao, String tipo, String nomeAnimal) {
		
		this.idServico = idServico;
		this.valor = valor;
		this.parcelas = parcelas;
		this.data = data_venda;
		this.nome_cliente = nome_cliente;
		this.forma_pagamento = forma_pagamento;
		this.descricao = descricao;
		this.tipo = tipo;
		this.nomeAnimal = nomeAnimal;
	}



	public ServicosPrestados() {
	
	}



	public Long getIdServico() {
		return idServico;
	}



	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}



	public Double getValor() {
		return valor;
	}



	public void setValor(Double valor) {
		this.valor = valor;
	}


	public int getParcelas() {
		return parcelas;
	}



	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}



	public String getNome_cliente() {
		return nome_cliente;
	}



	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}


	public String getForma_pagamento() {
		return forma_pagamento;
	}



	public void setForma_pagamento(String forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}



	public String getTitulo() {
		return descricao;
	}



	public void setTitulo(String titulo) {
		this.descricao = titulo;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getNomeAnimal() {
		return nomeAnimal;
	}



	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}
	
	
	
}
