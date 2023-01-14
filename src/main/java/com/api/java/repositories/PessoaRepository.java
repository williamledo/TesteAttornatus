package com.api.java.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.java.DTO.pessoa.DadosListagemPessoa;
import com.api.java.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	List<Pessoa> findAllByAtivoTrue();

}
