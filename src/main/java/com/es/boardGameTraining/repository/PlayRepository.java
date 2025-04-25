package com.es.boardGameTraining.repository;

import com.es.boardGameTraining.model.Play;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayRepository extends JpaRepository<Play, Long> {
}
