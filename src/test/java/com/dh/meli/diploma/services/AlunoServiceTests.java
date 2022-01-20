package com.dh.meli.diploma.services;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dh.meli.diploma.dto.AlunoDTO;
import com.dh.meli.diploma.entity.Aluno;
import com.dh.meli.diploma.repository.AlunoRepository;
import com.dh.meli.diploma.service.AlunoService;
import com.dh.meli.tests.Factory;

@ExtendWith(SpringExtension.class)
public class AlunoServiceTests {

    @InjectMocks
    private AlunoService service;

    @Mock
    private AlunoRepository repository;

    private long existingId;
    private long nonExistingId;
    private Aluno aluno;
    private AlunoDTO alunoDTO;
    
    @BeforeEach
    void setUp() throws Exception
    {
        existingId = 1L;
        nonExistingId = 2L;
        aluno = Factory.createAluno();
        alunoDTO = Factory.createAlunoDTO();
        
        Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(aluno);
             
    }
    
   
    @Test
    public void adicionaAlunoShouldSave() throws IOException
    {
    	
    	AlunoDTO result = service.adicionaAluno(alunoDTO);
    	
    	Assertions.assertNotNull(result);
    	
    	
    }
}
