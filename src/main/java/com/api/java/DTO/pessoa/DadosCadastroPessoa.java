package com.api.java.DTO.pessoa;

import java.time.LocalDate;
import java.util.List;

import com.api.java.entities.Endereco;

public record DadosCadastroPessoa(
		
		String nome,
		
		LocalDate dataDeNascimento,
		
		Long endereco_principal,
		
		List<Endereco> enderecos
		
		) {

}
