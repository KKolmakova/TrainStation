package com.kolmakova.entities;

import com.kolmakova.types.String;

import javax.persistence.*;

@Table(name = "Comfort")
@Entity
public class Comfort {

    @Id
    @Column(name = "id")
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type")
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
