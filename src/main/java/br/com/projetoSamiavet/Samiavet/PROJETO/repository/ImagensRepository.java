package br.com.projetoSamiavet.Samiavet.PROJETO.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoSamiavet.Samiavet.PROJETO.domain.ArquivosImagens;

public interface ImagensRepository extends JpaRepository<ArquivosImagens, Long> {

	
	List<ArquivosImagens> findByNomeImagem(String nome);
}
