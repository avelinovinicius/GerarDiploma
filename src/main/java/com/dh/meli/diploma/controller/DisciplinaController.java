package com.dh.meli.diploma.controller;

import com.dh.meli.diploma.dto.DisciplinaDTO;
import com.dh.meli.diploma.entity.Disciplina;
import com.dh.meli.diploma.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/disciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaService service;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody DisciplinaDTO dto)
    {
        Disciplina disciplina = DisciplinaDTO.converte(dto);
        return new ResponseEntity<>(service.save(disciplina), HttpStatus.CREATED);
    }
}
