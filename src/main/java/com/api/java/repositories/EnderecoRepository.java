package com.api.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.java.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
