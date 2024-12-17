package com.example.Api_Professores.service;

import com.example.Api_Professores.models.Professor;
import com.example.Api_Professores.repositories.ProfessorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.lang.reflect.Method;
import java.util.Scanner;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrudProfessorServiceTest {

    @InjectMocks
    CrudProfessorService crudProfessorService;

    @Mock
    ProfessorRepository professorRepository;

    Professor professor;

    @BeforeEach
    public void setUp(){
       professor = new Professor("gabriel");
    }



    @Test
    void deveAutualizarProfessor()throws Exception{







    }



}
