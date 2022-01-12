package com.dh.meli.diploma.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Disciplina {
	private String descricao;
	private Double nota;

	@Override
	public String toString() {
		return "Disciplina{" + "descricao='" + descricao + '\'' + ", nota=" + nota + '}';

	}
}