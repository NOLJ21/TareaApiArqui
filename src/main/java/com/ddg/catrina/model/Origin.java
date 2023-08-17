package com.ddg.catrina.model;

import jakarta.persistence.*;

@Entity
@Table(name = "origins")
public class Origin
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "origin_id")
    private Long id;

    @Column(name = "origin", length = 50)
    private String origin;
}
