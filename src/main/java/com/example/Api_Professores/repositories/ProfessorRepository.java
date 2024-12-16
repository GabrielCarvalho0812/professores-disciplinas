package com.example.Api_Professores.repositories;


import com.example.Api_Professores.models.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long>{

}
