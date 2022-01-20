package com.dh.meli.diploma.service;

import com.dh.meli.diploma.dto.DisciplinaDTO;
import com.dh.meli.diploma.entity.Disciplina;
import com.dh.meli.diploma.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repository;

    public DisciplinaDTO save(Disciplina disciplina)
    {
        return DisciplinaDTO.converteToDTO(repository.save(disciplina));
    }

}
