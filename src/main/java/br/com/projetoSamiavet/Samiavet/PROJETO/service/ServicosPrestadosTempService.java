package br.com.projetoSamiavet.Samiavet.PROJETO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ServicosPrestadosTemp;
import br.com.projetoSamiavet.Samiavet.PROJETO.repository.ServicosPrestadosTempRepository;

@Service
public class ServicosPrestadosTempService {

	
	@Autowired
	private ServicosPrestadosTempRepository servicosPrestadosTempRepository;
	
	public void cadastrar(ServicosPrestadosTemp servicosPrestadosTemp) {
		this.servicosPrestadosTempRepository.save(servicosPrestadosTemp);
	}
	
	public void cadastrarTodos(List<ServicosPrestadosTemp> listaservicosPrestadosTemp) {
		this.servicosPrestadosTempRepository.saveAll(listaservicosPrestadosTemp);
	}
	
	public void deletarTodos() {
		this.servicosPrestadosTempRepository.deleteAll();
	}
	
	public List<ServicosPrestadosTemp> listar(){
		return this.servicosPrestadosTempRepository.findAll();
	}
	
	public void deletar(Long id) {
		this.servicosPrestadosTempRepository.deleteById(id);
	}
}
