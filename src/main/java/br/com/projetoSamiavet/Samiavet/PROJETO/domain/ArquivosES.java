package br.com.projetoSamiavet.Samiavet.PROJETO.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="arquivosES")
public class ArquivosES {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nomeArquivo;

	
	private String tipoArquivo;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomeArquivo() {
		return nomeArquivo;
	}


	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	
	
	
	public String getTipoArquivo() {
		return tipoArquivo;
	}


	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}


	public ArquivosES() {
		
	}


	public ArquivosES(Long id, String nomeArquivo, String tipoArquivo) {
		this.id = id;
		this.nomeArquivo = nomeArquivo;
		this.tipoArquivo = tipoArquivo;
	}
	
	
	
	
}
