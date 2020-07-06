package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class CharClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String hitDice;

    @Column
    private String hitPoints;

    @Column
    private String armor;

    @Column
    private String weapon;

    @Column
    private String tool;

    @Column
    private String savingThrow;

    public CharClass() {
    }

    public long getId() {
        return id;
    }

    public String getHitDice() {
        return hitDice;
    }

    public String getHitPoints() {
        return hitPoints;
    }

    public String getArmor() {
        return armor;
    }

    public String getWeapon() {
        return weapon;
    }

    public String getTool() {
        return tool;
    }

    public String getSavingThrow() {
        return savingThrow;
    }

}
