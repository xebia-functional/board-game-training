package com.es.boardGameTraining.repository;

import com.es.boardGameTraining.model.Game;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findByBggId(Long bggId);
    List<Game> findByTitleContainingIgnoreCase(String title);

    @Query("select g from Game g where g.title like %?1%")
    List<Game> findByTitleContaining(String title);

    @NativeQuery("SELECT * FROM games g WHERE EXISTS (SELECT 1 FROM unnest(g.authors) AS author WHERE author ILIKE %?1%)")
    List<Game> findByAuthorContaining(String author);

    @NativeQuery("SELECT * FROM games g WHERE EXISTS (SELECT 1 FROM unnest(g.artists) AS artist WHERE artist ILIKE %?1%)")
    List<Game> findByArtistContaining(String artist);
}
