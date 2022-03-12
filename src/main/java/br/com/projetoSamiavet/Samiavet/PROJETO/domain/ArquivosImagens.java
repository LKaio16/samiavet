package br.com.projetoSamiavet.Samiavet.PROJETO.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="arquivosimagens")
public class ArquivosImagens {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nomeImagem;


	private String tipoImagem;
	
	
	public ArquivosImagens() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomeImagem() {
		return nomeImagem;
	}


	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}


	public String getTipoImagem() {
		return tipoImagem;
	}


	public void setTipoImagem(String tipoImagem) {
		this.tipoImagem = tipoImagem;
	}
	
	
	
}
