package com.api.java.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.api.java.DTO.pessoa.DadosAtualizacaoPessoa;
import com.api.java.DTO.pessoa.DadosCadastroPessoa;
import com.api.java.DTO.pessoa.DadosDetalhamentoPessoa;
import com.api.java.DTO.pessoa.DadosListagemPessoa;
import com.api.java.entities.Endereco;
import com.api.java.entities.Pessoa;
import com.api.java.repositories.EnderecoRepository;
import com.api.java.repositories.PessoaRepository;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoPessoa> create(@RequestBody DadosCadastroPessoa dados, UriComponentsBuilder uriBuilder) {
		
		var Pessoa = new Pessoa(dados);
		
		var enderecos = new ArrayList<>();
		
		for ( Endereco endereco : Pessoa.getEnderecos()) {
			Endereco novo = new Endereco(endereco.getLogradouro(), endereco.getCep(), endereco.getNumero(), endereco.getCidade(), Pessoa);
			
			enderecos.add(novo);
			enderecoRepository.save(novo);
		}
		
		repository.save(Pessoa);
		
		var uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(Pessoa.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<DadosDetalhamentoPessoa> update(@RequestBody DadosAtualizacaoPessoa dados, @PathVariable Long id) {
		
		Pessoa Pessoa = repository.getReferenceById(id);
		Pessoa.atualizarInformacoes(dados);
		repository.save(Pessoa);
		
		return ResponseEntity.ok().body(new DadosDetalhamentoPessoa(Pessoa));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosDetalhamentoPessoa> detalhar(@PathVariable Long id) {
		
		Pessoa Pessoa = repository.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosDetalhamentoPessoa(Pessoa));
		
	}
	
	@GetMapping
	public ResponseEntity <List<DadosListagemPessoa>> findAll() {
		
		var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemPessoa::new).toList();
		return ResponseEntity.ok().body(lista);
	}
	
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Pessoa Pessoa = repository.getReferenceById(id);
		Pessoa.delete();
		repository.save(Pessoa);
		
		return ResponseEntity.noContent().build();
		
	}
	
	
	
	@PutMapping("/{id_pessoa}/{id_endereco}")
	public ResponseEntity<?> enderecoPrincipal(@PathVariable("id_pessoa") Long id_pessoa, @PathVariable("id_endereco") Long id_endereco) {
		
		var pessoa = repository.getReferenceById(id_pessoa);
		
		pessoa.setEnderecoPrincipal(id_endereco);
		
		repository.save(pessoa);
		
		return ResponseEntity.ok().build();
		
	}
	
}
