package br.com.projetoSamiavet.Samiavet.PROJETO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Produtos;
import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Vendas;
import br.com.projetoSamiavet.Samiavet.PROJETO.repository.VendasRepository;

@Service
public class VendasService {

	
	private VendasRepository vendasRepository;
	
	@Autowired
	public VendasService(VendasRepository vendasRepository) {
		this.vendasRepository = vendasRepository;
	}

	public VendasRepository getVendasRepository() {
		return vendasRepository;
	}

	public Vendas cadastrar(Vendas vendas) {
		
		return this.vendasRepository.save(vendas);
		
	}
	
	public List<Vendas> listar(){
		return this.vendasRepository.findAll();
	}
	
	public void deletarTudo() {
		this.vendasRepository.deleteAll();
	}
	
}
