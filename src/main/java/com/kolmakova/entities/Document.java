package com.kolmakova.entities;

import com.kolmakova.types.DocumentType;

import javax.persistence.*;

@Entity
@Table(name = "Document")
public class Document {

    @Id
    @Column(name = "id")
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type")
    private DocumentType type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
    }
}
