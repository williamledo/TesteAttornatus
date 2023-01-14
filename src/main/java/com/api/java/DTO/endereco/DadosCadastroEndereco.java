package com.api.java.DTO.endereco;

import com.api.java.entities.Pessoa;

public record DadosCadastroEndereco(
		
		Long id,
		
		String logradouro,
		
		String cep,
		
		String numero,
		
		String cidade,

		Pessoa pessoa
		
		) {
	
}