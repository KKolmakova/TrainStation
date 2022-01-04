package com.kolmakova.entities;

import com.kolmakova.types.WagonType;

import javax.persistence.*;

@Table(name = "Comfort")
@Entity
public class Comfort {

    @Id
    @Column(name = "id")
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type")
    private WagonType type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public WagonType getType() {
        return type;
    }

    public void setType(WagonType type) {
        this.type = type;
    }
}
