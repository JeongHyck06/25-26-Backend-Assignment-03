package com.gdg.jpaexample.repository;

import com.gdg.jpaexample.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
