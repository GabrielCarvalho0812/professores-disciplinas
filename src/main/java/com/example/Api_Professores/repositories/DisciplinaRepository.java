package com.example.Api_Professores.repositories;

import com.example.Api_Professores.models.Disciplina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository  extends CrudRepository <Disciplina,Long> {
}
