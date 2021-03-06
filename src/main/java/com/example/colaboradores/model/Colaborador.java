package com.example.colaboradores.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "colaborador")
public class Colaborador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome")
	@Size(min = 1, max = 50)
	@NotNull
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "Sobrenome é obrigatório")
	@Size(min = 1, max = 50)
	private String sobrenome;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_empregador",referencedColumnName = "id")
	@JsonIgnoreProperties("colaboradores")
	private Empregador empregador;
	
	public Empregador getEmpregador() {
		return empregador;
	}
	public void setEmpregador(Empregador empregador) {
		this.empregador = empregador;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	@Override
	public String toString() {
		return "Colaborador [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + "]";
	}


		
}
