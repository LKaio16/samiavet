package br.com.projetoSamiavet.Samiavet.PROJETO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.DesativaAlert;
import br.com.projetoSamiavet.Samiavet.PROJETO.repository.DesativaAlertRepository;

@Service
public class DesativaAlertService {

	
	
	@Autowired
	private DesativaAlertRepository desativaAlertRepository;

	public DesativaAlertService(DesativaAlertRepository desativaAlertRepository) {
		
		this.desativaAlertRepository = desativaAlertRepository;
	}
	
	public void cadastrar(DesativaAlert desativaAlert) {
		this.desativaAlertRepository.save(desativaAlert);
	}
	
	public String retornaData(String data) {
		List<DesativaAlert> lista = this.desativaAlertRepository.findByData(data);
		
		
		String retornaData = null;
		
		for(DesativaAlert x : lista) {
			retornaData = x.getData();
		}
		
		return retornaData;
	}
	
	public List<DesativaAlert> lista(){
		return this.desativaAlertRepository.findAll();
	}
}
