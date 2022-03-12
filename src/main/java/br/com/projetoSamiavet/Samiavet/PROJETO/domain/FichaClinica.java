package br.com.projetoSamiavet.Samiavet.PROJETO.domain;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ficha")
public class FichaClinica {
@Id
private Integer identificador;
private String nome_proprietario;
private String telefone;
private String email;
private String endereco;
private String cpf;
@Column(name="nomeanimal")
private String nomeAnimal;
private String especie_animal;
private String raca_animal;
private String sexo_animal;
private String historico_animal;
private Double fc_animal;
private Double fr_animal;
private Double p_animal;
private Double t_animal;
private String data_nascimento_animal;
private String pelugem_animal;
private String peso_animal;
private String data_registro_animal;


public FichaClinica( Integer id, String nome_proprietario, String telefone, String email, String endereco,
String cpf, String nome_animal, String especie_animal, String raca_animal, String sexo_animal,
String historico_animal, Double fc_animal, Double fr_animal, Double p_animal, Double t_animal,
String data_nascimento_animal, String pelugem_animal, String peso_animal, String data_registro_animal) {
this.identificador = id;
this.nome_proprietario = nome_proprietario;
this.telefone = telefone;
this.email = email;
this.endereco = endereco;
this.cpf = cpf;
this.nomeAnimal = nome_animal;
this.especie_animal = especie_animal;
this.raca_animal = raca_animal;
this.sexo_animal = sexo_animal;
this.historico_animal = historico_animal;
this.fc_animal = fc_animal;
this.fr_animal = fr_animal;
this.p_animal = p_animal;
this.t_animal = t_animal;
this.data_nascimento_animal = data_nascimento_animal;
this.pelugem_animal = pelugem_animal;
this.peso_animal = peso_animal;
this.data_registro_animal = data_registro_animal;


}

public FichaClinica() {

}

public Integer getIdentificador() {
return identificador;
}

public void setIdentificador(Integer id) {
this.identificador = id;
}

public String getNome_proprietario() {
return nome_proprietario;
}
public void setNome_proprietario(String nome_proprietario) {
this.nome_proprietario = nome_proprietario;
}
public String getTelefone() {
return telefone;
}
public void setTelefone(String telefone) {
this.telefone = telefone;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public String getEndereco() {
return endereco;
}
public void setEndereco(String endereco) {
this.endereco = endereco;
}
public String getCpf() {
return cpf;
}
public void setCpf(String cpf) {
this.cpf = cpf;
}

public String getNomeAnimal() {
return nomeAnimal;
}

public void setNomeAnimal(String nomeAnimal) {
this.nomeAnimal = nomeAnimal;
}

public String getEspecie_animal() {
return especie_animal;
}
public void setEspecie_animal(String especie_animal) {
this.especie_animal = especie_animal;
}
public String getRaca_animal() {
return raca_animal;
}
public void setRaca_animal(String raca_animal) {
this.raca_animal = raca_animal;
}
public String getSexo_animal() {
return sexo_animal;
}
public void setSexo_animal(String sexo_animal) {
this.sexo_animal = sexo_animal;
}
public String getHistorico_animal() {
return historico_animal;
}
public void setHistorico_animal(String historico_animal) {
this.historico_animal = historico_animal;
}
public Double getFc_animal() {
return fc_animal;
}
public void setFc_animal(Double fc_animal) {
this.fc_animal = fc_animal;
}
public Double getFr_animal() {
return fr_animal;
}
public void setFr_animal(Double fr_animal) {
this.fr_animal = fr_animal;
}
public Double getP_animal() {
return p_animal;
}
public void setP_animal(Double p_animal) {
this.p_animal = p_animal;
}
public Double getT_animal() {
return t_animal;
}
public void setT_animal(Double t_animal) {
this.t_animal = t_animal;
}
public String getData_nascimento_animal() {
return data_nascimento_animal;
}
public void setData_nascimento_animal(String data_nascimento_animal) {
this.data_nascimento_animal = data_nascimento_animal;
}
public String getPelugem_animal() {
return pelugem_animal;
}
public void setPelugem_animal(String pelugem_animal) {
this.pelugem_animal = pelugem_animal;
}
public String getPeso_animal() {
return peso_animal;
}
public void setPeso_animal(String peso_animal) {
this.peso_animal = peso_animal;
}
public String getData_registro_animal() {
return data_registro_animal;
}
public void setData_registro_animal(String data_registro_animal) {
this.data_registro_animal = data_registro_animal;
}


}