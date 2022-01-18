package com.dh.meli.diploma.entity;

import java.util.ArrayList;
import java.util.List;

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

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private int idade;

    @OneToMany(cascade=CascadeType.PERSIST, mappedBy = "aluno")
    @JoinColumn(name="disciplina_id", nullable = false)
    private List<Disciplina> listaDisciplinas = new ArrayList<>();

  
}
