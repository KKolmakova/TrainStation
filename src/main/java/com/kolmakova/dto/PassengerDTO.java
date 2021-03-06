package com.kolmakova.dto;

import java.sql.Date;
import java.util.List;

public class PassengerDTO {

    private int id;
    private String name;
    private String surname;
    private DocumentDTO documentDTO;
    private String documentSeries;
    private List<PaymentDTO> paymentDTOList;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public DocumentDTO getDocumentDTO() {
        return documentDTO;
    }

    public void setDocumentDTO(DocumentDTO documentDTO) {
        this.documentDTO = documentDTO;
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

    public DocumentDTO getDocumentType() {
        return documentDTO;
    }

    public String getDocumentSeries() {
        return documentSeries;
    }

    public List<PaymentDTO> getPaymentDTOList() {
        return paymentDTOList;
    }

    public void setPaymentDTOList(List<PaymentDTO> paymentDTOList) {
        this.paymentDTOList = paymentDTOList;
    }
}
