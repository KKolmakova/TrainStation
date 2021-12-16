package com.kolmakova.dto;

import com.kolmakova.types.String;

public class ComfortDTO {

    private Integer id;
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

    @Override
    public java.lang.String toString() {
        return "ComfortDTO{" +
                "id=" + id +
                ", type=" + type +
                '}';
    }
}
