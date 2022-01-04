package com.kolmakova.dto;

import com.kolmakova.types.WagonType;

public class ComfortDTO {

    private Integer id;
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

    @Override
    public java.lang.String toString() {
        return "ComfortDTO{" +
                "id=" + id +
                ", type=" + type +
                '}';
    }
}
