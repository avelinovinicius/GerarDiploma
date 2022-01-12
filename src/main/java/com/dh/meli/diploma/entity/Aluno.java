package com.dh.meli.diploma.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Aluno{
	
    private Long id;
    private String nome;
    private String endereco;
    private int idade;
    private List<Disciplina> listaDisciplinas;

  
}
