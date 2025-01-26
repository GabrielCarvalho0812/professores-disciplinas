package com.example.Api_Professores.service;

import com.example.Api_Professores.models.Professor;
import com.example.Api_Professores.repositories.ProfessorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



import java.util.Optional;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CrudProfessorServiceTest {

    @InjectMocks
    CrudProfessorService crudProfessorService;

    @Mock
    ProfessorRepository professorRepository;

    private Scanner scanner;


    @BeforeEach
    public void setUp(){
        professorRepository = mock(ProfessorRepository.class); // Mock do repositório
        scanner = mock(Scanner.class); // Mock do scanner
        crudProfessorService = new CrudProfessorService(professorRepository);
    }



    @Test
    void deveAutualizarProfessor(){
        Long id = 1L;
        String nome = "João Silva";
        Professor professor = new Professor(id, "Antônio", "Matemática");


        when(scanner.nextLong()).thenReturn(id); // Simula a entrada do id do professor
        when(scanner.next()).thenReturn(nome); // Simula a entrada do nome do professor
        when(professorRepository.findById(id)).thenReturn(Optional.of(professor)); // Simula que o professor com o id 1 existe
        doNothing().when(professorRepository).save(professor);

        var outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));

        crudProfessorService.autualizar(scanner);

        verify(professorRepository).save(professor);
        assertTrue(outputStream.toString().contains("Professor autualizado com sucesso!"));





    }

}
