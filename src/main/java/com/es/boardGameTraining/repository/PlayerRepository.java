package com.es.boardGameTraining.repository;

import com.es.boardGameTraining.model.Player;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByNickname(String nickname);
}
