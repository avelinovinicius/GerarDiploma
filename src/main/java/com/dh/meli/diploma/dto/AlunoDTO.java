package com.dh.meli.diploma.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.dh.meli.diploma.entity.Aluno;
import com.dh.meli.diploma.entity.Disciplina;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {


	private Long id;
	@NotNull
	@Pattern(regexp = "[aA-zZ]+(.)*", message = "Caracter não permitido, apenas letras de a-z")
	@NotEmpty(message = "nome é obrigatório")
	@Size(min= 6, max=50, message="tamanho minimo de 8 letras e máximo 50")
    private String nome;
    private String endereco;
    private int idade;
    private List<Disciplina> listaDisciplinas;

    public static Aluno converte(AlunoDTO dto)
    {
    	Aluno aluno = Aluno.builder().nome(dto.getNome())
    			.endereco(dto.getEndereco())
    			.idade(dto.getIdade()).listaDisciplinas(dto.getListaDisciplinas())
    			.build();
    	return aluno;
    }
    
    public static AlunoDTO converteToDTO(Aluno aluno)
    {
    	return AlunoDTO.builder().id(aluno.getId()).nome(aluno.getNome())
    			.endereco(aluno.getEndereco())
    			.idade(aluno.getIdade())
    			.listaDisciplinas(aluno.getListaDisciplinas())
    			.build();
    }
    
    public static List<AlunoDTO> converte(List<Aluno> aluno){
		return aluno.stream().map(a -> converteToDTO(a)).collect(Collectors.toList());
	}

}
