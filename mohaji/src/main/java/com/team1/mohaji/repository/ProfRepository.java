package com.team1.mohaji.repository;

import com.team1.mohaji.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfRepository extends JpaRepository<Professor, Integer> {

    List<Professor> findByProfId(int profId);

}
