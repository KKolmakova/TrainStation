package com.kolmakova.entities;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "passenger_name")
    private String name;

    private String surname;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "document_type_id")
    private Document documentType;

    @Column(name = "document_series")
    private String documentSeries;

    @Where(clause = "mark_as_deleted = false")
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_id")
    private List<Payment> paymentList;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDocumentType(Document documentType) {
        this.documentType = documentType;
    }

    public void setDocumentSeries(String documentSeries) {
        this.documentSeries = documentSeries;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Document getDocumentType() {
        return documentType;
    }

    public String getDocumentSeries() {
        return documentSeries;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }
}
