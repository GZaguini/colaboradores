package com.example.colaboradores.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "empregador")
public class Empregador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Nome é obrigatório")
	@Size(max = 150)
	@NotNull
	private String nome;
	@Size(max = 18)
	@NotNull
	@NotBlank(message = "Identificador é obrigatório")
	private String identificador;
	
	@OneToMany 
	@JoinColumn(name = "id_empregador")
	@JsonIgnoreProperties("empregador")
	private List<Colaborador> colaboradores;
	
	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}
	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
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
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	@Override
	public String toString() {
		return "Empregador [id=" + id + ", nome=" + nome + ", identificador=" + identificador + "]";
	}
	
	
}
