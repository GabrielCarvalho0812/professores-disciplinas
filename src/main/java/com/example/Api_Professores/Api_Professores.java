package com.example.Api_Professores;

import com.example.Api_Professores.service.CrudDisciplinaService;
import com.example.Api_Professores.service.CrudProfessorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Api_Professores implements CommandLineRunner {
    private CrudProfessorService professorService;
    private CrudDisciplinaService disciplinaService;

    public Api_Professores(CrudProfessorService professorService, CrudDisciplinaService disciplinaService){
        this.professorService = professorService;
        this.disciplinaService = disciplinaService;

    }

    public static void main(String[] args) {
        SpringApplication.run(Api_Professores.class,args);

    }

    @Override
    public void run(String... args) throws Exception {
        boolean istrue = true;
        Scanner scanner = new Scanner(System.in); //para ler dados de entrada do teclado

        while (istrue){  //enquanto is true for verdadeiro
            System.out.println("qual entidade voce deseja interagir?");
            System.out.println("0 - parar a aplicação");
            System.out.println("1 - professor");
            System.out.println("2 - Disciplina");

            int opcao = scanner.nextInt();

            switch (opcao){
                case 0:
                    System.out.println();
                    System.out.println("DESENVOLVIDO POR GABRIEL CARVALHO ABRAÇOS!!");
                    System.exit(0);
                case 1 :
                    this.professorService.menu(scanner);
                    break;

                case 2 :
                    this.disciplinaService.menu(scanner);
                    break;

                default:
                    istrue = false;
                    break;
            }
        }
    }
}


