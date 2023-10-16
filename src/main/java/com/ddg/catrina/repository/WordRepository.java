package com.ddg.catrina.repository;

import com.ddg.catrina.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WordRepository extends JpaRepository<Word, Long> {

    @Query("SELECT CASE WHEN COUNT(w) > 0 THEN true ELSE false END FROM Word w WHERE w.name = :word and w.status = true")
    boolean existsByName(String word);

    // puede arrojar varios resultados, solo se necesita el primero (get(0))
    @Query("SELECT w FROM Word w WHERE w.name = :word")
    Word findByName(String word);

    @Query("SELECT w FROM Word w WHERE w.id = :id")
    Word findById1(long id);

}
