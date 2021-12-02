package com.kolmakova.entities;

public class Passenger {

    private int id;
    private String name;
    private String surname;
    private String sex;
    private String birthDate;
    private String documentType;
    private String documentSeries;

    public Passenger() {
    }

    public Passenger(int id, String name, String surname, String sex, String dateOfBirth, String typeOfDocument, String seriesOfDocument) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.birthDate = dateOfBirth;
        this.documentType = typeOfDocument;
        this.documentSeries = seriesOfDocument;
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
                ", dateOfBirth='" + birthDate + '\'' +
                ", typeOfDocument='" + documentType + '\'' +
                ", seriesOfDocument='" + documentSeries + '\'' +
                '}';
    }
}
