package com.ddg.catrina.model;

import jakarta.persistence.*;

@Entity
@Table(name = "words")
public class Word
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "origin_id")
    private Origin origin;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "example", length = 150)
    private String example;

    public Word(Long id, Origin origin, String name, String description, String example) {
        this.id = id;
        this.origin = origin;
        this.name = name;
        this.description = description;
        this.example = example;
    }

    public Word() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
