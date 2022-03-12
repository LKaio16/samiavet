package br.com.projetoSamiavet.Samiavet.PROJETO.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.Agendamento;
import br.com.projetoSamiavet.Samiavet.PROJETO.repository.AgendamentoRepository;

@Service
public class AgendamentoService {
	@Autowired
	private AgendamentoRepository agendamentoRepository;

	public AgendamentoRepository getAgendamentoRepository() {
		return agendamentoRepository;
	}
	
	public Integer salvar(Agendamento agendamento) {
		this.agendamentoRepository.save(agendamento);
		return 1;
	}
	
	public Integer deletar(Long id) {
		this.agendamentoRepository.deleteById(id);
		return 1;
	}
	
	public List<Agendamento> listarAgendamentos(){
		return this.agendamentoRepository.findAll();
	}
	
	public List<Agendamento> retornaPeloNome(String nome){
		return this.agendamentoRepository.findByNomeAnimal(nome);
	}
}
