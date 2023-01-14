package com.api.java.infra.configuration;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.api.java.entities.Endereco;
import com.api.java.entities.Pessoa;
import com.api.java.repositories.EnderecoRepository;
import com.api.java.repositories.PessoaRepository;

@Configuration
public class SeedConfiguration {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

    @Bean
    void seed() {
/*
        Pessoa pessoa = new Pessoa("William", LocalDate.now(), null);
        Endereco endereco = new Endereco(null, "Rua Reginaldo Rodrigues Montenegro", "54100020", "493", "Jaboatão dos Guararapes", pessoa);
        Endereco endereco2 = new Endereco(null, "Padre roma", "54100090", "7093", "Jaboatão dos Guararapes", pessoa);

        pessoaRepository.save(pessoa);
        enderecoRepository.save(endereco);
        enderecoRepository.save(endereco2);
*/
    }
	
}