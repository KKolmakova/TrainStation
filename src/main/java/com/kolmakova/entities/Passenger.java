package com.kolmakova.entities;

import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Table(appliesTo = "Passenger")
@Entity
public class Passenger {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String surname;
    private String sex;
    @Column(name = "birth_date")
    private String birthDate;
    @Column(name = "document_type")
    private String documentType;
    @Column(name = "document_series")
    private String documentSeries;

    public Passenger() {
    }

    public Passenger(int id, String name, String surname, String sex, String birthDate, String documentType, String documentSeries) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.birthDate = birthDate;
        this.documentType = documentType;
        this.documentSeries = documentSeries;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public void setDocumentSeries(String documentSeries) {
        this.documentSeries = documentSeries;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getDocumentSeries() {
        return documentSeries;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", documentType='" + documentType + '\'' +
                ", documentSeries='" + documentSeries + '\'' +
                '}';
    }
}
