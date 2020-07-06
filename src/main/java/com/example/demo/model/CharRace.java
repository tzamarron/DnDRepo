package com.example.demo.model;

import javax.persistence.*;

@Entity
public class CharRace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String abilityScore;

    @Column
    private String speed;

    @Column
    private boolean darkvision;

    @Column
    private String alignment;

    @Column
    private String size;

    @Column
    private String languages;

    public CharRace() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbilityScore(String abilityScore) {
        this.abilityScore = abilityScore;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public void setDarkvision(boolean darkvision) {
        this.darkvision = darkvision;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }
}
