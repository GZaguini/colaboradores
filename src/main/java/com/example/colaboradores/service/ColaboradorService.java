package com.example.colaboradores.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.colaboradores.model.Colaborador;
import com.example.colaboradores.repository.ColaboradorRepository;

@Service 
public class ColaboradorService {
	
	@Autowired //injeção de dependêcia
	private ColaboradorRepository colaboradorRepository;
	
	public List<Colaborador> buscarTodos(){
		return colaboradorRepository.findAll();
	}
	public Colaborador buscarPorId( Integer id) {
		Optional<Colaborador> opt = colaboradorRepository.findById(id);
		if(opt.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Colaborador n\u00E3o encontrado");
		}
		return opt.get();
	}
	
	public Colaborador criar( Colaborador colaborador) {
		colaborador.setId(null);
		return colaboradorRepository.save(colaborador);
	}
	
	public void removerPorId( Integer id) {
		colaboradorRepository.deleteById(id);
	}
	
	public Colaborador atulizar( Integer id, Colaborador colaborador) {
		Optional<Colaborador> opt = colaboradorRepository.findById(id);
		buscarPorId(id);
		colaborador.setId(id);
		return colaboradorRepository.save(colaborador);
	}
	
	 public Colaborador atulizarParcial( Integer id, Colaborador colaborador) {
		 Colaborador colaboradorSalvo = buscarPorId(id);
		 colaborador.setId(id);
		 if(colaborador.getNome() != null) {
			 colaboradorSalvo.setNome( colaborador.getNome());
		 }
		 if(colaborador.getSobrenome() != null) {
			 colaboradorSalvo.setSobrenome( colaborador.getSobrenome());	
		 }
		 return colaboradorRepository.save(colaborador);
	 }
}
