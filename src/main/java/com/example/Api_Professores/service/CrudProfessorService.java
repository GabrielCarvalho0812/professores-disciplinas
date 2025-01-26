package com.example.Api_Professores.service;

import com.example.Api_Professores.models.Professor;
import com.example.Api_Professores.repositories.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudProfessorService {
    private ProfessorRepository professorRepository;

    public CrudProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }


    public void menu(Scanner scanner) {
        boolean istrue = true;

        while (istrue) {
            System.out.println("QUAL AÇÃO VOÇE DESEJA EXECUTAR");
            System.out.println();
            System.out.println("0 - voltar ao menu anterior");
            System.out.println("1 - cadastrar novo professor");
            System.out.println("2 - atualizar um professor");
            System.out.println("3 - Visualizar todos os professores");
            System.out.println("4 - Deletar um Professor");


            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    this.cadastrar(scanner);
                    break;

                case 2:
                    this.autualizar(scanner);
                    break;

                case 3:
                    this.visualizar();
                    break;

                case 4:
                    this.deletar(scanner);
                    break;

                default:
                    istrue = false;
                    break;
            }
        }
        System.out.println();
    }


    public void cadastrar(Scanner scanner) {
        System.out.print("digite o nome do professor");
        String nome = scanner.next();
        System.out.println();



        Professor professor = new Professor(nome);

        this.professorRepository.save(professor);
        System.out.println("professor cadastrado com sucesso !!"  + professor);
        System.out.println();

    }


    public void autualizar(Scanner scanner) {
        System.out.println("Digite o ID do Professor a ser autualizado:");
        Long id = scanner.nextLong();

        Optional<Professor> optional = this.professorRepository.findById(id);


        if (optional.isPresent()) {
            System.out.print("digite o nome do professor");
            String nome = scanner.next();

            Professor professor = optional.get();
            professorRepository.save(professor);
            System.out.println("Professor autualizado com sucesso!!!\n");

        } else {
            System.out.println("ID do professor infomado:" + id + "é inválido\n");
        }
    }

    public void visualizar() {
        Iterable<Professor> professores = this.professorRepository.findAll();

        for (Professor professor : professores) {
            System.out.println(professor);
        }
        System.out.println();

    }


    public void deletar(Scanner scanner) {
        System.out.println("Digite o id do professor a ser deletado");
        long id = scanner.nextLong();

        Optional<Professor> optional = this.professorRepository.findById(id);

        if (optional.isPresent()) {
            this.professorRepository.deleteById(id);
            System.out.println("professor deletado com sucesso !!\n");
            System.out.println();
        }
        else {
            System.out.println("o id a ser deletado não exite !!");
        }
    }
}