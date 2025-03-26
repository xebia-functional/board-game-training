package com.es.boardGameTraining.repository;

import com.es.boardGameTraining.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends  JpaRepository<Game, Long> {
}
