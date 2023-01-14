package com.api.java.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.java.DTO.endereco.DadosCadastroEndereco;
import com.api.java.DTO.endereco.DadosDetalhamentoEndereco;
import com.api.java.DTO.endereco.DadosListagemEndereco;
import com.api.java.entities.Endereco;
import com.api.java.entities.Pessoa;
import com.api.java.repositories.EnderecoRepository;
import com.api.java.repositories.PessoaRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private EnderecoRepository repository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@PostMapping("/{id}")
	@Transactional
	public ResponseEntity<DadosDetalhamentoEndereco> create(@RequestBody DadosCadastroEndereco dados, @PathVariable Long id, UriComponentsBuilder uriBuilder) {

		var pessoa = pessoaRepository.getReferenceById(id);

		var Endereco = new Endereco(null, dados.logradouro(), dados.cep(), dados.numero(), dados.cidade(), pessoa);

		pessoa.getEnderecos().add(Endereco);

		pessoaRepository.save(pessoa);

		repository.save(Endereco);

		var uri = uriBuilder.path("/enderecos/{id}").buildAndExpand(Endereco.getId()).toUri();

		return ResponseEntity.created(uri).body(new DadosDetalhamentoEndereco(Endereco));

	}

	@GetMapping("/{id}")
	public ResponseEntity<List<DadosListagemEndereco>> findEnderecosById(@PathVariable Long id) {

		Pessoa pessoa = pessoaRepository.getReferenceById(id);

		var lista = pessoa.getEnderecos().stream().map(DadosListagemEndereco::new).toList();
		return ResponseEntity.ok().body(lista);

	}

}
