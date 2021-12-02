package com.kolmakova.entities;

public class Passenger {

    private final int id;
    private final String name;
    private final String surname;
    private final String sex;
    private final String dateOfBirth;
    private final String typeOfDocument;
    private final String seriesOfDocument;

    public Passenger(int id, String name, String surname, String sex, String dateOfBirth, String typeOfDocument, String seriesOfDocument) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.typeOfDocument = typeOfDocument;
        this.seriesOfDocument = seriesOfDocument;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getTypeOfDocument() {
        return typeOfDocument;
    }

    public String getSeriesOfDocument() {
        return seriesOfDocument;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex='" + sex + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", typeOfDocument='" + typeOfDocument + '\'' +
                ", seriesOfDocument='" + seriesOfDocument + '\'' +
                '}';
    }
}
