package com.dh.meli.diploma.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.dh.meli.diploma.entity.Disciplina;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class DisciplinaDTO {

	@NotNull
	@Pattern(regexp = "[aA-zZ]", message = "Caracter não permitido, apenas letras de a-z")
	@NotEmpty(message = "nome é obrigatório")
	@Size(min = 8, max = 50, message = "tamanho minimo de 8 letras e máximo 50")
	private String descricao;

	@Size(min = 1, max = 2, message = "A nota deve ter entre 1 e 2 caracteres")
	@Pattern(regexp = "[0-9]", message = "Deve conter caracteres do 0 ao 9")
	private Double nota;

	public static Disciplina converte(DisciplinaDTO dto) {
		Disciplina disc = Disciplina.builder().descricao(dto.getDescricao()).nota(dto.nota).build();
		return disc;
	}

	public static DisciplinaDTO converteToDTO(Disciplina disc) {
		return DisciplinaDTO.builder().descricao(disc.getDescricao()).nota(disc.getNota()).build();
	}

}
