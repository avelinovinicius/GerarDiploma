package com.dh.meli.diploma.helper;

import com.dh.meli.diploma.entity.Aluno;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

public class DatabaseHelper {
    private static final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    private static final String PATH_STUDENTS = "students.json";

    public static List<Aluno> getDatabaseStudent() {
        try {
            File file = new File(PATH_STUDENTS);
            FileInputStream fileInputStream = new FileInputStream(file);
            return Arrays.asList(objectMapper.readValue(fileInputStream, Aluno[].class));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
    public static String getDatabasePathStudents()
    {
        return PATH_STUDENTS;
    }
}