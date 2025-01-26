package com.example.Api_Professores.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Scanner;

@Entity
@Table(name = "Professores")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private long idade;



    @OneToMany(mappedBy = "professor",cascade = CascadeType.ALL)
    private List<Disciplina> disciplinas;


    public Professor(String nome) {
        this.nome = nome;
    }

    public Professor() {

    }


    public String getNome() {
        return nome;
    }

    public Scanner setNome(String nome) {
        this.nome = nome;
        return null;
    }

    public long getIdade() {
        return idade;
    }

    public void setIdade(long idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }


}