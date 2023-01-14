package com.api.java.DTO.pessoa;

import java.time.LocalDate;
import java.util.List;

import com.api.java.entities.Endereco;
import com.api.java.entities.Pessoa;

public record DadosListagemPessoa(Long id, String nome, LocalDate dataDeNascimento, List<Endereco> enderecos, Long enderecoPrincipal) {

	public DadosListagemPessoa(Pessoa pessoa) {
		this(pessoa.getId(), pessoa.getNome(), pessoa.getDataDeNascimento(), pessoa.getEnderecos(), pessoa.getEnderecoPrincipal());
	}
	
}
