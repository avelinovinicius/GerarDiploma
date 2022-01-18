package com.dh.meli.diploma.repository;

import com.dh.meli.diploma.entity.Aluno;
import com.dh.meli.diploma.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {



}
