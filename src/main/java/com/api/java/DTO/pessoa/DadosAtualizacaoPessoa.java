package com.api.java.DTO.pessoa;

import java.time.LocalDate;
import java.util.List;

import com.api.java.entities.Endereco;

public record DadosAtualizacaoPessoa(
		
		String nome,
		
		LocalDate dataDeNascimento,
		
		List<Endereco> enderecos,
		
		Long enderecoPrincipal
		
		
		) {

}
