package com.dh.meli.tests;

import com.dh.meli.diploma.dto.AlunoDTO;
import com.dh.meli.diploma.entity.Aluno;

public class Factory {

	public static Aluno createAluno() {
		Aluno aluno = new Aluno(1L, "Vinicius", "Rua Clemente Rocha, 21", 21);
		return aluno;
	}

	public static AlunoDTO createAlunoDTO() {
		AlunoDTO aluno = new AlunoDTO(1L, "Vinicius", "Rua Clemente Rocha, 21", 21);
		return aluno;
	}

}
