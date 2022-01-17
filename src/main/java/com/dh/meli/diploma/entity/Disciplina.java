package com.dh.meli.diploma.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tb_disciplina")
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private Double nota;

	@Override
	public String toString() {
		return "Disciplina{" + "descricao='" + descricao + '\'' + ", nota=" + nota + '}';

	}

	@ManyToOne()
	@JoinColumn(name="aluno_id")
	private List<Aluno> listaAluno;
}