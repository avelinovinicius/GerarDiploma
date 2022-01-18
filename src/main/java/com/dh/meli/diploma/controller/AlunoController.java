package com.dh.meli.diploma.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import com.dh.meli.diploma.dto.AlunoMediaDTO;
import com.dh.meli.diploma.entity.Disciplina;
import com.dh.meli.diploma.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dh.meli.diploma.dto.AlunoDTO;
import com.dh.meli.diploma.entity.Aluno;
import com.dh.meli.diploma.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private DisciplinaRepository repository;

    @PostMapping("/cadastra")
    public AlunoDTO cadastrarAluno(@Valid @RequestBody AlunoDTO dto) throws IOException {
        Aluno aluno = AlunoDTO.converte(dto);
        alunoService.adicionaAluno(aluno);
        return AlunoDTO.converteToDTO(aluno);
    }

    @GetMapping("/exibirAlunos")
    public List<AlunoDTO> exibirAlunos() {

        return alunoService.getListaAlunos();
    }

    @GetMapping(value = "/exibirAluno", params = "id")
    public AlunoDTO exibirAluno(@RequestParam Long id) {
        return alunoService.getStudantById(id);
    }

    @GetMapping("/exibirAlunoComMedia/{id}")
    public AlunoMediaDTO exibirAlunoComMedia(@PathVariable Long id) {
        return alunoService.getAlunoComMedia(id);
    }

    @PutMapping("/alterarAluno/{id}")
    public AlunoDTO alteraAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        aluno.setId(id);
        return alunoService.alterarAluno(id, aluno);
    }
    @GetMapping("/exibirDisciplinas")
    public List<Disciplina> exibirDisciplina() {
        return repository.findAll();
    }


    @DeleteMapping("/removerAluno/{id}")
    public ResponseEntity<Void> removeAluno(@PathVariable Long id) {
        alunoService.removerAluno(id);
        return ResponseEntity.noContent().build();
    }

}
