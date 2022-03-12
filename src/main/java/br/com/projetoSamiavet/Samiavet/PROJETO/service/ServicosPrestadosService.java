package br.com.projetoSamiavet.Samiavet.PROJETO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ServicosPrestados;
import br.com.projetoSamiavet.Samiavet.PROJETO.repository.ServicosPrestadosRepository;

@Service
public class ServicosPrestadosService{

	@Autowired
	private ServicosPrestadosRepository servicosPrestadosRepository;

	public ServicosPrestadosService(ServicosPrestadosRepository servicosPrestadosRepository) {
		this.servicosPrestadosRepository = servicosPrestadosRepository;
	}
	
	public void salvar(ServicosPrestados servico) {
		this.servicosPrestadosRepository.save(servico);
	}
	
	public void salvarTodos(List<ServicosPrestados> lista) {
		this.servicosPrestadosRepository.saveAll(lista);
	}
	
	public void deletarTodos() {
		this.servicosPrestadosRepository.deleteAll();
	}
	
	public List<ServicosPrestados> listar(){
		return this.servicosPrestadosRepository.findAll();
	}
	
	public void deletar(Long id) {
		this.servicosPrestadosRepository.deleteById(id);
	}
}
