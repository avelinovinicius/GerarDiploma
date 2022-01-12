package com.dh.meli.diploma.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.dh.meli.diploma.entity.Aluno;
import com.dh.meli.diploma.entity.Disciplina;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlunoMediaDTO {

    @NotNull
    @Pattern(regexp = "[aA-zZ]+(.)*", message = "Caracter não permitido, apenas letras de a-z")
    @NotEmpty(message = "nome é obrigatório")
    @Size(min = 6, max = 50, message = "tamanho minimo de 8 letras e máximo 50")
    private String nome;
    private BigDecimal media;
    private String message;
    private List<Disciplina> listaDisciplinas;

    public static AlunoMediaDTO converteToMedia(Aluno aluno) {
        AlunoMediaDTO alunoMediaDTO = AlunoMediaDTO.builder().nome(aluno.getNome())
                .media(calculaMedia(aluno.getListaDisciplinas()))
                .message(mensagemMedia(calculaMedia(aluno.getListaDisciplinas())))
                .listaDisciplinas(aluno.getListaDisciplinas())
                .build();
        return alunoMediaDTO;
    }

    public static BigDecimal calculaMedia(List<Disciplina> disciplinaList) {
        return new BigDecimal(disciplinaList.stream().mapToDouble(disciplina -> disciplina.getNota().doubleValue()).sum() / disciplinaList.size()).setScale(2, RoundingMode.HALF_EVEN);
    }

    public static String mensagemMedia(BigDecimal media) {
        if (media.doubleValue() >= 6) {
            return "Você foi aprovado! Sua média: " + media;
        }
        return "Reprovado, media: " + media;
    }
}
