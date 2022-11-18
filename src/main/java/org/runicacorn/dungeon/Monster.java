package org.runicacorn.dungeon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "monster")
public class Monster {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String strength;

    public String getName() {
        return name;
    }

    public String getStrength() {
        return strength;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public void setId(Long id) {
        this.id = id;
    }
}