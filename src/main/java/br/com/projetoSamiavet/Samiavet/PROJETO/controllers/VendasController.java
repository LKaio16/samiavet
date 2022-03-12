package br.com.projetoSamiavet.Samiavet.PROJETO.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Produtos;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Vendas;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.ProdutosService;
import br.com.projetoSamiavet.Samiavet.PROJETO.service.VendasService;

@RestController
@RequestMapping("/vendas")
public class VendasController {
	@Autowired
	private VendasService vendasService;
	
	@Autowired 
	private ProdutosService produtosService;
	
	
	@Autowired
	public VendasController(VendasService vendasService) {
		this.vendasService = vendasService;
	}
	public VendasService getVendasService() {
		return vendasService;
	}
	public void setVendasService(VendasService vendasService) {
		this.vendasService = vendasService;
	}
	
	@PostMapping("/salvar")
	public Vendas cadastrar(@RequestBody Vendas vendas) {
		
		
		return this.vendasService.cadastrar(vendas);
		
	}
	
	@GetMapping("/listar")
	public List<Vendas> listar(){
		return this.vendasService.getVendasRepository().findAll();
	}
	
	@GetMapping("/listar/{id}")
	public List<Vendas> listarId(@PathVariable Long id){
		return this.vendasService.getVendasRepository().findByIdVenda(id);
	}
	
	
}
