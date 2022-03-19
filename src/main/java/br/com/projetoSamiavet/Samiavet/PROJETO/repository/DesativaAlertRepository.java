package br.com.projetoSamiavet.Samiavet.PROJETO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.DesativaAlert;

public interface DesativaAlertRepository extends JpaRepository<DesativaAlert, Integer>{

	
	List<DesativaAlert> findByData(String data);
}
