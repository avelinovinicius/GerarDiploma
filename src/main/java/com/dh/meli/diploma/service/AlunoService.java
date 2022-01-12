package com.dh.meli.diploma.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.dh.meli.diploma.dto.AlunoDTO;
import com.dh.meli.diploma.dto.AlunoMediaDTO;
import com.dh.meli.diploma.entity.Aluno;
import com.dh.meli.diploma.exception.BusinessException;
import com.dh.meli.diploma.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;


    public AlunoDTO adicionaAluno(Aluno aluno) throws IOException {

        return AlunoDTO.converteToDTO(alunoRepository.save(aluno));

    }

    public List<AlunoDTO> getListaAlunos() {
        return AlunoDTO.converte(alunoRepository.getAll());
    }

    public AlunoDTO getStudantById(Long id) {
        try {
            return AlunoDTO.converteToDTO(alunoRepository.getById(id));

        } catch (BusinessException e) {
            throw new BusinessException(e.getMessage());
        }

    }

    public AlunoMediaDTO getAlunoComMedia(Long id) {
        try {
            return AlunoMediaDTO.converteToMedia(alunoRepository.getById(id));
        } catch (BusinessException e) {
            throw new BusinessException(e.getMessage());
        }
    }


    public AlunoDTO alterarAluno(Long id, Aluno aluno) {
        try {
            aluno.setId(id);
            return AlunoDTO.converteToDTO(alunoRepository.alterarAluno(id, aluno));
        } catch (BusinessException | IOException e) {
            throw new BusinessException(e.getMessage());
        }

    }

    public String removerAluno(Long id) {
        try {
            return alunoRepository.excluirAluno(id);
        } catch (BusinessException | IOException e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
