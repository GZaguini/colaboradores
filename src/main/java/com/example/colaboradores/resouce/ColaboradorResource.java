package com.example.colaboradores.resouce;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.colaboradores.model.Colaborador;
import com.example.colaboradores.repository.ColaboradorRepository;
import com.example.colaboradores.service.ColaboradorService;

//@CrossOrigin(origins = {"http://localhost:4200","http://127.0.0.1:8887"})
@RestController
@RequestMapping("/colaborador")
public class ColaboradorResource {

	@Autowired
	private ColaboradorService colaboradorService;

	@GetMapping
	public List<Colaborador> buscarTodos(){
		return colaboradorService.buscarTodos();
	}
	@GetMapping("/{id}")
	public Colaborador buscarPorId(@PathVariable Integer id) {
		return colaboradorService.buscarPorId(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Colaborador criar(@Valid @RequestBody Colaborador colaborador) {
		return colaboradorService.criar(colaborador);
	}
	
	@DeleteMapping("/{id}")
	public void removerPorId(@PathVariable Integer id) {
		 colaboradorService.removerPorId(id);
	}
	
	@PutMapping("/{id}")
	public Colaborador atulizar(@PathVariable Integer id,@RequestBody Colaborador colaborador) {
		return colaboradorService.atulizar(id, colaborador);
	}
	
	
	 @PatchMapping("/{id}")   //atualização parcial
	 public Colaborador atulizarParcial(@PathVariable Integer id,@RequestBody Colaborador colaborador) {
		 return colaboradorService.atulizarParcial(id, colaborador);
	 }
}
