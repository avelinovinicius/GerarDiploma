package com.dh.meli.diploma.entity;

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

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="disciplina_id")
    private List<Disciplina> listaDisciplinas;

  
}
