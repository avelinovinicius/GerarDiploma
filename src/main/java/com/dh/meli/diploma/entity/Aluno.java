package com.dh.meli.diploma.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tb_aluno")
public class Aluno{

	public Aluno(long l, String string, String string2, int i) {
		// TODO Auto-generated constructor stub
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private int idade;

    @JsonIgnoreProperties("alunos")
    @ManyToMany
    @JoinTable(name = "aluno_disciplina",
            joinColumns = @JoinColumn(name = "id_aluno"),
            inverseJoinColumns = @JoinColumn(name = "id_disciplina"))
    private List<Disciplina>disciplinas;
  
}
