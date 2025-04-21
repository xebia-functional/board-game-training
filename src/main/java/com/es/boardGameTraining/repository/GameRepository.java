package com.es.boardGameTraining.repository;

import com.es.boardGameTraining.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends  JpaRepository<Game, Long> {
    Optional<Game> findByBggId(Long bggId);
}
