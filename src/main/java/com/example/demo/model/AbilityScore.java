package com.example.demo.model;

import javax.persistence.*;

@Entity
public class AbilityScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String stat;

    @Column
    private int score;

    @OneToOne(cascade = CascadeType.ALL)
    private CharRace race;


}
