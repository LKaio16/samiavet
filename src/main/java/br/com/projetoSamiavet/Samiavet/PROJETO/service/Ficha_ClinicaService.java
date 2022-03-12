package br.com.projetoSamiavet.Samiavet.PROJETO.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.FichaClinica;
import br.com.projetoSamiavet.Samiavet.PROJETO.repository.Ficha_ClinicaRepository;

@Service
public class Ficha_ClinicaService {
@Autowired
private Ficha_ClinicaRepository ficha_clinica_repository;

public Ficha_ClinicaRepository getFicha_clinica_repository() {
	return ficha_clinica_repository;
}

public Boolean salvarFicha(FichaClinica ficha, Integer id) {

	Integer idEncontrado = buscarId(id);
	
	Integer emailDigitado = ficha.getIdentificador();
	
	Boolean validacao = false;
	if(idEncontrado == null ) {
	this.ficha_clinica_repository.save(ficha);
	validacao = true;
	}else if(idEncontrado == emailDigitado) {
	validacao = false;
	}
	return validacao;
}

public Integer buscarId(Integer id) {
	List<FichaClinica> listaFichas = this.ficha_clinica_repository.findByIdentificador(id);
	
	Integer idEncontrado = null;
	for(FichaClinica x : listaFichas) {
	idEncontrado = x.getIdentificador();
	}
		return idEncontrado;
}

public void excluir(Integer id) {

	this.ficha_clinica_repository.deleteById(id);
}

public Boolean editarFicha(FichaClinica ficha, Integer id) {

	Integer idEncontrado = buscarId(id);
	
	Integer emailDigitado = ficha.getIdentificador();

	Boolean validacao = false;
		if(idEncontrado == null ) {
		validacao = false;
		
		}else {
		this.ficha_clinica_repository.save(ficha);
		
		validacao = true;
		}
	return validacao;

}

public List<FichaClinica> listar(){
	return this.ficha_clinica_repository.findAll();
}

public List<FichaClinica> listarPorNome(String nome){
	return this.ficha_clinica_repository.findByNomeAnimal(nome);
}

}