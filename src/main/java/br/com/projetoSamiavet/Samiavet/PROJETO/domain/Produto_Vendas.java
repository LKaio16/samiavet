package br.com.projetoSamiavet.Samiavet.PROJETO.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produto_vendas")
public class Produto_Vendas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@ManyToOne(fetch = FetchType.LAZY)
	private Vendas vendas;

	@ManyToOne(fetch = FetchType.LAZY)
	private Produtos produtos;

}
