package com.es.boardGameTraining.repository;

import com.es.boardGameTraining.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByNickname(String nickname);

    @Query("select p from Player p where p.name like %?1%")
    List<Player> findByNameContaining(String name);

    @Query("select p from Player p where p.nickname like %?1%")
    List<Player> findByNicknameContaining(String nickname);

}
