package com.example.colaboradores.resouce;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.colaboradores.model.Empregador;
import com.example.colaboradores.service.EmpregadorService;

//@CrossOrigin(origins = "")
@RestController
@RequestMapping("/empregador")
public class EmpregadorResource {
	
	@Autowired
	private EmpregadorService empregadorService;
	
	@GetMapping
	public List<Empregador> buscarTodosEmpregadores(){
		System.out.println("aqui");
		return empregadorService.buscarTodosEmpregadores();
	}
	
	@GetMapping("/{id}")
	public Empregador buscarPorIdEmpregador(@PathVariable Integer id) {
		return empregadorService.buscarPorIdEmpregador(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Empregador criarEmpregador(@RequestBody Empregador empregador) {
		return empregadorService.criaEmpregador(empregador);
	}
	
	@DeleteMapping("/{id}")
	public void removerEmpregador(@PathVariable Integer id) {
		empregadorService.removerEmpregador(id);
	}
	@PutMapping("/{id}")
	public Empregador atulizarEmpregador(@PathVariable Integer id,@RequestBody Empregador empregador) {
		return empregadorService.atulizarEmpregador(id, empregador);
	}
}
