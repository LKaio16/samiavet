package br.com.projetoSamiavet.Samiavet.PROJETO.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="agendamentos")
public class Agendamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	
	@Column(name="nomeproprietario")
	private String nomeProprietario; 
	
	@Column(name="nomeanimal")
	private String nomeAnimal;
	
	private String atendimento;
	
	@Column(name="datainicio")
	private String dataInicio;
	
	@Column(name="datatermino")
	private String dataTermino;
	
	private String dataInicioSemHora;
	
	private String horaInicioSemData;
	
	
	private String dataTerminoSemHora;
	
	
	private String horaTerminoSemData;
	
	private String observacao;
	

	
	
	
	
	public Agendamento(Long id, String titulo, String nomeProprietario, String nomeAnimal, String atendimento,
			String dataInicio, String dataTermino, String dataInicioSemHora, String horaInicioSemData,
			String dataTerminoSemHora, String horaTerminoSemData, String observacao) {
		this.id = id;
		this.titulo = titulo;
		this.nomeProprietario = nomeProprietario;
		this.nomeAnimal = nomeAnimal;
		this.atendimento = atendimento;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.dataInicioSemHora = dataInicioSemHora;
		this.horaInicioSemData = horaInicioSemData;
		this.dataTerminoSemHora = dataTerminoSemHora;
		this.horaTerminoSemData = horaTerminoSemData;
		this.observacao = observacao;
	}
	public Agendamento() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getNomeProprietario() {
		return nomeProprietario;
	}
	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}
	public String getNomeAnimal() {
		return nomeAnimal;
	}
	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}
	public String getAtendimento() {
		return atendimento;
	}
	public void setAtendimento(String atendimento) {
		this.atendimento = atendimento;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getDataInicioSemHora() {
		return dataInicioSemHora;
	}
	public void setDataInicioSemHora(String dataInicioSemHora) {
		this.dataInicioSemHora = dataInicioSemHora;
	}
	public String getHoraInicioSemData() {
		return horaInicioSemData;
	}
	public void setHoraInicioSemData(String horaInicioSemData) {
		this.horaInicioSemData = horaInicioSemData;
	}
	public String getDataTerminoSemHora() {
		return dataTerminoSemHora;
	}
	public void setDataTerminoSemHora(String dataTerminoSemHora) {
		this.dataTerminoSemHora = dataTerminoSemHora;
	}
	public String getHoraTerminoSemData() {
		return horaTerminoSemData;
	}
	public void setHoraTerminoSemData(String horaTerminoSemData) {
		this.horaTerminoSemData = horaTerminoSemData;
	}
	
	
	
	
}
