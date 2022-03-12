package br.com.projetoSamiavet.Samiavet.PROJETO.domain;
import javax.persistence.Column;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "produtos")
public class Produtos {

    @Id
    @Column(name ="codigo_barras")
    private String codigoBarras;
    private String nome;
    private Double preco_compra;
    private Double preco_venda;
    private String distribuidora;
    private String empresa;
    private String data_registro;
    private String data_validade;
    private Integer quantidade_estoque;
 
    

    public Produtos(String codigoBarras, String nome, Double preco_compra, Double preco_venda, String distribuidora,
			String empresa, String data_registro, String data_validade, Integer quantidade_estoque) {
		this.codigoBarras = codigoBarras;
		this.nome = nome;
		this.preco_compra = preco_compra;
		this.preco_venda = preco_venda;
		this.distribuidora = distribuidora;
		this.empresa = empresa;
		this.data_registro = data_registro;
		this.data_validade = data_validade;
		this.quantidade_estoque = quantidade_estoque;
	}

	public Produtos() {

    }

	
    public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco_compra() {
        return preco_compra;
    }

    public void setPrecocompra(Double preco_compra) {
        this.preco_compra = preco_compra;
    }

    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }


    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getData_registro() {
        return data_registro;
    }

    public void setData_registro(String data_registro) {
        this.data_registro = data_registro;
    }

    public String getData_validade() {
        return data_validade;
    }

    public void setData_validade(String data_validade) {
        this.data_validade = data_validade;
    }

    public Integer getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(Integer quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public Double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_compra(Double preco_compra) {
        this.preco_compra = preco_compra;
    }


	

	
    
}
