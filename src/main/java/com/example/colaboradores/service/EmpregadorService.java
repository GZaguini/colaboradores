package com.example.colaboradores.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.colaboradores.model.Empregador;
import com.example.colaboradores.repository.EmpregadorRepository;

@Service
public class EmpregadorService {
	
	@Autowired 
	private EmpregadorRepository empregadorRepository;
	
	public List<Empregador> buscarTodosEmpregadores(){
		return empregadorRepository.findAll();
	}
	
	public Empregador buscarPorIdEmpregador( Integer id) {
		Optional<Empregador> opt = empregadorRepository.findById(id);
		if(opt.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empregador n\u00E3o encontrado");
		}
		return opt.get();
	}
	
	public Empregador criaEmpregador( Empregador empregador) {
		empregador.setId(null);
		return empregadorRepository.save(empregador);
	}
	
	public void removerEmpregador( Integer id) {
		empregadorRepository.deleteById(id);
	}
	
	public Empregador atulizarEmpregador( Integer id, Empregador empregador) {
		Optional<Empregador> opt = empregadorRepository.findById(id);
		buscarPorIdEmpregador(id);
		empregador.setId(id);
		return empregadorRepository.save(empregador);
	}
	
	
}
