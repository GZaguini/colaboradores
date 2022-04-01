package com.example.colaboradores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.colaboradores.model.Empregador;

public interface EmpregadorRepository extends JpaRepository<Empregador,Integer> {

}
