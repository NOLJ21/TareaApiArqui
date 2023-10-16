package com.ddg.catrina.repository;

import com.ddg.catrina.model.PartOfSpeech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PartOfSpeechRepository extends JpaRepository<PartOfSpeech, Long> {
    @Query("SELECT p FROM PartOfSpeech p WHERE p.name = :partOfSpeech")
    PartOfSpeech findByName(String partOfSpeech);
}
