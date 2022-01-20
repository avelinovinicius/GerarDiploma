package com.dh.meli.diploma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dh.meli.diploma.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {



}
