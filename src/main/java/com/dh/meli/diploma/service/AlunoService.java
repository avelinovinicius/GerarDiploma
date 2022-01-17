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

import javax.transaction.Transactional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional
    public AlunoDTO adicionaAluno(Aluno aluno) throws IOException {

        return AlunoDTO.converteToDTO(alunoRepository.save(aluno));

    }
    @Transactional
    public List<AlunoDTO> getListaAlunos() {
        return AlunoDTO.converte(alunoRepository.findAll());
    }

    @Transactional
    public AlunoDTO getStudantById(Long id) {
        try {
            return AlunoDTO.converteToDTO(alunoRepository.getById(id));

        } catch (BusinessException e) {
            throw new BusinessException(e.getMessage());
        }

    }
    @Transactional
    public AlunoMediaDTO getAlunoComMedia(Long id) {
        try {
            return AlunoMediaDTO.converteToMedia(alunoRepository.getById(id));
        } catch (BusinessException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Transactional
    public AlunoDTO alterarAluno(Long id, Aluno aluno) {
        try {
            aluno.setId(id);
            return AlunoDTO.converteToDTO(alunoRepository.save(aluno));
        } catch (BusinessException e) {
            throw new BusinessException("Aluno não encontrado");
        }

    }
    @Transactional
    public void removerAluno(Long id) {
        try {
            alunoRepository.deleteById(id);
        } catch (BusinessException e) {
            throw new BusinessException("ID "+ id + "not found");
        }
    }
}
