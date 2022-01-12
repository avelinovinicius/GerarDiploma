package com.dh.meli.diploma.repository;

import com.dh.meli.diploma.entity.Aluno;
import com.dh.meli.diploma.helper.DatabaseHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoRepository {
    private ObjectMapper objectMapper = DatabaseHelper.getObjectMapper();
    private String PATH = DatabaseHelper.getDatabasePathStudents();
    private List<Aluno> alunos = new ArrayList<>(DatabaseHelper.getDatabaseStudent());

    public List<Aluno> getAll() {
        return new ArrayList<>(alunos);
    }

    public Aluno getById(Long id) {
        return alunos.stream().filter(aluno -> aluno.getId().equals(id)).findFirst().orElse(null);
    }

    public Aluno save(Aluno aluno) throws IOException{
        try{
            aluno.setId((long) alunos.size()+1);
            alunos.add(aluno);
            updateFile();
        }catch (IOException e){
            throw new IOException("Erro na leitura do arquivo");
        }
        return aluno;
    }

    public Aluno alterarAluno(Long id, Aluno aluno) throws IOException {

        Aluno student = alunos.stream().filter(al -> al.getId().equals(id)).findFirst().orElse(null);
        alunos.set(alunos.indexOf(student), aluno);
        updateFile();
        return aluno;
    }

    public String excluirAluno(Long id) throws IOException {
        Aluno student = alunos.stream().filter(al -> al.getId().equals(id)).findFirst().orElse(null);
      alunos.removeIf(al -> al.getId().equals(id));

      updateFile();
        return "ALUNO REMOVIDO: " + student.getNome();
    }

    public void updateFile() throws IOException
    {
        try {
            objectMapper.writeValue(new File(PATH), this.alunos);
        }catch (IOException e){
            throw new IOException("Erro na leitura do arquivo");
        }
    }


}
