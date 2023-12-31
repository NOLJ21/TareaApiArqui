package com.ddg.catrina.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "words")
public class Word
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "part_of_speech_id", referencedColumnName = "id")
    private PartOfSpeech partOfSpeech;
}
