package com.dh.meli.diploma.repository;

import com.dh.meli.diploma.entity.Aluno;
import com.dh.meli.diploma.helper.DatabaseHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {



}
